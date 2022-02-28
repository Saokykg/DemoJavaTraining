package com.tma.views;

import com.tma.controller.GSMController;
import com.tma.utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class MainMenu {

    public void mainMenu(){
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int chose = 0;
        while (true) {
            System.out.println("Command menu ");
            System.out.println("1. add gsm");
            System.out.println("2. remove gsm");
            System.out.println("3. show list gsm");
            System.out.println("4. select gsm by id");
            System.out.println("5. exit!!!");
            System.out.print("Select command: ");
            try {
                chose = Integer.parseInt(sc.readLine());
            } catch (IOException | NumberFormatException ex) {
                ex.printStackTrace();
            }

            switch (chose) {
                case 1:
                    this.addGSM();
                    break;
                case 2:
                    this.removeGSM();
                    break;
                case 3:
                    this.list();
                    break;
                case 4:
                    this.select();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("command not found!!!");
                    break;
            }
        }
    }

    public void addGSM(){
        try {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("==========Input gsm infomation==========");
            System.out.println("Model: ");
            String model = sc.readLine();
            System.out.println("Manufacturer: ");
            String manufacturer = sc.readLine();
            System.out.println("Price: ");
            float price = Float.parseFloat(sc.readLine());
            System.out.println("Owner: ");
            String owner = sc.readLine();

            System.out.println();

            System.out.println("Battery info: ");
            System.out.println("Model battery: ");
            String batModel = sc.readLine();

            System.out.println("Hours idle: ");
            float houridl = 0;
            try {
                houridl = Float.parseFloat(sc.readLine());
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }

            System.out.println("Hours talk: ");
            float hourtalk = 0;
            try {
                hourtalk = Float.parseFloat(sc.readLine());
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }

            System.out.println("Chose battery type: ");

            int od = 1;
            for (EnumShare.batteryType bt : EnumShare.batteryType.values()) {
                System.out.printf("%d, %s \n", od++, bt);
            }
            System.out.printf("%d, %s \n", 4, "no info");
            int c = -1;
            while (c < 1 || c > od + 1) {
                try {
                    c = Integer.parseInt(sc.readLine());
                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
            Battery bat;
            if (od + 1 == c)
                bat = new Battery(batModel, houridl, hourtalk, null);
            else
                bat = new Battery(batModel, houridl, hourtalk, EnumShare.get(od));

            System.out.println();
            System.out.println("Display info: ");
            System.out.println("Size: ");
            int size = Integer.parseInt(sc.readLine());
            System.out.println("Colors: ");
            int colors = Integer.parseInt(sc.readLine());
            Display dis = new Display(size, colors);

            GSMController gsmControl = new GSMController();
            GSM addingGSM = gsmControl.addGSM(model, manufacturer, price, owner, bat, dis);

            System.out.println(addingGSM);

        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            System.out.println("========================================");
        }

    }

    public void removeGSM(){
        System.out.println("=============Remove gsm================");
        GSM deteleObj = choseGSM();
        try {
            GSMController gsmControl = new GSMController();
            if (gsmControl.remove(deteleObj))
                System.out.println("Delete success");
        } catch (NullPointerException ex){
            ex.printStackTrace();
        } finally {
            System.out.println("======================================");
        }
    }

    public void list(){
        System.out.println("===============List gsm=================");
        GSMController gsmControl = new GSMController();
        gsmControl.listed();
        System.out.println("====================================");
    }

    public void select(){
        GSMMenu gsmMenu = new GSMMenu(choseGSM());
        gsmMenu.showGSMMenu();
    }

    public GSM choseGSM() {
        BufferedReader sc = new BufferedReader(
                new InputStreamReader(System.in));
        GSMList.gsmList.forEach((obj) -> System.out.println(obj.toList()));
        int id = 0;
        System.out.print("Enter gsm id: ");
        while (id < 1 || id > GSMList.gsmList.size()) {
            try {
                id = Integer.parseInt(sc.readLine());
            } catch (NumberFormatException | IOException ex){
                ex.printStackTrace();
            }
        }
        return GSMList.gsmList.get(id-1);
    }
}
