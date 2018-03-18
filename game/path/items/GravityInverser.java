package game.path.items;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import model.modelItem.ModelGravityInverser;

import java.util.Arrays;
import java.util.List;


/**Objet graphique Changeur de gravité
 * @autor Vincent
 * @date 09/02/2018
 */
public class GravityInverser extends GravitySwitch {

    /**
     * La taille
     */
    private double width;


    /**
     * Constructeur
     * @param x coordonnée x de l'objet
     * @param y coordonnée y de l'objet
     */
    public GravityInverser(ModelGravityInverser mgi) {
        super(mgi);
        item = buildItem(mgi);
    }


}
