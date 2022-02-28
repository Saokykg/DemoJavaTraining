package com.tma.views;

import com.tma.controller.CallController;
import com.tma.controller.GSMController;
import com.tma.utils.Call;
import com.tma.utils.GSM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GSMMenu {
    private GSM gsm;

    public GSMMenu(GSM gsm){
        this.gsm = gsm;
    }
    public void setGsm(GSM gsm) {
        this.gsm = gsm;
    }
    public GSM getGsm(){
        return this.gsm;
    }

    public void showGSMMenu() {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int chose = 0;
        while (true) {
            System.out.println("Command menu ");
            System.out.println("1. Call history");
            System.out.println("2. add call");
            System.out.println("3. remove longest call");
            System.out.println("4. price check");
            System.out.println("5. back!!!");
            System.out.print("Select command: ");
            try {
                chose = Integer.parseInt(sc.readLine());
            } catch (NumberFormatException | IOException ex){
                ex.printStackTrace();
            }
            switch (chose) {
                case 1:
                    this.viewCallHistory();
                    break;
                case 2:
                    this.addCall();
                    break;
                case 3:
                    this.removeLongestCall();
                    break;
                case 4:
                    this.priceCheck();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("command not found!!!");
                    break;
            }
        }
    }

    public void viewCallHistory(){
        System.out.println("=============call history=============");
        List<Call> callHistory = gsm.getCallHistory();
        for (Call call : callHistory) {
            System.out.println(call);
        }
        System.out.println("======================================");
    }

    public void addCall(){
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=============Add cally=============");
        try {
//            System.out.print("Date: ");
//            String date = sc.readLine();
//            System.out.print("Time: ");
//            String time = sc.readLine();
            System.out.print("Duration: ");
            float duration = 0;
            try {
                duration = Float.parseFloat(sc.readLine());
            } catch (NumberFormatException ex){
                ex.printStackTrace();
            }
            System.out.print("Dialed number: ");
            String dialed = sc.readLine();

            CallController callControl = new CallController();
            Call call = callControl.add(duration, dialed);
            this.gsm.createCall(call);
            System.out.println();
        }
        catch (NumberFormatException | IOException ex){
            ex.printStackTrace();
        } finally {
            System.out.println("======================================");
        }
    }

    public void removeLongestCall(){
        System.out.println("=============Remove Call=============");
        Call result = gsm.removeLongestCall();
        if (result==null) {
            System.out.println("No call history");
        }
        else{
            System.out.printf("Call removed: %s\n", result);
        }
        System.out.println("======================================");
    }

    public void priceCheck(){
        System.out.println("===========Total call price===========");
        float timeCall = gsm.totalCallTime();
        System.out.printf("Total call time: %.2f\nPrice: %.2f\nTotal: %.2f\n",
                timeCall, GSM.getCallPrice(), timeCall * GSM.getCallPrice());
        System.out.println("======================================");
    }


}
