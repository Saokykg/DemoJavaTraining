package models;

public class Drink extends MenuItems {
    protected Enum.drinkType type;

    public Drink(){super();}
    public Drink(String name, String des, String img, double price){
        super(name, des, img, price);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s ", this.getType());
    }

    public Enum.drinkType getType() {
        return type;
    }

    public void setType(Enum.drinkType type) {
        this.type = type;
    }
}
