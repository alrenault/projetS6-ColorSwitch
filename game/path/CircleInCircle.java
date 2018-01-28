package game.path;

import javafx.scene.Group;

public class CircleInCircle extends Obstacle {
	Group obstacle;

	public CircleInCircle(int x, int y){
		super(x,y);
		obstacle = buildObstacle();
	}
	
	private Group buildObstacle(){
		Group circleInCircle = new Group();

		Circle cer1 =new Circle(280, 150, 100, 15 ,4,true,false,1);
		Circle cer2 =new Circle(280, 150, 85, 15 ,4,false,false,2);

		circleInCircle.getChildren().add(cer1.getShape());
		circleInCircle.getChildren().add(cer2.getShape());
		
		return circleInCircle;

	}
	
	public Group getObstacle(){
		return obstacle;
	}
}
