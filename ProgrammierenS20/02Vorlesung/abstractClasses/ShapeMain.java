package abstractClasses;

public class ShapeMain {

	public static void main(String[] args) {
		Shape [] shapes = new Shape[4];
		shapes[0] = new Rectangle(2, 4);
		shapes[1] = new Rectangle(5, 6);
		shapes[2] = new Circle(1);
		shapes[3] = new Circle(5);
		
		//einfache variante
//		for(int i = 0; i < shapes.length; i++) {
//			System.out.println(shapes[i].area());
//		}
		
		//coole variante :)
		for(Shape s : shapes) {
			System.out.println(s.area());
		}
		
	}
}
