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
        boredom += 50;
        thirst -= 10;
        if (waste % 10 == 0) {
            waste -= 5;
        }
        increaseHealth();
        increaseHappiness();
    }
}