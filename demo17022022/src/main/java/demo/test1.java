/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author pduonghoa
 */
public class test1 {

    private float a;
    private float b;
    private float c;

    public String title(){
        return "ax^2 + bx + c = 0";
    }
    public void calculator(){
            float delta = this.b*this.b - 4*this.a*this.c;

            System.out.println("Delta  = " + delta);

            if (delta > 0){
                //delta geater than 0
                System.out.println("X have two value:");
                System.out.println("X1 = " + ((-this.b-Math.sqrt(delta))/(2*this.a)));
                System.out.println("X2 = " + ((-this.b+Math.sqrt(delta))/(2*this.a)));
            }else
                if (delta < 0){
                    //delta smaller than 0
                    System.out.println("Cant find X");

                }
                else{
                    //delta equal to 0
                    System.out.println("X have one value = " + (-this.b / (2*this.a)) );

                }
    }


    /**
     * @return the a
     */
    public float getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(float a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public float getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(float b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public float getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(float c) {
        this.c = c;
    }
}
