package controller;

import DB.GestionDB;
import game.Game;
import game.Score;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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
		connectionDB=new GestionDB();

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
	public void scoring(String nom, Score score){
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
}
