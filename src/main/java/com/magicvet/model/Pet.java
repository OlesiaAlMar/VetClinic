package main.java.com.magicvet.model;

import java.util.Objects;

public abstract class Pet {
    private String type;
    private String sex;
    private Age age;
    private String name;
    private String ownerName;
    private HealthState healthState;

    public Pet() {
    }

    public Pet(Age age, HealthState healthState) {
        this.age = age;
        this.healthState = healthState;
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public Pet(String type, String sex, Age age, String name, String ownerName, HealthState healthState) {
        this.type = type;
        this.sex = sex;
        this.age = age;
        this.name = name;
        this.ownerName = ownerName;
        this.healthState = healthState;
    }

    @Override
    public String toString() {
        return "Pet {"
                + "type = " + type
                + ", sex = " + sex
                + ", age = " + age
                + ", name = " + name
                + ", ownerName = " + ownerName
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, age, name, ownerName);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public enum HealthState {
        EXCELLENT(1),
        GOOD(2),
        FAIR(3),
        POOR(4),
        CRITICAL(5);
        private final int val;

        HealthState(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    public enum Age {
        LITTLE(0, 1),
        YOUNG(2, 4),
        ADULT(5, 8),
        OLD(9, 14),
        SENIOR(14, 20);

        private final int minValue;
        private final int maxValue;

        Age(int minValue, int maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        public static Age fromValue(int value) {
            for (Age age : values()) {
                if (value >= age.minValue && value <= age.maxValue) {
                    return age;
                }
            }
            throw new IllegalArgumentException("Invalid age value: " + value);
        }

        public int getMinValue() {
            return minValue;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public int getValue() {
            return (minValue + maxValue) / 2;
        }
    }
}
