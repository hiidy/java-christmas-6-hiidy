package christmas.domain.discount;

import christmas.domain.order.Orders;
import christmas.utils.Constant;
import java.util.Calendar;

public class WeekdayDiscount implements DiscountPolicy {

    private static final int WEEKDAY_DISCOUNT_AMOUNT = 2023;
    private static final int SUNDAY = 1;
    private static final int THURSDAY = 5;

    @Override
    public int calculateDiscountAmount(int dayOfMonth, Orders orders) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Constant.YEAR.getValue(), Constant.MONTH.getValue(), dayOfMonth);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        if (isWeekday(dayOfWeek)) {
            return WEEKDAY_DISCOUNT_AMOUNT * orders.getTotalDessertCount();
        }
        return 0;
    }

    private boolean isWeekday(int dayOfWeek) {
        return dayOfWeek >= SUNDAY && dayOfWeek <= THURSDAY;
    }

}
