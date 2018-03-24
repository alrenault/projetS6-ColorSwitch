package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import model.modelItem.ModelBallColorSwitch;
import model.modelItem.ModelInvisibleLine;
import model.modelItem.ModelItem;
import model.modelItem.ModelStar;
import model.modelObstacle.ModelObstacle;
import view.path.Path;
import view.path.items.BuildItem;
import view.path.items.Item;
import view.path.obstacle.BuildObstacle;
import view.path.obstacle.Obstacle;

import java.util.ArrayList;
import java.util.List;

/**
 * Le chemin d'obstacle construit
 */
public class ViewPath {
   
	/**
     * La liste des obstacles contenus dans le ViewPath
     */
    private  List<Obstacle> obstacles;
    
    /**
     * La liste des obstacles contenus dans le ViewPath
     */
    private  List<Item> items;
    
    /**
     * La liste des shapes des obstacles contenus dans le ViewPath
     */
    private  List<Shape> obstaclesShapes;

    /**
     * La liste des shapes des items contenus dans le ViewPath
     */
    private  List<Shape> itemsShapes;
    
    /**
     * Le path contenant les modèles des obstacles, ...
     */
    private Path path;
    
    /**
     * Le groupe contenant les obstacles
     */
    private Group jObstacles;
    
    /**
     * Le groupe contenant les items
     */
    private Group jItems;

    /**
     * Le rectangle représentant la ligne d'arrivée
     */
    private Rectangle finishLine;
    
    /**
     * La coordonné y de la ligne d'arrivée
     */
    private double yFinishLine=Double.MAX_VALUE;

    /**
     * Constructeur d'un ViewPath
     * @param path Path contenant les obstacles, ...
     */
    public ViewPath(Path path) {
        this.path = path;

        jObstacles = ViewGameManagement.buildObstacles(path);
        jItems = ViewGameManagement.buildItems(path);

        ViewGameManagement.add(jObstacles);
        ViewGameManagement.add(jItems);

        obstacles = new ArrayList<>();
        items = new ArrayList<>();
        obstaclesShapes = new ArrayList<>();
        itemsShapes = new ArrayList<>();

        for (int i = 0; i < path.getNbr_ObsDeb(); i++) {
            addNewObstacle();
        }

        if (path.isFinite()) {
            path.setFinishLine(path.getPosY());
            finishLine = new Rectangle(0, path.getPosY() - 10, path.getScWidth(), 10);
            finishLine.setFill(Color.RED);
            yFinishLine = path.getFinishLine();
        }
    }

    /**
     * Vide la memoire des itemps passés , des formes , et du Path à la fin d'une partie
     */
    public void cleanPath(){
         this.items.clear();
         this.itemsShapes.clear();
         this.obstacles.clear();
         this.obstaclesShapes.clear();
         this.path.cleanPath();

    }
    
    /**
     * Rajoute un obstacles au ViewPath
     * @param mo Le modèle de l'obstacle à rajouter
     * @return L'obstacle ajouté
     */
    private Obstacle addObstacle(ModelObstacle mo) {
        Obstacle obstacle = BuildObstacle.build(mo);
        obstacles.add(obstacle);
        obstaclesShapes.addAll(obstacle.getShapeList());

        return obstacle;
    }

    /**
     * Crée un nouveau modèle d'obstacle, de colorSwitch et de Star, les construit et les rajoutes au ensembles du ViexPath
     */
    public void addNewObstacle() {
        ModelObstacle mo = path.addNewObstacle();
        Obstacle o = addObstacle(mo);
        jObstacles.getChildren().add(o.getObstacle());

        ModelItem bcs = path.addNewColorSwitch(o.getY() + o.getObstacleHeight() / 2 + 150);
        ((ModelBallColorSwitch) bcs).setColors_use(o.getColor_passable());

        //bcs.setY(o.getY() + mo.getObstacleHeight()/2 + 150);
        Item i = addItem(bcs);
        jItems.getChildren().add(i.getItem());

        ModelStar star = path.addNewStar(mo);
        Item s = addItem(star);
        jItems.getChildren().add(s.getItem());

        if (!path.isFinite()) {
            ModelInvisibleLine il = path.addNewInvisibleLine(mo.getY());
            Item line = addItem(il);

            jItems.getChildren().add(line.getItem());
        }


    }

