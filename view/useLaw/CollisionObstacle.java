package view.useLaw;

import controller.Controller;
import view.game.ball.BallPlayer;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import view.ViewPath;

public class CollisionObstacle implements UseLaw {
	
	private BallPlayer ball;
	private ViewPath path;
	private Controller controller;

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
			// ln("path "+ path.getObstacles().size());
			for(Shape shape : path.getObstaclesShapes()) {
				
				Shape intersection = Shape.intersect(b, shape);
				// ln("probleme ? "+intersection.getBoundsInParent().isEmpty());
				
				
				
				if (!intersection.getBoundsInParent().isEmpty()) {
					// ln("Intersection !");
					
					if(shape instanceof Arc && shape.getStroke() != b.getFill()){
					//	 ln("Game Over 1");
						controller.gameOver();
					}
					
					if(!(shape instanceof Arc) &&shape.getFill() != b.getFill()) {
					//	 ln("Game Over 2");
						controller.gameOver();
					}
				
				}
			}
			
		}

	}
}
