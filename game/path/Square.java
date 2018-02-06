package game.path;

import game.Colorable;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Square extends Shapes {

    private double length;

    public Square(double x, double y, double length, double width,
    		boolean mouvementDirection, boolean acceleration,int mouvementSpeed,Color[] colors, int pos_color) {
        super(x, y, width,mouvementDirection, acceleration,mouvementSpeed, colors, pos_color);
        this.length = length;

        this.shape = buildSquare();

    }


    private Group buildSquare() {
        Group squaire = new Group();

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


        color(rec1);
        verifPosColor();
        color(rec2);
        verifPosColor();
        color(rec3);
        verifPosColor();
        color(rec4);
        verifPosColor();

        squaire.getChildren().add(rec1);
        squaire.getChildren().add(rec2);
        squaire.getChildren().add(rec3);
        squaire.getChildren().add(rec4);


        RotateTransition rt = new RotateTransition(Duration.seconds(mouvementSpeed), squaire);

        rt.setByAngle(360 * ((mouvementDirection) ? 1 : -1));

        if (!acceleration) {
            rt.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
        }


        rt.setCycleCount((int) Double.POSITIVE_INFINITY);

        rt.play();

        return squaire;


    }


}
