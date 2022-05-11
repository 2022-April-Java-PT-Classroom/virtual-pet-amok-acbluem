package pets_amok;

public class OrganicCat extends OrganicPet implements Cat {
    public OrganicCat(String name, String description, int happiness, int hunger, int thirst, int boredom, int health, int waste) {
        super(name, description, happiness, hunger, thirst, boredom, health, waste);
    }

    public OrganicCat() {
        super("Snuggles", "An evil, fluffy cat.", 50, 50, 50, 50, 100, 0);
    }

    @Override
    public void herdCat() {
        increaseBoredom(50);
        increaseHunger(10);
        increaseHealth(20);
        increaseHappiness(20);
    }
}
