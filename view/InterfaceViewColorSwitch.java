package view;

import DB.Record;
import controller.Controller;
import view.game.Game;

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
	
	void viewMenuLvl();

	/**
	 *
	 * @param thisGame
	 */
	void viewGame(Game thisGame);

	/**
	 *
	 */
    void viewGameOver();

	void viewGameOverSuite();

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
