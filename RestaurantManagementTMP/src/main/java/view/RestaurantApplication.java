package view;

import java.io.IOException;
import java.util.Scanner;

import controller.BillController;
import controller.MenuController;

public class RestaurantApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		MenuController menuController = new MenuController();
		BillController billController = new BillController();
		ViewMenuChoose.selectAction();

		try {
			menuController.initListMenus();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int choose;
		do {
			System.out.println("Input a number in menu:");
			choose = scanner.nextInt();
			scanner.close();
			switch (choose) {
				case 0:
					return;
				case 1:
					menuController.chooseMenuInput();
					break;
				case 2:
					menuController.showMenu();
					break;
				case 3:
					menuController.editMenu();
					break;
				case 4:
					menuController.deleteMenu();
					break;
				case 5:
					billController.orderMenu();
					billController.inputBill();
					break;
				case 6:
					billController.showBill();
					break;
				case 7:
					billController.orderMenu();
					break;
				case 8:
					billController.deleteMenuInBill();
					break;
				default:
					break;
				}
		} while (true);
	}

}
