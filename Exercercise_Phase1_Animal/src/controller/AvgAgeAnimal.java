package controller;

import model.Animal;
import model.Dog;
import model.Frog;
import model.Kitten;
import model.Tomcats;

public class AvgAgeAnimal {
	// writing
	public StringBuilder avgAge(Animal[] inputAnimal) {
		

		int sizeOfArr = inputAnimal.length;
	
		
		// create variable sumAge of each animal in array
		double sumAgeDog = 0;
		double sumAgeFrog = 0;
		double sumAgeKitten = 0;
		double sumAgeTomcats = 0;
		// create variable count each animal in array
		double countDog = 0;
		double countFrog = 0;
		double countKitten = 0;
		double countTomcats = 0;

		for (int i = 0; i < sizeOfArr; i++) {
			if (inputAnimal[i] instanceof Dog) {
				sumAgeDog += inputAnimal[i].getAge();
				countDog++;
			}
			if (inputAnimal[i] instanceof Frog) {
				sumAgeFrog += inputAnimal[i].getAge();
				countFrog++;
			}
			if (inputAnimal[i] instanceof Kitten) {
				sumAgeKitten += inputAnimal[i].getAge();
				countKitten++;
			}
			if (inputAnimal[i] instanceof Tomcats) {
				sumAgeTomcats += inputAnimal[i].getAge();
				countTomcats++;
			}
		}
		StringBuilder builder = new StringBuilder();
		builder.append("Average age of dog is:" + (sumAgeDog / countDog));
		builder.append("Average age of frog is:" + (sumAgeFrog / countFrog));
		builder.append("Average age of kitten is:" + (sumAgeKitten / countKitten));
		builder.append("Average age of tomcats is:" + (sumAgeTomcats / countTomcats));
		return builder;
	}
}
