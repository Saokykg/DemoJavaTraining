import models.*;
import models.Enum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MenuListTest {

    @Test
    @Order(1)
    public void addItemTest(){
        List<MenuItems> itemListExpected = new ArrayList<>();;
        itemListExpected.add(new Food("AAA", "des abc","http.com.vn", 2000, Enum.foodType.LUNCH));
        itemListExpected.add(new Food("BBB", "des abc","http.com.vn", 20030, Enum.foodType.BREAKFAST));
        itemListExpected.add(new Food("CCC", "des abc","http.com.vn", 20700, Enum.foodType.LUNCH));
        itemListExpected.add(new Alcohol("ALCOHOL", "des abc","http.com.vn", 111111, 60));
        itemListExpected.add(new SoftDrink("SoftDrink", "des abc","http.com.vn", 4567));

        for (MenuItems menuItems : itemListExpected) {
            MenuItemsList.addItem(menuItems);
        }

        Assertions.assertFalse(MenuItemsList.getMenuList().isEmpty());
        Assertions.assertEquals(5, MenuItemsList.getMenuList().size());
        Assertions.assertTrue(MenuItemsList.getMenuList().containsAll(itemListExpected));
    }

    @Test
    @Order(2)
    public void removeItemTest(){
        MenuItems removeItem = MenuItemsList.getMenuList().get(3);
        MenuItemsList.removeItem(removeItem);
        Assertions.assertEquals(4, MenuItemsList.getMenuList().size());
        Assertions.assertFalse(MenuItemsList.getMenuList().contains(removeItem));
    }
}
