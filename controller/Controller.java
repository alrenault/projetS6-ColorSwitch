package controller;

import DB.GestionDB;
import model.InterfaceModelColorSwitch;
import model.modelItem.ModelItem;
import view.InterfaceViewColorSwitch;
import view.game.Difficulty;
import view.game.Score;

/**
 *Représente le controlleur de l'application pour l'application en MVC
 */
public class Controller {
	
    /**
     * Modèle du MVC
     */
    private InterfaceModelColorSwitch model;
    /**
     * Vue du MVC
     */
    private InterfaceViewColorSwitch view;
    
    /**
     * Connection à la base de donnée
     */
    private GestionDB connectionDB;

    /**
     * Constructeur du controlleur
     * @param model Modèle à relier avec le controlleur
     * @param view Vue à relier ave  le controlleur
     */
    public Controller(InterfaceModelColorSwitch model, InterfaceViewColorSwitch view) {
        this.model = model;
        this.view = view;
        view.setController(this);
        connectionDB = new GestionDB();


    }

    /**
     * Appel à la méthode d'affichage du menu par défaut 
    */
    public void init() {
        view.basicView();
    }


    /**
     * Appel à la méthode d'affichage du menu principal
     */
    public void startMenu() {
        view.viewMenu();
    }

    /**
     * Lance le jeu en difficulté RANDOM
     */
    public void startGame() {
        model.startGame();
        view.viewGame(model.getGame());
    }

    /**
     * Enregistre le score
     * @param score Score du joueur
     */
    public void recordScore(Score score) {
        view.viewGameOverRecord();
    }

    /**
     * Enregistre le score
     * @param pseudo Le pseudo du joueur
     * @param score Score du joueur
     */
    public void recordScore(String pseudo, Score score) {
    	System.out.println("CA VA LA");
        connectionDB.record(pseudo, score);
    }

    /**
     * Lance l'écran du game over
     */
    public void gameOver() {
        model.gameOver();
        view.viewGameOver();
    }

    /**
     * Accesseur de l'objet score
     * @return L'objet score
     */
    public Score getScore() {
        return model.getGame().getScore();
    }

    /**
     * Affiche le menu des scores
     */
    public void showScoresMenu() {
        boolean testCo = connectionDB.testConnexionDB();
        if (testCo) {

            view.viewScores(connectionDB.getLastRecords(15 * 2));
        } else {
            view.viewScoreError();

        }

    }

    /**
     * Lance une partie avec comme difficulté celle passé en paramètre
     * @param difficulty La difficulté de la partie à lancer
     */
    public void startGame(Difficulty difficulty) {
        model.startGame(difficulty);
        view.viewGame(model.getGame());
    }

    /**
     * Lance un niveau d'un certain nombre d'obstacle
     * @param nbr_obs Le nombre d'obstacle à traverser
     */
    public void startLvl(int nbr_obs) {
        model.startLvl(nbr_obs);
        view.viewGame(model.getGame());
    }

    /**
     * Lance la partie en HellCircle
     */
    public void startHellCircle() {
        model.startHellCircle();
        view.viewGame(model.getGame());
    }

    /**
     * Affiche le menu de choix de niveaux
     */
    public void menuLvl() {
        view.viewMenuLvl();
    }

    /**
     * Augmente le nombre d'item ramassé
     * @param mi Le model de l'item à ramasser
     */
    public void incItem(ModelItem mi) {
        model.incItem(mi);
    }

    /**
     * Teste si il est possible de se connecter à la base de donnée
     * @return Si il est possible de se connecter à la base de donnée
     */
    public boolean isConnect() {
        return connectionDB.testConnexionDB();
    }

    /**
     * Fait gagner une partie
     */
	public void win() {
		System.out.println("Victoire");
		
	}
	public void parametres(){
	    view.viewParams();
    }

	/**
	 * Permet de nettoyer le jeu
	 */
    public void clean() {
        //TODO
    }
}
