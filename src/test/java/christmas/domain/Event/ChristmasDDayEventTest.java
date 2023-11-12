package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Order.Orders;
import christmas.domain.Today;
import christmas.fixture.OrderFixture;
import christmas.fixture.TodayFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDDayEventTest {

    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("크리스마스 이전이 아니라면 null을 반환한다.")
        @Test
        void givenTodayIsAfterChristmas() {
            assertNull(ChristmasDDayEvent.createInstance(
                    TodayFixture.AFTER_CHRISTMAS.getToday(),
                    new Orders(List.of(OrderFixture.PRICE_OVER_20000.getOrder()))));
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("크리스마스 디데이 할인이 제대로 적용되는지 확인한다.")
        @ParameterizedTest
        @CsvSource(value = {"1,1000","2,1100"})
        void test(int day, int expectedDiscount) {

            Event christmasDDayEvent = ChristmasDDayEvent.createInstance(
                    new Today(day),
                    new Orders(List.of(OrderFixture.PRICE_OVER_20000.getOrder())));

            Discount discount = Objects.requireNonNull(christmasDDayEvent).getDiscount();
            Discount expected = new Discount("크리스마스 디데이 할인", expectedDiscount);

            assertEquals(discount.getMessage(), expected.getMessage());

        }

    }

}