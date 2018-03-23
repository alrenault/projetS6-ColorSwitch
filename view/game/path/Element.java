package view.game.path;

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
	
		protected  void addSL(Shape ... shapes) {
				
				if (shapes != null) {
					if(shape_list == null) shape_list = new ArrayList<Shape>();
					for (Shape j : shapes) {
						shape_list.add(j);
					}
				}
				
			}
			
		
			protected void addSL(List<Shape> ... shapes_list) {
				
				
		
				
				if (shapes_list != null) {
					if(shape_list == null) shape_list = new ArrayList<Shape>();
					for (List<Shape> j : shapes_list) {
						shape_list.addAll(j);
						
					}
				}
				
			}
			
			public  void removeSL(Shape ... shapes) {
				
				if (shapes != null) {
					if(shape_list == null) shape_list = new ArrayList<Shape>();
					for (Shape j : shapes) {
						shape_list.remove(j);
					}
				}
				
			}
			
		
			public void removeSL(List<Shape> ... shapes_list) {
				
				if (shapes_list != null) {
					if(shape_list == null) shape_list = new ArrayList<Shape>();
					for (List<Shape> j : shapes_list) {
						shape_list.removeAll(j);
						
					}
				}
				
			}
			
			
	/*protected void addSL(Shape ... shapes) {
		
		if (shapes != null) {
			if(shape_list == null) shape_list = new ArrayList<>();
            Collections.addAll(shape_list, shapes);
		}

	}
	

	protected void addSL(List<Shape> ... shapes_list) {
		
		if (shapes_list != null) {
			if(shape_list == null) shape_list = new ArrayList<>();
			for (List<Shape> j : shapes_list) {
				shape_list.addAll(j);

				
			}
		}

	}*/
	
/*protected void removeSL(Shape ... shapes) {
		
		if (shapes != null) {
			if(shape_list == null) shape_list = new ArrayList<>();
            Collections.addAll(shape_list, shapes);
            shape_list.removeAll(shapes);
		}

	}*/
	
	
	
	
	
	
    protected void check() {
    	assert(shape != null);
    	assert(shape_list != null);
    }
	
}
