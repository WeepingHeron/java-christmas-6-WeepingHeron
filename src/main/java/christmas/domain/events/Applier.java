package christmas.domain.events;

import christmas.domain.PromotionModel;
import christmas.domain.events.discounts.ChristmasDiscount;
import christmas.domain.events.discounts.DayOfTheWeekDiscount;
import christmas.domain.events.discounts.HolidayDiscount;

import java.util.Map;

public class Applier {

    Gift gift = new Gift();
    ChristmasDiscount christmasDiscount = new ChristmasDiscount();
    DayOfTheWeekDiscount dayOfTheWeekDiscount = new DayOfTheWeekDiscount();
    HolidayDiscount holidayDiscount = new HolidayDiscount();

    public void applyDiscounts(PromotionModel model, Integer addedPrice, Integer date, Map<String, Integer> order) {
        Integer discountedAmount = 0;
        discountedAmount
                += christmasDiscount.applyChristmasDiscount(date)
                + gift.applyGiftEvent(addedPrice)
                + dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(order, date)
                + holidayDiscount.applyHolidayDiscount(date);

        model.setDiscountedAmount(discountedAmount);
    }

    public void applyEvents(PromotionModel model, Integer addedPrice, Integer date, Map<String, Integer> order) {
        if (christmasDiscount.applyChristmasDiscount(date) > 0) {
            model.setAppliedEvents("크리스마스 디데이 할인", christmasDiscount.applyChristmasDiscount(date));
        }
        if (gift.applyGiftEvent(addedPrice) > 0) {
            model.setAppliedEvents("증정 이벤트", 25000);
        }
        if (dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(order, date) > 0) {
            applyDayOfTheWeekEvent(model, date, order);
        }
        if (holidayDiscount.applyHolidayDiscount(date) > 0) {
            model.setAppliedEvents("특별 할인", 1000);
        }
    }

    private void applyDayOfTheWeekEvent(PromotionModel model, Integer date, Map<String, Integer> order) {
        if (Calendar.values()[date - 1].isWeekend()) {
            model.setAppliedEvents("주말 할인", dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(order, date));
        } else if (!Calendar.values()[date - 1].isWeekend()) {
            model.setAppliedEvents("평일 할인", dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(order, date));
        }
    }
}
