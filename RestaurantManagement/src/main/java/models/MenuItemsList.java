package models;

import java.util.ArrayList;
import java.util.List;

public class MenuItemsList {

    private MenuItemsList(){}

    public static List<MenuItems> menuList = new ArrayList<>();

    public static MenuItems get(int id){
        for (MenuItems o : menuList){
            if (o.getId() == id)
                return o;
        }
        return null;
    }

    public static void addItem(MenuItems menuItems){
        menuList.add(menuItems);
    }

    public static void removeItem(MenuItems menuItems){
        menuList.remove(menuItems);
    }

    public static List<MenuItems> getMenuList() {
        return menuList;
    }

    public static void setMenuList(List<MenuItems> menuList) {
        MenuItemsList.menuList = menuList;
    }

}
