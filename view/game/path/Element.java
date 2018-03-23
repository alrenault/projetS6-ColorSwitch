package view.game.path;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public abstract class Element {
    /**
     *
     */
    private Group shape;
    /**
     *
     */
    private List<Shape> shape_list;

    /**
     *
     */
    protected Element() {
        //shape = new Group();
        shape_list = new ArrayList<>();
    }


    protected abstract Group build();


    public abstract Group getShape();

    public List<Shape> getShapeList() {
        return shape_list;
    }

    protected void addSL(Shape... shapes) {

        if (shapes != null) {
            if (shape_list == null) shape_list = new ArrayList<>();
            shape_list.addAll(Arrays.asList(shapes));
        }

    }


    protected void addSL(List<Shape>... shapes_list) {


        if (shapes_list != null) {
            if (shape_list == null) shape_list = new ArrayList<>();
            for (List<Shape> j : shapes_list) {
                shape_list.addAll(j);

            }
        }

    }

    public void removeSL(Shape... shapes) {

        if (shapes != null) {
            if (shape_list == null) shape_list = new ArrayList<>();
            for (Shape j : shapes) {
                shape_list.remove(j);
            }
        }

    }


    public void removeSL(List<Shape>... shapes_list) {

        if (shapes_list != null) {
            if (shape_list == null) shape_list = new ArrayList<>();
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
        assert (shape != null);
        assert (shape_list != null);
    }

}
