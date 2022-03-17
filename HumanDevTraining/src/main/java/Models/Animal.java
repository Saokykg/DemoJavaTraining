package Models;

import Interface.Ianimals;

import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;

public abstract class Animal{

    private int avgAge;
    private int maxSpeed;
    private String sound;
    private float number1 = 100;
    private Double number2 = 1033.0;
    private LocalTime time = LocalTime.now();

    public Animal(int avgAge, int maxSpeed, String sound){
        this.setAvgAge(avgAge);
        this.setMaxSpeed(maxSpeed);
        this.setSound(sound);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "avgAge=" + avgAge +
                ", maxSpeed=" + maxSpeed +
                ", sound='" + sound + '\'' +
                ", number1=" + number1 +
                ", number2=" + number2 +
                ", time=" + time +
                '}';
    }

    public int getAvgAge() {
        return avgAge;
    }

    public void setAvgAge(int avgAge) {
        this.avgAge = avgAge;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
