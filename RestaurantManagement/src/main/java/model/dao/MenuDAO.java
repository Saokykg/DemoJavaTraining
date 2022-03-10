package model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import file.MenuPath;
import model.utils.Alcohol;
import model.utils.BreakfastMenu;
import model.utils.DinnerMenu;
import model.utils.FoodMenu;
import model.utils.LunchMenu;
import model.utils.MenuItems;
import model.utils.SoftDrink;

public class MenuDAO {
	

	MenuItems getFoodMenuFromFile(String[] data, int num) {
		String id= data[0];
		String name = data[1];
		String image = data[2];
		String des = data[3];
		String price = data[4];
		MenuItems menu ;
		if(num==1) {
			menu= new BreakfastMenu();
		}else
		if(num==3) {
			menu= new DinnerMenu();
		}
		else {
			menu= new LunchMenu();
		}
		menu.setIdMenu(Integer.parseInt(id));
		menu.setName(name);
		menu.setImage(image);
		menu.setDescription(des);
		menu.setPrice(Float.parseFloat(price));
		return menu;
	}

	static Alcohol getAlcohol(String[] data) {

		String name = data[1];
		String image = data[2];
		String des = data[3];
		String price = data[4];
		String AlcoholConcentration = data[5];
		Alcohol alcohol = new Alcohol();
		alcohol.setName(name);
		alcohol.setImage(image);
		alcohol.setDescription(des);
		alcohol.setPrice(Float.parseFloat(price));
		alcohol.setAlcoholConcentration(Float.parseFloat(AlcoholConcentration));
		return alcohol;

	}

	static SoftDrink getSoftDrink(String[] data) {
		String name = data[1];
		String image = data[2];
		String des = data[3];
		String price = data[4];
		String savour = data[5];
		SoftDrink softDrink = new SoftDrink();

		softDrink.setName(name);
		softDrink.setImage(image);
		softDrink.setDescription(des);
		softDrink.setPrice(Float.parseFloat(price));
		softDrink.setSavour(savour);
		return softDrink;
	}

