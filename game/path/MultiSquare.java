package game.path;

import game.Colorable;
import game.path.Obstacle.ensDifficulty;
import javafx.scene.Group;
import javafx.scene.paint.Color;


public class MultiSquare extends Obstacle {
	/*
	 version 0 : petit rectangle tournant dans le sens contre horraire
	 version 1 : petit rectangle tournant dans le sens horraire
	 version 2 : rectangle de taille normal tournant dans le sens contre horraire
	 version 3 : rectangle de taille normal tournant dans le sens horraire
	 version 4 : un rectangle moyen dans un grand rectangle tournant dans des sens contraire
	 version 5 :
	 */

    public MultiSquare(double x, double y, Color[] colors, int version) {
        super(x, y, colors, version, 2);
        obstacle = buildObstacle();
    }

    public Group buildObstacle() {
        Group multiShapes = new Group();

        double tinyLength = 100.0;
        double mediumLength = 200.0;
        double bigLength = 300.0;
        double width = 15.0;
        int nbr_versions = 5;
        
        //public Square(double x, double y, double length, double width,
		//boolean mouvementDirection, boolean acceleration,int mouvementSpeed,Color[] colors, int pos_color)
        Square squa1;
        Square squa2;
        
        if (version >= nbr_versions)
            version = versionDefault;

        switch (version) {
            case 0:
            	squa1 =  new Square(x, y, tinyLength, width,false,false,1 ,Colorable.normal, 0);
            	multiShapes.getChildren().add(squa1.getShape());
            	difficulty = ensDifficulty.NORMAL;
                break;
            case 1:
            	squa1 =  new Square(x, y, tinyLength, width,true,false,1 ,Colorable.normal, 0);
            	multiShapes.getChildren().add(squa1.getShape());
            	difficulty = ensDifficulty.NORMAL;
                break;
            case 2:
            	squa1 =  new Square(x, y, mediumLength, width,false,false,1 ,Colorable.normal, 0);
            	multiShapes.getChildren().add(squa1.getShape());
            	difficulty = ensDifficulty.EASY;
                break;
            case 3:
            	squa1 =  new Square(x, y, mediumLength, width,true,false,1 ,Colorable.normal, 0);
            	multiShapes.getChildren().add(squa1.getShape());
            	difficulty = ensDifficulty.EASY;
                break;
            case 4:
            	squa1 =  new Square(x, y, mediumLength, width,false,false,1 ,Colorable.normal, 0);
            	squa2 =  new Square(x, y, bigLength, width,true,false,2, Colorable.normal, 2);
            	
            	multiShapes.getChildren().add(squa1.getShape());
            	multiShapes.getChildren().add(squa2.getShape());                
            	difficulty = ensDifficulty.HARD;
                break;
        }

        return multiShapes;
    }
}
