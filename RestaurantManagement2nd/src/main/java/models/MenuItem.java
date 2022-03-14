package models;

public abstract class MenuItem { //MenuItems
    private static int counter = 1;
    private int id;
    private String name;
    private String descripton;
    private String image;
    private double price;

    public MenuItem(){
        this.setId(counter++);
    }
    public MenuItem(String name, String des, String img, double price){
        this.setId(counter++);
        this.setName(name);
        this.setDescripton(des);
        this.setImage(img);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        return String.format("%-4d: %-20s %-30s %-30s %-10.2f ",this.getId(), this.getName(), this.getDescripton(), this.getImage(), this.getPrice());
    }

    public String output(){
        return String.format("%s, %s, %s, %.2f", this.name, this.descripton, this.image, this.price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
