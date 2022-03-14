package models;

import models.ItemType.DRINK;
public class Drink extends MenuItem {
    private DRINK type;

    public Drink(){super();}
    public Drink(String name, String des, String img, double price, DRINK type){
        super(name, des, img, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s ", this.getType());
    }

    @Override
    public String output(){
        return String.format("%s, %s", this.type, super.output());
    }

    public DRINK getType() {
        return type;
    }

    public void setType(DRINK type) {
        this.type = type;
    }
}
