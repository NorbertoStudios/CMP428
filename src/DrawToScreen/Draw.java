package DrawToScreen;

import java.awt.Graphics;
import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Draw extends Applet implements Runnable, KeyListener
{
    int x1, x2, y1, y2;
    Thread t;

    boolean lt_pressed = false;
    boolean rt_pressed = false;
    boolean up_pressed = false;
    boolean dn_pressed = false;


    public Draw() {

    }


    public void init() {
        t = new Thread(this);
        t.start();

    }

    public void run()
    {
        while (true)
        {
            // asynchronous input

//            if(lt_pressed) myBird.moveLeft(1);
//            if(rt_pressed) myBird.moveRight(1);
//            if(up_pressed) myBird.moveUp(1);
//            if(dn_pressed) myBird.moveDown(1);

            // AI
            // Collision Detection

            repaint();

            try {
                t.sleep(16);
            }catch (Exception o) {}
        }
    }

    public void paint(Graphics g) {

        int[] xpoint = {100,200,240,110,60};
        int[] ypoint = {100, 80, 200, 210, 180};

        //g.drawLine(x1,y1,x2,y2);
        // drawHLine(200,1000, 500, g);
        //drawVLine(200,700, 500, g);
       // drawVLine(400, 300, 200, g);
        //drawRect(100, 100, 400, 200, g);
        //drawLine(30, 50, 100,490, g);
        drawPolygon2(xpoint, ypoint, 5, g);

    }

    public void drawPoint(int x, int y, Graphics g) {
        g.drawLine(x, y, x, y);
    }

    public void drawHLine(int x1, int x2, int y, Graphics g) {
        for (int x = min(x1, x2); x <= max(x1,x2); x++) {
            drawPoint(x, y, g);
        }
    }

    public void drawVLine(int x, int y1, int y2, Graphics g) {
        for (int y = min(y1, y2); y <= max(y1,y2); y++) {
            drawPoint(x, y, g);
        }
    }

    public void drawRect(int x, int y, int w, int h, Graphics g) {
        // g.drawRect(x,y,w,h);

        drawHLine(x, x + w, y, g);

        drawHLine(x, x + w, y + h, g);

        drawVLine(x, y, y + h, g);

        drawVLine(x + w, y, y + h, g);
    }

    public void drawLine(int x1, int y1, int x2, int y2, Graphics g) {

        int dx = x2 - x1;
        int dy = y2 - y1;

        if(dx == 0)   drawVLine(x1, y1, y2, g);
        else
        if(dy == 0)   drawHLine(x1, x2, y1, g);
        else
        {
            double m = (double)dy / dx;

            if(m <= 1)
            {
                double y = y1;

                for(int x = x1; x <= x2; x++)
                {
                    drawPoint(x, (int)y, g);

                    y += m;
                }
            }
            else
            {
                double x = x1;

                for(int y = y1; y <= y2; y++)
                {
                    drawPoint((int)x, y, g);

                    x += 1/m;
                }

            }
        }
    }

    public int min(int a, int b)
    {
        if(a < b)
        {
            System.out.println("Min equals" + a);
            return a;
        }else
            System.out.println("Min" + b );
        return b;
    }
    public int max(int a, int b)
    {
        if(a > b)
        {
            System.out.println(" Max a equals" + a);
            return a;
        }
        else
            System.out.println("Max equals" + b);
        return b;
    }

    // better way to write lines
    // using recursive methods - for loop is more efficient

//    public void


    //Polygon - my version - too expensive
//    public void drawPolygon(int[] xpoitns, int[] ypoints, Graphics g)
//    {
//        for (int i = 0; i < xpoitns.length ; i++) {
//            if(i != xpoitns.length -1) {
//                drawLine(xpoitns[i], ypoints[i], xpoitns[i+1], ypoints[i+1], g);
//            }
//            else {
//                drawLine(xpoitns[i], ypoints[i], xpoitns[0], ypoints[0], g);
//            }
//        }
//    }

    //Polygon - better
    public void drawPolygon2(int[] xpoints, int[] ypoints,int n, Graphics g)
    {
        for (int i = 0; i < n-1; i++) {
                //drawLine(xpoints[i], ypoints[i], xpoints[i+1], ypoints[i+1], g);
                g.drawLine(xpoints[i], ypoints[i], xpoints[i+1], ypoints[i+1]);


        }
        //drawLine(xpoints[n-1], ypoints[n-1], xpoints[0], ypoints[0], g);
        g.drawLine(xpoints[n-1], ypoints[n-1], xpoints[0], ypoints[0]);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_LEFT) { lt_pressed = true;}
        if(e.getKeyCode() == e.VK_RIGHT) {rt_pressed = true;}
        if(e.getKeyCode() == e.VK_UP) {up_pressed = true;}
        if(e.getKeyCode() == e.VK_DOWN) {dn_pressed = true;}
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        lt_pressed = false;
        rt_pressed = false;
        up_pressed = false;
        dn_pressed = false;
    }
}
