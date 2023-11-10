package christmas.domain.events.discounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDiscountTest {

    @DisplayName("날짜에 따른 크리스마스 디데이 할인을 계산한다.")
    @Test
    void applyChristmasDiscountTest() {
        // Given
        Integer date1 = 1;
        Integer date2 = 25;
        ChristmasDiscount christmasDiscount = new ChristmasDiscount();

        // When
        Integer result1 = christmasDiscount.applyChristmasDiscount(date1);
        Integer result2 = christmasDiscount.applyChristmasDiscount(date2);

        // Then
        Assertions.assertEquals(1000, result1);
        Assertions.assertEquals(3400, result2);
    }
}