package view.useLaw;


import game.ball.BallPlayer;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;

public class Race implements UseLaw {

	BallPlayer ball;
	Scene scene;
	
	public Race(BallPlayer ball, Scene scene) {
		this.ball = ball;
	}
	
	@Override
	public void apply() {
		// TODO Auto-generated method stub

		ball.getShape().setTranslateY(ball.getShape().getTranslateY()-5);
		
		//scene.setOnMouseDragged(event -> System.out.println("Hello"));
		//scene.setOnKeyPressed(event -> System.out.println("Hello"));
		
		
		//ball.getShape().setTranslateX(ball.getShape().getTranslateY()-5);

	}

}
