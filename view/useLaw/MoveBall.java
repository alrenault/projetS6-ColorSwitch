package view.useLaw;

import game.ball.BallPlayer;

public class MoveBall implements UseLaw {

	private BallPlayer ball;
	
	MoveBall(BallPlayer ball){
		this.ball = ball ;
	}
	
	@Override
	public void apply() {
		ball.getBall().moveBall();
		
		System.out.println("Ball --- X : "+ball.getBall().getX()+" - Y : "+ball.getBall().getY());
		
		ball.getShape().setTranslateX(ball.getBall().getX());
		ball.getShape().setTranslateY(ball.getBall().getY());

	}

}
