package game.path;

import game.Colorable;
import game.Difficulty;
import game.ennemy.Ennemy;
import game.path.items.Item;
import game.path.items.Star;
import game.path.obstacle.BuildObstacle;
import game.path.obstacle.Obstacle;
import game.path.items.BallColorSwitch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Path extends Element {
    private List<Item> items;
    private List<Obstacle> obstacles;
    private List<Ennemy> ennemies;
    private Group path;
    private Difficulty gameDifficulty;
    private double scWidth;
    private double scHeight;
    private List<Color> colors;
    private int nbr_Obs;


    public Path(double scWidth, double scHeight, List<Color> colors, int nbr_Obs, Difficulty gameDifficulty) {
    	super();
        obstacles = new ArrayList<>();
        ennemies = new ArrayList<>();
        items = new ArrayList<>();
        this.gameDifficulty = gameDifficulty;
        this.colors = colors;
        this.scWidth = scWidth;
        this.scHeight = scHeight;
        this.nbr_Obs = nbr_Obs;

        path = buildPathRandom();
    }

    public Path(List<Obstacle> _obstacles, List<Ennemy> _ennemies) {
    	super();
        obstacles = _obstacles;
        ennemies = _ennemies;
        items = new ArrayList<>();
        path = buildPath();
    }
    
    public Path(List<Obstacle> _obstacles){
    	super();
    	obstacles = _obstacles;
    	ennemies = new ArrayList<>();
    	items = new ArrayList<>();
    }

    public Path(List<Color> colors, int nb_Obstacle, Difficulty difficulty) {
		this.colors = colors;
		this.nbr_Obs = nb_Obstacle;
		this.gameDifficulty = difficulty;
	}

	private Group buildPathRandom() {
    	
        Group newPath = new Group();
        Random r = new Random();
        int type;
        int variante;
        double posY = scHeight / 3;
        double posX = scWidth / 2;
        Difficulty obstacleDifficulty;



        //Constrution
        for (int i = 0; i < nbr_Obs; i++) {
            type = r.nextInt(6);
            variante = r.nextInt(10);
            obstacleDifficulty = obstacleDifficulty(variante);
            
            //Generation de l'obstacle avec son colorSwitch
            Obstacle o = BuildObstacle.VersionAlea(type, obstacleDifficulty, posX, posY, colors,scWidth);
            BallColorSwitch bcs = new BallColorSwitch(scWidth/2,posY + o.getObstacleHeight()/2 + 150,o.getModel_obstacle().getColor_use());

               List<Color> l = new ArrayList<Color>();
                     Star s;
                        if(o.getModel_obstacle().getDifficulty() == Difficulty.EASY){
                           	l.add(Colorable.BRONZE);
                                s = new Star(scWidth/2,o.getY(),10,l,10);
                            }
                        else if(o.getModel_obstacle().getDifficulty() == Difficulty.NORMAL){
                            	l.add(Colorable.SILVER);
                                s = new Star(scWidth/2,o.getY(),15,l,20);
                            }
                       else{
                            	l.add(Colorable.GOLD);
                                s = new Star(scWidth/2,o.getY(),20,l,30);
                           }

            //marche pas encore tout à fait
            /*for(Shape partStar : s.getShapeList()){
             	for(Shape shape : o.getShapeList()){
                 	while(!Shape.intersect(shape,partStar).getBoundsInParent().isEmpty()){
                 		s.setY(s.getY()+1);
                 	}
                 }
             }*/
            //System.out.println("colors : "+bcs.getColors_use());
            
            //System.out.println("Is it Empty ?"+o.getShapeList().isEmpty());
            
            newPath.getChildren().add(o.getObstacle());
            newPath.getChildren().add(bcs.getItem());
            newPath.getChildren().add(s.getItem());
            
            add(o);
            add(bcs);
            add(s);
            
            addSL(o.getShapeList());
            addSL(bcs.getShapeList());
            addSL(s.getShapeList());
            
            posY = posY - o.getObstacleHeight() / 2 - 600;
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
            BallColorSwitch bcs = new BallColorSwitch(scWidth/2,o.getY() + o.getObstacleHeight()/2 + 150 + o.getObstacleHeight()/2 + 100,o.getModel_obstacle().getColor_use());
            
            addSL(o.getShapeList());
            addSL(bcs.getShapeList());
        }

        Iterator<Ennemy> itEnn = ennemies.iterator();
        Ennemy e;
        while (itObs.hasNext()) {
            e = itEnn.next();
            //newPath.getChildren().add(e.getEnnemy);
        }

        return newPath;
    }
    
    
    
    private Difficulty obstacleDifficulty(int variante){
    	Difficulty obstacleDifficulty;
    	switch (gameDifficulty) {
        case EASY:
            if (variante <= 6)//70%
                obstacleDifficulty = Difficulty.EASY;
            else if (variante > 6 && variante < 9)//20%
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
                obstacleDifficulty = Difficulty.EASY;
            else if (variante > 5 && variante < 9)//30%
                obstacleDifficulty = Difficulty.NORMAL;
            else //10%
                obstacleDifficulty = Difficulty.HARD;
    	}
    	
    	return obstacleDifficulty;
    	
    }
    
    
    

    public void add(Obstacle o) {
        obstacles.add(o);
        //addSL(o.getShapeList());
        //path.getChildren().add(o.getShape());
    }

    public void add(Ennemy e) {
        ennemies.add(e);
    }

    public boolean add(Item item) {
        return items.add(item);
    }


    public boolean remove(Item item) {
    for(Shape s : item.getShapeList()){
    	s.setFill(Color.TRANSPARENT);
    }
    	path.getChildren().remove(item);
        return items.remove(item);
    }

    public void remove(Obstacle o) {
    	path.getChildren().remove(o);
        obstacles.remove(o);
    }

    public void remove(Ennemy e){
    	path.getChildren().remove(e);
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
    
    public List<Item> getItem(){
    	return items;
    }

    public Group getPath() {
        return path;
    }

	@Override
	protected Group build() {
		return buildPathRandom();
	}

	@Override
	public Group getShape() {
		// TODO Auto-generated method stub
		return path;
	}
	



}
