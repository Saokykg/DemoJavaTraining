package model;

public class Tomcats extends Animal {
	public Tomcats(String name, int age, Sex sex) {
		super(name, age, Sex.male);

		// TODO Auto-generated constructor stub
	}

	@Override
	public String sound() {
		// TODO Auto-generated method stub
		super.sound();
		return "This is TomCats sound";
	}
}
