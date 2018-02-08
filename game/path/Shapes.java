package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * A Shape is a group of javafx shapes
 * The goal is to represent a concrete shape that can be used for obstacles
 * This class is the pattern of all the shapes
 */
public abstract class Shapes {
    double x, y, width, mouvementSpeed;
    boolean mouvementDirection;
    boolean acceleration;

    int pos_color;
    Group shape;
    Color colors[];
    List<Color> colors_use;

    Shapes(double x, double y, double width, boolean mouvementDirection, boolean acceleration, Speed s, Color[] colors, int pos_color) {
        this.x = x;
        this.y = y;
        this.width = width;

        this.mouvementDirection = mouvementDirection;
        this.acceleration = acceleration;
        switch (s) {
            case SYMPA:
                mouvementSpeed = 6.0;
                break;
            case MOYEN:
                mouvementSpeed = 4.5;
                break;
            case HARD:
                mouvementSpeed = 3.0;
                break;
            case TRESSYMPA:
                mouvementSpeed = 7.0;
                break;
            case NONE:
                mouvementSpeed = 0.0;
                break;
        }

        this.colors = colors;
        if (pos_color <= 0)
            this.pos_color = 0;
        else
            this.pos_color = pos_color % colors.length;
        this.colors_use = new ArrayList<Color>();

    }


    public enum Speed {
        SYMPA,
        MOYEN,
        HARD,
        TRESSYMPA,
        NONE
    }

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
