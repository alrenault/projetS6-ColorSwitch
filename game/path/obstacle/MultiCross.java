package game.path.obstacle;

import game.Difficulty;
import game.path.shapes.BuildShape;
import game.path.shapes.Circle;
import game.path.shapes.Cross;
import game.Speed;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.modelObstacle.ModelMultiCross;
import model.modelObstacle.ModelObstacle;
import model.modelShape.ModelCross;
import model.modelShape.ModelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiCross extends Obstacle {
	/*
	version 0 : Une croix décalée vers la droite
	version 1 : Une croix décalée vers la gauche
	version 2 : Deux croix tournant vers le bas
	version 3 : Deux croix tournant vers le haut
	version 4 : Deux croix au dessus de 2 autres, tournant 2 à deux dans le meme sens
	version 5 : 2 grandes croix
	*/



    public MultiCross(ModelMultiCross mmc) {
        super(mmc);
        obstacle = buildObstacle(mmc);
    }

    protected Group buildObstacle(ModelObstacle mo) {
        Group multiCross = new Group();
        double length = 100.0;
        double width = 15.0;
        
        double x = mo.getX();
        double y = mo.getY();
        List<Color> colors = mo.getColors();


		/*public Cross(int x, int y, int width, int length, boolean mouvementDirection, boolean acceleration,
			int _mouvementSpeed, int nbr_rect,Color[] colors,int pos_color)*/

        Cross cr1;
        Cross cr2;
        List<ModelShape> modelC = new ArrayList<>();

        if (mo.getVersion() >= mo.getNbr_Versions())
            mo.setVersion(mo.getVersionDefault());

        switch (mo.getVersion()) {
            case 0:
                modelC.add(new ModelCross(x + length / 2, y, length, width, false, false, Speed.SYMPA, 4, colors, 0));
                
            	mo.setDifficulty(Difficulty.EASY);                
                break;
                
            case 1:
            	modelC.add(new ModelCross(x - length / 2, y, length, width, false, false, Speed.SYMPA, 4, colors, 0));
                
            	mo.setDifficulty(Difficulty.EASY);
                break;
                
            case 2:
            	modelC.add(new ModelCross(x + length + width / 2, y, length, width, true, false, Speed.MOYEN, 4, colors, 0));
            	modelC.add(new ModelCross(x - length - width / 2, y, length, width, true, false, Speed.MOYEN, 4, colors, 2));
                
            	mo.setDifficulty(Difficulty.NORMAL);
                break;
                
            case 3:
            	modelC.add(new ModelCross(x + length + width / 2, y, length, width, false, false, Speed.MOYEN, 4, colors, 0));
            	modelC.add(new ModelCross(x - length - width / 2, y, length, width, false, false, Speed.MOYEN, 4, colors, 2));
                
            	mo.setDifficulty(Difficulty.NORMAL);
                break;
                
            case 4:
            	modelC.add(new ModelCross(x + length + width / 2, y, length, width, true, false, Speed.SYMPA, 4, colors, 0));
            	modelC.add(new ModelCross(x - length - width / 2, y, length, width, true, false, Speed.SYMPA, 4, colors, 2));
                
            	modelC.add(new ModelCross(x + length + width / 2, y - length*2 - 100, length, width, false, false, Speed.SYMPA, 4, colors, 0));
            	modelC.add(new ModelCross(x - length - width / 2, y - length*2 - 100, length, width, false, false, Speed.SYMPA, 4, colors, 2));
                
            	mo.setDifficulty(Difficulty.HARD);
                break;
                
            case 5:
            	modelC.add(new ModelCross(x + length*3 + width / 2, y, length*3, width, true, false, Speed.SYMPA, 4, colors, 0));
            	modelC.add(new ModelCross(x - length*3 - width / 2, y, length*3, width, true, false, Speed.SYMPA, 4, colors, 2));
                
            	mo.setDifficulty(Difficulty.NORMAL);
            	break;
            	
            default:
            	System.out.println("Hello");
        }
        
        for(ModelShape ms : modelC){
        	cr1 = (Cross)BuildShape.constructShape(ms);
            addSL(cr1.getShapeList());  
            multiCross.getChildren().add(cr1.getShape());
            mo.getColor_use().addAll(ms.getColors_use());
        }
        
        return multiCross;
    }

}
