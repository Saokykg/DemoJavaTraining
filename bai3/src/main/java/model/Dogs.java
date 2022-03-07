package model;

public class Dogs extends Animals{
    public Dogs(String name, int age, EnumSex.Sex sex){
        super(name, age, sex);
        this.sound = "Dog_sound";
    }
}
