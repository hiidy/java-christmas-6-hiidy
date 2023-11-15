package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.benefit.Benefits;
import christmas.domain.menu.MenuRepository;
import christmas.domain.order.Item;
import christmas.domain.order.Orders;
import christmas.domain.order.Receipt;
import christmas.utils.date.Date;
import org.junit.jupiter.api.Test;

class ReceiptTest {

    @Test
    void testReceipt() {
        Date date = Date.of(25);
        Orders orders = new Orders(date);
        // 주문 목록을 생성하고, 여기에 메뉴와 수량을 채워넣습니다.
        orders.addOrder(new Item(MenuRepository.findMenuByName("티본스테이크"), 10));
        orders.addOrder(new Item(MenuRepository.findMenuByName("샴페인"), 5));
        Benefits benefits = new Benefits(orders);

        // Receipt 객체를 생성합니다.
        Receipt receipt = new Receipt(orders, benefits);

        // 총 디저트 수량이 올바른지 확인합니다.
        assertEquals(10, orders.getTotalMainCount());

        // 총 음료 수량이 올바른지 확인합니다.
        assertEquals(5, orders.getTotalBeverageCount());

    }
}
