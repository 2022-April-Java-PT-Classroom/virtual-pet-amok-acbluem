package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganicPetTest {
    OrganicPet test = new OrganicPet("Test", "Test description", 50, 50, 50, 50, 50, 50);

    @Test
    public void shouldGetHungerOf50() {
        assertEquals(50, test.getHunger());
    }

    @Test
    public void shouldGetThirstOf50() {
        assertEquals(50, test.getThirst());
    }

    @Test
    public void shouldGetBoredomOf50() {
        assertEquals(50, test.getBoredom());
    }

    @Test
    public void shouldGetWasteOf50() {
        assertEquals(50, test.getWaste());
    }

    @Test
    public void shouldFeedPetAndIncreaseHungerAndHealthAndHappinessAndWasteStats() {
        test.feedPet();
        assertEquals(100, test.getHunger());
        assertEquals(70, test.getHealth());
        assertEquals(60, test.getHappiness());
        assertEquals(50, test.getWaste());
    }

    @Test
    public void shouldWaterPetAndIncreaseThirstAndHealthAndHappinessAndWasteStats() {
        test.waterPet();
        assertEquals(100, test.getThirst());
        assertEquals(70, test.getHealth());
        assertEquals(60, test.getHappiness());
        assertEquals(50, test.getWaste());
    }

    @Test
    public void shouldPlayWithPetAndIncreaseBoredomAndHealthAndHappiness() {
        test.playPet();
        assertEquals(100, test.getBoredom());
        assertEquals(50, test.getHealth());
        assertEquals(70, test.getHappiness());
    }

    @Test
    public void shouldCleanAllWasteOnPet() {
        test.cleanWaste();
        assertEquals(-5, test.getWaste());
    }

    @Test
    public void shouldChangeStats() {
        test.tick();
        System.out.println("Happiness: " + test.getHappiness());
        System.out.println("Hunger: " + test.getHunger());
        System.out.println("Thirst: " + test.getThirst());
        System.out.println("Boredom: " + test.getBoredom());
        System.out.println("Health: " + test.getHealth());
        System.out.println("Waste: " + test.getWaste());
    }

    @Test
    public void shouldIncreaseWasteChangeWhenOverfed() {
        test.feedPet();
        test.feedPet();
        test.tick();
        assertEquals(75, test.getWaste());
    }

    @Test
    public void shouldStayAt100WhenStatGoesOver100() {
        test.waterPet();
        test.waterPet();
        test.tick();
        assertEquals(100, test.getThirst());
    }
}
