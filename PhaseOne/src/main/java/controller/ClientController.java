package controller;

import models.*;
import view.ClientView;

import java.time.LocalDate;
import java.time.LocalTime;

public class ClientController {
    private final ClientView view;
    Client client = new Client();

    public ClientController(ClientView view){
        this.view = view;
    }
    public void access(){
        while (true) {
            int choice = view.choseFunction();
            switch (choice) {
                case 1:
                    view.showMenuList();
                    break;
                case 2:
                    view.showFoodMenuList();
                    break;
                case 3:
                    view.showDrinkMenuList();
                    break;
                case 4:
                    OrderDetails orderDetails = view.ordering();
                    client.addOrder(orderDetails);
                    break;
                case 5:
                    view.showListCurrentOrder();
                    break;
                case 6:
                    if (Client.currentOrder.isEmpty()){
                        System.out.println("No order!!!");
                        break;
                    }
                    Bill bill = new Bill();
                    double tp = 0.0;
                    for (OrderDetails order : Client.currentOrder){
                        tp += order.getAmount() * order.getMenu().getPrice();
                    }
                    bill.setTotalPrice(tp);
                    bill.setDate(LocalDate.now());
                    bill.setTime(LocalTime.now());
                    bill.setOrder(Client.currentOrder);
                    client.addBill(bill);
                    client.clearOrder();
                    break;
                case 7:
                    view.showBillHistory();
                    break;
                case 0:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

}
