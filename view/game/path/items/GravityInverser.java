package view.game.path.items;

import model.modelItem.ModelGravityInverser;


/**
 * Objet graphique Changeur de gravité
 */
class GravityInverser extends GravitySwitch {

    /**
     * La taille du GravityInverser
     */
    private double size;


    /**
	 * Constructeur de la GravityInverser
	 * @param mgi Le model utilisé pour le GravityInverser
	 */
    public GravityInverser(ModelGravityInverser mgi) {
        super(mgi);
    }


}
