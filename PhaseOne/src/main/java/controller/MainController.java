package controller;

import view.ClientView;
import view.MainView;
import view.ServerView;

public class MainController {
    private MainView view;
    public MainController(MainView view) {
        this.view = view;
    }

    public void start(){
        while (true) {
            switch (view.getMainMenu()) {
                case 1:
                    ServerView serverView = new ServerView();
                    ServerController serverController = new ServerController(serverView);
                    serverController.access();
                    break;
                case 2:
                    ClientView clientView = new ClientView();
                    ClientController clientController = new ClientController(clientView);
                    clientController.access();
                    break;
                case 3:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
