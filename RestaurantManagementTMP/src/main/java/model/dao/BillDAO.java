package model.dao;

import java.text.ParseException;
import java.util.ArrayList;

import model.utils.Bill;
import model.utils.MenuItems;
import model.utils.MenuItemsInBill;

public class BillDAO {
	static ArrayList<MenuItemsInBill> listMenuInBill = new ArrayList<MenuItemsInBill>();

	public ArrayList<MenuItemsInBill> orderMenu(MenuItems menuItem, int quantity) {
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
		return listMenuInBill;
	}

	public Bill inputBill(ArrayList<MenuItemsInBill> list, String date, String time) throws ParseException {
		Bill bill = new Bill();
		bill.setMenuItems(list);
		bill.setOrderedDate(date);
		bill.setOrderedTime(time);
		return bill;
	}
	public ArrayList<MenuItemsInBill> deleteMenuInBill(int id) {
		
		for (int i = 0; i < listMenuInBill.size(); i++) {
			if (listMenuInBill.get(i).getId() == id) {
				listMenuInBill.remove(listMenuInBill.get(i));
			}
		}
		return listMenuInBill;

	}
	
	
}
