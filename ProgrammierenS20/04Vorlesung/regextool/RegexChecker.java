package regextool;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegexChecker {

	
	public void checkWords(String pattern, List<Word> goodWords, List<Word> badWords) {
		Pattern p = Pattern.compile(pattern);
		checkList(goodWords, p);
		checkList(badWords, p);
	}

	private void checkList(List<Word> list, Pattern p) {
		for(Word word : list) {
			Matcher matcher = p.matcher(word.getWord());
			try {
				if(matcher.find()) {
					int start = matcher.start();
					int end = matcher.end();

					//set words array in class Word
					boolean [] words = word.getIsMatched();
					for(int i = start; i < end; i++) {
						words[i] = true;
					}
					word.setIsMatched(words);
					
				}
				
			} catch (Exception e) {
				System.out.println("There was no match for word " + word.getWord() + " with the pattern " + p);
			}
		}
	}
	
}
