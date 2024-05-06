package main.java.com.magicvet.comparator;

import main.java.com.magicvet.model.Dog;

import java.util.Comparator;

public class DogAgeComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog dog1, Dog dog2) {
        return convertAge(dog1.getAge()) - convertAge(dog2.getAge());
    }

    private static int convertAge(String age) {
            return switch (age) {
                case Dog.PUPPY -> 1;
                case Dog.YOUNG -> 2;
                case Dog.YOUNG_ADULT -> 3;
                case Dog.ADULT -> 4;
                case Dog.OLD -> 5;
                default -> 0;
            };
        }
    }
