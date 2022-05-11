package pets_amok;

import org.junit.jupiter.api.Test;

public class CageTest {
    OrganicDog test = new OrganicDog("Test", "Test description", 50, 50, 50, 50, 50, 50);
    Cage testCage = new Cage();

    @Test
    public void shouldAddDogToCage() {
        testCage.addDog(test);
        testCage.getCage();
    }
}
