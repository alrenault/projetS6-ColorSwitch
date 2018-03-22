package view.game.path.shapes;

import javafx.scene.Group;
import model.modelShape.ModelCircle;
import model.modelShape.ModelCross;
import model.modelShape.ModelHLine;
import model.modelShape.ModelShape;
import model.modelShape.ModelSquare;
import model.modelShape.ModelTriangle;
import model.modelShape.ModelVLine;

public class BuildShape {

	public static Shapes constructShape(ModelShape model_shape){
		
		Shapes shape;
    	
    	switch(model_shape.getType()) {
    		case Circle:
    			shape = new Circle((ModelCircle) model_shape);
    			break;
    		
    		case Cross:
    			shape = new Cross((ModelCross) model_shape);
    			break;
    			
    		case Square:
    			shape = new Square((ModelSquare) model_shape);
    			break;
    		
    		case Triangle:
    			shape = new Triangle((ModelTriangle) model_shape);
    			break;
    			
    		case Horizontal_Line:
    			shape = new Linee((ModelHLine) model_shape);
    			break;
    			
    		case Vertical_Line:
    			shape = new VerticalLine((ModelVLine) model_shape);
    			break;
    			
    		default :
    			shape = new Shapes(model_shape);
    	}
    	
    	return shape;
	}
}
