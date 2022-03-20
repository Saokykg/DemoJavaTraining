package models;

import java.util.ArrayList;
import java.util.List;

public class BillList {
    public static List<Bill> billList = new ArrayList<>();

    public static String[] getHeader(){
        return new String[]{"Date", "Time", "Total price"};
    }

    public Bill get(int id){
        for (Bill bill : billList) {
            if (bill.getId() == id)
                return bill;
        }
        return null;
    }
    public void addBill(Bill bill){
        billList.add(bill);
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        BillList.billList = billList;
    }

}
