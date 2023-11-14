package christmas.view;

import christmas.view.util.PriceFormatterUtil;

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
        System.out.println();
    }

    public void printGift(Map<String, Integer> appliedEvents) {
        System.out.println("<증정 메뉴>");

        if (appliedEvents.containsKey("증정 이벤트")) {
            System.out.println("샴페인 1개");
        } else if (!appliedEvents.containsKey("증정 이벤트")) {
            System.out.println("없음");
        }
        System.out.println();
    }

    public void printAppliedEvents(Map<String, Integer> appliedEvents) {
        System.out.println("<혜택 내역>");

        for (Map.Entry<String, Integer> entry : appliedEvents.entrySet()) {
            String appliedEvent = entry.getKey();
            Integer discountedAmount = entry.getValue();

            System.out.print(appliedEvent + ": -");
            System.out.println(format.getFormattedPrice(discountedAmount));
        }
        if (appliedEvents.isEmpty()) {
            System.out.println("없음");
        }
        System.out.println();
    }

    public void printBenefit(Integer discountedAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + format.getFormattedPrice(discountedAmount));
        System.out.println();
    }

    public void printFinalPrice(Integer addedPrice, Integer discountedAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        if (addedPrice >= 120000) {
            System.out.println(format.getFormattedPrice(addedPrice - discountedAmount + 25000));
        } else if (addedPrice < 120000) {
            System.out.println(format.getFormattedPrice(addedPrice - discountedAmount));
        }
        System.out.println();
    }

    public void printBadge(Integer discountedAmount) {
        System.out.println("<12월 이벤트 배지>");
        if (discountedAmount >= 20000) {
            System.out.println("산타");
        } else if (discountedAmount >= 10000) {
            System.out.println("트리");
        } else if (discountedAmount >= 5000) {
            System.out.println("별");
        } else if (discountedAmount >= 0) {
            System.out.println("없음");
        }
    }
}
