package view.useLaw;

import controller.Controller;
import view.ViewPath;
import view.game.ball.BallPlayer;

public class FinishLine implements UseLaw {

	private ViewPath path;
	private BallPlayer ball;
	private Controller controller;
	
	public FinishLine(ViewPath path, BallPlayer ball, Controller controller) {
		this.path = path;
		this.ball = ball;
		this.controller = controller;
	}
	
	@Override
	public void apply() {
		
		System.out.println("Y Ball :"+Math.abs(ball.getBall().getY()));
		System.out.println("Y Finish :"+Math.abs(path.getYFinishLine()));
		
		
		
		
		if(Math.abs(ball.getBall().getY()) >= Math.abs(path.getYFinishLine())) {
			controller.win();
		}
			

	}

}
