package ufogame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;
import view.Message;

public class Game implements ITickableListener, IKeyboardListener {
	
	//Initialisierung von ArrayList für Projectiles und Ufos
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
	
	//Idea: we want to have multiple instances of an ufo and of a projectile
	//private Ufo [] ufos = new Ufo[10];
	//private Projectile [] projectiles = new Projectile[30];
	private Ship nyanCat;
	private int screenWidth = 900;
	private int screenHeight = 700;
	private GameFrameWork frameWork = new GameFrameWork();
	private int score = 0;
    private Message scoreDisplay = new Message("Score: " + score, 750, 650, 30, new Color(255,255,255));
	
	
	/**
	 * Initiates everything for the game. Multiple ufos just the ufos are actually space octopi and the nyancat are created.
	 */
	public void init() {
		frameWork.addMessage(scoreDisplay);
		frameWork.setSize(screenWidth, screenWidth);
		frameWork.setBackground(new Background("01Vorlesung\\assets\\background.png"));
		
		nyanCat = new Ship(screenWidth/2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9, 
				"01Vorlesung\\assets\\nyan.png");
		frameWork.addGameObject(nyanCat);
		
		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 8, screenWidth / 15, 4, 
				"01Vorlesung\\assets\\ufo20.png");
		ufos.add(ufo);
		
		frameWork.addGameObject(ufo);
		
		for(int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i-1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(), 
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}
		//wir wollen darüber informiert werden, wenn der Timer tickt, dann wird methode tick aktiviert
		frameWork.addTick(this);
		frameWork.addIKeyInput(this);
		
		//bei Game-Over
		//frameWork.removeTick(this);
	}
	
	public void shoot() {
		//create a projectile
		Projectile projectile = new Projectile(nyanCat.getX()+20, nyanCat.getY()-60, 
				nyanCat.getWidth()/2, nyanCat.getWidth()/2, 12, "01Vorlesung\\assets\\shot2p.png");
		
		//fügt das Objekt der ArrayList hinzu
		projectiles.add(projectile);
		frameWork.addGameObject(projectile);
	

		
		//prüft ob die Projektile aus dem Bild verschwinden, werden dann gelöscht.
				if(projectiles.get(0).getY() > screenHeight) {
					frameWork.removeGameObject(projectiles.get(0));
					projectiles.remove(0);
					} 
				
			
		
		//beim Array müsste es so aussehen: Vorteil an ArrayList: Kein Index
		//projectiles[0]=projectile;
		
		//ArrayList können alle Methoden nutzen
		//projectiles.get(0).getWidth();
		
		//Alternative Array
		//projectiles[0].getWidth();
		
		//ArrayList
		//projectiles.size();
		//Array
		//projectiles.length();
	}
	
	
//versuch einer Methode. Die prüfen soll ob ein Projektil mit nem Ufo kollidiert. Dann werden die setCollided true gesetzt
	
	public boolean checkCollision() {
	
	for (int u=0; u <ufos.size();u++) {
		 for(int p = 0; p < projectiles.size(); p++) {
			 if (ufos.get(u).getX() < (projectiles.get(p).getWidth() + projectiles.get(p).getX()) &&
						ufos.get(u).getY() < (projectiles.get(p).getHeight()+projectiles.get(p).getY()) &&
						(ufos.get(u).getX()+ufos.get(u).getWidth()) > projectiles.get(p).getX() &&
						(ufos.get(u).getY()+ufos.get(u).getHeight())>projectiles.get(p).getY()){
						
				 		//System.out.println("AHHHHH");
				 		
						projectiles.get(p).setCollided(true);
						ufos.get(u).setCollided(true);
						//ufos.remove(u);
						//projectiles.remove(p);
						return true;	
	}
			
	}
	}
	return false;
	}
	


	
	//bei jedem Tick sollen sich die Ufos bewegen. Die Tickmethode ist unser Gameloop
	@Override
	public void tick(long elapsedTime) {
	
		//lässt sich ufos bewegen und wenn ufo+Projektil kollidieren, sollen die Bilder gelöscht werden
		for(Ufo ufo : ufos) {
			ufo.move();
			if(ufo.isCollided()==true) {
				frameWork.removeGameObject(ufo);
		
			}}
			for(Projectile p: projectiles) {
				if(p.isCollided()==true) {
					frameWork.removeGameObject(p);
				}
			}
		//Scoredisplay wird erhöht wenn die Kollision erfolgt isst
			if (checkCollision()==true) {
	            score += 1;
	            scoreDisplay.setMessage("Score: " + score);
	            frameWork.addMessage(scoreDisplay);
	        }

			
		if(ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			//das letzte Ufo soll auch gelöscht werden oder so.. ffs no idea whats goin on
			ufos.add(new Ufo(ufos.get(ufos.size()-1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(), 
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(0));
		}
		
		for(Projectile p: projectiles) {
            p.move();
    
        }
	
		checkCollision();
		
		
	
		
		
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
