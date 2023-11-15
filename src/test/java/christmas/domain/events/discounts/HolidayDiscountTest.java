package christmas.domain.events.discounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HolidayDiscountTest {

    @DisplayName("공휴일의 경우 특별 할인을 진행한다.")
    @Test
    void applyHolidayDiscountTest() {
        // Given
        HolidayDiscount holidayDiscount = new HolidayDiscount();
        Integer notHoliday = 2;
        Integer holiday = 3;

        // When
        Integer noHolidayDiscount = holidayDiscount.applyHolidayDiscount(notHoliday);
        Integer gotHolidayDiscount = holidayDiscount.applyHolidayDiscount(holiday);

        // Then
        Assertions.assertEquals(0, noHolidayDiscount);
        Assertions.assertEquals(1000, gotHolidayDiscount);
    }
}