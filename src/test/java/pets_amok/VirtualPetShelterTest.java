package pets_amok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetShelterTest {
    VirtualPetShelter shelter = new VirtualPetShelter();

    OrganicCat testOrganicCat = new OrganicCat("Test OC", "Test OrganicCat description", 50, 50, 50, 50, 50, 50);
    RoboticCat testRoboticCat = new RoboticCat("Test RC", "Test RoboticCat description", 50, 50, 50);
    OrganicDog testOrganicDog = new OrganicDog("Test OD", "Test OrganicDog description", 50, 50, 50, 50, 50, 50);
    RoboticDog testRoboticDog = new RoboticDog("Test RD", "Test RoboticDog description", 50, 50, 50);

    @Test
    public void shouldAddAllPetsAndGetShelter() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.getShelter();
    }

    @Test
    public void shouldAdoptPet() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.getShelter();
        shelter.adoptPet("Test OC");
        shelter.getShelter();
    }

    @Test
    public void shouldGetPetNamesAndDescriptions() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.getPetNamesAndDescriptions();
    }

    @Test
    public void shouldFeedAllOrganicPets() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.feedPets();

        assertEquals(100, testOrganicCat.getHunger());
        assertEquals(100, testOrganicDog.getHunger());
    }

    @Test
    public void shouldWaterAllOrganicPets() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.waterPets();

        assertEquals(100, testOrganicCat.getThirst());
        assertEquals(100, testOrganicDog.getThirst());
    }

    @Test
    public void shouldPlayWithOnePet() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.entertainPet("Test OD");

        assertEquals(100, testOrganicDog.getBoredom());
        assertEquals(50, testOrganicCat.getBoredom());
    }

    @Test
    public void shouldOilAllRoboticPets() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.oilPets();

        assertEquals(100, testRoboticCat.getOilLevel());
        assertEquals(100, testRoboticDog.getOilLevel());
    }

    @Test
    public void shouldFixAllRoboticPets() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.fixPets();

        assertEquals(100, testRoboticCat.getHealth());
        assertEquals(100, testRoboticDog.getHealth());
    }

    @Test
    public void shouldWalkAllDogs() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.walkDogs();

        assertEquals(100, testOrganicDog.getBoredom());
        assertEquals(45, testOrganicDog.getWaste());

        assertEquals(40, testRoboticDog.getOilLevel());
    }

    @Test
    public void shouldHerdAllCats() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.herdCats();

        assertEquals(100, testOrganicCat.getBoredom());
        assertEquals(60, testOrganicCat.getHunger());

        assertEquals(40, testRoboticCat.getOilLevel());
    }

    @Test
    public void shouldChangeStats() {
        shelter.addPet(testOrganicCat);
        shelter.addPet(testRoboticCat);
        shelter.addPet(testOrganicDog);
        shelter.addPet(testRoboticDog);
        shelter.getShelter();
        shelter.tick();
        shelter.getShelter();
    }
}
