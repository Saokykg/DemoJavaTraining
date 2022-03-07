package model;

public class Cats extends Animals{
    public Cats(String name, int age, EnumSex.Sex sex){
        super(name, age, sex);
        this.sound = "Cat_sound";
    }
}
