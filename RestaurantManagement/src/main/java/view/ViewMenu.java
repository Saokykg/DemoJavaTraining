package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.MenuController;


import model.utils.Alcohol;
import model.utils.BreakfastMenu;
import model.utils.DinnerMenu;
import model.utils.DrinkMenu;
import model.utils.FoodMenu;
import model.utils.LunchMenu;
import model.utils.MenuItems;
import model.utils.SoftDrink;

public class ViewMenu {
	static Scanner scanner = new Scanner(System.in);
	MenuController controller = new MenuController();
	
	public BreakfastMenu inputBreakfastMenu() {
		BreakfastMenu breakfastMenu = new BreakfastMenu();
		inputMenu(breakfastMenu);
		return breakfastMenu;
	}

	public LunchMenu inputLunchMenu() {
		LunchMenu lunchMenu = new LunchMenu();
		inputMenu(lunchMenu);
		return lunchMenu;
	}

	public DinnerMenu inputDinnerMenu() {
		DinnerMenu dinnerMenu = new DinnerMenu();
		inputMenu(dinnerMenu);
		return dinnerMenu;
	}

	public SoftDrink inputSoftDrink() {
		SoftDrink softDrink = new SoftDrink();
		inputMenu(softDrink);
		return softDrink;
	}

	public Alcohol inputAlcohol() {
		Alcohol alcohol = new Alcohol();
		inputMenu(alcohol);
		return alcohol;
	}

