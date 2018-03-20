package view;

import java.util.ArrayList;
import java.util.List;

import game.path.Path;
import game.path.items.BuildItem;
import game.path.items.Item;
import game.path.obstacle.BuildObstacle;
import game.path.obstacle.Obstacle;
import javafx.scene.Group;
import javafx.scene.shape.Shape;
import model.modelItem.ModelItem;
import model.modelObstacle.ModelObstacle;

public class ViewPath {

	private static List<Obstacle> obstacles;
	private static List<Item> items;
	
	private static List<Shape> obstaclesShapes;
	private static List<Shape> itemsShapes;
	
	public ViewPath(Path path) {
		obstacles = new ArrayList<>();
		items = new ArrayList<>();
		obstaclesShapes = new ArrayList<>();
		itemsShapes = new ArrayList<>();
		
		buildObstacles(path);
		buildItems(path);
	}
	
	
	//ADD
	public static void addObstacle(ModelObstacle mo) {
		Obstacle obstacle = BuildObstacle.build(mo);
		obstacles.add(obstacle);
		obstaclesShapes.addAll(obstacle.getShapeList());
		System.out.println(obstacle.getShapeList());
	}
	
	public static void addItem(ModelItem mi) {
		Item item = BuildItem.build(mi);
		items.add(item);
		itemsShapes.addAll(item.getShapeList());
	}
	
	//REMOVE
	public static void removeObstacle(ModelObstacle mo) {
		Obstacle obstacle = BuildObstacle.build(mo);
		obstacles.remove(obstacle);
		obstaclesShapes.removeAll(obstacle.getShapeList());
	}
	
	public static void removeItem(Item i) {
		items.remove(i);
		itemsShapes.removeAll(i.getShapeList());
	}
	
	public static void removeObstacle(Obstacle o) {
		obstacles.remove(o);
		obstaclesShapes.removeAll(o.getShapeList());
	}
	
	public static void removeItem(ModelItem mi) {
		Item item = BuildItem.build(mi);
		items.remove(item);
		itemsShapes.removeAll(item.getShapeList());
	}
	
	//GET
	public List<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public List<Item> getItems(){
		return items;
	}
	
	public List<Shape> getObstaclesShapes() {
		return obstaclesShapes;
	}
	
	public List<Shape> getItemsShapes(){
		return itemsShapes;
	}
	
	//BUILD
	public static void buildObstacles(Path path) {
		for(ModelObstacle mo : path.getObstacles()) {
			addObstacle(mo);
		}
	}
	
	public static void buildItems(Path path) {
		for(ModelItem mi : path.getItem()) {
			addItem(mi);
		}
	}

	
}
