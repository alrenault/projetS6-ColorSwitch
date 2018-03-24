package view.game.path;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Une élément représent un élément du jeu
 * Le but est de représenter une forme concrete pouvant etre utilise pour les obstacles, items ou une simple forme du jeu
 */
public abstract class Element {

    /**
     * Groupe représentant l'élément
     */
    private Group shape;

    /**
     * La liste des (Java FX) shape de l'élément
     */
    private List<Shape> shape_list;

    /**
     * Constructeur d'un élément
     */
    protected Element() {
        shape_list = new ArrayList<>();
    }

    /**
     * Accesseur de la liste des shapes de l'élément
     *
     * @return la liste des shapes de l'élément
     */
    public List<Shape> getShapeList() {
        return shape_list;
    }

    /**
     * Permet de rajouter une ou des shapes à la liste de shapes
     *
     * @param shapes la/les shapes à ajouter
     */
    protected void addSL(Shape... shapes) {

        if (shapes != null) {
            if (shape_list == null) shape_list = new ArrayList<>();
            shape_list.addAll(Arrays.asList(shapes));
        }

    }

    /**
     * Permet de rajouter une ou des listes de shapes à la liste de shapes
     *
     * @param shapes La/les listes de shapes à ajouter
     */
    protected void addSL(List<Shape>... shapes_list) {


        if (shapes_list != null) {
            if (shape_list == null) shape_list = new ArrayList<>();
            for (List<Shape> j : shapes_list) {
                shape_list.addAll(j);

            }
        }

    }

    /**
     * Permet de supprimer une ou des shapes à la liste de shapes
     *
     * @param shapes la/les shapes à supprimer
     */
    public void removeSL(Shape... shapes) {

        if (shapes != null) {
            if (shape_list == null) shape_list = new ArrayList<>();
            for (Shape j : shapes) {
                shape_list.remove(j);
            }
        }

    }

    /**
     * Permet de supprimer une ou des listes de shapes à la liste de shapes
     *
     * @param shapes_list La/les listes de shapes à supprimer
     */
    public void removeSL(List<Shape>... shapes_list) {

        if (shapes_list != null) {
            if (shape_list == null) shape_list = new ArrayList<>();
            for (List<Shape> j : shapes_list) {
                shape_list.removeAll(j);

            }
        }

    }

    protected void check() {
        assert (shape != null);
        assert (shape_list != null);
    }

}
