package view.path;

import javafx.scene.paint.Color;
import model.modelItem.*;
import model.modelObstacle.BuildModelObstacle;
import model.modelObstacle.ModelObstacle;
import model.game.Colorable;
import model.game.Difficulty;
import view.ennemy.Ennemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Représentation d'un chemin constitué d'une suite d'obstacles (un niveau) stockant des modèles
 */
public class Path {

    /**
     * La liste des modèles d'items du path
     */
    private List<ModelItem> items;

    /**
     * La listes des modèles d'obstacles du path
     */
    private List<ModelObstacle> obstacles;

    /**
     * La liste des ennemis du path (non utilisé)
     */
    private List<Ennemy> ennemies;

    /**
     * Difficulté du niveau
     */
    private Difficulty gameDifficulty;

    /**
     * La largeur de la fenêtre
     */
    private double scWidth;

    /**
     * La hauteur de la fenêtre
     */
    private double scHeight;

    /**
     * La liste de couleurs utilisées
     */
    private List<Color> colors;

    /**
     * Le nombre d'obstacles du path
     */
    private int nbr_ObsDeb;

    /**
     * La position en x où placer le prochain obstacle
     */
    private double posX;

    /**
     * La position en y où placer le prochain obstacle
     */
    private double posY;

    /**
     * La position en y de la ligne d'arrivée, dans le cas d'un niveau avec un nombre fini d'obstacles
     */
    private double finishLine;

    /**
     * Défini si le niveau est fini ou non
     */
    private boolean isFinite;

    /**
     * Défini si la partie est en CircleHell ou non
     */
    private boolean isCircleHell = false;

    /**
     * Constructeur d'un path pour un niveau infini (avec un nombre défini d'obstacle  déjà placé)
     *
     * @param scWidth        La largeur de la fenêtre
     * @param scHeight       La hauteur de la fenêtre
     * @param colors         La liste de couleurs utilisées
     * @param nbr_ObsDeb     Nombre d'obstacle à placer dès le début
     * @param gameDifficulty La difficulté de la partie
     */
    public Path(double scWidth, double scHeight, List<Color> colors, int nbr_ObsDeb, Difficulty gameDifficulty) {
        super();
        obstacles = new ArrayList<>();
        ennemies = new ArrayList<>();
        items = new ArrayList<>();
        this.gameDifficulty = gameDifficulty;
        this.colors = colors;
        this.scWidth = scWidth;
        this.scHeight = scHeight;
        this.nbr_ObsDeb = nbr_ObsDeb;
        posX = scWidth / 2;
        this.posY = scHeight / 5;
        isFinite = false;

    }

    /**
     * Constructeur d'un path pour un niveau fini (la difficultée du niveau est défini en RANDOM)
     *
     * @param scWidth  La largeur de la fenêtre
     * @param scHeight La hauteur de la fenêtre
     * @param colors   La liste de couleurs utilisées
     * @param nbr_Obs  Le nombre d'obstacle constituant le niveau
     */
    public Path(double scWidth, double scHeight, List<Color> colors, int nbr_Obs) {
        super();
        obstacles = new ArrayList<>();
        ennemies = new ArrayList<>();
        items = new ArrayList<>();
        this.gameDifficulty = Difficulty.RANDOM;
        this.colors = colors;
        this.scWidth = scWidth;
        this.scHeight = scHeight;
        this.nbr_ObsDeb = nbr_Obs;
        posX = scWidth / 2;
        this.posY = scHeight / 5;
        isFinite = true;
    }

    /**
     * Constructeur d'un path dans le cas d'une partie en CircleHell (difficulté en RANDOM et le nombre d'obstacle directement placé = 3)
     *
     * @param scWidth  La largeur de la fenêtre
     * @param scHeight La hauteur de la fenêtre
     * @param colors   La liste de couleurs utilisées
     */
    public Path(double scWidth, double scHeight, List<Color> colors) {
        super();
        obstacles = new ArrayList<>();
        ennemies = new ArrayList<>();
        items = new ArrayList<>();
        this.gameDifficulty = Difficulty.RANDOM;
        this.colors = colors;
        this.scWidth = scWidth;
        this.scHeight = scHeight;
        posX = scWidth / 2;
        this.posY = scHeight / 5;
        isFinite = false;
        isCircleHell = true;
        this.nbr_ObsDeb = 3;

    }


