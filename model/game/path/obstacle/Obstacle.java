package model.game.path.obstacle;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.modelObstacle.ModelObstacle;
import model.game.path.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * An Obstacle is a Group of Shapes which contains at least one of it
 * This class is the pattern of all obstacles in the model.game
 */
public abstract class Obstacle extends Element {
    /**
     * Le model contenant les données pour la construction e l'obstacle
     */
    protected ModelObstacle mo;
    /**
     * La liste des couleurs passables
     */
    List<Color> color_passable;
    /**
     * Le Group représentant l'obstacle
     */
    private Group obstacle;
    /**
     * Objet permettant de manipuler les coordonnees (et la largeur et hauteur) de l'Item)
     */
    private Bounds coord;

    /**
     * Constructeur de l'obstacle
     * @param mo Le modèle ace quoi on veut construire l'obstacle
     */
    Obstacle(ModelObstacle mo) {
        super();
        this.mo = mo;
        color_passable = new ArrayList<>();

        obstacle = buildObstacle();
    }

    /**
     * Accesseur du modèle de l'obstacle
     *
     * @return le modèle de l'obstacle
     */
    public ModelObstacle getModel_obstacle() {
        return mo;
    }

    protected abstract Group buildObstacle();

    /**
     * Accesseur de coordonnée x
     *
     * @return La coordonnée x
     */
    private double getX() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    /**
     * Accesseur de coordonnée y
     *
     * @return La coordonnée y
     */
    public double getY() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    /**
     * Accesseur des coordonnées sous forme d'un Point2D
     *
     * @return Les coordonnées
     */
    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }

    /**
     * Accesseur du groupe représentant l'obstacle
     *
     * @return le groupe représentant l'obstacle
     */
    public Group getObstacle() {
        return obstacle;
    }

    /**
     * Accesseur de la largeur de l'obstacle
     *
     * @return la largeur de l'obstacle
     */
    public double getObstacleWidth() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getWidth();
    }

    /**
     * Accesseur de la hauteur de l'obstacle
     *
     * @return la largeur de l'obstacle
     */
    public double getObstacleHeight() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getHeight();
    }

    /**
     * Accesseur de la liste de couleurs passables
     *
     * @return la liste des couleurs passables
     */
    public List<Color> getColor_passable() {
        return color_passable;
    }


}
