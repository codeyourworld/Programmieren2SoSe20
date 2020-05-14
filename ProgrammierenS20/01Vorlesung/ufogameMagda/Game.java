package ufogameMagda;

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
	private int score;

	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		// Aufgabe 3
		score = 0;

		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("01Vorlesung\\assets\\space14.jpg"));

		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9,
				"01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);

		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 1,
				"01Vorlesung\\assets\\ufo20.png");
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
				ship.getWidth() / 2, ship.getWidth() / 2, 3, "01Vorlesung\\assets\\projectile06.png");
		projectiles.add(projectile);

		frameWork.addGameObject(projectile);

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

		// Aufgabe 1
		if (!projectiles.isEmpty() && (projectiles.get(0).getY() < 0)) {
			frameWork.removeGameObject(projectiles.get(0));
			projectiles.remove(0);

		}

		// Aufgabe 2 & 3

		//TODO du bekommtst eine ConcurrentModificationException. hast an dieser stelle 2 Optionen
		//TODO Option 1: in eine Methode auslagern und du alle Elemente in der if-Abfrage entfernt hast, gehst du mit return aus der Methode raus
		//TODO Option 2: Du erstellst eine boolean Variable und setzt sie entsprechend
		boolean isCollided = false;
		for (Projectile p : projectiles) {
			for (Ufo ufo : ufos) {
				boolean isCollision = checkCollision(ufo, p);
				if (isCollision) {
					// Spielstand +1
					score++;
					// remove Ufo and p from lists
					frameWork.removeGameObject(ufo);
					frameWork.removeGameObject(p);
					ufos.remove(ufo);
					projectiles.remove(p);
					
					//TODO f�ge hier wieder ein Ufo hinzu, sonst sind in dem Spiel irgendwann keine mehr
					isCollided = true;
				}
				if(isCollided) {
					break;
				}
			}
			if(isCollided) {
				break;
			}
		}

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

	// Aufgabe 2
	public boolean checkCollision(Ufo ufo, Projectile p) {

		// check that projectile is on left of ufo (p.x + p.width) < ufo.x
		if ((p.getX() + p.getWidth()) < ufo.getX()) {
			return false;
		}
		// check that projectile is on the right of ufo (ufo.x + ufo.width) < p.x
		if ((ufo.getWidth() + ufo.getX()) < p.getX()) {
			return false;
		}

		// check that projectile is above ufo (p.height + p.y) < ufo.y
		if ((p.getHeight() + p.getY()) < ufo.getY()) {
			return false;
		}

		// check that projectile is below ufo p.Y > (ufo.Y + ufo.height)
		if (p.getY() > (ufo.getY() + ufo.getHeight())) {
			return false;

		}

		return true;

	}

}
