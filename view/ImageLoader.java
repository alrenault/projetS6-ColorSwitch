package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;

/**
 * Le chargeur d'image
 */

public class ImageLoader {

    /**
     * Image de la coupe pour le score
     */
    private ImageView imageScore;

    /**
     * Image de l'engrenage pour les parametres
     */
    private ImageView imageParameters;

    /**
     * Charge les images pour le jeu
     */
    public ImageLoader() {
        this.imageScore = new ImageView();
        this.imageParameters = new ImageView();


        URL scoreURL = this.getClass().getResource("/resources/Score.jpg");
        URL parametersURL = this.getClass().getResource("/resources/Parameters.png");


        Image scoreMedia = new Image(scoreURL.toString());
        Image parametersMedia = new Image(parametersURL.toString());


        imageScore.setImage(scoreMedia);
        imageParameters.setImage(parametersMedia);


    }


    /**
     * Get image pour le score
     *
     * @return L'image pour le score
     */
    public ImageView getScorePicture() {
        return imageScore;
    }

    /**
     * Get image pour les parametres
     *
     * @return L'image pour les parametres
     */
    public ImageView getParametersPicture() {
        return imageParameters;
    }
}
