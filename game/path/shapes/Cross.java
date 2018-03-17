package game.path.shapes;

import java.util.List;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.modelShape.ModelCross;
import model.modelShape.ModelShape;

/**Objet graphique d'une croix
 */
public class Cross extends Shapes {
    
    /**
     * Constructeur basique de la croix (direction à true, acceleration à false, la vitesse la plus faible, et la position de la couleur à 1
     * @param x Coordonnée en x de la croix
     * @param y Coordonnée en y de la croix
     * @param width Largeur d'un rectangle
     * @param length Longueur d'un rectangle
     * @param colors L'ensemble de couleurs utilisées par la croix
     */
    
    public Cross(ModelCross mc){
    	super(mc);
    	group_shape = build(mc);
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
    }


    /**
     * Génère la croix
     * @return le Group correspondant à la croix
     */
    protected Group build(ModelCross mc) {

        //Initialisation
        Group croix = new Group();
        double rad = mc.getWidth();
        double len = mc.getLength();

        //Computing hight-left corner of the first rectangle
        double x_pos_1 = mc.getX() - rad - len / 2;
        double y_pos_1 = mc.getY() - rad / 2;

        //Computing hight-left corner of the second rectangle
        double x_pos_2 = mc.getX() - len / 2;
        double y_pos_2 = mc.getY() - rad - len / 2;

        //Computing hight-left corner of the second rectangle
        double x_pos_3 = mc.getX() + len / 2;
        double y_pos_3 = mc.getY() - len / 2;

        //Computing hight-left corner of the second rectangle
        double x_pos_4 = mc.getX() - len / 2;
        double y_pos_4 = mc.getY() + len / 2;

        double x_middle = mc.getX() - len / 2;
        double y_middle = mc.getY() - len / 2;

        //Building Cross
        Rectangle part_1 = new Rectangle(x_pos_1, y_pos_1, rad, len);
        Rectangle part_2 = new Rectangle(x_pos_2, y_pos_2, len, rad);
        Rectangle part_3 = new Rectangle(x_pos_3, y_pos_3, rad, len);
        Rectangle part_4 = new Rectangle(x_pos_4, y_pos_4, len, rad);
        Rectangle middle = new Rectangle(x_middle, y_middle, len, len);
        middle.setFill(Color.WHITE);

        if (mc.getNbr_rect() == 4) {
            color(part_1);
            verifPosColor();

            color(part_2);
            verifPosColor();

            color(part_3);
            verifPosColor();

            color(part_4);
            verifPosColor();

        } else {
            color(part_1);
            color(part_3);
            verifPosColor();

            color(part_2);
            color(part_4);
            verifPosColor();
        }
        
        addSL(part_1,part_2,part_3,part_4,middle);

        croix.getChildren().add(part_1);
        croix.getChildren().add(part_2);
        croix.getChildren().add(part_3);
        croix.getChildren().add(part_4);
        croix.getChildren().add(middle);


        RotateTransition rt1 = new RotateTransition(Duration.seconds(mc.getMouvementSpeed()), croix);

        rt1.setByAngle(360 * ((mc.isMouvementDirection()) ? 1 : -1));

        if (!mc.isAcceleration()) {
            rt1.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
        }

        rt1.setCycleCount((int) Double.POSITIVE_INFINITY);


        rt1.play();

        return croix;
    }
}
