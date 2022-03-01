import model.*;

import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args) {

        List<Animals> list = new ArrayList<>();

        list.add(new Kittens("kitten1", 2));
        list.add(new Kittens("kitten2", 9));
        list.add(new Kittens("kitten3", 5));
        list.add(new Kittens("kitten4", 11));
        list.add(new Kittens("kitten5", 2));

        list.add(new Dogs("Dog1", 2, EnumSex.Sex.FEMALE));
        list.add(new Dogs("Dog2", 7, EnumSex.Sex.FEMALE));
        list.add(new Dogs("Dog3", 3, EnumSex.Sex.MALE));

        list.add(new Frogs("Frogs1", 1, EnumSex.Sex.MALE));
        list.add(new Frogs("Frogs2", 3, EnumSex.Sex.MALE));
        list.add(new Frogs("Frogs3", 2, EnumSex.Sex.FEMALE));
        list.add(new Frogs("Frogs4", 5, EnumSex.Sex.FEMALE));
        list.add(new Frogs("Frogs5", 3, EnumSex.Sex.MALE));

        list.add(new Cats("Cats1", 3, EnumSex.Sex.MALE));
        list.add(new Cats("Cats2", 6, EnumSex.Sex.MALE));
        list.add(new Cats("Cats3", 2, EnumSex.Sex.FEMALE));
        list.add(new Cats("Cats4", 1, EnumSex.Sex.FEMALE));
        list.add(new Cats("Cats5", 7, EnumSex.Sex.FEMALE));

        list.add(new TomCats("TomCats1", 3, EnumSex.Sex.FEMALE));
        list.add(new TomCats("TomCats2", 5, EnumSex.Sex.MALE));
        list.add(new TomCats("TomCats3", 2, EnumSex.Sex.FEMALE));
        list.add(new TomCats("TomCats4", 8, EnumSex.Sex.FEMALE));
        list.add(new TomCats("TomCats5", 2, EnumSex.Sex.FEMALE));

        AvgAge controller = new AvgAge();
        controller.CalculatorAvgAge(list);
    }
}
