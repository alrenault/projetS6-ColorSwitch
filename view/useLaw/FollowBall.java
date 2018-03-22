package view.useLaw;

import view.game.ball.BallPlayer;
import javafx.geometry.Point2D;
import javafx.scene.Scene;


public class FollowBall implements UseLaw {

	Scene scene;
	BallPlayer ball;
	double difference;
	double limite;
	double yCamera;
	
	public FollowBall(Scene scene, BallPlayer ball) {
		this.scene = scene;
		this.ball = ball;
		difference = 0;
		limite = scene.getHeight()/2;
		yCamera = 0;
		
	}
	
	@Override
	public void apply() {
		
		Point2D coordPlayer = ball.getCoord();
		
		difference = coordPlayer.getY() - limite ;
		
		if (difference < 0) {
			limite+=difference;
			yCamera+=difference;
		}
		
		scene.getCamera().setTranslateY(yCamera);

	}

}
