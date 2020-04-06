package regextool;

import java.util.ArrayList;
import java.util.List;

public class ExerciseController {

	private List<Exercise> exercises = new ArrayList<Exercise>();

	public ExerciseController() {		

		loadExercises01();
		loadExercises02();
		loadExercises03();
		loadExercises04();
//		loadExercises05();
//		loadExercises06();
//		loadExercises07();
		
		
		loadExercises51();
		loadExercises52();
		loadExercises53();
		loadExercises54();
		loadExercises55();
		loadExercises56();
		loadExercises57();
	}

	private void loadExercises01() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("laufen"));
		goodWords.add(new Word("saufen"));
		goodWords.add(new Word("Rauf"));
		goodWords.add(new Word("auf dem"));
		goodWords.add(new Word("taufen"));
		goodWords.add(new Word("kaufen"));
		goodWords.add(new Word("raufen"));
		goodWords.add(new Word("Schaufel"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("aus"));
		badWords.add(new Word("tauchen"));
		badWords.add(new Word("raus"));
		badWords.add(new Word("laut"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("au f"));
		badWords.add(new Word("genau"));
		badWords.add(new Word("ufff"));

		String text = "Filtert nach Wörtern, die ein \"auf\" enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.BEGINNER, text, goodWords, badWords));
	}

	private void loadExercises02() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("laufen"));
		goodWords.add(new Word("rauf"));
		goodWords.add(new Word("tauchen"));
		goodWords.add(new Word("raus"));
		goodWords.add(new Word("laut"));
		goodWords.add(new Word("raufen"));
		goodWords.add(new Word("schaufeln"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("AHHH"));
		badWords.add(new Word("1.1.89"));
		badWords.add(new Word("WTF!!"));
		badWords.add(new Word("#####"));
		badWords.add(new Word("Y/N?"));
		badWords.add(new Word("42"));
		badWords.add(new Word("OH NO"));

		String text = "Filtert nach Wörtern, die kleine Buchstaben enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.BEGINNER, text, goodWords, badWords));
	}

	private void loadExercises03() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("123"));
		goodWords.add(new Word("42"));
		goodWords.add(new Word("89"));
		goodWords.add(new Word("1987"));
		goodWords.add(new Word("7"));
		goodWords.add(new Word("12345"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("laut"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("au f"));
		badWords.add(new Word("WTF!!"));
		badWords.add(new Word("#####"));
		badWords.add(new Word("Y/N?"));
		badWords.add(new Word("OH NO"));

		String text = "Filtert nach Wörtern, die Zahlen enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.BEGINNER, text, goodWords, badWords));
	}


	private void loadExercises04() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Was geht?"));
		goodWords.add(new Word("42"));
		goodWords.add(new Word("89"));
		goodWords.add(new Word("1987"));
		goodWords.add(new Word("7"));
		goodWords.add(new Word("12345"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("laut"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("au f"));
		badWords.add(new Word("WTF!!"));
		badWords.add(new Word("#####"));
		badWords.add(new Word("Y/N?"));
		badWords.add(new Word("OH NO"));

		String text = "Filtert nach Ausdrücken, die sowohl Klein- als auch Großbuchstauben enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.BEGINNER, text, goodWords, badWords));
	}

	private void loadExercises15() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Was geht?"));
		goodWords.add(new Word("4 + 2 = 10"));
		goodWords.add(new Word("89"));
		goodWords.add(new Word("1987"));
		goodWords.add(new Word(""));
		goodWords.add(new Word("gut gemacht!"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("WasGeht?"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("auf"));
		badWords.add(new Word("WTF!!"));
		badWords.add(new Word("#####"));
		badWords.add(new Word("Y/N?"));
		badWords.add(new Word("OHNO"));

		String text = "Filtert nach Ausdrücken, die ein Whitespace (Leertaste, Zeilenumbruch, Tab) enthalten. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.BEGINNER, text, goodWords, badWords));
	}

	private void loadExercises51() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Sonne"));
		goodWords.add(new Word("sonnig"));
		goodWords.add(new Word("saß"));
		goodWords.add(new Word("sitzen"));
		goodWords.add(new Word("Sessel"));
		goodWords.add(new Word("aussingen"));
		goodWords.add(new Word("sammeln"));
		goodWords.add(new Word("suchen"));
		goodWords.add(new Word("sagen"));
		goodWords.add(new Word("Sage"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("aus"));
		badWords.add(new Word("reißen"));
		badWords.add(new Word("Spliss"));
		badWords.add(new Word("Spross"));
		badWords.add(new Word("huhu"));
		badWords.add(new Word("hu hu"));
		badWords.add(new Word("singe2"));
		badWords.add(new Word("sing2e"));

		String text = "Filtert nach Wörtern, die mit s oder S beginnen, aber nicht mit s aufhören. "
				+ "Diese Wörter dürfen nur aus Buchstaben bestehen und haben ab dem 2. Buchstaben nur kleine Buchstaben. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.DIFFICULT, text, goodWords, badWords));
	}

	private void loadExercises52() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Martin Max Mustermann"));
		goodWords.add(new Word("Mira van Hagen"));
		goodWords.add(new Word("Torsten de Larrin"));
		goodWords.add(new Word("Sina Schmidt"));
		goodWords.add(new Word("marvin"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("St4phi"));
		badWords.add(new Word("Jan-Mirko"));
		badWords.add(new Word("Dennis  Carsten Klein"));
		badWords.add(new Word("Richard_Klein"));
		badWords.add(new Word("Richard.Klein"));
		badWords.add(new Word("Digga!"));

		String text = "Filtert nach Namen. Diese Namen dürfen nur aus Buchstaben bestehen und können Leerzeichen enthalten. "
				+ "Ab dem 2. Buchstaben dürfen nur kleine Buchstaben. Der erste Buchstabe darf kleingeschrieben sein. "
				+ "Es dürfen keine zwei Leerzeichen aufeinander folgen. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.DIFFICULT, text, goodWords, badWords));
	}

	private void loadExercises53() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Abendessen"));
		goodWords.add(new Word("Affen"));
		goodWords.add(new Word("decken"));
		goodWords.add(new Word("baden"));
		goodWords.add(new Word("Chaoten"));
		goodWords.add(new Word("Chancen"));
		goodWords.add(new Word("denken"));
		goodWords.add(new Word("dichten"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("barfuß gehen"));
		badWords.add(new Word("Biene"));
		badWords.add(new Word("Bruder"));
		badWords.add(new Word("Abend"));
		badWords.add(new Word("Rachen"));
		badWords.add(new Word("rufen"));

		String text = "Filtert nach Wörtern, die mit a, A, B, b, c, C, d oder D beginnen und mit n aufhören. "
				+ "Diese Wörter dürfen nur aus Buchstaben bestehen und haben ab dem 2. Buchstaben nur kleine Buchstaben."
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.DIFFICULT, text, goodWords, badWords));
	}

	private void loadExercises54() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("Abendessen"));
		goodWords.add(new Word("Affen"));
		goodWords.add(new Word("anders"));
		goodWords.add(new Word("arrangieren"));
		goodWords.add(new Word("Asien"));
		goodWords.add(new Word("Arten"));
		goodWords.add(new Word("Abend"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("Affe"));
		badWords.add(new Word("aber"));
		badWords.add(new Word("Attacke"));
		badWords.add(new Word("Bund"));
		badWords.add(new Word("Art"));
		badWords.add(new Word("Biene"));
		badWords.add(new Word("baden"));
		badWords.add(new Word("suchen"));
		badWords.add(new Word("A1rten"));
		badWords.add(new Word("Abend-Essen"));

		String text = "Filtert nach Wörtern, die mit a oder A beginnen und ein n im Wort haben. "
				+ "Diese Wörter dürfen nur aus Buchstaben bestehen und haben ab dem 2. Buchstaben nur kleine Buchstaben. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.DIFFICULT, text, goodWords, badWords));
	}

	private void loadExercises55() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("[23:43:32] Der Spieler stellt einen neuen Rekord mit 192 Punkten auf."));
		goodWords.add(new Word("[00:13:42] 201 ist der neue Rekord."));
		goodWords.add(new Word("[23:59:59] 204 Punkte – was für eine grandiose Leistung."));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("Der Spieler ist offline."));
		badWords.add(new Word("Der Spieler ist online."));
		badWords.add(new Word("Der Spieler tritt einem Match bei."));
		badWords.add(new Word("Das Match geht mit 192:87 Punkten in 01:47 Min aus."));
		badWords.add(new Word("[57:11:99] Dies ist keine richtige Uhrzeit."));
		badWords.add(new Word("[24:00:00] Dies sollt ihr nicht filtern."));
		badWords.add(new Word("[00:95:00] Dies sollt ihr nicht filtern."));


		String text = "Stellt euch vor ihr hättet eine riesige Log-Datei eines Spiels. "
				+ "Immer wenn jemand einen neuen Rekord aufstellt, wird dies in der "
				+ "Log-Datei mit einem Zeitstempel (z.B.: 22:34:02) und einer entsprechenden "
				+ "Nachricht eingetragen. Ihr sollt die Zeilen aus der Log-Datei filtern, "
				+ "die so einen Zeitstempel haben, achtet darauf, dass im Zeitstempel auch nur "
				+ "gültige Uhrzeiten stehen können. In so einer Zeile können Zahlen, Buchstaben, "
				+ "Leerzeichen, Doppelpunkte, Satzzeichen auftreten. "
				+ "Ihr sollt die komplette Zeile filtern."
				+ "In Grün sind die Zeilen aufgeführt, die ihr filtern solltet. In Rot sind Zeilen aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.DIFFICULT, text, goodWords, badWords));
	}

	private void loadExercises56() {
		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("stephanieb@gmail.com"));
		goodWords.add(new Word("noreply@gmx.net"));
		goodWords.add(new Word("tim23@yahoo.de"));
		goodWords.add(new Word("coffee2go@marke.de"));
		goodWords.add(new Word("grrrrr@keinklopapier.da"));
		goodWords.add(new Word("alle@nudelnsind.weg"));
		goodWords.add(new Word("hierkönntedeine@email.sein"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		badWords.add(new Word("was.geht.so?@nicht.v1el"));
		badWords.add(new Word("@gmail.com"));
		badWords.add(new Word("stephi@gmail."));
		badWords.add(new Word("sonne@istCool?ne"));
		badWords.add(new Word("Chuck.norris@brauchtkeine.email"));
		badWords.add(new Word("Warum-habe-ich keinen@kuchen.hier"));

		String text = "Schreibt eine Methode boolean emailCheck(String email), dabei sollt ihr prüfen, "
				+ "ob die Email-Adresse ein Mix aus Buchstaben und Zahlen, gefolgt von einem @, "
				+ "danach sind Buchstaben erlaubt, ein Punkt muss folgen und "
				+ "danach müssen 2-4 Buchstaben wieder folgen. Eure emailCheck()-Methode soll prüfen, "
				+ "ob angegebene Email-Adressen diesem Schema folgen. "
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. "
				+ "In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.DIFFICULT, text, goodWords, badWords));
	}

	private void loadExercises57() {

		ArrayList<Word> goodWords = new ArrayList<Word>();
		goodWords.add(new Word("01.01.00"));
		goodWords.add(new Word("23.12.99"));
		goodWords.add(new Word("31.01.10"));
		goodWords.add(new Word("14.10.30"));
		goodWords.add(new Word("05.07.59"));
		goodWords.add(new Word("99.99.99"));

		ArrayList<Word> badWords = new ArrayList<Word>();
		goodWords.add(new Word("199.01.99"));
		goodWords.add(new Word("01.01.919"));
		goodWords.add(new Word("01.01.1999"));
		goodWords.add(new Word("z9.07.69"));
		goodWords.add(new Word("23.1.81"));
		goodWords.add(new Word("9.9.99"));

		String text = "Schreibt eine Methode boolean dateCheck(String date), dabei sollt ihr prüfen, "
				+ "ob date dem richtigen Schema entspricht. Richtig sind alle zweistelligen "
				+ "Zahlen wie folgt angeordnet: Zahl.Zahl.Zahl."
				+ "In Grün sind die Wörter aufgeführt, die ihr filtern solltet. "
				+ "In Rot sind Wörter aufgeführt, die ihr nicht filtern solltet.";
		exercises.add(new Exercise(Exercise.DIFFICULT, text, goodWords, badWords));
	}
	
	



}
