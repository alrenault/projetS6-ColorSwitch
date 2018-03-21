package view.useLaw;

import game.ball.BallPlayer;

public class MoveBall implements UseLaw {

	private BallPlayer ball;
	
	MoveBall(BallPlayer ball){
		this.ball = ball ;
	}
	
	@Override
	public void apply() {
		ball.getModelBall().moveBall();
		
		ball.getShape().setTranslateX(ball.getX());
		ball.getShape().setTranslateY(ball.getY());

	}

}
