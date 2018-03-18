package view;

import controller.Controller;
import game.Game;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.Main;

public class View implements InterfaceViewColorSwitch {
	
	Stage stage;
	Controller controller;
	
	int tailleX = 600;
	int tailleY = 1000;
	//Preferences
	
	public View(Stage primaryStage) {
		stage = primaryStage ;
		initStage(stage);
		//basicView();
		
	}
	
	public void setController(Controller c) {
		controller = c;
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
 
		Scene scene = Menu.createInstance(controller,600,1000);
		display(scene);	
	}

	public void viewGame(Game thisGame) {
		
		Group root = new Group();
		Scene scene = new Scene(root,tailleX,tailleY);
		
		ViewGameManagement.view(thisGame,scene);
		
		
		display(scene);
		
	}

	@Override
	public void viewGameOver() {
		Scene form = null;
		try {
			form = ScenePseudo.class.newInstance().stre( controller);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		display(form);
	}



	@Override
	public Controller getController() {
		return controller;
		
	}

}
