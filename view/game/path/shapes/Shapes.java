package view.game.path.shapes;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import model.modelShape.ModelShape;
import view.game.path.Element;

/**
 * Une Shapes représent un group de shapes de JavaFX
 * Le but est de représenter une forme concrete pouvant etre utilise pour les obstacles, items ou ennemis
 */

public abstract class Shapes extends Element {

    /**
     * Patron de la forme
     */
    protected ModelShape ms;

    /**
     * Le groupe représentant la forme
     */
    Group group_shape;

    /**
     * Objet permettant de manipuler les coordonnees (et la largeur et hauteur) de la forme)
     */
    Bounds coord;

    /**
     * Constructeuer permettant de construire une forme
     *
     * @param modelShape Le modèle permettant de construire la forme
     */
    Shapes(ModelShape modelShape) {
        super();
        ms = modelShape;
        group_shape = buildShape();

    }

    protected abstract Group buildShape();


    public Bounds getCoord() {
        return coord;
    }

    public void setCoord(Bounds coord) {
        this.coord = coord;
    }

    /**
     * Assesseur de la coordonée en x de la forme
     *
     * @return La coordonnée en x de la forme
     */
    private double getX() {
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }


    /**
     * Assesseur de la coordonée en y de la forme
     *
     * @return La coordonnée en y de la forme
     */
    private double getY() {
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    /**
     * Assesseur des coordonnees de la forme sous la forme d'un Point2D
     *
     * @return Les coordonnees de ka forme
     */
    public Point2D getCoord2D() {
        return new Point2D(getX(), getY());
    }

    /**
     * @param _x
     * @param _y
     * @return
     */
    public boolean isOver(double _x, double _y) {
        return this.group_shape.contains(_x, _y);
        //return this.shape.intersects(getX(),getY(),coord.getSize(),coord.getHeight());
    }

    /**
     * Retourne le groupe correspondant a la forme
     *
     * @return Le groupe correspondant a la forme
     */
    public Group getShape() {
        return group_shape;
    }


}
