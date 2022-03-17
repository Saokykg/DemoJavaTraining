package controllers;

import models.MenuItem;
import utils.MENUITEMFUNCTION;
import view.MenuView;

public class MenuController {
    private MenuView view;

    public MenuController(MenuView view){
        this.view = view;
    }

    public void showControlMenu(){
        MENUITEMFUNCTION choice = this.view.showMainMenu();
        switch (choice){
            case SHOW_MENU_LIST:
                this.view.showFullMenu();
                break;
            case SHOW_FOOD_LIST:
                this.view.showFoodMenu();
                break;
            case SHOW_DRINK_LIST:
                this.view.showDrinkMenu();
                break;
            case ADD_ITEM:
                MenuItem menuItem = this.view.inputNewMenuItem();
                break;
            case SELECT_ITEM:
                break;
            case EXIT:
                break;
        }
    }
}
