package model.modelObstacle;

import javafx.scene.paint.Color;
import model.ObstacleType;
import view.game.Difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * Modèle d'un obstacle
 */
public abstract class ModelObstacle {
	
    /**
     * Version de l'obstacle
     */
    int version;
    
    /**
     * Coordonnée en x de l'Obstacle
     */
    private double x;
    /**
     * Coordonnée en Y de l'Obstacle
     */
    private double y;
    
    /**
     * La liste de couleurs à utiliser
     */
    private List<Color> colors;
    
    /**
     * La version par défaut de l'obstacle
     */
    private int versionDefault;
    
    /**
     * La difficulté de l'obstacle
     */
    private Difficulty difficulty;
    
    /**
     * La liste des oculeurs utilisées
     */
    private List<Color> color_use;
    
    /**
     * Le type de modèle d'obstacle
     */
    private ObstacleType type;

    /**
     * Constructeur d'un modèle d'obstacle
     * @param x Position en x de l'obstacle
     * @param y Position en y de l'obstacle
     * @param colors La liste des couleurs à utiliser
     * @param version La version de d'obstacle 
     * @param versionDefault La version par défaut de l'obstacle
     * @param type Le type du modèle de l'obstacle
     */
    ModelObstacle(double x, double y, List<Color> colors, int version, int versionDefault, ObstacleType obstacleType) {
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
     * Accesseur de la position en x de l'obstacle
     * @return La position en x de l'obstacle
     */
    public double getX() {
        return x;
    }

    /**
     * Accesseur de la position en y de l'obstacle
     * @return La position en y de l'obstacle
     */
    public double getY() {
        return y;
    }

    /**
     * Accesseur de la liste de couleurs à utiliser
     * @return La liste des couleurs à utiliser
     */
    public List<Color> getColors() {
        return colors;
    }

    /**
     * Accesseur de la version de l'obstacle
     * @return La version de l'obstacle
     */
    public int getVersion() {
        return version;
    }

    /**
     * Mutateur de la version de l'obstacle
     * @param version La nouvelle version de l'obstacle
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Accesseur de la version par défault de l'obstacle
     * @return La version par défault de l'obstacle
     */
    public int getVersionDefault() {
        return versionDefault;
    }

    /**
     * Accesseur de la difficulté de l'obstacle
     * @return La difficulté de l'obstacle
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Mutateur de la difficulté de l'obstacle
     * @param difficulty La nouvelle difficulté de l'obstacle
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Accesseur de l'ensemble des couleurs utiliser par l'obstacle
     * @return
     */
    public List<Color> getColor_use() {
        return color_use;
    }

    /**
     * Accesseur du type du modèle de l'obstacle
     * @return
     */
    public ObstacleType getType() {
        return type;
    }

    /**
     * Accesseur de la hauteur maximale de l'obstacle
     * @return La hauteur maximale de l'obstacle
     */
    public abstract double getObstacleHeight();


}
