package main.java.com.magicvet.model;
import main.java.com.magicvet.util.EnumParser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
    private String type;
    private String sex;
    private Age ageCategory;
    private int numAge;
    private String name;
    private String ownerName;
    private HealthState healthState;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    public Pet(Age ageCategory,int numAge, HealthState healthState) {
        this.ageCategory = ageCategory;
        this.numAge = numAge;
        this.healthState = healthState;
    }

    public HealthState getHealthState() {
        return healthState;
    }
    public void setHealthState(HealthState healthState) {this.healthState = healthState;}

public Pet(){

}

    public Pet(String type, String sex, Age ageCategory,int numAge, String name, String ownerName, HealthState healthState) {
        this.type = type;
        this.sex = sex;
        this.ageCategory = ageCategory;
        this.numAge = numAge;
        this.name = name;
        this.ownerName = ownerName;
        this.healthState = healthState;
    }

    @Override
    public String toString() {
        return "Pet {"
                + "type = " + type
                + ", sex = " + sex
                + ", age = " + numAge + " (" + ageCategory + ")"
                + ", name = " + name
                + ", ownerName = " + ownerName
                + ", healthState = " + healthState
                + ", registrationDate = " + registrationDate.format(FORMATTER)
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(sex, pet.sex)
                && Objects.equals(ageCategory, pet.ageCategory)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName)
                && Objects.equals(healthState, pet.healthState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, ageCategory, numAge, name, ownerName, healthState);
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

    public Age getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(Age ageCategory) {
        this.ageCategory = ageCategory;
    }

    public int getNumericAge() { return numAge;}

    public void setNumericAge(int numAge) {this.numAge = numAge;}

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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public static DateTimeFormatter getFormatter() {
        return FORMATTER;
    }

    public enum HealthState {
        EXCELLENT(1),
        GOOD(2),
        FAIR(3),
        POOR(4),
        CRITICAL(5),
        UNKNOWN(0);
        private final int val;

        HealthState(int val) {
            this.val = val;
        }
        public static HealthState health (String val){
            return EnumParser.parseEnum(HealthState.class, val, UNKNOWN);
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
        SENIOR(14, 20),
        UNKNOWN(0,0);
        private final int minValue;
        private final int maxValue;

        Age(int minValue, int maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
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

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
        public static Age fromValue(int value) {
            return EnumParser.parseAge(value, UNKNOWN);
        }
    }
}