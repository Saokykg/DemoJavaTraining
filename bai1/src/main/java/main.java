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


import com.tma.controller.GSMController;
import com.tma.utils.*;
import com.tma.utils.EnumShare.batteryType;
import com.tma.views.MainMenu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args){

        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();

    }
}

