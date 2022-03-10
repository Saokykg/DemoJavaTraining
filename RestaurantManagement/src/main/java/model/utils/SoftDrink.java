package model.utils;

import java.util.ArrayList;

public class SoftDrink extends DrinkMenu {
	private String savour;

	public static ArrayList<SoftDrink> softDrinkMenus = new ArrayList<SoftDrink>();

	public SoftDrink() {
		super();
	}

	public SoftDrink(String savour) {
		super();
		this.savour = savour;
	}

	public String getSavour() {
		return savour;
	}

	public void setSavour(String savour) {
		this.savour = savour;
	}

}
