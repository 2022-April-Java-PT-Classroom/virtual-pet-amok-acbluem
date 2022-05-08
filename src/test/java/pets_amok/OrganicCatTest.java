package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrganicCatTest {
    OrganicCat test = new OrganicCat("Test", "Test description", 50, 50, 50, 50, 50, 50);

    @Test
    public void shouldHerdCatAndChangeStats() {
        test.herdCat();
        assertEquals(100, test.getBoredom());
        assertEquals(60, test.getHunger());
        assertEquals(55, test.getHealth());
        assertEquals(55, test.getHappiness());
    }
}
