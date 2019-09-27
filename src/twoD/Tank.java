package twoD;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Tank {
    private int x;
    private int y;

    int test = 0;
    Graphics g2d;

    private double degree = 0;

    public boolean isRotating = false;

    private int[] xbody = {50, -50, -50, 50};
    private int[] ybody = {70, 70, -70, -70};

    private int[] xLtrack = {-65, -50, -50, -65};
    private int[] yLtrack = {60, 60, -60, -60};

    private int[] xRtrack = {65, 50, 50, 65};
    private int[] yRtrack = {60, 60, -60, -60};

    private int[] xhatch = {20, -20, -20, 20};
    private int[] yhatch = {20, 20, -20, -20};

    private int[] xgun = {5, -5, -5, 5};
    private int[] ygun = {-20, -20, -60, -60};

    private int[] xp = new int[4];
    private int[] yp = new int[4];

    private int[] xp1 = new int[4];
    private int[] yp1 = new int[4];

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void draw(Graphics g)
    {
        g2d = g;

        drawing(xbody, ybody);
        drawing(xRtrack, yRtrack);
        drawing(xLtrack, yLtrack);
        drawing(xhatch, yhatch);
        //--------//
       // if(xp1[0] <= xgun[0]) {

           // drawing(xgun, ygun);
       // }else {
            drawing(xp1, yp1);
        //}
        //g.fillPolygon(xp, yp, 4);
    }

    private void drawing(int[] xa, int[] yb) {
        for (int i = 0; i < 4; i++) {
            xp[i] = xa[i] + x;
            yp[i] = yb[i] + y;
        }
        g2d.drawPolygon(xp,yp,4);
    }

    //    private void xAndYBody() {
//        for (int i = 0; i < 4; i++) {
//            xp[i] = xbody[i] + x;
//            yp[i] = ybody[i] + y;
//        }
//    }
//
//    private void xAndYRTrack() {
//        for (int i = 0; i < 4; i++) {
//            xp[i] = xRtrack[i] + x;
//            yp[i] = yRtrack[i] + y;
//        }
//    }
//
//    private void xAndYLTrack() {
//        for (int i = 0; i < 4; i++) {
//            xp[i] = xLtrack[i] + x;
//            yp[i] = yLtrack[i] + y;
//        }
//    }
//
//    private void xAndYHatch() {
//        for (int i = 0; i < 4; i++) {
//            xp[i] = xhatch[i] + x;
//            yp[i] = yhatch[i] + y;
//        }
//    }
//
//    private void xAndYGun() {
//        for (int i = 0; i < 4; i++) {
//            xp[i] = xp2[i] + x;
//            yp[i] = yp2[i] + y;
//        }
//    }

    public void moveLeft(int dx) {
        x -= dx;
    }

    public void moveRight(int dx) {
        x += dx;
    }

    public void moveUp(int dy) {
        y -= dy;
    }

    public void moveDown(int dy) {
        y += dy;
    }

    public void moveBy(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void rotateBy(double rad) {

        double d;

        // Delta angle = d
//      --------
        d = degree * 3.14f / 180;

        degree += rad;

        if (degree >= 360 || degree <= -360) {
            degree = 0;
        }

        System.out.println(degree);
//      ---------

        // Pivot
        // point to rotate from  X[1]-----*-----X[0]
        //int pivot = (xgun[0] + xgun[1]) / 2;

        double cos = Math.cos(d);
        double sin = Math.sin(d);

        for (int i = 0; i < 4; i++) {

            xp1[i] = (int) (xgun[i] * cos - ygun[i] * sin);
            yp1[i] = (int) (ygun[i] * cos + xgun[i] * sin);

//                xp1[i] = xp2[i] + x;
//                yp1[i] = yp2[i] + y;


//                xp1[i] =  (int) (xgun[i] * cos - ygun[i] * sin) + x;
//                yp1[i] =  (int) (ygun[i] * cos + xgun[i] * sin) + y;

        }

        System.out.println("_________________");

    }
}
