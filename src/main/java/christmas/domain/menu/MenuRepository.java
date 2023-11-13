package christmas.domain.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {

    private static final List<Menu> menus = new ArrayList<>();

    static {
        initializeMenus();
    }

    private static void initializeMenus() {
        menus.add(new Menu("양송이수프", Category.APPETIZER, 6000));
        menus.add(new Menu("타파스", Category.APPETIZER, 5500));
        menus.add(new Menu("시저샐러드", Category.APPETIZER, 8000));
        menus.add(new Menu("티본스테이크", Category.MAIN, 55000));
        menus.add(new Menu("바비큐립", Category.MAIN, 54000));
        menus.add(new Menu("해산물파스타", Category.MAIN, 35000));
        menus.add(new Menu("크리스마스파스타", Category.MAIN, 25000));
        menus.add(new Menu("초코케이크", Category.DESSERT, 15000));
        menus.add(new Menu("아이스크림", Category.DESSERT, 5000));
        menus.add(new Menu("제로콜라", Category.BEVERAGE, 3000));
        menus.add(new Menu("레드와인", Category.BEVERAGE, 60000));
        menus.add(new Menu("샴페인", Category.BEVERAGE, 25000));
    }


    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }

    public static Menu findMenuByName(String menuName) {
        return menus.stream()
                .filter(menu -> menu.getName().equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }
}
