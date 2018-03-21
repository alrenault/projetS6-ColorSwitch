package game.path.items;

import controller.Controller;
import game.ball.Ball;
import game.ball.BallPlayer;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import model.modelItem.ModelGravitySwitch;
import model.modelItem.ModelItem;
import view.ViewPath;


/**Objet graphique Changeur de gravité
 * @autor Vincent
 * @date 09/02/2018
 */
public class GravitySwitch extends Item {


    /**
     * Constructeur
     */
    public GravitySwitch(ModelGravitySwitch mgs) {
        super(mgs);
        item = buildItem(mgs);
    }

    /**
     * Genere la forme
     * @return un ensemble de forme
     */
    protected Group buildItem(ModelItem mi) {
        double w = ((ModelGravitySwitch)mi).getSize();
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
    
    public void get(ViewPath vPah, Controller c, BallPlayer b){
    	//TODO
    }
}
