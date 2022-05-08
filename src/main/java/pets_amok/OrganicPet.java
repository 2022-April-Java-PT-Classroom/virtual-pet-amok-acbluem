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
        waste += 5;
    }

    public void waterPet() {
        thirst += 50;
        increaseHealth();
        increaseHappiness();
        waste += 5;
    }

    public void playPet() {
        boredom += 50;
        increaseHealth();
        increaseHappiness();
    }

    public void cleanWaste() {
        increaseHealth();
        increaseHappiness();
        waste = 0;
    }

    @Override
    public void tick() {
        if (hunger <= 0) {
            hunger = 0;
            decreaseHealth();
            decreaseHappiness();
        } else if (hunger > 100) {
            hunger = 100;
            waste += 20;
        } else {
            hunger -= 10;
        }

        if (thirst <= 0) {
            thirst = 0;
            decreaseHealth();
            decreaseHappiness();
        } else if (thirst > 100) {
            thirst = 100;
            waste += 20;
        } else {
            thirst -= 10;
        }

        if (boredom <= 0) {
            boredom = 0;
            decreaseHappiness();
        } else if (boredom > 100) {
            boredom = 100;
        } else {
            boredom -= 10;
        }

        if (waste <= 0) {
            waste = 0;
        } else if (waste > 100) {
            waste = 100;
            decreaseHealth();
            decreaseHappiness();
        } else {
            waste += 5;
        }

        if (health <= 0) {
            health = 0;
            decreaseHappiness();
        } else if (health > 100) {
            health = 100;
        }
    }
}