package view.game.path;

import view.game.Colorable;
import view.game.Difficulty;
import view.game.ennemy.Ennemy;
import javafx.scene.paint.Color;
import model.modelItem.BuildModelItem;
import model.modelItem.ModelBallColorSwitch;
import model.modelItem.ModelInvisibleLine;
import model.modelItem.ModelItem;
import model.modelItem.ModelStar;
import model.modelObstacle.BuildModelObstacle;
import model.modelObstacle.ModelObstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Path {
    private List<ModelItem> items;
    private List<ModelObstacle> obstacles;
    private List<Ennemy> ennemies;
    //private Group path;
    private Difficulty gameDifficulty;
    private double scWidth;
    private double scHeight;
    private List<Color> colors;
	private int nbr_ObsDeb;
	private double posX;
	private double posY;
	private double finishLine;
	
	private boolean isFinite;
	private boolean isCircleHell = false;


    public Path(double scWidth, double scHeight, List<Color> colors, int nbr_ObsDeb, Difficulty gameDifficulty) {
    	super();
        obstacles = new ArrayList<>();
        ennemies = new ArrayList<>();
        items = new ArrayList<>();
        this.gameDifficulty = gameDifficulty;
        this.colors = colors;
        this.scWidth = scWidth;
        this.scHeight = scHeight;
        this.nbr_ObsDeb = nbr_ObsDeb;
        posX = scWidth / 2;
        this.posY = scHeight / 5;
        isFinite = false;

        //buildPathRandom();
    }
    
    public Path(double scWidth, double scHeight, List<Color> colors, int nbr_Obs) {
    	super();
        obstacles = new ArrayList<>();
        ennemies = new ArrayList<>();
        items = new ArrayList<>();
        this.gameDifficulty = Difficulty.RANDOM;
        this.colors = colors;
        this.scWidth = scWidth;
        this.scHeight = scHeight;
        this.nbr_ObsDeb = nbr_Obs;
        posX = scWidth / 2;
        this.posY = scHeight / 5;
        isFinite = true;
        //buildPathRandom();
    }
    
	public Path(double scWidth, double scHeight, List<Color> colors){
		super();
        obstacles = new ArrayList<>();
        ennemies = new ArrayList<>();
        items = new ArrayList<>();
        this.gameDifficulty = Difficulty.RANDOM;
        this.colors = colors;
        this.scWidth = scWidth;
        this.scHeight = scHeight;
        posX = scWidth / 2;
        this.posY = scHeight / 5;
        isFinite = false;
        isCircleHell = true;
        this.nbr_ObsDeb = 3;

	}


    public Path(List<ModelObstacle> _obstacles, List<Ennemy> _ennemies) {
    	super();
        obstacles = _obstacles;
        ennemies = _ennemies;
        items = new ArrayList<>();
        posX = scWidth / 2;
        this.posY = scHeight / 5;
        //buildPath();
    }
    
    public Path(List<ModelObstacle> _obstacles){
    	super();
    	obstacles = _obstacles;
    	ennemies = new ArrayList<>();
    	items = new ArrayList<>();
        posX = scWidth / 2;
        this.posY = scHeight / 5;
        posX = scWidth / 2;
        this.posY = scHeight / 5;
    }

    public Path(List<Color> colors, int nb_Obstacle, Difficulty difficulty) {
		this.colors = colors;
		this.nbr_ObsDeb = nb_Obstacle;
		this.gameDifficulty = difficulty;
	}

	private void buildPathRandom() {
    	
        //Group newPath = new Group();
        /*Random r = new Random();
        int type;
        int variante;
       // double posY = scHeight / 5;
        Difficulty obstacleDifficulty;*/



        //Construction
        for (int i = 0; i < nbr_ObsDeb; i++) {
        	ModelObstacle mo = addNewObstacle();
        	addNewColorSwitch(mo.getY() + mo.getObstacleHeight()/2 + 150);
            

            //marche pas encore tout à fait
            /*for(Shape partStar : s.getShapeList()){
             	for(Shape shape : o.getShapeList()){
                 	while(!Shape.intersect(shape,partStar).getBoundsInParent().isEmpty()){
                 		s.setY(s.getY()+1);
                 	}
                 }
             }*/

            // ln("Is it Empty ?"+o.getShapeList().isEmpty());
            
            //newPath.getChildren().add(o.getObstacle());
            //newPath.getChildren().add(bcs.getItem());
            //newPath.getChildren().add(s.getItem());
            
            
            
            //addSL(o.getShapeList());
            //addSL(bcs.getShapeList());
            //addSL(s.getShapeList());
            
            
        }


        //return newPath;
    }

	/* Fonction normalement obsolete maintenant
    private Group buildPath() {
        Group newPath = new Group();
        Iterator<ModelObstacle> itObs = obstacles.iterator();
        ModelObstacle o;
        while (itObs.hasNext()) {
            o = itObs.next();
            //newPath.getChildren().add(o.getObstacle());
            BallColorSwitch bcs = new BallColorSwitch(scWidth/2,o.getY() + mo.getObstacleHeight()/2 + 150 + o.getObstacleHeight()/2 + 100,o.getModel_obstacle().getColor_use());
            
            //addSL(o.getShapeList());
            //addSL(bcs.getShapeList());
        }

        Iterator<Ennemy> itEnn = ennemies.iterator();
        Ennemy e;
        while (itObs.hasNext()) {
            e = itEnn.next();
            //newPath.getChildren().add(e.getEnnemy);
        }

        return newPath;
    }*/
    
	 public ModelObstacle addNewObstacle(){
	    	Random r = new Random();
	    	int type;
	        int variante = r.nextInt(10);
	    	Difficulty obstacleDifficulty = obstacleDifficulty(variante);
	    	ModelObstacle mo;
	    	
	    	if(this.isCircleHell){
	    		type = r.nextInt(2);
	    	}
	    	else{
	    		type = r.nextInt(6);
	    	}
	    	
	    	//Generation de l'obstacle avec son colorSwitch
	        mo = BuildModelObstacle.build(type, obstacleDifficulty, posX, posY, colors,scWidth);
	       // BallColorSwitch bcs = new BallColorSwitch(scWidth/2,posY + mo.getObstacleHeight()/2 + 150,mo.getColor_use());
	    	
	    	

	           
	        
	       
	        add(mo);
	        // ln(mo.getBcs());
	        //add(modelStar);
	        posY = posY - mo.getObstacleHeight() / 2 - 600;
	        
	        return mo;
	    }
	 
	 
	 
	 public ModelBallColorSwitch addNewColorSwitch(double y){
		 ModelBallColorSwitch modelBCS = (ModelBallColorSwitch)BuildModelItem.build(0, scWidth/2,y, colors, 0, 0, 0, scWidth);
	     add(modelBCS);
	     return modelBCS;
	 }
    
	 public ModelStar addNewStar(ModelObstacle mo){
		 List<Color> l = new ArrayList<>();
		 ModelStar modelStar;
         switch (mo.getDifficulty()) {
             case EASY:
                 l.add(Colorable.BRONZE);
                 modelStar = (ModelStar) BuildModelItem.build(3, scWidth / 2, mo.getY(), l, 0, 10, 10, scWidth);
                 break;
             case NORMAL:
                 l.add(Colorable.SILVER);
                 modelStar = (ModelStar) BuildModelItem.build(3, scWidth / 2, mo.getY(), l, 0, 15, 20, scWidth);
                 break;
             default:
                 l.add(Colorable.GOLD);
                 modelStar = (ModelStar) BuildModelItem.build(3, scWidth / 2, mo.getY(), l, 0, 20, 30, scWidth);
                 break;
         }
	     add(modelStar);
	     
	     return modelStar;
	        
	 }
	 
	 public ModelInvisibleLine addNewInvisibleLine(double y){
		 ModelInvisibleLine modelIL = (ModelInvisibleLine)BuildModelItem.build(4, scWidth/2,y, colors, 0, 0, 0, scWidth);
	     add(modelIL);
	     return modelIL;
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
            
        case RANDOM:
        	int r = new Random().nextInt(3);
            switch (r) {
                case 0:
                    obstacleDifficulty = Difficulty.EASY;
                    break;
                case 1:
                    obstacleDifficulty = Difficulty.NORMAL;
                    break;
                default:
                    obstacleDifficulty = Difficulty.HARD;
                    break;
            }

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
    
    
    

    private void add(ModelObstacle o) {
        obstacles.add(o);
        //addSL(o.getShapeList());
        //path.getChildren().add(o.getShape());
    }
    
   

    public void add(Ennemy e) {
        ennemies.add(e);
    }

    private void add(ModelItem item) {
        items.add(item);
    }


    public void remove(ModelItem item) {
        items.remove(item);
    }

    public void remove(ModelObstacle o) {
        obstacles.remove(o);
    }

    /*public void remove(Ennemy e){
    	path.getChildren().remove(e);
        ennemies.remove(e);
    }*/

    public boolean isCorrect() {
        //TODO
        return false;
    }

    /**
     * Accesseur du nombre d'items
     * @return le nombre d'items
     */
    public int getItemNbr() {
        return items.size();
    }

    
    
    public int getNbr_ObsDeb() {
		return nbr_ObsDeb;
	}

	/**
     * Accesseur du nombre d'Obstacles
     * @return le nombre d'Obstacles dans la liste
     */
    public int getObstacleNbr() {
        return obstacles.size();
    }

    public List<ModelObstacle> getObstacles() {
        return obstacles;
    }

    //TODO
    public List<Ennemy> getEnnemies() {
        return ennemies;
    }
    
    public List<ModelItem> getItem(){
    	return items;
    }
    
    public List<Color> getColors() {
		return colors;
	}

	public double getPosY() {
		return posY;
	}

	public boolean isFinite() {
		return isFinite;
	}

	public boolean isCircleHell() {
		return isCircleHell;
	}

	public double getFinishLine() {
		return finishLine;
	}

	public void setFinishLine(double finishLine) {
		this.finishLine = finishLine;
	}

	public double getScWidth() {
		return scWidth;
	}

	public double getScHeight() {
		return scHeight;
	}
	
	
	
	

    /*public Group getPath() {
        return path;
    }*/
	



}
