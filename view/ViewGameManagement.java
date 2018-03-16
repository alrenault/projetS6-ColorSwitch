package view;

import game.Colorable;
import game.Difficulty;
import game.Game;
import game.path.Path;
import javafx.scene.Group;
import javafx.scene.Scene;

public class ViewGameManagement {
	
	static Group root;

	public static void view(Game thisGame, Scene thisScene) {
		
        root = (Group) thisScene.getRoot();
		
		
		Path p = thisGame.getPath();

        
        add(p.getPath());
        
        
        
        
        thisScene.setFill(Colorable.BLACK);
	}
	
	private static void add(Group group) {
		root.getChildren().add(group);
	}
}
