package view;

import controller.Controller;
import game.Game;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.Main;

/**
 *
 */
public class View implements InterfaceViewColorSwitch {
	/**
	 *
	 */
	Stage stage;
	/**
	 *
	 */
	Controller controller;
	/**
	 *
	 */
	int tailleX = 600;
	/**
	 *
	 */
	int tailleY = 1000;
	//Preferences

	/**
	 *
	 * @param primaryStage
	 */
	public View(Stage primaryStage) {
		stage = primaryStage ;
		initStage(stage);
		//basicView();
		
	}

	/**
	 *
	 * @param c
	 */
	public void setController(Controller c) {
		controller = c;
	}


	/**
	 *
	 * @param stage
	 */
	private void initStage(Stage stage) {
		//Set Stage
        stage.setTitle("ColorSuitch");
        stage.getIcons().add(new Image("file:../view/color_icon.png"));
        stage.setFullScreen(1==0);
        stage.setResizable(false);
	}

	/**
	 *
	 * @param scene
	 */
	private void display(Scene scene) {
        stage.setScene(scene);
        stage.show();
	}


	/**
	 *
	 */
	public void basicView() {
		viewMenu();
	}


	/**
	 *
	 */
	public void viewMenu() {
 
		Scene scene = Menu.createInstance(controller,600,1000);
		display(scene);	
	}

	/**
	 *
	 * @param thisGame
	 */
	public void viewGame(Game thisGame) {
		
		Group root = new Group();
		Scene scene = new Scene(root,tailleX,tailleY);
		
		ViewGameManagement.view(thisGame,scene,controller);
		
		
		display(scene);
		
	}

	/**
	 *
	 */
	@Override
	public void viewGameOver() {
		stage.close();
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


	/**
	 *
	 * @return
	 */
	@Override
	public Controller getController() {
		return controller;
		
	}

}
