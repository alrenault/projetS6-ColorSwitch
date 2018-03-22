package view.game.path.shapes;

import view.game.Colorable;
import view.game.path.Element;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.modelShape.ModelCircle;
import model.modelShape.ModelCross;
import model.modelShape.ModelHLine;
import model.modelShape.ModelShape;
import model.modelShape.ModelSquare;
import model.modelShape.ModelTriangle;
import model.modelShape.ModelVLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Une Shapes représent un group de shapes de JavaFX
 * Le but est de représenter une forme concrete pouvant etre utilise pour les obstacles, items ou ennemis
 */

public class Shapes extends Element{

	/**
     *Coordonnée en x du centre de la forme
     */
   // protected double x;
    /**
     *Coordonnée en y du centre de la forme
     */
   // protected double y;
    /**
     * Le groupe représentant la forme
     */
    protected Group group_shape;
    
    /**
     * Objet permettant de manipuler les coordonnees (et la largeur et hauteur) de la forme) 
     */
    //protected Bounds coord;
    
    /**
     * L'épaisseur du trait de la forme
     */
    
   // double width;
    
    /**
     * Indique la direction du mouvement de la forme
     */
    
   // boolean mouvementDirection;
    /**
     * Indique si la rotation de la forme est linéaire ou est soumise à une accéleration
     */
    
    //boolean acceleration;
    
    /**
     * Position actuelle pour le parcours de la liste de couleurs
     */
    //int pos_color;
    
    /**
     * Vitesse de rotation de la forme
     */
    //double mouvementSpeed;
    
    /**
     * L'ensemble de couleurs que l'on peut utiliser
     */
    //List<Color> colors;
    
    /**
     * L'ensemble des couleurs utilisées par la forme
     */
    //List<Color> colors_use;
    
    /**
     * Patron de la forme
     */
    static ModelShape model_shape;
    
    /**
     * Objet permettant de manipuler les coordonnees (et la largeur et hauteur) de la forme) 
     */
    protected Bounds coord;
    


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
    
    protected Shapes(ModelShape modelShape) {
    	super();
    	model_shape = modelShape;
    	//group_shape = buildShape();
    	
    }

	/**
     * Assesseur de l'épaisseur de la forme
     * @return l'épaisseur de la forme
     */
   /* public double getSize() {
        return width;
    }*/

    /**
     * Génère la forme
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
     * @return La coordonnée en x de la forme
     */
    public double getX() {
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
        return coord.getMinX() + coord.getWidth() / 2;
    }


    /**
     * Assesseur de la coordonée en y de la forme
     * @return La coordonnée en y de la forme
     */
    public double getY() {
        coord = group_shape.localToScene(group_shape.getBoundsInLocal());
        return coord.getMinY() + coord.getHeight() / 2;
    }

    /**
     * Assesseur des coordonnees de la forme sous la forme d'un Point2D
     * @return Les coordonnees de ka forme
     */
    public Point2D getCoord2D() {
        return new Point2D(getX(), getY());
    }
    /**
     * 
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
