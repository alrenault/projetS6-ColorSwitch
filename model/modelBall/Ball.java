package model.modelBall;

import javafx.scene.paint.Color;

/**
 *La Balle de jeu (le joueur)
 */
public class Ball {
    /**
     *
     */
    private final double jumpHeight = 50;
    /**
     *
     */
    private double x;
    private double y;
    /**
     * La taille de la Balle
     */
    private float size;
    /**
     *
     */
    private double scWidth;
    /**
     *
     */
    private double scHeight;
    /**
     * La couleur de la Balle
     */
    private Color color;
    private double vectorX = 0;
    private double vectorY = 0;

    /**
     * @param size
     * @param color
     */
    public Ball(float size, Color color) {
        this.size = size;
        this.color = color;
    }

    /**
     * @return
     */
    public double getX() {
        return x;
    }

    public void setX(double newX) {
        x = newX;
    }

    public double getY() {
        return y;
    }

    public void setY(double newY) {

        y = newY;

    }

    /**
     * @return
     */
    public double getSize() {
        return size;
    }

    /**
     * @return
     */
    public double getScWidth() {
        return scWidth;
    }

    /**
     * @return
     */
    public double getScHeight() {
        return scHeight;
    }

    /**
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * Accesseur de la valeur de hauteur de saut
     *
     * @return La hauteur de saut
     */
    public double getJumpHeight() {
        return jumpHeight;
    }

    public double addVectorX(double j) {
        return vectorX += j;
    }

    public void addVectorY(double j) {
        vectorY += j;
    }

    public double getVectorX() {
        return vectorX;
    }

    public double getVectorY() {
        return vectorY;
    }

    public void moveBall() {
        x += vectorX;
        y += vectorY;
        resetVectors();
    }

    private void resetVectors() {
        vectorX = 0;
        vectorY = 0;
    }

}
