package model.modelBall;

import javafx.scene.paint.Color;

/**
 * Modèle d'une balle représentant le joueur
 */
public class Ball {
    /**
     * La hauteur d'un saut (ancienne implémentation)
     */
    private final double jumpHeight = 50;
    
    /**
     * Position en x de la balle
     */
    private double x;
    
    /**
     * Position en y de la balle
     */
    private double y;
    
    /**
     * La taille de la Balle
     */
    
    private float size;
    
    /**
     * La largeur de la scène (ancienne implémentation)
     */
    private double scWidth;

    /**
     * La hauteur de la scène (ancienne implémentation)
     */
    private double scHeight;
    
    /**
     * La couleur de la Balle
     */
    private Color color;
    
    /**
     * Le vecteur direction en x de la balle
     */
    private double vectorX = 0;
    
    /**
     * Le vecteur direction en y de la balle
     */
    private double vectorY = 0;

    /**
     * Constructeur de la balle
     * @param size Taille de la balle
     * @param color Couleur de la balle
     */
    public Ball(float size, Color color) {
        this.size = size;
        this.color = color;
    }

    /**
     * Accesseur de la position en x de la balle
     * @return La position en x de la balle
     */
    public double getX() {
        return x;
    }

    /**
     * Mutateur de la position en x
     * @param newX La nouvelle position en x
     */
    public void setX(double newX) {
        x = newX;
    }

    /**
     * Accesseur de la position en y de la balle
     * @return La position en y de la balle
     */
    public double getY() {
        return y;
    }

    /**
     * Mutateur de la position en y
     * @param newY La nouvelle position en y
     */
    public void setY(double newY) {

        y = newY;

    }

    /**
     * Accesseur de la taille de la balle
     * @return la taille de la balle
     */
    public double getSize() {
        return size;
    }

    /**
     * Accesseur de la largeur de la balle
     * @return la largeur de la balle
     */
    public double getScWidth() {
        return scWidth;
    }

    /**
     * Accesseur de la hauteur de la balle
     * @return la hauteur de la balle
     */
    public double getScHeight() {
        return scHeight;
    }

    /**
     * Accesseur de la couleur
     * @return la couleur
     */
    public Color getColor() {
        return color;
    }

    /**
     * Accesseur de la valeur de hauteur de saut
     * @return La hauteur de saut
     */
    public double getJumpHeight() {
        return jumpHeight;
    }

    /**
     * Augmente le vecteur en x d'une certaine valeur
     * @param j La valeur à ajouter
     * @return La nouvelle valeur du vecteur en x
     */
    public double addVectorX(double j) {
        return vectorX += j;
    }

    /**
     * Augmente le vecteur en y d'une certaine valeur
     * @param j La valeur à ajouter
     */
    public void addVectorY(double j) {
        vectorY += j;
    }

    /**
     * Accesseur du vecteur en x
     * @return La valeur du vecteur en x
     */
    public double getVectorX() {
        return vectorX;
    }

    /**
     * Accesseur du vecteur en y
     * @return La valeur du vecteur en y
     */
    public double getVectorY() {
        return vectorY;
    }

    /**
     * Mets à jour la position de la balle et remet les vecteurs à 0
     */
    public void moveBall() {
        x += vectorX;
        y += vectorY;
        resetVectors();
    }

    /**
     * Remet les vecteurs à 0
     */
    private void resetVectors() {
        vectorX = 0;
        vectorY = 0;
    }

}
