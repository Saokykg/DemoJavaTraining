///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.tma.view;
//
//import com.tma.model.Battery;
//import com.tma.model.Display;
//import com.tma.model.GSM;
//import com.tma.model.EnumShare.batteryType;
//
//import java.io.IOException;
//import java.util.Scanner;
//
///**
// *
// * @author pduonghoa
// */
//public class main {
//    public static void main(String[] args) throws IOException{
//        System.out.println("PROGRAM RUNNING...\n");
//        Scanner in = new Scanner(System.in); 
//        
//        //add display
//        Display dis = new Display(10, 10000);
//        System.out.println(dis.toString());
//        System.out.println("=========================\n");
//        
//        //add battery
//        Battery bat = new Battery("bat_1", 10, 5, batteryType.LiIon);
//        System.out.println(bat);
//        System.out.println("=========================\n");
//        
//        //add GSM
//        GSM mobile = new GSM("mobile-1", "samsum", (float)256831.23, "hoa", bat, dis);
//
//        System.out.println(mobile);
//
//
//        System.out.println("\nPROGRAM END!!!");
//
//    }
//    public void checkingCall(){
//int menu = 0;
//
//    }
//
//    public void modifGSM(){
//    }
//}


package com.tma.view;

import com.tma.controller.GSMController;
import com.tma.model.Battery;
import com.tma.model.Call;
import com.tma.model.Display;
import com.tma.model.EnumShare.batteryType;
import com.tma.model.EnumShare;
import com.tma.model.GSM;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class main {
    List<GSM> gsm = new ArrayList();
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        Battery bat = new Battery();
        System.out.println(bat);

        mainmenu();
    }
    public static void mainmenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Select command: ");
        System.out.println("1. add gsm");
        System.out.println("2. remove gsm");
        System.out.println("3. show list gsm");
        System.out.println("4. select gsm by id");
        System.out.println("5. go back!!!");
        int chose = sc.nextInt();
        switch (chose){
            case 1:
                System.out.println("Input gsm infomation");
                System.out.println("Model: ");          String model = sc.nextLine();
                System.out.println("Manufacturer: ");   String manufacturer = sc.nextLine();
                System.out.println("Price: ");          float price = sc.nextFloat();
                System.out.println("Owner: ");          String owner = sc.nextLine();

                System.out.println();

                System.out.println("Battery info: ");   
                System.out.println("Model battery: ");  String batModel = sc.nextLine();
                System.out.println("Hours idle: ");     float houridl = sc.nextFloat();
                System.out.println("Hours talk: ");     float hourtalk = sc.nextFloat();
                
                System.out.println("Chose battery type: ");
                
                int od = 1;
                for(batteryType bt: batteryType.values()){
                    System.out.printf("%d, %s \n", od++, bt);
                }
                System.out.printf("%d, %s \n", 4, "no info");
                int c = -1; 
                while (c < 1 || c > od + 1){
                    c = sc.nextInt();
                }
                Battery bat;
                if (od + 1 == c)
                    bat = new Battery(batModel, houridl, hourtalk, null);
                else
                    bat = new Battery(batModel, houridl, hourtalk, EnumShare.get(od));

                System.out.println();
                System.out.println("Display info: ");
                System.out.println("Size: ");   int size = sc.nextInt();
                System.out.println("Colors: "); int colors = sc.nextInt();
                Display dis = new Display(size, colors);

                System.out.println(GSMController.addGSM(model, manufacturer, price, owner, bat, dis));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("command not found!!!");
                break;
        }
    }
    
}

