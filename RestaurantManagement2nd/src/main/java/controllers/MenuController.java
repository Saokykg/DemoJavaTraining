package controllers;

import view.MenuView;

public class MenuController {
    private MenuView view;

    public MenuController(MenuView view){
        this.view = view;
    }

    public void showControlMenu(){
        int choice = this.view.showMainMenu();
    }
}
