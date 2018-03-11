package game.path.shapes;

import java.util.List;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**Objet graphique d'une croix
 */
public class Cross extends Shapes {
	/**
	 * Nombre de rectangle (par defaut 2. Pourra aussi valoir 4
	 */
    private int nbr_rect = 2;
    
    /**
     * Longueur d'un rectangle de la croix
     */
    private double length;
    
    /**
     * Constructeur basique de la croix (direction à true, acceleration à false, la vitesse la plus faible, et la position de la couleur à 1
     * @param x Coordonnée en x de la croix
     * @param y Coordonnée en y de la croix
     * @param width Largeur d'un rectangle
     * @param length Longueur d'un rectangle
     * @param colors L'ensemble de couleurs utilisées par la croix
     */
    public Cross(double x, double y, double width, double length, List<Color> colors) {
        super(x, y, width, true, false, Speed.SYMPA, colors, 1);
        this.length = length;
        this.shape = build();
    }

    /**
     * Constructeur plus précis de la croix
     * @param x Coordonnée en x de la croix
     * @param y Coordonnée en y de la croix
     * @param width Largeur d'un rectangle
     * @param length Longueur d'un rectangle
     * @param mouvementDirection Direction du mouvement (true sens horraire, false contre-horraire)
     * @param acceleration Permet d'activer ou de désactiver l'accélération de la croix
     * @param _mouvementSpeed La vitesse de la croix
     * @param nbr_rect Le nombre de rectangle (2 ou 4)
     * @param colors L'ensemble de couleurs que l'on peut utiliser
     * @param pos_color La position initiale pour le parcours de la liste
     */
    public Cross(double x, double y, double width, double length, boolean mouvementDirection, boolean acceleration,
                 Speed _mouvementSpeed, int nbr_rect, List<Color> colors, int pos_color) {

        super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed, colors, pos_color);
        if (nbr_rect != 2)
            this.nbr_rect = 4;

        this.length = length;
        this.shape = build();

        //recuperation de la position
        coord = shape.localToScene(shape.getBoundsInLocal());
        
        check();
    }

    /**
     * Génère la croix
     * @return le Group correspondant à la croix
     */
    protected Group buildShape() {

        //Initialisation
        Group croix = new Group();
        double rad = width;
        double len = length;

        //Computing hight-left corner of the first rectangle
        double x_pos_1 = x - width - length / 2;
        double y_pos_1 = y - length / 2;

        //Computing hight-left corner of the second rectangle
        double x_pos_2 = x - length / 2;
        double y_pos_2 = y - width - length / 2;

        //Computing hight-left corner of the second rectangle
        double x_pos_3 = x + length / 2;
        double y_pos_3 = y - length / 2;

        //Computing hight-left corner of the second rectangle
        double x_pos_4 = x - length / 2;
        double y_pos_4 = y + length / 2;

        double x_middle = x - length / 2;
        double y_middle = y - length / 2;

        //Building Cross
        Rectangle part_1 = new Rectangle(x_pos_1, y_pos_1, rad, len);
        Rectangle part_2 = new Rectangle(x_pos_2, y_pos_2, len, rad);
        Rectangle part_3 = new Rectangle(x_pos_3, y_pos_3, rad, len);
        Rectangle part_4 = new Rectangle(x_pos_4, y_pos_4, len, rad);
        Rectangle middle = new Rectangle(x_middle, y_middle, len, len);
        middle.setFill(Color.WHITE);

        if (nbr_rect == 4) {
            color(part_1);
            verifPosColor();

            color(part_2);
            verifPosColor();

            color(part_3);
            verifPosColor();

            color(part_4);
            verifPosColor();

        } else {
            color(part_1);
            color(part_3);
            verifPosColor();

            color(part_2);
            color(part_4);
            verifPosColor();
        }
        
        addSL(part_1,part_2,part_3,part_4,middle);

        croix.getChildren().add(part_1);
        croix.getChildren().add(part_2);
        croix.getChildren().add(part_3);
        croix.getChildren().add(part_4);
        croix.getChildren().add(middle);


        RotateTransition rt1 = new RotateTransition(Duration.seconds(mouvementSpeed), croix);

        rt1.setByAngle(360 * ((mouvementDirection) ? 1 : -1));

        if (!acceleration) {
            rt1.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
        }

        rt1.setCycleCount((int) Double.POSITIVE_INFINITY);


        rt1.play();

        return croix;
    }
}
