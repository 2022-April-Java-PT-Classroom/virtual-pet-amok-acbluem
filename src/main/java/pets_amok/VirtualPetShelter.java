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
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %n", "Name", "Hunger", "Thirst", "Boredom", "Health", "Oil Level", "Happiness");
        System.out.println("----------|----------------------------------------------------------------");

        for (VirtualPet pet : shelter.values()) {
            if (pet instanceof OrganicPet) {
                System.out.format("%-10s %-10d %-10d %-10d %-10d %-10s %-10d %n",
                        pet.getName(), ((OrganicPet) pet).getHunger(), ((OrganicPet) pet).getThirst(),
                        ((OrganicPet) pet).getBoredom(), pet.getHealth(),
                        "X", pet.getHappiness());
            } else if (pet instanceof RoboticPet) {
                System.out.format("%-10s %-10s %-10s %-10s %-10d %-10s %-10d %n",
                        pet.getName(), "X", "X", "X", pet.getHealth(),
                        ((RoboticPet) pet).getOilLevel(), pet.getHappiness());
            }
        }
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
        System.out.println("\nPet names and descriptions:");
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

    public void giveTreat(String petChoice, String treat) {
        for (VirtualPet pet : shelter.values()) {
            if (petChoice.equals(pet.getName())) {
                if (pet instanceof OrganicCat || pet instanceof OrganicDog) {
                    if (treat.equals("Meat")) {
                        ((OrganicPet) pet).feedTreat();
                    } else if (treat.equals("Hay")) {
                        pet.decreaseHappiness(50);
                        System.out.println("Hay, that's not cool. This pet is not happy with this treat.\n");
                    }
                } else if (pet instanceof OrganicHorse) {
                    if (treat.equals("Hay")) {
                        ((OrganicPet) pet).feedTreat();
                    } else if (treat.equals("Meat")) {
                        pet.decreaseHappiness(50);
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

    public void tick() {
        for (VirtualPet pet : shelter.values()) {
            pet.tick();
        }
    }
}
