package christmas.domain.events.discounts;

import christmas.domain.events.Calendar;

public class HolidayDiscount {

    public Integer applyHolidayDiscount(Integer date) {
        int discountAmount = 0;

        if (Calendar.values()[date - 1].isHoliday()) {
            return discountAmount += 1000;
        }

        return discountAmount;
    }
}
