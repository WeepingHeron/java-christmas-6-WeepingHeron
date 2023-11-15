package christmas.domain.events.discounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class DayOfTheWeekDiscountTest {

    private final Map<String, Integer> order = new LinkedHashMap<>();
    DayOfTheWeekDiscount dayOfTheWeekDiscount = new DayOfTheWeekDiscount();

    @BeforeEach
    void setUp() {
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
        Integer oneTBoneSteakDiscount = dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(weekend, order);
        Integer twoChocoCakesDiscount = dayOfTheWeekDiscount.applyDayOfTheWeekDiscount(weekday, order);

        // Then
        Assertions.assertEquals(2023, oneTBoneSteakDiscount);
        Assertions.assertEquals(4046, twoChocoCakesDiscount);
    }
}