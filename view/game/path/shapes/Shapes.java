package view.game.path.shapes;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import model.modelShape.ModelShape;
import view.game.path.Element;

/**
 * Une Shapes représent un group de shapes de JavaFX
 * Le but est de représenter une forme concrete pouvant etre utilise pour les obstacles, items ou ennemis
 */

public class Shapes extends Element {

    // protected double x;
    // protected double y;
    /**
     * Patron de la forme
     */
    private static ModelShape model_shape;

    //protected Bounds coord;

    // double width;

    // boolean mouvementDirection;

    //boolean acceleration;

    //int pos_color;

    //double mouvementSpeed;

    //List<Color> colors;

    //List<Color> colors_use;
    /**
     * Le groupe représentant la forme
     */
    Group group_shape;
    /**
     * Objet permettant de manipuler les coordonnees (et la largeur et hauteur) de la forme)
     */
    Bounds coord;


    /**
     */
   /* protected Shapes(double x, double y, double width, boolean mouvementDirection, boolean acceleration, Speed s, List<Color> colors, int pos_color) {
        super();
    	this.x = x;
        this.y = y;
        this.width = width;

        this.mouvementDirection = mouvementDirection;
        this.acceleration = acceleration;
        switch (s) {
            case SYMPA:
                mouvementSpeed = 6.0;
                break;
            case MOYEN:
                mouvementSpeed = 4.5;
                break;
            case HARD:
                mouvementSpeed = 3.0;
                break;
            case TRESSYMPA:
                mouvementSpeed = 7.0;
                break;
            case NONE:
                mouvementSpeed = 0.0;
                break;
        }

        this.colors = colors;
        if (pos_color <= 0)
            this.pos_color = 0;
        else {
            this.pos_color = pos_color % colors.size();
        }
        this.colors_use = new ArrayList<>();
        //this.shape = build();
        //check();

    }*/

    Shapes(ModelShape modelShape) {
        super();
        model_shape = modelShape;
        //group_shape = buildShape();

    }

	/* public double getSize() {
        return width;
    }*/

    /**
     * Génère la forme
     *
     * @return Le Group représentant la forme
     */
   /* protected Group build() {
    	return buildShape();
    }

    public Group buildShape() {
    	Group shape;
    	
    	switch(model_shape.getType()) {
    		case Circle:
    			shape = Circle.build((ModelCircle) model_shape);
    			break;
    		
    		case Cross:
    			shape = Cross.build((ModelCross) model_shape);
    			break;
    			
    		case Square:
    			shape = Square.build((ModelSquare) model_shape);
    			break;
    		
    		case Triangle:
    			shape = Triangle.build((ModelTriangle) model_shape);
    			break;
    			
    		case Horizontal_Line:
    			shape = Linee.build((ModelHLine) model_shape);
    			break;
    			
    		case Vertical_Line:
    			shape = VerticalLine.build((ModelVLine) model_shape);
    			break;
    			
    			
    		default:
    			shape = new Group();
    			break;
    		
    	}
    	
    	return shape;
    }*/
    public Bounds getCoord() {
        return coord;
    }

    public void setCoord(Bounds coord) {
        this.coord = coord;
    }

    /**
     * Assesseur de la coordonée en x de la forme
     *
     * @return La coordonnée en x de la forme
     */
    private double getX() {
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }


    /**
     * Assesseur de la coordonée en y de la forme
     *
     * @return La coordonnée en y de la forme
     */
    private double getY() {
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    /**
     * Assesseur des coordonnees de la forme sous la forme d'un Point2D
     *
     * @return Les coordonnees de ka forme
     */
    public Point2D getCoord2D() {
        return new Point2D(getX(), getY());
    }

    /**
     * @param _x
     * @param _y
     * @return
     */
    public boolean isOver(double _x, double _y) {
        return this.group_shape.contains(_x, _y);
        //return this.shape.intersects(getX(),getY(),coord.getSize(),coord.getHeight());
    }

    /**
     * Retourne le groupe correspondant a la forme
     *
     * @return Le groupe correspondant a la forme
     */
    public Group getShape() {
        return group_shape;
    }

    @Override
    protected Group build() {
        // TODO Auto-generated method stub
        return null;
    }
}
