package interfaceBsp;

public class MarketMain {

	public static void main(String[] args) {
		IBuyable [] article = new IBuyable[4];
		article[0] = new Tree("Buche", 10.5f, 19.99f);
		article[1] = new Tree("Essigbaum", 7.3f, 14.99f);
		article[2] = new Color(49.99f, "weiﬂ", "Alpina");
		article[3] = new Color(29.99f, "blau", "andereMarke");
		
		for(IBuyable prod : article) {
			if(prod instanceof Color) {
				System.out.print("Artikel Color: " + ((Color)prod).getName());
			} else if(prod instanceof Tree) {
				System.out.print("Artikel Tree: " + ((Tree)prod).getName());
			}
			System.out.println(prod.price());
		}
	}
}
