package game.path.obstacle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import game.Difficulty;
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
    protected List<Color> colors;
    protected int version;
    protected int versionDefault;
    protected int nbr_Versions;
    protected Difficulty difficulty;
    protected Bounds coord;
    protected List<Color> color_use;


    public Obstacle(double x, double y, List<Color> colors, int version, int versionDefault) {
        this.x = x;
        this.y = y;
        this.colors = colors;
        this.versionDefault = versionDefault;
        if (0 > version) {
            this.version = versionDefault;
        } else {
            this.version = version;
        }
        color_use = new ArrayList<Color>();
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

    public Difficulty getDifficulty() {
        return difficulty;
    }

    
    
    public List<Color> getColor_use() {
		return color_use;
	}


	public boolean isOver(int x, int y) {
        return this.obstacle.contains(x, y);
    }


    // public enum Difficulty {EASY, NORMAL, HARD}


}