package christmas.domain.order;

import christmas.domain.menu.Category;
import christmas.utils.date.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {

    private final List<Item> orderList = new ArrayList<>();
    private final Date date;

    public Orders(Date date) {
        this.date = date;
    }

    public void addOrder(Item item) {
        orderList.add(item);
    }

    public List<Item> getOrderList() {
        return Collections.unmodifiableList(orderList);
    }

    public Date getDate() {
        return date;
    }

    public int getTotalDessertCount() {
        return orderList.stream()
                .filter(item -> Category.DESSERT.equals(item.getMenu().getCategory()))
                .mapToInt(Item::getQuantity)
                .sum();
    }

    public int getTotalBeverageCount() {
        return orderList.stream()
                .filter(item -> Category.BEVERAGE.equals(item.getMenu().getCategory()))
                .mapToInt(Item::getQuantity)
                .sum();
    }

    public int getTotalMainCount() {
        return orderList.stream()
                .filter(item -> Category.MAIN.equals(item.getMenu().getCategory()))
                .mapToInt(Item::getQuantity)
                .sum();
    }

    public int getRawAmount() {
        return orderList.stream()
                .mapToInt(item -> item.getMenu().getPrice() * item.getQuantity())
                .sum();
    }

    public String printAllOrders() {
        return "<주문 메뉴>\n" + orderList.stream()
                .map(Item::toString)
                .collect(Collectors.joining("\n"));
    }

    public String printGetRawAmount() {
        return "<할인 전 총주문 금액>\n" + getRawAmount() + "원";
    }

}