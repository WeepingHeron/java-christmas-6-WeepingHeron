package christmas.view.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class InputToolTest {

    private InputTool inputTool;
    private Map<String, Integer> order;

    @BeforeEach
    void setUp() {
        inputTool = new InputTool();
        order = new HashMap<>();

        order.put("티본스테이크",1);
        order.put("바비큐립",1);
        order.put("초코케이크",2);
        order.put("제로콜라",1);
    }

    @DisplayName("인자로 들어온 입력을 Map 형태로 반환한다.")
    @Test
    void parseOrderTest() {
        // Given
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        // When
        Map<String, Integer> result = inputTool.parseOrder(input);

        // Then
        Assertions.assertEquals(order, result);
    }

    @DisplayName("입력에 중복된 메뉴가 있는 경우를 체크한다.")
    @Test
    void checkOrderWhileParsingTest() {
        // Given
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1,티본스테이크-2";

        // When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputTool.parseOrder(input));
    }
}