package pets_amok;

public class OrganicDog extends OrganicPet implements Dog {
    public OrganicDog(String name, String description, int happiness, int hunger, int thirst, int boredom, int health, int waste) {
        super(name, description, happiness, hunger, thirst, boredom, health, waste);
    }

    public OrganicDog() {
        super("Doofy", "A cross-eyed spotted dog.", 100, 50, 50, 50, 100, 100);
    }

    @Override
    public void walkDog() {
        boredom += 50;
        waste -= 5;
        increaseHealth();
        increaseHappiness();
    }
}