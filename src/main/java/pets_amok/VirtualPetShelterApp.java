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
                    System.out.println("Select a treat option:");
                    System.out.println("Meat");
                    System.out.println("Hay");

                    userInput.nextLine();
                    String treat = userInput.nextLine();

                    System.out.println("Which pet would you like to give a treat?");
                    System.out.println("Please type the name exactly as it appears.");

                    String pet = userInput.nextLine();

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

                shelter.tick();
            } else if (userChoice == 5) {
                System.out.println("Which of the following are you surrendering today?");
                System.out.println("1. Cat");
                System.out.println("2. Dog");
                System.out.println("3. Horse");

                int selection = userInput.nextInt();

                if (selection == 1) {
                    System.out.println("Are you surrendering an organic or robotic cat?");
                    System.out.println("1. Organic");
                    System.out.println("2. Robotic");

                    int type = userInput.nextInt();

                    if (type == 1) {
                        OrganicCat newOrganicCat;
                        System.out.println("Please enter the following details to surrender an organic cat:");
                        System.out.println("(alternatively, you may hit enter to surrender the default organic cat)\n");
                        System.out.println("Name:");

                        userInput.nextLine();
                        String petName = userInput.nextLine();

                        if (petName.equals("")) {
                            newOrganicCat = new OrganicCat();
                        } else {
                            System.out.println("Description:");
                            String petDescription = userInput.nextLine();

                            System.out.println("Happiness (number):");
                            int petHappiness = userInput.nextInt();

                            System.out.println("Hunger Level (number):");
                            int petHunger = userInput.nextInt();

                            System.out.println("Thirst Level (number):");
                            int petThirst = userInput.nextInt();
                            userInput.nextLine();

                            System.out.println("Boredom Level (number):");
                            int petBoredom = userInput.nextInt();

                            System.out.println("Health Level (number):");
                            int petHealth = userInput.nextInt();

                            System.out.println("Waste Level (number)");
                            int petWaste = userInput.nextInt();
                            userInput.nextLine();

                            newOrganicCat = new OrganicCat(petName, petDescription, petHappiness, petHunger, petThirst, petBoredom, petHealth, petWaste);
                        }

                        shelter.addPet(newOrganicCat);
                        litterBox.addCat((newOrganicCat));
                    } else if (type == 2) {
                        RoboticCat newRoboticCat;

                        System.out.println("Please enter the following details to surrender a robotic cat:");
                        System.out.println("(alternatively, you may hit enter to surrender the default organic cat)\n");
                        System.out.println("Name:");

                        userInput.nextLine();
                        String petName = userInput.nextLine();

                        if (petName.equals("")) {
                            newRoboticCat = new RoboticCat();
                        } else {
                            System.out.println("Description:");
                            String petDescription = userInput.nextLine();

                            System.out.println("Happiness (number):");
                            int petHappiness = userInput.nextInt();

                            System.out.println("Health Level (number):");
                            int petHealth = userInput.nextInt();

                            System.out.println("Oil Level (number)");
                            int petOilLevel = userInput.nextInt();
                            userInput.nextLine();

                            newRoboticCat = new RoboticCat(petName, petDescription, petHappiness, petHealth, petOilLevel);
                        }

                        shelter.addPet(newRoboticCat);
                    } else {
                        System.out.println(errorMessage);
                    }
                } else if (selection == 2) {
                    System.out.println("Are you surrendering an organic or robotic dog?");
                    System.out.println("1. Organic");
                    System.out.println("2. Robotic");

                    int type = userInput.nextInt();

                    if (type == 1) {
                        OrganicDog newOrganicDog;

                        System.out.println("Please enter the following details to surrender an organic dog:");
                        System.out.println("(alternatively, you may hit enter to surrender the default organic dog)\n");
                        System.out.println("Name:");

                        userInput.nextLine();
                        String petName = userInput.nextLine();

                        if (petName.equals("")) {
                            newOrganicDog = new OrganicDog();
                        } else {
                            System.out.println("Description:");
                            String petDescription = userInput.nextLine();

                            System.out.println("Happiness (number):");
                            int petHappiness = userInput.nextInt();

                            System.out.println("Hunger Level (number):");
                            int petHunger = userInput.nextInt();

                            System.out.println("Thirst Level (number):");
                            int petThirst = userInput.nextInt();
                            userInput.nextLine();

                            System.out.println("Boredom Level (number):");
                            int petBoredom = userInput.nextInt();

                            System.out.println("Health Level (number):");
                            int petHealth = userInput.nextInt();

                            System.out.println("Waste Level (number)");
                            int petWaste = userInput.nextInt();
                            userInput.nextLine();

                            newOrganicDog = new OrganicDog(petName, petDescription, petHappiness, petHunger, petThirst, petBoredom, petHealth, petWaste);
                        }

                        shelter.addPet(newOrganicDog);
                        cage.addDog(newOrganicDog);
                    } else if (type == 2) {
                        RoboticDog newRoboticDog;

                        System.out.println("Please enter the following details to surrender a robotic dog:");
                        System.out.println("(alternatively, you may hit enter to surrender the default organic dog)\n");
                        System.out.println("Name:");

                        userInput.nextLine();
                        String petName = userInput.nextLine();

                        if (petName.equals("")) {
                            newRoboticDog = new RoboticDog();
                        } else {
                            System.out.println("Description:");
                            String petDescription = userInput.nextLine();

                            System.out.println("Happiness (number):");
                            int petHappiness = userInput.nextInt();

                            System.out.println("Health Level (number):");
                            int petHealth = userInput.nextInt();

                            System.out.println("Oil Level (number)");
                            int petOilLevel = userInput.nextInt();
                            userInput.nextLine();

                            newRoboticDog = new RoboticDog(petName, petDescription, petHappiness, petHealth, petOilLevel);
                        }

                        shelter.addPet(newRoboticDog);
                    } else {
                        System.out.println(errorMessage);
                    }
                } else if (selection == 3) {
                    System.out.println("Are you surrendering an organic or robotic horse?");
                    System.out.println("1. Organic");
                    System.out.println("2. Robotic");

                    int type = userInput.nextInt();

                    if (type == 1) {
                        OrganicHorse newOrganicHorse;

                        System.out.println("Please enter the following details to surrender an organic horse:");
                        System.out.println("(alternatively, you may hit enter to surrender the default organic horse)\n");
                        System.out.println("Name:");

                        userInput.nextLine();
                        String petName = userInput.nextLine();

                        if (petName.equals("")) {
                            newOrganicHorse = new OrganicHorse();
                        } else {
                            System.out.println("Description:");
                            String petDescription = userInput.nextLine();

                            System.out.println("Happiness (number):");
                            int petHappiness = userInput.nextInt();

                            System.out.println("Hunger Level (number):");
                            int petHunger = userInput.nextInt();

                            System.out.println("Thirst Level (number):");
                            int petThirst = userInput.nextInt();
                            userInput.nextLine();

                            System.out.println("Boredom Level (number):");
                            int petBoredom = userInput.nextInt();

                            System.out.println("Health Level (number):");
                            int petHealth = userInput.nextInt();

                            System.out.println("Waste Level (number)");
                            int petWaste = userInput.nextInt();
                            userInput.nextLine();

                            newOrganicHorse = new OrganicHorse(petName, petDescription, petHappiness, petHunger, petThirst, petBoredom, petHealth, petWaste);
                        }

                        shelter.addPet(newOrganicHorse);
                        stable.addHorse(newOrganicHorse);
                    } else if (type == 2) {
                        RoboticHorse newRoboticHorse;

                        System.out.println("Please enter the following details to surrender a robotic horse:");
                        System.out.println("(alternatively, you may hit enter to surrender the default organic horse)\n");
                        System.out.println("Name:");

                        userInput.nextLine();
                        String petName = userInput.nextLine();

                        if (petName.equals("")) {
                            newRoboticHorse = new RoboticHorse();
                        } else {
                            System.out.println("Description:");
                            String petDescription = userInput.nextLine();

                            System.out.println("Happiness (number):");
                            int petHappiness = userInput.nextInt();

                            System.out.println("Health Level (number):");
                            int petHealth = userInput.nextInt();

                            System.out.println("Oil Level (number)");
                            int petOilLevel = userInput.nextInt();
                            userInput.nextLine();

                            newRoboticHorse = new RoboticHorse(petName, petDescription, petHappiness, petHealth, petOilLevel);
                        }

                        shelter.addPet(newRoboticHorse);
                    } else {
                        System.out.println(errorMessage);
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
