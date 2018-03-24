package view;

import java.net.URL;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

/**
  Contient les sons et musiques utilisés par le jeu*
 */
public class Sound {
	
	/**
	 * Le son du saut
	 */
	private static AudioClip jump;
	
	/**
	 * La musique du jeu
	 */
	private static AudioClip music;
	
	/**
	 * Le son du GameOver
	 */
	private static AudioClip gameOver;
	
	/**
	 * Le son lorsque l'on ramasse une étoile
	 */
	private static AudioClip star;
	
	/**
	 * Le volume du son
	 */
	private static double volume;

	/**
	 * Constructeur créant tous les sons et musiques du jeu
	 */
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
	
	/**
	 * Lance le son du saut
	 */
	public void playJumpSound() {
		if (jump != null) jump.play();
	}
	
	/**
	 * Lance la musique du jeu
	 */
	public void playMusic() {
		if (music != null) music.play();
	}
	
	/**
	 * Lance le son du GameOver
	 */
	public void playGameOverSOund() {
		if (gameOver != null) gameOver.play();
	}
	
	/**
	 * Lance le son du ramassage d'étoile
	 */
	public void playStarSound() {
		if (star != null) star.play();
	}
	
	/**
	 * Mute le son
	 */
	public void muteSound() {
		music.setVolume(0);
		jump.setVolume(0);
		gameOver.setVolume(0);
		star.setVolume(0);
	}
	
	/**
	 * Demute le son
	 */
	public void unMuteSound() {
		music.setVolume(volume);
		jump.setVolume(volume);
		gameOver.setVolume(volume);
		star.setVolume(volume);
	}
}
