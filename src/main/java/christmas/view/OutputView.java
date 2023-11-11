package christmas.view;

public class OutputView {

    public void printHeader() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printIllegalArgumentException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printEventPreviewMessage() {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void printOrderedMenus(String orderedMenus) {
        System.out.println("<주문 메뉴>");
        System.out.println(orderedMenus);
    }

    public void printTotalPriceBeforeDiscount(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원%n", totalPrice);
    }

    public void printGiveaway(String giveawayMessage) {
        System.out.println("<증정 메뉴>");
        System.out.println(giveawayMessage);
    }

    public void printDiscounts(String discountsMessage) {
        System.out.println("<혜택 내역>");
        System.out.println(discountsMessage);
    }

    public void printTotalDiscounts(int totalDiscounts) {
        System.out.println("<총혜택 금액>");
        System.out.printf("-%,d원%n", totalDiscounts);
    }

    public void printTotalPriceAfterDiscount(int discountedTotalPrice) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원%n", discountedTotalPrice);
    }

    public void printBadge(String badgeName) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badgeName);
    }

}
