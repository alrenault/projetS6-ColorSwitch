package view;

import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Menu {
	
	public static Scene createInstance(double width, double height){
		
		int buttonWidth = 200;
		int buttonHeight = 50;
		
		VBox root = new VBox(100);
		root.setAlignment(Pos.CENTER);
		Button goGameEasy = new Button("Nouvelle partie (facile)");
		Button goGameNormal = new Button("Nouvelle partie (normale)");
		Button goGameHard = new Button("Nouvelle partie (difficile)");
		Button goScore = new Button("Score");
		
		root.getChildren().add(goGameEasy);
		root.getChildren().add(goGameNormal);
		root.getChildren().add(goGameHard);
		root.getChildren().add(goScore);
		
		goGameEasy.setMinHeight(buttonHeight);
		goGameNormal.setMinHeight(buttonHeight);
		goGameHard.setMinHeight(buttonHeight);
		goScore.setMinHeight(buttonHeight);

		
		goGameEasy.setMinWidth(buttonWidth);
		goGameNormal.setMinWidth(buttonWidth);
		goGameHard.setMinWidth(buttonWidth);
		goScore.setMinWidth(buttonWidth);

		
		
		Scene sc = new Scene(root, width, height);
        root.setStyle("-fx-background-color: #393939");

		
		return sc;
	}

}
