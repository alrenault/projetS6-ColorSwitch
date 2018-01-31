package game.path;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;


public class Obstacle implements Colorable {
    protected Group obstacle;
    protected double x;
    protected double y;
    protected Color colors[];
    protected int version;
    protected ensDifficulty difficulty;

    public Obstacle(double x, double y, Color[] colors, int version) {
        this.x = x;
        this.y = y;
        this.colors = colors;
        this.version = version;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Group getObstacle() {
        return obstacle;
    }

    public ensDifficulty getDifficulty() {
        return difficulty;
    }

    public boolean isOver(int x, int y) {
        return this.obstacle.contains(x, y);
    }

    protected enum ensDifficulty {EASY, NORMAL, HARD}
}
