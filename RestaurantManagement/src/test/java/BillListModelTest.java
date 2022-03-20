import models.*;
import models.ItemsType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasProperty;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BillListModelTest {

    BillList billList = new BillList();
    @Test
    @Order(1)
    public void billListConstructorTest(){
        Assertions.assertTrue(billList.getBillList().isEmpty());
    }

    @Test
    @Order(2)
    public void addBillTest(){
        Food menuItems = new Food("abc", "des abc","http.com.vn", 10000, ItemsType.foodType.BREAKFAST);
        Bill bill = new Bill(3);
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        orderDetailsList.add(new OrderDetails(menuItems, 10));

        bill.setOrder(orderDetailsList);
        billList.addBill(bill);
        Assertions.assertFalse(billList.getBillList().isEmpty());
        Assertions.assertEquals(10*10000, billList.get(1).getTotalPrice());
        Assertions.assertEquals(1, billList.getBillList().size());
        Assertions.assertEquals(3, billList.get(1).getCustomerId());
//        Assertions.assertSame(orderDetailsList, billList.get(1).getOrder());
    }
}
