package christmas.domain.discount;

import christmas.domain.order.Orders;

public class SpecialDiscount implements DiscountPolicy {

    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private final SpecialDayCalender eventCalendar = new SpecialDayCalender();

    @Override
    public boolean isApplicable(Orders orders) {
        return eventCalendar.isStarDay(orders.getDate().getDayOfMonth());
    }

    @Override
    public int calculateDiscountAmount(Orders orders) {
        return SPECIAL_DISCOUNT_AMOUNT;
    }

    @Override
    public DiscountPolicyType getPolicy() {
        return DiscountPolicyType.SPECIAL;
    }
}
