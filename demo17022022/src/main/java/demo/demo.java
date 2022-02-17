/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

/**
 *
 * @author pduonghoa
 */
import demo.test1;
import demo.sumArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) throws IOException{
        
        Scanner in = new Scanner(System.in); 
        Boolean stop = false;
        System.out.println("Program start: ");

        while(!stop){
            System.out.println("Menu:");
            System.out.println("1: Quadratic Formula root");
            System.out.println("2: Sum array");
            System.out.println("3: Exit");

            System.out.println("Chose function: ");

            int menu = in.nextInt();
            switch (menu){
            case 1:
                test1 m = new test1();
                System.out.println(m.title());

                System.out.println("Enter a: ");
                m.setA(in.nextFloat());

                System.out.println("Enter b: "); 
                m.setB(in.nextFloat());

                System.out.println("Enter c: "); 

                m.setC(in.nextFloat());

                m.calculator();
                break;
            case 2:
                System.out.println("Enter number of value"); 
                int state = in.nextInt();
                int[] list = new int[state];
                int idx = 0;
                System.out.println("When stop, enter -1"); 
                while (state!=0){
                    list[idx]=in.nextInt();
                    state--;
                    idx++;
                }
                int[] sum = list.clone();
                for (int i=1; i<sum.length; i++){
                    sum[i]=sum[i-1]+sum[i];            
                }
                System.err.println(sum[sum.length - 1]);
                break;
            case 3:
                stop = true;
                break;
            default:
                System.out.println("No command exist \npls try again!!!");
                break; 
            }
        }
        
    }
}
