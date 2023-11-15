package christmas.domain.benefit;

import christmas.domain.discount.DiscountPolicy;
import christmas.domain.event.EventPolicy;
import christmas.domain.menu.Menu;

public class Benefit {

    BenefitType type;
    DiscountPolicy discount;
    EventPolicy event;
    int amount;
    Menu item;

    public Benefit(DiscountPolicy dp, int amount) {
        this.type = BenefitType.DISCOUNT;
        this.discount = dp;
        this.amount = amount;
    }

    public Benefit(EventPolicy ep, Menu item, int amount) {
        this.type = BenefitType.EVENT;
        this.event = ep;
        this.item = item;
        this.amount = amount;
    }

    public DiscountPolicy getDiscount() throws IllegalAccessError {
        if (this.type == BenefitType.DISCOUNT) {
            return this.discount;
        }
        throw new IllegalAccessError("This benefit is not a discount.");
    }

    public EventPolicy getEvent() throws IllegalAccessError {
        if (this.type == BenefitType.EVENT) {
            return this.event;
        }
        throw new IllegalAccessError("This benefit is not an event benefit.");
    }

    @Override
    public String toString() {
        if (this.type == BenefitType.EVENT) {
            return event.getPolicy().getEventName();
        }
        return discount.getPolicy().getDiscountName();
    }
}