package playSound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound {

	public void play(String filePath) {

		try {

			// create AudioInputStream object
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

			// create clip reference
			Clip clip = AudioSystem.getClip();

			// open audioInputStream to the clip
			clip.open(audioInputStream);

//            clip.loop(Clip.LOOP_CONTINUOUSLY); 
			clip.start();

			// solange in milliseconds wird ein Sound abgespielt
			Thread.sleep(5000);

		}

		catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();

		}

	}
	
	public static void main(String[] args) {
		PlaySound playSound = new PlaySound();
		playSound.play("01Vorlesung\\assets\\dat03.wav");
	}
}
