package view;

import models.*;

import java.io.IOException;
import java.util.Scanner;

public class ClientView {

    private void showHeader(){
        System.out.printf("\n%-5s %-20s %-30s %-30s %-10s %-10s%n", "ID", "Name", "Description", "Image", "Price", "Type");
    }

    Scanner scanner = new Scanner(System.in);

    public int choseFunction(){
        System.out.println("1. list full menu");
        System.out.println("2. list food menu");
        System.out.println("3. list drink menu");
        System.out.println("4. Ordering");
        System.out.println("5. Edit order");
        System.out.println("6. List order");
        System.out.println("7. Payment");
        System.out.println("8. Bill history");
        System.out.println("9. Print bills");
        System.out.println("0. Exit");
        do {
            try {
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException ex){
                ex.printStackTrace();
                System.out.println("Enter again!!!");
            }
        }while (true);
    }

    public void showMenuList(){
        showHeader();
        for (MenuItems o : MenuItemsList.menuList) {
            System.out.println(o);
        }
    }

    public void showFoodMenuList(){
        showHeader();
        for (MenuItems o : MenuItemsList.menuList) {
            if (o instanceof Food)
                System.out.println(o);
        }
    }

    public void showDrinkMenuList(){
        showHeader();
        for (MenuItems o : MenuItemsList.menuList) {
            if (o instanceof Drink)
                System.out.println(o);
        }
    }

    public OrderDetails ordering() {
        OrderDetails orderDetails = new OrderDetails();
        System.out.print("Input id item: ");
        orderDetails.setMenu(MenuItemsList.get(Integer.parseInt(scanner.nextLine())));
        System.out.print("Input amount: ");
        orderDetails.setAmount(Integer.parseInt(scanner.nextLine()));
        return orderDetails;
    }

    public void showListCurrentOrder(){
        int idx = 0;
        for (OrderDetails orderDetails : BillList.currentOrder){
            idx++;
            System.out.printf("%d - %s\n",idx, orderDetails);
        }
    }

    public void showBillHistory(){
        BillList.billList.forEach(System.out::println);
    }

    public int selectOrderToEdit(){
        this.showListCurrentOrder();
        System.out.print("Enter order idx: ");
        int choice = -1;
        boolean  notPass;
        do {
            notPass = false;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                notPass = true;
            }
        }while(notPass);

        return choice;
    }

    public int inputNewAmout(OrderDetails order){
        System.out.printf("Name: %s\n", order.getMenu());
        System.out.printf("Amount: %d\n", order.getAmount());
        System.out.print("Enter new amount (-1 to cancel action): ");
        int choice = -1;
        boolean  notPass;
        do {
            notPass = false;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex){
                ex.printStackTrace();
                notPass = true;
            }
        }while(notPass);

        return choice;
    }

    public String enterFileOutputName(){
        return scanner.nextLine();
    }
}
