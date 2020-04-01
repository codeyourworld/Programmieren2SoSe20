package movable;

import java.util.ArrayList;

public class MovableMain {

	public static void main(String[] args) {
		ArrayList<IMovable> movables = new ArrayList<IMovable>();
		movables.add(new Ball(0, 0, 3f, 7.5f));
		movables.add(new Ball(82, 50, -0.2f, 1.5f));
		movables.add(new Car(30,  42, 10));
		movables.add(new Car(383,  20, 20));
		
		for (IMovable movable : movables) {
			System.out.println(movable);
			movable.move();
			System.out.println(movable + "\n\n");
		}
	}
	
}
