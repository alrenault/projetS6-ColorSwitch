package view.useLaw;

import controller.Controller;
import game.ball.BallPlayer;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import view.ViewPath;

public class CollisionItem implements UseLaw {
	
	BallPlayer ball;
	ViewPath path;
	Controller controller;
	
	public CollisionItem(BallPlayer ball, ViewPath path, Controller controller){
		this.ball = ball ;
		this.path = path ;
		this.controller = controller ;
	}

	@Override
	public void apply() {
		for(Shape b : ball.getShapeList()) {
			for(Shape shape : path.getItemsShapes()) {
				Shape intersection = Shape.intersect(b, shape);
				
				if (!intersection.getBoundsInParent().isEmpty()) {
					if(shape instanceof Arc && shape.getStroke() != b.getFill()){
						controller.gameOver();
					}
					
					if(!(shape instanceof Arc) &&shape.getFill() != b.getFill()) {
						controller.gameOver();
					}
				
				}
			}
			
		}

	}
}