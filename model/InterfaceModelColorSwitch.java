package model;

import model.modelItem.ModelItem;
import view.game.Difficulty;
import view.game.Game;
import view.game.ball.Player;
import view.game.law.Universe;
import view.game.path.Path;

/**
 * Interface représentant le modèle de ColorSwitch
 */
public interface InterfaceModelColorSwitch {
	
    /**
     * Crée un nouveau jeu infini RANDOM
     */
    void startGame();

    /**
     * Crée un jeu infini avec comme difficulté celle passé en argument
     * @param difficulty La difficulté du jeu
     */
    void startGame(Difficulty difficulty);

    /**
     * Crée un jeu en mode HellCircle
     */
    void startHellCircle();

    /**
     * Crée un niveau d'un certain nombre d'obstacle
     * @param nbr_obs Le nombre d'obstacle du niveau
     */
    void startLvl(int nbr_obs);

    /**
     * Lance le game over du jeu
     */
    void gameOver();


    /**
     * Incrémente le nombre d'Item ramassé
     * @param mi Le modèle de l'Item à ramasser
     */
    void incItem(ModelItem mi);


    /**
     * Accesseur du jeu
     * @return Le jeu
     */
    Game getGame();


}
