package model;

public class Kitten extends Animal {
	public Kitten(String name, int age, Sex sex) {
		super(name, age, Sex.female);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sound() {
		// TODO Auto-generated method stub
		super.sound();
		return "This is Kitten sound";
	}
}
