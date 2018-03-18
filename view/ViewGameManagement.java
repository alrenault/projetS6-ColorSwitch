package view;

import game.Colorable;
import game.Difficulty;
import game.Game;
import game.path.Path;
import game.path.items.BuildItem;
import game.path.items.Item;
import game.path.obstacle.BuildObstacle;
import game.path.obstacle.Obstacle;
import game.path.shapes.Shapes;
import javafx.scene.Group;
import javafx.scene.Scene;
import model.modelObstacle.ModelObstacle;
import model.modelItem.ModelItem;


public class ViewGameManagement {
	
	static Group root;
	static Game game;

	public static void view(Game thisGame, Scene thisScene) {
		
        root = (Group) thisScene.getRoot();
        game = thisGame;
		
		
		Path path = game.getPath();
		
		Group jObstacles = buildObstacles(path);
		Group jItems = buildItems(path);

        
		add(jObstacles);
		add(jItems);
        
        
        
        
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
			add(obstacle.getObstacle());
		}
		
		
			//obstacle -> group
			//ajouter à jObstacles
			
			
		//}
		
		
		return jObstacles;
	}
	
	public static Group buildItems(Path path) {
		Group jItems = new Group();
	
		
		for(ModelItem mi : path.getItem()) {
			System.out.println(mi.getType());
			Item item = BuildItem.build(mi);
			add(item.getItem());
		}
		
		
			//obstacle -> group
			//ajouter à jObstacles
			
			
		//}
		
		
		return jItems;
	}
}
