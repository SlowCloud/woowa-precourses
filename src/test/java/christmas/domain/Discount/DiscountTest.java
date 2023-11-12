package christmas.domain.Discount;

import christmas.fixture.DiscountFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @DisplayName("getMessage 테스트")
    @Nested
    class getMessage {

        @DisplayName("출력이 원하는대로 되는지 확인한다.")
        @Test
        void checkGetMessage() {
            Discount discount = DiscountFixture.BASE.getDiscount();
            assertEquals(discount.getMessage(), DiscountFixture.BASE.getDiscountMessage());
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("반환값이 올바른지 확인한다.")
        @Test
        void checkGetMessage() {
            Discount discount = DiscountFixture.BASE.getDiscount();
            assertEquals(discount.getDiscount(), DiscountFixture.BASE.getDiscountPrice());
        }

    }

}