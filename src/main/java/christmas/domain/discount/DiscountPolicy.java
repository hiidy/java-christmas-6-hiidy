package christmas.domain.discount;

import christmas.domain.order.Orders;

public interface DiscountPolicy {

    boolean isApplicable(Orders orders);

    int calculateDiscountAmount(Orders orders);

    DiscountPolicyType getPolicy();
}
