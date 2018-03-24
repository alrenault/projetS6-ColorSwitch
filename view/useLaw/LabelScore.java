package view.useLaw;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import model.game.Score;

/**
 * Le lacel du score
 */
public class LabelScore implements UseLaw {

	/**
	 * Le score a afficher
	 */
    Score leScore;
    
    /**
     * La valeur du score
     */
    double score;
    
    /**
     * La scène où l'on doit afficher le score
     */
    Scene scene;

    /**
     * Constructeur du label du score
     * @param leScore Le score à afficher
     * @param scene La scène où afficher
     */
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
