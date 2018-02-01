package game.path;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class MultiCross extends Obstacle {
	/*
	version 0 : Une croix décalée vers la droite
	version 1 : Une croix décalée vers la gauche
	version 2 : Deux croix tournant vers le bas
	version 3 : Deux croix tournant vers le haut
	*/

    public MultiCross(double x, double y, Color[] colors, int version) {
        super(x, y, colors, version);
        obstacle = buildObstacle();
    }

    private Group buildObstacle() {
        Group multiCross = new Group();
        double length = 100.0;
        double width = 15.0;
        int nbr_versions = 5;

		
		/*public Cross(int x, int y, int width, int length, boolean mouvementDirection, boolean acceleration, 
			int _mouvementSpeed, int nbr_rect,Color[] colors,int pos_color)*/

        Cross cr1;
        Cross cr2;

        if (version >= nbr_versions)
            version = 0;

        switch (version) {
            case 0:
                cr1 = new Cross(x + length / 2, y, length, width, true, false, 1, 4, colors, 0);
                multiCross.getChildren().add(cr1.getShape());
                difficulty = ensDifficulty.EASY;
                break;
            case 1:
                cr1 = new Cross(x - length / 2, y, length, width, true, false, 1, 4, colors, 0);
                multiCross.getChildren().add(cr1.getShape());
                difficulty = ensDifficulty.EASY;
                break;
            case 2:
                cr1 = new Cross(x + length + width / 2, y, length, width, true, false, 2, 4, colors, 0);
                cr2 = new Cross(x - length - width / 2, y, length, width, true, false, 2, 4, colors, 2);

                multiCross.getChildren().add(cr1.getShape());
                multiCross.getChildren().add(cr2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
            case 3:
                cr1 = new Cross(x + length + width / 2, y, length, width, false, false, 2, 4, colors, 0);
                cr2 = new Cross(x - length - width / 2, y, length, width, false, false, 2, 4, colors, 2);

                multiCross.getChildren().add(cr1.getShape());
                multiCross.getChildren().add(cr2.getShape());
                difficulty = ensDifficulty.NORMAL;
                break;
            case 4:
                cr1 = new Cross(x + length / 2 + 3 * width, y, length, width, true, false, 1, 4, colors, 0);
                cr2 = new Cross(x - length / 2, y, length, width, true, false, 1, 4, colors, 2);
                multiCross.getChildren().add(cr1.getShape());
                multiCross.getChildren().add(cr2.getShape());
                difficulty = ensDifficulty.HARD;

                break;
        }
        return multiCross;
    }

}
