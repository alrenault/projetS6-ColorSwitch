package view.useLaw;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import view.ViewPath;
import view.game.ball.BallPlayer;


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
		LockBall lb = new LockBall(scene,ball);
		//laws.add(lb);
		laws.add(fb);
		
		Race race = new Race(ball,scene);
		//laws.add(race);
		
		CollisionObstacle co = new CollisionObstacle(ball, path, controller); 
		CollisionItem ci = new CollisionItem(ball,path,controller,path.getjItems());
		
		Tourni tourni = new Tourni(scene);
		//laws.add(tourni);
		
		//laws.add(co);
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
	
	
	
	
	
	
	
	
	//public ViewTimer(Game view.game,ViewPath path,BallPlayer ball, Scene scene) {


	
	public void start() {
		timer.start();
	}


}
