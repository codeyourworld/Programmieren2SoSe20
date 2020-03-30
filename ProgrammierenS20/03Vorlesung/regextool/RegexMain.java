package regextool;

import java.util.ArrayList;


public class RegexMain {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static void main(String[] args) {
		RegexChecker regexChecker = new RegexChecker();
		String pattern = "[Ss][a-zA-Zﬂ¸ˆ‰‹÷ƒ]*[a-rt-zA-RT-Z‰¸ˆƒ‹÷ﬂ]$";
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Sonne"));
		goodWords.add(new Word("sonnig"));
		goodWords.add(new Word("saﬂ"));
		goodWords.add(new Word("sitzen"));
		goodWords.add(new Word("Sessel"));
		goodWords.add(new Word("aussingen"));
		goodWords.add(new Word("sammeln"));
		goodWords.add(new Word("suchen"));
		goodWords.add(new Word("sagen"));
		goodWords.add(new Word("Sage"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("aus"));
		badWords.add(new Word("reiﬂen"));
		badWords.add(new Word("Spliss"));
		badWords.add(new Word("Spross"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("hu hu"));
		badWords.add(new Word("singe2"));
		badWords.add(new Word("sing2e"));

		regexChecker.checkWords(pattern, goodWords, badWords);
		
		for(Word word : goodWords) {
			for(int i = 0; i < word.getIsMatched().length; i++) {
				if(word.getIsMatched()[i]) {
					System.out.print(ANSI_GREEN + word.getWord().charAt(i) + ANSI_RESET);
				}
				else {
					System.out.print(ANSI_RED + word.getWord().charAt(i) + ANSI_RESET);
				}
			}
			System.out.println();
		}

		for(Word word : badWords) {
			for(int i = 0; i < word.getIsMatched().length; i++) {
				if(word.getIsMatched()[i]) {
					System.out.print(ANSI_GREEN + word.getWord().charAt(i) + ANSI_RESET);
				}
				else {
					System.out.print(ANSI_RED + word.getWord().charAt(i) + ANSI_RESET);
				}
			}
			System.out.println();
		}

	}
}
