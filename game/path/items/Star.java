package game.path.items;

import java.util.List;
import java.util.Random;

import controller.Controller;
import game.Colorable;
import game.ball.Player;
import game.ball.BallPlayer;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
import model.Model;
import model.modelItem.ModelBallColorSwitch;
import model.modelItem.ModelItem;
import model.modelItem.ModelStar;
import view.ViewPath;
import javafx.scene.shape.Shape;



/**Objet graphique Etoile
 */

public class Star extends Item {

    /**
     *Constructeur d'Etoile
     */
    public Star(ModelStar ms) {
        super(ms);
        //recuperation de la position
        //  this.coord = shape.localToScene(shape.getBoundsInLocal());
        this.item = buildItem(ms);
    }


    /**
     * Genere la forme
     * @return un ensemble de Forme
     */
    protected Group buildItem(ModelItem mi) {
        Group g = new Group();
        Polygon p = new Polygon();
        double[] ax = new double[5];
        double[] ay = new double[5];
        for (int i = 0; i < 5; i++) {
            ax[i] = mi.getX() + (((ModelStar)mi).getRadius() * Math.cos(i * 2 * Math.PI / 5));
            ay[i] = mi.getY() + (((ModelStar)mi).getRadius() * Math.sin(i * 2 * Math.PI / 5));
        }

        p.getPoints().addAll(ax[1], ay[1], ax[4], ay[4], ax[2], ay[2], ax[0], ay[0], ax[3], ay[3]);
        p.setFill(mi.getColors().get(0));
        
        p.setRotate(125);

        g.getChildren().add(p);
        addSL(p);


        return g;
    }
    
    public void setY(double y){
    	for(Shape s : getShapeList()){
    		s.setLayoutY(y);
    	}
    }
    
    public void get(ViewPath vPath, Controller c, BallPlayer b){
    	c.incItem(model_item);
    	
    	if(c.getScore().getNbEtoilesRamassees() > 1)
    		vPath.removeObstacle(vPath.getObstacles().get(0));
    }


}
