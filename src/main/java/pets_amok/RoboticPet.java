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
        increaseOilLevel(50);
        increaseHealth(5);
        increaseHappiness(5);
    }

    public void fixPet() {
        health = 100;
    }

    public void increaseOilLevel(int amount) {
        oilLevel += amount;
    }

    public void decreaseOilLevel(int amount) {
        oilLevel -= amount;
    }

    @Override
    public void tick() {
        decreaseOilLevel(10);

        if (oilLevel <= 0) {
            oilLevel = 0;
            decreaseHealth(5);
        } else if (oilLevel > 100) {
            oilLevel = 100;
            decreaseHealth(10);
        }

        if (health <= 0) {
            health = 0;
            decreaseHappiness(5);
        } else if (health > 100) {
            health = 100;
        }

        if (happiness < 0) {
            happiness = 0;
        } else if (happiness > 100) {
            happiness = 100;
        }
    }
}
