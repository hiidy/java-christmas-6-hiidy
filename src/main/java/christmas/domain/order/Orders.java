package christmas.domain.order;

import christmas.domain.date.Date;
import java.util.ArrayList;
import java.util.List;

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
        return orderList;
    }
}