package game.path.items;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class BallColorSwitch implements Colorable {

    private double x;
    private double y;
    private double size;
    private Group shape;
    private Color[] colors;
    private int pos_color = 0;
    private List<Color> colors_use;


    public BallColorSwitch(double x, double y, Color[] colors) {
        this.size = 10;
        this.x = x;
        this.y = y;

        this.colors = colors;
        this.colors_use = new ArrayList<Color>();
        this.shape = buildBall();
    }

    public Group buildBall() {
        Group ball = new Group();

        double angle = 90;

        ArcType type = ArcType.ROUND;


        for (int i = 0; i <= 4; i++) {
            Arc arc_1 = new Arc(x, y, size, size, i * angle, angle);
            arc_1.setType(type);
            color(arc_1);
            verifPosColor();
            ball.getChildren().add(arc_1);
        }

        return ball;

    }

    public void verifPosColor() {
        pos_color++;
        System.out.println("position " + pos_color);
        if (pos_color == colors.length)
            pos_color = 0;
    }

    public void color(Shape s) {
        s.setFill(colors[pos_color]);
        colors_use.add(colors[pos_color]);
    }

    public Group getShape() {
        return shape;
    }

}
