package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganicDogTest {
    OrganicDog test = new OrganicDog("Test", "Test description", 50, 50, 50, 50, 50, 50);

    @Test
    public void shouldWalkDogAndChangeStats() {
        test.walkDog();
        assertEquals(100, test.getBoredom());
        assertEquals(45, test.getWaste());
        assertEquals(70, test.getHealth());
        assertEquals(75, test.getHappiness());
    }

}
