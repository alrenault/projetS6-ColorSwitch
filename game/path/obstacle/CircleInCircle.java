package game.path.obstacle;

import game.Difficulty;
import game.path.shapes.BuildShape;
import game.path.shapes.Circle;
import game.Speed;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.modelShape.ModelCircle;

import java.util.List;
import java.util.Random;


public class CircleInCircle extends Obstacle {
	/*
	version 0 : 2 cercles imbriqués 
	version 1 : 2 cercles imbriqués dans autre sens 
	version 2 : 3 cercles imbriqués
	version 3 : 3 cercles imbriqués dans l'autre sens
	version 4 : 2 cercle croisés tournant vers le haut
	version 5 : 2 cercle croisés tournant vers le bas
	version 6 : petit cercle dans un grand cercle
	default : version 4
	*/

    public static final int NBR_VERSIONS = 7;
    protected static int[] versionEasy = {4, 5};
    protected static int[] versionMedium = {0, 1, 6};
    protected static int[] versionHard = {2, 3};

    public CircleInCircle(double x, double y, List<Color> colors, int version) {
        super(x, y, colors, version, 4);
        obstacle = buildObstacle();
    }

    public CircleInCircle(double x, double y, List<Color> colors, Difficulty difficulty) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = CircleInCircle.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = CircleInCircle.getRandomMediumVersion();
        else
            version = CircleInCircle.getRandomHardVersion();
        obstacle = buildObstacle();
    }

    public static int getRandomEasyVersion() {
        Random r = new Random();
        return versionEasy[r.nextInt(versionEasy.length)];
    }

    public static int getRandomMediumVersion() {
        Random r = new Random();
        return versionMedium[r.nextInt(versionMedium.length)];
    }

    public static int getRandomHardVersion() {
        Random r = new Random();
        return versionHard[r.nextInt(versionHard.length)];
    }

    protected Group buildObstacle() {
        double tinyRadial = 60.0;
        double mediumRadial = 70.0;
        double internRadial = 85.0;
        double bigRadial = 100.0;
        double width = 15.0;
        int nb_arc = 4;
        
        //BuildShape builder = new BuildShape();
        
        Group circleInCircle = new Group();
        Circle cer1;
        Circle cer2;
        Circle cer3;
        
        ModelCircle model1 = null;
        ModelCircle model2 = null;
        ModelCircle model3 = null;

        if (version >= NBR_VERSIONS)
            version = versionDefault;

        //double xCenter, double yCenter, double radial, double width, int arcs_nbr, boolean rotationDirection,
        //boolean acceleration, Speed vitesseRotation, List<Color> colors, int pos_color
        
        switch (version) {

            case 0:
            	model1 = new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
            	model2 = new ModelCircle(x, y, internRadial, width, nb_arc, false, false, Speed.MOYEN, colors, 3);
                
                difficulty = Difficulty.NORMAL;
                break;

            case 1:
            	model1 = new ModelCircle(x, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
            	model2 = new ModelCircle(x, y, internRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 3);
                
                difficulty = Difficulty.NORMAL;
                break;

            case 2:
            	model1 = new ModelCircle(x, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
            	model2 = new ModelCircle(x, y, internRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 1);
            	model3 = new ModelCircle(x, y, mediumRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 1);
                
                difficulty = Difficulty.HARD;
                break;

            case 3:
            	model1 = new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
            	model2 = new ModelCircle(x, y, internRadial, width, nb_arc, false, false, Speed.MOYEN, colors, 3);
            	model3 = new ModelCircle(x, y, mediumRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
                
                difficulty = Difficulty.HARD;
                break;

            case 4:
            	model1 = new ModelCircle(x - bigRadial / 2, y, bigRadial, width, nb_arc, false, false, Speed.SYMPA, colors, 0);
            	model2 = new ModelCircle(x + bigRadial / 2, y, bigRadial, width, nb_arc, true, false, Speed.MOYEN, colors, 2);
                
                difficulty = Difficulty.EASY;
                break;

            case 5:
            	model1 = new ModelCircle(x - bigRadial / 2, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 0);
            	model2 = new ModelCircle(x + bigRadial / 2, y, bigRadial, width, nb_arc, false, false, Speed.MOYEN, colors, 2);
                
                difficulty = Difficulty.NORMAL;
                break;

            case 6:
            	model1 = new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
            	model2 = new ModelCircle(x, y, mediumRadial, width, nb_arc, false, false, Speed.MOYEN, colors, 3);
                
                difficulty = Difficulty.NORMAL;
                break;

            default:
            	model1 = new ModelCircle(x, y, bigRadial, width, nb_arc, true, false, Speed.SYMPA, colors, 1);
              
                difficulty = Difficulty.EASY;

        }
        if(model1 != null){
        	cer1 = (Circle)BuildShape.constructShape(model1);
            addSL(cer1.getShapeList());  
            circleInCircle.getChildren().add(cer1.getShape());
            color_use.addAll(model1.getColors_use());
        }
        if(model2 != null){
        	cer2 = (Circle)BuildShape.constructShape(model2);
            addSL(cer2.getShapeList());  
            circleInCircle.getChildren().add(cer2.getShape());
            color_use.addAll(model2.getColors_use());
        }
        if(model3 != null){
        	cer3 = (Circle)BuildShape.constructShape(model3);
            addSL(cer3.getShapeList());  
            circleInCircle.getChildren().add(cer3.getShape());
            color_use.addAll(model3.getColors_use());
        }
        return circleInCircle;

    }







}