    /**
     * Ajoute un Item dans la liste d'Item
     * @param mi Le modèle depuis lequel on construit l'item
     * @return L'item ajouté
     */
    private Item addItem(ModelItem mi) {
        Item item = BuildItem.build(mi);
        items.add(item);
        itemsShapes.addAll(item.getShapeList());
        return item;
    }

    /**
     * Supprime un obstacles au Path
     * @param mo Le modèle de l'obstacle à supprimer
     */
    public void removeObstacle(ModelObstacle mo) {
        Obstacle obstacle = BuildObstacle.build(mo);
        obstacles.remove(obstacle);
        obstaclesShapes.removeAll(obstacle.getShapeList());
    }

    /**
     * Supprime un item au ViewPath
     * @param i L'item à supprimer
     */
    public void removeItem(Item i) {

        for (Shape s : i.getShapeList()) {
            s.setFill(Color.TRANSPARENT);
        }
        items.remove(i);
        itemsShapes.removeAll(i.getShapeList());
        path.remove(i.getModel_item());
    }

    /**
     * Supprime un obstacle au ViewPath
     * @param o L'obstacle à supprimer
     */
    public void removeObstacle(Obstacle o) {
        for (Shape s : o.getShapeList()) {
            s.setFill(Color.TRANSPARENT);
            s.setStroke(Color.TRANSPARENT);
        }


        obstacles.remove(o);
        obstaclesShapes.removeAll(o.getShapeList());
        path.remove(o.getModel_obstacle());
        o.removeSL(o.getShapeList());


    }

    /**
     * Supprime un item au Path
     * @param mi Le modèle de l'item à supprimer
     */
    public void removeItem(ModelItem mi) {
        Item item = BuildItem.build(mi);
        items.remove(item);
        itemsShapes.removeAll(item.getShapeList());
    }

    /**
     * Accesseur de la liste d'obstacles
     * @return La liste des obstacles
     */
    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    /**
     * Accesseur de la liste des items
     * @return Le liste des items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Accesseur de la listes des shapes des obstacles
     * @return La listes des shapes des obstacles
     */
    public List<Shape> getObstaclesShapes() {
        return obstaclesShapes;
    }

    /**
     * Accesseur de la listes des shapes des obstacles
     * @return La listes des shapes des obstacles
     */
    public List<Shape> getItemsShapes() {
        return itemsShapes;
    }

    /**
     * Construit les obstacles contenus dans le path
     * @param path Le path
     */
    public void buildObstacles(Path path) {
        for (ModelObstacle mo : path.getObstacles()) {
            addObstacle(mo);
        }
    }

    /**
     * Construit les items contenus dans le path
     * @param path La path
     */
    public void buildItems(Path path) {
        for (ModelItem mi : path.getItem()) {
            addItem(mi);
        }
    }


    /**
     * Accesseur du groupe des obstacles
     * @return Le groupe d'obstacles
     */
    public Group getjObstacles() {
        return jObstacles;
    }

    /**
     * Accesseur du groupe des items
     * @return Le groupe d'items
     */
    public Group getjItems() {
        return jItems;
    }

    /**
     * Accesseur de la ligne d'arrivée
     * @return La ligne d'arrivée
     */
    public Rectangle getFinishLine() {
        return finishLine;
    }

    /**
     * Accesseur de la coordonnée en y de la ligne d'arrivée
     * @return La coordonnées en y de la ligne d'arrivée
     */
	public double getYFinishLine() {
		return yFinishLine;
	}



}
