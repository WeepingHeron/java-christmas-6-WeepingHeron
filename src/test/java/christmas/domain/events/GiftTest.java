package christmas.domain.events;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftTest {

    @DisplayName("총주문 금액에 따라 증정 이벤트를 한다.")
    @Test
    void applyGiftEventTest() {
        // Given
        Integer invalidPrice = 119999;
        Integer validPrice = 120000;
        Gift gift = new Gift();

        // Then
        Integer result1 = gift.applyGiftEvent(invalidPrice);
        Integer result2 = gift.applyGiftEvent(validPrice);

        // Then
        Assertions.assertEquals(0, result1);
        Assertions.assertEquals(25000, result2);
    }
}