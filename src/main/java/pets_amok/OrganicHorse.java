package pets_amok;

public class OrganicHorse extends OrganicPet implements Horse {
    public OrganicHorse(String name, String description, int happiness, int hunger, int thirst, int boredom, int health, int waste) {
        super(name, description, happiness, hunger, thirst, boredom, health, waste);
    }

    public OrganicHorse() {
        super("Run", "A brown horse ready to chase you down", 100, 50, 50, 50, 100, 0);
    }

    @Override
    public void rideHorse() {
        increaseBoredom(50);
        decreaseThirst(10);
        if (waste % 2 == 0) {
            decreaseWaste(5);
        }
        increaseHealth(20);
        increaseHappiness(30);
    }
}