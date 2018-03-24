package view.useLaw;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import view.ball.BallPlayer;

/**
 * La loi générant le saut du joueur
 */
public class Jump implements UseLaw {

	/**
	 * La balle représentant le joueur
	 */
    private BallPlayer ball;
    
    /**
     * La scène où se trouve le joueur
     */
    private Scene scene;
    
    /**
     * Le moment du dernier saut
     */
    private double last_jump_time;
    
    /**
     * Le temps depuis le dernier saut
     */
    private double duration_since_last_jump;
    
    /**
     * Le temps présent
     */
    private double current_time;
    
    /**
     * Vecteur qu'on ajoute à chaque frame à la balle
     */
    private double vectorY = 0;
    
    /**
     * La durée du saut
     */
    private double jump_duration;

    /**
     * Constructeur de la loi
     * @param ball La balle devant sauter
     * @param scene LA scène où se trouve la balle
     */
    public Jump(BallPlayer ball, Scene scene) {
        this.ball = ball;
        this.scene = scene;
        current_time = System.currentTimeMillis();
        last_jump_time = current_time;
        duration_since_last_jump = 0;
        jump_duration = 1;
    }

    @Override
    public void apply() {

        current_time = System.currentTimeMillis();


        scene.setOnKeyPressed(event -> {

            boolean space = event.getCode() == KeyCode.SPACE;
            if (space && duration_since_last_jump > 150) {
                last_jump_time = current_time;
            }
        });


        duration_since_last_jump = current_time - last_jump_time;

        double j = computePosition(duration_since_last_jump);

        ball.getBall().addVectorY(-j * 0.55);

    }

    /**
     * Trouve la position de la balle
     * @param duration_since_last_jump Le temps depuis le dernier saut
     * @return La position de la balle
     */
    private double computePosition(double duration_since_last_jump) {
        double during_jump = jump_duration * 1000 - duration_since_last_jump;
        if (during_jump < 0) during_jump = 0;
        vectorY = Math.abs(during_jump) / 50;

        //vectorY = 800 / (duration_since_last_jump + 0.01);
        return vectorY;
    }

}
