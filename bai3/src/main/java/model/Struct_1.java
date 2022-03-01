package model;

public class Struct_1 {
    public int sum_age;
    public int counter;

    public Struct_1(){
        this.sum_age = 0;
        this.counter =0;
    }

    @Override
    public String toString() {
        return  "total age=" + sum_age +
                ", amount =" + counter +
                ", ave age =" + this.avg() ;
    }

    public void addAge(int age){
        this.sum_age += age;
        this.counter++;
    }

    public float avg(){
        if (this.counter == 0)
            return 0;
        else
            return  (float) this.sum_age /this.counter;
    }
}
