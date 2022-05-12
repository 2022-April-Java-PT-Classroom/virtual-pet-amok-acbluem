package pets_amok;

public class OrganicDog extends OrganicPet implements Dog {
    public OrganicDog(String name, String description, int happiness, int hunger, int thirst, int boredom, int health, int waste) {
        super(name, description, happiness, hunger, thirst, boredom, health, waste);
    }

    public OrganicDog() {
        super("Doofy", "A cross-eyed spotted dog.", 100, 50, 50, 50, 100, 0);
    }

    @Override
    public void walkDog() {
        increaseBoredom(50);
        if (waste % 2 == 0) {
            decreaseWaste(5);
        }
        increaseHealth(20);
        increaseHappiness(25);
    }
}
