/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tma.controller;

import com.tma.utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author pduonghoa
 */
public class GSMController{

    public GSM addGSM(String model, String mft, float price, String owner, Battery bat, Display dis){
        GSM gsm = new GSM(model, mft, price, owner, bat, dis);
        GSMList.gsmList.add(gsm);
        return gsm;
    }

    public boolean remove(GSM gsm){
        return GSMList.gsmList.remove(gsm);
    }

    public void listed(){
        GSMList.gsmList.forEach((obj) -> {
            System.out.println(obj);
            System.out.println("---------------------");
        });
    }

}
