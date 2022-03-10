package model.utils;

import java.util.ArrayList;

public  class MenuItems {
	private String name;
	private String description;
	private String image;
	private float price;
	private int idMenu;
	private static int countID;
	public static ArrayList<MenuItems> listMenus= new ArrayList<MenuItems>();
	
	
	
	public MenuItems() {
		super();
		this.idMenu=++countID;
	}
	public MenuItems(String name, String description, String image, float price) {
		super();
		this.idMenu=++countID;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		
		this.price = price;
	}
	
	
	public int getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	@Override
	public String toString() {
		return "\n [ID="+idMenu+",name=" + name + ", description=" + description + ", image=" + image + ", price=" + price + "]";
	}
	
}
