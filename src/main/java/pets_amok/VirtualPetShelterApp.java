package pets_amok;

import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        VirtualPetShelter shelter = new VirtualPetShelter();
        Cage cage = new Cage();
        LitterBox litterBox = new LitterBox();
        Stable stable = new Stable();

        OrganicCat mrWiggles = new OrganicCat("Mr Wiggles", "A perpetually-drooling long-haired cat", 60, 70, 40, 90, 50, 80);
        RoboticCat doom = new RoboticCat("Doom", "A copper cat that's totally not planning to take over the world", 50, 100, 80);
        OrganicDog bubbles = new OrganicDog("Bubbles", "A very burpy but lovable poodle", 20, 30, 40, 50, 60, 70);
        RoboticDog tank = new RoboticDog("Tank", "A shiny dog with a heart of gold... literally", 30, 40, 50);
        OrganicHorse peanut = new OrganicHorse("Peanut", "A younger paint horse but full of spirit", 80, 60, 30, 30, 40, 50);
        RoboticHorse reaper = new RoboticHorse("Reaper", "A horse with a body and guts of steel", 20, 40, 50);

        shelter.addPet(mrWiggles);
        shelter.addPet(doom);
        shelter.addPet(bubbles);
        shelter.addPet(tank);
        shelter.addPet(peanut);
        shelter.addPet(reaper);

        cage.addDog(bubbles);
        litterBox.addCat(mrWiggles);
        stable.addHorse(peanut);


        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("\n");

        String errorMessage = "Sorry, something went wrong. Please try again.";

        System.out.println("Welcome to the shelter!");
        System.out.println("Here are the current pets in the shelter:\n");

        int userChoice;

        do {
            shelter.getShelter();
            cage.getCage();
            litterBox.getLitterBox();
            stable.getStable();

            shelter.getPetNamesAndDescriptions();

            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Tend to multiple pets.");
            System.out.println("2. Tend to one pet.");
            System.out.println("3. Clean the shelter.");
            System.out.println("4. Adopt a pet.");
            System.out.println("5. Surrender a pet.");
            System.out.println("6. Exit the shelter.");

            userChoice = userInput.nextInt();

            if (userChoice == 1) {
                System.out.println("What would you like to do?");
                System.out.println("1. Feed all organic pets.");
                System.out.println("2. Water all organic pets.");
                System.out.println("3. Oil all robotic pets.");
                System.out.println("4. Fix all robotic pets.");
                System.out.println("5. Walk all dogs.");
                System.out.println("6. Herd all cats.");
                System.out.println("7. Ride all the horses.");

                int selection = userInput.nextInt();

                if (selection == 1) {
                    shelter.feedPets();
                    System.out.println("You feed all the organic pets.\n");
                } else if (selection == 2) {
                    shelter.waterPets();
                    System.out.println("You water all the pets.\n");
                } else if (selection == 3) {
                    shelter.oilPets();
                    System.out.println("You oil all the robotic pets.\n");
                } else if (selection == 4) {
                    shelter.fixPets();
                    System.out.println("You fix all the robotic pets.\n");
                } else if (selection == 5) {
                    shelter.walkDogs();
                    System.out.println("You walk all the dogs.\n");
                } else if (selection == 6) {
                    shelter.herdCats();
                    System.out.println("You somehow manage to herd all the cats.\n");
                } else if (selection == 7) {
                    shelter.rideHorses();
                    System.out.println("Your bum hurts, but you ride all the horses.\n");
                } else {
                    System.out.println(errorMessage);
                }
                shelter.tick();
            } else if (userChoice == 2) {
                System.out.println("What would you like to do?");
                System.out.println("1. Play with a pet.");
                System.out.println("2. Give a pet a treat.");

                int selection = userInput.nextInt();

                if (selection == 1) {
                    System.out.println("Which pet would you like to play with?");

                    shelter.getPetNamesAndDescriptions();

                    String pet = userInput.next();

                    shelter.entertainPet(pet);
                } else if (selection == 2) {
                    System.out.println("Which pet would you like to give a treat?");
                    System.out.println("Please type the name exactly as it appears.");

                    userInput.nextLine();
                    String pet = userInput.nextLine();

                    System.out.println("Choose a treat option:");
                    System.out.println("1. Meat");
                    System.out.println("2. Hay");

                    int treatChoice = userInput.nextInt();
                    String treat = "";

                    if (treatChoice == 1) {
                        treat = "Meat";
                    } else if (treatChoice == 2) {
                        treat = "Hay";
                    }

                    shelter.giveTreat(pet, treat);
                }

                shelter.tick();
            } else if (userChoice == 3) {
                System.out.println("Would you like to clean the cages or the litter box?");
                System.out.println("1. Cages");
                System.out.println("2. Litter Box");
                System.out.println("3. Stable");

                int selection = userInput.nextInt();

                if (selection == 1) {
                    cage.cleanCage();
                } else if (selection == 2) {
                    litterBox.cleanLitterBox();
                } else if (selection == 3) {
                    stable.cleanStable();
                } else {
                    System.out.println(errorMessage);
                }

                shelter.tick();
            } else if (userChoice == 4) {
                System.out.println("Which pet would you like to adopt?");
                shelter.getPetNamesAndDescriptions();

                userInput.nextLine();
                String petChoice = userInput.nextLine();

                shelter.adoptPet(petChoice);

                cage.removeDog(petChoice);
                litterBox.removeCat(petChoice);
                stable.removeHorse(petChoice);

                shelter.tick();
            } else if (userChoice == 5) {
                System.out.println("Which of the following are you surrendering today?");
                System.out.println("1. Cat");
                System.out.println("2. Dog");
                System.out.println("3. Horse");
                int species = userInput.nextInt();

                System.out.println("Are you surrendering an organic or robotic cat?");
                System.out.println("1. Organic");
                System.out.println("2. Robotic");
                int type = userInput.nextInt();

                System.out.println("Name (or hit enter for a default pet):");
                userInput.nextLine();
                String petName = userInput.nextLine();

                if (petName.equals("")) {
                    if (type == 1) {
                        if (species == 1) {
                            OrganicCat newOrganicCat = new OrganicCat();
                            shelter.addPet(newOrganicCat);
                            litterBox.addCat(newOrganicCat);
                        } else if (species == 2) {
                            OrganicDog newOrganicDog = new OrganicDog();
                            shelter.addPet(newOrganicDog);
                            cage.addDog(newOrganicDog);
                        } else if (species == 3) {
                            OrganicHorse newOrganicHorse = new OrganicHorse();
                            shelter.addPet(newOrganicHorse);
                            stable.addHorse(newOrganicHorse);
                        }
                    } else if (type == 2) {
                        if (species == 1) {
                            RoboticCat newRoboticCat = new RoboticCat();
                            shelter.addPet(newRoboticCat);
                        } else if (species == 2) {
                            RoboticDog newRoboticDog = new RoboticDog();
                            shelter.addPet(newRoboticDog);
                        } else if (species == 3) {
                            RoboticHorse newRoboticHorse = new RoboticHorse();
                            shelter.addPet(newRoboticHorse);
                        }
                    }
                } else {
                    System.out.println("Description:");
                    String petDescription = userInput.nextLine();

                    System.out.println("Happiness (number):");
                    int petHappiness = userInput.nextInt();

                    System.out.println("Health Level (number):");
                    int petHealth = userInput.nextInt();

                    if (type == 1) {
                        System.out.println("Hunger Level (number):");
                        int petHunger = userInput.nextInt();

                        System.out.println("Thirst Level (number):");
                        int petThirst = userInput.nextInt();

                        System.out.println("Boredom Level (number):");
                        int petBoredom = userInput.nextInt();

                        System.out.println("Waste Level (number):");
                        int petWaste = userInput.nextInt();
                        userInput.nextLine();

                        if (species == 1) {
                            OrganicCat newOrganicCat = new OrganicCat(petName, petDescription, petHappiness, petHunger, petThirst, petBoredom, petHealth, petWaste);
                            shelter.addPet(newOrganicCat);
                            litterBox.addCat(newOrganicCat);
                        } else if (species == 2) {
                            OrganicDog newOrganicDog = new OrganicDog(petName, petDescription, petHappiness, petHunger, petThirst, petBoredom, petHealth, petWaste);
                            shelter.addPet(newOrganicDog);
                            cage.addDog(newOrganicDog);
                        } else if (species == 3) {
                            OrganicHorse newOrganicHorse = new OrganicHorse(petName, petDescription, petHappiness, petHunger, petThirst, petBoredom, petHealth, petWaste);
                            shelter.addPet(newOrganicHorse);
                            stable.addHorse(newOrganicHorse);
                        } else {
                            System.out.println("We do not allow this organic species here.");
                        }
                    } else if (type == 2) {
                        System.out.println("Oil Level (number)");
                        int petOilLevel = userInput.nextInt();

                        if (species == 1) {
                            RoboticCat newRoboticCat = new RoboticCat(petName, petDescription, petHappiness, petHealth, petOilLevel);
                            shelter.addPet(newRoboticCat);
                        } else if (species == 2) {
                            RoboticDog newRoboticDog = new RoboticDog(petName, petDescription, petHappiness, petHealth, petOilLevel);
                            shelter.addPet(newRoboticDog);
                        } else if (species == 3) {
                            RoboticHorse newRoboticHorse = new RoboticHorse(petName, petDescription, petHappiness, petHealth, petOilLevel);
                            shelter.addPet(newRoboticHorse);
                        } else {
                            System.out.println("We do not allow this robotic species here.");
                        }
                    } else {
                        System.out.println("We do not allow this type here.");
                    }
                }
                shelter.tick();
            } else if (userChoice == 6) {
                System.out.println("Goodbye!");
            } else {
                System.out.println(errorMessage);
            }
        }
        while (userChoice != 6);
    }
}
