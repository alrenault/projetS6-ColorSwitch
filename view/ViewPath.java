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
import view.game.path.Path;
import view.game.path.items.BuildItem;
import view.game.path.items.Item;
import view.game.path.obstacle.BuildObstacle;
import view.game.path.obstacle.Obstacle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ViewPath {
    /**
     *
     */
    private static List<Obstacle> obstacles;
    /**
     *
     */
    private static List<Item> items;
    /**
     *
     */
    private static List<Shape> obstaclesShapes;

    /**
     *
     */
    private static List<Shape> itemsShapes;
    /**
     *
     */
    private Path path;
    /**
     *
     */
    private Group jObstacles;
    /**
     *
     */
    private Group jItems;

    private Rectangle finishLine;
    
    private double yFinishLine=Double.MAX_VALUE;

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

        //buildObstacles(path);
        //buildItems(path);
    }


    //ADD
    private Obstacle addObstacle(ModelObstacle mo) {
        Obstacle obstacle = BuildObstacle.build(mo);
        obstacles.add(obstacle);
        obstaclesShapes.addAll(obstacle.getShapeList());

        return obstacle;
    }

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

    private Item addItem(ModelItem mi) {
        Item item = BuildItem.build(mi);
        items.add(item);
        itemsShapes.addAll(item.getShapeList());
        return item;
    }

    //REMOVE
    public void removeObstacle(ModelObstacle mo) {
        Obstacle obstacle = BuildObstacle.build(mo);
        obstacles.remove(obstacle);
        obstaclesShapes.removeAll(obstacle.getShapeList());
    }

    public void removeItem(Item i) {

        for (Shape s : i.getShapeList()) {
            s.setFill(Color.TRANSPARENT);
        }
        items.remove(i);
        itemsShapes.removeAll(i.getShapeList());
        path.remove(i.getModel_item());
    }

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

    public void removeItem(ModelItem mi) {
        Item item = BuildItem.build(mi);
        items.remove(item);
        itemsShapes.removeAll(item.getShapeList());
    }

    //GET
    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Shape> getObstaclesShapes() {
        return obstaclesShapes;
    }

    public List<Shape> getItemsShapes() {
        return itemsShapes;
    }

    //BUILD
    public void buildObstacles(Path path) {
        for (ModelObstacle mo : path.getObstacles()) {
            addObstacle(mo);
        }
    }

    public void buildItems(Path path) {
        for (ModelItem mi : path.getItem()) {
            addItem(mi);
        }
    }


    public Group getjObstacles() {
        return jObstacles;
    }


    public Group getjItems() {
        return jItems;
    }


    public Rectangle getFinishLine() {
        return finishLine;
    }


	public double getYFinishLine() {
		return yFinishLine;
	}


}
