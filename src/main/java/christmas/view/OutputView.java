package christmas.view;

import christmas.util.PriceFormatterUtil;

import java.util.Map;

public class OutputView {

    PriceFormatterUtil format = new PriceFormatterUtil();

    public void printDate(Integer date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void printMenu(Map<String, Integer> order) {
        System.out.println("<주문 메뉴>");

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menu = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(menu + " " + quantity + "개");
        }
        System.out.println();
    }

    public void printAddedPrice(Integer addedPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(format.getFormattedPrice(addedPrice));
    }
}
