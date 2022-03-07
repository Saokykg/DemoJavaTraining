import model.Animals;
import model.Struct_1;

import java.util.List;

public class AvgAge {



    public static void CalculatorAvgAge(List<Animals> list){
        Struct_1 dogs = new Struct_1();
        Struct_1 kittens = new Struct_1();
        Struct_1 cats = new Struct_1();
        Struct_1 tomCats = new Struct_1();
        Struct_1 frogs = new Struct_1();

        list.forEach((obj)->{
//            System.out.println(obj.sound());
            if(obj instanceof model.Cats){
                cats.addAge(obj.getAge());
            }
            if(obj instanceof model.Dogs){
                dogs.addAge(obj.getAge());
            }
            if(obj instanceof model.Kittens){
                kittens.addAge(obj.getAge());
            }
            if(obj instanceof model.TomCats){
                tomCats.addAge(obj.getAge());
            }
            if(obj instanceof model.Frogs){
                frogs.addAge(obj.getAge());
            }
        });

        System.out.printf("Dogs: %s\nFrogs: %s\nKittens: %s\nTomCats: %s\nCats: %s\n", dogs, frogs, kittens, tomCats, cats);

    }
}
