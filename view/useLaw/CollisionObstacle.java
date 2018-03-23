package view.useLaw;

import controller.Controller;
import view.game.ball.BallPlayer;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import view.ViewPath;

public class CollisionObstacle implements UseLaw {
	
	BallPlayer ball;
	ViewPath path;
	Controller controller;

	/**
	 *
	 * @param ball
	 * @param path
	 * @param controller
	 */
	public CollisionObstacle(BallPlayer ball, ViewPath path, Controller controller){
		this.ball = ball ;
		this.path = path ;
		this.controller = controller ;
	}

	@Override
	public void apply() {
		
		for(Shape b : ball.getShapeList()) {

		/*
			for(Obstacle o : path.getObstacles()) {

			}
		*/
			//System.out.println("path "+ path.getObstacles().size());
			for(Shape shape : path.getObstaclesShapes()) {
				
				Shape intersection = Shape.intersect(b, shape);
				//System.out.println("probleme ? "+intersection.getBoundsInParent().isEmpty());
				
				
				
				if (!intersection.getBoundsInParent().isEmpty()) {
					//System.out.println("Intersection !");
					
					if(shape instanceof Arc && shape.getStroke() != b.getFill()){
					//	System.out.println("Game Over 1");
						controller.gameOver();
					}
					
					if(!(shape instanceof Arc) &&shape.getFill() != b.getFill()) {
					//	System.out.println("Game Over 2");
						controller.gameOver();
					}
				
				}
			}
			
		}

	}
}
