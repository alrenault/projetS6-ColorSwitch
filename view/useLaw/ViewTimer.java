package view.useLaw;

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
import game.Game;
import game.ball.Player;
import game.ball.BallPlayer;


public class ViewTimer {
	/**
	 *
	 */
	AnimationTimer timer;
	List<UseLaw> laws;
	Controller controller;
	
	public ViewTimer(BallPlayer ball, ViewPath path, Controller controller, Scene scene) {
		laws = new ArrayList<>();
		this.controller = controller;
		
		J j = new J();
		//laws.add(j);
		
		JtGravity gravity = new JtGravity(ball);
		laws.add(gravity);
		
		MoveBall mv = new MoveBall(ball);
		laws.add(mv);
		
		Jump jump = new Jump(ball,scene);
		laws.add(jump);
		
		FollowBall fb = new FollowBall(scene,ball);
		laws.add(fb);
		
		CollisionObstacle co = new CollisionObstacle(ball, path, controller); 
		CollisionItem ci = new CollisionItem(ball,path,controller,path.getjItems());
		
		laws.add(co);
		laws.add(ci);
		
		
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
				
				
			}
			
		};
	}
	
	public void play() {
		timer.start();
	}
	
	
	
	
	
	
	
	
	//public ViewTimer(Game game,ViewPath path,BallPlayer ball, Scene scene) {


	
	public void start() {
		timer.start();
	}


}
