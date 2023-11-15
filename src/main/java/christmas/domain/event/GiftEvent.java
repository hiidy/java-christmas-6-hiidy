package christmas.domain.event;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuRepository;
import christmas.domain.order.Orders;

public class GiftEvent implements EventPolicy {

    private static final int GIFT_AMOUNT = 120000;

    @Override
    public boolean isApplicable(Orders orders) {
        return orders.getRawAmount() >= GIFT_AMOUNT;
    }

    @Override
    public Menu getEventItem(Orders orders) {
        return MenuRepository.findMenuByName("샴페인");
    }

    @Override
    public EventPolicyType getPolicy() {
        return EventPolicyType.GIFT_EVENT;
    }

    @Override
    public int calculateDiscountAmount(Orders orders) {
        return getEventItem(orders).getPrice();
    }
}
