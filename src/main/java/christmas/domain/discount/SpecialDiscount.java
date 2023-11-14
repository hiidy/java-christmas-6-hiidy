package christmas.domain.discount;

import christmas.domain.order.Orders;

public class SpecialDiscount implements DiscountPolicy {

    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private final SpecialDayCalender eventCalendar;

    public SpecialDiscount(SpecialDayCalender eventCalendar) {
        this.eventCalendar = eventCalendar;
    }

    @Override
    public int calculateDiscountAmount(int dayOfMonth, Orders orders) {
        if (eventCalendar.isStarDay(dayOfMonth)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }
}
