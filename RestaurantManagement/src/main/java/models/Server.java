package models;

import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<MenuItems> menuList = new ArrayList<>();

    public static MenuItems get(int id){
        for (MenuItems o : menuList){
            if (o.getId() == id)
                return o;
        }
        return null;
    }

}
