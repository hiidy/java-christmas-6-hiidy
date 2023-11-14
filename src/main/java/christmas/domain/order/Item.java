package christmas.domain.order;

import christmas.domain.menu.Menu;

public class Item {

    private final Menu menu;
    private final int quantity;

    public Item(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "menu=" + menu +
                ", quantity=" + quantity +
                '}';
    }
}
