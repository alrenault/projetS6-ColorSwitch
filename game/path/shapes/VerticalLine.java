package game.path.shapes;

import java.util.List;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.modelShape.ModelVLine;

/**
 * Objet graphique d'une ligne verticale
 */
public class VerticalLine extends Shapes {

    

    /**
     * Constructeur d'une ligne verticale

     */
    public VerticalLine(ModelVLine mvl) {
        super(mvl);
        this.group_shape = buildShape(mvl);

        //recuperation de la position
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
        
       // check();
    }


    /**
     * Génère la ligne verticale
     * @return le Group correspondant a la ligne verticale
     */
    protected Group buildShape(ModelVLine mvl) {
        Group hline = new Group();

        for (int i = 0; i < mvl.getNbr_seg(); i++) {
            mvl.verifPosColor();
            Rectangle rec = new Rectangle(mvl.getX() + mvl.getDistanceSeparation() * i, mvl.getY(), mvl.getWidth(), mvl.getHeight());
            mvl.color(rec);
            
            addSL(rec);
            hline.getChildren().add(rec);
        }


        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(mvl.getMouvementSpeed() + Math.abs(mvl.getGoal() / 1000)), hline);
        tt1.setByX(mvl.getGoal());

        tt1.setCycleCount((int) Double.POSITIVE_INFINITY);

        if (mvl.isReverse())
            tt1.setAutoReverse(true);

        if (!mvl.isAcceleration()) tt1.setInterpolator(Interpolator.LINEAR);

        tt1.play();

        return hline;
    }

}
