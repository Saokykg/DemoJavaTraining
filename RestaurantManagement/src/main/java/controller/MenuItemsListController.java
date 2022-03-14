package controller;

import models.*;
import models.Enum;
import view.ServerView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuItemsListController {
    private final ServerView view;

    public MenuItemsListController(ServerView view){
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
                    MenuItemsList.addItem(food);
                    break;
                case 5:
                    MenuItemsList.addItem(view.addDrink());
                    break;
                case 6:
                    MenuItems deleteItems = null;
                    int choiceId;
                    do {
                        choiceId = view.deleteMenuItem();
                        if (choiceId == 0)
                            break;
                        for (MenuItems menuItems : MenuItemsList.menuList) {
                            if (choiceId == menuItems.getId()) {
                                deleteItems = menuItems;
                                break;
                            }
                        }
                        if (deleteItems == null)
                            System.out.println("Id not found\nInput again"); //cant find item with id user input
                    }while(deleteItems != null);
                    if (choiceId != 0)
                        MenuItemsList.removeItem(deleteItems);
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
            String[] info = reader.split(", ");
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
            MenuItemsList.menuList.add(menu);
        }
    }
}
