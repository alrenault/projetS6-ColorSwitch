package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controller.Controller;
import game.path.items.BallColorSwitch;
import game.path.items.Item;
import game.path.obstacle.Obstacle;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import view.ViewPath;
import view.useLaw.CollisionObstacle;
import view.useLaw.J;
import view.useLaw.JtGravity;
import view.useLaw.UseLaw;
import game.Game;
import game.ball.Ball;
import game.ball.BallPlayer;


public class ViewTimer {
	/**
	 *
	 */
	AnimationTimer timer;
	List<UseLaw> laws;
	Controller controller;
	
	public ViewTimer(BallPlayer ball, ViewPath path, Controller controller, Group root) {
		laws = new ArrayList<>();
		this.controller = controller;
		
		J j = new J();
		//laws.add(j);
		
		JtGravity gravity = new JtGravity(ball);
		//laws.add(gravity);
		
		CollisionObstacle co = new CollisionObstacle(ball, path, controller); 
		laws.add(co);
		
		Circle circle = new Circle(300,500,50,Color.ALICEBLUE);
		root.getChildren().add(circle);
		
		timer = new AnimationTimer() {
			long startTime = System.currentTimeMillis();
			
			
			@Override
			public void handle(long now) {
				long currentTime = System.currentTimeMillis();
				long duree = currentTime - startTime;
				//System.out.println("Time : "+ duree + " ms");
				
				for(UseLaw j : laws) {
					j.apply();
				}
				
				
				circle.setTranslateY(circle.getTranslateY()+4);
				for(Shape ball : ball.getShapeList()) {
					Shape intersection = Shape.intersect(ball, circle);
					//System.out.println(intersection);
					
					if (!intersection.getBoundsInParent().isEmpty()) {
						System.out.println("AIE");
					}
				}
				
				
				//checkCollision();
			}
			
			private void checkCollision() {
				
				for(Shape ball : ball.getShapeList()) {
					
					for(Obstacle o : path.getObstacles()) {
						
						for(Shape shape : o.getShapeList()){
						
						Shape intersection = Shape.intersect(ball, shape);
						
							if (!intersection.getBoundsInParent().isEmpty()) {
								//System.out.println(shape.getFill());
								//System.out.println(ball.getFill());
								//game.getScore().increaseNOC();
								if(shape instanceof Arc && shape.getStroke() != ball.getFill()){
									System.out.println("Game Over check");
									//game.defeat();
								}
								
								if(!(shape instanceof Arc) &&shape.getFill() != ball.getFill()) {
									//game.defeat();
									System.out.println("Game Over check");
								}
							
							}
						}
					}
					
					Boolean touch = false;
					 for(Item i : path.getItems()){
						if(i instanceof BallColorSwitch){
							for(Shape shape : i.getShapeList()){
								Shape intersection = Shape.intersect(ball,shape);
								
								if (!intersection.getBoundsInParent().isEmpty()) {
									//System.out.println(shape.getFill().toString());
									//System.out.println(ball.getFill().toString());
									if(shape.getFill() != ball.getFill()) {
										Random r = new Random();
										//int size = ((BallColorSwitch) i).getColors_use().size();
										//Color c = ((BallColorSwitch) i).getColors_use().get(r.nextInt(size));
										path.removeItem(i);
										//ball.setColor(c);
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
					
						//game.getScore().ramasseItem(i);

					}	 
				}
				
				/*if(game.getBall().getY() >= scene.getHeight()){
					 game.defeat();
				 }
				System.err.println("Score :"+ game.getScore());*/

			}
		};
	}
	
	public void play() {
		timer.start();
	}
	
	
	
	
	
	
	
	
	//public ViewTimer(Game game,ViewPath path,BallPlayer ball, Scene scene) {


	/**
	 *
	 * @param game
	 * @param scene
	 */
	public ViewTimer(Game game,ViewPath path,BallPlayer ball, Scene scene) {
		timer = //apellé a chaque shape
		        new AnimationTimer() {

					@Override
					public void handle(long now) {
						checkCollision();
						//frame=score.getScore();
						double x = ball.getX();
						double y = ball.getY();
						
						
						//nFrame++;
						//System.out.println("X : " + x + " - Y : "+ y);
					}

					private void checkCollision() {
						
						for(Shape ball : ball.getShapeList()) {
							
							for(Obstacle o : path.getObstacles()) {
								
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
							 for(Item i : path.getItems()){
								if(i instanceof BallColorSwitch){
									for(Shape shape : i.getShapeList()){
										Shape intersection = Shape.intersect(ball,shape);
										
										if (!intersection.getBoundsInParent().isEmpty()) {
											System.out.println(shape.getFill().toString());
											System.out.println(ball.getFill().toString());
											if(shape.getFill() != ball.getFill()) {
												Random r = new Random();
												//int size = ((BallColorSwitch) i).getColors_use().size();
												//Color c = ((BallColorSwitch) i).getColors_use().get(r.nextInt(size));
												path.removeItem(i);
												//ball.setColor(c);
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
