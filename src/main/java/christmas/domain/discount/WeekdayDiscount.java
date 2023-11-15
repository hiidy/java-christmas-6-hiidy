package christmas.domain.discount;

import christmas.domain.order.Orders;

public class WeekdayDiscount implements DiscountPolicy {

    private static final int WEEKDAY_DISCOUNT_AMOUNT = 2023;

    @Override
    public boolean isApplicable(Orders orders) {
        return orders.getDate().isWeekday();
    }

    @Override
    public int calculateDiscountAmount(Orders orders) {
        return WEEKDAY_DISCOUNT_AMOUNT * orders.getTotalDessertCount();
    }

    @Override
    public DiscountPolicyType getPolicy() {
        return DiscountPolicyType.WEEKDAY;
    }
}
