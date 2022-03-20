import models.*;
import models.ItemsType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BillModelTest {

    @Test
    public void billConstructorTest(){
        List<OrderDetails> listOrderDetails = new ArrayList<>();

        Food menuItems = new Food("abc", "des abc","http.com.vn", 10000, ItemsType.foodType.BREAKFAST);
        OrderDetails orderDetails = new OrderDetails(menuItems, 2);
        listOrderDetails.add(orderDetails);

        Food menuItems2 = new Food("123", "des abc","http.com.vn", 10000, ItemsType.foodType.BREAKFAST);
        OrderDetails orderDetails2 = new OrderDetails(menuItems2, 2);
        listOrderDetails.add(orderDetails2);

        Food menuItems3 = new Food("xyz", "des abc","http.com.vn", 2000, ItemsType.foodType.BREAKFAST);
        OrderDetails orderDetails3 = new OrderDetails(menuItems3, 3);
        listOrderDetails.add(orderDetails3);

        Bill bill = new Bill(10, listOrderDetails);

        LocalDate dateAfterConstruct = LocalDate.now();
        LocalTime timeAfterConstruct = LocalTime.now();

//        Assertions.assertSame(listOrderDetails, bill.getOrder());
        Assertions.assertEquals(10000*2+10000*2+2000*3, bill.getTotalPrice());
        Assertions.assertTrue(bill.getDate().getYear() == dateAfterConstruct.getYear() &&
                                    bill.getDate().getMonth() == dateAfterConstruct.getMonth() &&
                                    bill.getDate().getDayOfMonth() == dateAfterConstruct.getDayOfMonth()); //Wrong if test changing session from 23:59 to 00:00 nextday
        Assertions.assertTrue(bill.getTime().until(timeAfterConstruct, ChronoUnit.MINUTES) <= 1); //Check if time different is lower than 1 minute, error like about assert


    }
}
