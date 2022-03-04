package models;

public class Alcohol extends Drink{
    private double concentration;

    public Alcohol(){
        this.type = Enum.drinkType.ALCOHOL;
    }

    public Alcohol(String name, String des, String img, double price, double concentration){
        super(name, des, img, price);
        this.concentration = concentration;
        this.type = Enum.drinkType.ALCOHOL;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10s ", this.getConcentration());
    }

    public double getConcentration(){
        return this.concentration;
    }

    public void setConcentration(double concentration){
        this.concentration = concentration;
    }

}
