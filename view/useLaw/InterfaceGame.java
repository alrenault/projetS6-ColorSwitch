package view.useLaw;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.game.Score;
import view.ball.BallPlayer;

public class InterfaceGame implements UseLaw {

	Score leScore;
    double score;
    Scene scene;
    Label scoreLabel;
    Group interfaceGame;
    BallPlayer ball;
    
    public InterfaceGame(Score leScore, Group interfaceGame,BallPlayer ball) {
        this.leScore = leScore;
        this.scene = scene;
        this.score = leScore.getScore();
        this.ball = ball ;
        scoreLabel = new Label("Score :"+leScore.getScore().toString());
        this.interfaceGame = interfaceGame;
        interfaceGame.getChildren().add(scoreLabel);
    }
	
	@Override
	public void apply() {
		
		scoreLabel.setText(leScore.getScore().toString());
		scoreLabel.setTextFill(Color.WHITE);
		Font scoreFont = Font.font("Verdana", FontWeight.BOLD, 50);
		scoreLabel.setFont(scoreFont);
		
		
		//scoreLabel.setTranslateX(ball.getBall().getX());
		//scoreLabel.setTranslateY(ball.getBall().getY());
		
		
		Label oui = new Label("Oui");
        oui.setTextFill(Color.WHITE);
        interfaceGame.getChildren().add(oui);
		
        

        
	}
	
	

}
