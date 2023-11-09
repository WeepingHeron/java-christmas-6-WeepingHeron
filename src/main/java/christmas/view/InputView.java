package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class InputView {

    public int readDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public Map<String, Integer> readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();

        return parseOrderInput(input);
    }

    private Map<String, Integer> parseOrderInput(String input) {
        Map<String, Integer> orderMap = new HashMap<>();

        String[] orders = input.split(",");
        for (String order : orders) {
            String[] menuAndQuantity = order.trim().split("-");
            if (menuAndQuantity.length == 2) {
                String menu = menuAndQuantity[0];
                int quantity = Integer.parseInt(menuAndQuantity[1]);
                orderMap.put(menu, quantity);
            }
        }

        return orderMap;
    }
}
