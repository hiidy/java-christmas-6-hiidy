package christmas.domain.event;

import christmas.domain.menu.Menu;
import christmas.domain.order.Orders;

public class BadgeEvent implements EventPolicy {

    private static final int BADGE_AMOUNT = 100000;

    @Override
    public boolean isApplicable(Orders orders) {
        return orders.getRawAmount() >= BADGE_AMOUNT;
    }

    @Override
    public Menu getEventItem(Orders orders) {
        return null;
    }

    @Override
    public EventPolicyType getPolicy() {
        return EventPolicyType.BADGE_EVENT;
    }

    @Override
    public int calculateDiscountAmount(Orders orders) {
        return 0;
    }
}
