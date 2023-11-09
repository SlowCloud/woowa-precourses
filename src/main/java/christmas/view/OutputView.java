package christmas.view;

public class OutputView {

    public void printHeader() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printIllegalArgumentException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printOrderedMenus(String orderedMenus) {
        System.out.println("<주문 메뉴>");
        System.out.println(orderedMenus);
    }

}
