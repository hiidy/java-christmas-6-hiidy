package christmas.domain.order;

import christmas.domain.benefit.Benefits;


public class Receipt {

    private final Orders orders;
    private final Benefits benefits;

    public Receipt(Orders orders, Benefits benefits) {
        this.orders = orders;
        this.benefits = benefits;
    }

    public Orders getOrders() {
        return orders;
    }

    public Benefits getBenefits() {
        return benefits;
    }

    public String printReceipt() {
        throw new UnsupportedOperationException();
    }

    public int getDiscountedAmount() {
        return orders.getRawAmount() - benefits.getTotalDiscountedAmount();
    }

    public int getBenefitsAmount() {
        return benefits.getTotalBenefitsAmount();
    }

}
