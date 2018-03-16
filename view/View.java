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
		//basicView();
	}

	public View() {
		this(new Stage());
	}
	
	

	private void initStage(Stage stage) {
		//Set Stage
        stage.setTitle("ColorSuitch");
        stage.getIcons().add(new Image("file:../view/color_icon.png"));
        stage.setFullScreen(1==0);
        stage.setResizable(false);
	}
	
	private void display(Scene scene) {
        stage.setScene(scene);
        stage.show();
	}
	
	
	
	public void basicView() {
		viewMenu();
	}
	
	
	
	
	
	public void viewMenu() {
		Scene sc = Menu.createInstance(600,1000);
		display(sc);	
	}

	public void viewGame(Game thisGame) {
		
		Group root = new Group();
		Scene scene = new Scene(root,tailleX,tailleY);
		
		ViewGameManagement.view(thisGame,scene);
		
		
		
		display(scene);
		
	}



	
}
