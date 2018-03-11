package game.path.items;

import game.Colorable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BallColorSwitch extends Item implements Colorable {

    private double size;
    private int pos_color = 0;
    private List<Color> colors_use;


    public BallColorSwitch(double x, double y, List<Color> colors) {
    	super(x,y,colors);
        this.size = 12;

        this.colors_use = new ArrayList<Color>();
        item = buildItem();
    }

    public Group buildItem() {
        Group ball = new Group();

        double angle = 90;

        ArcType type = ArcType.ROUND;


        for (int i = 0; i <= 4; i++) {
            Arc arc_1 = new Arc(x, y, size, size, i * angle, angle);
            arc_1.setType(type);
            color(arc_1);
            verifPosColor();
            ball.getChildren().add(arc_1);
            addSL(arc_1);
        }

        return ball;

    }

    public void verifPosColor() {
        pos_color++;
        //System.out.println("position " + pos_color);
        if (pos_color == colors.size())
            pos_color = 0;
    }

    public void color(Shape s) {
    	Iterator<Color> it = colors.iterator();
    	Color c = null;
    	for(int i = 0;it.hasNext() && i <= pos_color;i++){
    		c = it.next();
    	}
    	
    	if(c == null)
    		c = Color.WHITE;
        s.setFill(c);
        colors_use.add(c);
    }

	public List<Color> getColors_use() {
		return colors_use;
	}


    
    

}
