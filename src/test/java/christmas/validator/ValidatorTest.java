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
        order.put("존재하지 않는 메뉴", 1);

        // When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(order));
    }

    @DisplayName("메뉴 수량의 유효성을 검증한다.")
    @Test
    void checkMenuQuantityTest() {
        // Given
        order.put("레드와인", 0);

        // When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(order));
    }

    @DisplayName("전체 수량의 유효성을 검증한다.")
    @Test
    void checkTotalQuantityTest() {
        // Given
        Map<String, Integer> emptyOrder = new HashMap<>();
        order.put("레드와인", 16);

        // When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(emptyOrder));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(order));
    }

    @DisplayName("음료만 주문할 경우 주문이 불가하도록 한다.")
    @Test
    void isNotOnlyBeverageTest() {
        // Given
        Map<String, Integer> onlyBeverage = new HashMap<>();
        onlyBeverage.put("제로콜라", 1);
        onlyBeverage.put("레드와인", 2);

        // When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidOrder(onlyBeverage));
        Assertions.assertDoesNotThrow(() -> validator.isValidOrder(order));
    }

    @DisplayName("Map에 새로운 데이터를 추가할 때 겹치는 key가 있는지 확인한다.")
    @Test
    void checkOrderWhileParsingTest() {
        // Given
        String existentMenu = "제로콜라";
        String nonexistentMenu = "레드와인";

        // When & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.checkOrderWhileParsing(order, existentMenu));
        Assertions.assertDoesNotThrow(() -> validator.checkOrderWhileParsing(order, nonexistentMenu));

    }
}