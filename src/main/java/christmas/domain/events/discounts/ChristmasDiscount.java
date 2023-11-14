package christmas.domain.events.discounts;

public class ChristmasDiscount {

    private static final int INITIAL_DATE = 1;
    private static final int LAST_DATE = 25;
    private static final int INITIAL_AMOUNT = 1000;
    private static final int DISCOUNT_PER_DAY = 100;

    public Integer applyChristmasDiscount(Integer date) {
        int discountedAmount = 0;

        if (checkChristmasDiscount(date)) {
            discountedAmount = calculateChristmasDiscount(date);
        }
        return discountedAmount;
    }

    private boolean checkChristmasDiscount(Integer date) {
        return INITIAL_DATE <= date && date <= LAST_DATE;
    }

    private int calculateChristmasDiscount(Integer date) {
        int daysPassed = date - INITIAL_DATE;
        return calculateDiscountAmount(daysPassed);
    }

    private int calculateDiscountAmount(int daysPassed) {
        return INITIAL_AMOUNT + (daysPassed * DISCOUNT_PER_DAY);
    }
}
