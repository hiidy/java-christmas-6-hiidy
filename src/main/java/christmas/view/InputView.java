package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    private static String getInput() {
        return Console.readLine();
    }

    public static int getDayOfMonth() {
        while (true) {
            try {
                System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
                return Integer.parseInt(getInput());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static Map<String, Integer> getOrderDetails() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        Map<String, Integer> getOrderDetails = new HashMap<>();
        String input = getInput();

        String[] menuQuantities = input.split(",");
        for (String menuQuantity : menuQuantities) {
            String[] parts = menuQuantity.split("-");
            if (parts.length == 2) {
                try {
                    String menuName = parts[0].trim();
                    int quantity = Integer.parseInt(parts[1].trim());
                    getOrderDetails.put(menuName, quantity);
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                    return getOrderDetails();
                }
            } else {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                return getOrderDetails();
            }
        }

        return getOrderDetails;
    }

}
