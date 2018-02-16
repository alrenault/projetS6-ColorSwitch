package game.path;

import game.ennemy.Ennemy;
import game.path.items.Item;
import game.path.pluri.Obstacle;

import java.util.ArrayList;
import java.util.List;


public class Path {
    private List<Item> items;
    private List<Obstacle> obstacles;
    private List<Ennemy> ennemies;


    public Path() {
        obstacles = new ArrayList<Obstacle>();
        ennemies = new ArrayList<Ennemy>();
        items = new ArrayList<Item>();
    }

    public Path(List<Obstacle> _obstacles, List<Ennemy> _ennemies) {
        obstacles = _obstacles;
        ennemies = _ennemies;
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


}
