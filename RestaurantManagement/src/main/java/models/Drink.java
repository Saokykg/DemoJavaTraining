package models;

public class Drink extends MenuItem {
    protected ItemsType.drinkType type;

    public Drink(){super();}
    public Drink(ItemsType.drinkType type){
        super();
        this.type = type;
    }
    public Drink(String name, String des, String img, double price, ItemsType.drinkType type){
        super(name, des, img, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s ", this.getType());
    }

    public ItemsType.drinkType getType() {
        return type;
    }

    public void setType(ItemsType.drinkType type) {
        this.type = type;
    }
}
