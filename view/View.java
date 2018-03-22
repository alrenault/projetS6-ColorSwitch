package view;

import DB.Record;
import controller.Controller;
import game.Colorable;
import game.Game;
import game.Score;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.PerspectiveCamera;
import java.util.LinkedList;


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
	protected static final Integer tailleX = 600;
	/**
	 *
	 */
	protected static final Integer tailleY = 1000;
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
		Scene s = new Scene(ViewScores.GroupeScoreJoueurEnCours(new Score(14567,787,3)),tailleX,tailleY);
		s.setFill(Colorable.BLACK);
		display(s);
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


        display(ViewScores.GroupeScoresNoK());
	}
	@Override
	public void viewScores(LinkedList<Record> liste) {
		/*
		Scene scene = new Scene(ViewScores.GroupeScoreOk(liste),tailleX,tailleY);
        scene.setFill(Colorable.BLACK);

		display(scene);
		*/
		viewGameOver();
	}




}