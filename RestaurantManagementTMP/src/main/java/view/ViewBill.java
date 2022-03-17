package view;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.BillController;
import model.dao.MenuData;
import model.utils.Alcohol;
import model.utils.Bill;
import model.utils.BreakfastMenu;
import model.utils.DinnerMenu;
import model.utils.LunchMenu;
import model.utils.MenuItems;
import model.utils.MenuItemsInBill;
import model.utils.SoftDrink;

public class ViewBill {
	Scanner scanner = new Scanner(System.in);
	BillController billController = new BillController();
	static Bill bill;
	static ArrayList<MenuItemsInBill> listMenuInBill = new ArrayList<MenuItemsInBill>();
	ViewMenu viewMenu;

	void orderMenu(MenuItems menuItem, int quantity) {
		boolean status = false;
		for (int i = 0; i < listMenuInBill.size(); i++) {
			if (listMenuInBill.get(i).getMenu() == menuItem) {
				int oldQuantity = listMenuInBill.get(i).getQuantity();
				listMenuInBill.get(i).setQuantity(oldQuantity + quantity);
				listMenuInBill.set(i, listMenuInBill.get(i));
				status = true;
			}
		}
		if (!status) {
			MenuItemsInBill bill = new MenuItemsInBill();
			bill.setMenu(menuItem);
			bill.setQuantity(quantity);
			listMenuInBill.add(bill);
		}
	}

	
	

	void findBreakfastMenu(ArrayList<BreakfastMenu> list, int id, int quantity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				orderMenu(list.get(i), quantity);
			}
		}
	}

	void findLunchMenu(ArrayList<LunchMenu> list, int id, int quantity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				orderMenu(list.get(i), quantity);
			}
		}
	}

	void findDinnerMenu(ArrayList<DinnerMenu> list, int id, int quantity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				orderMenu(list.get(i), quantity);
			}
		}
	}

	void findSoftDrinkMenu(ArrayList<SoftDrink> list, int id, int quantity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				orderMenu(list.get(i), quantity);
			}
		}
	}

	void findAlcoholMenu(ArrayList<Alcohol> list, int id, int quantity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdMenu() == id) {
				orderMenu(list.get(i), quantity);
			}
		}
	}

	void outputListMenu(int choose) {
		if (choose == 1) {
			System.out.println("List Breakfast menu");
			System.out.println(MenuData.BREAKFAST_MENUS);
		} else if (choose == 2) {
			System.out.println("List Lunch menu");
			System.out.println(MenuData.LUNCH_MENUS);
		} else if (choose == 3) {
			System.out.println("List Dinner menu");
			System.out.println(MenuData.DINNER_MENUS);
		} else if (choose == 4) {
			System.out.println("List SoftDrink menu");
			System.out.println(MenuData.SOFT_DRINK_MENUS);
		} else if (choose == 5) {
			System.out.println("List Alcohol Menu");
			System.out.println(MenuData.ALCOHOL_MENUS);
		}
		System.out.println("Choose id menu");
	}

	public void orderBreakfastMenu(ArrayList<BreakfastMenu> list) {
		outputListMenu(1);
		int idMenu = scanner.nextInt();
		System.out.println("Input quantity");
		int quantity = scanner.nextInt();
		findBreakfastMenu(list, idMenu, quantity);
	}

	public void orderLunchMenu(ArrayList<LunchMenu> list) {
		outputListMenu(2);
		int idMenu = scanner.nextInt();
		System.out.println("Input quantity");
		int quantity = scanner.nextInt();
		findLunchMenu(list, idMenu, quantity);
	}

	public void orderDinnerMenu(ArrayList<DinnerMenu> list) {
		outputListMenu(3);
		int idMenu = scanner.nextInt();
		System.out.println("Input quantity");
		int quantity = scanner.nextInt();
		findDinnerMenu(list, idMenu, quantity);
	}

	public void orderSoftDrinkMenu(ArrayList<SoftDrink> list) {
		outputListMenu(4);
		int idMenu = scanner.nextInt();
		System.out.println("Input quantity");
		int quantity = scanner.nextInt();
		findSoftDrinkMenu(list, idMenu, quantity);
	}

	public void orderAlcoholMenu(ArrayList<Alcohol> list) {
		outputListMenu(5);
		int idMenu = scanner.nextInt();
		System.out.println("Input quantity");
		int quantity = scanner.nextInt();
		findAlcoholMenu(list, idMenu, quantity);
	}

	public void inputBill() {
		try {
			scanner.nextLine();
			System.out.println("Input ordered time(HH:mm):");
			String time = scanner.nextLine();

			System.out.println("Input ordered date(dd-MM-yyyy):");
			String date = scanner.nextLine();
			bill = billController.inputDataBill(listMenuInBill, date, time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Please input ordered time with format (dd-MM-yyyy HH:mm)");
		}
	}
	public void deleteMenu() {
		System.out.println("Input id to delete:");
		int id = scanner.nextInt();
		listMenuInBill = deleteMenuInBill(id);
	}
	public ArrayList<MenuItemsInBill> deleteMenuInBill(int id) {
		
		for (int i = 0; i < listMenuInBill.size(); i++) {
			if (listMenuInBill.get(i).getId() == id) {
				listMenuInBill.remove(listMenuInBill.get(i));
			}
		}
		return listMenuInBill;

	}
	public void outputBill() {
		bill.setMenuItems(listMenuInBill);
		System.out.println(bill.toString());
	}

	public void chooseOrderMenu() {
		int choose;
		do {

			System.out.println("choose 0 to exit!");
			System.out.println("Choose menu");
			ViewMenuChoose.chooseMenu();
			choose = Integer.parseInt(scanner.nextLine());

			switch (choose) {
			case 1:
				billController.orderBreakfastMenu();
				break;
			case 2:
				billController.orderLunchMenu();
				break;
			case 3:
				billController.orderDinnerMenu();
				break;
			case 4:
				billController.orderSoftDrinkMenu();
				break;
			case 5:
				billController.orderAlcohol();
				break;
			default:
				break;
			}
		} while (choose != 0 && choose <= 5);
	}
}
