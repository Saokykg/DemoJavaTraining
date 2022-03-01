package model;

public class TomCats extends Cats {
    public TomCats(String name, int age) {
        super(name, age, EnumSex.Sex.MALE);
    }

    public TomCats(String name, int age, EnumSex.Sex sex){
        super(name, age, EnumSex.Sex.MALE);
    }

    @Override
    public String sound(){
        return "TomCats_sound";
    }
}
