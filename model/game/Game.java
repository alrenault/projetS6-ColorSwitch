package model.game;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import model.modelBall.Ball;
import model.modelLaw.Universe;
import model.modelLaw.Universe.UniverseType;
import view.path.Path;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe est utilisée pour créer un jeu
 * Cette classe ne contient que les données relatives au jeu
 */

public class Game {

    /**
     * La difficulté de la partie
     */
    Difficulty difficulty;

    /**
     * La liste de couleurs à utiliser par le jeu
     */
    List<Color> colors;

    /**
     * La scène du jeu
     */
    Scene scene;

    /**
     * La ball représentant le joueur
     */
    private Ball ball;

    /**
     * Le chemin formé d'obstacles
     */
    private Path path;

    /**
     * L'ensemble des lois régissant le jeu
     */
    private Universe universe;

    /**
     * Le score du joueur
     */
    private Score score;

    /**
     * Le nombre de frame
     */
    private int nFrame = 0;

    /**
     * Le constructeur d'un jeu
     *
     * @param _ball     La balle représentant le joueur
     * @param _path     Le chemin d'obstacles
     * @param _universe L'ensemble de lois
     */
    public Game(Ball _ball, Path _path, Universe _universe) {
        this.ball = _ball;
        this.path = _path;
        this.universe = _universe;
    }

    /**
     * Constructeur d'un jeu infini
     */
    public Game() {
        List<Color> CUSTOM = customColors();

        this.path = new Path(600, 1000, CUSTOM);

        this.ball = new Ball(10, CUSTOM.get(0));

        this.universe = new Universe();

        this.score = new Score();


    }

    /**
     * Constructeur d'un jeu avec un certain nombre d'obstacles
     *
     * @param nbr_obs Le nombre d'obstacle à créer
     */
    public Game(int nbr_obs) {
        List<Color> CUSTOM = customColors();

        this.path = new Path(600, 1000, CUSTOM, nbr_obs);

        this.ball = new Ball(10, CUSTOM.get(0));

        this.universe = new Universe();

        this.score = new Score();
    }


    /**
     * Constructeur d'un jeu en fonction d'une difficulté et d'un type d'univers
     *
     * @param difficulty La difficulté de la partie
     * @param type       Le type d'univers utilisé
     */
    public Game(Difficulty difficulty, UniverseType type) {


        List<Color> CUSTOM = customColors();

        this.path = new Path(600, 1000, CUSTOM, 5, difficulty);

        //this.ball = new BallPlayer(10, CUSTOM.get(0), scene);
        this.ball = new Ball(10, CUSTOM.get(0));

        this.universe = new Universe(type);

        this.score = new Score();
    }

    /**
     * Crée une liste de couleurs custem correspondant aux couleurs de Color Switch
     *
     * @return La liste de couleurs
     */
    public ArrayList<Color> customColors() {
        ArrayList<Color> CUSTOM = new ArrayList<>();
        CUSTOM.add(Colorable.YELLOW);
        CUSTOM.add(Colorable.PURPLE);
        CUSTOM.add(Colorable.ROSE);
        CUSTOM.add(Colorable.BLUE);

        return CUSTOM;
    }

    /**
     * Accesseur de la balle
     *
     * @return La balle
     */
    public Ball getBall() {
        return ball;
    }

    /**
     * Accesseur du chemin d'obstacle
     *
     * @return Le chemin d'obstacle
     */
    public Path getPath() {
        return path;
    }

    /**
     * Accesseur de l'ensemble des lois
     *
     * @return L'esemble des lois
     */
    public Universe getUniverse() {
        return universe;
    }

    /**
     * Accesseur du score
     *
     * @return Le score
     */
    public Score getScore() {
        return score;
    }

    /**
     * Vide le Jeu
     */
    public void clean() {
        //this.path.cleanPath();

        this.score = new Score();
    }
}
