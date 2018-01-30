package game.ball;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

import java.util.Random;

public class BallColorSwitch extends Ball {

	private double size;
	private Group shape;
	private Scene scene;
	
	public BallColorSwitch(double size, Scene scene){
		this.size = size;
		
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
		
		
		return ball;
		
	}
	
	public Group getShape() {
		return shape;
	} 
	
	public Color coloRand() {
		Random r =new Random();
		return new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1);
	}

	@Override
	public void applyGravity() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
	}
}