    /**
     * Ancien constructeur d'un path non utilisée qui aurait permis de rajouter des ennemis (ne respecte pas le MVC)
     *
     * @param _obstacles La liste des obstacles déjà construit
     * @param _ennemies  La liste des ennemis déjà construit
     */
    public Path(List<ModelObstacle> _obstacles, List<Ennemy> _ennemies) {
        super();
        obstacles = _obstacles;
        ennemies = _ennemies;
        items = new ArrayList<>();
        posX = scWidth / 2;
        this.posY = scHeight / 5;
    }

    /**
     * Rajoute un modèle d'obstacle au path
     *
     * @return le modèle du nouvel obstacle
     */
    public ModelObstacle addNewObstacle() {
        Random r = new Random();
        int type;
        int variante = r.nextInt(10);
        Difficulty obstacleDifficulty = obstacleDifficulty(variante);
        ModelObstacle mo;

        if (this.isCircleHell) {
            type = r.nextInt(2);
        } else {
            type = r.nextInt(6);
        }

        //Generation de l'obstacle avec son colorSwitch
        mo = BuildModelObstacle.build(type, obstacleDifficulty, posX, posY, colors, scWidth);


        add(mo);
        posY = posY - mo.getObstacleHeight() / 2 - 600;

        return mo;
    }

    /**
     * Rajoute un modèle d'une BallColorSwitch au path
     *@param y La coordonnée en y de la BallCOlorwitch à ajouter
     * @return le modèle de la  nouvelle BallColorSwitch
     */
    public ModelBallColorSwitch addNewColorSwitch(double y) {
        ModelBallColorSwitch modelBCS = (ModelBallColorSwitch) BuildModelItem.build(0, scWidth / 2, y, colors, 0, 0, 0, scWidth);
        add(modelBCS);
        return modelBCS;
    }

    /**
     * Rajoute un modèle d'une Star au path
     *@param mo La coordonnée en y de la Star à rajouter
     * @return le modèle de la  nouvelle Star
     */
    public ModelStar addNewStar(ModelObstacle mo) {
        List<Color> l = new ArrayList<>();
        ModelStar modelStar;
        switch (mo.getDifficulty()) {
            case EASY:
                l.add(Colorable.BRONZE);
                modelStar = (ModelStar) BuildModelItem.build(3, scWidth / 2, mo.getY(), l, 0, 10, 10, scWidth);
                break;
            case NORMAL:
                l.add(Colorable.SILVER);
                modelStar = (ModelStar) BuildModelItem.build(3, scWidth / 2, mo.getY(), l, 0, 15, 20, scWidth);
                break;
            default:
                l.add(Colorable.GOLD);
                modelStar = (ModelStar) BuildModelItem.build(3, scWidth / 2, mo.getY(), l, 0, 20, 30, scWidth);
                break;
        }
        add(modelStar);

        return modelStar;

    }

    /**
     * Rajoute un modèle d'une InvisibleLine au path
     *@param y La coordonnée en y de la InvisibleLine à rajouter
     * @return le modèle de la  nouvelle InvisbleLine
     */
    public ModelInvisibleLine addNewInvisibleLine(double y) {
        ModelInvisibleLine modelIL = (ModelInvisibleLine) BuildModelItem.build(4, scWidth / 2, y, colors, 0, 0, 0, scWidth);
        add(modelIL);
        return modelIL;
    }

    private Difficulty obstacleDifficulty(int variante) {
        Difficulty obstacleDifficulty;
        switch (gameDifficulty) {
            case EASY:
                if (variante <= 6)//70%
                    obstacleDifficulty = Difficulty.EASY;
                else if (variante > 6 && variante < 9)//20%
                    obstacleDifficulty = Difficulty.NORMAL;
                else //10%
                    obstacleDifficulty = Difficulty.HARD;
                break;

            case NORMAL:
                if (variante <= 1)//20%
                    obstacleDifficulty = Difficulty.EASY;
                else if (variante > 1 && variante < 8)//60%
                    obstacleDifficulty = Difficulty.NORMAL;
                else//20%
                    obstacleDifficulty = Difficulty.HARD;
                break;

            case HARD:
                if (variante <= 0)//10%
                    obstacleDifficulty = Difficulty.EASY;
                else if (variante > 0 && variante < 4)//30%
                    obstacleDifficulty = Difficulty.NORMAL;
                else//60%
                    obstacleDifficulty = Difficulty.HARD;
                break;

            case RANDOM:
                int r = new Random().nextInt(3);
                switch (r) {
                    case 0:
                        obstacleDifficulty = Difficulty.EASY;
                        break;
                    case 1:
                        obstacleDifficulty = Difficulty.NORMAL;
                        break;
                    default:
                        obstacleDifficulty = Difficulty.HARD;
                        break;
                }

            default:
                if (variante <= 5)//60%
                    obstacleDifficulty = Difficulty.EASY;
                else if (variante > 5 && variante < 9)//30%
                    obstacleDifficulty = Difficulty.NORMAL;
                else //10%
                    obstacleDifficulty = Difficulty.HARD;
        }

        return obstacleDifficulty;

    }