	public FoodMenu chooseFoodMenu(FoodMenu food) {
		try {
			controller.inputFoodMenuToFile(food);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return food;
	}

	public DrinkMenu chooseDinkMenu(int choose) {

		DrinkMenu drink = new DrinkMenu();
		if (choose == 4) {
			System.out.println("Input savour");
			String savour = scanner.nextLine();
			drink = new SoftDrink(savour);
			inputMenu(drink);
			try {
				controller.inputSoftDrinkMenuToFile((SoftDrink) drink);

			} catch (IOException e) {

				e.printStackTrace();
			}

		} else if (choose == 5) {
			System.out.println("Input alcohol concentration");
			float alcoholConcentration = scanner.nextFloat();
			drink = new Alcohol(alcoholConcentration);
			inputMenu(drink);
			try {
				controller.inputAlcoholMenuToFile((Alcohol) drink);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		// controller.insertMenu(drink);
		return drink;
	}

	public void inputMenu(MenuItems menu) {
		scanner.nextLine();
		System.out.println("Input name:");
		menu.setName(scanner.nextLine());
		System.out.println("Input image:");
		menu.setImage(scanner.nextLine());
		System.out.println("Input description:");
		menu.setDescription(scanner.nextLine());
		System.out.println("Input price:");
		do {
			try {
				String str = scanner.nextLine();
				float price = Float.parseFloat(str);
				if (price < 0) {
					price = 0;
				}
				menu.setPrice(price);
				return;
			} catch (NumberFormatException e) {
				System.out.println("ERROR:Please input number");

			}
		} while (true);

	}

	public void showBreakfastMenu(ArrayList<BreakfastMenu> liBreakfastMenus) {

		if (liBreakfastMenus.size() > 0) {
			System.out.println("Breakfast menu");
			System.out.println(liBreakfastMenus.toString());
		}

	}

	public void showLunchMenu(ArrayList<LunchMenu> listLunchMenus) {
		if (listLunchMenus.size() > 0) {
			System.out.println("Lunch menu");
			System.out.println(listLunchMenus.toString());
		}
	}

	public void showDinnerMenu(ArrayList<DinnerMenu> lisDinnerMenus) {
		if (lisDinnerMenus.size() > 0) {
			System.out.println("Dinner menu");
			System.out.println(lisDinnerMenus.toString());
		}
	}

	public void showSoftDrinkMenu(ArrayList<SoftDrink> lisSoftDrinks) {
		if (lisSoftDrinks.size() > 0) {
			System.out.println("Soft drink menu ");
			System.out.println(lisSoftDrinks.toString());
		}
	}

	public void showAlcoholMenu(ArrayList<Alcohol> lisAlcohols) {
		if (lisAlcohols.size() > 0) {
			System.out.println("Alcohol menu");
			System.out.println(lisAlcohols.toString());
		}
	}

	public ArrayList<BreakfastMenu> editBreakfastMenu(int id, BreakfastMenu breakfastMenu) {
		return controller.editBreakfastMenu(id, breakfastMenu);
	}

	public ArrayList<LunchMenu> editLunchMenu(int id, LunchMenu lunchMenu) {
		return controller.editLunchMenuMenu(id, lunchMenu);
	}

	public ArrayList<DinnerMenu> editDinnerMenu(int id, DinnerMenu dinnerMenu) {
		return controller.editDinnerMenuMenu(id, dinnerMenu);
	}

	public ArrayList<Alcohol> editAlcoholMenu(int id, Alcohol alcohol) {
		return controller.editAlcoholMenu(id, alcohol);
	}

	public ArrayList<SoftDrink> editSoftDrinkMenu(int id, SoftDrink softDrink) {
		return controller.editSoftDrinkMenu(id, softDrink);
	}

	public boolean deleteBreakfastMenu(int id) {
		return controller.deleteBreakfastMenu(id);
	}

	public boolean deleteLunchMenu(int id) {

		return controller.deleteLunchMenu(id);
	}

	public boolean deleteDinnerMenu(int id) {
		return controller.deleteDinnerMenu(id);
	}

	public boolean deleteSoftDrinkMenu(int id) {

		return controller.deleteSoftDrinkMenu(id);
	}

	public boolean deleteAlcoholMenu(int id) {

		return controller.deleteAlcoholMenu(id);
	}

	void statusDelete(boolean status) {
		if (status) {
			System.out.println("Deleted!!");
		} else {
			System.out.println("id cannot find!!");
		}
	}

	public void chooseMenuToDelete() {
		ViewMenuChoose.chooseMenu();
		int n = scanner.nextInt();
		int id = 0;
		boolean delete = false;
		switch (n) {
		case 1:
			System.out.println("Choose id menu to edit:");
			controller.showBreakfastMenu();
			id = scanner.nextInt();
			delete = deleteBreakfastMenu(id);
			statusDelete(delete);
			break;
		case 2:
			System.out.println("Choose id menu to edit:");
			controller.showLunchMenu();
			id = scanner.nextInt();
			delete = deleteLunchMenu(id);
			statusDelete(delete);
			break;
		case 3:
			System.out.println("Choose id menu to edit:");
			controller.showDinnerMenu();
			id = scanner.nextInt();
			delete = deleteDinnerMenu(id);
			statusDelete(delete);
			break;
		case 4:
			System.out.println("Choose id menu to edit:");
			controller.showSoftDrinkMenu();
			id = scanner.nextInt();
			delete = deleteSoftDrinkMenu(id);
			statusDelete(delete);
			break;
		case 5:
			System.out.println("Choose id menu to edit:");
			controller.showAlcoholMenu();
			id = scanner.nextInt();
			delete = deleteAlcoholMenu(id);
			statusDelete(delete);
			break;
		default:
			break;
		}
	}

	public void chooseMenuInput() {
		ViewMenuChoose.chooseMenu();
		int choose=scanner.nextInt();
		switch (choose) {
		case 1:
			controller.inputBreakfastMenu();
			break;
		case 2:
			controller.inputLunchMenu();
			break;
		case 3: 
			controller.inputDinnerMenu();
			break;
		case 4:
			controller.inputSoftDrinkMenu();
			break;
		case 5:
			controller.inputAlcoholMenu();
			break;

		default:
			break;
		}
	}

	public void chooseMenuEdit() {
		ViewMenuChoose.chooseMenu();
		int n = scanner.nextInt();
		int id = 0;
		switch (n) {

		case 1:

			controller.showBreakfastMenu();
			System.out.println("Choose id menu to edit:");
			id = scanner.nextInt();
			BreakfastMenu breakfastMenu = new BreakfastMenu();
			inputMenu(breakfastMenu);
			editBreakfastMenu(id, breakfastMenu);
			break;
		case 2:

			controller.showLunchMenu();
			System.out.println("Choose id menu to edit:");
			id = scanner.nextInt();
			LunchMenu lunchNew = new LunchMenu();
			inputMenu(lunchNew);
			editLunchMenu(id, lunchNew);
			break;
		case 3:

			controller.showDinnerMenu();
			System.out.println("Choose id menu to edit:");
			id = scanner.nextInt();
			DinnerMenu dinnerMenu = new DinnerMenu();
			inputMenu(dinnerMenu);
			editDinnerMenu(id, dinnerMenu);
			break;
		case 4:

			controller.showSoftDrinkMenu();
			System.out.println("Choose id menu to edit:");
			id = scanner.nextInt();
			SoftDrink softDrinkMenu = new SoftDrink();
			inputMenu(softDrinkMenu);
			editSoftDrinkMenu(id, softDrinkMenu);
			break;
		case 5:

			controller.showAlcoholMenu();
			System.out.println("Choose id menu to edit:");
			id = scanner.nextInt();
			Alcohol alcoholMenu = new Alcohol();
			System.out.println("Input new infomation");
			inputMenu(alcoholMenu);
			editAlcoholMenu(id, alcoholMenu);
			break;
		default:
			break;
		}
	}
}
