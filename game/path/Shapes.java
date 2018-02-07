package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;


public abstract class Shapes {
    double x, y, width, mouvementSpeed;
    Shapes(double x, double y, double width, boolean mouvementDirection, boolean acceleration, Speed s, Color[] colors, int pos_color) {
        this.x = x;
        this.y = y;
        this.width = width;

        this.mouvementDirection = mouvementDirection;
        this.acceleration = acceleration;
        switch (s) {
            case SYMPA:
                mouvementSpeed = 7.0;
                break;
            case MOYEN:
                mouvementSpeed = 6.0;
                break;
            case HARD:
                mouvementSpeed = 4.5;
                break;
            case BATARD:
                mouvementSpeed = 3.0;
                break;

        }

        this.colors = colors;
        if (pos_color <= 0)
            this.pos_color = 0;
        else
            this.pos_color = pos_color % colors.length;
        this.colors_use = new ArrayList<Color>();

    }

    boolean mouvementDirection;
    boolean acceleration;

    public enum Speed {SYMPA, MOYEN, HARD, BATARD}

    int pos_color;
    Group shape;
    Color colors[];
    List<Color> colors_use;


    public void verifPosColor() {
        pos_color++;
        if (pos_color == colors.length)
            pos_color = 0;
    }

    public void color(Shape s) {
        s.setFill(colors[pos_color]);
        colors_use.add(colors[pos_color]);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public List<Color> getColors_use() {
        return colors_use;
    }


    public boolean isOver(double _x, double _y) {
        return this.shape.contains(_x, _y);
    }

    public Group getShape() {
        return shape;
    }
}
