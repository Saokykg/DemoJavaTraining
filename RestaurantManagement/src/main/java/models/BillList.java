package models;

import java.util.ArrayList;
import java.util.List;

public class BillList {
    public static List<Bill> billList = new ArrayList<>();
    public static List<OrderDetails> currentOrder = new ArrayList<>();

    private BillList(){}

    public static String[] getHeader(){
        return new String[]{"Date", "Time", "Total price"};
    }

    public static void addOrder(MenuItems order){
        boolean kt = false;
        for (OrderDetails o : currentOrder){
            if (o.getMenu().equals(order)) {
                kt = true;
                o.setAmount(o.getAmount() + 1);
                break;
            }
        }
        if (!kt){
            currentOrder.add(new OrderDetails(order));
        }
    }

    public static void addOrder(OrderDetails orderDetails){
        for (OrderDetails orderDetails1 : currentOrder){
            if (orderDetails1.getMenu().equals(orderDetails.getMenu())){
                orderDetails1.setAmount(orderDetails.getAmount() + orderDetails1.getAmount());
                return;
            }
        }
        currentOrder.add(orderDetails);
    }

    public static void editOrder(OrderDetails order){
        currentOrder.remove(order);
    }

//    public static void cancelOrder(int id){}

    public static void clearOrder(){
        currentOrder.clear();
    }

    public static void addBill(Bill bill){
        billList.add(bill);
    }

    public static List<Bill> getBillList() {
        return billList;
    }

    public static void setBillList(List<Bill> billList) {
        BillList.billList = billList;
    }

    public static List<OrderDetails> getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(List<OrderDetails> currentOrder) {
        BillList.currentOrder = currentOrder;
    }

}
