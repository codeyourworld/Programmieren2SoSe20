package ufoStephi;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;


public class HighScore implements Serializable{
	
	
	
	
		public LinkedList<Score> scoreList;
		
		public HighScore()
		{
			scoreList = new LinkedList();
			
			scoreList.add(new Score(122,"Nana"));
			scoreList.add(new Score(23, "Gugu"));
			scoreList.add(new Score(12,"June"));
		
		
			//Sortieren der HighScore Liste
			Collections.sort(scoreList);
		}
		
		
		public void ToString()
		{
			//Ausgabe der Liste
			for(Score score1 : scoreList) {
				System.out.println(score1.getUsername() + " : " + score1.getPoints());
			}
			
		}
		
	}
	


