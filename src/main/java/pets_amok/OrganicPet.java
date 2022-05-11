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
        hunger += 50;
        increaseHealth();
        increaseHappiness();
    }

    public void feedTreat() {
        hunger += 20;
        increaseHappiness();
    }

    public void waterPet() {
        thirst += 50;
        increaseHealth();
        increaseHappiness();
    }

    public void playPet() {
        boredom += 50;
        increaseHealth();
        increaseHappiness();
    }

    public void cleanWaste() {
        increaseHealth();
        increaseHappiness();
        waste = -5;
    }

    @Override
    public void tick() {
        hunger -= 10;
        thirst -= 10;
        boredom -= 10;
        waste += 5;

        if (hunger <= 0) {
            hunger = 0;
            decreaseHealth();
            decreaseHappiness();
        } else if (hunger > 100) {
            hunger = 100;
            waste += 20;
        }

        if (thirst <= 0) {
            thirst = 0;
            decreaseHealth();
            decreaseHappiness();
        } else if (thirst > 100) {
            thirst = 100;
            waste += 20;
        }

        if (boredom <= 0) {
            boredom = 0;
            decreaseHappiness();
        } else if (boredom > 100) {
            boredom = 100;
        }

        if (waste <= 0) {
            waste = 0;
        } else if (waste > 100) {
            waste = 100;
            decreaseHealth();
            decreaseHappiness();
        }

        if (health <= 0) {
            health = 0;
            decreaseHappiness();
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
