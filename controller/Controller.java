package controller;

import game.Game;
import model.InterfaceColorSwitch;
import view.InterfaceViewJavaFX;

public class Controller {
	
	InterfaceColorSwitch model;
	InterfaceViewJavaFX view;
	
	
	public Controller(InterfaceColorSwitch model, InterfaceViewJavaFX view) {
		this.model = model;
		this.view = view;
	}

	

}
