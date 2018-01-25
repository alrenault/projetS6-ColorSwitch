package game.path;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Linee extends Shape {


	private int length;
	private int nbr_seg;
	
	
	public Linee(int x, int y, int length, int width/*, Color color*/){
	super(x, y, width,true,false,1);
		this.length = length;
		nbr_seg = 1;
		this.shape = buildLine();

	}

	public Linee(int x, int y, int length, int width,int _nbr_seg){
		super(x, y, width,true,false,1);
		this.length = length;
		nbr_seg = _nbr_seg;
		this.shape = buildLine();
	}


	public Linee(int x, int y, int width, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed, int length, double speed, int nbr_seg) {
		super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed);
		this.length = length;
		this.nbr_seg = nbr_seg;
	}


	private Group buildLine() {
		Group line = new Group();
		
		for(int i=0; i<nbr_seg; i++){
			Rectangle rec = new Rectangle(x + length * i, y, length, width);
			rec.setFill(coloRand());
			line.getChildren().add(rec);
		}

		
		TranslateTransition tt1 = new TranslateTransition(Duration.seconds(mouvementSpeed),line);
		tt1.setByX(400f);

		tt1.setCycleCount((int)Double.POSITIVE_INFINITY);

		tt1.setAutoReverse(true);

		if (!acceleration) tt1.setInterpolator(Interpolator.LINEAR);

		tt1.play();
		
		return line;
		
	}


	@Override
	public boolean isOver(int x, int y) {
		//TODO
		return false;
	}
}
