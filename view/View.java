package view;

import controller.Controller;
import game.Game;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class View implements InterfaceViewColorSwitch {
	
	Stage stage;
	Controller controller;
	
	int tailleX = 600;
	int tailleY = 1000;
	//Preferences
	
	public View(Controller ctrl, Stage primaryStage) {
		controller = ctrl ;
		stage = primaryStage ;
		initStage(stage);
		basicView();
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
		Scene scene = Menu.createInstance(600,1000);
		display(scene);	
	}

	public void viewGame(Game thisGame) {
		
		Group root = new Group();
		Scene scene = new Scene(root,tailleX,tailleY);
		
		ViewGameManagement.view(thisGame,scene);
		
		
		
		display(scene);
		
	}



	
}
