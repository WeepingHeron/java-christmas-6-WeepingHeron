package christmas.domain.events;

public class Gift {

    private static final int GIFT_EVENT_THRESHOLD = 120000;
    private static final int GIFT_DISCOUNT_AMOUNT = 25000;

    public Integer applyGiftEvent(Integer addedPrice) {
        int discountedAmount = 0;

        if (checkGiftEvent(addedPrice)) {
            discountedAmount += GIFT_DISCOUNT_AMOUNT;
        }
        return discountedAmount;
    }

    private boolean checkGiftEvent(Integer addedPrice) {
        return addedPrice >= GIFT_EVENT_THRESHOLD;
    }
}
