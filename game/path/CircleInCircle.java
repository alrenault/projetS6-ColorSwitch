package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;


public class CircleInCircle extends Obstacle {

	public CircleInCircle(int x, int y,Color[] colors){
		super(x,y, colors);
		obstacle = buildObstacle();
	}
	
	private Group buildObstacle(){
		Group circleInCircle = new Group();

		Circle cer1 =new Circle(280, 150, 100, 15 ,4,true,false,1,colors);
		Circle cer2 =new Circle(280, 150, 85, 15 ,4,false,false,2,colors);

		circleInCircle.getChildren().add(cer1.getShape());
		circleInCircle.getChildren().add(cer2.getShape());
		
		return circleInCircle;

	}
	
	public Group getObstacle(){
		return obstacle;
	}
}
