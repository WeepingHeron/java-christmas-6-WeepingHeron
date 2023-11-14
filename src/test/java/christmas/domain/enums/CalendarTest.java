package christmas.domain.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalendarTest {

    @DisplayName("인자로 들어온 날짜가 주말인지 확인한다.")
    @Test
    void isWeekendTest() {
        // Given
        int weekday = 7;
        int weekend = 8;

        // When
        boolean isNotWeekend = Calendar.isWeekend(weekday);
        boolean isWeekend = Calendar.isWeekend(weekend);

        // Then
        Assertions.assertFalse(isNotWeekend);
        Assertions.assertTrue(isWeekend);
    }

    @DisplayName("인자로 들어온 날짜가 공휴일인지 확인한다.")
    @Test
    void isHolidayTest() {
        // Given
        int notHoliday = 2;
        int holiday = 3;

        // When
        boolean isNotHoliday = Calendar.isHoliday(notHoliday);
        boolean isHoliday = Calendar.isHoliday(holiday);

        // Then
        Assertions.assertFalse(isNotHoliday);
        Assertions.assertTrue(isHoliday);
    }
}