package view;

import java.io.File;

import controller.Controller;
import view.game.Colorable;
import view.game.Difficulty;
import view.game.Game;
import view.game.ball.Player;
import view.game.ball.BallPlayer;
import view.game.path.Path;
import view.game.path.items.BuildItem;
import view.game.path.items.Item;
import view.game.path.obstacle.BuildObstacle;
import view.game.path.obstacle.Obstacle;
import view.game.path.shapes.Shapes;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.modelObstacle.ModelObstacle;
import view.useLaw.ViewTimer;
import model.modelItem.ModelItem;
import model.modelBall.BuildBall;
import model.modelBall.Ball;
import javafx.scene.control.Label;
import javafx.scene.Node;

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
		
		
		Group jBall = ballplayer.getShape();
		
		add(jBall);
		
		
		Label score = new Label("Oui");
		score.setTextFill(Color.AQUAMARINE);
		root.getChildren().add(score);
		
		
		
		ViewPath viewpath = new ViewPath(path);
		
		if(viewpath.getFinishLine() != null){
			root.getChildren().add(viewpath.getFinishLine());
		}
		
		timer = new ViewTimer(ballplayer, viewpath, controller, thisScene);
		timer.play();
		//ViewTimer timer = new ViewTimer(thisGame,viewpath,ballplayer,thisScene);
		        
        
		
		
        
        thisScene.setFill(Colorable.BLACK);
	}

	/**
	 * Methode d'ajout de Shape, Item ... dans root
	 * @param group L'item,Shape,... à ajouter
	 */
	public static void add(Group group) {
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
