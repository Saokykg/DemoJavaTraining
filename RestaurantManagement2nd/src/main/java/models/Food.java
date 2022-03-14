package models;

import models.ItemType.FOOD;
public class Food extends MenuItem{
    private FOOD type;

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s ", this.getType());
    }

    @Override
    public String output(){
        return String.format("%s, %s\n", this.type, super.output());
    }

    public Food(){
        super();
    }

    public Food(FOOD type){
        super();
        this.type = type;
    }

    public Food(String name, String des, String img, double price, FOOD type){
        super(name, des, img, price);
        this.setType(type);
    }

    public FOOD getType() {
        return type;
    }

    public void setType(FOOD type) {
        this.type = type;
    }
}