	public ArrayList<BreakfastMenu> outputBreakfastMenuFormFile() throws IOException {
		ArrayList<BreakfastMenu> breakfastMenus = new ArrayList<BreakfastMenu>();
		BufferedReader br = new BufferedReader(new FileReader(MenuPath.urlBreakfastMenu));

		String line = br.readLine();
		
		while (line != null) {
			String[] data = line.split(",");
			BreakfastMenu breakfastMenu =  (BreakfastMenu) getFoodMenuFromFile(data,1);
			breakfastMenus.add(breakfastMenu);
			line = br.readLine();
		}
		br.close();
		
	  	return breakfastMenus;
	}
	public FoodMenu chooseFoodMenu(FoodMenu food) {
		try {
			inputFoodMenuToFile(food);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return food;
	}

	public ArrayList<LunchMenu> outputLunchMenuFromFile() throws IOException {
		ArrayList<LunchMenu> lunchMenus = new ArrayList<LunchMenu>();
		BufferedReader br = new BufferedReader(new FileReader(MenuPath.urlLunchMenu));

		String line = br.readLine();
		while (line != null) {
			String[] data = line.split(",");
			LunchMenu lunchMenuData = (LunchMenu) getFoodMenuFromFile(data,2);
			lunchMenus.add(lunchMenuData);
			line = br.readLine();
		}
		br.close();
		return lunchMenus;
	}

	public ArrayList<DinnerMenu> outputDinnerMenuFromFile() throws IOException {
		ArrayList<DinnerMenu> dinnerMenus = new ArrayList<DinnerMenu>();
		BufferedReader br = new BufferedReader(new FileReader(MenuPath.urlDinnerMenu));

		String line = br.readLine();
		while (line != null) {
			String[] data = line.split(",");
			DinnerMenu dinnerMenuData = (DinnerMenu) getFoodMenuFromFile(data,3);
			dinnerMenus.add(dinnerMenuData);
			line = br.readLine();
		}
		br.close();
		return dinnerMenus;
	}

	public ArrayList<Alcohol> outputAlcoholMenuFromFile() throws IOException {
		ArrayList<Alcohol> alcoholMenus = new ArrayList<Alcohol>();
		BufferedReader br = new BufferedReader(new FileReader(MenuPath.urlAlcoholMenu));

		String line = br.readLine();
		while (line != null) {
			String[] data = line.split(",");
			Alcohol alcohol = (Alcohol) getAlcohol(data);
			alcoholMenus.add(alcohol);
			line = br.readLine();
		}
		br.close();
		return alcoholMenus;
	}

	public ArrayList<SoftDrink> outputSoftDrinkMenuFromFile() throws IOException {
		ArrayList<SoftDrink> softDrinkMenus = new ArrayList<SoftDrink>();
		BufferedReader br = new BufferedReader(new FileReader(MenuPath.urlSoftDrinkMenu));

		String line = br.readLine();
		while (line != null) {
			String[] data = line.split(",");
			SoftDrink softDrink = (SoftDrink) getSoftDrink(data);
			softDrinkMenus.add(softDrink);
			line = br.readLine();
		}
		br.close();
		return softDrinkMenus;
	}

	public void inputFoodMenuToFile(FoodMenu foodMenu) throws IOException {

		String fileName = "";
		if (foodMenu instanceof BreakfastMenu) {
			fileName = "BreakfastMenuData.csv";
		}
		if (foodMenu instanceof LunchMenu) {
			fileName = "LunchMenuData.csv";
		}
		if (foodMenu instanceof DinnerMenu) {
			fileName = "DinnerMenuData.csv";
		}
		FileWriter csvWriter = new FileWriter(MenuPath.url + fileName, true);
		BufferedWriter bw = new BufferedWriter(csvWriter);
		PrintWriter pw = new PrintWriter(bw);
		pw.println(foodMenu.getIdMenu() + "," + foodMenu.getName() + "," + foodMenu.getImage() + ","
				+ foodMenu.getDescription() + "," + foodMenu.getPrice());
		pw.close();
		bw.close();
		csvWriter.close();
	}

	public void inputAlcoholMenuToFile(Alcohol alcohol) throws IOException {
		FileWriter csvWriter = new FileWriter(MenuPath.urlAlcoholMenu, true);
		BufferedWriter bw = new BufferedWriter(csvWriter);
		PrintWriter pw = new PrintWriter(bw);
		pw.println(alcohol.getIdMenu() + "," + alcohol.getName() + "," + alcohol.getImage() + ","
				+ alcohol.getDescription() + "," + alcohol.getPrice() + "," + alcohol.getAlcoholConcentration());
		pw.close();
		bw.close();
		csvWriter.close();
	}

	public void inputSoftDrinkMenuToFile(SoftDrink softDrink) throws IOException {
		FileWriter csvWriter = new FileWriter(MenuPath.urlSoftDrinkMenu, true);
		BufferedWriter bw = new BufferedWriter(csvWriter);
		PrintWriter pw = new PrintWriter(bw);
		pw.println(softDrink.getIdMenu() + "," + softDrink.getName() + "," + softDrink.getImage() + ","
				+ softDrink.getDescription() + "," + softDrink.getPrice() + "," + softDrink.getSavour());
		pw.close();
		bw.close();
		csvWriter.close();
	}

	
	
	
	
	public ArrayList<BreakfastMenu> editBreakfastMenu(ArrayList<BreakfastMenu> list,int id,BreakfastMenu menu){
		 ArrayList<BreakfastMenu> listEdit= list;
		for (int i = 0; i < listEdit.size(); i++) {
		
			if(listEdit.get(i).getIdMenu()==id) {
				listEdit.set(i, menu);
			}
		}
		return listEdit;
	}
	
	public ArrayList<LunchMenu> editLunchMenuMenu(ArrayList<LunchMenu> list,int id,LunchMenu menu){
		 ArrayList<LunchMenu> listEdit= list;
		for (int i = 0; i < listEdit.size(); i++) {
		
			if(listEdit.get(i).getIdMenu()==id) {
				listEdit.set(i, menu);
			}
		}
		return listEdit;
	}
	
	public ArrayList<DinnerMenu> editDinnerMenuMenu(ArrayList<DinnerMenu> list,int id,DinnerMenu menu){
		 ArrayList<DinnerMenu> listEdit= list;
		for (int i = 0; i < listEdit.size(); i++) {
		
			if(listEdit.get(i).getIdMenu()==id) {
				listEdit.set(i, menu);
			}
		}
		return listEdit;
	}
	
	public ArrayList<Alcohol> editAlcoholMenu(ArrayList<Alcohol> list, int id, Alcohol alcohol){
		 ArrayList<Alcohol> listEdit= list;
			for (int i = 0; i < listEdit.size(); i++) {
			
				if(listEdit.get(i).getIdMenu()==id) {
					listEdit.set(i, alcohol);
				}
			}
			return listEdit;
	}
	
	public ArrayList<SoftDrink> editSoftDrinkMenu(ArrayList<SoftDrink> list, int id, SoftDrink softDrink){
		 ArrayList<SoftDrink> listEdit= list;
			for (int i = 0; i < listEdit.size(); i++) {
			
				if(listEdit.get(i).getIdMenu()==id) {
					listEdit.set(i, softDrink);
				}
			}
			return listEdit;
	}
	
	
	
	
	public boolean deleteBreakfastMenu(int id, ArrayList<BreakfastMenu> list) {
		boolean status = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				status = list.remove(list.get(i));
			}
		}

		return status;
	}

	public boolean deleteLunchMenu(int id, ArrayList<LunchMenu> list) {
		boolean status = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				status = list.remove(list.get(i));
			}
		}
		return status;
	}

	public boolean deleteDinnerMenu(int id, ArrayList<DinnerMenu> list) {
		boolean status = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				status = list.remove(list.get(i));
			}
		}
		return status;
	}

	public boolean deleteSoftDrinkMenu(int id, ArrayList<SoftDrink> list) {
		boolean status = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				status = list.remove(list.get(i));
			}
		}
		return status;
	}

	public boolean deleteAlcoholMenu(int id, ArrayList<Alcohol> list) {
		boolean status = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				status = list.remove(list.get(i));
			}
		}
		return status;
	}

	void statusDelete(boolean status) {
		if (status) {
			System.out.println("Deleted!!");
		} else {
			System.out.println("id cannot find!!");
		}
	}

	
}
