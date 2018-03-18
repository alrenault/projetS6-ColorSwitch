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
import view.InterfaceViewColorSwitch;
import view.View;

public class Controller {
	
	InterfaceModelColorSwitch model;
	InterfaceViewColorSwitch view;
	GestionDB connectionDB;
	
	public Controller(InterfaceModelColorSwitch model, InterfaceViewColorSwitch view) {
		this.model = model;
		this.view = view;
		view.setController(this);
		
		/*
		try {
			connectionDB=new GestionDB();
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Connexion with database failed.");
		}*/
		

	}


	public void init() {
		view.basicView();
	}
	
	
	
	public void startMenu() {
		view.viewMenu();
	}
	
	public void startGame() {
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
	
	public void gameOver(){
		model.gameOver();
		view.viewGameOver();
	}

	public Score getScore() {
		return model.getGame().getScore();
	}


	public void startGame(Difficulty difficulty) {
		System.out.println("J");
		model.startGame(difficulty);
		view.viewGame(model.getGame());
	}
}
