package christmas.domain.benefit;

import christmas.domain.discount.DiscountPolicy;
import christmas.domain.discount.DiscountPolicyType;
import christmas.domain.event.EventPolicy;
import christmas.domain.event.EventPolicyType;
import christmas.domain.menu.Menu;
import christmas.domain.order.Orders;
import java.util.ArrayList;
import java.util.List;

public class Benefits {

    private final List<Benefit> benefits = new ArrayList<>();

    public Benefits(Orders orders) {
        addAllDiscountPolicies(orders);
        addAllEventPolicies(orders);
    }

    public List<Benefit> getBenefits() {
        return benefits;
    }

    public void addAllDiscountPolicies(Orders orders) {
        for (DiscountPolicyType policyType : DiscountPolicyType.values()) {
            addDiscountBenefit(orders, policyType.getPolicy());
        }
    }

    public void addDiscountBenefit(Orders orders, DiscountPolicy discountPolicy) {
        if (discountPolicy.isApplicable(orders)) {
            int discountAmount = discountPolicy.calculateDiscountAmount(orders);
            benefits.add(new Benefit(discountPolicy, discountAmount));
        }
    }

    public void addAllEventPolicies(Orders orders) {
        for (EventPolicyType policyType : EventPolicyType.values()) {
            addEventBenefit(orders, policyType.getPolicy());
        }
    }

    public void addEventBenefit(Orders orders, EventPolicy policy) {
        if (policy.isApplicable(orders)) {
            int discountAmount = policy.calculateDiscountAmount(orders);
            benefits.add(new Benefit(policy, policy.getEventItem(orders), discountAmount));
        }
    }

    public int getTotalBenefitsAmount() {
        int totalBenfitsAmount = 0;
        for (Benefit benefit : benefits) {
            totalBenfitsAmount += benefit.amount;
        }
        return totalBenfitsAmount;
    }

    public int getTotalDiscountedAmount() {
        int totalDiscountedAmount = 0;
        for (Benefit benefit : benefits) {
            if (benefit.type == BenefitType.DISCOUNT) {
                totalDiscountedAmount += benefit.amount;
            }
        }
        return totalDiscountedAmount;
    }

    public Menu getGiftItem() {
        for (Benefit benefit : benefits) {
            if (benefit.type == BenefitType.EVENT) {
                return benefit.item;
            }
        }
        return null;
    }

}
