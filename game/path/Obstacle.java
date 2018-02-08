package game.path;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;

/**
 * An Obstacle is a Group of Shapes which contains at least one of it
 * This class is the pattern of all obstacles in the game
 */
public abstract class Obstacle implements Colorable {

    protected enum ensDifficulty {EASY, NORMAL, HARD}

    protected Group obstacle;
    protected double x;
    protected double y;
    protected Color colors[];
    protected int version;
    protected int versionDefault;
    protected ensDifficulty difficulty;


    public Obstacle(double x, double y, Color[] colors, int version, int versionDefault) {
        this.x = x;
        this.y = y;
        this.colors = colors;
        this.versionDefault = versionDefault;
        if(0 > version){
        	this.version = versionDefault;
        }
        else{
            this.version = version;
        }
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


}
