package view.useLaw;


import view.game.ball.BallPlayer;
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
	double speed;
	
	public Race(BallPlayer ball, Scene scene) {
		this.ball = ball;
		this.scene = scene;
		startTime = System.currentTimeMillis();
		speed = 5;
	}
	
	@Override
	public void apply() {
		// TODO Auto-generated method stub
		
		currentTime = System.currentTimeMillis();
		
		duration = currentTime-startTime;
		
		
		if (speed > 10) speed = 5 + (duration/12000);
		else speed = 10 ;
		

		ball.getShape().setTranslateY(ball.getShape().getTranslateY()-speed);
		
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
