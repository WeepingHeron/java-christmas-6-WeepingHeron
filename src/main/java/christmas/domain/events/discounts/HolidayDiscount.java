package christmas.domain.events.discounts;

import christmas.domain.enums.Calendar;

public class HolidayDiscount {

    private static final int HOLIDAY_DISCOUNT_AMOUNT = 1000;

    public Integer applyHolidayDiscount(Integer date) {
        if (Calendar.values()[date - 1].isHoliday()) {
            return HOLIDAY_DISCOUNT_AMOUNT;
        }

        return 0;
    }
}
