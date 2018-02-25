package game.path;

import game.path.pluri.*;
import game.ennemy.Ennemy;
import game.path.items.Item;
import game.path.pluri.Obstacle;
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
    private int difficulty;
    private Scene scene;
    private Color[] colors;
    private int nbr_Obs;


    public Path(Scene scene, Color[] colors,int nbr_Obs) {
        obstacles = new ArrayList<Obstacle>();
        ennemies = new ArrayList<Ennemy>();
        items = new ArrayList<Item>();
        difficulty = 1;
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
    
    private Group buildPathRandom(){
    	Group newPath = new Group();
    	Random r = new Random();
    	int type;
    	int variante;
    	double posY = scene.getHeight()/3;
    	double posX = scene.getWidth()/2;
    	
    	if(difficulty == 1){
    		for(int i = 0;i<nbr_Obs;i++){
    			type = r.nextInt(6);
    			Obstacle o = null;
    			//Idée pour remplacer ça : une factory ou au moins une classe qui construit un obstacle en fonction du type choisi,...
    			switch(type){
    			case 0:
    				System.out.println("CircleInCircle");
    				variante = r.nextInt(CircleInCircle.NBR_VERSIONS);
    				o = new CircleInCircle(posX,posY,colors,variante);
    				break;
    				
    			case 1:
    				System.out.println("MultiCircle");
    				variante = r.nextInt(MultiCircle.NBR_VERSIONS);
    				o = new MultiCircle(posX,posY,colors,variante);
    				break;
    				
    			case 2:
    				System.out.println("MultiCross");
    				variante = r.nextInt(MultiCross.NBR_VERSIONS);
    				o = new MultiCross(posX,posY,colors,variante);
    				break;
    				
    			case 3:
    				System.out.println("MultiLinee");
    				variante = r.nextInt(MultiLinee.NBR_VERSIONS);
    				o = new MultiLinee(posX,posY,colors,variante,scene);
    				break;
    				
    			case 4:
    				System.out.println("MultiShapes");
    				variante = r.nextInt(MultiShapes.NBR_VERSIONS);
    				o = new MultiShapes(posX,posY,colors,scene,variante);	
    				break;
    				
    			case 5:
    				System.out.println("MultiSquaire");
    				variante = r.nextInt(MultiSquare.NBR_VERSIONS);
    				o = new MultiSquare(posX,posY,colors,variante);
    				break;
    			}
    			newPath.getChildren().add(o.getObstacle());
				obstacles.add(o);
				posY = posY - o.getObstacleHeight()/2 - 500;
    		}
    	}
    	
    	
    	
    	return newPath;
    }
    
    private Group buildPath(){
    	Group newPath = new Group();
    	Iterator<Obstacle> itObs = obstacles.iterator();
    	Obstacle o;
    	while(itObs.hasNext()){
    		o = itObs.next();
    		newPath.getChildren().add(o.getObstacle());
    	}
    	
    	Iterator<Ennemy> itEnn = ennemies.iterator();
    	Ennemy e;
    	while(itObs.hasNext()){
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
    
    public Group getPath(){
    	return path;
    }


}
