package controller;

import view.BillView;
import view.MainView;
import view.OrderView;
import view.MenuView;

import utils.MAINFUNCTION;

public class MainController {

    private final MainView view;

    public MainController(MainView view) {
        this.view = view;
    }

    public void start(){
        while (true) {
            MAINFUNCTION choice = view.choseFunction();
            switch (choice) {
                case MENU:
                    MenuView menuView = new MenuView();
                    MenuController menuController = new MenuController(menuView);
                    menuController.access();
                    break;
                case BILL:
                    BillView billView = new BillView();
                    BillController billController = new BillController(billView);
                    billController.access();
                    break;
                case EXIT:
                    return;
                default:
                    System.out.println("WRONG INPUT");
                    break;
            }
        }
    }
}
