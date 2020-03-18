package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

/**
 * GameFrameWork provides methods to simply draw shapes and images. 
 * To draw images you need to implement the interface IGameObject, the image is stretched by the given width and height.
 * The framework provides to draw Rectangles and Circles in a specific color and size. 
 * You just add the your object and it is painted every frame. If you want to have motions, just change your coordinates. 
 * Through the getX() and getY() Methods in the interfaces and classes the framework get the current position.
 * <br>
 * <br>
 * You can get notify at every frame. For that just implement the ITickable interface.
 * <br>
 * If you want to get notified when the mouse is clicked implement the IMouseInput interface.
 * <br>
 * If you want to get notified when a specific key is used implement the IKeyboardInput interface.
 * <br>
 * 
 * @author Stephi
 * @version 1.0
 * @see IGameObject
 * @see Shape
 * @see IKeyboardInput
 * @see IMouseInput
 * @see ITickable
 * @see IBackground
 */
public class GameFrameWork {
	private GameFrame gameFrame;
	private LinkedList<IKeyboardInput> keyInputs;
	private LinkedList<IMouseInput> mouseInputs;
	private LinkedList<Shape> gameShapes;
	private LinkedList<IGameObject> gameObjects;
	private LinkedList<Image> imageObjects;
	private LinkedList<ITickable> ticks;
	private int delay = 30;

	public static void main(String[] args) {
		new GameFrameWork();
	}
	
	/**
	 * Creates an white window of the size 400x400 pixels. If you want to have a bigger window use the setSize(int x, int y) method.
	 */
	public GameFrameWork() {
		init();
	}


