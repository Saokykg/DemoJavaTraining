package models;

import java.util.ArrayList;
import java.util.List;

public class MenuItemList {

    public static List<MenuItem> menuList = new ArrayList<>();

    public MenuItem get(int id){
        for (MenuItem o : menuList){
            if (o.getId() == id)
                return o;
        }
        return null;
    }

    public void addItem(MenuItem menuItem){
        menuList.add(menuItem);
    }

    public void removeItem(MenuItem menuItem){
        menuList.remove(menuItem);
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuItem> menuList) {
        MenuItemList.menuList = menuList;
    }

    public void showFullMenu(){
        menuList.forEach(System.out::println);
    }

    public void showFoodMenu(){
        menuList.forEach(menuItem -> {
            if (menuItem instanceof Food)
                System.out.println(menuItem);
        });
    }

    public void showDrinkMenu(){
        menuList.forEach(menuItem -> {
            if (menuItem instanceof Drink)
                System.out.println(menuItem);
        });
    }

}
