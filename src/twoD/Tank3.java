package twoD;////

import java.awt.*;

////    Created     9/17/19, 7:54 PM
////    By:         Norberto Studios
////

public class Tank3 {
    private double x;
    private double y;
    private int angle = 0;

    Graphics g2d;

    public boolean isRotating = false;

    private final static int[] ybody = {20, -20, -20, 20};
    private final static int[] xbody = {35, 35, -35, -35};

    private final static int[] yLtrack = {-30, -20, -20, -30};
    private final static int[] xLtrack = {30, 30, -30, -30};

    private final static int[] yRtrack = {30, 20, 20, 30};
    private final static int[] xRtrack = {30, 30, -30, -30};

    private final static int[] yhatch = {-10, 10, 10, -10};
    private final static int[] xhatch = {-10, -10, 10, 10};

    private final static int[] ygun = {2, -2, -2, 2};
    private final static int[] xgun = {10, 10, 30, 30};

    private int[] xp = new int[4];
    private int[] yp = new int[4];

    private int[] xp1 = new int[4];
    private int[] yp1 = new int[4];

    public Tank3(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public Tank3(int x, int y, int angle)
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
            xp[i] =  (int)((xa[i] * cos - yb[i] * sin) + x);
            yp[i] =  (int)((yb[i] * cos + xa[i] * sin) + y);
        }
        g2d.drawPolygon(xp, yp, 4);
    }

    public void moveForward(int distance)
    {
        double radians = angle * Math.PI/180;

        double dx = distance * Math.cos(radians);
        double dy = distance * Math.sin(radians);

        x += dx;
        y += dy;
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

    public void rotate(int dangle)
    {
        angle += dangle;

        if (angle >= 360 || angle <= -360) {
            angle = 0;
        }
        System.out.println(angle);
    }

    public  void rotateGun(int dAngle)
    {
        drawing(xgun,ygun);
    }

}


