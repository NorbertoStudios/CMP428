package DrawToScreen;

import java.awt.*;

public class Rect
{
    protected int x,y,w,h; //Rectangle Point(x,y), width, height
    protected boolean held = false; // is able to be hold

    public Rect(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public  boolean contains(int mx, int my)
    {
        return ((mx > x) &&
                (mx < x+w) &&
                (my > y) &&
                (my < y+h));
    }

    public  void draw(Graphics g)
    {
        g.drawRect(x, y, w, h);
    }

    public void moveDown(int dy)        { y += dy; }
    public void moveUp(int dy)          { y -= dy; }
    public void moveRight(int dx)       { x += dx; }
    public void moveLeft(int dx)        { x -= dx; }

    public  void setPosition(int x, int y) // or moveTo()
    {
        this.x=x;
        this.y=y;
    }
    public void moveBy(int dx, int dy)
    {
        x += dx;
        y += dy;
    }
    public void resizeBy(int dw, int dh)
    {
        w += dw;
        h += dh;
    }

}
