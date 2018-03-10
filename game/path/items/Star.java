package game.path.items;

import java.util.List;

import game.Colorable;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import model.Model;


/**
 * @author Vincent
 * @date 8/02/18
 */

public class Star extends Item {
    /**
     * Rayon de l'etoile
     */
    private double radius;

    /**
     *
     * @param x Coordonnée x de l'Etoile
     * @param y Coordonnée y de l'Etoile
     * @param _radius Rayon de l'Etoile
     * @param colors couleur de l'Etoile
     */
    public Star(double x, double y, double _radius,List<Color> colors) {
        super(x, y, colors);
        this.radius = _radius;
        //recuperation de la position
        //  this.coord = shape.localToScene(shape.getBoundsInLocal());
    }

    public Star(double x, double y,List<Color> colors) {
        super(x, y, colors);
        this.radius = 10.0;
        // this.coord = shape.localToScene(shape.getBoundsInLocal());
        this.item = buildItem();
    }

    protected Group buildItem() {
        Group g = new Group();
        Polygon p = new Polygon();
        double[] ax = new double[5];
        double[] ay = new double[5];
        for (int i = 0; i < 5; i++) {
            ax[i] = x + (radius * Math.cos(i * 2 * Math.PI / 5));
            ay[i] = y + (radius * Math.sin(i * 2 * Math.PI / 5));
        }

        p.getPoints().addAll(ax[1], ay[1], ax[4], ay[4], ax[2], ay[2], ax[0], ay[0], ax[3], ay[3]);
        p.setFill(colors.get(0));

        g.getChildren().add(p);


        return g;
    }


}
