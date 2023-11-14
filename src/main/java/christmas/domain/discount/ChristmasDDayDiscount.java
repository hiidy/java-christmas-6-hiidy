package christmas.domain.discount;

import christmas.domain.order.Orders;

public class ChristmasDDayDiscount implements DiscountPolicy {

    private static final int BASE_DISCOUNT = 1000;
    private static final int DISCOUNT_INCREASE_RATE = 100;
    private static final int CHRISTMAS_DAY = 25;
    private static final int START_DAY = 1;

    @Override
    public int calculateDiscountAmount(int dayOfMonth, Orders orders) {
        return calculateDiscount(dayOfMonth);
    }

    private int calculateDiscount(int dayOfMonth) {
        if (isBeforeStartDay(dayOfMonth) || isAfterChristmasDay(dayOfMonth)) {
            return BASE_DISCOUNT + calculateIncreasedDiscount(dayOfMonth);
        }
        return 0;
    }

    private boolean isBeforeStartDay(int dayOfMonth) {
        return dayOfMonth < START_DAY;
    }

    private boolean isAfterChristmasDay(int dayOfMonth) {
        return dayOfMonth > CHRISTMAS_DAY;
    }

    private int calculateIncreasedDiscount(int dayOfMonth) {
        return (CHRISTMAS_DAY - dayOfMonth) * DISCOUNT_INCREASE_RATE;
    }
}
