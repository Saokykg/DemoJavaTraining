import controller.MainController;
import controller.ServerController;
import models.*;
import models.Enum;
import view.MainView;
import view.ServerView;

import java.io.FileNotFoundException;

public class app { //rest application
    public static void main(String[] args) throws FileNotFoundException {

        ServerController serverController = new ServerController(new ServerView());
        serverController.input("src/input/input.txt");


        MainView view = new MainView();
        MainController mainController = new MainController(view);
        mainController.start();
    }
}
