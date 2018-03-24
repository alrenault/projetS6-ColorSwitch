package model.game;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.modelBall.Ball;
import model.modelLaw.Universe;
import model.modelLaw.Universe.UniverseType;
import view.path.Path;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a model.game
 * You have to use it in the model
 * Only contains data
 */

public class Game {

    Difficulty difficulty;
    List<Color> colors;
    Scene scene;
    private Ball ball;
    private Path path;
    private Universe universe;
    private Score score;
    private int nFrame = 0;

    public Game(Ball _ball, Path _path, Universe _universe) {
        this.ball = _ball;
        this.path = _path;
        this.universe = _universe;
    }
    
    public ArrayList<Color> customColors(){
    	ArrayList<Color> CUSTOM = new ArrayList<>();
        CUSTOM.add(Colorable.YELLOW);
        CUSTOM.add(Colorable.PURPLE);
        CUSTOM.add(Colorable.ROSE);
        CUSTOM.add(Colorable.BLUE);   
        
        return CUSTOM;
    }

    public Game() {
        List<Color> CUSTOM = customColors();

        this.path = new Path(600, 1000, CUSTOM);

        //this.ball = new BallPlayer(10, CUSTOM.get(0), scene);
        this.ball = new Ball(10, CUSTOM.get(0));

        this.universe = new Universe();

        this.score = new Score();


    }
    
    

    public Game(int nbr_obs) {
        List<Color> CUSTOM = customColors();

        this.path = new Path(600, 1000, CUSTOM, nbr_obs);

        //this.ball = new BallPlayer(10, CUSTOM.get(0), scene);
        this.ball = new Ball(10, CUSTOM.get(0));

        this.universe = new Universe();

        this.score = new Score();
    }


    public Game(Scene scene) {


        List<Color> CUSTOM = customColors();


        this.path = new Path(scene.getWidth(), scene.getHeight(), CUSTOM, 10, Difficulty.EASY);

        //this.ball = new BallPlayer(10, CUSTOM.get(0), scene);


        this.universe = new Universe();

        this.score = new Score();

        //ViewGameManagement.view(this,scene,controller);


    }

    public Game(Difficulty difficulty, UniverseType type) {


        List<Color> CUSTOM = customColors();

        this.path = new Path(600, 1000, CUSTOM, 5, difficulty);

        //this.ball = new BallPlayer(10, CUSTOM.get(0), scene);
        this.ball = new Ball(10, CUSTOM.get(0));

        this.universe = new Universe(type);

        this.score = new Score();
    }


    public void stop() {

        path = null;
        ball = null;
        universe = null;
    }


    public void hello(Stage primaryStage) {


        List<Color> CUSTOM = new ArrayList<>();
        CUSTOM.add(Colorable.YELLOW);
        CUSTOM.add(Colorable.PURPLE);
        CUSTOM.add(Colorable.ROSE);
        CUSTOM.add(Colorable.BLUE);

        //Set Stage
        primaryStage.setTitle("ColorSuitch");
        primaryStage.getIcons().add(new Image("file:../view/color_icon.png"));

        //Set Scene
        Group root = new Group();
        Scene scene1 = new Scene(root, 600, 1000);
        //GestionDB g=new GestionDB();

        Group jBall = new Group();
        Group jObstacles = new Group();
        Group jItems = new Group();

        root.getChildren().add(jBall);
        root.getChildren().add(jObstacles);
        root.getChildren().add(jItems);


        Path p = new Path(scene1.getWidth(), scene1.getHeight(), CUSTOM, 10, Difficulty.EASY);

        //jObstacles.getChildren().add(p.getPath());


        scene1.setFill(Colorable.BLACK);


        Label frame = new Label("Frame : " + nFrame);
        root.getChildren().add(frame);


        //-------------------------------------------------------------------


        //Pour le joueur


        //BallPlayer player = new BallPlayer(10, CUSTOM.get(0), scene1);

		/*player.setCenterX(250);

		player.setCenterY(490);*/

        //jBall.getChildren().add(player.getShape());
        //player.applyGravity();


        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public void jump() {
        // TODO Auto-generated method stub

    }


    public Ball getBall() {
        return ball;
    }

    public Path getPath() {
        return path;
    }

    public Universe getUniverse() {
        return universe;
    }

    public Score getScore() {
        return score;
    }

    /**
     * Vide le Jeu
     */
    public void clean() {
        //this.path.cleanPath();



        this.universe.cleanUniverse();

        this.score = new Score();
    }
}
