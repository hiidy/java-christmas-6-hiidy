package christmas.utils.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class Date {

    private static final int YEAR = 2023;
    private static final int MONTH = Calendar.DECEMBER + 1;
    private final int dayOfMonth;

    public Date() {
        this.dayOfMonth = 1;
    }

    public Date(int dayOfMonth) {
        validateDayOfMonth(dayOfMonth);
        this.dayOfMonth = dayOfMonth;
    }

    private void validateDayOfMonth(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 31) {
            throw new UnsupportedOperationException();
        }
    }

    public static Date of(int dayOfMonth) {
        return new Date(dayOfMonth);
    }

    public int getYear() {
        return YEAR;
    }

    public int getMonth() {
        return MONTH;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public boolean isWeekend() {
        LocalDate date = LocalDate.of(YEAR, MONTH, dayOfMonth);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public boolean isWeekday() {
        return !isWeekend();
    }

}
