package models;

import java.util.ArrayList;
import java.util.List;

public class MenuItemList {
    public static List<MenuItem> menuItemList = new ArrayList<>();

    public boolean add(MenuItem menuItem){
        return menuItemList.add(menuItem);
    }

    public boolean remove(MenuItem menuItem){
        return menuItemList.remove(menuItem);
    }

    public void showFullMenu(){
        menuItemList.forEach(System.out::println);
    }

    public void showFoodMenu(){
        menuItemList.forEach(menuItem -> {
            if (menuItem instanceof Food)
                System.out.println(menuItem);
        });
    }

    public void showDrinkMenu(){
        menuItemList.forEach(menuItem -> {
            if (menuItem instanceof Drink)
                System.out.println(menuItem);
        });
    }
}
