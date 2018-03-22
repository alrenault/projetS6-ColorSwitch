package controller;

import DB.GestionDB;
import game.Difficulty;
import game.Game;
import game.Score;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import main.Main;
import model.InterfaceModelColorSwitch;
import model.modelItem.ModelItem;
import view.InterfaceViewColorSwitch;
import view.View;

public class Controller {
	/**
	 *
	 */
	InterfaceModelColorSwitch model;
	/**
	 *
	 */
	InterfaceViewColorSwitch view;
	/**
	 *
	 */
	GestionDB connectionDB;

	/**
	 *
	 * @param model
	 * @param view
	 */
	public Controller(InterfaceModelColorSwitch model, InterfaceViewColorSwitch view) {
		this.model = model;
		this.view = view;
		view.setController(this);
		connectionDB=new GestionDB();
		/*
		try {
			connectionDB=new GestionDB();
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Connexion with database failed.");
		}*/
		

	}

	/**
	 *
	 */
	public void init() {
		System.out.println("Initialisation");
		view.basicView();
	}


	/**
	 *
	 */
	public void startMenu() {
		System.out.println("Menu");
		view.viewMenu();
	}

	/**
	 *
	 */
	public void startGame() {
		System.out.println("New Game !");
		model.startGame();
		view.viewGame(model.getGame());
	}

	/**
	 * Enregistre le score
	 * @param nom nom du joueur
	 * @param score Score du joueur
	 */
	public void recordScore(String nom, Score score){
//
		connectionDB.record(nom,score);
	}

	/**
	 *
	 */
	public void gameOver(){
		System.out.println("Game Over !");
		model.gameOver();
		view.viewGameOver();
	}

	/**
	 *
	 * @return
	 */
	public Score getScore() {
		return model.getGame().getScore();
	}

	public void showScoresMenu(){
		boolean testCo=connectionDB.testConnexionDB();
		if (testCo){

			view.viewScores(connectionDB.getLastRecords(15*2));
		}else{
			view.viewScoreNoCo();

		}

	}
	/**
	 *
	 * @param difficulty
	 */
	public void startGame(Difficulty difficulty) {
		System.out.println("J");
		model.startGame(difficulty);
		view.viewGame(model.getGame());
	}
	
	public void incItem(ModelItem mi){
		model.incItem(mi);
	}
}
