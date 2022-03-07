package model;

public class TomCats extends Cats {
    public TomCats(String name, int age) {
        super(name, age, EnumSex.Sex.MALE);
        this.sound = "TomCat_sound";
    }

    public TomCats(String name, int age, EnumSex.Sex sex){
        super(name, age, EnumSex.Sex.MALE);
        this.sound = "TomCat_sound";
    }

}
