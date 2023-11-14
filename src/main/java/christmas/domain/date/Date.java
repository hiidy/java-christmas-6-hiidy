package christmas.domain.date;

import christmas.utils.Constant;

public class Date {

    private final Constant year = Constant.YEAR;
    private final Constant month = Constant.MONTH;
    private final int dayOfMonth;

    public Date(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public static Date of(int dayOfMonth) {
        return new Date(dayOfMonth);
    }
}
