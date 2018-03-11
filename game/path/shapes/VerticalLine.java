package game.path.shapes;

import java.util.List;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Objet graphique d'une ligne verticale
 */
public class VerticalLine extends Shapes {

	/**
	 * Longueur d'un rectangle
	 */
    private double length;
    
    /**
     * Le nombre de segment formant la ligne
     */
    private int nbr_seg;
    
    /**
     * Point d'arrivée pour l'animation
     */
    private double goal;
    
    /**
     * Active les allez-retours
     */
    private boolean reverse;
    
    /**
     * La distance separant 2 segments
     */
    private double distanceSeparation;
    

    /**
     * Constructeur d'une ligne verticale
     * @param x Coordonnée en x de la ligne
     * @param y Coordonnée en y de la ligne
     * @param height La hauteur d'un rectangle
     * @param width La largeur d'un rectangle
     * @param distanceSeparation La distance separant 2 segments
     * @param acceleration Active l'accélération de l'animation
     * @param reverse Active les allez-retour
     * @param _mouvementSpeed La vitesse du mouvement
     * @param nbr_seg Le nombre de rectangle pour la ligne
     * @param colors L'ensemble de couleurs que l'on peut utiliser
     * @param pos_colors La position de départ dans la liste
     * @param goal Le point d'arrivée pour l'animation 
     */
    public VerticalLine(double x, double y, double height, double width, double distanceSeparation, boolean acceleration
            , boolean reverse, Speed _mouvementSpeed, int nbr_seg, List<Color> colors, int pos_colors, double goal) {
        super(x, y, width, true, acceleration, _mouvementSpeed, colors, pos_colors);
        this.length = height;
        this.distanceSeparation = distanceSeparation;
        this.nbr_seg = nbr_seg;
        this.goal = goal;
        this.reverse = reverse;
        this.shape = build();

        //recuperation de la position
        coord = shape.localToScene(shape.getBoundsInLocal());
        
        check();
    }


    /**
     * Génère la ligne verticale
     * @return le Group correspondant a la ligne verticale
     */
    protected Group buildShape() {
        Group hline = new Group();

        for (int i = 0; i < nbr_seg; i++) {
            verifPosColor();
            Rectangle rec = new Rectangle(x + distanceSeparation * i, y, width, length);
            color(rec);
            
            addSL(rec);
            hline.getChildren().add(rec);
        }


        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(mouvementSpeed + Math.abs(goal / 1000)), hline);
        tt1.setByX(goal);

        tt1.setCycleCount((int) Double.POSITIVE_INFINITY);

        if (reverse)
            tt1.setAutoReverse(true);

        if (!acceleration) tt1.setInterpolator(Interpolator.LINEAR);

        tt1.play();

        return hline;
    }

}
