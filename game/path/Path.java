package game.path;

import game.Difficulty;
import game.ennemy.Ennemy;
import game.path.items.Item;
import game.path.obstacle.BuildObstacle;
import game.path.obstacle.Obstacle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Path {
    private List<Item> items;
    private List<Obstacle> obstacles;
    private List<Ennemy> ennemies;
    private Group path;
    private Difficulty gameDifficulty;
    private Scene scene;
    private Color[] colors;
    private int nbr_Obs;


    public Path(Scene scene, Color[] colors, int nbr_Obs, Difficulty gameDifficulty) {
        obstacles = new ArrayList<Obstacle>();
        ennemies = new ArrayList<Ennemy>();
        items = new ArrayList<Item>();
        this.gameDifficulty = gameDifficulty;
        this.colors = colors;
        this.scene = scene;
        this.nbr_Obs = nbr_Obs;

        path = buildPathRandom();
    }

    public Path(List<Obstacle> _obstacles, List<Ennemy> _ennemies) {
        obstacles = _obstacles;
        ennemies = _ennemies;
        path = buildPath();
    }

    private Group buildPathRandom() {
        Group newPath = new Group();
        Random r = new Random();
        int type;
        int variante;
        double posY = scene.getHeight() / 3;
        double posX = scene.getWidth() / 2;
        Difficulty obstacleDifficulty;

        BuildObstacle bo = new BuildObstacle();

        for (int i = 0; i < nbr_Obs; i++) {
            type = r.nextInt(6);
            variante = r.nextInt(10);

            switch (gameDifficulty) {
                case EASY:
                    if (variante <= 5)//60%
                        obstacleDifficulty = Difficulty.EASY;
                    else if (variante > 5 && variante < 9)//30%
                        obstacleDifficulty = Difficulty.NORMAL;
                    else //10%
                        obstacleDifficulty = Difficulty.HARD;
                    break;

                case NORMAL:
                    if (variante <= 1)//20%
                        obstacleDifficulty = Difficulty.EASY;
                    else if (variante > 1 && variante < 8)//60%
                        obstacleDifficulty = Difficulty.NORMAL;
                    else//20%
                        obstacleDifficulty = Difficulty.HARD;
                    break;

                case HARD:
                    if (variante <= 0)//10%
                        obstacleDifficulty = Difficulty.EASY;
                    else if (variante > 0 && variante < 4)//30%
                        obstacleDifficulty = Difficulty.NORMAL;
                    else//60%
                        obstacleDifficulty = Difficulty.HARD;
                    break;

                default:
                    if (variante <= 5)//60%
                        obstacleDifficulty = Difficulty.EASY; //à remplacer par des difficulter !!
                    else if (variante > 5 && variante < 9)//30%
                        obstacleDifficulty = Difficulty.NORMAL;
                    else //10%
                        obstacleDifficulty = Difficulty.HARD;
            }

            //System.out.println(obstacleDifficulty);
            Obstacle o = bo.BuildObstacleVersionAlea(type, obstacleDifficulty, posX, posY, colors, scene);
            //BallColorSwitch bcs = new BallColorSwitch(scene.getWidth()/2,posY + o.getObstacleHeight() + 100,o.getColor_use());

            newPath.getChildren().add(o.getObstacle());
            obstacles.add(o);
            posY = posY - o.getObstacleHeight() / 2 - 500;
        }


        return newPath;
    }

    private Group buildPath() {
        Group newPath = new Group();
        Iterator<Obstacle> itObs = obstacles.iterator();
        Obstacle o;
        while (itObs.hasNext()) {
            o = itObs.next();
            newPath.getChildren().add(o.getObstacle());
        }

        Iterator<Ennemy> itEnn = ennemies.iterator();
        Ennemy e;
        while (itObs.hasNext()) {
            e = itEnn.next();
            //newPath.getChildren().add(e.getEnnemy);
        }

        return newPath;
    }

    public void add(Obstacle o) {
        obstacles.add(o);
    }

    public void add(Ennemy e) {
        ennemies.add(e);
    }

    public boolean add(Item item) {
        return items.add(item);
    }


    public boolean remove(Object o) {
        return items.remove(o);
    }

    public void remove(Obstacle o) {
        obstacles.remove(o);
    }

    public void remove(Ennemy e) {
        ennemies.remove(e);
    }

    public boolean isCorrect() {
        //TODO
        return false;
    }

    public int getItemNbr() {
        return items.size();
    }

    public int getObstacleNbr() {
        return obstacles.size();
    }

    /*c'est pas cool !!!*/
    //TODO
    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    //TODO
    public List<Ennemy> getEnnemies() {
        return ennemies;
    }

    public Group getPath() {
        return path;
    }


}
