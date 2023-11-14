package christmas.domain.discount;

import christmas.domain.order.Orders;
import christmas.utils.Constant;
import java.util.Calendar;

public class WeekendDiscount implements DiscountPolicy {

    private static final int WEEKEND_DISCOUNT_AMOUNT = 2023;
    private static final int FRIDAY = 6;
    private static final int SATURDAY = 7;

    @Override
    public int calculateDiscountAmount(int dayOfMonth, Orders orders) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Constant.YEAR.getValue(), Constant.MONTH.getValue(), dayOfMonth);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        if (isWeekend(dayOfWeek)) {
            return WEEKEND_DISCOUNT_AMOUNT * orders.getTotalMainCount();
        }
        return 0;
    }

    private boolean isWeekend(int dayOfWeek) {
        return dayOfWeek >= FRIDAY && dayOfWeek <= SATURDAY;
    }
}
