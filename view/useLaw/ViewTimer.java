package view.useLaw;

import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import view.ViewPath;
import view.game.ball.BallPlayer;
import view.game.law.LawType;
import view.game.law.Universe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ViewTimer {

    /**
     *
     */
    AnimationTimer timer;
    List<UseLaw> laws;
    Controller controller;
    private Scene scene;
    private BallPlayer ballPlayer;
    private ViewPath path;

    public ViewTimer(BallPlayer ball, ViewPath path, Controller controller, Scene scene) {
        laws = new ArrayList<>();
        this.controller = controller;
        this.scene=scene;
      this.ballPlayer=ball;
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
        CollisionItem ci = new CollisionItem(ball, path, controller);

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
    public HashSet<UseLaw> createSet(Universe u){
        HashSet<UseLaw> res=new HashSet<>();
        for (LawType l : u.getBanq()){
            switch (l){
                case J:
                    res.add(new J());
                case Jump:
                    res.add(new Jump(this.ballPlayer,this.scene));
                case Race:
                    res.add(new Race(this.ballPlayer,this.scene));
                case JtGravity:
                    res.add(new JtGravity(this.ballPlayer));
                case MoveBall:
                    res.add(new MoveBall(this.ballPlayer));
                case CollisionItem:
                    res.add(new CollisionItem(this.ballPlayer,this.path,this.controller));
                case CollisionObstacle:
                    res.add(new CollisionObstacle(this.ballPlayer,this.path,this.controller));
                case LockBall:
                    res.add(new LockBall(this.scene,this.ballPlayer));
                case Tourni:
                    res.add(new Tourni(this.scene));
                case FinishLine:
                    res.add(new FinishLine(this.path,this.ballPlayer,this.controller));
                case LabelScore:
                    res.add(new LabelScore(this.controller.getScore(),this.scene));

            }


        }
        return res;
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
