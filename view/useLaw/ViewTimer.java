package view.useLaw;

import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import model.modelLaw.LawType;
import model.modelLaw.Universe;
import view.ViewPath;
import view.ball.BallPlayer;

import java.util.HashSet;

/**
 * Traitement des lois à chaque frame
 */
public class ViewTimer {

    /**
     * L'objet dont la méthod handle se répète continuellement
     */
    private AnimationTimer timer;
    
    /**
     * Ensemble de loi
     */
    private HashSet<UseLaw> laws;
    
    /**
     * Référence vers le controlleur
     */
    private Controller controller;
    
    /**
     * La scène
     */
    private Scene scene;
    
    /**
     * Le joueur
     */
    private BallPlayer ballPlayer;
    
    /**
     * Le viewPath contenant les obstacles
     */
    private ViewPath path;
    
    /**
     * L'interface du jeu
     */
    private Group interfaceGame;
    
    /**
     * Constructeur de ViewTimer
     * @param ball La balle représentant le joueur
     * @param path Le viewPath avec l'ensemble des obstacles
     * @param controller Référence ves le controlleur
     * @param scene La scène
     * @param u L'univers avec les lois
     * @param interfaceGame L'interface du jeu
     */
    public ViewTimer(BallPlayer ball, ViewPath path, Controller controller, Scene scene,Universe u, Group interfaceGame) {
    	this.controller = controller;
        this.scene=scene;
        this.ballPlayer=ball;
        this.path = path;
        this.interfaceGame = interfaceGame;


        laws = this.createSet(u);


        timer = new AnimationTimer() {
            long startTime = System.currentTimeMillis();
            long checkpoint = startTime;


            @Override
            public void handle(long now) {
                long currentTime = System.currentTimeMillis();
                long duree = currentTime - startTime;

                checkpoint = currentTime - checkpoint;



                //rintln("Time : "+ duree + " ms");

                if (checkpoint >= 100) {
                    for (UseLaw j : laws) {
                        j.apply();
                       /* if(ball.getY() > scene.getWidth()+ball.getLimiteJump()){
                        	controller.gameOver();
                        }*/
                    }
                    checkpoint = currentTime;
                }


            }

        };
    }
    
    /**
     * Crée l'ensemble des lois
     * @param u L'univers avec les lois
     * @return L'ensemble des lois utilisées
     */
    public HashSet<UseLaw> createSet(Universe u){
        HashSet<UseLaw> res=new HashSet<>();
        for (LawType l : u.getBanq()){
            switch (l){
                case Jump:
                    res.add(new Jump(ballPlayer, scene));
                    break;
                case Race:
                    res.add(new Race(ballPlayer, scene));
                    break;
                case Gravity:
                    res.add(new Gravity(ballPlayer)); break;
                case MoveBall:
                    res.add(new MoveBall(ballPlayer));
                    break;
                case CollisionItem:
                    res.add(new CollisionItem(ballPlayer, path, controller));
                    break;
                case CollisionObstacle:
                    res.add(new CollisionObstacle(ballPlayer, path, controller));
                    break;
                case LockBall:
                    res.add(new LockBall(scene,ballPlayer, interfaceGame)); break;
                case FinishLine:
                    res.add(new FinishLine(path, ballPlayer, controller));
                    break;
                case LabelScore:
                    res.add(new LabelScore(controller.getScore(), scene));
                    break;
                case Interface:
                    res.add(new InterfaceGame(scene, controller.getScore(), interfaceGame, ballPlayer));
                    break;
                case FollowBall:
                    res.add(new FollowBall(scene, ballPlayer, interfaceGame));
            }


        }
        return res;
    }

    /**
     * Lance le timer
     */
    public void play() {
        timer.start();
    }



    /**
     * Démarre le timer
     */
    public void start() {
        timer.start();
    }

    /**
     * Accesseur de l'ensemble des lois utilisées
     * @return L'ensemble des lois utilisées
     */
    public HashSet<UseLaw> getLaws() {
        return laws;
    }

    /**
     * Vide l'ensemble des lois utilisées
     */
    public void clean() {
        laws.clear();
    }
}
