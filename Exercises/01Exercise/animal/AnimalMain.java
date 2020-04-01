package animal;

import java.util.ArrayList;

public class AnimalMain {

	public static void main(String[] args) {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Lion(true, 50.93f, 0.54f));
		animals.add(new Lion(true, 69.93f, 1.00f));
		animals.add(new Lion(true, 30.93f, 0.84f));
		animals.add(new Lion(false, 10.93f, 0.64f));
		animals.add(new Lion(true, 20.93f, 0.24f));
		animals.add(new CommonBlackBird(true, false));
		animals.add(new CommonBlackBird(true, true));
		animals.add(new CommonBlackBird(false, true));
		animals.add(new CommonBlackBird(false, false));
		animals.add(new JellyFish(34.82f));
		animals.add(new JellyFish(3.82f));
		
		for (Animal animal : animals) {
			if(animal instanceof ISound) {
				((ISound)animal).makeSound();
			}
			System.out.println(animal + "\n" + animal.getFeed() + "\n");
		}
	}
}
