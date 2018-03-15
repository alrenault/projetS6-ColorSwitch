package game.path.items;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.util.Arrays;
import java.util.List;


/**Objet graphique Changeur de gravité
 * @autor Vincent
 * @date 09/02/2018
 */
public class GravityInverser extends Item {

    /**
     * La taille
     */
    private double width;


    /**
     * Constructeur
     * @param x coordonnée x de l'objet
     * @param y coordonnée y de l'objet
     */
    public GravityInverser(double x, double y) {
        super(x, y, null);
        this.width = 3.0;
        item = buildItem();
    }

    /**
     * Genere la forme
     * @return un ensemble de forme
     */
    protected Group buildItem() {
        double w = width;
        Polygon p = new Polygon();
        //1
        p.getPoints().add(x - w);
        p.getPoints().add(y - 2 * w);
        //2
        p.getPoints().add(x - w);
        p.getPoints().add(y + 2 * w);
        //5
        p.getPoints().add(x - 2 * w);
        p.getPoints().add(y + 2 * w);

        //6
        p.getPoints().add(x);
        p.getPoints().add(y + 4 * w);
        //7
        p.getPoints().add(x + 2 * w);
        p.getPoints().add(y + 2 * w);
        //3
        p.getPoints().add(x + w);
        p.getPoints().add(y + 2 * w);
        //4
        p.getPoints().add(x + w);
        p.getPoints().add(y - 2 * w);
        //8
        p.getPoints().add(x + 2 * w);
        p.getPoints().add(y - 2 * w);
        //9
        p.getPoints().add(x);
        p.getPoints().add(y - 4 * w);
        p.getPoints().add(x - 2 * w);
        p.getPoints().add(y - 2 * w);


        Group g = new Group();
        p.setFill(colors.get(0));
        g.getChildren().add(p);
        return g;


    }
}
