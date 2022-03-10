package model.dao;

import java.util.ArrayList;

import model.utils.Alcohol;
import model.utils.BreakfastMenu;
import model.utils.DinnerMenu;
import model.utils.LunchMenu;
import model.utils.SoftDrink;

public final class MenuData {
	private MenuData() {
		
	}
	public static  ArrayList<BreakfastMenu> BREAKFAST_MENUS = new ArrayList<BreakfastMenu>();
	
	public static  ArrayList<LunchMenu>  LUNCH_MENUS = new ArrayList<LunchMenu>();

	public static  ArrayList<DinnerMenu> DINNER_MENUS = new ArrayList<DinnerMenu>();

	public static  ArrayList<SoftDrink> SOFT_DRINK_MENUS = new ArrayList<SoftDrink>();

	public static  ArrayList<Alcohol> ALCOHOL_MENUS = new ArrayList<Alcohol>();


	



}
