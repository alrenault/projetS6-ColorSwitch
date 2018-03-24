package view;

import java.net.URL;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class Sound {
	
	private static AudioClip jump;
	private static AudioClip music;
	private static AudioClip gameOver;
	private static AudioClip star;
	
	private static double volume;
	
	private static Sound sound;

	public Sound() {
		
		volume = 0.1;
		
		try {
			
			URL jumpURL = this.getClass().getResource("/resources/JumpSound.mp3");
			Media jumpMedia = new Media(jumpURL.toString());
			jump = new AudioClip(jumpMedia.getSource());
			
			URL starURL = this.getClass().getResource("/resources/StarSound.mp3");
			Media starMedia = new Media(starURL.toString());
			star = new AudioClip(starMedia.getSource());
			
			URL gameOverURL = this.getClass().getResource("/resources/GameOverSound.mp3");
			Media gameOverMedia = new Media(gameOverURL.toString());
			gameOver = new AudioClip(gameOverMedia.getSource());
			
			URL musicURL = this.getClass().getResource("/resources/ColorSuitch.mp3");
			Media musicMedia = new Media(musicURL.toString());
			music = new AudioClip(musicMedia.getSource());
			music.setCycleCount(999);
			
			unMuteSound();
			
			//String musicURL = "src/ressources/Spring.wav";
			//Media musicMedia = new Media(Paths.get(musicURL).toUri().toString());
			//music = new AudioClip(musicMedia.getSource());
			//music.setCycleCount(AudioClip.INDEFINITE);
		} catch(Exception e) {
			System.out.println("Impossible de charger la Musique");
		}
		//String jumpURL = "src/ressources/Spring.wav";
	}
	
	public static void playJumpSound() {
		if (jump != null) jump.play();
	}
	
	public static void playMusic() {
		if (music != null) music.play();
	}
	
	public static void playGameOverSOund() {
		if (gameOver != null) gameOver.play();
	}
	
	public static void playStarSound() {
		if (star != null) star.play();
	}
	
	
	public static void muteSound() {
		music.setVolume(0);
		jump.setVolume(0);
		gameOver.setVolume(0);
		star.setVolume(0);
	}
	
	public static void unMuteSound() {
		music.setVolume(volume);
		jump.setVolume(volume);
		gameOver.setVolume(volume);
		star.setVolume(volume);
	}
}
