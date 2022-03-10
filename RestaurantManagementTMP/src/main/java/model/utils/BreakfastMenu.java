package model.utils;

import java.util.ArrayList;

public class BreakfastMenu extends FoodMenu{
	

	

	public BreakfastMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BreakfastMenu(String name, String description, String image, float price) {
		super(name, description, image, price);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<BreakfastMenu> breakfastMenus= new ArrayList<BreakfastMenu>();
}
