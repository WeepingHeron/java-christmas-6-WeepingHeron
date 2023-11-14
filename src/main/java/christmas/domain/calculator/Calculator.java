package christmas.domain.calculator;

import christmas.domain.enums.Calendar;
import christmas.domain.enums.MenuList;
import christmas.domain.events.Gift;
import christmas.domain.events.discounts.ChristmasDiscount;
import christmas.domain.events.discounts.DayOfTheWeekDiscount;
import christmas.domain.events.discounts.HolidayDiscount;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static final int EVENT_THRESHOLD = 10000;

    Gift gift = new Gift();
    ChristmasDiscount christmasDiscount = new ChristmasDiscount();
    DayOfTheWeekDiscount dayOfTheWeekDiscount = new DayOfTheWeekDiscount();
    HolidayDiscount holidayDiscount = new HolidayDiscount();

    public Integer calculateAddedPrice(Map<String, Integer> order) {
        Integer addedPrice = 0;

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menuName = entry.getKey();
            Integer quantity = entry.getValue();

            addedPrice += MenuList.getPriceByName(menuName) * quantity;
        }

        return addedPrice;
    }

    public Integer calculateBenefit(Integer date, Integer addedPrice, Map<String, Integer> order) {
        Integer benefit = 0;

        if (addedPrice >= EVENT_THRESHOLD) {
            benefit
                    += christmasDiscount.applyChristmasDiscount(date)
                    + gift.applyGiftEvent(addedPrice)
                    + dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(date, order)
                    + holidayDiscount.applyHolidayDiscount(date);
        }

        return benefit;
    }

    public Map<String, Integer> calculateAppliedEvents(Integer date, Integer addedPrice, Map<String, Integer> order) {
        Map<String, Integer> appliedEvents = new HashMap<>();

        if (addedPrice >= EVENT_THRESHOLD) {
            checkEvents(appliedEvents, date, addedPrice, order);
        }

        return appliedEvents;
    }

    private void checkEvents(Map<String, Integer> appliedEvents, Integer date, Integer addedPrice, Map<String, Integer> order) {
        if (christmasDiscount.applyChristmasDiscount(date) > 0) {
            appliedEvents.put("크리스마스 디데이 할인", christmasDiscount.applyChristmasDiscount(date));
        }
        if (gift.applyGiftEvent(addedPrice) > 0) {
            appliedEvents.put("증정 이벤트", gift.applyGiftEvent(addedPrice));
        }
        if (dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(date, order) > 0) {
            checkDayOfTheWeekEvent(appliedEvents, date, order);
        }
        if (holidayDiscount.applyHolidayDiscount(date) > 0) {
            appliedEvents.put("특별 할인", holidayDiscount.applyHolidayDiscount(date));
        }
    }

    private void checkDayOfTheWeekEvent(Map<String, Integer> appliedEvents, Integer date, Map<String, Integer> order) {
        if (Calendar.values()[date - 1].isWeekend()) {
            appliedEvents.put("주말 할인", dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(date, order));
        } else if (!Calendar.values()[date - 1].isWeekend()) {
            appliedEvents.put("평일 할인", dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(date, order));
        }
    }
}
