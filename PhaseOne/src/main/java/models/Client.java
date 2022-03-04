package models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static List<Bill> billList = new ArrayList<>();
    public static List<OrderDetails> currentOrder = new ArrayList<>();


    public void addOrder(Menu order){
        boolean kt = false;
        for (OrderDetails o : currentOrder){
            if (o.equals(order)) {
                kt = true;
                o.setAmount(o.getAmount() + 1);
                break;
            }
        }
        if (!kt){
            currentOrder.add(new OrderDetails(order));
        }
    }

    public void addOrder(OrderDetails orderDetails){
        for (OrderDetails orderDetails1 : currentOrder){
            if (orderDetails1.getMenu().equals(orderDetails.getMenu())){
                orderDetails1.setAmount(orderDetails.getAmount() + orderDetails1.getAmount());
                return;
            }
        }
        currentOrder.add(orderDetails);
    }

    public void cancelOrder(OrderDetails order){
        currentOrder.remove(order);
    }

    public void cancelOrder(int id){

    }

    public void clearOrder(){
        currentOrder.clear();
    }

    public void addBill(Bill bill){
        billList.add(bill);
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        Client.billList = billList;
    }

    public List<OrderDetails> getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(List<OrderDetails> currentOrder) {
        Client.currentOrder = currentOrder;
    }
}
