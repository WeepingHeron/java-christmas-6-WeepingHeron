package christmas.domain.events.discounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDiscountTest {

    @DisplayName("날짜에 따른 크리스마스 디데이 할인을 계산한다.")
    @Test
    void applyChristmasDiscountTest() {
        // Given
        Integer minDiscountDate = 1;
        Integer maxDiscountDate = 25;
        Integer noDiscountDate = 26;
        ChristmasDiscount christmasDiscount = new ChristmasDiscount();

        // When
        Integer minDiscount = christmasDiscount.applyChristmasDiscount(minDiscountDate);
        Integer maxDiscount = christmasDiscount.applyChristmasDiscount(maxDiscountDate);
        Integer noDiscount = christmasDiscount.applyChristmasDiscount(noDiscountDate);

        // Then
        Assertions.assertEquals(1000, minDiscount);
        Assertions.assertEquals(3400, maxDiscount);
        Assertions.assertEquals(0, noDiscount);
    }
}