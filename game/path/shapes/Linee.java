package game.path.shapes;

import java.util.List;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * Objet graphique d'une ligne horizontale
 */
public class Linee extends Shapes {

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
     * Constructeur d'une ligne
     * @param x Coordonnée en x de la ligne
     * @param y Coordonnée en y de la ligne
     * @param length La longueur d'un rectangle
     * @param width La largeur d'un rectangle
     * @param acceleration Active l'accélération de l'animation
     * @param reverse Active les allez-retour
     * @param _mouvementSpeed La vitesse du mouvement
     * @param nbr_seg Le nombre de rectangle pour la ligne
     * @param colors L'ensemble de couleurs que l'on peut utiliser
     * @param pos_colors La position de départ dans la liste
     * @param goal Le point d'arrivée pour l'animation
     */
    public Linee(double x, double y, double length, double width, boolean acceleration
            , boolean reverse, Speed _mouvementSpeed/*, double speed*/, int nbr_seg, List<Color> colors, int pos_colors, double goal) {
        super(x, y, width, true, acceleration, _mouvementSpeed, colors, pos_colors);
        this.length = length;
        this.nbr_seg = nbr_seg;
        this.goal = goal;
        this.reverse = reverse;
        this.shape = build();

        //recuperation de la position
        coord = shape.localToScene(shape.getBoundsInLocal());
        
        check();
    }

    /**
     * Génère la ligne
     * @return le Group correspondant à la ligne
     */
    protected Group buildShape() {
        Group line = new Group();

        for (int i = 0; i < nbr_seg; i++) {
            verifPosColor();
            Rectangle rec = new Rectangle(x + length * i, y, length, width);
            color(rec);
            
            addSL(rec);
            line.getChildren().add(rec);
        }


        TranslateTransition tt1 = new TranslateTransition(Duration.seconds(mouvementSpeed), line);
        tt1.setByX(goal);

        tt1.setCycleCount((int) Double.POSITIVE_INFINITY);

        if (reverse)
            tt1.setAutoReverse(true);

        if (!acceleration) tt1.setInterpolator(Interpolator.LINEAR);

        tt1.play();

        return line;
    }
}
