package view;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import model.modelBall.Ball;
import model.modelBall.BuildBall;
import model.modelItem.ModelItem;
import model.modelObstacle.ModelObstacle;
import model.game.Colorable;
import model.game.Game;
import view.ball.BallPlayer;
import view.path.Path;
import view.path.items.BuildItem;
import view.path.items.Item;
import view.path.obstacle.BuildObstacle;
import view.path.obstacle.Obstacle;
import view.useLaw.ViewTimer;

import javax.swing.text.html.ImageView;

/**
 *
 */
class ViewGameManagement {
    /**
     *
     */
    private static Group root;
    /**
     *
     */
    private static Game game;
    private static ViewTimer timer;


    /**
     * @param thisGame
     * @param thisScene
     */
    public static void view(Game thisGame, Scene thisScene, Controller controller) {

        root = (Group) thisScene.getRoot();
        game = thisGame;


        Path path = game.getPath();
        Ball ball = game.getBall();


        //BallPlayer qball = new BallPlayer(10, path.getColors().get(0), thisScene);
        BallPlayer ballplayer = BuildBall.build(ball, thisScene);


        Group jBall = ballplayer.getShape();

        add(jBall);


        Label score = new Label("Oui");
        score.setTextFill(Color.AQUAMARINE);
        root.getChildren().add(score);


        ViewPath viewpath = new ViewPath(path);

        if (viewpath.getFinishLine() != null) {
            root.getChildren().add(viewpath.getFinishLine());
        }
        
        System.out.println(thisGame.getUniverse());

        timer = new ViewTimer(ballplayer, viewpath, controller, thisScene, thisGame.getUniverse());
        timer.play();
        //ViewTimer timer = new ViewTimer(thisGame,viewpath,ballplayer,thisScene);


        thisScene.setFill(Colorable.BLACK);
    }

    /**
     * Methode d'ajout de Shape, Item ... dans root
     *
     * @param group L'item,Shape,... à ajouter
     */
    public static void add(Group group) {
        root.getChildren().add(group);
    }

    public void construtionUnivLaws(){

    }

    /**
     * @param path
     * @return
     */
    public static Group buildObstacles(Path path) {
        Group jObstacles = new Group();

        for (ModelObstacle mo : path.getObstacles()) {

            Obstacle obstacle = BuildObstacle.build(mo);
            add(obstacle.getObstacle());
        }

        return jObstacles;
    }

    /**
     * @param path
     * @return
     */
    public static Group buildItems(Path path) {
        Group jItems = new Group();

        for (ModelItem mi : path.getItem()) {

            Item item = BuildItem.build(mi);
            add(item.getItem());
        }

        return jItems;
    }

    /**
     * Vide le manager
     */
    public void destroy() {
        ViewGameManagement.game.clean();
        ViewGameManagement.timer.clean();


    }




}
