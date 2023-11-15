package christmas.domain.event;

import christmas.domain.menu.Menu;
import christmas.domain.order.Orders;

public interface EventPolicy {

    boolean isApplicable(Orders orders);

    Menu getEventItem(Orders orders);

    EventPolicyType getPolicy();

    int calculateDiscountAmount(Orders orders);
}
