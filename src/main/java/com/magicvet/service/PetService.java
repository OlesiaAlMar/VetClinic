package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

import java.util.Optional;

public class PetService {
    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Optional<Pet> registerNewPet(){
        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();

        return Optional.ofNullable(type)
                .filter(t -> DOG_TYPE.equals(t) || CAT_TYPE.equals(t))
                .map(this::buildPet)
                .or(() -> {
                    System.out.println("Unknown pet type: " + type);
                    return Optional.empty();
                });
    }

    private Pet buildPet(String type) {

        System.out.print("Age: ");
        int ageValue = Integer.parseInt(Main.SCANNER.nextLine());

        Pet.Age age =  Pet.Age.fromValue(ageValue);

        System.out.print("Name: ");
       String name = Main.SCANNER.nextLine();

        System.out.print("Sex(male/female): ");
        String sex = Main.SCANNER.nextLine().toLowerCase();

        System.out.print("Health state (excellent/good/fair/poor/critical): ");
        Pet.HealthState healthState = Pet.HealthState.health(Main.SCANNER.nextLine().toUpperCase());

            Pet pet;
            if (DOG_TYPE.equals(type)) {
                System.out.print("Size (XS / S / M / L / XL): ");
                Dog.Size size = Dog.Size.fromString(Main.SCANNER.nextLine().toUpperCase());
                pet = new Dog(size, age, ageValue, healthState);
            } else {
                pet = new Cat();
                pet.setHealthState(healthState);
            }

            pet.setType(type);
            pet.setAgeCategory(age);
            pet.setNumericAge(ageValue);
            pet.setName(name);
            pet.setSex(sex);

        return pet;
    }
}
