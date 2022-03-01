package model;

public abstract class Animals implements ISound{
    private String name;
    private int age;
    private EnumSex.Sex sex;

    public Animals(String name, int age, EnumSex.Sex sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public String sound(){
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EnumSex.Sex getSex() {
        return sex;
    }

    public void setSex(EnumSex.Sex sex) {
        this.sex = sex;
    }
}
