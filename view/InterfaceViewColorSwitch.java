package view;

import controller.Controller;
import game.Game;

/**
 *
 */
public interface InterfaceViewColorSwitch {
	/**
	 *
	 */
	public void basicView();

	/**
	 *
	 */
	public void viewMenu() ;

	/**
	 *
	 * @param thisGame
	 */
	public void viewGame(Game thisGame);

	/**
	 *
	 */
    void viewGameOver();

	/**
	 *
	 * @return
	 */
	public Controller getController();

	/**
	 *
	 * @param controller
	 */
	public void setController(Controller controller);
}
