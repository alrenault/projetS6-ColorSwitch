package game.path;

import javafx.animation.Interpolator;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Linee extends Shapes {


	private int length;
	private int nbr_seg;
	private int goal;
	private boolean reverse;
	
	
	public Linee(int x, int y, int length, int width, Color[] colors,int goal){
	super(x, y, width,true,false,1,colors,0);
		this.length = length;
		nbr_seg = 1;
		this.goal = goal;
		reverse = true;
		this.shape = buildLine();

	}

	public Linee(int x, int y, int length, int width,int _nbr_seg,Color[] colors, int goal){
		super(x, y, width,true,false,1,colors,0);
		this.length = length;
		nbr_seg = _nbr_seg;
		this.goal = goal;
		reverse = true;
		this.shape = buildLine();
	}


	public Linee(int x, int y,int length, int width/*, boolean mouvementDirection*/, boolean acceleration 
			,boolean reverse,int _mouvementSpeed/*, double speed*/, int nbr_seg, Color[] colors, int pos_colors, int goal) {
		super(x, y, width, true, acceleration, _mouvementSpeed,colors,pos_colors);
		this.length = length;
		this.nbr_seg = nbr_seg;
		this.goal = goal;
		this.reverse = reverse;
		this.shape = buildLine();
	}


	private Group buildLine() {
		Group line = new Group();
		
		for(int i=0; i<nbr_seg; i++){
			verifPosColor();
			Rectangle rec = new Rectangle(x + length * i, y, length, width);
			color(rec);
			line.getChildren().add(rec);
		}

		
		TranslateTransition tt1 = new TranslateTransition(Duration.seconds(mouvementSpeed),line);
		tt1.setByX(goal);

		tt1.setCycleCount((int)Double.POSITIVE_INFINITY);

		if(reverse)
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
