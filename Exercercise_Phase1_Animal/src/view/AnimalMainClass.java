package view;

import controller.AvgAgeAnimal;
import model.Animal;
import model.Dog;
import model.Frog;
import model.Kitten;
import model.Sex;
import model.Tomcats;

public class AnimalMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AvgAgeAnimal ageAnimal = new AvgAgeAnimal();
		outArrAnimal(initArrAnimal());
		// output average age of each animal
		System.out.println(ageAnimal.avgAge(initArrAnimal()));
	}

	public static void outArrAnimal(Animal[] animals) {
		// init Array animals with 4 elements

		int sizeOfArr = animals.length;

		for (int i = 0; i < sizeOfArr; i++) {
			System.out.println(animals[i].toString());
			System.out.println(animals[i].sound());
		}
	}

	public static Animal[] initArrAnimal() {
		// init Array animals with 4 elements
		Animal[] animals = new Animal[4];
		animals[0] = new Dog("Dog Name", 6, Sex.male);// Upcasting
		animals[1] = new Frog("Frog Name", 2, Sex.female);
		animals[2] = new Kitten("Kitten Name", 10, Sex.male);
		animals[3] = new Tomcats("Tomcat Name", 8, Sex.female);
		return animals;
	}
}
