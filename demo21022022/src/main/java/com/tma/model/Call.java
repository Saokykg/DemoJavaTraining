/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tma.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 *
 * @author pduonghoa
 */
public class Call {
    private static int id = 0;
    private LocalDate date;
    private LocalTime time;
    private float duration; //minute
    private String dialedNumber;

    DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("dd-mm-yyyy");
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String toString(){
        return String.format("Call info\nid: %d\nDialedNumber: %s\ndate: %s\ntime: %s\nduration: %.2f\n",
             this.getId(), this.getDialedNumber(), this.getDate(), this.getTime(), this.getDuration());
    }

    public Call(String date, String time, float dura, String dialN){
        id++;
        this.date = LocalDate.parse(date, dayFormat);
        this.time = LocalTime.parse(time, timeFormat);
        this.duration = dura;
        this.dialedNumber = dialN;
    }

    public Call(float dura, String dialN){
        id++;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.duration = dura;
        this.dialedNumber = dialN;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date.toString();
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = LocalDate.parse(date, dayFormat);;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time.toString();
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = LocalTime.parse(time, timeFormat);;
    }

    /**
     * @return the duration
     */
    public float getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(float duration) {
        this.duration = duration;
    }

    /**
     * @return the dialedNumber
     */
    public String getDialedNumber() {
        return dialedNumber;
    }

    /**
     * @param dialedNumber the dialedNumber to set
     */
    public void setDialedNumber(String dialedNumber) {
        this.dialedNumber = dialedNumber;
    }

}
