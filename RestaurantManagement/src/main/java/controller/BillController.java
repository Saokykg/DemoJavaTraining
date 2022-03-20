package controller;

import com.opencsv.CSVWriter;
import models.*;
import utils.BILLFUNCTION;
import utils.BILLSTATUS;
import view.BillView;
import utils.BILLFUNCTION.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BillController {
    private final BillView view;

    public BillController(BillView view){
        this.view = view;
    }

    BillList billList = new BillList();

    public void access(){
        while (true) {
            BILLFUNCTION choice = view.choseFunction();
            switch (choice) {
                case SHOW_ALL_BILL:
                    view.showAllBill();
                    break;
                case SHOW_ONGOING_BILL:
                    view.showOngoingBill();
                    break;
                case SHOW_FINISHED_BILL:
                    view.showFinishedBill();
                    break;
                case CREATE_NEW_BILL:
                    billList.addBill(view.createNewBill());
                    break;
                case PAYMENT:
                    int id = view.choseBillById();
                    Bill bill = billList.get(id);
                    bill.setStatus(BILLSTATUS.FINISHED);
                    System.out.println("DONE");
                    break;
                case EXIT:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

}
