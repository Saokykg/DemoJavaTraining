import models.*;
import models.ItemsType;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MenuListTest {

    MenuItemList menuItemList = new MenuItemList();
    @Test
    @Order(1)
    public void addItemTest(){
        List<MenuItem> itemListExpected = new ArrayList<>();;
        itemListExpected.add(new Food("AAA", "des abc","http.com.vn", 2000, ItemsType.foodType.LUNCH));
        itemListExpected.add(new Food("BBB", "des abc","http.com.vn", 20030, ItemsType.foodType.BREAKFAST));
        itemListExpected.add(new Food("CCC", "des abc","http.com.vn", 20700, ItemsType.foodType.LUNCH));
        itemListExpected.add(new Drink("ALCOHOL", "des abc","http.com.vn", 111111, ItemsType.drinkType.ALCOHOL));
        itemListExpected.add(new Drink("SoftDrink", "des abc","http.com.vn", 4567, ItemsType.drinkType.SOFTDRINK));

        for (MenuItem menuItem : itemListExpected) {
            menuItemList.addItem(menuItem);
        }

        Assertions.assertFalse(menuItemList.getMenuList().isEmpty());
        Assertions.assertEquals(5, menuItemList.getMenuList().size());
        Assertions.assertTrue(menuItemList.getMenuList().containsAll(itemListExpected));
    }

    @Test
    @Order(2)
    public void removeItemTest(){
        MenuItem removeItem = menuItemList.getMenuList().get(3);
        menuItemList.removeItem(removeItem);
        Assertions.assertEquals(4, menuItemList.getMenuList().size());
        Assertions.assertFalse(menuItemList.getMenuList().contains(removeItem));
    }
}
