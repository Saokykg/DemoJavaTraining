import controller.MainController;
import controller.MenuController;
import view.MainView;
import view.MenuView;

import java.io.FileNotFoundException;

public class RestaurantManagementApplication { //rest application
    public static void main(String[] args) throws FileNotFoundException {

        MenuController menuController = new MenuController(new MenuView());
        menuController.input("src/input/input.txt");

        MainView view = new MainView();
        MainController mainController = new MainController(view);
        mainController.start();
    }
}
