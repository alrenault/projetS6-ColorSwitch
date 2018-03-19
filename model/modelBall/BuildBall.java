package model.modelBall;

import game.ball.Ball;
import game.ball.BallPlayer;
import javafx.scene.Scene;

public class BuildBall {

	public static BallPlayer build(Ball ball, Scene scene) {
		BallPlayer ballplayer;
		
		ballplayer = new BallPlayer(ball,scene);
		
		return ballplayer;
	}
}
