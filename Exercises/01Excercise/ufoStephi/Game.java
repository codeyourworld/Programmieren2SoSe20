package ufoStephi;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IGameObject;
import view.IKeyboardListener;
import view.ITickableListener;
import view.Message;

/**
 * Creates ufos which moves from the upper left side of the screen to the upper right side. 
 * Creates a ship from which a user an shoot a projectile by pressing space. A projectile moves up. 
 * If a projectile collides with a ufo the user gets a point. If a projectile does not damage a ufo the user gets a bad point. 
 * If the target is missed 20 times game is over.
 * 
 * Call init() to start the game.
 * 
 * @author Stephi
 * @version 1.1
 */
public class Game implements ITickableListener, IKeyboardListener {

	private ArrayList<Ufo> ufos = new ArrayList<>();
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private Ship ship;
	private int screenWidth = 1700;
	private int screenHeight = 900;
	private GameFrameWork view = new GameFrameWork();
	private Background background;
	private int counter = 0;
	private int targetMissed = 0;
	private boolean gameOver = false;
	private Message message;
	private int collisionTimer = 0;
	private static final int MAX_MISSED = 20;
	private static final int COLLISION_DELAY = 5;
	
	/**
	 * Starts the game.
	 * The game field is set to the given screen width and screen height. The highest screen size could just be your screen size.
	 * @param screenWidth of the game window
	 * @param screenHeight of the game window
	 */
	public void init(int screenWidth, int screenHeight) {
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;

		//create all game objects and the background image
		background = new Background("01Vorlesung\\assets\\space14.jpg");
		ship = new Ship(screenWidth / 2, 3 * screenHeight / 4, screenHeight / 10, screenHeight / 9,
				"01Vorlesung\\assets\\ship23.png");

		Ufo ufo = new Ufo(-20, screenHeight / 8, screenHeight / (2 * 5), screenHeight / (2 * 9), 5,
				"01Vorlesung\\assets\\ufo21.png" + "");
		ufos.add(ufo);

		for (int i = 1; i < 10; i++) {
			addUfo();
		}

		message = new Message(counter + " / " + targetMissed, screenWidth - 200, screenHeight - 100, 30,
				new Color(255, 255, 255));
		
		
		//add all game objects to gameFrameWork (view) and demand notification for a timer tick and keyboard input
		view.setSize(screenWidth, screenHeight);
		view.addGameObject(ship);
		view.setBackground(background);
		view.addTick(this);
		view.addIKeyInput(this);
		view.addMessage(message);
	}

	@Override
	public void tick(long ellapseTime) {
		//Note from Stephi: now you can easily see what happens in our game loop. This is how it shout look like :)
		
		if (!gameOver) {

			moveUfos();
			moveProjectiles();
			
			handleProjectileOutsideWindow();
			checkCollision();
			handleCollision();

			checkGameOver();
		}
	}

	
	/**
	 * Checks if two rectangle objects from type {@link IGameObject} collides
	 * @param objA to check if it collides 
	 * @param objB to check if it collides 
	 * @return true if the rectangles collides if not returns false.
	 */
	protected boolean isCollided(IGameObject objA, IGameObject objB) {

		if ((objA.getX() < (objB.getX() + objB.getWidth())) && ((objA.getX() + objA.getWidth()) > objB.getX())
				&& ((objA.getY()) < (objB.getY() + objB.getHeight()))
				&& ((objA.getY() + objA.getHeight()) > objB.getY())) {
			return true;
		}
		return false;
	}

	/**
	 * Adds a new ufo to ufos list. The ufo has the same attributes like the first one except the x position. The new ufo added after the last ufo.
	 * The ufo is visible now.
	 */
	protected void addUfo() {
		Ufo ufo = new Ufo(ufos.get(ufos.size() - 1).getX() - 500, ufos.get(0).getY(), ufos.get(0).getWidth(),
				ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getSprite());
		ufos.add(ufo);
		view.addGameObject(ufo);
	}

	/**
	 * Adds a projectile to projectiles list. The projectile is positioned directly above the ship. The projectile is visible now.
	 */
	private void shoot() {
		int width = ship.getWidth() / 4;
		Projectile projectile = new Projectile(ship.getX() + ship.getWidth() / 2 - width / 2, ship.getY(), width, width,
				8, "01Vorlesung\\assets\\projectile06.png");
		projectiles.add(projectile);
		view.addGameObject(projectile);

	}


	/**
	 * If a user missed 20 times the target game is over. A game over message is displayed.
	 */
	protected void checkGameOver() {
		if (targetMissed >= MAX_MISSED) {
			gameOver = true;
			view.addMessage(new Message("Game Over! \n" + counter + " Points", screenWidth / 2 - 150,
					screenHeight / 2, 40, new Color(255, 255, 255)));
		}
	}

	/**
	 * If there is no known collision the method checks for a collision. Points are increased and updated. 
	 */
	public void checkCollision() {
		if (collisionTimer == 0) {
			for (Projectile projectile : projectiles) {
				for (Ufo ufo : ufos) {

					if (isCollided(ufo, projectile)) {
						ufo.setCollided(true);
						projectile.setCollided(true);
						counter++;
						message.setMessage(counter + " / " + targetMissed);
						collisionTimer++;
						return;
					}
				}
			}
		}
	}

	/**
	 * Collided objects are removed with a delay. Checks for level update.
	 */
	protected void handleCollision() {
		
		//Increase delay counter
		if (collisionTimer > 0) {
			collisionTimer++;
		}

		//after a certain delay remove collided object
		if (collisionTimer >= COLLISION_DELAY) {
			for (Ufo ufo : ufos) {
				if (ufo.isCollided()) {
					view.removeGameObject(ufo);
					ufos.remove(ufo);
					addUfo();
					break;
				}
			}
			for (Projectile projectile : projectiles) {
				if (projectile.isCollided()) {
					view.removeGameObject(projectile);
					projectiles.remove(projectile);
					break;
				}
			}			
			collisionTimer = 0;

			levelChanger();
		}
	}

	/**
	 * Moves all projectiles.
	 */
	private void moveProjectiles() {
		
		for (Projectile projectile : projectiles) {
			projectile.move();
		}
	}

	/**
	 * If a projectile is outside the window the target missed counter is increased. The target missing counter on screen is updated.
	 * The projectile is removed from list and not visible anymore.
	 */
	private void handleProjectileOutsideWindow() {
		if (!projectiles.isEmpty() && (projectiles.get(0).getY() + projectiles.get(0).getHeight() < 0)) {
			targetMissed++;
			message.setMessage(counter + " / " + targetMissed);
			view.removeGameObject(projectiles.get(0));
			projectiles.remove(0);
		}
	}

	/**
	 * Moves all ufos. If a ufo is outside a window it is removed and not visible anymore.
	 */
	private void moveUfos() {
		if (ufos.get(0).getX() > screenWidth) {
			view.removeGameObject(ufos.get(0));
			ufos.remove(0);
			addUfo();
		}
		for (Ufo ufo : ufos) {
			ufo.move();
		}
	}

	@Override
	public int[] getKeys() {
		int[] events = { KeyEvent.VK_SPACE };
		return events;
	}

	@Override
	public void keyDown(int key) {
		shoot();
	}

	/**
	 * If a user hit the target 3 times at a same level. The level is increased. So the ufos moves faster.
	 */
	private void levelChanger() {
		if (counter % 3 == 0) {
			for (Ufo ufo : ufos) {
				ufo.increaseSpeed();
			}
		}
	}
}
