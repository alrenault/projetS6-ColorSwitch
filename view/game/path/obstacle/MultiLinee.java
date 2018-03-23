package view.game.path.obstacle;

import view.game.Difficulty;
import view.game.path.shapes.BuildShape;
import view.game.path.shapes.Shapes;
import view.game.Speed;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import model.modelObstacle.ModelMultiLine;
import model.modelObstacle.ModelObstacle;
import model.modelShape.ModelShape;
import model.modelShape.ModelVLine;
import model.modelShape.ModelHLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MultiLinee extends Obstacle {
	/*
	version 0 : 1 segment commençant de la gauche
	version 1 : 1 segment commençant de la droite
	version 2 : 2 segments 
	version 3 : 1 ligne faisant des allés-retours
	version 4 : 1 ligne allant de la gauche vers la droite
	version 5 : 1 ligne allant de la gauche vers la droite et 1 ligne allant de la droite vers la gauche
	version 6 : 1 ligne allant de la gauche vers la droite et 1 ligne allant de la droite vers la gauche avec un espace
	version 7 : 2 barres verticales faisant des aller-retour
	version 8 : 2 barres partant des 2 côtés faisant des aller-retour
	version 9 : ligne + une barre verticale au dessus et en dessous faisant des allez-retour
	version 10 : 4 barres verticales des 2 côtés faisant les allez-retour
	*/

    

    public MultiLinee(ModelMultiLine mml) {
        super(mml);
    }

    

    protected Group buildObstacle(ModelObstacle mo) {

        double length = 100.0;
        double width = 20.0;
        double separation = 300;
        Group multiLinee = new Group();
        
        double y = mo.getY();
        List<Color> colors = mo.getColors();
        
       // Scene scene = ((ModelMultiLine) mo).getScene();
        double scWidth = ((ModelMultiLine) mo).getScWidth();
        
        Shapes s;
        
        List<ModelShape> modelC = new ArrayList<>();
        
        Random r = new Random();
        int colorDeb = r.nextInt(colors.size());
        int colorOppose = (colorDeb+colors.size()/2) % colors.size();
        int colorRand = r.nextInt(colors.size());


		/*public Linee(int x, int y,int length, int width, boolean acceleration,
				boolean reverse,int _mouvementSpeed, int nbr_seg, Color[] colors, int pos_colors,int goal) {*/
        if(mo.getVersion() >= ModelMultiLine.NBR_VERSIONS)
            mo.setVersion(mo.getVersionDefault());

        switch (mo.getVersion()) {
            case 0:
                modelC.add(new ModelHLine(-length, y, length, width, false, true, Speed.HARD, 1, colors, colorDeb, (int) scWidth + length));
            	color_passable.addAll(colors);
            	
            	mo.setDifficulty(Difficulty.EASY);
                break;
                
            case 1:
            	modelC.add(new ModelHLine((int) scWidth, y, length, width, false, true, Speed.MOYEN, 1, colors, colorDeb, -((int) scWidth + length)));
            	color_passable.addAll(colors);

            	mo.setDifficulty(Difficulty.EASY);
                break;
                
            case 2:
            	modelC.add(new ModelHLine((int) scWidth, y, length, width, false, true, Speed.MOYEN, 1, colors, colorDeb, -((int) scWidth + length)));
            	modelC.add(new ModelHLine(-length, y + width, length, width, false, true, Speed.HARD, 1, colors, colorRand, (int) scWidth + length));
            	color_passable.addAll(colors);

            	mo.setDifficulty(Difficulty.NORMAL);
                break;
                
            case 3:
            	modelC.add(new ModelHLine((-length) * 4, y, length, width, false, true, Speed.SYMPA, (int) scWidth / (int) length + 4, colors, colorDeb, length * 4));
            	color_passable.addAll(colors);

            	mo.setDifficulty(Difficulty.NORMAL);
                break;
                
            case 4:
            	modelC.add(new ModelHLine(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scWidth / (int) length + 4, colors, colorDeb, length * 4));
            	color_passable.addAll(colors);

            	mo.setDifficulty(Difficulty.EASY);
                break;
                
           case 5:
            	modelC.add(new ModelHLine(-150 * 4, y, 150, width, false, false, Speed.SYMPA, (int) scWidth / 150 + 4, colors, colorDeb, 150 * 4));
            	modelC.add(new ModelHLine(0, y + width, 150, width, false, false, Speed.SYMPA, (int) scWidth / 150 + 4, colors,(colorDeb+1)%colors.size(), -(150 * 4)));
            	color_passable.add(colors.get((colorDeb+1)%colors.size()));
            	color_passable.add(colors.get((colorDeb+1)%colors.size()));
            	
            	mo.setDifficulty(Difficulty.NORMAL);
                break;
               
            case 6:
            	modelC.add(new ModelHLine(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scWidth / (int) length + 4, colors, colorDeb, length * 4));
            	modelC.add(new ModelHLine(0, y + width + 120, length, width, false, false, Speed.SYMPA, (int) scWidth / (int) length + 4, colors, colorRand, -(length * 4)));
            	color_passable.addAll(colors);

            	mo.setDifficulty(Difficulty.NORMAL);
                break;
                
            case 7:
            	modelC.add(new ModelVLine(-width * 2 - separation, y, length, width, separation, false, true, Speed.SYMPA, 2, colors, colorDeb, (scWidth + 2 * width + separation)));
            	color_passable.addAll(colors);
            	
            	mo.setDifficulty(Difficulty.EASY);
                break;

            case 8:
            	modelC.add(new ModelVLine(-width * 2 - separation, y, length, width, separation, false, true, Speed.SYMPA, 2, colors, colorDeb, (scWidth + 2 * width + separation)));
            	modelC.add(new ModelVLine(scWidth, y, length, width, separation, false, true, Speed.SYMPA, 2, colors, colorRand, -(scWidth + width * 2 + separation)));
            	color_passable.addAll(colors);

            	mo.setDifficulty(Difficulty.NORMAL);
                break;

            case 9:
            	modelC.add(new ModelHLine(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scWidth / (int) length + 4, colors, colorDeb, length * 4));
            	modelC.add(new ModelVLine(-width, y - length, length, width, separation, false, true, Speed.SYMPA, 1, colors, colorDeb, (scWidth + width)));
            	modelC.add(new ModelVLine(scWidth, y + width, length, width, separation, false, true, Speed.SYMPA, 1, colors, colorRand, -(scWidth + width)));
            	color_passable.addAll(colors);

            	mo.setDifficulty(Difficulty.HARD);
                break;
                
            case 10:
            	modelC.add(new ModelVLine(-width * 4 - separation * 3, y, length, width, separation, false, true, Speed.MOYEN, 4, colors, colorDeb, (scWidth + 4 * width + separation*3)));
            	modelC.add(new ModelVLine(scWidth, y, length, width, separation, false, true, Speed.MOYEN, 4, colors, colorRand, -(scWidth + width * 4 + separation*3)));
            	color_passable.addAll(colors);

            	mo.setDifficulty(Difficulty.HARD);
            	break;
            	
           default:
            	modelC.add(new ModelHLine(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scWidth / (int) length + 4, colors, colorDeb, length * 4));
            	color_passable.addAll(colors);

            	mo.setDifficulty(Difficulty.EASY);
        }
        
        for(ModelShape ms : modelC){
        	s = BuildShape.constructShape(ms);
            addSL(s.getShapeList());  
            multiLinee.getChildren().add(s.getShape());
            mo.getColor_use().addAll(ms.getColors_use());
        }
        

        return multiLinee;

    }
    

}
