package view;

import java.util.ArrayList;
import java.util.List;

import game.path.Path;
import game.path.items.BuildItem;
import game.path.items.Item;
import game.path.obstacle.BuildObstacle;
import game.path.obstacle.Obstacle;
import javafx.scene.Group;
import model.modelItem.ModelItem;
import model.modelObstacle.ModelObstacle;

public class ViewPath {

	private static List<Obstacle> obstacles;
	private static List<Item> items;
	
	public ViewPath(Path path) {
		obstacles = new ArrayList<>();
		items = new ArrayList<>();
		buildObstacles(path);
		buildItems(path);
	}
	
	
	//ADD
	public static void addObstacle(ModelObstacle mo) {
		Obstacle obstacle = BuildObstacle.build(mo);
		obstacles.add(obstacle);
	}
	
	public static void addItem(ModelItem mi) {
		Item item = BuildItem.build(mi);
		items.add(item);
	}
	
	//REMOVE
	public static void removeObstacle(ModelObstacle mo) {
		Obstacle obstacle = BuildObstacle.build(mo);
		obstacles.remove(obstacle);
	}
	
	public static void removeItem(Item i) {
		items.remove(i);
	}
	
	public static void removeObstacle(Obstacle o) {
		obstacles.remove(o);
	}
	
	public static void removeItem(ModelItem mi) {
		Item item = BuildItem.build(mi);
		items.remove(item);
	}
	
	//GET
	public List<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public List<Item> getItems(){
		return items;
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
