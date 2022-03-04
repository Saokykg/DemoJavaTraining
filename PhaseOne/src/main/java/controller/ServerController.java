package controller;

import models.Drink;
import models.Food;
import models.Server;
import view.ServerView;

public class ServerController {
    private ServerView view;

    public ServerController(ServerView view){
        this.view = view;
    }

    public void access(){
        while (true) {
            int choice = view.choseFunction();
            switch (choice) {
                case 1:
                    view.showMenuList();
                    break;
                case 2:
                    view.showFoodMenuList();
                    break;
                case 3:
                    view.showDrinkMenuList();
                    break;
                case 4:
                    Food food = view.addFood();
                    Server.menuList.add(food);
                    break;
                case 5:
                    Server.menuList.add(view.addDrink());
                    break;
                case 6:
                    Server.menuList.remove(Server.get(view.deleteMenuItem()));
                    break;
                case 7:
                    break;
                case 0:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
