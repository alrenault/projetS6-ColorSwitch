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

	/**
	 *
	 */
	void viewMenuLvl();

	/**
	 *
	 * @param thisGame
	 */
	void viewGame(Game thisGame);

	/**
	 *Génère l'affichage de fin de partie en cas de GameOver
	 */
    void viewGameOver();
	/**
	 *Propose d'enregistrer le Score in DB
	 */
	void viewGameOverRecord();

	/**
	 *Accesseur de controller
	 * @return le Controller de jeu
	 */
	Controller getController();

	/**
	 * Affiche une fenetre d'érreur en cas de demande de score si pas de DB
	 */
	void viewScoreError();

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
