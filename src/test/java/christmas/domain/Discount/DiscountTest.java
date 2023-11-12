package christmas.domain.Discount;

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
            Discount discount = new Discount("메시지", 10_000);
            assertEquals(discount.getMessage(), "메시지: -10,000원");
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("반환값이 올바른지 확인한다.")
        @Test
        void checkGetMessage() {
            Discount discount = new Discount("메시지", 10_000);
            assertEquals(discount.getDiscount(), -10_000);
        }

    }

}