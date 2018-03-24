package model;

import model.modelItem.ModelItem;
import model.modelLaw.Universe;
import model.modelLaw.Universe.UniverseType;
import controller.InterfaceModelColorSwitch;
import model.game.Difficulty;
import model.game.Game;
import view.ball.Player;
import view.path.Path;

/**
 * This class represents the model in the MVC pattern
 * It contains ALL the data needed for the view
 */
public class Model implements InterfaceModelColorSwitch {
    /**
     *
     */
    private Game game;

    /**
     *
     */
    public Model() {

    }

    @Override
    public void startGame() {
        // TODO Auto-generated method stub

        //Lancer une partie
        this.game = new Game();

    }

    @Override
    public void gameOver() {
        // TODO Auto-generated method stub

        game.stop();


    }


    public Game getGame() {
        return game;
    }

    @Override
    public void startGame(Difficulty difficulty,UniverseType type) {
        this.game = new Game(difficulty,type);

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
