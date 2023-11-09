package christmas.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class OutputViewTest {
    private OutputView outputView;

    @BeforeEach
    void setup() {
        outputView = new OutputView();
    }

    @DisplayName("Map 형태로 받은 주문을 출력한다.")
    @Test
    void printMenuTest() {
        // Given
        Map<String, Integer> order = new LinkedHashMap<>();
        order.put("티본스테이크", 1);
        order.put("바비큐립", 1);
        order.put("초코케이크", 2);
        order.put("제로콜라", 1);

        // When & Then
        outputView.printMenu(order);
    }

    @DisplayName("할인 전 총주문 금액을 출력한다.")
    @Test
    void printListPriceTest() {
        // Given
        Integer testPrice = 142000;

        // When & Then
        outputView.printListPrice(testPrice);
    }
}