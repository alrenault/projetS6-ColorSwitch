package game.path.pluri;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * An Obstacle is a Group of Shapes which contains at least one of it
 * This class is the pattern of all obstacles in the game
 */
public abstract class Obstacle {

    protected Group obstacle;
    protected double x;
    protected double y;
    protected Color colors[];
    protected int version;
    protected int versionDefault;
    protected int nbr_Versions;
    protected ensDifficulty difficulty;
    protected Bounds coord;
    public Obstacle(double x, double y, Color[] colors, int version, int versionDefault) {
        this.x = x;
        this.y = y;
        this.colors = colors;
        this.versionDefault = versionDefault;
        if (0 > version) {
            this.version = versionDefault;
        } else {
            this.version = version;
        }
    }

    public double getX() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }

    public double getY() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    public Point2D getCoord() {
        return new Point2D(getX(), getY());
    }

    public Group getObstacle() {
        return obstacle;
    }

    public double getObstacleWidth() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getWidth();
    }

    public double getObstacleHeight() {
        coord = obstacle.localToScene(obstacle.getBoundsInLocal());
        return coord.getHeight();
    }

    public ensDifficulty getDifficulty() {
        return difficulty;
    }

    public boolean isOver(int x, int y) {
        return this.obstacle.contains(x, y);
    }

    protected enum ensDifficulty {EASY, NORMAL, HARD}


}
