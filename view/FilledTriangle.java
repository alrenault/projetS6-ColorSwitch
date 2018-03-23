package view;


import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 */
public class FilledTriangle {
    /**
     *
     * @param x
     * @param y
     * @param side
     * @param color
     * @return
     */
	public static Polygon create(double x, double y, double side, Color color) {
		Polygon triangle = new Polygon();
		
		double p1x = x;
        double p1y = y-2.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        double p2x = x + (side/2);
        double p2y = y+1.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        double p3x = x - (side/2);
        double p3y = y+1.0/3.0 * side * (Math.sqrt(3.0)/2.0);
        
        
       
        triangle.getPoints().addAll(
               p1x, p1y, 
               p2x, p2y, 
               p3x, p3y);
        
        
        triangle.setRotate(90);
        
    	triangle.setFill(color);
    	
    	return triangle;
	}
}
