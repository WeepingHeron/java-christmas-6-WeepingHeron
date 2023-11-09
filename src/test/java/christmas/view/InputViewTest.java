package christmas.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView = new InputView();

    @DisplayName("사용자의 방문 날짜를 입력받는다.")
    @Test
    void readDateTest() {
        // Given
        String testInput = "27";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        // When
        int result = inputView.readDate();

        // Then
        Assertions.assertEquals(27, result);
    }

    @DisplayName("사용자의 주문을 입력받고, Map 형태로 반환한다.")
    @Test
    void readOrderTest() {
        // Given
        String testInput = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);

        // When
        Map<String, Integer> result = inputView.readOrder();

        // Then
        System.out.println(result);
    }
}