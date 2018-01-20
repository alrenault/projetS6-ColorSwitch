package controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.Group;




public class Listeners {
	private Scene sc;
	
	public Listeners(Scene sc){
		this.sc = sc;
	}
	
	public void jump(Group group){
		//Label l1 = new Label("je test");
		//group.getChildren().add(l1);
		//l1.setFont(new Font(50));
		sc.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke){
				//if(ke.getCode() == KeyCode.ENTER){
				if(ke.getCode().getName() == "Space"){
					System.out.println("bonjour");
					//l1.setText(ke.getCode().getName());
				}
				
				
			}
		});
	}
	
	

}
