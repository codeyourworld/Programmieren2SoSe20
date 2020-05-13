package ufoKiwan;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;
import view.Message;

public class Game implements ITickableListener, IKeyboardListener {
	
	//Idea: we want to have multiple instances of an ufo and of a projectile
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
	//private Ufo [] ufos = new Ufo[10];
	//private Projectile [] projectiles = new Projectile[30];
	private Ship ship;
	private int screenWidth = 900;
	private int screenHeight = 700;
	private int score = 0;
	private Message scoreDisplay = new Message("Score: " + score, 750, 650, 30, new Color(255,255,255));
	private GameFrameWork frameWork = new GameFrameWork();
	
	
	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("ProgrammierenS20/01Vorlesung\\assets\\background.png"));
		
		ship = new Ship(screenWidth/2, 4 * screenHeight / 5, screenWidth / 10, screenWidth / 10, 
				"ProgrammierenS20/01Vorlesung\\assets\\pacman.png");
		frameWork.addGameObject(ship);
		
		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 6, screenWidth / 12, 3, 
				"ProgrammierenS20/01Vorlesung\\assets\\ufo4.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);
		
		for(int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i-1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(), 
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}
		
		frameWork.addTick(this);
		frameWork.addIKeyInput(this);
		
		frameWork.addMessage(scoreDisplay);
		
	}
	
	public void shoot() {
		//create a projectile
		Projectile projectile = new Projectile(ship.getX()+25, ship.getY()-40, 
				ship.getWidth()/3, ship.getWidth()/3, 5, "ProgrammierenS20/01Vorlesung\\assets\\projectile3.png");
		projectiles.add(projectile);
		frameWork.addGameObject(projectile);
		//Variante Array
		//projectiles[0] = projectile;
		
		//projectiles.get(0).getWidth();
		//Variante Array
		//projectiles[0].getWidth();
		
		//projectiles.size();
		//Variante Array
		//projectiles.length();
		
	}

	@Override
	public void tick(long elapsedTime) {
		//Das ist unsere GameLoop
		
		for(Ufo ufo : ufos) {
			ufo.move();
		}
		
		if(ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			              
			//TODO wenn kein Ufo mehr da ist (das passiert, wenn du gerade as 10 abgeschossen hast, gibt dir ufos.size() 0 zurück und du greifst auf das Element -1 zu. -> IndexOutOfBoundsException
			ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(), 
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() - 1));
		}
		
		for(Projectile p: projectiles) {
			p.move();
		}

		//TODO du kannst auch sagen: if(!projectiles.isEmpty())
		if (projectiles.size()>0) {
			if(projectiles.get(0).getY() < 0) {
				frameWork.removeGameObject(projectiles.get(0));
				projectiles.remove(0);
			}
		}
		
		//checkCollision();
		
		if (checkCollision()) {
			score += 1;
			scoreDisplay.setMessage("Score: " + score);
			frameWork.addMessage(scoreDisplay);
		}
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
	
	
	//Check if projectile and ufo collide

	public boolean checkCollision() {
		for(int u = 0; u < ufos.size(); u++) {
			for(int p = 0; p < projectiles.size(); p++) {
				if (ufos.get(u).getX() <= projectiles.get(p).getX() + projectiles.get(p).getWidth() &&
					ufos.get(u).getY() <= projectiles.get(p).getY() + projectiles.get(p).getHeight() &&
					ufos.get(u).getX() + ufos.get(u).getWidth() >= projectiles.get(p).getX() &&
					ufos.get(u).getY() + ufos.get(u).getHeight() >= projectiles.get(p).getY()) {
						frameWork.removeGameObject(ufos.get(u));
						ufos.remove(u);
						frameWork.removeGameObject(projectiles.get(p));
						projectiles.remove(p);
						//TODO du willst auch wieder neue Ufos hinzufügen, da sonst irgendwann keine Ufos mehr da sind. 
						return true;
				}
			}
		}
		return false;
	}
	

}
