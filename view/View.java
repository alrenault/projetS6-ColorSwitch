package view;

import game.Game;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class View implements InterfaceViewJavaFX {
	
	Stage stage;
	int tailleX = 600;
	int tailleY = 1000;
	//Preferences
	
	public View(Stage primaryStage) {
		stage = primaryStage;
		initStage(stage);
		viewMenu();
	}

	public View() {
		this(new Stage());
	}
	
	

	public void initStage(Stage stage) {
		//Set Stage
        stage.setTitle("ColorSuitch");
        stage.getIcons().add(new Image("file:../view/color_icon.png"));
        stage.setFullScreen(1==0);
	}
	
	private void viewMenu() {
		// TODO Auto-generated method stub
		
	}

	public void viewGame(Game thisGame) {
		
		Group root = new Group();
		Scene scene = new Scene(root);
		
		ViewGameManagement.view(thisGame,scene);
		
	}
	
}
