package view;

import java.io.File;

import controller.Controller;
import game.Colorable;
import game.Difficulty;
import game.Game;
import game.ball.Ball;
import game.ball.BallPlayer;
import game.path.Path;
import game.path.items.BuildItem;
import game.path.items.Item;
import game.path.obstacle.BuildObstacle;
import game.path.obstacle.Obstacle;
import game.path.shapes.Shapes;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import main.ViewTimer;
import model.modelObstacle.ModelObstacle;
import model.modelItem.ModelItem;
import model.modelBall.BuildBall;
import model.modelBall.ModelBall;

/**
 *
 */
public class ViewGameManagement {
	/**
	 *
	 */
	static Group root;
	/**
	 *
	 */
	static Game game;
	static ViewTimer timer;
	
	Controller controller;

	/**
	 *
	 * @param thisGame
	 * @param thisScene
	 */
	public static void view(Game thisGame, Scene thisScene, Controller controller) {
		
        root = (Group) thisScene.getRoot();
        game = thisGame;
		
		
		Path path = game.getPath();
		Ball ball = game.getBall();
		
		//BallPlayer qball = new BallPlayer(10, path.getColors().get(0), thisScene);
		BallPlayer ballplayer = BuildBall.build(ball,thisScene);
		
		
		Group jObstacles = buildObstacles(path);
		Group jItems = buildItems(path);
		Group jBall = ballplayer.getShape();
		
		

        
		add(jObstacles);
		add(jItems);
		add(jBall);
		
		ViewPath viewpath = new ViewPath(path);
		
		timer = new ViewTimer(ballplayer, viewpath, controller,jItems);
		timer.play();
		//ViewTimer timer = new ViewTimer(thisGame,viewpath,ballplayer,thisScene);
		        
        
		
		
        
        thisScene.setFill(Colorable.BLACK);
	}

	/**
	 * Methode d'ajout de Shape, Item ... dans root
	 * @param group L'item,Shape,... à ajouter
	 */
	private static void add(Group group) {
		root.getChildren().add(group);
	}


	/**
	 *
	 * @param path
	 * @return
	 */
	public static Group buildObstacles(Path path) {
		Group jObstacles = new Group();
				
		for(ModelObstacle mo : path.getObstacles()) {
			System.out.println(mo.getType());
			Obstacle obstacle = BuildObstacle.build(mo);
			add(obstacle.getObstacle());
		}
		
		return jObstacles;
	}

	/**
	 *
	 * @param path
	 * @return
	 */
	public static Group buildItems(Path path) {
		Group jItems = new Group();
	
		for(ModelItem mi : path.getItem()) {
			System.out.println(mi.getType());
			Item item = BuildItem.build(mi);
			add(item.getItem());
		}
		
		return jItems;
	}
}
