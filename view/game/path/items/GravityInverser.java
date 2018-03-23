package view.game.path.items;

import model.modelItem.ModelGravityInverser;


/**
 * Objet graphique Changeur de gravité
 *
 * @autor Vincent
 * @date 09/02/2018
 */
class GravityInverser extends GravitySwitch {

    /**
     * La taille
     */
    private double size;


    /**
     * @param mgi
     */
    public GravityInverser(ModelGravityInverser mgi) {
        super(mgi);
    }


}
