package view;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageLoader {
	
	/**
	 * Image de la coupe pour le score
	 */
	private ImageView imageScore;
	
	/**
	 * Image de l'engrenage pour les parametres
	 */
	private ImageView imageParameters;
	
	public ImageLoader() {
		this.imageScore = new ImageView();
		this.imageParameters = new ImageView();
		
		System.out.println(imageScore);
		
		URL scoreURL = this.getClass().getResource("/resources/Score.jpg");
		URL parametersURL = this.getClass().getResource("/resources/Parameters.png");
		
		System.out.println(scoreURL);
		
		Image scoreMedia = new Image(scoreURL.toString());
		Image parametersMedia = new Image(parametersURL.toString());
		
		System.out.println(scoreMedia);
        
        imageScore.setImage(scoreMedia);
        imageParameters.setImage(parametersMedia);
        
        System.out.println(imageScore == null);

	}
	

	/**
	 * Get image pour le score
	 * @return L'image pour le score
	 */
	public ImageView getScorePicture() {
		return imageScore;
	}
	
	/**
	 * Get image pour les parametres
	 * @return L'image pour les parametres
	 */
	public ImageView getParametersPicture() {
		return imageParameters;
	}
}
