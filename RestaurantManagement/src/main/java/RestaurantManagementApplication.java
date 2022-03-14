import controller.MainController;
import controller.MenuItemsListController;
import view.MainView;
import view.ServerView;

import java.io.FileNotFoundException;

public class RestaurantManagementApplication { //rest application
    public static void main(String[] args) throws FileNotFoundException {

        MenuItemsListController menuItemsListController = new MenuItemsListController(new ServerView());
        menuItemsListController.input("src/input/input.txt");


        MainView view = new MainView();
        MainController mainController = new MainController(view);
        mainController.start();
    }
}
