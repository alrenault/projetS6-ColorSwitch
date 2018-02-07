package game.path.pluri;

import game.path.Linee;
import game.path.Obstacle;
import game.path.Shapes.Speed;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


public class MultiLinee extends Obstacle {
	/*
	version 0 : 1 segment commençant de la gauche
	version 1 : 1 segement commençant de la droite
	version 2 : un segment commençant de la droite + un segment rapide commençant de la gauche 
	version 3 : 1 ligne faisant des aller-retour
	version 4 : 1 ligne allant de la gauche vers la droite
	version 5 : 1 ligne allant de la gauche vers la droite et 1 ligne allant de la droite vers la gauche
	version 6 : 1 ligne allant de la gauche vers la droite et 1 ligne allant de la droite vers la gauche avec un espace
	version 7 : 2 barres verticales faisant des aller-retour
	version 8 : 2 barres partant des 2 côtés faisant des aller-retour
	version 9 : ligne + une barre verticale au dessus et en dessous faisant des allez-retour
	*/

    Scene scene;

    public MultiLinee(double x, double y, Color[] colors, int version, Scene scene) {
        super(x, y, colors, version, 4);
        this.scene = scene;
        obstacle = buildObstacle();
    }

    private Group buildObstacle() {

        double length = 100.0;
        double width = 20.0;
        int nbr_versions = 10;
        Group multiLinee = new Group();

        Linee l1;
        Linee l2;
		
		/*public Linee(int x, int y,int length, int width, boolean acceleration, 
				boolean reverse,int _mouvementSpeed, int nbr_seg, Color[] colors, int pos_colors,int goal) {*/
        if (version >= nbr_versions)
            version = versionDefault;

        switch (version) {
            case 0:
                l1 = new Linee(-length, y, length, width, false, true, Speed.HARD, 1, colors, 0, (int) scene.getWidth() + length);
                multiLinee.getChildren().add(l1.getShape());
                difficulty = ensDifficulty.EASY;
                break;
            case 1:
                l1 = new Linee((int) scene.getWidth(), y, length, width, false, true, Speed.MOYEN, 1, colors, 1, -((int) scene.getWidth() + length));
                multiLinee.getChildren().add(l1.getShape());
                difficulty = ensDifficulty.EASY;
                break;
            case 2:
                l1 = new Linee((int) scene.getWidth(), y, length, width, false, true, Speed.MOYEN, 1, colors, 1, -((int) scene.getWidth() + length));
                l2 = new Linee(-length, y + width, length, width, false, true, Speed.HARD, 1, colors, 0, (int) scene.getWidth() + length);

                multiLinee.getChildren().add(l1.getShape());
                multiLinee.getChildren().add(l2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
            case 3:
                l1 = new Linee(-length * 4, y, length, width, false, true, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                multiLinee.getChildren().add(l1.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
            case 4:
                l1 = new Linee(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                multiLinee.getChildren().add(l1.getShape());
                difficulty = ensDifficulty.EASY;

                break;
            case 5:
                l1 = new Linee(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                l2 = new Linee(0, y + width, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 1, -(length * 4));

                multiLinee.getChildren().add(l1.getShape());
                multiLinee.getChildren().add(l2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
            case 6:
                l1 = new Linee(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                l2 = new Linee(0, y + width + 80, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 1, -(length * 4));

                multiLinee.getChildren().add(l1.getShape());
                multiLinee.getChildren().add(l2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
            case 7:
            	vl1 = new VerticalLine(-width*2-separation,y,length,width,separation,false,true, 1, 2,Colorable.CUSTOM, 0,(scene.getWidth()+2*width+separation));
                multiLinee.getChildren().add(vl1.getShape());
                difficulty = ensDifficulty.EASY;
            	break;
            	
            case 8:
            	vl1 = new VerticalLine(-width*2-separation,y,length,width,separation,false,true, 1, 2,Colorable.CUSTOM, 0,(scene.getWidth()+2*width+separation));
            	vl2 = new VerticalLine(scene.getWidth(),y,length,width,separation,false,true, 1, 2,Colorable.CUSTOM, 2,-(scene.getWidth()+width*2+separation));
                multiLinee.getChildren().add(vl1.getShape());
                multiLinee.getChildren().add(vl2.getShape());
                difficulty = ensDifficulty.NORMAL;            	
            	break;
            	
            case 9:
                l1 = new Linee(-length * 4, y, length, width, false, false, 1, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                vl1 = new VerticalLine(-width,y-length,length,width,separation,false,true, 1, 1,Colorable.CUSTOM, 0,(scene.getWidth()+width));
            	vl2 = new VerticalLine(scene.getWidth(),y+width,length,width,separation,false,true, 1, 1,Colorable.CUSTOM, 2,-(scene.getWidth()+width));
            	multiLinee.getChildren().add(l1.getShape());
                multiLinee.getChildren().add(vl1.getShape());
                multiLinee.getChildren().add(vl2.getShape());
                difficulty = ensDifficulty.NORMAL;            	
                
            	break;
            default:
                l1 = new Linee(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                multiLinee.getChildren().add(l1.getShape());
                difficulty = ensDifficulty.EASY;
        }

        return multiLinee;

    }


}
