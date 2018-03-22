package view.game.path;

import view.game.path.items.Item;

/**
 * @autor Vincent
 * @date 10/03/2018
 */
public abstract class Modifiers {
    /**
     * La forme de l' item
     * */
    Item forme;


    /**
     * Le nombre de points obtenus en attrapant cet item
     * */
    private int nbPoints;

    public Modifiers() {
    }

    public Modifiers(Item forme, int nbPoints) {
        this.forme = forme;
        this.nbPoints = nbPoints;
    }
    /**
     *Assesseur du nombre de points de l'item
     * @return Le nombre de points obtenus en attrapant cet item
     */
    public int getnbPoints() {
        return nbPoints;
    }
}
