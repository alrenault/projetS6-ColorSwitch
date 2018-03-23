package view;


import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *Génère un Triangle plein
 */
class FilledTriangle {
    /**
     * @param x Coordonnée x du centre du triangle
     * @param y Coordonnée y du centre du triangle
     * @param side Longueur du coté
     * @param color Couleur du de la forme
     * @return Un polygon en Triangle de la couleur color
     */
    public static Polygon create(double x, double y, double side, Color color) {
        Polygon triangle = new Polygon();

        double p1x = x;
        double p1y = y - 2.0 / 3.0 * side * (Math.sqrt(3.0) / 2.0);

        double p2x = x + (side / 2);
        double p2y = y + 1.0 / 3.0 * side * (Math.sqrt(3.0) / 2.0);

        double p3x = x - (side / 2);
        double p3y = y + 1.0 / 3.0 * side * (Math.sqrt(3.0) / 2.0);


        triangle.getPoints().addAll(
                p1x, p1y,
                p2x, p2y,
                p3x, p3y);


        triangle.setRotate(90);

        triangle.setFill(color);

        return triangle;
    }
    
    public static Group create(double x, double y, double side, Color color, String text) {
    	Group level = new Group();
    	
    	Group labelContainer = new Group();
    	Label label = new Label(text);
    	label.setTextFill(color);
    	labelContainer.getChildren().add(label);
    	
    	labelContainer.setTranslateY(y+20);
    	labelContainer.setTranslateX(x);
    	
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
    	
    	level.getChildren().add(create(x, y, side, color));
    	
    	level.getChildren().add(labelContainer);
    	
    	return level ;
    }
}
