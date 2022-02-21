/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tma.model;

import com.tma.model.Call;
import com.tma.model.Battery;
import com.tma.model.Display;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author pduonghoa
 */
public class GSM {
    private static int id = 0;
    private String model;
    private String manufacturer;
    private float price;
    private String owner;
    private static float callPrice = (float) 0.37;
    private Battery battery;
    private Display display;
    private LinkedList<Call> callHistory;

    @Override
    public String toString(){
        return String.format("Main info\nid: %d\nmodel: %s\nmanufacturer: %s\nPrice: %.2f\nOwner: %s\n\nBattery info:\n%s\n\nDisplay info\n%s\n",
             this.getId(), this.getModel(), this.getManufacturer(), this.getPrice(), this.getOwner(), this.getBattery(), this.getDisplay());
    }

    public GSM(String model, String mft, float price, String owner, Battery bat, Display dis){
        id++;
        this.model = model;
        this.manufacturer = mft;
        this.price = price;
        this.owner = owner;
        this.battery = bat;
        this.display = dis;
    }

    public List<Call> callHistory(){
        return null;
    }

    public boolean createCall(Call newCall){
        return this.callHistory.add(newCall) ? true : false;
    }

    public boolean createCall(String date, String time, float duration, String dialnumber){
        return this.callHistory.add(new Call(date, time, duration, dialnumber)) ? true : false;
    }

    public boolean createCall(float duration, String dialnumber){
        return this.callHistory.add(new Call(duration, dialnumber)) ? true : false;
    }

    public boolean clearCall(){
        this.callHistory.clear();
        return this.callHistory.isEmpty();
    }

    public Call removeLongestCall(){
        return null;
    }

    public float totalCallTime(){
        return 0;
    }

    public float price(){
        return this.totalCallTime()*this.callPrice;
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
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the callPrice
     */
    public static float getCallPrice() {
        return callPrice;
    }

    /**
     * @param aCallPrice the callPrice to set
     */
    public static void setCallPrice(float aCallPrice) {
        callPrice = aCallPrice;
    }

    /**
     * @return the battery
     */
    public Battery getBattery() {
        return battery;
    }

    /**
     * @param battery the battery to set
     */
    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    /**
     * @return the display
     */
    public Display getDisplay() {
        return display;
    }

    /**
     * @param display the display to set
     */
    public void setDisplay(Display display) {
        this.display = display;
    }

    /**
     * @return the callHistory
     */
    public List<Call> getCallHistory() {
        return callHistory;
    }

    /**
     * @param callHistory the callHistory to set
     */
    public void setCallHistory(LinkedList<Call> callHistory) {
        this.callHistory = callHistory;
    }

    

    
}
