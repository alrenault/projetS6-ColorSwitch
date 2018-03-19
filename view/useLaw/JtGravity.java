package view.useLaw;

import game.ball.BallPlayer;

public class JtGravity implements UseLaw {
	
	BallPlayer ball;

	public JtGravity(BallPlayer ball) {
		this.ball = ball ;
	}

	@Override
	public void apply() {
		System.out.println("Gravity");
		
		ball.getShape().setTranslateY(ball.getShape().getTranslateY()+5);
		
		//ball.getShape().setLayoutY(-10);
		
	}
}
