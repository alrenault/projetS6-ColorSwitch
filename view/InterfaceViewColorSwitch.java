package view;

import controller.Controller;
import game.Game;

public interface InterfaceViewColorSwitch {

	public void basicView();
	
	public void viewMenu() ;

	public void viewGame(Game thisGame);

    void viewGameOver();

	public Controller getController();

	public void setController(Controller controller);
}
