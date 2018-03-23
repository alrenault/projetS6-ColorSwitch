package model.modelObstacle;

import java.util.ArrayList;
import java.util.List;

import view.game.Difficulty;
import javafx.scene.paint.Color;
import model.ObstacleType;

public abstract class ModelObstacle {
	/**
	 * Coordonnée en x de l'Obstacle
	 */
    private double x;
	/**
	 * Coordonnée en Y de l'Obstacle
	 */
    private double y;
	/**
	 *
	 */
    private List<Color> colors;
	/**
	 *
	 */
    int version;
	/**
	 *
	 */
    private int versionDefault;
	/**
	 *
	 */
    private int nbr_Versions;
	/**
	 *
	 */
    private Difficulty difficulty;
	/**
	 *
	 */
    private List<Color> color_use;
	/**
	 *
	 */
    private ObstacleType type;
    
	/**
	 *
	 * @param x
	 * @param y
	 * @param colors
	 * @param version
	 * @param versionDefault
	 * @param obstacleType Le type de l'Obstacle à génerer
	 */
    ModelObstacle(double x, double y, List<Color> colors, int version, int versionDefault, ObstacleType obstacleType){
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
    

	/**
	 *
	 * @return
	 */
	public double getX() {
		return x;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		return y;
	}

	/**
	 *
	 * @return
	 */
	public List<Color> getColors() {
		return colors;
	}

	/**
	 *
	 * @return
	 */
	public int getVersion() {
		return version;
	}

	/**
	 *
	 * @param version
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 *
	 * @return
	 */
	public int getVersionDefault() {
		return versionDefault;
	}

	/**
	 *
	 * @return
	 */
	public int getNbr_Versions() {
		return nbr_Versions;
	}

	/**
	 *
	 * @return
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}

	/**
	 *
	 * @param difficulty
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 *
	 * @return
	 */
	public List<Color> getColor_use() {
		return color_use;
	}

	/**
	 *
	 * @return
	 */
	public ObstacleType getType() {
		return type;
	}

	/**
	 *
	 * @return
	 */
	public abstract double getObstacleHeight();
    
	   
}
