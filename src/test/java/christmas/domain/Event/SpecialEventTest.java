package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Order.Orders;
import christmas.fixture.OrderFixture;
import christmas.fixture.TodayFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SpecialEventTest {

    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("크리스마스 또는 일요일이 아니면 null을 반환한다.")
        @Test
        void givenTodayIsNotSpecial() {
            assertNull(SpecialEvent.createInstance(
                    TodayFixture.WEEKEND.getToday(),
                    new Orders(List.of(OrderFixture.PRICE_OVER_20000.getOrder()))
            ));
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("특별 할인이 제대로 적용되는지 확인한다.")
        @Test
        void checkGetDiscount() {

            DiscountEvent discountEvent = new SpecialEvent(
                    TodayFixture.CHRISTMAS.getToday(),
                    new Orders(List.of(OrderFixture.PRICE_OVER_20000.getOrder()))
            );

            Discount discount = discountEvent.getDiscount();
            Discount expected = new Discount("특별 할인", 1000);

            assertEquals(discount, expected);

        }

    }

}