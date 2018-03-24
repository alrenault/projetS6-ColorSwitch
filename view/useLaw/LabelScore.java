package view.useLaw;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import model.game.Score;

public class LabelScore implements UseLaw {

    Score leScore;
    double score;
    Scene scene;

    public LabelScore(Score leScore, Scene scene) {
        this.leScore = leScore;
        this.scene = scene;
        this.score = leScore.getScore();
    }

    @Override
    public void apply() {
        Label score = new Label(leScore.getScore().toString());
        score.setTextFill(Color.WHITE);
        Group root = (Group) scene.getRoot();

        root.getChildren().add(score);

    }

}
