package model.utils;

import java.util.ArrayList;

public class Alcohol extends DrinkMenu {
	private float alcoholConcentration;

	public static ArrayList<Alcohol> alcoholMenus = new ArrayList<Alcohol>();

	public Alcohol() {
		super();
	}

	

	public Alcohol(float alcoholConcentration) {
		super();
		this.alcoholConcentration = alcoholConcentration;
	}

	public float getAlcoholConcentration() {
		return alcoholConcentration;
	}

	public void setAlcoholConcentration(float alcoholConcentration) {
		this.alcoholConcentration = alcoholConcentration;
	}

}
