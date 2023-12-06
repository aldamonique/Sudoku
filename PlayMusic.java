package sudoku; 
import java.io.File;
import javax.sound.sampled.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayMusic{
	public static Clip clip; 
	
	public PlayMusic() {
		
	}
	public static void Play(String location) {
		try {
			File musicPath = new File(location);
			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.close();
			}else {
				System.out.println("Erro ao encontrar o arquivo");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		//clip.close();
	}
	
}