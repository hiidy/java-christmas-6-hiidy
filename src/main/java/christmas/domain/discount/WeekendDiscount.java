package christmas.domain.discount;

import christmas.domain.order.Orders;

public class WeekendDiscount implements DiscountPolicy {

    private static final int WEEKEND_DISCOUNT_AMOUNT = 2023;

    @Override
    public boolean isApplicable(Orders orders) {
        return orders.getDate().isWeekend();
    }

    @Override
    public int calculateDiscountAmount(Orders orders) {
        return WEEKEND_DISCOUNT_AMOUNT * orders.getTotalMainCount();
    }

    @Override
    public DiscountPolicyType getPolicy() {
        return DiscountPolicyType.WEEKEND;
    }

}
