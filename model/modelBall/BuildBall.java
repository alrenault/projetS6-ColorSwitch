package model.modelBall;

import game.ball.Player;
import game.ball.BallPlayer;
import javafx.scene.Scene;

public class BuildBall {

	public static BallPlayer build(Player ball, Scene scene) {
		BallPlayer ballplayer;
		
		ballplayer = new BallPlayer(ball,scene);
		
		return ballplayer;
	}
}
