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
		
		System.out.println("Ball --- X : "+ball.getModelBall().getX()+" - Y : "+ball.getModelBall().getY());
		
		ball.getShape().setTranslateX(ball.getModelBall().getX());
		ball.getShape().setTranslateY(ball.getModelBall().getY());

	}

}
