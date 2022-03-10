package controller;


import java.text.ParseException;
import java.util.ArrayList;

import model.dao.BillDAO;
import model.dao.MenuData;
import model.utils.Bill;
import model.utils.MenuItemsInBill;
import view.ViewBill;

public class BillController {
	private BillDAO billModel;
	private ViewBill billView;
	static Bill bill= new Bill();
	public BillController() {
		super();
		
		this.billModel = new BillDAO();
	}
	public void orderBreakfastMenu() {
		billView = new ViewBill();
		billView.orderBreakfastMenu(MenuData.BREAKFAST_MENUS);
	}
	public void orderLunchMenu() {
		billView.orderLunchMenu(MenuData.LUNCH_MENUS);
	}
	public void orderDinnerMenu() {
		billView.orderDinnerMenu(MenuData.DINNER_MENUS);
	}
	public void orderAlcohol() {
		billView.orderAlcoholMenu(MenuData.ALCOHOL_MENUS);
	}
	public void orderSoftDrinkMenu() {
		billView.orderSoftDrinkMenu(MenuData.SOFT_DRINK_MENUS);
	}

	public void deleteMenuInBill() {
		billView.deleteMenu();
	}

	public Bill inputDataBill(ArrayList<MenuItemsInBill>list, String date, String time) throws ParseException {
		
		return billModel.inputBill(list,date, time);
		  
	}
	public void inputBill() {
		billView.inputBill();
	}
	public void showBill() {
		billView= new ViewBill();
		billView.outputBill();
	}
	public void orderMenu() {
		billView = new ViewBill();
		billView.chooseOrderMenu();
	}
	
}
