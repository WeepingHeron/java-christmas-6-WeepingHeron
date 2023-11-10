package christmas.domain.events.discounts;

import christmas.domain.events.Calendar;
import christmas.domain.menu.MenuList;

import java.util.Map;

public class DayOfTheWeekDiscount {

    public Integer applyDayOfTheWeekDiscount(Map<String, Integer> order, Integer date) {
        int discountedAmount = 0;

        if (Calendar.values()[date - 1].isWeekend()) {
            return discountedAmount += calculateDayOfTheWeekDiscount(order, "메인");
        }

        return discountedAmount += calculateDayOfTheWeekDiscount(order, "디저트");
    }

    public Integer calculateDayOfTheWeekDiscount(Map<String, Integer> order, String menuGroup) {
        int discountedAmount = 0;

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menuName = entry.getKey();
            Integer quantity = entry.getValue();

            if (MenuList.getGroupByName(menuName, menuGroup)) {
                discountedAmount += 2023 * quantity;
            }
        }

        return discountedAmount;
    }
}
