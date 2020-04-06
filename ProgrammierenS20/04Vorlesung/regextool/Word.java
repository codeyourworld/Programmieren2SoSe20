package regextool;

public class Word {

	private String word;
	private boolean [] isMatched;
	
	public Word(String word) {
		super();
		this.word = word;
		initIsMatched();
	}

	private void initIsMatched() {
		isMatched = new boolean[word.length()];
		for(int i = 0; i < isMatched.length; i++) {
			isMatched[i] = false;
		}
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
		initIsMatched();
	}

	public boolean[] getIsMatched() {
		return isMatched;
	}

	public void setIsMatched(boolean[] isMatched) {
		this.isMatched = isMatched;
	} 
	
}
