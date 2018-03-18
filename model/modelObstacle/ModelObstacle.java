package model.modelObstacle;

import java.util.ArrayList;
import java.util.List;

import game.Difficulty;
import javafx.scene.paint.Color;
import model.ObstacleType;

public class ModelObstacle {

    protected double x;
    protected double y;
    protected List<Color> colors;
    protected int version;
    protected int versionDefault;
    protected int nbr_Versions;
    protected Difficulty difficulty;
    protected List<Color> color_use;
    protected ObstacleType type;
    
    public ModelObstacle(double x, double y, List<Color> colors, int version, int versionDefault, ObstacleType obstacleType){
    	this.x = x;
        this.y = y;
        this.colors = colors;
        this.versionDefault = versionDefault;
        if (0 > version) {
            this.version = versionDefault;
        } else {
            this.version = version;
        }
        color_use = new ArrayList<>();
        this.type = obstacleType;
    }

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public List<Color> getColors() {
		return colors;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getVersionDefault() {
		return versionDefault;
	}

	public int getNbr_Versions() {
		return nbr_Versions;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public List<Color> getColor_use() {
		return color_use;
	}

	public ObstacleType getType() {
		return type;
	}

	public int getObstacleHeight() {
		return 600;
	}
    
	   
}
