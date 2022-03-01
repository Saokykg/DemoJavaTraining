package model;

public class Kittens extends Cats{

    public Kittens(String name, int age){
        super(name, age, EnumSex.Sex.FEMALE);
    }

    public Kittens(String name, int age, EnumSex.Sex sex){
        super(name, age, EnumSex.Sex.FEMALE);
    }

    @Override
    public String sound(){
        return "Kittens_sound";
    }
}
