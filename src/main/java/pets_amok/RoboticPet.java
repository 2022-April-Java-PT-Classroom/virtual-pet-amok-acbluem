package pets_amok;

public class RoboticPet extends VirtualPet {
    protected int oilLevel;

    public RoboticPet(String name, String description, int happiness, int health, int oilLevel) {
        super(name, description, happiness, health);
        this.oilLevel = oilLevel;
    }

    public int getOilLevel() {
        return oilLevel;
    }

    public void oilPet() {
        oilLevel += 50;
        increaseHealth();
        increaseHappiness();
    }

    public void fixPet() {
        increaseHappiness();
        health = 100;
    }

    @Override
    public void tick() {
        if (oilLevel <= 0) {
            oilLevel = 0;
            decreaseHealth();
        } else if (oilLevel > 100) {
            oilLevel = 100;
        } else {
            oilLevel -= 10;
        }

        if (health <= 0) {
            health = 0;
            decreaseHappiness();
        } else if (health > 100) {
            health = 100;
        }
    }
}
