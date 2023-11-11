package christmas.domain.events.discounts;

public class ChristmasDiscount {

    public Integer applyChristmasDiscount(Integer date) {
        int discountedAmount = 0;

        if (checkChristmasDiscount(date)) {
            discountedAmount = calculateChristmasDiscount(date);
        }
        return discountedAmount;
    }

    private boolean checkChristmasDiscount(Integer date) {
        if (1 <= date && date <= 25) {
            return true;
        }
        return false;
    }

    private int calculateChristmasDiscount(Integer date) {
        int initialDate = 1;
        int initialAmount = 1000;
        int daysPassed = date - initialDate;
        int discountAmount = initialAmount + (daysPassed * 100);

        return discountAmount;
    }
}
