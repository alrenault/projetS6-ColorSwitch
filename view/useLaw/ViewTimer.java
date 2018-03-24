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


public class ViewTimer {

    /**
     *
     */
    private AnimationTimer timer;
    private HashSet<UseLaw> laws;
    private Controller controller;
    private Scene scene;
    private BallPlayer ballPlayer;
    private ViewPath path;
    private Group interfaceGame;

    public ViewTimer(BallPlayer ball, ViewPath path, Controller controller, Scene scene, Universe u, Group interfaceGame) {
        this.controller = controller;
        this.scene = scene;
        this.ballPlayer = ball;
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
                    }
                    checkpoint = currentTime;
                }


            }

        };
    }

    public HashSet<UseLaw> createSet(Universe u) {
        HashSet<UseLaw> res = new HashSet<>();
        for (LawType l : u.getBanq()) {
            switch (l) {
                case J:
                    res.add(new J());
                    break;
                case Jump:
                    res.add(new Jump(ballPlayer, scene));
                    break;
                case Race:
                    res.add(new Race(ballPlayer, scene));
                    break;
                case Gravity:
                    res.add(new JtGravity(ballPlayer));
                    break;
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
                    res.add(new LockBall(scene, ballPlayer, interfaceGame));
                    break;
                case Tourni:
                    res.add(new Tourni(scene));
                    break;
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

    public void play() {
        timer.start();
    }


    //public ViewTimer(Game model.game,ViewPath path,BallPlayer ball, Scene scene) {


    public void start() {
        timer.start();
    }

    public HashSet<UseLaw> getLaws() {
        return laws;
    }

    public void clean() {
        laws.clear();
    }
}
