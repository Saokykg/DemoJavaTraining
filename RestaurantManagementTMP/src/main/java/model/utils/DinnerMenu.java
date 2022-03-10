package model.utils;

import java.util.ArrayList;

public class DinnerMenu extends FoodMenu{
	
	
	
	

	public DinnerMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DinnerMenu(String name, String description, String image, float price) {
		super(name, description, image, price);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<DinnerMenu> dinnerMenus= new ArrayList<DinnerMenu>();
}
