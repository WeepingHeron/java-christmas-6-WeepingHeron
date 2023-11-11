package christmas.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceFormatterUtilTest {

    @DisplayName("인자로 들어온 price를 포맷에 맞추어 반환한다.")
    @Test
    void getFormattedPrice() {
        // Given
        Integer price = 142000;

        // When
        PriceFormatterUtil util = new PriceFormatterUtil();
        String formattedPrice = util.getFormattedPrice(price);

        // Then
        Assertions.assertEquals("142,000원", formattedPrice);
    }
}