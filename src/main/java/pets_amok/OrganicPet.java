package pets_amok;

public class OrganicPet extends VirtualPet {
    protected int hunger;
    protected int thirst;
    protected int waste;
    protected int boredom;

    public OrganicPet(String name, String description, int happiness, int hunger, int thirst, int boredom, int health, int waste) {
        super(name, description, happiness, health);
        this.hunger = hunger;
        this.thirst = thirst;
        this.boredom = boredom;
        this.waste = waste;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getWaste() {
        return waste;
    }

    public void feedPet() {
        increaseHunger(100);
        increaseHealth(20);
        increaseHappiness(20);
    }

    public void feedTreat() {
        increaseHunger(50);
        increaseHappiness(50);
    }

    public void waterPet() {
        increaseThirst(100);
        increaseHealth(20);
        increaseHappiness(20);
    }

    public void playPet() {
        increaseBoredom(100);
        increaseHappiness(20);
    }

    public void cleanWaste() {
        increaseHealth(50);
        increaseHappiness(20);
        waste = -5;
    }

    public void increaseHunger(int amount) {
        hunger += amount;
    }

    public void increaseThirst(int amount) {
        thirst += amount;
    }

    public void increaseBoredom(int amount) {
        boredom += amount;
    }

    public void decreaseWaste(int amount) {
        waste -= amount;
    }

    public void decreaseHunger(int amount) {
        hunger -= amount;
    }

    public void decreaseThirst(int amount) {
        thirst -= amount;
    }

    public void decreaseBoredom(int amount) {
        boredom -= amount;
    }

    public void increaseWaste(int amount) {
        waste += amount;
    }

    @Override
    public void tick() {
        decreaseHunger(10);
        decreaseThirst(10);
        decreaseBoredom(10);
        increaseWaste(5);

        if (hunger <= 0) {
            hunger = 0;
            decreaseHealth(5);
            decreaseHappiness(5);
        } else if (hunger > 100) {
            hunger = 100;
            increaseWaste(20);
        }

        if (thirst <= 0) {
            thirst = 0;
            decreaseHealth(5);
            decreaseHappiness(5);
        } else if (thirst > 100) {
            thirst = 100;
            increaseWaste(20);
        }

        if (boredom <= 0) {
            boredom = 0;
            decreaseHappiness(10);
        } else if (boredom > 100) {
            boredom = 100;
        }

        if (waste <= 0) {
            waste = 0;
        } else if (waste > 100) {
            waste = 100;
            decreaseHealth(20);
            decreaseHappiness(20);
        }

        if (health <= 0) {
            health = 0;
            decreaseHappiness(10);
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
