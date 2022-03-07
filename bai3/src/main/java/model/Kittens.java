package model;

public class Kittens extends Cats{

    public Kittens(String name, int age){
        super(name, age, EnumSex.Sex.FEMALE);
        this.sound = "Kitten_sound";
    }

    public Kittens(String name, int age, EnumSex.Sex sex){
        super(name, age, EnumSex.Sex.FEMALE);
        this.sound = "Kitten_sound";
    }

}
