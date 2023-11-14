package christmas.domain.events.discounts;

import christmas.domain.enums.Calendar;

public class HolidayDiscount {

    private static final int HOLIDAY_DISCOUNT_AMOUNT = 1000;
    private static final int NO_DISCOUNT_APPLIED = 0;

    public Integer applyHolidayDiscount(Integer date) {
        if (Calendar.isHoliday(date)) {
            return HOLIDAY_DISCOUNT_AMOUNT;
        }

        return NO_DISCOUNT_APPLIED;
    }
}
