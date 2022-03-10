package model.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bill {
	private ArrayList<MenuItemsInBill> menuItems;
	private Date orderedTime;
	private Date orderedDate;
	private int idBill;
	private static int countID = 0;
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public Bill(ArrayList<MenuItemsInBill> menuItems, Date orderedTime) {
		super();
		this.idBill = ++countID;
		this.menuItems = menuItems;
		this.orderedTime = orderedTime;

	}

	public Bill() {
		super();
		this.idBill = ++countID;
	}

	public ArrayList<MenuItemsInBill> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(ArrayList<MenuItemsInBill> menuItems) {
		this.menuItems = menuItems;
	}

	public Date getOrderedTime() {
		return orderedTime;
	} 

	public void setOrderedTime(String orderedTime) throws ParseException {
		this.orderedTime = timeFormat.parse(orderedTime);
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) throws ParseException {
		this.orderedDate = dateFormat.parse(orderedDate);
	}

	@Override
	public String toString() {
		return "Bill [idBill=" + idBill + ", menuItems=" + menuItems.toString() +
				"\n orderedTime=" + timeFormat.format(orderedTime)
				+ ", orderedDate=" + dateFormat.format(orderedDate) + "]";
	}

}
