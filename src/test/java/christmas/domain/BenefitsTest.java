package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import christmas.domain.benefit.Benefits;
import christmas.domain.discount.DiscountPolicyType;
import christmas.domain.event.EventPolicyType;
import christmas.domain.menu.MenuRepository;
import christmas.domain.order.Item;
import christmas.domain.order.Orders;
import christmas.utils.date.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BenefitsTest {

    private Orders orders;
    private Benefits benefits;

    @BeforeEach
    public void setup() {
        Date date = Date.of(25);
        orders = new Orders(date);
        // 주문 목록을 생성하고, 여기에 메뉴와 수량을 채워넣습니다.
        orders.addOrder(new Item(MenuRepository.findMenuByName("티본스테이크"), 10));
        orders.addOrder(new Item(MenuRepository.findMenuByName("샴페인"), 5));
        benefits = new Benefits(orders);
    }

    @Test
    void testAddAllDiscountPolicies() {
        benefits.addAllDiscountPolicies(orders);

        int expectedSize = 0;
        for (DiscountPolicyType policyType : DiscountPolicyType.values()) {
            if (policyType.getPolicy().isApplicable(orders)) {
                expectedSize++;
            }
        }
        assertEquals(expectedSize, benefits.getBenefits().size());
    }

    @Test
    void testAddAllEventPolicies() {
        benefits.addAllEventPolicies(orders);

        int expectedSize = 0;
        for (EventPolicyType policyType : EventPolicyType.values()) {
            if (policyType.getPolicy().isApplicable(orders)) {
                expectedSize++;
            }
        }
        assertEquals(expectedSize, benefits.getBenefits().size());
    }

    @Test
    void testAddDiscountBenefit() {
        for (DiscountPolicyType policyType : DiscountPolicyType.values()) {
            if (policyType.getPolicy().isApplicable(orders)) {
                benefits.addDiscountBenefit(orders, policyType.getPolicy());
                break;
            }
        }

        // addBenefit 메소드가 실행된 후 Benefit 객체가 추가되었는지 확인
        assertFalse(benefits.getBenefits().isEmpty());
    }

    @Test
    void testAddEventBenefit() {
        for (EventPolicyType policyType : EventPolicyType.values()) {
            if (policyType.getPolicy().isApplicable(orders)) {
                benefits.addEventBenefit(orders, policyType.getPolicy());
                break;
            }
        }

        // addBenefit 메소드가 실행된 후 Benefit 객체가 추가되었는지 확인
        assertFalse(benefits.getBenefits().isEmpty());
    }
}
