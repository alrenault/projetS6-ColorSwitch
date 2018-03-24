package model.modelBall;

import javafx.scene.Scene;
import model.game.ball.BallPlayer;

/**
 * Générateur de balle
 */
public class BuildBall {

	/**
	 * Génère une balle depuis un modèle et une scène
	 * @param ball Le modèle de la balle dont on veut la balle
	 * @param scene La scène où se trouve la balle
	 * @return La balle
	 */
    public static BallPlayer build(Ball ball, Scene scene) {
        BallPlayer ballplayer;

        ballplayer = new BallPlayer(ball, scene);

        return ballplayer;
    }
}
