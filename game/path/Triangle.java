package game.path;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Triangle extends Shapes {

    private int height;

    public Triangle(int x, int y, int height, int width, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed, Color[] colors, int pos_color) {
        super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed, colors, pos_color);
        this.height = height;
        this.shape = buildTriangle();
    }

    private Group buildTriangle() {
        Group t = new Group();
        double xa, ya, xb,yb,xc,yc,xd,yd,xe,ye,xf,yf,valCote;
        Polygon Drogon,Viserion,Rhaegal;
        Drogon=new Polygon();
        Viserion=new Polygon();
        Rhaegal=new Polygon();
        valCote = (height * Math.sin(Math.toRadians(90))) / Math.sin(Math.toRadians(120));//=h/sin(120)
        xa= x;
        ya= y + 0.5*height;
        xb = x + (valCote / 2);
        yb= y + 0.5*height;
        xc=x+ 0.5*height - (width*(Math.sin(Math.toRadians(60))))/0.5;//(0.5 = Sin (30°)
        yc=y + 0.5*height - width;
        xd= x;
        yd = y - (0.5 * height) + ((width * (Math.sin(Math.toRadians(60)))) / 0.5);
        xe = x - (valCote / 2);
        ye=yb;
        xf=x+ 0.5*height + (width*(Math.sin(Math.toRadians(60))))/0.5;
        yf=yc;

        Drogon.getPoints().addAll(xa,ya, xb,yb, xc,yc, xd,yd);
        Viserion.getPoints().addAll(xb,yb, xe,ye, xf,yf, xc,yc);
        Rhaegal.getPoints().addAll(xe,ye, xf,yf, xa,ya, xd,yd);
        verifPosColor();
        Drogon.setFill(colors[pos_color]);
        verifPosColor();
        Viserion.setFill(colors[pos_color]);
        verifPosColor();
        Rhaegal.setFill(colors[pos_color]);


        /*
3 genre de rectangles biseautés

//Drogon, Viserion et Rhaegal


             // Create the Triangle
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(50.0, 0.0,	0.0, 50.0,100.0, 50.0);
      //  triangle.setFill(Color.WHITE);
        triangle.setStroke(Color.RED);

        gr.getChildren().add(triangle);

     D (xa,ya, xb,yb, xc,yc, xd,yd)
     Drogon.getPoints().addAll();
     V (xb,yb, xe,ye, xf,yf, xc,yc)
     Viserion.getPoints().addAll();
     R (xe,ye, xf,yf, xa,ya, xd,yd)
     Rhaegal.getPoints().addAll();

            1
        r  / \  d
          /   \
         2-----3
            v

            xa: x
            ya: y + 0.5h
            xb: x + 0.5h
            yb: y - 0.5h
            xc
            yc
            xd: x
            yd: y - 0.5h -(w*(Math.(Math.toRadians()))
            xe
            ye
            xf
            yf




            1 :
            le y est 1/2 height + y
                x=x

            2 :
            3 :


         */


        t.getChildren().add(Drogon);
       t.getChildren().add(Viserion);
        t.getChildren().add(Rhaegal);


        RotateTransition rotation = new RotateTransition(Duration.seconds(mouvementSpeed),t);


        rotation.setByAngle(360* ((mouvementDirection)? 1 :-1 ));

        rotation.setCycleCount((int)Double.POSITIVE_INFINITY);
        if (!acceleration) {
            rotation.setInterpolator(Interpolator.LINEAR);
        }


        //rotation.play();
        return t;
    }

}
