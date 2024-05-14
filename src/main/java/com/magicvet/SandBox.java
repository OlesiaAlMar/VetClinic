package main.java.com.magicvet;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;
import java.util.Arrays;
import java.util.Comparator;

public class SandBox {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{
                new Dog(Dog.Size.M, Pet.Age.ADULT, Pet.HealthState.EXCELLENT),
                new Dog(Dog.Size.S, Pet.Age.YOUNG,Pet.HealthState.CRITICAL),
                new Dog(Dog.Size.L, Pet.Age.LITTLE,Pet.HealthState.FAIR),
                new Dog(Dog.Size.XL, Pet.Age.SENIOR,Pet.HealthState.POOR),
                new Dog(Dog.Size.XS, Pet.Age.ADULT,Pet.HealthState.GOOD),
                new Dog(Dog.Size.S, Pet.Age.OLD,Pet.HealthState.FAIR)
        };
        Arrays.sort(dogs, new Comparator<>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });
        System.out.println("\nSorted by size:");
        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }
        Arrays.sort(dogs, new Comparator<>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getAge().getValue() - o2.getAge().getValue();
                }
        });
        System.out.println("\nSorted by age:");
        for (Dog dog : dogs) {
            System.out.println(dog.getAge());
        }

        Arrays.sort(dogs, new Comparator<>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getHealthState().getVal() - o2.getHealthState().getVal();
            }
        });
        System.out.println("\nSorted by HealthState:");
        for (Dog dog : dogs) {
            System.out.println(dog.getHealthState());
        }
    }
}

