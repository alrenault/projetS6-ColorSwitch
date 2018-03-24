package view.useLaw;

import controller.Controller;
import view.ViewPath;
import view.ball.BallPlayer;

/**
 * Loi testant sio on a dépassé la ligne d'arrivée
 */
public class FinishLine implements UseLaw {

	/**
	 * Le viewPath où doit se trouver la loi
	 */
	private ViewPath path;
	
	/**
	 * La balle qui doit passer la ligne d'arrivée
	 */
	private BallPlayer ball;
	
	/**
	 * Référence au controlleur
	 */
	private Controller controller;
	
	/**
	 * Constructeur de la loi
	 * @param path Le viewPath où doit se trouver la loi
	 * @param ball La balle qui doit passer la ligne d'arrivée
	 * @param controller Référence au controlleur
	 */
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
