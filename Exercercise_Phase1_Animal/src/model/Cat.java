package model;

public class Cat extends Animal {

	public Cat(String name, int age, Sex sex) {
		super(name, age, sex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sound() {
		// TODO Auto-generated method stub
		super.sound();
		return "This is Cat sound";
	}
}
