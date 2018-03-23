package view.useLaw;

import view.game.ball.BallPlayer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Jump implements UseLaw {

	private BallPlayer ball;
	private Scene scene;
	private double last_jump_time;
	private double duration_since_last_jump;
	private double current_time;
	private double vectorY=0;
	
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
			if(space && duration_since_last_jump > 150) {
				last_jump_time = current_time ;
			}
		});
		
		
		duration_since_last_jump = current_time - last_jump_time ;
		
		double j = computePosition(duration_since_last_jump);
		
		ball.getBall().addVectorY(-j);

	}
	
	private double computePosition(double time) {
		vectorY = 800/(time+0.01);
		return vectorY;
	}

}
