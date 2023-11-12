package christmas.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class ParseOrderUtilTest {

    @DisplayName("인자로 들어온 입력을 Map 형태로 반환한다.")
    @Test
    void parseOrder() {
        // Given
        ParseOrderUtil util = new ParseOrderUtil();
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("티본스테이크", 1);
        expectedResult.put("바비큐립", 1);
        expectedResult.put("초코케이크", 2);
        expectedResult.put("제로콜라", 1);

        // When
        Map<String, Integer> result = util.parseOrder(input);

        // Then
        Assertions.assertEquals(expectedResult, result);
    }
}