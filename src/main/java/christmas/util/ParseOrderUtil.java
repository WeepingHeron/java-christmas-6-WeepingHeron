package christmas.util;

import christmas.validator.Validator;

import java.util.HashMap;
import java.util.Map;

public class ParseOrderUtil {

    Validator validator = new Validator();

    public Map<String, Integer> parseOrder(String input) {
        Map<String, Integer> parsedOrder = new HashMap<>();

        String[] orders = input.split(",");
        for (String order : orders) {
            String[] menuAndQuantity = order.trim().split("-");
            putData(parsedOrder, menuAndQuantity);
        }
        return parsedOrder;
    }

    private Map<String, Integer> putData(Map<String, Integer> destination, String[] source) {
        if (source.length == 2) {
            try {
                String menu = source[0];
                int quantity = Integer.parseInt(source[1]);
                validator.checkOrderWhileParsing(destination, menu);
                destination.put(menu, quantity);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 수량입니다. 다시 입력해 주세요.");
            }
        }
        return destination;
    }
}
