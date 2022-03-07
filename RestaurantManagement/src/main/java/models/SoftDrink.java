package models;

public class SoftDrink extends Drink{


    public SoftDrink(){
        super();
        this.setType(Enum.drinkType.SOFTDRINK);
    }

    public SoftDrink(String name, String des, String img, double price){
        super(name, des, img, price);
        this.setType(Enum.drinkType.SOFTDRINK);
    }


    @Override
    public String toString() {
        return super.toString();
    }

}
