package christmas.domain.events;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftTest {

    @DisplayName("총주문 금액에 따라 증정 이벤트를 한다.")
    @Test
    void applyGiftEventTest() {
        // Given
        Integer withoutGift = 119999;
        Integer withGift = 120000;
        Gift gift = new Gift();

        // When
        Integer result1 = gift.applyGiftEvent(withoutGift);
        Integer result2 = gift.applyGiftEvent(withGift);

        // Then
        Assertions.assertEquals(0, result1);
        Assertions.assertEquals(25000, result2);
    }
}