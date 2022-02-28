/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tma.utils;

/**
 *
 * @author pduonghoa
 */
public class EnumShare {
    public enum batteryType {
        LiIon, NiMH, NiCd
    } 

    public static batteryType get(int x){
        int od = 1;
        for(batteryType bt: batteryType.values()){
            if (od == x)
                return bt;    
        }  
        return null;
    }
    
    
}
