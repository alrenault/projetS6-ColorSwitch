package view.useLaw;


import view.game.ball.BallPlayer;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;

/**
 *
 */
public class Race implements UseLaw {

	BallPlayer ball;
	Scene scene;
	double startTime;
	double currentTime;
	double duration;
	
	public Race(BallPlayer ball, Scene scene) {
		this.ball = ball;
		this.scene = scene;
		startTime = System.currentTimeMillis();
	}
	
	@Override
	public void apply() {
		// TODO Auto-generated method stub
		
		currentTime = System.currentTimeMillis();
		
		duration = currentTime-startTime;
		

		ball.getShape().setTranslateY(ball.getShape().getTranslateY()-5-(duration/1000));
		
		scene.setOnMouseMoved(event -> {
			double i;
			i = event.getSceneX();
			//ball.getShape().setTranslateX(i-scene.getWidth()/2);
			ball.getShape().setTranslateX(i);
		});
		//scene.setOnKeyPressed(event -> System.out.println("Hello"));
		
		
		//ball.getShape().setTranslateX(ball.getShape().getTranslateY()-5);

	}

}
