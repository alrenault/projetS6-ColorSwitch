package controller;

import game.Game;
import model.InterfaceColorSwitch;
import view.InterfaceViewJavaFX;
import view.View;

public class Controller {
	
	InterfaceColorSwitch model;
	InterfaceViewJavaFX view;
	
	
	public Controller(InterfaceColorSwitch model, InterfaceViewJavaFX view) {
		this.model = model;
		this.view = view;
	}


	public void init() {
		view.basicView();
	}

	

}
