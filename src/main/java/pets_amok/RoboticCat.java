package pets_amok;

public class RoboticCat extends RoboticPet implements Cat {
    public RoboticCat(String name, String description, int happiness, int health, int oilLevel) {
        super(name, description, happiness, health, oilLevel);
    }

    public RoboticCat() {
        super("Mr Doodles", "A metallic cat with a permanent angry face.", 50, 100, 50);
    }

    @Override
    public void herdCat() {
        oilLevel -= 10;
        increaseHealth();
        increaseHappiness();
    }
}
