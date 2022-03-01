package model;

public class Cats extends Animals{
    public Cats(String name, int age, EnumSex.Sex sex){
        super(name, age, sex);
    }

    @Override
    public String sound(){
        return "Cats_sound";
    }
}
