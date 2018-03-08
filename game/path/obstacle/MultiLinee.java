package game.path.obstacle;

import game.Difficulty;
import game.path.shapes.Linee;
import game.path.shapes.Shapes.Speed;
import game.path.shapes.VerticalLine;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;


public class MultiLinee extends Obstacle {
	/*
	version 0 : 1 segment commençant de la gauche
	version 1 : 1 segment commençant de la droite
	version 2 : 1 des aller-retour
	version 4 : 1 ligne allant de la gauche vers la droite
	version 5 : 1 ligne allant de la gauche vers la droite et 1 ligne allant de la droite vers la gauche
	version 6 : 1 ligne allant de la gauche vers la droite et 1 ligne allant de la droite vers la gauche avec un espace
	version 7 : 2 barres verticales faisant des aller-retour
	version 8 : 2 barres partant des 2 côtés faisant des aller-retour
	version 9 : ligne + une barre verticale au dessus et en dessous faisant des allez-retour
	version 10 : 4 barres verticales des 2 côtés faisant les allez-retour
	*/

    public static final int NBR_VERSIONS = 11;
    protected static int[] versionEasy = {0, 1, 4, 7};
    protected static int[] versionMedium = {2, 3, 5, 6, 8};
    protected static int[] versionHard = {9, 11};
    Scene scene;

    public MultiLinee(double x, double y, List<Color> colors, int version, Scene scene) {
        super(x, y, colors, version, 4);
        this.scene = scene;
        obstacle = buildObstacle();
    }

