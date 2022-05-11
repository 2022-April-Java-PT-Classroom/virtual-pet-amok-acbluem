package pets_amok;

public class RoboticHorse extends RoboticPet implements Horse {
    public RoboticHorse(String name, String description, int happiness, int health, int oilLevel) {
        super(name, description, happiness, health, oilLevel);
    }

    public RoboticHorse() {
        super("Rocket", "An obsidian-coated horse with a mane of fire", 50, 100, 50);
    }

    @Override
    public void rideHorse() {
        oilLevel -= 20;
        increaseHappiness();
    }
}
