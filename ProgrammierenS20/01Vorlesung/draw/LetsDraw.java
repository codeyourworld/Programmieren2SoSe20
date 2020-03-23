package draw;

import java.awt.Color;

import view.GameFrameWork;
import view.ITickableListener;
import view.Oval;
import view.Rectangle;

public class LetsDraw implements ITickableListener{

	private Rectangle rectangle = new Rectangle(100, 200, 200, 150, new Color(0, 0, 0));

	
	public static void main(String[] args) {
		LetsDraw draw = new LetsDraw();
		draw.init();
	}

	public void init() {
		GameFrameWork gameFrameWork = new GameFrameWork();
		gameFrameWork.setSize(1200, 960);
		gameFrameWork.setBackgroundColor(new Color(0, 180, 180));
		gameFrameWork.setBackground(null);
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
	}
	
}
