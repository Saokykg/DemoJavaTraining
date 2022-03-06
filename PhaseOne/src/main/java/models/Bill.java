package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<OrderDetails> order;
    private LocalDate date;
    private LocalTime time;
    private Double totalPrice;

    @Override
    public String toString() {
        StringBuilder myOrder = new StringBuilder();
        myOrder.append("-----------------------------------\n");
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
}
