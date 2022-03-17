package Models;

import Interface.Ianimals;

public class Dog extends Animal implements Ianimals{

    public Dog(int avgAge, int maxSpeed, String sound) {
        super(avgAge, maxSpeed, sound);
    }

    public void age() {
        System.out.println(this.getAvgAge());
    }

    public void sound() {
        System.out.println(this.getSound());
    }

    public void speed() {
        System.out.println(this.getMaxSpeed());
    }
}
