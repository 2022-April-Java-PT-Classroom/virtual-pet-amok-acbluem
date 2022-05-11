package pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
    private Map<String, VirtualPet> shelter = new HashMap<>();

    public VirtualPetShelter() {
    }

    public void addPet(VirtualPet pet) {
        shelter.put(pet.getName(), pet);
    }

    public Collection<VirtualPet> getPets() {
        return shelter.values();
    }

    public VirtualPet getPet(VirtualPet pet) {
        return shelter.get(pet);
    }

    public void getShelter() {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n", "Name", "Hunger", "Thirst", "Boredom", "Health", "Waste", "Oil Level", "Happiness");
        System.out.println("----------|----------------------------------------------------------------------------");

        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicPet) {
                System.out.format("%-10s %-10d %-10d %-10d %-10d %-10d %-10s %-10d %n",
                        pet.getName(), ((OrganicPet) pet).getHunger(), ((OrganicPet) pet).getThirst(),
                        ((OrganicPet) pet).getBoredom(), pet.getHealth(), ((OrganicPet) pet).getWaste(),
                        "X", pet.getHappiness());
            } else if (pet instanceof RoboticPet) {
                System.out.format("%-10s %-10s %-10s %-10s %-10d %-10s %-10d %-10d %n",
                        pet.getName(), "X", "X", "X", pet.getHealth(), "X",
                        ((RoboticPet) pet).getOilLevel(), pet.getHappiness());
            }
        }

        System.out.println("\nCage Waste Status: " + cage() + "% filled.");
        System.out.println("Litter Box Status: " + litterBox() + "% filled.");
        System.out.println("Stable Status: " + stable() + "% filled.");
    }

    public void adoptPet(String choice) {
        for (VirtualPet pet : shelter.values()) {
            if (choice.equals(pet.getName())) {
                shelter.remove(pet.getName(), pet);

                break;
            }
        }
    }

    public void getPetNamesAndDescriptions() {
        for (VirtualPet pet : shelter.values()) {
            System.out.println(pet.getName() + ": " + pet.getDescription());
        }
    }

    public void feedPets() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).feedPet();
            }
        }
    }

    public void waterPets() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).waterPet();
            }
        }
    }

    public void oilPets() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof RoboticPet) {
                ((RoboticPet) pet).oilPet();
            }
        }
    }

    public void fixPets() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof RoboticPet) {
                ((RoboticPet) pet).fixPet();
            }
        }
    }

    public void walkDogs() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicDog) {
                ((OrganicDog) pet).walkDog();
            }

            if (pet instanceof RoboticDog) {
                ((RoboticDog) pet).walkDog();
            }
        }
    }

    public void herdCats() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicCat) {
                ((OrganicCat) pet).herdCat();
            }

            if (pet instanceof RoboticCat) {
                ((RoboticCat) pet).herdCat();
            }
        }
    }

    public void rideHorses() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicHorse) {
                ((OrganicHorse) pet).rideHorse();
            }

            if (pet instanceof RoboticHorse) {
                ((RoboticHorse) pet).rideHorse();
            }
        }
    }

    public void entertainPet(String choice) {
        for (VirtualPet pet : shelter.values()) {
            if (choice.equals(pet.getName()) && pet instanceof OrganicPet) {
                ((OrganicPet) pet).playPet();
            }
        }
    }

    public void giveTreat(String choice, String treat) {
        for (VirtualPet pet : shelter.values()) {
            if (choice.equals(pet.getName())) {
                if (pet instanceof OrganicCat || pet instanceof OrganicDog) {
                    if (treat.equals("Meat")) {
                        ((OrganicPet) pet).feedTreat();
                    } else if (treat.equals("Hay")) {
                        pet.decreaseHappiness();
                        System.out.println("Hay, that's not cool. This pet is not happy with this treat.\n");
                    }
                } else if (pet instanceof OrganicHorse) {
                    if (treat.equals("Hay")) {
                        ((OrganicPet) pet).feedTreat();
                    } else if (treat.equals("Meat")) {
                        pet.decreaseHappiness();
                        System.out.println("This pet never wants to meat you again. This pet is not happy with this treat.\n");
                    }
                } else {
                    System.out.println("Sorry, we don't have this treat in stock.\n");
                }
            } else {
                System.out.println("This pet doesn't know what to do with this treat.\n");
            }
        }
    }

    public int cage() {
        int cageWaste = 0;

        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicDog) {
                cageWaste += ((OrganicDog) pet).getWaste();
            }
        }

        if (cageWaste > 100) {
            cageWaste = 100;
        } else if (cageWaste < 0) {
            cageWaste = 0;
        }

        if (cageWaste == 100) {
            for (VirtualPet pet : shelter.values()) {
                if (pet instanceof OrganicDog) {
                    pet.decreaseHealth();
                    pet.decreaseHappiness();
                }
            }
        }

        return cageWaste;
    }

    public int litterBox() {
        int litterBoxWaste = 0;

        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicCat) {
                litterBoxWaste += ((OrganicCat) pet).getWaste();
            }
        }

        if (litterBoxWaste > 100) {
            litterBoxWaste = 100;
        } else if (litterBoxWaste < 0) {
            litterBoxWaste = 0;
        }

        if (litterBoxWaste == 100) {
            for (VirtualPet pet : shelter.values()) {
                if (pet instanceof OrganicCat) {
                    pet.decreaseHealth();
                    pet.decreaseHappiness();
                }
            }
        }

        return litterBoxWaste;
    }

    public int stable() {
        int stableWaste = 0;

        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicHorse) {
                stableWaste += ((OrganicHorse) pet).getWaste();
            }
        }

        if (stableWaste > 100) {
            stableWaste = 100;
        } else if (stableWaste < 0) {
            stableWaste = 0;
        }

        if (stableWaste == 100) {
            for (VirtualPet pet : shelter.values()) {
                if (pet instanceof OrganicCat) {
                    pet.decreaseHealth();
                    pet.decreaseHappiness();
                }
            }
        }

        return stableWaste;
    }

    public void cleanCages() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicDog) {
                ((OrganicDog) pet).cleanWaste();
            }
        }
    }

    public void cleanLitterBox() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicCat) {
                ((OrganicCat) pet).cleanWaste();
            }
        }
    }

    public void cleanStable() {
        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicHorse) {
                ((OrganicHorse) pet).cleanWaste();
            }
        }
    }

    public void tick() {
        for (VirtualPet pet : shelter.values()) {
            pet.tick();
        }
    }
}
