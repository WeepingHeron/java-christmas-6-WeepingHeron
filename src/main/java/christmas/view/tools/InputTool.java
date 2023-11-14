package christmas.view.tools;

import java.util.HashMap;
import java.util.Map;

public class InputTool {

    private static final int MENU_AND_QUANTITY_MATCHED = 2;
    private static final int INDEX_OF_MENU = 0;
    private static final int INDEX_OF_QUANTITY = 1;

    public Map<String, Integer> parseOrder(String input) {
        Map<String, Integer> parsedOrder = new HashMap<>();

        String[] orders = input.split(",");
        for (String order : orders) {
            String[] menuAndQuantity = order.trim().split("-");
            putData(parsedOrder, menuAndQuantity);
        }
        return parsedOrder;
    }

    private Map<String, Integer> putData(Map<String, Integer> parsedOrder, String[] menuAndQuantity) {
        if (menuAndQuantity.length == MENU_AND_QUANTITY_MATCHED) {
            try {
                String menu = menuAndQuantity[INDEX_OF_MENU];
                int quantity = Integer.parseInt(menuAndQuantity[INDEX_OF_QUANTITY]);
                checkOrderWhileParsing(parsedOrder, menu);
                parsedOrder.put(menu, quantity);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 수량입니다. 다시 입력해 주세요.");
            }
        }
        return parsedOrder;
    }

    private void checkOrderWhileParsing(Map<String, Integer> order, String menu) {
        if (order.containsKey(menu)) {
            throw new IllegalArgumentException("[ERROR] 중복된 메뉴가 있습니다. 다시 입력해 주세요.");
        }
    }
}
