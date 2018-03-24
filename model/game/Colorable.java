package model.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.Random;

/**
 * Cette interface défini un ensemble de couleurs utilisées par l'application
 */
public interface Colorable {
    Color BLACK = Color.rgb(39, 39, 39);
    Color YELLOW = Color.rgb(255, 255, 0);
    Color PURPLE = Color.rgb(144, 13, 255);
    Color ROSE = Color.rgb(255, 1, 129);
    Color BLUE = Color.rgb(50, 219, 240);

    Color BRONZE = Color.rgb(97, 78, 26);
    Color SILVER = Color.rgb(206, 206, 206);
    Color GOLD = Color.rgb(255, 215, 0);

    Color WHITE = Color.rgb(255, 255, 255);

    /**
     *Vérifie si la pos_color reste dans la taille de colors après incrémentation
     */
    void verifPosColor();

    /**
     * Colorie une (JavaFX) Shape en fonction de l'ensemble de couleurs qui lui est associe
     * @param s La (JavaFX) Shape a colorier
     */
    void color(Shape s);
}
