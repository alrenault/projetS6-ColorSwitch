package controller;

import DB.GestionDB;
import model.InterfaceModelColorSwitch;
import model.modelItem.ModelItem;
import view.InterfaceViewColorSwitch;
import view.game.Difficulty;
import view.game.Score;

public class Controller {
    /**
     *
     */
    private InterfaceModelColorSwitch model;
    /**
     *
     */
    private InterfaceViewColorSwitch view;
    /**
     *
     */
    private GestionDB connectionDB;

    /**
     * @param model
     * @param view
     */
    public Controller(InterfaceModelColorSwitch model, InterfaceViewColorSwitch view) {
        this.model = model;
        this.view = view;
        view.setController(this);
        connectionDB = new GestionDB();


    }

    /**
     *
     */
    public void init() {
        view.basicView();
    }


    /**
     *
     */
    public void startMenu() {

        view.viewMenu();
    }

    /**
     *
     */
    public void startGame() {
        model.startGame();
        view.viewGame(model.getGame());
    }

    /**
     * Enregistre le score
     *
     * @param score Score du joueur
     */
    public void recordScore(Score score) {

        view.viewGameOverRecord();
    }

    /**
     * Enregistre le score
     *
     * @param score Score du joueur
     */
    public void recordScore(String pseudo, Score score) {


    	System.out.println("CA VA LA");
        connectionDB.record(pseudo, score);
    }

    /**
     *
     */
    public void gameOver() {
        model.gameOver();
        view.viewGameOver();
    }

    /**
     * @return
     */
    public Score getScore() {
        return model.getGame().getScore();
    }

    public void showScoresMenu() {
        boolean testCo = connectionDB.testConnexionDB();
        if (testCo) {

            view.viewScores(connectionDB.getLastRecords(15 * 2));
        } else {
            view.viewScoreError();

        }

    }

    /**
     * @param difficulty
     */
    public void startGame(Difficulty difficulty) {
        model.startGame(difficulty);
        view.viewGame(model.getGame());
    }

    public void startLvl(int nbr_obs) {
        model.startLvl(nbr_obs);
        view.viewGame(model.getGame());
    }

    public void startHellCircle() {
        model.startHellCircle();
        view.viewGame(model.getGame());
    }

    public void menuLvl() {
        view.viewMenuLvl();
    }

    public void incItem(ModelItem mi) {
        model.incItem(mi);
    }

    public boolean isConnect() {
        return connectionDB.testConnexionDB();
    }

	public void win() {
		System.out.println("Victoire");
		
	}

    public void clean() {
        //TODO
    }
}
