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
import javafx.scene.paint.Color;

public class ViewPath {

	private static List<Obstacle> obstacles;
	private static List<Item> items;
	
	private static List<Shape> obstaclesShapes;
	private static List<Shape> itemsShapes;
	
	private Path path;
	
	public ViewPath(Path path) {
		this.path = path;
		obstacles = new ArrayList<>();
		items = new ArrayList<>();
		obstaclesShapes = new ArrayList<>();
		itemsShapes = new ArrayList<>();
		
		buildObstacles(path);
		buildItems(path);
	}
	
	
	//ADD
	public void addObstacle(ModelObstacle mo) {
		Obstacle obstacle = BuildObstacle.build(mo);
		obstacles.add(obstacle);
		obstaclesShapes.addAll(obstacle.getShapeList());
		System.out.println(obstacle.getShapeList());
	}
	
	public void addItem(ModelItem mi) {
		Item item = BuildItem.build(mi);
		items.add(item);
		itemsShapes.addAll(item.getShapeList());
	}
	
	//REMOVE
	public void removeObstacle(ModelObstacle mo) {
		Obstacle obstacle = BuildObstacle.build(mo);
		obstacles.remove(obstacle);
		obstaclesShapes.removeAll(obstacle.getShapeList());
	}
	
	public void removeItem(Item i) {
		
		for(Shape s : i.getShapeList()){
	    	s.setFill(Color.TRANSPARENT);
	    }
		items.remove(i);
		itemsShapes.removeAll(i.getShapeList());
		path.remove(i.getModel_item());
	}
	
	public void removeObstacle(Obstacle o) {
		obstacles.remove(o);
		obstaclesShapes.removeAll(o.getShapeList());
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
	public void buildObstacles(Path path) {
		for(ModelObstacle mo : path.getObstacles()) {
			addObstacle(mo);
		}
	}
	
	public void buildItems(Path path) {
		for(ModelItem mi : path.getItem()) {
			addItem(mi);
		}
	}

	
}
