package christmas.domain.order;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuRepository;
import java.util.ArrayList;
import java.util.List;

//enum BenefitType {
//    Discount, Event
//}
//
//class Benefits {
//    List<Benefit> benefits;
//
//    public int getAmount() {
//        throw new UnsupportedOperationException();
//    }
//
//    public int getDiscountAmount() {
//        throw new UnsupportedOperationException();
//    }
//}
//
//class Benefit {
//    BenefitType type;
//    DiscountPolicy discount;
//    EventPolicy event;
//    int amount;
//
//    public Benefit(DiscountPolicy dp, int amount) {
//        this.type = BenefitType.Discount;
//        this.discount = dp;
//        this.amount = amount;
//    }
//
//    public DiscountPolicy getDiscount() throws IllegalAccessError {
//        if (this.type == BenefitType.Discount) {
//            return this.discount;
//        }
//        throw new IllegalAccessError();
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
//}

public class Receipt {

    private static final int GIFT_AMOUNT_LIMIT = 120000;
    private static final Menu GIFT_MENU = MenuRepository.findMenuByName("샴페인");

    private final Orders orders;
    private final List<Item> gift = new ArrayList<>();
//    private final Benefits benefits = new Benefits();

    public Receipt(Orders orders) {
        this.orders = orders;
        addGift();
    }


    public List<Item> getGift() {
        return gift;
    }

    public int getTotalDessertCount() {
        return orders.getOrderList().stream()
                .filter(item -> Category.DESSERT.equals(item.getMenu().getCategory()))
                .mapToInt(Item::getQuantity)
                .sum();
    }

    public int getTotalBeverageCount() {
        return orders.getOrderList().stream()
                .filter(item -> Category.BEVERAGE.equals(item.getMenu().getCategory()))
                .mapToInt(Item::getQuantity)
                .sum();
    }

    public int getTotalMainCount() {
        return orders.getOrderList().stream()
                .filter(item -> Category.MAIN.equals(item.getMenu().getCategory()))
                .mapToInt(Item::getQuantity)
                .sum();
    }

    public int getRawAmount() {
        return orders.getOrderList().stream()
                .mapToInt(item -> item.getMenu().getPrice() * item.getQuantity())
                .sum();
    }

    public void addGift() {
        if (getRawAmount() >= GIFT_AMOUNT_LIMIT) {
            gift.add(new Item(GIFT_MENU, 1));
        }
    }
}
