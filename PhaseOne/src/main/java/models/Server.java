package models;

import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Menu> menuList = new ArrayList<>();

    public static Menu get(int id){
        for (Menu o : menuList){
            if (o.getId() == id)
                return o;
        }
        return null;
    }
}
