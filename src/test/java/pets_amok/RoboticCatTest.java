package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboticCatTest {
    RoboticCat test = new RoboticCat("Test", "Test description", 50, 50, 50);

    @Test
    public void shouldHerdCatAndChangeStats() {
        test.herdCat();
        assertEquals(40, test.getOilLevel());
        assertEquals(55, test.getHealth());
        assertEquals(70, test.getHappiness());
    }
}
