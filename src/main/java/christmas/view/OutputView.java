package christmas.view;

import christmas.view.tools.OutputTool;

import java.util.Map;

public class OutputView {

    private static final int GIFT_EVENT_THRESHOLD = 120000;
    private static final int GIFT_DISCOUNT_AMOUNT = 25000;
    private static final int SANTA_BADGE_THRESHOLD = 20000;
    private static final int TREE_BADGE_THRESHOLD = 10000;
    private static final int STAR_BADGE_THRESHOLD = 5000;

    OutputTool outputTool = new OutputTool();

    public void printAll(
            Integer date,
            Map<String, Integer> order,
            Integer addedPrice,
            Map<String, Integer> appliedEvents,
            Integer benefit) {
        printDate(date);
        printMenu(order);
        printAddedPrice(addedPrice);
        printGift(appliedEvents);
        printAppliedEvents(appliedEvents);
        printBenefit(benefit);
        printFinalPrice(addedPrice, benefit);
        printBadge(benefit);
    }

    private void printDate(Integer date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    private void printMenu(Map<String, Integer> order) {
        System.out.println("<주문 메뉴>");

        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String menu = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(menu + " " + quantity + "개");
        }
        System.out.println();
    }

    private void printAddedPrice(Integer addedPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(outputTool.formatPrice(addedPrice));
        System.out.println();
    }

    private void printGift(Map<String, Integer> appliedEvents) {
        System.out.println("<증정 메뉴>");

        if (appliedEvents.containsKey("증정 이벤트")) {
            System.out.println("샴페인 1개");
        }
        if (!appliedEvents.containsKey("증정 이벤트")) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printAppliedEvents(Map<String, Integer> appliedEvents) {
        System.out.println("<혜택 내역>");

        for (Map.Entry<String, Integer> entry : appliedEvents.entrySet()) {
            String appliedEvent = entry.getKey();
            Integer discountedAmount = entry.getValue();

            System.out.print(appliedEvent + ": -");
            System.out.println(outputTool.formatPrice(discountedAmount));
        }
        if (appliedEvents.isEmpty()) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printBenefit(Integer benefit) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + outputTool.formatPrice(benefit));
        System.out.println();
    }

    private void printFinalPrice(Integer addedPrice, Integer benefit) {
        System.out.println("<할인 후 예상 결제 금액>");
        if (addedPrice >= GIFT_EVENT_THRESHOLD) {
            System.out.println(outputTool.formatPrice(addedPrice - benefit + GIFT_DISCOUNT_AMOUNT));
        }
        if (addedPrice < GIFT_EVENT_THRESHOLD) {
            System.out.println(outputTool.formatPrice(addedPrice - benefit));
        }
        System.out.println();
    }

    private void printBadge(Integer benefit) {
        System.out.println("<12월 이벤트 배지>");
        if (benefit >= SANTA_BADGE_THRESHOLD) {
            System.out.println("산타");
        } else if (benefit >= TREE_BADGE_THRESHOLD) {
            System.out.println("트리");
        } else if (benefit >= STAR_BADGE_THRESHOLD) {
            System.out.println("별");
        } else if (benefit >= 0) {
            System.out.println("없음");
        }
    }
}
