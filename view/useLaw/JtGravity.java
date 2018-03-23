package view.useLaw;

import view.game.ball.BallPlayer;

/**
 *
 */
public class JtGravity implements UseLaw {
	/**
	 *
	 */
    private BallPlayer ball;

	/**
	 *
	 * @param ball
	 */
	public JtGravity(BallPlayer ball) {
		this.ball = ball ;
	}

	/**
	 *
	 */
	@Override
	public void apply() {
		//System.out.println("Gravity");
		
		ball.getBall().addVectorY(6);
		
		//ball.getShape().setTranslateY(ball.getShape().getTranslateY()+5);
		
		//ball.getShape().setLayoutY(-10);
		
	}
}
