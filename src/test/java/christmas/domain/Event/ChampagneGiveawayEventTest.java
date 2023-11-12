package christmas.domain.Event;

import christmas.domain.Discount.Discount;
import christmas.domain.Giveaway.Giveaway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChampagneGiveawayEventTest {
    
    @DisplayName("createInstance 테스트")
    @Nested
    class createInstance {

        @DisplayName("총 구매액이 12만을 넘지 않으면 null을 반환한다.")
        @Test
        void givenPriceIsLowerThanHundredTwentyThousand() {
            assertNull(ChampagneGiveawayEvent.createInstance(0));
        }

    }

    @DisplayName("getDiscount 테스트")
    @Nested
    class getDiscount {

        @DisplayName("정상적으로 Discount를 반환하는지 확인한다.")
        @Test
        void checkGetDiscount() {
            ChampagneGiveawayEvent champagneGiveawayEvent = new ChampagneGiveawayEvent(120_000);
            assertEquals(
                    champagneGiveawayEvent.getDiscount().getMessage(),
                    new Discount("증정 이벤트", 25_000).getMessage()
            );
        }

    }

    @DisplayName("getGiveaway 테스트")
    @Nested
    class getGiveaway {

        @DisplayName("정상적으로 Giveaway를 반환하는지 확인한다.")
        @Test
        void checkGetDiscount() {
            ChampagneGiveawayEvent champagneGiveawayEvent = new ChampagneGiveawayEvent(120_000);
            assertEquals(
                    champagneGiveawayEvent.getGiveaway().getMessage(),
                    new Giveaway("샴페인", 1).getMessage()
            );
        }

    }

}