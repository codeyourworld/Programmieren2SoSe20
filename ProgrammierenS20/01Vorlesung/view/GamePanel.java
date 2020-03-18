package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Shape> gameShapes = new LinkedList<Shape>();
	private LinkedList<IGameObject> gameObjects = new LinkedList<IGameObject>();
	private LinkedList<Image> imageObjects = new LinkedList<Image>();
	private IBackground background = null;
	private Image backgroundImage = null;
	private Color backgroundColor;
	private Dimension dimension;
	private String message = "";
	private int textSize = 0;
	private Color messageColor = Color.BLACK;
	private int messageX = 0;
	private int messageY = 0;

	public GamePanel(Dimension dimension) {
		this.dimension = dimension;
		this.backgroundColor = new Color(255, 255, 255);
		setPreferredSize(dimension);
		setSize(dimension);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(backgroundColor);
		g2.fillRect(0, 0, dimension.width, dimension.height);

		if (backgroundImage != null) {
			g2.drawImage(backgroundImage, 0, 0, dimension.width, dimension.height, null);
		}

		for (Shape shape : gameShapes) {
			g2.setColor(shape.getColor());
			if (shape instanceof Rectangle) {
				g2.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			} else {
				g2.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			}
		}

		synchronized (gameObjects) {
			synchronized (imageObjects) {
				for (int i = 0; i < imageObjects.size(); i++) {
					g2.drawImage(imageObjects.get(i), gameObjects.get(i).getX(), gameObjects.get(i).getY(),
							gameObjects.get(i).getWidth(), gameObjects.get(i).getHeight(), null);
				}
			}
		}
		
		g2.setColor(messageColor);
		g2.setFont(g2.getFont().deriveFont(Float.valueOf(textSize)));
		g2.drawString(message, messageX, messageY);
	}

	public void setGameObjects(LinkedList<IGameObject> gameObjects) {
		this.gameObjects = gameObjects;
	}

	public void setBackground(IBackground background) {
		this.background = background;
		try {
			backgroundImage = ImageIO.read(new File(background.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setImageObjects(LinkedList<Image> imageObjects) {
		this.imageObjects = imageObjects;
	}


	public void setGameShapes(LinkedList<Shape> gameShapes) {
		this.gameShapes = gameShapes;
	}

	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		dimension = new Dimension(width, height);
	}

	public void showMessage(String message, int x, int y, int textSize, Color color) {
		this.message = message;
		this.messageX = x;
		this.messageY = y;
		this.textSize = textSize;
		this.messageColor = color;
	}

	public void setBackgroundColor(Color color) {
		backgroundColor = color;
		
	}

}