    public MultiLinee(double x, double y, List<Color> colors, Difficulty difficulty, Scene scene) {
        super(x, y, colors, 0, 4);
        if (difficulty == Difficulty.EASY)
            version = CircleInCircle.getRandomEasyVersion();
        else if (difficulty == Difficulty.NORMAL)
            version = CircleInCircle.getRandomMediumVersion();
        else
            version = CircleInCircle.getRandomHardVersion();

        this.scene = scene;
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

    private Group buildObstacle() {

        double length = 100.0;
        double width = 20.0;
        double separation = 300;
        Group multiLinee = new Group();

        Linee l1;
        Linee l2;
        VerticalLine vl1;
        VerticalLine vl2;

		/*public Linee(int x, int y,int length, int width, boolean acceleration,
				boolean reverse,int _mouvementSpeed, int nbr_seg, Color[] colors, int pos_colors,int goal) {*/
        if (version >= NBR_VERSIONS)
            version = versionDefault;

        switch (version) {
            case 0:
                l1 = new Linee(-length, y, length, width, false, true, Speed.HARD, 1, colors, 0, (int) scene.getWidth() + length);
                multiLinee.getChildren().add(l1.getShape());
                difficulty = Difficulty.EASY;
                color_use.addAll(l1.getColors_use());
                break;
                
            case 1:
                l1 = new Linee((int) scene.getWidth(), y, length, width, false, true, Speed.MOYEN, 1, colors, 1, -((int) scene.getWidth() + length));
                multiLinee.getChildren().add(l1.getShape());
                difficulty = Difficulty.EASY;
                color_use.addAll(l1.getColors_use());
                break;
                
            case 2:
                l1 = new Linee((int) scene.getWidth(), y, length, width, false, true, Speed.MOYEN, 1, colors, 1, -((int) scene.getWidth() + length));
                l2 = new Linee(-length, y + width, length, width, false, true, Speed.HARD, 1, colors, 0, (int) scene.getWidth() + length);

                multiLinee.getChildren().add(l1.getShape());
                multiLinee.getChildren().add(l2.getShape());
                difficulty = Difficulty.NORMAL;
                color_use.addAll(l1.getColors_use());
                color_use.addAll(l2.getColors_use());
                break;
                
            case 3:
                l1 = new Linee(-length * 4, y, length, width, false, true, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                multiLinee.getChildren().add(l1.getShape());
                difficulty = Difficulty.NORMAL;
                color_use.addAll(l1.getColors_use());
                break;
                
            case 4:
                l1 = new Linee(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                multiLinee.getChildren().add(l1.getShape());
                difficulty = Difficulty.EASY;
                color_use.addAll(l1.getColors_use());
                break;
                
            case 5:
                l1 = new Linee(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                l2 = new Linee(0, y + width, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 1, -(length * 4));

                multiLinee.getChildren().add(l1.getShape());
                multiLinee.getChildren().add(l2.getShape());
                difficulty = Difficulty.NORMAL;
                color_use.addAll(l1.getColors_use());
                color_use.addAll(l2.getColors_use());
                break;
                
            case 6:
                l1 = new Linee(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                l2 = new Linee(0, y + width + 100, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 1, -(length * 4));

                multiLinee.getChildren().add(l1.getShape());
                multiLinee.getChildren().add(l2.getShape());
                difficulty = Difficulty.NORMAL;
                color_use.addAll(l1.getColors_use());
                color_use.addAll(l2.getColors_use());
                break;
                
            case 7:
                vl1 = new VerticalLine(-width * 2 - separation, y, length, width, separation, false, true, Speed.SYMPA, 2, colors, 0, (scene.getWidth() + 2 * width + separation));
                multiLinee.getChildren().add(vl1.getShape());
                difficulty = Difficulty.EASY;
                color_use.addAll(vl1.getColors_use());
                break;

            case 8:
                vl1 = new VerticalLine(-width * 2 - separation, y, length, width, separation, false, true, Speed.SYMPA, 2, colors, 0, (scene.getWidth() + 2 * width + separation));
                vl2 = new VerticalLine(scene.getWidth(), y, length, width, separation, false, true, Speed.SYMPA, 2, colors, 2, -(scene.getWidth() + width * 2 + separation));
                multiLinee.getChildren().add(vl1.getShape());
                multiLinee.getChildren().add(vl2.getShape());
                difficulty = Difficulty.NORMAL;
                color_use.addAll(vl1.getColors_use());
                color_use.addAll(vl2.getColors_use());
                break;

            case 9:
                l1 = new Linee(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                vl1 = new VerticalLine(-width, y - length, length, width, separation, false, true, Speed.SYMPA, 1, colors, 0, (scene.getWidth() + width));
                vl2 = new VerticalLine(scene.getWidth(), y + width, length, width, separation, false, true, Speed.SYMPA, 1, colors, 2, -(scene.getWidth() + width));
                multiLinee.getChildren().add(l1.getShape());
                multiLinee.getChildren().add(vl1.getShape());
                multiLinee.getChildren().add(vl2.getShape());
                difficulty = Difficulty.HARD;
                color_use.addAll(l1.getColors_use());
                color_use.addAll(vl1.getColors_use());
                color_use.addAll(vl2.getColors_use());
                break;
                
            case 10:
            	Random r = new Random();
                vl1 = new VerticalLine(-width * 4 - separation * 3, y, length, width, separation, false, true, Speed.MOYEN, 4, colors, r.nextInt(4), (scene.getWidth() + 4 * width + separation*3));
                vl2 = new VerticalLine(scene.getWidth(), y, length, width, separation, false, true, Speed.MOYEN, 4, colors, r.nextInt(4), -(scene.getWidth() + width * 4 + separation*3));
                multiLinee.getChildren().add(vl1.getShape());
                multiLinee.getChildren().add(vl2.getShape());
                difficulty = Difficulty.HARD;
                color_use.addAll(vl1.getColors_use());
                color_use.addAll(vl2.getColors_use());
            	break;
            	
            default:
                l1 = new Linee(-length * 4, y, length, width, false, false, Speed.SYMPA, (int) scene.getWidth() / (int) length + 4, colors, 0, length * 4);
                multiLinee.getChildren().add(l1.getShape());
                difficulty = Difficulty.EASY;
                color_use.addAll(l1.getColors_use());
        }

        return multiLinee;

    }
}
