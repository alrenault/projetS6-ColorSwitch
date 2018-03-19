package model;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


/**
 * This class represents the menu before playing a game
 */
public class Menu {
	/**
	 *
	 * @return
	 */
	public Scene createInstance(){
		HBox root = new HBox(10);
		Button newGameEasy = new Button("Nouvelle partie (facile)");
		Button newGameMedium = new Button("Nouvelle partie (moyen)");
		Button newGameHard = new Button("Nouvelle partie (difficile)");
		
		root.getChildren().add(newGameEasy);
		root.getChildren().add(newGameMedium);
		root.getChildren().add(newGameHard);
		
		root.setLayoutY(500);
		
		Scene scene = new Scene(root, 600, 1000);
		
		return scene;
		
	}

	

}
