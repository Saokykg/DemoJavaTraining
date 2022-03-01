package model;

public class Frogs extends Animals{
    public Frogs(String name, int age, EnumSex.Sex sex){
        super(name, age, sex);
    }

    @Override
    public String sound(){
        return "Frogs_sound";
    }
}