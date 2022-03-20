package models;

public class OrderDetails {
    private MenuItem menu;
    private int amount;

    public OrderDetails(){}
    public OrderDetails(MenuItem menu){
        this.menu = menu;
        this.amount = 1;
    }

    public OrderDetails(MenuItem menu, int amount){
        this.menu = menu;
        this.amount = amount;
    }


    @Override
    public String toString() {
        return String.format("%10s %10.2f x %3d %15.2f",
                    this.getMenu().getName(),
                    this.getMenu().getPrice(),
                    this.getAmount(),
                    this.getMenu().getPrice() * this.getAmount());
    }

    public MenuItem getMenu() {
        return menu;
    }

    public void setMenu(MenuItem menu) {
        this.menu = menu;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
