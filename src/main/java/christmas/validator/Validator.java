package christmas.validator;

import christmas.domain.menu.MenuList;

import java.util.Map;

public class Validator {

    public boolean isValidDate (Integer date) {
        if (date < 1 || 31 < date) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return true;
    }

    public boolean isValidOrder(Map<String, Integer> order) {
        if (isValidMenuNameAndQuantity(order) == true && isNotOnlyBeverage(order) == true) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private boolean isValidMenuNameAndQuantity(Map<String, Integer> order) {
        int totalQuantity = 0;

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menu = entry.getKey();
            int quantity = entry.getValue();

            checkMenuName(menu);
            checkMenuQuantity(quantity);
            totalQuantity += quantity;
        }
        checkTotalQuantity(totalQuantity);

        return true;
    }

    private void checkMenuName(String menu) {
        if (!MenuList.isValidName(menu)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴가 있습니다.");
        }
    }

    private void checkMenuQuantity(Integer quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 1개 이상부터 주문 가능합니다.");
        }
    }

    private void checkTotalQuantity(Integer totalQuantity) {
        if (totalQuantity <= 0) {
            throw new IllegalArgumentException("[ERROR] 메뉴를 주문해 주세요.");
        }
        if (totalQuantity > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    private boolean isNotOnlyBeverage(Map<String, Integer> order) {

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menu = entry.getKey();
            if (!MenuList.getGroupByName(menu).equals("음료")) {
                return true;
            }
        }

        throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
    }

    public void checkOrderWhileParsing(Map<String, Integer> order, String menu) {
        if (order.containsKey(menu)) {
            throw new IllegalArgumentException("[ERROR] 중복된 메뉴가 있습니다. 다시 입력해 주세요.");
        }
    }
}
