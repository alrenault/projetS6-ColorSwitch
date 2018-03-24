package view.path.items;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import model.modelItem.ModelGravitySwitch;
import view.ViewPath;
import view.ball.BallPlayer;


/**
 * Objet graphique Changeur de gravité
 */
public class GravitySwitch extends Item {


    /**
     * Constructeur d'un GravitySwitch
     * @param mgs Modèle à utiliser pour la création d'un GravitySwitch
     */
    public GravitySwitch(ModelGravitySwitch mgs) {
        super(mgs);
    }

    protected Group buildItem() {
        double w = ((ModelGravitySwitch) mi).getSize();
        double x = mi.getX();
        double y = mi.getY();

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
        p.setFill(mi.getColors().get(0));
        g.getChildren().add(p);
        return g;


    }

    public void get(ViewPath vPah, Controller c, BallPlayer b) {
    }
}