    /**
     * Rajoute un modèle d'obstacle à la liste de modèles d'obstacle
     *
     * @param o Le modèle d'obstacle à rajouter
     */
    private void add(ModelObstacle o) {
        obstacles.add(o);

    }

    /**
     * Rajoute un Ennemy à la liste d'Ennemy
     *
     * @param e L'Ennemy à rajouter
     */
    public void add(Ennemy e) {
        ennemies.add(e);
    }

    /**
     * Rajoute un modèle d'item à la liste de modèles d'item
     *
     * @param item Le modèle d'item à rajouter
     */
    private void add(ModelItem item) {
        items.add(item);
    }

    /**
     * Supprime un modèle d'item à la liste de modèles d'item
     *
     * @param item Le modèle d'item à supprimer
     */
    public void remove(ModelItem item) {
        items.remove(item);
    }

    /**
     * Supprime un modèle d'obstacle à la liste de modèles d'obstacle
     *
     * @param o Le modèle d'obstacle à supprimer
     */
    public void remove(ModelObstacle o) {
        obstacles.remove(o);
    }

    /**
     * Accesseur du nombre d'items
     *
     * @return le nombre d'items
     */
    public int getItemNbr() {
        return items.size();
    }

    /**
     * Accesseur du nombre d'obstacles à créer dès le début
     *
     * @return le nombre d'obstacles à créer dès le début
     */
    public int getNbr_ObsDeb() {
        return nbr_ObsDeb;
    }

    /**
     * Accesseur du nombre d'Obstacles
     *
     * @return le nombre d'Obstacles dans la liste
     */
    public int getObstacleNbr() {
        return obstacles.size();
    }

    /**
     * Vide le Path ( les Listes)
     */
    public void cleanPath(){
        this.ennemies.clear();
        this.items.clear();
        this.obstacles.clear();
        this.nbr_ObsDeb=0;
    }

    /**
     * Accesseur de la liste de modèles d'obstacle du path
     *
     * @return la liste d'obstacles du path
     */
    public List<ModelObstacle> getObstacles() {
        return obstacles;
    }

    /**
     * Accesseur des ennemies du path (non utilisé)
     *
     * @return la liste des ennemies du path
     */
    public List<Ennemy> getEnnemies() {
        return ennemies;
    }

    /**
     * Accesseur de la liste de modèles d'items du path
     *
     * @return la liste d'items du path
     */
    public List<ModelItem> getItem() {
        return items;
    }

    /**
     * Accesseur de la position où ajouter le prochain obstacle
     *
     * @return la position où ajouter le prochain obstacle
     */
    public double getPosY() {
        return posY;
    }

    /**
     * Teste si le path est fini
     *
     * @return si le path est fini
     */
    public boolean isFinite() {
        return isFinite;
    }

    /**
     * Teste si le path correspond à une partie en CircleHell
     *
     * @return si le path correspond à une partie en CircleHell
     */
    public boolean isCircleHell() {
        return isCircleHell;
    }

    /**
     * Accesseur de la position en y de ligne d'arrivée
     *
     * @return la position en y de ligne d'arrivée
     */
    public double getFinishLine() {
        return finishLine;
    }

    /**
     * Mutateur de la position en y de ligne d'arrivée
     *
     * @param finishLine La nouvelle position en y de la ligne d'arrivée
     */
    public void setFinishLine(double finishLine) {
        this.finishLine = finishLine;
    }

    /**
     * Accesseur de la largeur de la scène
     *
     * @return la largeur de la scène
     */
    public double getScWidth() {
        return scWidth;
    }

    /**
     * Accesseur de la hauteur de la scène
     *
     * @return la hauteur de la scène
     */
    public double getScHeight() {
        return scHeight;
    }

}
