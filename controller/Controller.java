package controller;

import DB.GestionDB;
import game.Game;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;
import model.InterfaceModelColorSwitch;
import view.InterfaceViewColorSwitch;
import view.View;

public class Controller {

	InterfaceModelColorSwitch model;
	InterfaceViewColorSwitch view;
	private GestionDB connectionDB;

	public Controller(InterfaceModelColorSwitch model, InterfaceViewColorSwitch view) {
		this.model = model;
		this.view = view;
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

	public GestionDB getConnectionDB() {
		return connectionDB;
	}


}
