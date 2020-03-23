package ufogame;

import view.GameFrameWork;

public class Game {
	
	//Idea: we want to have multiple instances of an ufo and of a projectile
	private Ufo [] ufos = new Ufo[10];
	private Projectile [] projectiles = new Projectile[30];
	private Ship ship;
	private int screenWidth = 900;
	private int screenHeight = 700;
	private GameFrameWork frameWork = new GameFrameWork();
	
	
	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.setSize(screenWidth, screenHeight);
		
		ship = new Ship(screenWidth/2, 4 * screenHeight / 5, screenWidth / 20, screenWidth / 20, 
				"01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);
		
		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 10, 1, 
				"01Vorlesung\\assets\\ufo20.png");
		ufos[0] = ufo;
		frameWork.addGameObject(ufo);
		
        for(int i = 1; i < ufos.length; i++) {
            ufos[i] = new Ufo(ufos[i-1].getX() - 20, ufos[0].getY(), ufos[0].getWidth(), 
                    ufos[0].getHeight(), ufos[0].getSpeed(), ufos[0].getImagePath());
            frameWork.addGameObject(ufos[i]);
        }
	}
	
	public void shoot() {
		//create a projectile
		Projectile projectile = new Projectile(ship.getX(), ship.getY(), 
				ship.getWidth()/2, ship.getWidth()/2, 3, "01Vorlesung\\assets\\projectile06.png");
		
	}

}
