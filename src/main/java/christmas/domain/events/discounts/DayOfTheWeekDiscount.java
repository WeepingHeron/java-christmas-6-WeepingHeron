package christmas.domain.events.discounts;

import christmas.domain.enums.Calendar;
import christmas.domain.enums.MenuList;

import java.util.Map;

public class DayOfTheWeekDiscount {

    private static final int NO_DISCOUNT_APPLIED = 0;
    private static final int DISCOUNT_PER_ITEM = 2023;

    public Integer applyDayOfTheWeekDiscount(Integer date, Map<String, Integer> order) {

        if (Calendar.isWeekend(date)) {
            return calculateDayOfTheWeekDiscount(order, "메인");
        }

        return calculateDayOfTheWeekDiscount(order, "디저트");
    }

    private Integer calculateDayOfTheWeekDiscount(Map<String, Integer> order, String menuGroup) {
        int discountedAmount = NO_DISCOUNT_APPLIED;

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menuName = entry.getKey();
            Integer quantity = entry.getValue();

            if (MenuList.isExistentMatchOfNameAndGroup(menuName, menuGroup)) {
                discountedAmount += DISCOUNT_PER_ITEM * quantity;
            }
        }

        return discountedAmount;
    }
}
