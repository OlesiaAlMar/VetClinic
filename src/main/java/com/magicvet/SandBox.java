package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogAgeComparator;
import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.model.Dog;

import java.util.Arrays;

import static main.java.com.magicvet.model.Dog.*;

public class SandBox {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{
                new Dog(Dog.M,ADULT),
                new Dog(Dog.S,YOUNG),
                new Dog(Dog.L,PUPPY),
                new Dog(Dog.XL,YOUNG_ADULT),
                new Dog(Dog.XS,ADULT),
                new Dog(Dog.S,OLD)
        };
        Arrays.sort(dogs, new DogSizeComparator());
        System.out.println("Sorted by size:");
        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        Arrays.sort(dogs, new DogAgeComparator());
        System.out.println("\nSorted by age:");
        for (Dog dog : dogs) {
            System.out.println(dog.getAge());
        }
    }
}


