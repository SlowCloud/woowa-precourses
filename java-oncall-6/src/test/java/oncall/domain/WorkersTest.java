package oncall.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkersTest {
    @Nested
    class constructor {
        @Test
        void Workers_생성을_확인한다() {
            assertDoesNotThrow(() -> new Workers(List.of("test")));
        }
    }

    @Nested
    class empty {
        @Test
        void 비어_있으면_참() {
            Workers workers = new Workers(List.of());
            assertTrue(workers.empty());
        }

        @Test
        void 차_있으면_거짓() {
            Workers workers = new Workers(List.of("test"));
            assertFalse(workers.empty());
        }
    }

    @Nested
    class top {
        @Test
        void top_반환() {
            Workers workers = new Workers(List.of("1", "2"));
            assertEquals(workers.top(), new Worker("1"));
        }
    }

    @Nested
    class pop {
        @Test
        void pop_확인() {
            Workers workers = new Workers(List.of("1", "2"));
            workers.pop();
            assertEquals(workers.top(), new Worker("2"));
        }
    }

    @Nested
    class pushFront {
        @Test
        void pushFront_확인() {
            Workers workers = new Workers(List.of("1", "2"));
            workers.pushFront(new Worker("3"));
            assertEquals(workers.top(), new Worker("3"));
        }
    }
}