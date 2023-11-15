package christmas.domain.discount;

import christmas.domain.order.Orders;

public class ChristmasDDayDiscount implements DiscountPolicy {

    private static final int BASE_DISCOUNT = 1000;
    private static final int DISCOUNT_INCREASE_RATE = 100;
    private static final int CHRISTMAS_DAY = 25;
    private static final int START_DAY = 1;


    @Override
    public boolean isApplicable(Orders orders) {
        return isBeforeStartDay(orders.getDate().getDayOfMonth()) || isAfterChristmasDay(
                orders.getDate().getDayOfMonth());
    }

    @Override
    public int calculateDiscountAmount(Orders orders) {
        return calculateDiscount(orders);
    }

    @Override
    public DiscountPolicyType getPolicy() {
        return DiscountPolicyType.CHRISTMAS_D_DAY;
    }

    private int calculateDiscount(Orders orders) {
        int dayOfMonth = orders.getDate().getDayOfMonth();
        if (isBeforeStartDay(dayOfMonth) || isAfterChristmasDay(dayOfMonth)) {
            return BASE_DISCOUNT + calculateIncreasedDiscount(dayOfMonth);
        }
        return 0;
    }

    private boolean isBeforeStartDay(int dayOfMonth) {
        return dayOfMonth <= START_DAY;
    }

    private boolean isAfterChristmasDay(int dayOfMonth) {
        return dayOfMonth >= CHRISTMAS_DAY;
    }

    private int calculateIncreasedDiscount(int dayOfMonth) {
        return (CHRISTMAS_DAY - dayOfMonth) * DISCOUNT_INCREASE_RATE;
    }

}
