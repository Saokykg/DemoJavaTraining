import models.*;
import models.Enum;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.Matchers.hasProperty;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BillListModelTest {

    @Test
    @Order(1)
    public void billListConstructorTest(){
        Assertions.assertTrue(BillList.getBillList().isEmpty());
        Assertions.assertTrue(BillList.getCurrentOrder().isEmpty());
    }

    @Test
    @Order(2)
    public void addOneOrderTest(){
        Food menuItems = new Food("abc", "des abc","http.com.vn", 10000, Enum.foodType.BREAKFAST);
        BillList.addOrder(menuItems);
        Assertions.assertFalse(BillList.getCurrentOrder().isEmpty());
        Assertions.assertEquals(1, BillList.getCurrentOrder().size());

        Assertions.assertSame(menuItems, BillList.getCurrentOrder().get(0).getMenu());
        Assertions.assertEquals(1, BillList.getCurrentOrder().get(0).getAmount());

        BillList.addOrder(menuItems);
        Assertions.assertEquals(2, BillList.getCurrentOrder().get(0).getAmount());
    }

    @Test
    @Order(3)
    public void clearOrderTest(){

        BillList.clearOrder();

        Assertions.assertEquals(0, BillList.getCurrentOrder().size());
        Assertions.assertTrue(BillList.getCurrentOrder().isEmpty());
        Assertions.assertTrue(BillList.getBillList().isEmpty());
    }

    @Test
    @Order(4)
    public void addOrderWithDetailTest(){
        Food menuItems2 = new Food("123", "des 123","http.com.vn", 10000, Enum.foodType.BREAKFAST);

        OrderDetails orderDetails = new OrderDetails(menuItems2, 2);
        BillList.addOrder(orderDetails);//add 2 food 123

        Assertions.assertFalse(BillList.getCurrentOrder().isEmpty());
        Assertions.assertEquals(1, BillList.getCurrentOrder().size());
        Assertions.assertSame(menuItems2, BillList.getCurrentOrder().get(0).getMenu());
        Assertions.assertEquals(2, BillList.getCurrentOrder().get(0).getAmount());

        OrderDetails orderDetails2 = new OrderDetails(menuItems2, 3);
        BillList.addOrder(orderDetails2); //add 3 more food 123
        Assertions.assertEquals(5, BillList.getCurrentOrder().get(0).getAmount());

        Food menuItems3 = new Food("xyz", "des abc","http.com.vn", 2000, Enum.foodType.LUNCH);
        OrderDetails orderDetails3 = new OrderDetails(menuItems3, 3);

        BillList.addOrder(orderDetails3);

        Assertions.assertEquals(2, BillList.getCurrentOrder().size());
    }

    @Test
    @Order(5)
    public void addBillTest(){
//
//        Food menuItems = new Food("abc", "des abc","http.com.vn", 10000, Enum.foodType.BREAKFAST);
//        OrderDetails orderDetails = new OrderDetails(menuItems, 2);
//        BillList.addOrder(orderDetails);
//
//        Food menuItems2 = new Food("123", "des abc","http.com.vn", 10000, Enum.foodType.BREAKFAST);
//        OrderDetails orderDetails2 = new OrderDetails(menuItems2, 2);
//        BillList.addOrder(orderDetails2);
//
//        Food menuItems3 = new Food("xyz", "des abc","http.com.vn", 2000, Enum.foodType.BREAKFAST);
//        OrderDetails orderDetails3 = new OrderDetails(menuItems3, 3);
//        BillList.addOrder(orderDetails3);

        Bill currentBill = new Bill(BillList.getCurrentOrder());

        BillList.addBill(currentBill); // test here

        Assertions.assertEquals(1, BillList.getBillList().size());
        Assertions.assertSame(currentBill, BillList.getBillList().get(0));
        Assertions.assertTrue(BillList.getBillList().contains(currentBill));
    }


}
