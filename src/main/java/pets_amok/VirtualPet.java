package pets_amok;

public abstract class VirtualPet {
    protected String name;
    protected String description;
    protected int happiness;
    protected int health;

    public VirtualPet(String name, String description, int happiness, int health) {
        this.name = name;
        this.description = description;
        this.happiness = happiness;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHealth() {
        return health;
    }

    public void increaseHealth(int amount) {
        health += amount;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
    }

    public void increaseHappiness(int amount) {
        happiness += amount;
    }

    public void decreaseHappiness(int amount) {
        happiness -= amount;
    }

    public abstract void tick();
}
