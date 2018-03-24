package view;

import java.nio.file.Paths;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class Sound {
	
	private static AudioClip jump;
	private static AudioClip music;
	private static Sound sound;

	public Sound() {
		String jumpURL = "src/ressources/Spring.wav";
		Media jumpMedia = new Media(Paths.get(jumpURL).toUri().toString());
		jump = new AudioClip(jumpMedia.getSource());
		
		String musicURL = "src/ressources/Spring.wav";
		Media musicMedia = new Media(Paths.get(musicURL).toUri().toString());
		music = new AudioClip(musicMedia.getSource());
		music.setCycleCount(AudioClip.INDEFINITE);
	}
	
	public static void playJumpSound() {
		jump.play();
	}
	
	public static void playMusicSound() {
		music.play();
	}
	
	public static void muteSound() {
		music.setVolume(0);
		jump.setVolume(0);
	}
}
