package view;


import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 */
class FilledTriangle {
    /**
     * @param x
     * @param y
     * @param side
     * @param color
     * @return
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
