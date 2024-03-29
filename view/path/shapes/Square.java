package view.path.shapes;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import model.modelShape.ModelSquare;

/**
 * Objet graphique d'un carre
 */
class Square extends Shapes {

    /**
     * Constructeur d'un carre
     *
     * @param ms Le modèle avec lequel on veut construire un carré
     */
    public Square(ModelSquare ms) {
        super(ms);


        //recuperation de la position
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());

    }

    /**
     * Génère le carre
     *
     * @return le Group correspondant au carre
     */
    protected Group buildShape() {
        ModelSquare ms1 = (ModelSquare) ms;
        Group squaire = new Group();
        double length = ms1.getLength();
        double x = ms.getX();
        double y = ms.getY();
        double width = ms.getWidth();

        double pos1_x = x - length / 2;
        double pos1_y = y - length / 2;

        double pos2_x = x - length / 2;
        double pos2_y = y - length / 2 + width;

        double pos3_x = x - length / 2 + width;
        double pos3_y = y + length / 2 - width;

        double pos4_x = x + length / 2 - width;
        double pos4_y = y - length / 2;

        Rectangle rec1 = new Rectangle(pos1_x, pos1_y, length - width, width);
        Rectangle rec2 = new Rectangle(pos2_x, pos2_y, width, length - width);
        Rectangle rec3 = new Rectangle(pos3_x, pos3_y, length - width, width);
        Rectangle rec4 = new Rectangle(pos4_x, pos4_y, width, length - width);


        ms.color(rec1);
        ms.verifPosColor();
        ms.color(rec2);
        ms.verifPosColor();
        ms.color(rec3);
        ms.verifPosColor();
        ms.color(rec4);
        ms.verifPosColor();

        addSL(rec1, rec2, rec3, rec4);
        squaire.getChildren().add(rec1);
        squaire.getChildren().add(rec2);
        squaire.getChildren().add(rec3);
        squaire.getChildren().add(rec4);


        RotateTransition rt = new RotateTransition(Duration.seconds(ms.getMouvementSpeed()), squaire);

        rt.setByAngle(360 * ((ms.isMouvementDirection()) ? 1 : -1));

        if (!ms.isAcceleration()) {
            rt.setInterpolator(Interpolator.LINEAR);
        }


        rt.setCycleCount((int) Double.POSITIVE_INFINITY);

        rt.play();

        return squaire;


    }


}
