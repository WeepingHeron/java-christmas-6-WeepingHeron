package christmas.domain.events.discounts;

import christmas.domain.enums.Calendar;
import christmas.domain.enums.MenuList;

import java.util.Map;

public class DayOfTheWeekDiscount {

    public Integer applyDayOfTheWeekDiscount(Integer date, Map<String, Integer> order) {
        int discountedAmount = 0;

        if (Calendar.values()[date - 1].isWeekend()) {
            return discountedAmount += calculateDayOfTheWeekDiscount(order, "메인");
        }

        return discountedAmount += calculateDayOfTheWeekDiscount(order, "디저트");
    }

    private Integer calculateDayOfTheWeekDiscount(Map<String, Integer> order, String menuGroup) {
        int discountedAmount = 0;

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menuName = entry.getKey();
            Integer quantity = entry.getValue();

            if (MenuList.isExistentNameAndGroup(menuName, menuGroup)) {
                discountedAmount += 2023 * quantity;
            }
        }

        return discountedAmount;
    }
}
