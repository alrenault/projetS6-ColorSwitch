package view;

import DB.Record;
import controller.Controller;
import view.game.Game;
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
    private Stage stage;
	/**
	 *
	 */
	static Controller controller;
	/**
	 * La largeur des fenètres
	 */
	static final Integer tailleX = 600;
	/**
	 *La hauteur des fenètres
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
        stage.setTitle("ColorSuitch");
        stage.getIcons().add(new Image("file:../view/color_icon.png"));
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> stage.close());
	}

	/**
	 * Affiche la Scene
	 * @param scene La scene à afficher
	 */
	private void display(Scene scene) {
        stage.setScene(scene);
        stage.show();
	}


	public void basicView() {
		viewMenu();
	}



	public void viewMenu() {
 
		Scene scene = Menu.createInstance(controller);
		display(scene);	
	}
	
	public void viewMenuLvl(){
		Scene scene = MenuLvl.createInstance(controller);
		display(scene);
	}


	public void viewGame(Game thisGame) {
		
		Group root = new Group();
		Scene scene = new Scene(root,tailleX,tailleY);
		scene.setCamera(new PerspectiveCamera());
		
		ViewGameManagement.view(thisGame,scene,controller);
		
		
		display(scene);
		
	}

	/*
	 *Génère l'affichage de fin de partie en cas de GameOver
	 */
	@Override
	public void viewGameOver() {



		display(ViewScores.viewEndScore(controller.getScore()));

	}

	/*
	 *Propose d'enregistrer le Score in DB
	 */
	@Override
	public void viewGameOverRecord() {
		display(ScenePseudo.stre(controller));
	}
	/*
	 *Accesseur de controller
	 * @return le Controller de jeu
	 */
	@Override
	public Controller getController() {
		return controller;
		
	}

	/*
	 * Affiche une fenetre d'érreur en cas de demande de score si pas de DB
	 */
	@Override
	public void viewScoreError() {


        display(ViewScores.viewError());
	}


	@Override
	public void viewScores(LinkedList<Record> liste) {

		display(ViewScores.GroupeScoreOk(liste));

	}




}