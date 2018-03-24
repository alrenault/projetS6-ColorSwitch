package view;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import model.modelBall.Ball;
import model.modelBall.BuildBall;
import model.modelItem.ModelItem;
import model.modelLaw.Universe.UniverseType;
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
 * Crée les élément graphique du jeu
 */
class ViewGameManagement {
    
	/**
     * Le groupe racine de la scène
     */
    private static Group root;
    
    /**
     * Instance du jeu à afficher
     */
    private static Game game;
    
    /**
     * Timer pour lancer les traitements en continue
     */
    private static ViewTimer timer;


    /**
     * Constructeur de la vue
     * @param thisGame L'instance du jeu où il faut afficher les élements graphique
     * @param thisScene La scène où se trouve les éléments graphique
     * @param controller Instance du controlleur 
     */
    public static void view(Game thisGame, Scene thisScene, Controller controller) {

        root = (Group) thisScene.getRoot();
        game = thisGame;
        
        Group interfaceGame = new Group();
        root.getChildren().add(interfaceGame);
        
        


        Path path = game.getPath();
        Ball ball = game.getBall();


        BallPlayer ballplayer = BuildBall.build(ball, thisScene);
        if(game.getUniverse().getType() == UniverseType.Basic){
        	ballplayer.basicMode();
        }


        Group jBall = ballplayer.getShape();

        add(jBall);


        //Label score = new Label("Oui");
        //score.setTextFill(Color.AQUAMARINE);
        //root.getChildren().add(score);


        ViewPath viewpath = new ViewPath(path);

        if (viewpath.getFinishLine() != null) {
            root.getChildren().add(viewpath.getFinishLine());
        }
        
        System.out.println(thisGame.getUniverse());

        timer = new ViewTimer(ballplayer, viewpath, controller, thisScene, thisGame.getUniverse(),interfaceGame);
        timer.play();


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

    /**
     * Construit les obstacles depuis un ensemble de modèle d'obstacle présent dans un path
     * @param path Le path où se trouvent les modèles
     * @return Le groupe contenant les obstacles 
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
     * Construit les items depuis un ensemble de modèle d'obstacle présent dans un path
     * @param path Le path où se trouvent les modèles
     * @return Le groupe contenant les items 
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
