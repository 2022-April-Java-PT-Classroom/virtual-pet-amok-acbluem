package pets_amok;

import java.util.HashMap;
import java.util.Map;

public class Cage {
    private Map<OrganicDog, Integer> cage = new HashMap<>();

    public Cage() {
    }

    public void addDog(OrganicDog dog) {
        cage.put(dog, dog.getWaste());
    }


    public void removeDog(String dogToRemove) {
        for (OrganicDog dog : cage.keySet()) {
            if (dogToRemove.equals(dog.getName())) {
                cage.remove(dog);
            }
        }
    }

    public void getCage() {
        System.out.println("\nCage Waste Levels:");
        System.out.printf("%-10s %-10s %n", "Name", "Waste");
        System.out.println("----------|------");

        for (OrganicDog dog : cage.keySet()) {
            System.out.printf("%-10s %-10d %n", dog.getName(), dog.getWaste());
        }
    }

    public void cleanCage() {
        for (OrganicDog dog : cage.keySet()) {
            dog.cleanWaste();
        }
    }
}
