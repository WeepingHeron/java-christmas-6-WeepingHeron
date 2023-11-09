package christmas.domain.calculate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("Map 형태의 주문을 받아 MenuList를 순회하며 정가 합산")
    @Test
    void calculateListPriceTest() {
        // Given
        Map<String, Integer> testOrder = new HashMap<>();
        testOrder.put("티본스테이크", 1);
        testOrder.put("바비큐립", 1);
        testOrder.put("초코케이크", 2);
        testOrder.put("제로콜라", 1);

        // When
        Calculator calculator = new Calculator();
        Integer result = calculator.calculateListPrice(testOrder);

        // Then
        Assertions.assertEquals(142000, result);
    }
}