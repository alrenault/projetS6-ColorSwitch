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
		
		System.out.println("Y Ball - "+ball.getBall().getY());
		System.out.println("Scene moitié - "+scene.getHeight()/2);
		
		double difference = Math.abs(ball.getBall().getY()) - scene.getHeight()/2 ;
		
		System.out.println("Difference : " + difference);
		System.out.println("Hello");
		
		if (difference > 0){
			//System.out.println("HELLO BOBBY !!");
			//scene.getCamera().setTranslateY(-difference);
		}

	}

}
