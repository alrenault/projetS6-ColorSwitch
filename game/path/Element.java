package game.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

/**
 *
 */
public abstract class Element {
	/**
	 *
	 */
	protected Group shape;
	/**
	 *
	 */
	List<Shape> shape_list;

	/**
	 *
	 */
	public Element() {
		//shape = new Group();
		shape_list = new ArrayList<>();
	}
	
	
	
	
	
	
	protected abstract Group build();
	
	
	
	public abstract Group getShape();
	
	public List<Shape> getShapeList(){
		return shape_list;
	}
	
	
	protected List<Shape> addSL(Shape ... shapes) {
		
		
		
		
		if (shapes != null) {
			if(shape_list == null) shape_list = new ArrayList<>();
			for (Shape j : shapes) {
				shape_list.add(j);
			}
		}
		
		return shape_list;
	}
	

	protected List<Shape> addSL(List<Shape> ... shapes_list) {
		
		

		
		if (shapes_list != null) {
			if(shape_list == null) shape_list = new ArrayList<>();
			for (List<Shape> j : shapes_list) {
				shape_list.addAll(j);

				
			}
		}
		return shape_list;
		
	}
	
	
	
	
	
    protected void check() {
    	assert(shape != null);
    	assert(shape_list != null);
    }
	
}
