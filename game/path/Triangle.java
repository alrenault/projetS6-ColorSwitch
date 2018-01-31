package game.path;

import game.Colorable;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class Triangle extends Shapes {

    private int height;
    private  double k;
    public Triangle(int x, int y, int height, int width, boolean mouvementDirection, boolean acceleration, int _mouvementSpeed, Color[] colors, int pos_color) {
        super(x, y, width, mouvementDirection, acceleration, _mouvementSpeed, colors, pos_color);
        this.height = height;
        k = ((double)height- (3.0 *(double) width))/(double)height;
        this.shape = buildTriangle();
    }

    private Group buildTriangle() {
        Group t = new Group();
        Circle milieu = new Circle(x,y,5,5,1,false,false,1, Colorable.WHITE,0);
        double xa, ya, xb,yb,xc,yc,xd,yd,xe,ye,xf,yf,j;
        Polygon Drogon,Viserion,Rhaegal;
        Drogon=new Polygon();
        Viserion=new Polygon();
        Rhaegal=new Polygon();
        j = (Math.sqrt((4.0*(double)height*(double)height)/5.0));

        xa= x;
        ya= y - ((double)height/2.0);//+
        xb = x + (j / 2.0);
        yb= y + ((double)height/2.0);
        xc= x + ((j / 2.0)* k);
        yc=yb -(double) width;
        xd = x;
        yd = ya +2.0*width;


        xe = x - (j / 2.0);
        ye=yb;


        xf=x - ((j / 2.0)* k);
        yf=yc;




        Drogon.getPoints().addAll(xa,ya, xb,yb, xc,yc, xd,yd);
        Viserion.getPoints().addAll(xb,yb, xe,ye, xf,yf, xc,yc);
        Rhaegal.getPoints().addAll(xe,ye, xf,yf, xd,yd, xa,ya);




        color(Drogon);
        verifPosColor();
        color(Viserion);
        verifPosColor();
        color(Rhaegal);
        verifPosColor();
/*
        Dragon.getPoints().addAll(xa,ya, xb,yb, xe,ye );

        color(Dragon);
        verifPosColor();

        Dragon2.getPoints().addAll(xd,yd, xc,yc, xf,yf );

        color(Dragon2);
        verifPosColor();
*/
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
       // t.getChildren().add(milieu.getShape());

        t.getChildren().add(Drogon);
        t.getChildren().add(Viserion);
        t.getChildren().add(Rhaegal);

        System.out.println(x);
        System.out.println(y);
        System.out.println();
        System.out.println(height);
        System.out.println(width);
        System.out.println();
        System.out.println(j);
        System.out.println(k);
        System.out.println();
        System.out.println(xa);
        System.out.println(ya);

        System.out.println(xb);
        System.out.println(yb);
        System.out.println(xc);
        System.out.println(yc);
        System.out.println(xd);
        System.out.println(yd);
        System.out.println(xe);
        System.out.println(ye);
        System.out.println(xf);
        System.out.println(yf);
      //  t.getChildren().add(Dragon);
       // t.getChildren().add(Dragon2);
        //t.getChildren().add(milieu.getShape());
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
