package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboticPetTest {
    RoboticPet test = new RoboticPet("Test", "Test description", 50, 50, 50);

    @Test
    public void shouldGetOilLevel() {
        assertEquals(50, test.getOilLevel());
    }

    @Test
    public void shouldOilPet() {
        test.oilPet();
        assertEquals(150, test.getOilLevel());
    }

    @Test
    public void shouldFixPet() {
        test.fixPet();
        assertEquals(100, test.getHealth());
    }

    @Test
    public void shouldChangeStats() {
        test.tick();
        System.out.println("Happiness: " + test.getHappiness());
        System.out.println("Health: " + test.getHealth());
        System.out.println("Oil Level: " + test.getOilLevel());
    }

    @Test
    public void shouldDecreaseHealthIfOilIs0() {
        test.tick();
        test.tick();
        test.tick();
        test.tick();
        test.tick();
        test.tick();
        assertEquals(40, test.getHealth());
    }
}
