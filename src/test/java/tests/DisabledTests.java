package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisabledTests {

    @Disabled
    @Test
    void disabled1Test() {
        assertTrue(false);
    }

    @Disabled
    @Test
    void disabled2Test() {
        assertTrue(false);
    }

    @Disabled
    @Test
    void disabled3Test() {
        assertTrue(false);
    }

}
