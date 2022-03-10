package model.utils;

public class MenuItemsInBill {
	private MenuItems menu;
	private int quantity;
	private int id;
	private static int countID=0;
	
	public MenuItemsInBill() {
		super();
		this.id=++countID;
	}
	public MenuItems getMenu() {
		return menu;
		
	}
	public void setMenu(MenuItems menu) {
		this.menu = menu;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "\n[id=" + id + ", menu=" + menu.toString() + ", quantity=" + quantity + "]";
	}
	
}
