package christmas.domain.Discount;

import christmas.fixture.DiscountFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DiscountsTest {

    @DisplayName("getDiscountMessage 테스트")
    @Nested
    class getDiscountMessage {

        @DisplayName("빈 배열을 입력으로 넣으면 \"없음\"을 출력한다.")
        @Test
        void givenListIsEmpty() {
            Discounts discounts = new Discounts(List.of());
            assertEquals(discounts.getDiscountMessage(), "없음");
        }

        @DisplayName("메시지가 정상적으로 출력되는지 확인한다.")
        @Test
        void givenListIsNotEmpty() {
            Discounts discounts = new Discounts(List.of(DiscountFixture.BASE.getDiscount()));
            assertThat(discounts.getDiscountMessage())
                    .contains(DiscountFixture.BASE.getDiscountMessage());
        }

    }
    
    @DisplayName("getTotalDiscounts 테스트")
    @Nested
    class getTotalDiscounts {

        @DisplayName("총 혜택액을 잘 계산하는지 확인한다.")
        @Test
        void checkGetTotalDiscounts() {
            Discounts discounts = new Discounts(List.of(DiscountFixture.BASE.getDiscount()));
            assertEquals(discounts.getTotalDiscounts(), DiscountFixture.BASE.getDiscountPrice());
        }

    }

}