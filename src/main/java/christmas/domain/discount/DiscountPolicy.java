package christmas.domain.discount;

import christmas.domain.order.Orders;

public interface DiscountPolicy {

    int calculateDiscountAmount(int dayOfMonth, Orders orders);

}
