package christmas.view;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {

    public void printMenu(Map<String, Integer> order) {
        System.out.println("<주문 메뉴>");

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menu = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(menu + " " + quantity + "개");
        }
    }

    public void printListPrice(Integer calculatedListPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(getFormattedPrice(calculatedListPrice));
    }

    private String getFormattedPrice(Integer calculatedListPrice) {
        DecimalFormat formatter = new DecimalFormat("###,###원");
        return formatter.format(calculatedListPrice);
    }
}
