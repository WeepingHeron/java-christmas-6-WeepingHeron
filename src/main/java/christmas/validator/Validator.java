package christmas.validator;

import christmas.domain.enums.MenuList;

import java.util.Map;

public class Validator {

    private static final Integer INITIAL_DATE_OF_DECEMBER = 1;
    private static final Integer LAST_DATE_OF_DECEMBER = 31;
    private static final Integer INITIAL_TOTAL_QUANTITY = 0;
    private static final Integer MIN_MENU_QUANTITY = 1;
    private static final Integer MIN_TOTAL_QUANTITY = 1;
    private static final Integer MAX_TOTAL_QUANTITY = 20;

    public boolean isValidDate (Integer date) {
        if (date < INITIAL_DATE_OF_DECEMBER || LAST_DATE_OF_DECEMBER < date) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return true;
    }

    public boolean isValidOrder(Map<String, Integer> order) {
        if (isValidMenuNameAndQuantity(order) && isNotOnlyBeverage(order)) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private boolean isValidMenuNameAndQuantity(Map<String, Integer> order) {
        int totalQuantity = INITIAL_TOTAL_QUANTITY;

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
        if (!MenuList.isExistentName(menu)) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴가 있습니다.");
        }
    }

    private void checkMenuQuantity(Integer quantity) {
        if (quantity < MIN_MENU_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 1개 이상부터 주문 가능합니다.");
        }
    }

    private void checkTotalQuantity(Integer totalQuantity) {
        if (totalQuantity < MIN_TOTAL_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] 메뉴를 주문해 주세요.");
        }
        if (totalQuantity > MAX_TOTAL_QUANTITY) {
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
}
