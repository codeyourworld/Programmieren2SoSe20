package regextool;

import java.util.ArrayList;

public class Exercise {

	public static final int BEGINNER = 10;
	public static final int EASY = 11;
	public static final int MIDDLE = 12;
	public static final int ADVANCED = 13;
	public static final int DIFFICULT = 14;
	public static final int CHUCK_NORRIS = 15;
	private String text;
	private ArrayList<Word> goodWords = new ArrayList<Word>();
	private ArrayList<Word> badWords = new ArrayList<Word>();
	private boolean succeded;
	private String feedback;
	private int level;
	
	
	public Exercise(int level, String text, ArrayList<Word> goodWords, ArrayList<Word> badWords) {
		super();
		this.level = level;
		this.text = text;
		this.goodWords = goodWords;
		this.badWords = badWords;
	}

	public boolean isSucceded() {
		return succeded;
	}

	public void setSucceded(boolean succeded) {
		this.succeded = succeded;
	}

	public String getText() {
		return text;
	}

	public ArrayList<Word> getGoodWords() {
		return goodWords;
	}

	public ArrayList<Word> getBadWords() {
		return badWords;
	}

	public String getFeedback() {
		return feedback;
	}
	
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}
