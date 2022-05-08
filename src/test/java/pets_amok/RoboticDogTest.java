package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboticDogTest {
    RoboticDog test = new RoboticDog("Test", "Test description", 50, 50, 50);

    @Test
    public void shouldWalkDogAndChangeStats() {
        test.walkDog();
        assertEquals(40, test.getOilLevel());
        assertEquals(55, test.getHealth());
        assertEquals(55, test.getHappiness());
    }
}
