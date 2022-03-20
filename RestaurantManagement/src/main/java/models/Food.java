package models;

public class Food extends MenuItem {
    private ItemsType.foodType type;

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s ", this.getType());
    }

    public Food(){
        super();
    }

    public Food(ItemsType.foodType type){
        super();
        this.type = type;
    }

    public Food(String name, String des, String img, double price, ItemsType.foodType type){
        super(name, des, img, price);
        this.setType(type);
    }

    public ItemsType.foodType getType() {
        return type;
    }

    public void setType(ItemsType.foodType type) {
        this.type = type;
    }
}
