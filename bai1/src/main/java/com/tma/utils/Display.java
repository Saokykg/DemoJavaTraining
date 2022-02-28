/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tma.utils;

import java.io.Serializable;

/**
 *
 * @author pduonghoa
 */
public class Display  implements Serializable{
    private static int counter = 1;
    private int id;
    private int size = 0;
    private int numberOfColers = 0;

    public Display(int size, int colors){
        this.id = counter++;
        this.size = size;
        this.numberOfColers = colors;
    }

    @Override
    public String toString(){
        return String.format("id: %d \nsize: %d \ncolors: %d", this.getId(), this.getSize(), this.getNumberOfColers());
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the numberOfColers
     */
    public int getNumberOfColers() {
        return numberOfColers;
    }

    /**
     * @param numberOfColers the numberOfColers to set
     */
    public void setNumberOfColers(int numberOfColers) {
        this.numberOfColers = numberOfColers;
    }
}
