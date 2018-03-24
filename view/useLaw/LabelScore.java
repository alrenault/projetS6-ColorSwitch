package view.useLaw;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        Label score = new Label("Oui");
        Group root = (Group) scene.getRoot();

        root.getChildren().add(score);

    }

}
