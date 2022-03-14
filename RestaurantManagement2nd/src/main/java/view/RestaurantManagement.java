package view;

import controllers.BillController;
import controllers.MenuController;
import controllers.OrderController;
import models.Bill;
import utils.MAINFUNCTION;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaurantManagement {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            boolean check;
            MAINFUNCTION chosenFunction = null;
            do {
                int idx = 0;
                for (MAINFUNCTION function : MAINFUNCTION.values()) {
                    System.out.printf("%d, %s\n",idx++, function);
                }
                System.out.print("Input your choice: ");
                    check = false;
                    try {
                        choice = scanner.nextInt();
                    }catch (InputMismatchException ex){
                        ex.printStackTrace();
                        check = true;
                        System.out.println("SOMETHING WRONG\nPLS try again!!!");
                    }
                    try {
                        chosenFunction = MAINFUNCTION.values()[choice];
                    }catch (ArrayIndexOutOfBoundsException ex){
                        ex.printStackTrace();
                        check = true;
                        System.out.println("SOMETHING WRONG\nPLS try again!!!");
                    }
                    scanner.nextLine();
            }while (check);
            System.out.println();

            switch (chosenFunction){
                case ORDER:
                    OrderView orderView = new OrderView();
                    OrderController orderController = new OrderController(orderView);
                    orderController.showControlMenu();
                    break;
                case BILL:
                    BillView billView = new BillView();
                    BillController billController = new BillController(billView);
                    billController.showControlMenu();
                    break;
                case MENU:
                    MenuView menuView = new MenuView();
                    MenuController menuController = new MenuController(menuView);
                    menuController.showControlMenu();
                    break;
                case EXIT:
                    return;
                default:{
                    System.out.println("NOT FOUND\nPLS try again");
                }
            }
        }while(true);
    }
}
