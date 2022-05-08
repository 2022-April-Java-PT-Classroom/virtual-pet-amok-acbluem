package pets_amok;

public class RoboticDog extends RoboticPet implements Dog {
    public RoboticDog(String name, String description, int happiness, int health, int oilLevel) {
        super(name, description, happiness, health, oilLevel);
    }

    public RoboticDog() {
        super("Loopy", "A confused dog equipped with dangerous weapons.", 50, 100, 50);
    }

    @Override
    public void walkDog() {
        oilLevel -= 10;
        increaseHealth();
        increaseHappiness();
    }
}
