package view;

import DB.Record;
import controller.Controller;
import view.game.Game;

import java.util.LinkedList;

/**
 * Interface représentant la vue (MVC) de ColorSwitch
 */
public interface InterfaceViewColorSwitch {
	
    /**
     * Affiche la vue par défaut
     */
    void basicView();

    /**
     * Affiche le menu principal
     */
    void viewMenu();

    /**
     * Affiche le menu des niveaux
     */
    void viewMenuLvl();

    /**
     * Affiche la page de jeu
     * @param thisGame Le jeu a afficher
     */
    void viewGame(Game thisGame);

    /**
     * Génère l'affichage de fin de partie en cas de GameOver
     */
    void viewGameOver();

    /**
     * Affiche la page de fin de partie
     */
    void viewGameEnd();

    /**
     * Propose d'enregistrer le Score in DB
     */
    void viewGameOverRecord();

    /**
     * Accesseur de controller
     *
     * @return le Controller de jeu
     */
    Controller getController();

    /**
     * Mutateur de la référence au controlleur
     * @param controller La nouvelle référence au controlleur
     */
    void setController(Controller controller);

    /**
     * Affiche une fenetre d'érreur en cas de demande de score si pas de DB
     */
    void viewScoreError();

    /**
     * Génère une vue contenant les scores de liste
     *
     * @param liste La liste des records à afficher
     */
    void viewScores(LinkedList<Record> liste);

    /**
     * Affiche la page de modification des paramètres
     */
    void viewParams();
}
