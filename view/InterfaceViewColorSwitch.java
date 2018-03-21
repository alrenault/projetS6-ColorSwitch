package view;

import DB.Record;
import controller.Controller;
import game.Game;

import java.util.LinkedList;

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
	 * Génère une vue d'érreur
	 */
	void viewScoreNoCo();

	/**
	 *
	 * @param controller
	 */
	public void setController(Controller controller);

	/**
	 * Génère une vue contenant les scores de liste
	 * @param liste La liste des records à afficher
	 */
	void viewScores(LinkedList<Record> liste);
}
