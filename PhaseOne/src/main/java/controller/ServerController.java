package controller;

import models.*;
import models.Enum;
import view.ServerView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ServerController {
    private final ServerView view;

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

    public void input(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String reader = scanner.nextLine();
            String info[] = reader.split(", ");
            MenuItems menu = null;
            switch (info[0]){
                case "SOFTDRINK":
                    menu = new SoftDrink();
                    break;
                case "ALCOHOL":
                    try {
                        menu = new Alcohol(Double.parseDouble(info[5]));
                    }catch (NumberFormatException | NullPointerException ex){
                        ex.printStackTrace();
                    }
                    break;
                case "BREAKFAST":
                    menu = new Food(Enum.foodType.BREAKFAST);
                    break;
                case "LUNCH":
                    menu = new Food(Enum.foodType.LUNCH);
                    break;
                case "DINNER":
                    menu = new Food(Enum.foodType.DINNER);
                    break;
                default: throw new AssertionError();
            }
            menu.setName(info[1]);
            menu.setDescripton(info[2]);
            menu.setImage(info[3]);
            try {
                menu.setPrice(Double.parseDouble(info[4]));
            }catch (NumberFormatException | NullPointerException ex){
                ex.printStackTrace();
            }
            Server.menuList.add(menu);
        }
    }
}
