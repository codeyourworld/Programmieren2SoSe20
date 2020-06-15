package draw;

import java.awt.Color;

import ufogame.Ship;
import view.GameFrameWork;
import view.ITickable;
import view.Oval;
import view.Rectangle;

public class LetsDraw {

	
	public static void main(String[] args) {
		GameFrameWork frameWork = new GameFrameWork();
		frameWork.setSize(1000, 800);
		//Standardbibliothek von Java importieren, RGB Werte
		frameWork.setBackgroundColor(new Color(0,180,200));
		//interessant: Alles was im Vordergrund sein soll, muss später eingeführt werden
		frameWork.addRectangle(new Rectangle(100, 100, 400, 200, new Color(255,255,255)));
		frameWork.addOval(new Oval(200,200,30,50, new Color(0,255,0)));
		Ship ship = new Ship(600, 600, 200, 200, "01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);
		
	}
	
	
	
	
	/*private Rectangle rectangle = new Rectangle(100, 200, 200, 150, new Color(0, 0, 0));

	
	public static void main(String[] args) {
		LetsDraw draw = new LetsDraw();
		draw.init();
	}

	public void init() {
		GameFrameWork gameFrameWork = new GameFrameWork();
		gameFrameWork.setSize(1200, 1200);
		gameFrameWork.setBackgroundColor(new Color(0, 180, 180));
		gameFrameWork.addRectangle(rectangle);
		Rectangle rectangle2 = new Rectangle(-30, 700, 200, 50, new Color(255, 255, 255));
		gameFrameWork.addRectangle(rectangle2);
		Oval oval = new Oval(200, 300, 100, 100, new Color(255, 255, 0));
		gameFrameWork.addOval(oval);
		gameFrameWork.addTick(this);

	}

	@Override
	public void tick(long ellapseTime) {
		rectangle.setX(rectangle.getX() + 2);
		if(rectangle.getX() > 1200) {
			rectangle.setX(-200);
		}
	}*/
	
}
