package twoD;////

import java.awt.*;

////    Created     9/17/19, 7:54 PM
////    By:         Norberto Studios
////

public class Tank2 {
    private int x;
    private int y;
    private int angle = 0;

    Graphics g2d;

    public boolean isRotating = false;

    private final static int[] ybody = {50, -50, -50, 50};
    private final static int[] xbody = {70, 70, -70, -70};

    private final static int[] yLtrack = {-65, -50, -50, -65};
    private final static int[] xLtrack = {60, 60, -60, -60};

    private final static int[] yRtrack = {65, 50, 50, 65};
    private final static int[] xRtrack = {60, 60, -60, -60};

    private final static int[] yhatch = {20, -20, -20, 20};
    private final static int[] xhatch = {20, 20, -20, -20};

    private final static int[] ygun = {5, -5, -5, 5};
    private final static int[] xgun = {20, 20, 60, 60};

    private int[] xp = new int[4];
    private int[] yp = new int[4];

    private int[] xp1 = new int[4];
    private int[] yp1 = new int[4];

    public Tank2(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public Tank2(int x, int y, int angle)
    {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public void draw(Graphics g) {
        g2d = g;

        drawing(xbody, ybody);
        drawing(xRtrack, yRtrack);
        drawing(xLtrack, yLtrack);
        drawing(xhatch, yhatch);

        drawing(xgun,ygun);
    }

    private void drawing(int[] xa, int[] yb)
    {
        double radians = angle * 3.14/180;

        double cos = Math.cos(radians);
        double sin = Math.sin(radians);

        for (int i = 0; i < 4; i++)
        {
            xp[i] = (int) (xa[i] * cos - yb[i] * sin) + x;
            yp[i] = (int) (yb[i] * cos + xa[i] * sin) + y;
        }
        g2d.drawPolygon(xp, yp, 4);
    }

    public void moveForward(int distance)
    {
        double radians = angle * Math.PI/180;

        double dx = distance * Math.cos(radians);
        double dy = distance * Math.sin(radians);

        moveBy((int)dx,(int)dy);
    }

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
    public void rotate(double dangle)
    {
        angle += dangle;

        if (angle >= 360 || angle <= -360) {
            angle = 0;
        }

        System.out.println(angle);
    }

//    public void rotateBy(double rad) {
//
//        // Delta angle = d
////      --------
//        double radian = angle * 3.14f / 180;
//
//        angle += rad;
//
//        if (angle >= 360 || angle <= -360) {
//            angle = 0;
//        }
//
//        System.out.println(angle);
////      ---------
//
//        // Pivot
//        // point to rotate from  X[1]-----*-----X[0]
//        //int pivot = (xgun[0] + xgun[1]) / 2;
//
//        double cos = Math.cos(radian);
//        double sin = Math.sin(radian);
//
//        for (int i = 0; i < 4; i++) {
//
//            xp1[i] = (int) (xgun[i] * cos - ygun[i] * sin);
//            yp1[i] = (int) (ygun[i] * cos + xgun[i] * sin);
//
//        }
//
//        System.out.println("_________________");
//
//    }
}


