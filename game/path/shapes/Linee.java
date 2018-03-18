package game.path.shapes;

import java.util.List;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.modelShape.ModelCircle;
import model.modelShape.ModelHLine;
import model.modelShape.ModelShape;
import model.modelShape.ModelSquare;

/**
 * Objet graphique d'une ligne horizontale
 */
public class Linee extends Shapes {


    /**
     * Constructeur d'une ligne
     */
    public Linee(ModelHLine mhl) {
        super(mhl);
    }

    /**
     * Génère la ligne
     * @return le Group correspondant à la ligne
     */
    protected Group buildShape(ModelShape ms) {
    	
    	ModelHLine mhl = null;
    	if(ms instanceof ModelHLine ){
    		mhl = (ModelHLine)ms;
    	}
    	else
    		throw new IllegalArgumentException("Modele de ligne horizontale necessaire");

    	
        Group line = new Group();

        for (int i = 0; i < mhl.getNbr_seg(); i++) {
            mhl.verifPosColor();
            Rectangle rec = new Rectangle(mhl.getX() + mhl.getLength() * i, mhl.getY(), mhl.getLength(), mhl.getWidth());
            mhl.color(rec);
            
            addSL(rec);
            line.getChildren().add(rec);
        }


        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(mhl.getMouvementSpeed()), line);
        tt1.setByX(mhl.getGoal());

        tt1.setCycleCount((int) Double.POSITIVE_INFINITY);

        if (mhl.isReverse())
            tt1.setAutoReverse(true);

        if (!mhl.isAcceleration()) tt1.setInterpolator(Interpolator.LINEAR);

        tt1.play();

        return line;
    }
}
