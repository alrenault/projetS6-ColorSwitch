package view.useLaw;

import game.ball.BallPlayer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Jump implements UseLaw {

	BallPlayer ball;
	Scene scene;
	double last_jump_time;
	double duration_since_last_jump;
	double current_time;
	double vectorY=0;
	
	public Jump(BallPlayer ball,Scene scene) {
		this.ball = ball ; 
		this.scene = scene;
		current_time = System.currentTimeMillis();
		last_jump_time = current_time;
		duration_since_last_jump=0;
	}
	
	@Override
	public void apply() {
		
		current_time = System.currentTimeMillis();
		
		scene.setOnKeyPressed(event -> {
			
			
			
			
			
			
			boolean space = event.getCode() == KeyCode.SPACE;
			if(space) {
				last_jump_time = current_time ;
			}
			
			
			
			
			//ball.getShape().setTranslateX(i-scene.getWidth()/2);
		});
		
		
		duration_since_last_jump = current_time - last_jump_time ;
		
		double j = computePosition(duration_since_last_jump);
		
		//System.out.println(j);
		ball.getModelBall().addVectorY(-j/2);

	}
	
	private double computePosition(double time) {
		vectorY = 1000/(time+0.01);
		return vectorY;
	}

}
