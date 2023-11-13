package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Order.Orders;
import christmas.fixture.OrderFixture;
import christmas.fixture.TodayFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class WeekendEventTest {

    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("주말이 아니면 null을 반환한다.")
        @Test
        void givenTodayIsNotWeekday() {
            assertNull(WeekdayEvent.createInstance(
                    TodayFixture.WEEKDAY.getToday(),
                    new Orders(List.of(OrderFixture.DESSERT.getOrder()))
            ));
        }

        @DisplayName("주문에 디저트가 없으면 null을 반환한다.")
        @Test
        void givenOrdersNotContainMain() {
            assertNull(WeekdayEvent.createInstance(
                    TodayFixture.WEEKEND.getToday(),
                    new Orders(List.of(OrderFixture.PRICE_OVER_20000.getOrder()))
            ));
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("평일 할인이 제대로 적용되는지 확인한다.")
        @Test
        void checkGetDiscount() {

            DiscountEvent discountEvent = new WeekendEvent(
                    TodayFixture.WEEKEND.getToday(),
                    new Orders(List.of(OrderFixture.DESSERT.getOrder()))
            );

            Discount discount = discountEvent.getDiscount();
            Discount expected = new Discount("주말 할인", 2023);

            assertEquals(discount, expected);

        }

    }

}