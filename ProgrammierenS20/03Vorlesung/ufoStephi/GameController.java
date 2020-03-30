package ufoStephi;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IGameObject;
import view.IKeyboardListener;
import view.ITickableListener;
import view.Message;

public class GameController implements ITickableListener, IKeyboardListener {

	private ArrayList<UfoObj> ufos = new ArrayList<UfoObj>(10);
	private ArrayList<ProjectileObj> projectiles = new ArrayList<ProjectileObj>();
	private ShipObj ship;
	private int screenWidth = 1700;
	private int screenHeight = 900;
	private GameFrameWork controller = new GameFrameWork();
	private BackgroundSprite background;
	private int counter = 0;
	private int badShoot = 0;
	private boolean gameOver = false;
	private Message message;
	private int collisionTimer = 0;

	public void init() {
		background = new BackgroundSprite("01Vorlesung\\assets\\space14.jpg");
		ship = new ShipObj(screenWidth / 2, 3 * screenHeight / 4, screenWidth / 10, screenWidth / 10,
				"01Vorlesung\\assets\\ship23.png");

		UfoObj ufo = new UfoObj(-20, screenHeight / 8, screenWidth / (2 * 5), screenWidth / (2 * 9), 5,
				"01Vorlesung\\assets\\ufo21.png" + "");
		ufos.add(ufo);

		for (int i = 1; i < 10; i++) {
			addUfo();
		}

		controller.setSize(screenWidth, screenHeight);
		controller.addGameObject(ship);
		controller.setBackground(background);
		controller.addTick(this);
		controller.addIKeyInput(this);
		message = new Message(counter + " / " + badShoot, screenWidth - 200, screenHeight - 100, 30,
				new Color(255, 255, 255));
		controller.addMessage(message);
	}

	protected boolean isCollided(IGameObject objA, IGameObject objB) {

		if ((objA.getX() < (objB.getX() + objB.getWidth())) && ((objA.getX() + objA.getWidth()) > objB.getX())
				&& ((objA.getY()) < (objB.getY() + objB.getHeight()))
				&& ((objA.getY() + objA.getHeight()) > objB.getY())) {
			return true;
		}
		return false;
	}

	protected void addUfo() {
		UfoObj ufo = new UfoObj(ufos.get(ufos.size() - 1).getX() - 500, ufos.get(0).getY(), ufos.get(0).getWidth(),
				ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getSprite());
		ufos.add(ufo);
		controller.addGameObject(ufo);
	}

	private void shoot() {
		int width = ship.getWidth() / 4;
		ProjectileObj projectile = new ProjectileObj(ship.getX() + ship.getWidth() / 2 - width / 2, ship.getY(), width, width,
				8, "01Vorlesung\\assets\\projectile06.png");
		projectiles.add(projectile);
		controller.addGameObject(projectile);

	}

	@Override
	public void tick(long ellapseTime) {
		if (!gameOver) {
			if (badShoot > 20) {
				gameOver = true;
				controller.addMessage(new Message("Game Over! \n" + counter + " Points", screenWidth / 2 - 100,
						screenHeight / 2, 60, new Color(255, 255, 255)));
			}

			moveUfos();

			moveProjectiles();
			checkCollision();
			if (collisionTimer > 0) {
				collisionTimer++;
			}
		}
	}

	public void checkCollision() {
		if (collisionTimer == 0) {
			for (ProjectileObj projectile : projectiles) {
				for (UfoObj ufo : ufos) {

					if (isCollided(ufo, projectile)) {
						ufo.setCollided(true);
						projectile.setCollided(true);
						counter++;
						message.setMessage(counter + " / " + badShoot);
						projectile.setCollided(true);
						collisionTimer = 1;
						break;
					}
				}
			}
		}
		if (collisionTimer >= 5) {
			for (UfoObj ufo : ufos) {
				if (ufo.isCollided()) {
					controller.removeGameObject(ufo);
					ufos.remove(ufo);
					addUfo();
					levelChanger();
					break;
				}
			}
			for (ProjectileObj projectile : projectiles) {
				if (projectile.isCollided()) {
					controller.removeGameObject(projectile);
					projectiles.remove(projectile);
					break;
				}
			}
			collisionTimer = 0;

		}
	}

	private void moveProjectiles() {
		if (!projectiles.isEmpty() && (projectiles.get(0).getY() + projectiles.get(0).getHeight() < 0)) {
			badShoot++;
			message.setMessage(counter + " / " + badShoot);
			projectiles.remove(0);
		}
		for (ProjectileObj projectile : projectiles) {
			projectile.move();
		}
	}

	private void moveUfos() {
		if (ufos.get(0).getX() > screenWidth) {
			ufos.remove(0);
			addUfo();
		}
		for (UfoObj ufo : ufos) {
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
//		if(timeOutShooting <= 0) {
		shoot();
//		}
	}

	private void levelChanger() {
		if (counter % 3 == 0) {
			for (UfoObj ufo : ufos) {
				ufo.increaseSpeed();
			}
		}
	}
}
