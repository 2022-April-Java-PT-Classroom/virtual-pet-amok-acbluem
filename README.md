# Virtual Pets Amok

My project classes and descriptions of them:
- VirtualPet: 
This is now an abstract class and contains the variables that should be shared amongst ALL pets.
The tick() method is now abstract because the variables that change has to be different depending on if it's activated on an organic or robotic pet.
VirtualPet has basically become the very basic framework of a pet.
- OrganicPet: 
This is a regular class that extends VirtualPet.
All variables are inherited from VirtualPet and variables specific to all organic pets are in here.
Various methods that apply to organic pets only are in this class.
- RoboticPet: 
This is a regular class that extends VirtualPet.
All variables are inherited from VirtualPet and variables specific to all robotic pets are in here.
Various methods that apply to robotic pets only are in this class.
- OrganicCat: 
This is a regular class that extends OrganicPet and implements Cat.
All variables are inherited from OrganicPet.
Since OrganicPet extends VirtualPet, I have access to VirtualPet's variables and methods.
All methods from Cat are used here.
- OrganicDog: 
This is a regular class that extends OrganicPet and implements Dog.
All variables are inherited from OrganicPet.
Since OrganicPet extends VirtualPet, I have access to VirtualPet's variables and methods.
All methods from Dog are used here.
- RoboticCat: 
This is a regular class that extends RoboticPet and implements Cat.
All variables are inherited from RoboticPet.
Since RoboticPet extends VirtualPet, I have access to VirtualPet's variables and methods here.
All methods from Cat are used here.
- RoboticDog: 
This is a regular class that extends RoboticPet and implements Dog.
All variables are inherited from RoboticPet.
Since RoboticPet extends VirtualPet, I have access to VirtualPet's variables and methods here.
All methods from Dog are used here.
- Cat: 
Cat is an interface class that contains methods specific to all cats.
However, since there are organic and robotic cats, the methods have to apply differently to both.
Therefore, I made this an interface class and the methods are overwritten in the classes that implement Cat.
- Dog: 
Dog is an interface class that contains methods specific to all dogs.
However, since there are organic and robotic dogs, the methods have to apply differently to both.
Therefore, I made this an interface class and the methods are overwritten in the classes that implement Dog.
- VirtualPetShelter: 
VirtualPetShelter contains the shelter itself and any pets that are added to it.
It also provides the methods that affect all pets by searching through the shelter (HashMap) and executing corresponding methods derived from mostly (but not limited to) OrganicPet and RoboticPet.
OrganicCat/Dog and RoboticCat/Dog can all add to the same HashMap, so I went this route.
The cage() and litterBox() methods reside here and keep track of the level of waste within the cage or litter box.
Cage adds all the waste stats of organic dogs and litterBox adds the waste of organic cats.
There's also corresponding cleaning methods for cages and the litter box.
Some methods stayed the same from the last project here, like adoptPet() and tick().
- VirtualPetShelterApp: 
Some choices were modified to make the program look cleaner when interacting with it.
One example is clumping all the multi-pet modifiers (minus waste) into choice 1 and giving another menu to choose the specific option.
Some options were not changed.
Cleaning the shelter is a new option.
Surrendering a pet became a longer process due to the increased specificity needed to create a pet (would this be better as a method?).

Test Driven Development was done on all classes except for VirtualPet, Cat, Dog, and VirtualPetShelterApp.
Any methods that did not test for equality were instead used to see the output.

Added classes

- Organic/Robotic Horse classes, function similarly to the cat/dog ones
- Horse interface class, also similar to Dog/Cat interface classes
- Cage/LitterBox/Stable classes that have their own hashmap of pets and their waste values

Added new methods

- Treat method under VPS class, meat for dogs/cats and hay for horses (feeding the opposite will decrease happiness)
