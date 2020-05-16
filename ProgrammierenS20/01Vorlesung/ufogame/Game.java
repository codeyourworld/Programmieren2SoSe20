package ufogame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;
import view.Message;

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
	private int speed = 10;
	private int score = 0;
	
	private Message scoreText;

	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("01Vorlesung\\assets\\space14.jpg"));

		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9,
				"01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);

		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 1, "01Vorlesung\\assets\\ufo20.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);

		for (int i = 0; i < 5; i++) {
			ufos.add(new Ufo(ufos.get(i).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}

		frameWork.addTick(this);
		frameWork.addIKeyInput(this);
		
		
		scoreText = new Message("Score: 0", 100, 100, 40, Color.white);
		frameWork.addMessage(scoreText);
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
	

    
	private boolean checkCollision(Ufo ufo) {
		
		boolean isBum = false;
		for (Projectile p : projectiles) 
		{
			if (ufo.getX() <= p.getX() 
			 && ufo.getX() + ufo.getWidth() >= p.getX() 
			 && ufo.getY() <= p.getY()
			 && ufo.getY() + ufo.getHeight() >= p.getY()) 
			{
				p.setCollided(true);
				isBum = true;
				
			}

		} 
		return isBum;

	}

	@Override
	public void tick(long elapsedTime) {
		int removableObjectIndexUfo = -1;
		
		for (Ufo ufo : ufos)
		{
			ufo.move();
			ufo.setCollided(checkCollision(ufo));
			if(ufo.isCollided())
			{
				removableObjectIndexUfo = ufos.indexOf(ufo);
				score ++;
				scoreText.setMessage("Score: " + score);
				
			}

		}
		
		if(removableObjectIndexUfo != -1 ) 
		{
			frameWork.removeGameObject(ufos.get(removableObjectIndexUfo));
			ufos.remove(removableObjectIndexUfo);
		}
		
		if (ufos.size() > 0 && ufos.get(0).getX() > screenWidth)
		{
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() - 1));
		}

	    int removableObjectIndexProjectile = -1;
		for (Projectile p : projectiles) 
			
		{
			p.move();
			if(p.isCollided())
			{
				removableObjectIndexProjectile = projectiles.indexOf(p);
			}
		}
		
		if(removableObjectIndexProjectile != -1)
		{
			frameWork.removeGameObject(projectiles.get(removableObjectIndexProjectile));
			projectiles.remove(removableObjectIndexProjectile);
		}

		if (projectiles.size() > 0 && projectiles.get(0).getY() < 0) 
		{
			frameWork.removeGameObject(projectiles.get(0));
			projectiles.remove(0);
		}

		
	}

	@Override
	public int[] getKeys() {
		int[] keys = { KeyEvent.VK_SPACE, KeyEvent.VK_A, KeyEvent.VK_LEFT, KeyEvent.VK_D, KeyEvent.VK_RIGHT };
		return keys;
	}

	@Override
	public void keyDown(int key) {
		if (key == KeyEvent.VK_SPACE) {
			shoot();
		}
		if ((key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) && ship.getX() > 0) {
			ship.setX(ship.getX() - speed);
		}
		if ((key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) && ship.getX() < (screenWidth - ship.getWidth())) {
			ship.setX(ship.getX() + speed);
		}

	}

}
