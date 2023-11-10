package christmas.domain.events;

public class Gift {

    public Integer applyGiftEvent(Integer addedPrice) {

        int discountedAmount = 0;
        if (checkGiftEvent(addedPrice)) {
            discountedAmount += 25000;
        }
        return discountedAmount;
    }

    private boolean checkGiftEvent(Integer addedPrice) {
        if (addedPrice >= 120000) {
            return true;
        }
        return false;
    }
}
