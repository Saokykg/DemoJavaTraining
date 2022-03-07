/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tma.controller;

import com.tma.utils.Call;

/**
 *
 * @author pduonghoa
 */
public class MainController {
    public Call add(float duration, String number) {
        return new Call(duration, number);
    }

}
