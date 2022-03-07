import controller.MainController;
import controller.ServerController;
import view.MainView;
import view.ServerView;

import java.io.FileNotFoundException;

public class RestaurantManagementApplication { //rest application
    public static void main(String[] args) throws FileNotFoundException {

        ServerController serverController = new ServerController(new ServerView());
        serverController.input("src/input/input.txt");


        MainView view = new MainView();
        MainController mainController = new MainController(view);
        mainController.start();
    }
}
