package christmas.controller;

import christmas.domain.benefit.Benefits;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuRepository;
import christmas.domain.order.Item;
import christmas.domain.order.Orders;
import christmas.domain.order.Receipt;
import christmas.utils.date.Date;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {

    public void run() {
        Date date = new Date();
        OutputView.printEventPlannerStartMessage(date);
        date = Date.of(InputView.getDayOfMonth());
        Map<String, Integer> inputOrderList = InputView.getOrderDetails();
        OutputView.printEventPlannerPreviewMessage(date);
        Orders orders = createOrders(date, inputOrderList);
        Benefits benefits = new Benefits(orders);
        Receipt receipt = new Receipt(orders, benefits);
        OutputView.printReceipt(receipt);

    }

    public static Orders createOrders(Date date, Map<String, Integer> inputOrderList) {
        Orders orders = new Orders(date);

        inputOrderList.entrySet().stream()
                .map(entry -> {
                    String menuName = entry.getKey();
                    int quantity = entry.getValue();
                    Menu menu = MenuRepository.findMenuByName(menuName);
                    return new Item(menu, quantity);
                })
                .forEach(orders::addOrder);

        return orders;

    }
}
