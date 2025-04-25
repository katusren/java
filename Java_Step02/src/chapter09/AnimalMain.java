package chapter09;

public class AnimalMain {

	public static void main(String[] args) {

		animalSound(new Cat());
		animalSound(new Dog());

	}

	public static void animalSound(Animal animal) {
		animal.sound();
	}

}
