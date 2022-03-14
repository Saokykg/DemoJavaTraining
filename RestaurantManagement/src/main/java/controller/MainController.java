package controller;

import view.ClientView;
import view.MainView;
import view.ServerView;

public class MainController {

    private final MainView view;

    public MainController(MainView view) {
        this.view = view;
    }

    public void start(){
        while (true) {
            switch (view.getMainMenu()) {
                case 1: //const serverIdx = x
                    ServerView serverView = new ServerView();
                    MenuItemsListController menuItemsListController = new MenuItemsListController(serverView);
                    menuItemsListController.access();
                    break;
                case 2:
                    ClientView clientView = new ClientView();
                    BillListController billListController = new BillListController(clientView);
                    billListController.access();
                    break;
                case 3:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
