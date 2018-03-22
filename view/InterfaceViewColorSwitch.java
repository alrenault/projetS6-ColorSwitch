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
	void basicView();

	/**
	 *
	 */
	void viewMenu() ;

	/**
	 *
	 * @param thisGame
	 */
	void viewGame(Game thisGame);

	/**
	 *
	 */
    void viewGameOver();

	/**
	 *
	 * @return
	 */
	Controller getController();

	/**
	 * Génère une vue d'érreur
	 */
	void viewScoreNoCo();

	/**
	 *
	 * @param controller
	 */
	void setController(Controller controller);

	/**
	 * Génère une vue contenant les scores de liste
	 * @param liste La liste des records à afficher
	 */
	void viewScores(LinkedList<Record> liste);
}
