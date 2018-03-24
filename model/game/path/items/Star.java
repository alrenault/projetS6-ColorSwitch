package model.game.path.items;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import model.modelItem.ModelStar;
import view.ViewPath;
import model.game.ball.BallPlayer;


/**
 * Objet graphique Etoile
 */

public class Star extends Item {

    /**
     * Constructeur d'Etoile
     * @param ms Modèle servant à contruire une Star
     */
    public Star(ModelStar ms) {
        super(ms);
    }


    /**
     * Genere la forme
     *
     * @return un ensemble de Forme
     */
    protected Group buildItem() {
        Group g = new Group();
        Polygon p = new Polygon();
        double[] ax = new double[5];
        double[] ay = new double[5];
        for (int i = 0; i < 5; i++) {
            ax[i] = mi.getX() + (((ModelStar) mi).getRadius() * Math.cos(i * 2 * Math.PI / 5));
            ay[i] = mi.getY() + (((ModelStar) mi).getRadius() * Math.sin(i * 2 * Math.PI / 5));
        }

        p.getPoints().addAll(ax[1], ay[1], ax[4], ay[4], ax[2], ay[2], ax[0], ay[0], ax[3], ay[3]);
        p.setFill(mi.getColors().get(0));

        p.setRotate(125);

        g.getChildren().add(p);
        addSL(p);


        return g;
    }

    /**
     * Mutateur de la coordonnée en y de l'étoile
     *
     * @param y La nouvelle position de l'étoile
     */
    public void setY(double y) {
        for (Shape s : getShapeList()) {
            s.setLayoutY(y);
        }
    }

    public void get(ViewPath vPath, Controller c, BallPlayer b) {
        c.incItem(mi);
    }


}
