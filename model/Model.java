package model;

import controller.InterfaceModelColorSwitch;
import model.game.Difficulty;
import model.game.Game;
import model.modelItem.ModelItem;
import model.modelLaw.Universe.UniverseType;

/**
 * Cette classe représente le modèle du MVC
 * Il contient toutes les données pour la vue
 */
public class Model implements InterfaceModelColorSwitch {

    /**
     * Le jeu
     */
    private Game game;

    @Override
    public void startGame() {
        //Lancer une partie
        this.game = new Game();

    }

    @Override
    public void gameOver() {
        // TODO Auto-generated method stub

        //Perdre la partie
        //appel au controleur et passe le score


    }


    public Game getGame() {
        return game;
    }

    @Override
    public void startGame(Difficulty difficulty, UniverseType type) {
        this.game = new Game(difficulty, type);

    }

    public void startLvl(int nbr_obs) {
        this.game = new Game(nbr_obs);
    }

    public void startHellCircle() {
        this.game = new Game();
    }

    public void circleHell() {

    }

    public void incItem(ModelItem mi) {

        game.getScore().ramasseItem(mi);
    }

}
