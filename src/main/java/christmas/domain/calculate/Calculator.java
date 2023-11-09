package christmas.domain.calculate;

import christmas.domain.menu.MenuList;

import java.util.Map;

public class Calculator {
    public Integer addPrice(Map<String, Integer> order) {
        Integer addedPrice = 0;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menuName = entry.getKey();
            Integer quantity = entry.getValue();

            addedPrice += MenuList.getPriceByName(menuName) * quantity;
        }
        return addedPrice;
    }
}
