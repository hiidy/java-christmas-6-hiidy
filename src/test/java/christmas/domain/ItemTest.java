package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuRepository;
import christmas.domain.order.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    @DisplayName("주문 생성 테스트")
    void createOrder() {

        assertThat(new Item(MenuRepository.findMenuByName("제로콜라"), 2)).isInstanceOf(Item.class);

        //given
        Menu menu = new Menu("제로콜라", Category.BEVERAGE, 3000);
        int quantity = 2;

        //when
        Item item = new Item(menu, quantity);

        //then
        assertThat(item.getMenu()).isEqualTo(menu);
    }
}
