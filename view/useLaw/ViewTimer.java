package view.useLaw;

import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import view.ViewPath;
import view.game.ball.BallPlayer;

import java.util.ArrayList;
import java.util.List;


public class ViewTimer {

    /**
     *
     */
    AnimationTimer timer;
    List<UseLaw> laws;
    Controller controller;

    public ViewTimer(BallPlayer ball, ViewPath path, Controller controller, Scene scene) {
        laws = new ArrayList<>();
        this.controller = controller;

        J j = new J();

        LabelScore score = new LabelScore(controller.getScore(), scene);
        laws.add(score);
        //laws.add(j);

        JtGravity gravity = new JtGravity(ball);
        //laws.add(gravity);

        MoveBall mv = new MoveBall(ball);
        //laws.add(mv);

        Jump jump = new Jump(ball, scene);
        //laws.add(jump);

        FollowBall fb = new FollowBall(scene, ball);
        LockBall lb = new LockBall(scene, ball);
        //laws.add(lb);
        //laws.add(fb);

        Race race = new Race(ball, scene);
        //laws.add(race);

        CollisionObstacle co = new CollisionObstacle(ball, path, controller);
        CollisionItem ci = new CollisionItem(ball, path, controller, path.getjItems());

        Tourni tourni = new Tourni(scene);
        //laws.add(tourni);
        //laws.add(tourni);

        //laws.add(co);
        //laws.add(ci);
        
        FinishLine finishLine = new FinishLine(path,ball,controller);
        laws.add(finishLine);


        timer = new AnimationTimer() {
            long startTime = System.currentTimeMillis();
            long checkpoint = startTime;


            @Override
            public void handle(long now) {
                long currentTime = System.currentTimeMillis();
                long duree = currentTime - startTime;

                checkpoint = currentTime - checkpoint;

                System.out.println("Last time : " + checkpoint + " ms");


                //System.out.println("Time : "+ duree + " ms");

                if (checkpoint >= 100) {
                    for (UseLaw j : laws) {
                        j.apply();
                    }
                    checkpoint = currentTime;
                }


            }

        };
    }

    public void play() {
        //timer.start();
    }


    //public ViewTimer(Game view.game,ViewPath path,BallPlayer ball, Scene scene) {


    public void start() {
        timer.start();
    }


    public void clean() {
        laws.clear();
        controller.clean();
    }
}
