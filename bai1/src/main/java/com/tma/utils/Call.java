/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tma.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author pduonghoa
 */
public class Call {
    private static int counter = 1;
    private int id;
    private LocalDate date = null;
    private LocalTime time = null;
    private float duration = 0; //minute
    private String dialedNumber = null;

    DateTimeFormatter dayFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public String toString(){
        return String.format("id: %d, DialedNumber: %s, date: %s, time: %s, duration: %.2f\n",
             this.getId(), this.getDialedNumber(), this.getDate(), this.getTime(), this.getDuration());
    }

    public Call(String date, String time, float dura, String dialN){ // call in the pass
        this.id = counter++;
        this.date = LocalDate.parse(date, dayFormat);
        this.time = LocalTime.parse(time, timeFormat);
        this.duration = dura;
        this.dialedNumber = dialN;
    }

    public Call(float dura, String dialN){  // call now
        this.id = counter++;
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
