package view;

import game.Colorable;
import game.Difficulty;
import game.Game;
import game.path.Path;
import game.path.obstacle.Obstacle;
import game.path.shapes.Shapes;
import javafx.scene.Group;
import javafx.scene.Scene;

public class ViewGameManagement {
	
	static Group root;
	static Game game;

	public static void view(Game thisGame, Scene thisScene) {
		
        root = (Group) thisScene.getRoot();
        game = thisGame;
		
		
		Path path = game.getPath();
		
		Group jObstacles = buildObstacles(path);

        
        add(path.getPath());
        add(jObstacles);
        
        
        
        
        thisScene.setFill(Colorable.BLACK);
	}
	
	private static void add(Group group) {
		root.getChildren().add(group);
	}
	
	public static Group buildObstacles(Path path) {
		Group jObstacles = new Group();
		
		for(Obstacle obstacle : path.getObstacles()) {
			//obstacle -> group
			//ajouter à jObstacles
			
			
		}
		
		
		return jObstacles;
	}
}
