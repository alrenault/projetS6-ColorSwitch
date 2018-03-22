package view.useLaw;

import game.ball.BallPlayer;
import javafx.scene.Scene;


public class FollowBall implements UseLaw {

	Scene scene;
	BallPlayer ball;
	
	public FollowBall(Scene scene, BallPlayer ball) {
		this.scene = scene;
		this.ball = ball;
	}
	
	@Override
	public void apply() {
		// TODO Auto-generated method stub
		
		double difference = Math.abs(ball.getModelBall().getY()) - scene.getHeight()/2 ;
		
		if (difference > 0){
			//System.out.println("HELLO BOBBY !!");
			scene.getCamera().setTranslateY(-difference);
		}

	}

}
