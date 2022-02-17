/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.List;

/**
 *
 * @author pduonghoa
 */
public class sumArray {

    private int[] value;
    private long[] sum;

    public String print(){
        String s = "";
        for (int i=0;i<this.value.length; i++){
            s+= this.value[i] + ',';
        }
        return s;
    }
    /**
     * @return the value
     */
    public int[] getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int[] value) {
        this.value = value;
    }

    /**
     * @return the sum
     */
    public long[] getSum() {
        return sum;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(long[] sum) {
        this.sum = sum;
    }

    void setValue(List<Integer> list) {
        int idx = 0;
        list.forEach((ele) -> {
//            this.value[idx] = ele;
//            if (idx==0)
//                this.sum[idx] = ele;
//            else
//                this.sum[idx] = this.sum[idx-1]+ele;
//            idx = idx + 1;
        }); 
    }

}
