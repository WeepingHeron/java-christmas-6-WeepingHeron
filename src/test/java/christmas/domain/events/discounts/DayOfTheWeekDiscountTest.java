package christmas.domain.events.discounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class DayOfTheWeekDiscountTest {

    private Map<String, Integer> order = new LinkedHashMap<>();
    DayOfTheWeekDiscount dayOfTheWeekDiscount = new DayOfTheWeekDiscount();

    @BeforeEach
    void setup() {
        order.put("티본스테이크", 1);
        order.put("초코케이크", 2);
        order.put("제로콜라", 1);
    }

    @DisplayName("인자로 들어온 날짜에 따라 평일/주말 할인을 받는다.")
    @Test
    void applyDayOfTheWeekDiscountTest() {
        // Given
        Integer weekend = 2;
        Integer weekday = 3;

        // When
        Integer result1 = dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(order, weekend);
        Integer result2 = dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(order, weekday);

        // Then
        Assertions.assertEquals(2023, result1);
        Assertions.assertEquals(4046, result2);
    }

    @DisplayName("인자로 들어온 group명에 따라 할인을 진행한다.")
    @Test
    void calculateDayOfTheWeekDiscountTest() {
        // Given
        String group1 = "메인";
        String group2 = "디저트";

        // When
        Integer result1 = dayOfTheWeekDiscount.calculateDayOfTheWeekDiscount(order, group1);
        Integer result2 = dayOfTheWeekDiscount.calculateDayOfTheWeekDiscount(order, group2);

        // Then
        Assertions.assertEquals(2023, result1);
        Assertions.assertEquals(4046, result2);
    }
}