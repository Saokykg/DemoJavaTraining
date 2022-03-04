package models;

public class Food extends Menu{
    private Enum.foodType type;

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s ", this.getType());
    }

    public Food(){}
    public Food(String name, String des, String img, double price, Enum.foodType type){
        super(name, des, img, price);
        this.setType(type);
    }

    public Enum.foodType getType() {
        return type;
    }

    public void setType(Enum.foodType type) {
        this.type = type;
    }
}
