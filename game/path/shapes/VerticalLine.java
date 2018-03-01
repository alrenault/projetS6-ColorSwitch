package game.path.shapes;

import java.util.List;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class VerticalLine extends Shapes {

    private double length;
    private int nbr_seg;
    private double goal;
    private double distanceSeparation;
    private boolean reverse;


    public VerticalLine(double x, double y, double height, double width, double distanceSeparation, boolean acceleration
            , boolean reverse, Speed _mouvementSpeed, int nbr_seg, List<Color> colors, int pos_colors, double goal) {
        super(x, y, width, true, acceleration, _mouvementSpeed, colors, pos_colors);
        this.length = height;
        this.distanceSeparation = distanceSeparation;
        this.nbr_seg = nbr_seg;
        this.goal = goal;
        this.reverse = reverse;
        this.shape = build();

        //recuperation de la position
        coord = shape.localToScene(shape.getBoundsInLocal());
    }


    protected Group build() {
        Group hline = new Group();

        for (int i = 0; i < nbr_seg; i++) {
            verifPosColor();
            Rectangle rec = new Rectangle(x + distanceSeparation * i, y, width, length);
            color(rec);
            hline.getChildren().add(rec);
        }


        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(mouvementSpeed + Math.abs(goal / 1000)), hline);
        tt1.setByX(goal);

        tt1.setCycleCount((int) Double.POSITIVE_INFINITY);

        if (reverse)
            tt1.setAutoReverse(true);

        if (!acceleration) tt1.setInterpolator(Interpolator.LINEAR);

        tt1.play();

        return hline;
    }

}
