package datastructures;

import java.util.ArrayList;
import java.util.Collections;

public class HighscoreMain {
	
	public static void main(String[] args) {
//		Objekt, welches wir reinspeichern wollen, hier: Highscore(die Klasse)
		ArrayList<Highscore> highscore = new ArrayList<>();
		highscore.add(new Highscore("Pika", 42));
		highscore.add(new Highscore("Chuck", 10000));
		highscore.add(new Highscore("Vegeta", 9001));
		highscore.add(new Highscore("Edmund", 42));
		highscore.add(new Highscore("Covid", 19));
		highscore.add(new Highscore("Covid", 1337));
		
		Collections.sort(highscore);
		
		for(Highscore score: highscore) {
//			eventuell String.format angucken
			System.out.println(score.getName() + ":\t" + score.getPoints());
		}
	}

}
