package christmas.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class ValidatorTest {

    private Validator validator;
    private Map<String, Integer> order;

    @BeforeEach
    void setUp() {
        validator = new Validator();
        order = new HashMap<>();

        order.put("티본스테이크",1);
        order.put("바비큐립",1);
        order.put("초코케이크",2);
        order.put("제로콜라",1);
    }

    @DisplayName("방문 날짜 입력의 유효성을 검증한다.")
    @Test
    void isValidDateTest() {
        // Given
        Integer validDate1 = 1;
        Integer validDate2 = 15;
        Integer validDate3 = 31;

        Integer invalidDate1 = 0;
        Integer invalidDate2 = 32;

        // When & Then
        Assertions.assertDoesNotThrow(() -> validator.isValidDate(validDate1));
        Assertions.assertDoesNotThrow(() -> validator.isValidDate(validDate2));
        Assertions.assertDoesNotThrow(() -> validator.isValidDate(validDate3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidDate(invalidDate1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidDate(invalidDate2));
    }

    @DisplayName("존재하지 않는 메뉴가 있는지 확인한다.")
    @Test
    void checkMenuNameTest() {
        // Given
        Assertions.assertDoesNotThrow(() -> validator.isValidOrder(order));

        // When
        order.put("존재하지 않는 메뉴", 1);

        // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(order));
    }

    @DisplayName("메뉴 수량의 유효성을 검증한다.")
    @Test
    void checkMenuQuantityTest() {
        // Given
        Assertions.assertDoesNotThrow(() -> validator.isValidOrder(order));

        // When
        order.put("레드와인", 0);

        // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(order));
    }

    @DisplayName("전체 수량의 유효성을 검증한다.")
    @Test
    void checkTotalQuantityTest() {
        // Given
        Assertions.assertDoesNotThrow(() -> validator.isValidOrder(order));
        Map<String, Integer> validOrder = new HashMap<>();
        Map<String, Integer> inValidOrder = new HashMap<>();
        Map<String, Integer> emptyOrder = new HashMap<>();

        // When
        order.put("레드와인", 16);
        validOrder.put("해산물파스타", 20);
        inValidOrder.put("해산물파스타", 21);

        // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(order));
        Assertions.assertDoesNotThrow(() -> validator.isValidOrder(validOrder));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(inValidOrder));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(emptyOrder));
    }

    @DisplayName("음료만 주문할 경우 주문이 불가하도록 한다.")
    @Test
    void isNotOnlyBeverageTest() {
        // Given
        Assertions.assertDoesNotThrow(() -> validator.isValidOrder(order));
        Map<String, Integer> onlyBeverage = new HashMap<>();

        // When
        onlyBeverage.put("제로콜라", 1);
        onlyBeverage.put("레드와인", 2);

        // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(onlyBeverage));
    }
}