package game.ball;

import java.util.Random;

import controller.Listeners;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class BallColorSwitch extends Ball {

	private double size;
	//private Color color;
	private Group shape;
	private Scene scene;
	
	public BallColorSwitch(double size/*, Color color*/, Scene scene){
		this.size = size;
		//this.color = color;		
		this.scene = scene;
		this.shape = buildBall();
	}
	
	public Group buildBall(){
		Group ball = new Group();
		
		double x = scene.getWidth()/2;
		double y = scene.getHeight()/2;
		
		int angle =90;
		
		ArcType type =ArcType.ROUND;
		
		

		for (int i = 0; i <= 4; i++) {
			Arc arc_1 = new Arc(x, y, size, size, i*angle, angle);
			arc_1.setType(type);
			arc_1.setFill(coloRand());
			ball.getChildren().add(arc_1);
		}
		
		
		//animation
		/*TranslateTransition tt1 = new TranslateTransition(Duration.seconds(4),ball);
		tt1.setByY(scene.getHeight()+size);*/
		//tt.setCycleCount(4);
		//tt1.setCycleCount((int)Double.POSITIVE_INFINITY);//mouvement a l'infini
		//tt1.setAutoReverse(true);
		//tt1.setInterpolator(Interpolator.LINEAR);
		
		
		//tt1.play();
		
		return ball;
		
	}
	
	public Group getShape() {
		return shape;
	} 
	
	public Color coloRand() {
		Random r =new Random();
		return new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1);
	}
}
