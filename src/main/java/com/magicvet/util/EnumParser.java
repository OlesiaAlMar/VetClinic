package main.java.com.magicvet.util;

import main.java.com.magicvet.model.Pet;

public class EnumParser {
    public static <E extends Enum<E>> E parseEnum(Class<E> enumClass, String value, E defaultValue) {
        for (E enumConstant : enumClass.getEnumConstants() ) {
            if (enumConstant.name().equalsIgnoreCase(value)) {
                return enumConstant;
            }
        }
        System.out.println("Unable to parse value '" + value + "'. Using default value: " + defaultValue);
        return defaultValue;
    }
    public static Pet.Age parseAge(int value, Pet.Age defaultValue) {
        for (Pet.Age age : Pet.Age.values()) {
            if (value >= age.getMinValue() && value <= age.getMaxValue()) {
                return age;
            }
        }
        System.out.println("Invalid age value: " + value + ". Using default value: " + defaultValue);
        return defaultValue;
    }
}


