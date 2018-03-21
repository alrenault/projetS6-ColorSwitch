package view.useLaw;

import game.ball.BallPlayer;
import javafx.scene.Scene;

public class Jump implements UseLaw {

	BallPlayer ball;
	Scene scene;
	
	public Jump(BallPlayer ball,Scene scene) {
		this.ball = ball ; 
		this.scene = scene;
	}
	
	@Override
	public void apply() {
		scene.setOnKeyPressed(event -> {
			System.out.println(event.getCode());
			//ball.getShape().setTranslateX(i-scene.getWidth()/2);
		});

	}

}
