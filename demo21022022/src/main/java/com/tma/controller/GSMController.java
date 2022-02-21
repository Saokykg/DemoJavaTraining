/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tma.controller;

import com.tma.model.Battery;
import com.tma.model.Call;
import com.tma.model.Display;
import com.tma.model.GSM;
/**
 *
 * @author pduonghoa
 */
public class GSMController{
    public static GSM addGSM(String model, String mft, float price, String owner, Battery bat, Display dis){
        return new GSM(model, mft, price, owner, bat, dis);
    }

    public static Call addCall(GSM mobile){
        return null;
    }
}
