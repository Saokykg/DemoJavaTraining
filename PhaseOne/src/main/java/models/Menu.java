package models;

public abstract class Menu {
    private static int counter = 0;
    private int id;
    private String name;
    private String descripton;
    private String image;
    private double price;

    public Menu(){
        this.setId(counter++);
    }
    public Menu(String name, String des, String img, double price){
        this.setId(counter++);
        this.setName(name);
        this.setDescripton(des);
        this.setImage(img);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        return String.format("%-4d: %-20s %-50s %-20s %-10.2f ",this.getId(), this.getName(), this.getDescripton(), this.getImage(), this.getPrice());
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
