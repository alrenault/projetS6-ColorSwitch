package view.useLaw;

import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import modelLaw.LawType;
import modelLaw.Universe;
import view.ViewPath;
import view.game.ball.BallPlayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ViewTimer {

    /**
     *
     */
    AnimationTimer timer;
    HashSet<UseLaw> laws;
    Controller controller;
    private Scene scene;
    private BallPlayer ballPlayer;
    private ViewPath path;

    public ViewTimer(BallPlayer ball, ViewPath path, Controller controller, Scene scene,Universe u) {
    	this.controller = controller;
        this.scene=scene;
        this.ballPlayer=ball;


        laws=this.createSet(u);
        
        

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
                    	System.out.println(j);
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

    public HashSet<UseLaw> getLaws() {
        return laws;
    }

    public void clean() {
        laws.clear();
        controller.clean();
    }
}
