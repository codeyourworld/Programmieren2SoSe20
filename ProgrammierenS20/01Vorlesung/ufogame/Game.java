package ufogame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;

public class Game implements ITickableListener, IKeyboardListener {

	// Idea: we want to have multiple instances of an ufo and of a projectile
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
//	private Ufo [] ufos = new Ufo[10];
//	private Projectile [] projectiles = new Projectile[30];
	private Ship ship;
	private int screenWidth = 900;
	private int screenHeight = 700;
	private GameFrameWork frameWork = new GameFrameWork();

	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("Images\\space.jpg"));

		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9, "Images\\pingu.jpg");
		frameWork.addGameObject(ship);

		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 1, "Images\\virus.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);

		for (int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}

		frameWork.addTick(this);
		frameWork.addIKeyInput(this);

	}

	public void shoot() {
		// create a projectile
		Projectile projectile = new Projectile(ship.getX() + ship.getWidth() / 4, ship.getY() - ship.getWidth() / 2,
				ship.getWidth() / 2, ship.getWidth() / 2, 3, "Images\\Netflix.png");
		projectiles.add(projectile);

		frameWork.addGameObject(projectile);

	}

//		for(int i = 0; i < 1000; i++) {
//			projectiles.add(projectile);
//		}
//		
//		for(Projectile p : projectiles) {
//			System.out.println(p.getImagePath());
//		}
	// Variante Array
	// projectiles[0] = projectile;

	// projectiles.get(0).getWidth();
	// Variante Array
	// projectiles[0].getWidth();

	// projectiles.size();
	// Variante Array
	// projectiles.lenght

	// Aufgabe 2: Method that checks for the Collision between projectile and Ufo.
	public boolean checkCollision() {

		//TODO du fragst nur das 0. Element ab. es werden aber wahrscheinlich andere Ufos mit Projektilen kollidieren
		//TODO nutze eine verschachtelte for Schleife fuer alle Projektile und alle Ufos
		if (ufos.get(0).getX() < projectiles.get(0).getX() + projectiles.get(0).getWidth() && // Check if the
																								// Coordinates from the
																								// Ufo overlap with the
																								// coordinates from the
																								// bullet
				(ufos.get(0).getY() < projectiles.get(0).getY() + projectiles.get(0).getHeight()) &&

				(ufos.get(0).getX() + ufos.get(0).getWidth() > projectiles.get(0).getX()) &&

				(ufos.get(0).getY() + ufos.get(0).getHeight() > projectiles.get(0).getY())) {

			// System.out.println("collision detected");

			ufos.get(0).setCollided(true); // Change the isCollided attribute from the Ufo and projectile class to True
			projectiles.get(0).setCollided(true);

			// Aufgabe 3: Delete both objects if Ufo and Projectile collide.
			if (ufos.get(0).isCollided() == true) { // Ich glaube ich habe die isCollided und setCollided Attribute
													// nicht verstanden--
				frameWork.removeGameObject(ufos.get(0)); // Theoretisch glaube ich das soll funktionieren aber irgendwie
															// macht die methode nicths--
				//TODO die ufos musst du entfernen und wieder neue hinzu fügen
				// ufos.remove(ufos.get(0)); //Weder verschwinden noch "collision detected"
				// printen.
			}

			if (projectiles.get(0).isCollided() == true) {
				frameWork.removeGameObject(projectiles.get(0));
				projectiles.remove(projectiles.get(0));
			}

			// System.out.println("Collision detected");
			// boolean Collision = true;
		}

		return true;

	}

	@Override
	public void tick(long elapsedTime) {
		for (Ufo ufo : ufos) {
			ufo.move();
		}
		if (ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() - 1));
		}

		for (Projectile p : projectiles) {
			p.move();
		}

		// Aufgabe 1: Remove Projectile from Array.
		// TODO strg + shift + f = formatiert deinen code ordentlich
		if (projectiles.size() >= 1) {
			if (projectiles.get(0).getY() < 0) {
				frameWork.removeGameObject(projectiles.get(0));
				projectiles.remove(0);
			}
		}

		// Check if the Projectile was actually deleted!
		int size = projectiles.size();
		System.out.println("Ammount of Projectiles in Array: " + size);

		/*
		 * if (checkCollision()==true){ System.out.println("collision"); }
		 */

		// checkCollision(); // Trying to run checkCollision ends up in an error
		// message.

	}

	@Override
	public int[] getKeys() {
		int[] keys = { KeyEvent.VK_SPACE };
		return keys;
	}

	@Override
	public void keyDown(int key) {
		shoot();

	}

}
