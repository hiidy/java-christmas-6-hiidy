package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.menu.Category;
import christmas.domain.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    @DisplayName("메뉴가 정상적으로 생성되는지 테스트")
    void testMenuCreation() {
        // Given
        String name = "타파스";
        Category category = Category.APPETIZER;
        int price = 5500;

        // when
        Menu menu = new Menu(name, category, price);

        // Then
        assertEquals(name, menu.getName());
        assertEquals(category, menu.getCategory());
        assertEquals(price, menu.getPrice());
    }
}
