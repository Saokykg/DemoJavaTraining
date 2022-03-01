package model;

public class EnumSex {
    public enum Sex {
        MALE,
        FEMALE
    }

    public Sex male(){
        return Sex.MALE;
    }

    public Sex femail(){
        return Sex.FEMALE;
    }
}
