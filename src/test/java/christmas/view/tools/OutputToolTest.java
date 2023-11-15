package christmas.view.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputToolTest {

    @DisplayName("인자로 들어온 price를 포맷에 맞추어 반환한다.")
    @Test
    void getFormattedPrice() {
        // Given
        OutputTool outputTool = new OutputTool();
        Integer price = 142000;

        // When
        String formattedPrice = outputTool.formatPrice(price);

        // Then
        Assertions.assertEquals("142,000원", formattedPrice);
    }
}