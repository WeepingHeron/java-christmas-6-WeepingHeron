package christmas.domain.calculate;

import christmas.domain.menu.MenuList;

import java.util.Map;

public class Calculator {
    public Integer calculateListPrice(Map<String, Integer> order) {
        Integer calculatedListPrice = 0;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menuName = entry.getKey();
            Integer quantity = entry.getValue();

            calculatedListPrice += MenuList.getPriceByName(menuName) * quantity;
        }
        return calculatedListPrice;
    }
}
