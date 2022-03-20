package controller;

import models.*;
import models.ItemsType;
import utils.MENUFUNCTION;
import view.ItemView;
import view.MenuView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuController {
    private final MenuView view;
    MenuItemList menuItemList = new MenuItemList();

    public MenuController(MenuView view){
        this.view = view;
    }

    public void access(){
        while (true) {
            MENUFUNCTION choice = view.choseFunction();
            System.out.println(choice);
            switch (choice) {
                case SHOW_MENU_LIST:
                    view.showMenuList();
                    break;
                case SHOW_FOOD_LIST:
                    view.showFoodMenuList();
                    break;
                case SHOW_DRINK_LIST:
                    view.showDrinkMenuList();
                    break;
                case ADD_ITEM:
                    MenuItem menuItem = this.view.inputNewMenuItem();
                    menuItemList.addItem(menuItem);
                    break;
                case SELECT_ITEM:
                    MenuItem selectItem = this.view.selectItem();
                    ItemController itemController = new ItemController(new ItemView(), selectItem);
                    itemController.access();
                    break;
                case EXIT:
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
            MenuItem menu = null;
            switch (info[0]){
                case "SOFTDRINK":
                    menu = new Drink();
                    break;
                case "ALCOHOL":
                    try {
                        menu = new Drink(ItemsType.drinkType.ALCOHOL);
                    }catch (NumberFormatException | NullPointerException ex){
                        ex.printStackTrace();
                    }
                    break;
                case "BREAKFAST":
                    menu = new Food(ItemsType.foodType.BREAKFAST);
                    break;
                case "LUNCH":
                    menu = new Food(ItemsType.foodType.LUNCH);
                    break;
                case "DINNER":
                    menu = new Food(ItemsType.foodType.DINNER);
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
            MenuItemList.menuList.add(menu);
        }
    }
}
