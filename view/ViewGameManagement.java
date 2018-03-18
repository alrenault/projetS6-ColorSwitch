package view;

import game.Colorable;
import game.Difficulty;
import game.Game;
import game.path.Path;
import game.path.obstacle.BuildObstacle;
import game.path.obstacle.Obstacle;
import game.path.shapes.Shapes;
import javafx.scene.Group;
import javafx.scene.Scene;
import model.modelObstacle.ModelObstacle;

public class ViewGameManagement {
	
	static Group root;
	static Game game;

	public static void view(Game thisGame, Scene thisScene) {
		
        root = (Group) thisScene.getRoot();
        game = thisGame;
		
		
		Path path = game.getPath();
		
		Group jObstacles = buildObstacles(path);

        
		add(jObstacles);
        
        
        
        
        thisScene.setFill(Colorable.BLACK);
	}
	
	private static void add(Group group) {
		root.getChildren().add(group);
	}
	
	public static Group buildObstacles(Path path) {
		Group jObstacles = new Group();
		
		
		for(ModelObstacle mo : path.getObstacles()) {
			System.out.println(mo.getType());
			Obstacle obstacle = BuildObstacle.build(mo);
			add(obstacle.getModel_obstacle().getObstacle());
		}
		
		
			//obstacle -> group
			//ajouter à jObstacles
			
			
		//}
		
		
		return jObstacles;
	}
}
