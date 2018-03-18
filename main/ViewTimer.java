package main;

import java.util.Random;

import game.path.items.BallColorSwitch;
import game.path.items.Item;
import game.path.obstacle.Obstacle;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import game.Game;


public class ViewTimer {
	/**
	 *
	 */
	AnimationTimer timer;

	/**
	 *
	 * @param game
	 * @param scene
	 */
	public ViewTimer(Game game, Scene scene) {
		timer = //apellé a chaque shape
		        new AnimationTimer() {

					@Override
					public void handle(long now) {
						checkCollision();
						//frame=score.getScore();
						double x = game.getBall().getX();
						double y = game.getBall().getY();
						
						
						//nFrame++;
						//System.out.println("X : " + x + " - Y : "+ y);
					}

					private void checkCollision() {
						
						for(Shape ball : game.getBall().getShapeList()) {
							
							for(Obstacle o : game.getPath().getObstacles()) {
								
								for(Shape shape : o.getShapeList()){
								
								Shape intersection = Shape.intersect(ball, shape);
								
									if (!intersection.getBoundsInParent().isEmpty()) {
										System.out.println(shape.getFill());
										System.out.println(ball.getFill());
										game.getScore().increaseNOC();
										if(shape instanceof Arc && shape.getStroke() != ball.getFill()){
											game.defeat();
										}
										
										if(!(shape instanceof Arc) &&shape.getFill() != ball.getFill()) {
											game.defeat();
										}
									
									}
								}
							}
							
							Boolean touch = false;
							 for(Item i : game.getPath().getItem()){
								if(i instanceof BallColorSwitch){
									for(Shape shape : i.getShapeList()){
										Shape intersection = Shape.intersect(ball,shape);
										
										if (!intersection.getBoundsInParent().isEmpty()) {
											System.out.println(shape.getFill().toString());
											System.out.println(ball.getFill().toString());
											if(shape.getFill() != ball.getFill()) {
												Random r = new Random();
												int size = ((BallColorSwitch) i).getColors_use().size();
												Color c = ((BallColorSwitch) i).getColors_use().get(r.nextInt(size));
												game.getPath().remove(i);
												game.getBall().setColor(c);
												touch = true;
												break;
											}
											
										}
									}
									if(touch){
										touch = false;
										break;
									}
								}
							
								game.getScore().ramasseItem(i);

							}	 
						}
						
						if(game.getBall().getY() >= scene.getHeight()){
							 game.defeat();
						 }
						System.err.println("Score :"+ game.getScore());

					}
		        	
		        }
		        ;
	}
	
	public void start() {
		timer.start();
	}


}
