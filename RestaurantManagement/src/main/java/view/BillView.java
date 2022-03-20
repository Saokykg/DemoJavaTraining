package view;

import models.Bill;
import models.BillList;
import models.MenuItemList;
import models.OrderDetails;
import utils.BILLFUNCTION;
import utils.BILLSTATUS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillView {

    Scanner scanner = new Scanner(System.in);
    BillList billList = new BillList();

    private void showHeader(){
        System.out.printf("\n%-5s %-20s %-30s %-30s %-10s %-10s%n", "ID", "Name", "Description", "Image", "Price", "Type");
    }

    public BILLFUNCTION choseFunction(){
        System.out.println("1. Show all bill");
        System.out.println("2. Show ongoing bill");
        System.out.println("3. Show finised bill");
        System.out.println("4. Create new bill");
        System.out.println("5. Payment");
        System.out.println("0. Exit");
        return BILLFUNCTION.values()[Integer.parseInt(scanner.nextLine())];

    }
    public void showAllBill(){
        for (Bill bill : billList.getBillList()) {
            System.out.println(bill);
        }
    }
    public void showOngoingBill(){
        for (Bill bill : billList.getBillList()) {
            if (bill.getStatus().equals(BILLSTATUS.ONGOING))
                System.out.println(bill);
        }
    }
    public void showFinishedBill(){
        for (Bill bill : billList.getBillList()) {
            if (bill.getStatus().equals(BILLSTATUS.FINISHED))
                System.out.println(bill);
        }
    }

    public Bill createNewBill(){
        MenuItemList menuItemList = new MenuItemList();

        System.out.println("Enter customer id: ");
        Bill bill = new Bill(scanner.nextInt());
        scanner.nextLine();
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        int choice = -1;
        do{
            System.out.println("0, stop");
            System.out.println("1, view menu list");
            System.out.println("2, order");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    menuItemList.showFullMenu();
                    break;
                case 2:
                    System.out.print("Enter item id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter amount: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    OrderDetails orderDetails = new OrderDetails(menuItemList.get(id), amount);
                    orderDetailsList.add(orderDetails);
                default:
                    break;
            }
        }while(choice != 0);
        bill.setOrder(orderDetailsList);
        return bill;
    }

    public int choseBillById(){
        System.out.print("Enter bill id: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
