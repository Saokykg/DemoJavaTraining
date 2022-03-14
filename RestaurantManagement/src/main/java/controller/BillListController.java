package controller;

import com.opencsv.CSVWriter;
import models.*;
import view.ClientView;;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static controller.SwitchName.BillListSwitch.*;

public class BillListController {
    private final ClientView view;

    public BillListController(ClientView view){
        this.view = view;
    }
    public void access(){
        while (true) {
            int choice = view.choseFunction();
            switch (choice) {
                case SHOW_FULL_MENU:
                    view.showMenuList();
                    break;
                case SHOW_FOOD_MENU:
                    view.showFoodMenuList();
                    break;
                case SHOW_DRINK_MENU:
                    view.showDrinkMenuList();
                    break;
                case ORDER:
                    OrderDetails orderDetails = view.ordering();
                    BillList.addOrder(orderDetails);
                    break;
                case EDIT_ORDER:
                    int orderIdx = view.selectOrderToEdit();
                    OrderDetails selectedOrder;
                    try {
                        selectedOrder = BillList.getCurrentOrder().get(orderIdx-1);
                    } catch (IndexOutOfBoundsException ex){
                        ex.printStackTrace();
                        System.out.println("Index not found\nPls restart action");
                        break;
                    }
                    int newAmount = view.inputNewAmout(selectedOrder);
                    if (newAmount != -1)
                        selectedOrder.setAmount(newAmount);
                    break;
                case SHOW_CURRENT_ORDER:
                    view.showListCurrentOrder();
                    break;
                case PAYMENT:
                    if (BillList.currentOrder.isEmpty()){
                        System.out.println("No order!!!");
                        break;
                    }
                    Bill bill = new Bill(BillList.currentOrder);

                    BillList.addBill(bill);
                    BillList.clearOrder();
                    break;
                case SHOW_BILL_HISTORY:
                    view.showBillHistory();
                    break;
                case PRINT_BILL_HISTORY:
                    System.out.print("Start printing to file: ");
                    String fileName = view.enterFileOutputName();
                    File file = new File(String.format("%s.csv", fileName));
                    try {
                        // create FileWriter object with file as parameter
                        FileWriter outputfile = new FileWriter(file);
                        // create CSVWriter object filewriter object as parameter
                        CSVWriter writer = new CSVWriter(outputfile);

                        // adding header to csv
                        String[] header = { "Name", "Class", "Marks" };
                        writer.writeNext(BillList.getHeader());

                        BillList.getBillList().forEach(currentBill -> {
                            String[] data = { currentBill.getDate().toString(), currentBill.getTime().toString(), currentBill.getTotalPrice().toString() };
                            writer.writeNext(data);
                        });

                        // closing writer connection
                        writer.close();
                    }
                    catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case EXIT:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

}
