package controller;

import model.game.Difficulty;
import model.game.Game;
import model.modelItem.ModelItem;
import model.modelLaw.Universe.UniverseType;

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
     *
     * @param difficulty La difficulté du jeu
     * @param type       Le type d'univers de lois qu'on utilise pour la partie
     */
    void startGame(Difficulty difficulty, UniverseType type);


    /**
     * Crée un jeu en mode HellCircle
     */
    void startHellCircle();

    /**
     * Crée un niveau d'un certain nombre d'obstacle
     *
     * @param nbr_obs Le nombre d'obstacle du niveau
     */
    void startLvl(int nbr_obs);

    /**
     * Lance le game over du jeu
     */
    void gameOver();


    /**
     * Incrémente le nombre d'Item ramassé
     *
     * @param mi Le modèle de l'Item à ramasser
     */
    void incItem(ModelItem mi);


    /**
     * Accesseur du jeu
     *
     * @return Le jeu
     */
    Game getGame();


}
