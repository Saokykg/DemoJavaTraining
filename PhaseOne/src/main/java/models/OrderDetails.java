package models;

public class OrderDetails {
    private Menu menu;
    private int amount;

    public OrderDetails(){};
    public OrderDetails(Menu menu){
        this.setMenu(menu);
        this.setAmount(1);
    }

    @Override
    public String toString() {
        return String.format("%10s %10.2f x %3d %15.2f",
                    this.getMenu().getName(),
                    this.getMenu().getPrice(),
                    this.getAmount(),
                    this.getMenu().getPrice() * this.getAmount());
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
