package datastructures;

import java.util.ArrayList;
import java.util.Collections;

public class HighScoreMain {

	public static void main(String[] args) {

		ArrayList<Highscore> highscore = new ArrayList<>();
		highscore.add(new Highscore("Lale", 42));
		highscore.add(new Highscore("Krischan", 10000));
		highscore.add(new Highscore("Francie", 9999));
		highscore.add(new Highscore("Lutz",90001));
		highscore.add(new Highscore("Rita", 42));
		highscore.add(new Highscore("Sonja",2020));
		
		Collections.sort(highscore);
		
		for(Highscore score: highscore) {
			System.out.println(String.format("%20s:\t%d",score.getName(), score.getPoints()));
		}
	}

}