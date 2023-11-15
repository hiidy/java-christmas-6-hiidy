package christmas.view;

import christmas.domain.benefit.Benefits;
import christmas.domain.order.Orders;
import christmas.domain.order.Receipt;
import christmas.utils.date.Date;

public class OutputView {

    public static void printReceipt(Receipt receipt) {
        OutputView.printOrderMenus(receipt);
        OutputView.printTotalOrderAmount(receipt);
        OutputView.printGiftMenu(receipt);
        OutputView.printBenefits(receipt);
        OutputView.printTotalBenefitsAmount(receipt);
        OutputView.printExpectedPaymentAmount(receipt);
        OutputView.printEventBadge(receipt);
    }

    public static void printEventPlannerStartMessage(Date date) {
        System.out.println("안녕하세요! 우테코 식당 " + date.getMonth() + "월 이벤트 플래너입니다.");
    }

    public static void printEventPlannerPreviewMessage(Date date) {
        System.out.println(date.getMonth() + "월 " + date.getDayOfMonth() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOrderMenus(Receipt receipt) {
        Orders orders = receipt.getOrders();
        System.out.println("<주문 메뉴>");
        orders.getOrderList()
                .forEach(menu -> System.out.println(menu.getMenu().getName() + " " + menu.getQuantity() + "개"));
    }

    public static void printTotalOrderAmount(Receipt receipt) {
        Orders orders = receipt.getOrders();
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(orders.getRawAmount() + "원");
    }

    public static void printGiftMenu(Receipt receipt) {
        Benefits benefits = receipt.getBenefits();
        System.out.println("\n<증정 메뉴>");
        if (benefits.getBenefits() != null) {
            System.out.println(benefits.getGiftItem());
        } else {
            System.out.println("없음");
        }
    }

    public static void printBenefits(Receipt receipt) {
        Benefits benefits = receipt.getBenefits();
        System.out.println("\n<혜택 내역>");
        if (!benefits.getBenefits().isEmpty()) {
            System.out.println(benefits.toString());
            return;
        }
        System.out.println("없음");
    }

    public static void printTotalBenefitsAmount(Receipt receipt) {
        System.out.println("\n<총혜택 금액>");
        System.out.println(receipt.getBenefitsAmount() + "원");
    }

    public static void printExpectedPaymentAmount(Receipt receipt) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(receipt.getDiscountedAmount() + "원");
    }

    public static void printEventBadge(Receipt receipt) {
        Benefits benefits = receipt.getBenefits();
        System.out.println("\n<12월 이벤트 배지>");
        if (true) {
            System.out.println("12월 이벤트 배지");
        } else {
            System.out.println("없음");
        }
    }
}
