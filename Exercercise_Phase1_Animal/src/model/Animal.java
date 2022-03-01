package model;

public class Animal implements ISound {
	private String name;
	private int age;
	private Sex sex;

	public Animal(String name, int age, Sex sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	@Override
	public String sound() {
		// TODO Auto-generated method stub
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
		if (age >= 0) {
			this.age = age;
		} else {
			throw new ArithmeticException("not valid! Age must >0");
		}

	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public void avgAge(Animal[] arr) {
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:" + getName() + "\nAge:" + getAge() + "\nSex:" + getSex();
	}

}