	private void init() {

		gameObjects = new LinkedList<>();
		imageObjects = new LinkedList<>();
		gameShapes = new LinkedList<>();

		ticks = new LinkedList<>();
		mouseInputs = new LinkedList<>();
		keyInputs = new LinkedList<>();

		gameFrame = new GameFrame(imageObjects, gameObjects, gameShapes);

		gameFrame.setGameObjects(gameObjects);
		gameFrame.setImageObjects(imageObjects);
		gameFrame.setGameShapes(gameShapes);

		gameFrame.setVisible(true);
		gameFrame.toFront();
		gameFrame.requestFocus();

		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				for (ITickable tickable : ticks) {
					tickable.tick(delay);
				}
				gameFrame.update();
			}
		};
		Timer timer = new Timer();
		timer.schedule(timerTask, 50, delay);

		gameFrame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent event) {
				for (IKeyboardInput keys : keyInputs) {
					for (int key : keys.getKeys()) {
						if (event.getKeyCode() == key) {
							keys.keyDown(key);
						}
					}
				}
			}

		});
		gameFrame.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				for (IMouseInput mouse : mouseInputs) {
					mouse.mouseClicked();
				}

			}
		});

	}

	/**
	 * Sets the window size.
	 * @param width of the window
	 * @param height of the window
	 */
	public void setSize(int width, int height) {
		gameFrame.setSize(width, height);
	}


	/**
	 * Sets the background color to the RGB values. 
	 * <br>
	 * <br>
	 * If red, green and blue are 0 the color is black. 
	 * <br>
	 * If red, green and blue are 255 the color is white. 
	 * <br>
	 * If red is 255 and blue and green is 0 the color is red.
	 * <br>
	 * @param red value from 0 to 255
	 * @param green value from 0 to 255
	 * @param blue value from 0 to 255
	 */
	public void setBackgroundColor(int red, int green, int blue) {
		gameFrame.setBackground(new Color(red, green, blue));
	}

	public void setBackgroundColor(Color color) {
		gameFrame.setBackground(color);
	}

	
	/**
	 * Draws a rectangle at the x, y coordinate with the width and height.
	 * The rectangle has the color of the RGB values
	 * @param x coordinate of the rectangle
	 * @param y coordinate of the rectangle
	 * @param width of the rectangle
	 * @param height of the rectangle
	 * @param red value of the RGB color
	 * @param green value of the RGB color
	 * @param blue value of the RGB color
	 */
	public void drawRectangle(int x, int y, int width, int height, int red, int green, int blue) {
		gameShapes.add(new Rectangle(x, y, width, height, new Color(red, green, blue)));
	}

	/**
	 * Draws an oval at the x, y coordinate with the width and height.
	 * The oval has the color of the RGB values
	 * @param x coordinate of the oval
	 * @param y coordinate of the oval
	 * @param width of the oval
	 * @param height of the oval
	 * @param red value of the RGB color
	 * @param green value of the RGB color
	 * @param blue value of the RGB color
	 */
	public void drawOval(int x, int y, int width, int height, int red, int green, int blue) {
		gameShapes.add(new Circle(x, y, width, height, new Color(red, green, blue)));
	}

	/**
	 * Adds the gameobject to a list and draws it every frame. 
	 * A gameobject could be every class which implements the interface IGameObject.
	 * 
	 * @param gameObject to draw
	 */
	public void addGameObject(IGameObject gameObject) {
		synchronized (gameObjects) {
			synchronized (imageObjects) {
				gameObjects.add(gameObject);
				try {
					imageObjects.add(ImageIO.read(new File(gameObject.getImagePath())));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Removes the gameobject from the list, so it is not drawn anymore.
	 * 
	 * @param gameObject to remove from list
	 */
	public void removeGameObject(IGameObject gameObject) {
		synchronized (gameObjects) {
			synchronized (imageObjects) {
				int index = gameObjects.indexOf(gameObject);
				if(index >= 0) {
					imageObjects.remove(index);
					gameObjects.remove(index);					
				}
			}
		}
	}

	/**
	 * Adds a class to a list, so that class is notified when a user clicks.
	 * Every class which implements the interface IMouseInput can be added.
	 * @param mouseInput class to notify when a user clicks
	 */
	public void addIMouseInput(IMouseInput mouseInput) {
		mouseInputs.add(mouseInput);
	}

	/**
	 * Removes a class from a list, so that class is not notified anymore when a user clicks.
	 * @param mouseInput to remove from list
	 */
	public void removeIMouseInput(IMouseInput mouseInput) {
		mouseInputs.remove(mouseInput);
	}

	/**
	 * Adds a class to a list, so that class is notified when a user press a specific key. 
	 * Every class which implements the interface IKeyboardInput can be added.
	 * @param keyInput class to notify when a user press a key
	 */
	public void addIKeyInput(IKeyboardInput keyInput) {
		keyInputs.add(keyInput);
	}

	/**
	 * Removes a class from a list, so that class is not notified anymore when a user press a key.
	 * @param keyInput class to remove from list
	 */
	public void removeIKeyboardInput(IKeyboardInput keyInput) {
		keyInputs.remove(keyInput);
	}

	/**
	 * Notifies that class every time when a timer ticks and before new frame is drawn. 
	 * @param tickable class to notify at each timer tick
	 */
	public void addTick(ITickable tickable) {
		ticks.add(tickable);
	}

	/**
	 * Removes the class from a list so the class is not notified anymore at a timer tick.
	 * @param tickable to remove from list
	 */
	public void removeTick(ITickable tickable) {
		ticks.remove(tickable);
	}

	/**
	 * Draws a background every frame
	 * @param background to draw
	 */
	public void addBackground(IBackground background) {
		gameFrame.addBackground(background);
	}

	/**
	 * Removes that background so it is not drawn anymore
	 * @param background to remove
	 */
	public void removeBackground(IBackground background) {
		gameFrame.addBackground(null);

	}

	/**
	 * Shows a message at a specific x, y coordinate. That message is displayed in the given color and text size.
	 * 
	 * @param message to show
	 * @param x coordinate of the message
	 * @param y coordinate of the message
	 * @param textSize of the message
	 * @param red value of the RGB color, from 0 to 255
	 * @param green value of the RGB color, from 0 to 255
	 * @param blue value of the RGB color, from 0 to 255
	 */
	public void showMessage(String message, int x, int y, int textSize, int red, int green, int blue) {
		gameFrame.showMessage(message, x, y, textSize, new Color(red, green, blue));
	}
	
	/**
	 * Shows a message at a specific x, y coordinate. That message is displayed in the given color and text size.
	 * 
	 * @param message to show
	 * @param x coordinate of the message
	 * @param y coordinate of the message
	 * @param textSize of the message
	 * @param color as RGB color
	 * @see Color
	 */
	public void showMessage(String message, int x, int y, int textSize, Color color) {
		gameFrame.showMessage(message, x, y, textSize, color);
	}

}
