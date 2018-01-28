package game.path;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Square extends Shapes {

	private int length;

	public Square(int x, int y, int length, int width, Color[] colors, int pos_color){
		super(x, y,width,false,false,1,colors,pos_color);
		this.length = length;
		
		this.shape = buildSquare();
	}

	
	int maxwidth = 1000;
	int maxheight = 1000;


	private Group buildSquare(){
		Group squaire = new Group();
		
		int pos1_x = x-(length+width)/2;
		int pos1_y = y-(length+width)/2;
		
		int pos2_x = x-(length-width)/2-width;
		int pos2_y = y-(length+width)/2+width;
		
		int pos3_x = x-(length+width)/2+width;
		int pos3_y = y+(length+width)/2-2*width;
		
		int pos4_x = x+(length+width)/2-2*width;
		int pos4_y = y-(length+width)/2;
		
		Rectangle rec1 = new Rectangle(pos1_x,pos1_y,length-width,width);
		Rectangle rec2 = new Rectangle(pos2_x,pos2_y,width,length-width);
		Rectangle rec3 = new Rectangle(pos3_x,pos3_y,length-width,width);
		Rectangle rec4 = new Rectangle(pos4_x,pos4_y,width,length-width);
		
		
		color(rec1);
		verifPosColor();
		color(rec2);
		verifPosColor();
		color(rec3);
		verifPosColor();
		color(rec4);
		verifPosColor();
		
		squaire.getChildren().add(rec1);
		squaire.getChildren().add(rec2);
		squaire.getChildren().add(rec3);
		squaire.getChildren().add(rec4);
		
		
		RotateTransition rt = new RotateTransition(Duration.seconds(mouvementSpeed),squaire);

		rt.setByAngle(360* ((mouvementDirection)? 1 :-1 ));
		
		if(!acceleration){
			rt.setInterpolator(Interpolator.LINEAR);//pas d'acceleration grace à ca
		}


		rt.setCycleCount((int)Double.POSITIVE_INFINITY);

		rt.play();

		return squaire;


	}


	@Override
	public boolean isOver(int x, int y) {
		return false;
	}
}
