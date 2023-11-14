package christmas.domain.enums;

public enum Calendar {

    DAY1(1, true, false),
    DAY2(2, true, false),
    DAY3(3, false, true),
    DAY4(4, false, false),
    DAY5(5, false, false),
    DAY6(6, false, false),
    DAY7(7, false, false),
    DAY8(8, true, false),
    DAY9(9, true, false),
    DAY10(10, false, true),
    DAY11(11, false, false),
    DAY12(12, false, false),
    DAY13(13, false, false),
    DAY14(14, false, false),
    DAY15(15, true, false),
    DAY16(16, true, false),
    DAY17(17, false, true),
    DAY18(18, false, false),
    DAY19(19, false, false),
    DAY20(20, false, false),
    DAY21(21, false, false),
    DAY22(22, true, false),
    DAY23(23, true, false),
    DAY24(24, false, true),
    DAY25(25, false, true),
    DAY26(26, false, false),
    DAY27(27, false, false),
    DAY28(28, false, false),
    DAY29(29, true, false),
    DAY30(30, true, false),
    DAY31(31, false, true);

    private final int date;
    private final boolean weekend;
    private final boolean holiday;

    Calendar(int date, boolean weekend, boolean holiday) {
        this.date = date;
        this.weekend = weekend;
        this.holiday = holiday;
    }

    public static boolean isWeekend(int date) {
        return findByDate(date).weekend;
    }

    public static boolean isHoliday(int date) {
        return findByDate(date).holiday;
    }

    private static Calendar findByDate(int date) {
        for (Calendar day : values()) {
            if (day.date == date) {
                return day;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다.");
    }
}