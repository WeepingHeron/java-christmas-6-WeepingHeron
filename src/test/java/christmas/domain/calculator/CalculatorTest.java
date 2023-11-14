package christmas.domain.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CalculatorTest {

    Calculator calculator = new Calculator();

    private Integer date;
    private Map<String, Integer> order;

    @BeforeEach
    void setUp() {
        date = 3;
        order = new HashMap<>();
        order.put("티본스테이크",1);
        order.put("바비큐립",1);
        order.put("초코케이크",2);
        order.put("제로콜라",1);
    }

    @DisplayName("주문을 받아 총주문 금액 산출")
    @Test
    void calculateAddedPriceTest() {
        // Given

        // When
        Calculator calculator = new Calculator();
        Integer result = calculator.calculateAddedPrice(order);

        // Then
        Assertions.assertEquals(142000, result);
    }

    @DisplayName("날짜, 총주문 금액, 주문을 받아 총혜택 금액 산출")
    @Test
    void calculateBenefitTest() {
        // Given
        Integer addedPrice = calculator.calculateAddedPrice(order);

        // When
        Integer benefit = calculator.calculateBenefit(date, addedPrice, order);

        // Then
        Assertions.assertEquals(31246, benefit);
    }

    @DisplayName("날짜, 총주문 금액, 주문을 받아 적용된 이벤트 산출")
    @Test
    void calculateAppliedEventsTest() {
        // Given
        Integer addedPrice = calculator.calculateAddedPrice(order);
        Map<String, Integer> expectedEvents = new HashMap<>();
        expectedEvents.put("크리스마스 디데이 할인", 1200);
        expectedEvents.put("증정 이벤트", 25000);
        expectedEvents.put("평일 할인", 4046);
        expectedEvents.put("특별 할인", 1000);

        // When
        Map<String, Integer> appliedEvents = calculator.calculateAppliedEvents(date, addedPrice, order);

        // Then
        Assertions.assertEquals(expectedEvents, appliedEvents);
    }
}