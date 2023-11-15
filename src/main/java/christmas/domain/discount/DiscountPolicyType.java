package christmas.domain.discount;

public enum DiscountPolicyType {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인", new ChristmasDDayDiscount()),
    WEEKEND("주말 할인", new WeekendDiscount()),
    SPECIAL("특별 할인", new SpecialDiscount()),
    WEEKDAY("평일 할인", new WeekdayDiscount());

    private final String discountName;
    private final DiscountPolicy policy;

    DiscountPolicyType(String discountName, DiscountPolicy policy) {
        this.discountName = discountName;
        this.policy = policy;
    }

    public String getDiscountName() {
        return discountName;
    }

    public DiscountPolicy getPolicy() {
        return policy;
    }
}
