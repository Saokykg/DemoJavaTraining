package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.dao.MenuDAO;
import model.dao.MenuData;
import model.utils.Alcohol;
import model.utils.BreakfastMenu;
import model.utils.DinnerMenu;
import model.utils.FoodMenu;
import model.utils.LunchMenu;
import model.utils.SoftDrink;
import view.ViewMenu;

public class MenuController {
	private MenuDAO menuModel;
	private ViewMenu menuView;

	public MenuController() {
		menuModel= new MenuDAO();
		
	}

	

	public void showBreakfastMenu() {
		menuView= new ViewMenu();
		menuView.showBreakfastMenu(MenuData.BREAKFAST_MENUS);
	}

	public void showLunchMenu() {
		menuView.showLunchMenu(MenuData.LUNCH_MENUS);
	}

	public void showDinnerMenu() {
		menuView.showDinnerMenu(MenuData.DINNER_MENUS);
	}

	public void showSoftDrinkMenu() {
		menuView.showSoftDrinkMenu(MenuData.SOFT_DRINK_MENUS);
	}

	public void showAlcoholMenu() {
		menuView.showAlcoholMenu(MenuData.ALCOHOL_MENUS);
	}

	public void inputFoodMenuToFile(FoodMenu foodMenu) throws IOException {

		menuModel.inputFoodMenuToFile(foodMenu);
	}

	public void inputAlcoholMenuToFile(Alcohol alcohol) throws IOException {
		menuModel.inputAlcoholMenuToFile(alcohol);
	}

	public void inputSoftDrinkMenuToFile(SoftDrink softDrink) throws IOException {
		menuModel.inputSoftDrinkMenuToFile(softDrink);
	}
	
	public void chooseMenuInput() {
		menuView.chooseMenuInput();
	}
	public void inputBreakfastMenu() {
		try {
			inputFoodMenuToFile(menuView.inputBreakfastMenu());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void inputLunchMenu() {
		try {
			inputFoodMenuToFile(menuView.inputLunchMenu());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void inputDinnerMenu() {
		try {
			inputFoodMenuToFile(menuView.inputDinnerMenu());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void inputSoftDrinkMenu() {
		try {
			inputSoftDrinkMenuToFile(menuView.inputSoftDrink());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void inputAlcoholMenu() {
		try {
			inputAlcoholMenuToFile(menuView.inputAlcohol());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void showMenu() {
		showBreakfastMenu();
		showLunchMenu();
		showDinnerMenu();
		showSoftDrinkMenu();
		showAlcoholMenu();
		
	}
	public void editMenu() {
		menuView.chooseMenuEdit();
	}
	public void deleteMenu() {
		menuView.chooseMenuToDelete();
	}
	public ArrayList<BreakfastMenu> editBreakfastMenu(int id, BreakfastMenu menu) {
		ArrayList<BreakfastMenu> listEdit = menuModel.editBreakfastMenu(MenuData.BREAKFAST_MENUS, id, menu);
		return listEdit;
	}

	public ArrayList<LunchMenu> editLunchMenuMenu(int id, LunchMenu menu) {
		ArrayList<LunchMenu> listEdit = menuModel.editLunchMenuMenu(MenuData.LUNCH_MENUS, id, menu);
		return listEdit;
	}

	public ArrayList<DinnerMenu> editDinnerMenuMenu(int id, DinnerMenu menu) {
		ArrayList<DinnerMenu> listEdit = menuModel.editDinnerMenuMenu(MenuData.DINNER_MENUS, id, menu);
		return listEdit;
	}

	public ArrayList<Alcohol> editAlcoholMenu(int id, Alcohol alcohol) {
		ArrayList<Alcohol> listEdit = menuModel.editAlcoholMenu(MenuData.ALCOHOL_MENUS, id, alcohol);
		return listEdit;
	}

	public ArrayList<SoftDrink> editSoftDrinkMenu(int id, SoftDrink softDrink) {
		ArrayList<SoftDrink> listEdit = menuModel.editSoftDrinkMenu(MenuData.SOFT_DRINK_MENUS, id, softDrink);
		return listEdit;
	}

	public boolean deleteBreakfastMenu(int id) {
		ArrayList<BreakfastMenu> list = MenuData.BREAKFAST_MENUS;
		return menuModel.deleteBreakfastMenu(id, list);
	}

	public boolean deleteLunchMenu(int id) {
		ArrayList<LunchMenu> list = MenuData.LUNCH_MENUS;
		return menuModel.deleteLunchMenu(id, list);
	}

	public boolean deleteDinnerMenu(int id) {
		ArrayList<DinnerMenu> list = MenuData.DINNER_MENUS;

		return menuModel.deleteDinnerMenu(id, list);
	}

	public boolean deleteSoftDrinkMenu(int id) {
		ArrayList<SoftDrink> list = MenuData.SOFT_DRINK_MENUS;

		return menuModel.deleteSoftDrinkMenu(id, list);
	}

	public boolean deleteAlcoholMenu(int id) {
		ArrayList<Alcohol> list = MenuData.ALCOHOL_MENUS;
		return menuModel.deleteAlcoholMenu(id, list);
	}

	void statusDelete(boolean status) {
		if (status) {
			System.out.println("Deleted!!");
		} else {
			System.out.println("id cannot find!!");
		}
	}

	public void initListMenus() throws IOException {
		MenuData.BREAKFAST_MENUS = menuModel.outputBreakfastMenuFormFile();
		
		MenuData.LUNCH_MENUS = menuModel.outputLunchMenuFromFile();
		MenuData.DINNER_MENUS = menuModel.outputDinnerMenuFromFile();
		MenuData.SOFT_DRINK_MENUS = menuModel.outputSoftDrinkMenuFromFile();
		MenuData.ALCOHOL_MENUS = menuModel.outputAlcoholMenuFromFile();
	}
}
