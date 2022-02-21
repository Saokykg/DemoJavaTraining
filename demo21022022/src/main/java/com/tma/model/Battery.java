/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tma.model;
import com.tma.model.EnumShare.batteryType;
/**
 *
 * @author pduonghoa
 */

public class Battery {
    

    private static int id = 0;
    private String model = null ;
    private float hoursIdle = 0;
    private float hoursTalk = 0;
    private batteryType batteryType = null;

    public Battery(){
        id++;
    }

    public Battery(String model, float hIdle, float hTalk, batteryType batType){
        id++;
        this.model = model;
        this.hoursIdle = hIdle;
        this.hoursTalk = hTalk;
        this.batteryType = batType;
    }

    @Override
    public String toString(){
        return String.format("Id: %d \nModel: %s \nHours idle: %.2f \nHours talk: %.2f \nBattery type: %s", 
                        this.getId(), this.getModel(), this.getHoursIdle(), this.getHoursTalk(), this.getBatteryType());
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the hoursIdle
     */
    public float getHoursIdle() {
        return hoursIdle;
    }

    /**
     * @param hoursIdle the hoursIdle to set
     */
    public void setHoursIdle(float hoursIdle) {
        this.hoursIdle = hoursIdle;
    }

    /**
     * @return the hoursTalk
     */
    public float getHoursTalk() {
        return hoursTalk;
    }

    /**
     * @param hoursTalk the hoursTalk to set
     */
    public void setHoursTalk(float hoursTalk) {
        this.hoursTalk = hoursTalk;
    }

    /**
     * @return the batteryType
     */
    public batteryType getBatteryType() {
        return batteryType;
    }

    /**
     * @param batteryType the batteryType to set
     */
    public void setBatteryType(batteryType batteryType) {
        this.batteryType = batteryType;
    }

}
