package view.useLaw;

import javafx.geometry.Point2D;
import javafx.scene.Scene;
import view.game.ball.BallPlayer;

public class LockBall implements UseLaw {

	Scene scene;
	BallPlayer ball;
	double difference = 0;
	double limite = 0;
	double yCamera = 0;
	
	public LockBall(Scene scene, BallPlayer ball) {
		this.scene = scene ;
		this.ball = ball ;
		
		difference = 0;
		limite = scene.getHeight()/2;
		yCamera = 0;
	}
	
	@Override
	public void apply() {


		Point2D coordPlayer = ball.getCoord();
		
		difference = coordPlayer.getY() - limite ;
		

		limite+=difference;
		yCamera+=difference;

		
		scene.getCamera().setTranslateY(yCamera);
	}

}
