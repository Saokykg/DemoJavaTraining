package view;

import models.*;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientView {

    private void showHeader(){
        System.out.println(String.format("\n%-5s %-20s %-50s %-20s %-10s %-10s", "ID", "Name", "Description", "Image", "Price", "Type"));
    }

    Scanner scanner = new Scanner(System.in);

    public int choseFunction(){
        System.out.println("1. list full menu");
        System.out.println("2. list food menu");
        System.out.println("3. list drink menu");
        System.out.println("4. Ordering");
        System.out.println("5. List order");
        System.out.println("6. Payment");
        System.out.println("7. Bill history");
        System.out.println("0. Exit");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showMenuList(){
        showHeader();
        for (Menu o : Server.menuList) {
            System.out.println(o);
        }
    }

    public void showFoodMenuList(){
        showHeader();
        for (Menu o : Server.menuList) {
            if (o instanceof Food)
                System.out.println(o);
        }
    }

    public void showDrinkMenuList(){
        showHeader();
        for (Menu o : Server.menuList) {
            if (o instanceof Drink)
                System.out.println(o);
        }
    }

    public OrderDetails ordering() {
        OrderDetails orderDetails = new OrderDetails();
        System.out.print("Input id item: ");
        orderDetails.setMenu(Server.get(Integer.parseInt(scanner.nextLine())));
        System.out.print("Input amount: ");
        orderDetails.setAmount(Integer.parseInt(scanner.nextLine()));
        return orderDetails;
    }

    public void showListCurrentOrder(){
        for (OrderDetails orderDetails : Client.currentOrder){
            System.out.println(orderDetails);
        }
    }
    public void showBillHistory(){
        Client.billList.forEach((b)->{
            System.out.println(b);
        });
    }
}
