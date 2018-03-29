package view;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import java.net.URL;

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
    private static double volume = 0.1;

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
        } catch (Exception e) {
            System.out.println("Impossible de charger la Musique");
        }
        //String jumpURL = "src/ressources/Spring.wav";
    }

    /**
     * Lance le son du saut
     */
    public static void playJumpSound() {
        if (jump != null) jump.play();
        System.out.println("coucou");
    }

    /**
     * Lance la musique du jeu
     */
    public static void playMusic() {
        if (music != null) music.play();
    }
    
    /**
     * Coupe la musique du jeu
     */
    public static void stopMusic() {
        if (music != null) music.stop();
    }

    /**
     * Lance le son du GameOver
     */
    public static void playGameOverSOund() {
        if (gameOver != null) gameOver.play();
    }

    /**
     * Lance le son du ramassage d'étoile
     */
    public static void playStarSound() {
        if (star != null) star.play();
    }

    /**
     * Mute le son
     */
    public static void muteSound() {
    	if(music.isPlaying()){
    		music.stop();
            music.setVolume(0);
            jump.stop();
            jump.setVolume(0);
            gameOver.stop();
            gameOver.setVolume(0);
            star.stop();
            star.setVolume(0);
    	}
    	else
    		unMuteSound();
        
    }

    /**
     * Demute le son
     */
    public static void unMuteSound() {
        music.setVolume(volume);
        jump.setVolume(volume+0.5);
        gameOver.setVolume(volume);
        star.setVolume(volume);
        
        star.play();
        music.play();
    }
}
