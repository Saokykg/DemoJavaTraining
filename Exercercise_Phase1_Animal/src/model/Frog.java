package model;

public class Frog extends Animal {
	public Frog(String name, int age, Sex sex) {
		super(name, age, sex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sound() {
		// TODO Auto-generated method stub
		super.sound();
		return "This is Frog sound";
	}
}
