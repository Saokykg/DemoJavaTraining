package models;

import utils.BILLSTATUS;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private static int counter = 1;
    private int id;
    private int customerId;
    private List<OrderDetails> order;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
    private Double totalPrice;
    private BILLSTATUS status = BILLSTATUS.ONGOING;

    public Bill(int customerId){
        this.setId(counter++);
        this.setCustomerId(customerId);
    }
    public Bill(int customerId, List<OrderDetails> orderDetails){
        this.setId(counter++);
        this.setCustomerId(customerId);
        this.setOrder(orderDetails);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Bill.counter = counter;
    }

    public String[] getStringCsv(){
        return new String[]{this.date.toString(), this.time.toString(), this.totalPrice.toString()};
    }
    @Override
    public String toString() {
        StringBuilder myOrder = new StringBuilder();
        myOrder.append(String.format("------------------%d----------------\n", this.getId()));
        myOrder.append(String.format("Customer id: %d\n", this.customerId));
        for (OrderDetails o : this.order) {
            myOrder.append(String.format("%-10s  - %-3d\n", o.getMenu().getName(), o.getAmount()));
        }
        myOrder.append(String.format("Total: %s\n", this.totalPrice.toString()));
        myOrder.append(String.format("Date: %s\n", this.date.toString()));
        myOrder.append(String.format("Time: %s\n", this.time.toString()));
        myOrder.append("-----------------------------------\n");
        return myOrder.toString();
    }

    public List<OrderDetails> getOrder() {
        return order;
    }

    public void setOrder(List<OrderDetails> order) {
        this.order = new ArrayList<>(order);
        double price = 0.0;
        for (OrderDetails orderDetails : this.getOrder()) {
            price += orderDetails.getAmount() * orderDetails.getMenu().getPrice();
        }
        this.setTotalPrice(price);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BILLSTATUS getStatus() {
        return status;
    }

    public void setStatus(BILLSTATUS status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
