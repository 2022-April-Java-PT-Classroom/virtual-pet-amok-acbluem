package pets_amok;

import java.util.HashMap;
import java.util.Map;

public class Stable {
    private Map<OrganicHorse, Integer> stable = new HashMap<>();

    public Stable() {
    }

    public void addHorse(OrganicHorse horse) {
        stable.put(horse, horse.getWaste());
    }

    public void removeHorse(String horseToRemove) {
        for (OrganicHorse horse : stable.keySet()) {
            if (horseToRemove.equals(horse.getName())) {
                stable.remove(horse);
            }
        }
    }

    public void getStable() {
        System.out.println("\nStable Waste Levels:");
        System.out.printf("%-10s %-10s %n", "Name", "Waste");
        System.out.println("----------|------");

        for (OrganicHorse horse : stable.keySet()) {
            System.out.printf("%-10s %-10d %n", horse.getName(), horse.getWaste());
        }
    }

    public void cleanStable() {
        for (OrganicHorse horse : stable.keySet()) {
            horse.cleanWaste();
        }
    }
}