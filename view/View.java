package view;

import DB.Record;
import controller.Controller;
import view.game.Game;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.PerspectiveCamera;
import view.game.Score;

import java.util.LinkedList;


/**
 *
 */
public class View implements InterfaceViewColorSwitch {
	/**
	 *
	 */
    private Stage stage;
	/**
	 *
	 */
	static Controller controller;
	/**
	 *
	 */
	static final Integer tailleX = 600;
	/**
	 *
	 */
	static final Integer tailleY = 1000;
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
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> stage.close());
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
 
		Scene scene = Menu.createInstance(controller);
		display(scene);	
	}
	
	public void viewMenuLvl(){
		Scene scene = MenuLvl.createInstance(controller);
		display(scene);
	}

	/**
	 *
	 * @param thisGame
	 */
	public void viewGame(Game thisGame) {
		
		Group root = new Group();
		Scene scene = new Scene(root,tailleX,tailleY);
		scene.setCamera(new PerspectiveCamera());
		
		ViewGameManagement.view(thisGame,scene,controller);
		
		
		display(scene);
		
	}

	/**
	 *
	 */
	@Override
	public void viewGameOver() {
		/*
		Scene form =  ScenePseudo.stre( controller);
		display(form);
		*/

		//TODO ajouter bouton de ragequit(vers menu) et de view form

		//display(ViewScores.viewEndScore(controller.getScore()));

		display(ViewScores.viewEndScore(new Score(67,90,90)));
	}

	@Override
	public void viewGameOverSuite() {
		display(ScenePseudo.stre(controller));
	}
	/**
	 *
	 * @return
	 */
	@Override
	public Controller getController() {
		return controller;
		
	}

//TODO ajouter de quoi retourner au menu
	@Override
	public void viewScoreNoCo() {


        display(ViewScores.viewError());
	}
	@Override
	public void viewScores(LinkedList<Record> liste) {

//		display(ViewScores.GroupeScoreOk(liste));

		viewGameOver();
	}




}