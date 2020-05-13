package ufoJacek;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IGameObject;
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
	private int score;
	private GameFrameWork frameWork = new GameFrameWork();
	private String path = "";

	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		score = 0;
		
		frameWork.setSize(screenWidth, screenHeight);
		//TODO bitte nutze relative Pfade
		frameWork.setBackground(new Background(path + "01Vorlesung\\assets\\space14.jpg"));
		
		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9,
				path + "01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);

		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 1,
				path + "01Vorlesung\\assets\\ufo20.png");
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
		Projectile projectile = new Projectile(ship.getX() + ship.getWidth()/4, 
				ship.getY() - ship.getWidth() / 2, ship.getWidth() / 2, ship.getWidth() / 2, 3,
				path + "01Vorlesung\\assets\\projectile06.png");
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
	
	//Checks only for corners
	public boolean checkCollision(IGameObject object, IGameObject target) {
		boolean YCollides = target.getY() + target.getHeight() > object.getY() && target.getY() < object.getY() + object.getHeight();
		boolean LeftXCollides = target.getX() < object.getX() && target.getX() + target.getWidth() > object.getX();
		boolean RightCollides = target.getX() < object.getX()+object.getWidth() &&
				target.getX() + target.getWidth() > object.getX()+object.getWidth();
		//TODO du kannst das kürzer schreiben:
		//boolean XCollides = target.getX() + target.getWidth() < object.getX() && target.getX() + target.getWidth() > object.getX();

				
		//boolean rightXCollides =
		if(YCollides & (LeftXCollides || RightCollides)) {
			return true;
		}
		return false;
	}
	
	//TODO das hat in unserem Fall keinen Benefit. Es gibt keinen Fall, in dem diese Methode eine collision erkennt und die andere Methode nicht.
	//Es ist in der Tat rechenaufwendiger. 
	//This is better because it checks not only for corners but also all pixels between the corners. the Only down side more calculations
	public boolean betterCheckCollision(IGameObject object, IGameObject target) 
	{
		//TODO du brauchst diese for schleifen nicht
		for(int x  = object.getX(); x <= object.getX() + object.getWidth(); x++){
			for(int y  = object.getY(); y <= object.getY() + object.getWidth(); y++){
				boolean betweenX =  target.getX() < x && x < target.getX() + target.getWidth();
				boolean betweenY = target.getY() < y && y < target.getY() + target.getHeight();
				if(betweenX && betweenY){
					return true;
				}
			}
		}
		return false;
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
		
		for(Projectile p: projectiles) {
            p.move();
        }
		
		
		// Aufgabe 1
		if(!projectiles.isEmpty()) {
			for(int x = 0; x < projectiles.size(); x++) {
				if(projectiles.get(x).getY() <= 0) {
					frameWork.removeGameObject(projectiles.get(x));
					projectiles.remove(x);
					System.out.println("Removed");
				}
			}
		}
		
		
		// Aufgabe 3 the the score variables name is score
		for(int x = 0; x < ufos.size(); x++){
			for(int y = 0; y < projectiles.size(); y++){
				//TODO du bekommst hier eine IndexOutOfBoundsException, es ist nur ein Ufo im Spiel size() = 1, du greifst aber auf das Element
				if(betterCheckCollision(projectiles.get(y), ufos.get(x))){
					score++;
					System.out.println("Has Collided with " + x + " and your score is " + score);
					
					
					
					frameWork.removeGameObject(projectiles.get(y));
					projectiles.remove(y);
					
					frameWork.removeGameObject(ufos.get(x));
					ufos.remove(x);
					//TODO du musst auch Ufos wieder hinzu fügen, ansonsten fliegen irgendwann keine mehr durchs bild und 
					//du bekommst eine IndexOutOfBoundsException
				}
			}
		}
		
		///
		///
		//TODO check size of list
//			frameWork.removeGameObject(projectiles.get(0));
	}

	@Override
	public int[] getKeys() {
		int [] keys = {KeyEvent.VK_SPACE};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		shoot();
		
	}

}
