package christmas.domain.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orders {

    private static final List<Order> orderList = new ArrayList<>();

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orderList);
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }
}
