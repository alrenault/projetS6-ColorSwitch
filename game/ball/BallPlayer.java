package game.ball;

import controller.Listeners;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPlayer extends Ball {
	
	private float size;
	private Color color;
	private Group shape;
	private Scene scene;
	
	public BallPlayer(float size, Color color, Scene scene){
		this.size = size;
		this.color = color;		
		this.scene = scene;
		this.shape = buildBall();
	}
	
	public Group buildBall(){
		Group ball = new Group();
		
		Circle player = new Circle(size,color);
		System.out.println(scene.getWidth()+" "+scene.getHeight());
		player.setCenterX(scene.getWidth()/2);
		player.setCenterY(scene.getHeight() - 5*size);
		ball.getChildren().add(player);
		
		//animation
		TranslateTransition tt1 = new TranslateTransition(Duration.seconds(4),ball);
		tt1.setByY(scene.getHeight()+size);
		//tt.setCycleCount(4);
		//tt1.setCycleCount((int)Double.POSITIVE_INFINITY);//mouvement a l'infini
		//tt1.setAutoReverse(true);
		//tt1.setInterpolator(Interpolator.LINEAR);
		Listeners l = new Listeners(scene);
		l.jump(ball);
		
		
		tt1.play();
		
		return ball;
		
	}
	
	public Group getShape() {
		return shape;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
