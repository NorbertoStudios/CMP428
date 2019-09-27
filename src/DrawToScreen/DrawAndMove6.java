package DrawToScreen;

import twoD.Tank3;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawAndMove6 extends Applet implements Runnable, KeyListener {
    Tank3[] tank = new Tank3[10];
    Tank3 myTank;
    Thread t;

    Image       offscreen;
    Graphics    offScreen_g;

    boolean[] pressed = new boolean[1024];

    public DrawAndMove6() {
//        tank1 = new Tank3(200,200, 0);
//        tank2 = new Tank3(500,400, 180);
//
//        tank = tank1;

        this.setFocusable(true);
        addKeyListener(this);
    }

    public void init() {
        setSize(new Dimension(1200, 900));

        // initialize the offscreen image
        offscreen   = createImage(1200,900);
        offScreen_g = offscreen.getGraphics();



        for (int i = 0; i < tank.length; i++) {
            tank[i] = new Tank3(100 + 80 * i, 100 +1 * i);
        }

        myTank = tank[0];

        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true)
        {
            if(pressed[KeyEvent.VK_1]) { myTank = tank[1]; }
            if(pressed[KeyEvent.VK_2]) { myTank = tank[2]; }
            if(pressed[KeyEvent.VK_3]) { myTank = tank[3]; }

            if(pressed[KeyEvent.VK_LEFT]) { myTank.rotate(-2); }
            if(pressed[KeyEvent.VK_RIGHT]) { myTank.rotate(2); }
            if(pressed[KeyEvent.VK_UP]) { myTank.moveForward(4);}
            if(pressed[KeyEvent.VK_DOWN]) { myTank.moveForward(-4);}

            repaint();

            try {
                t.sleep(16);
            } catch (Exception o) {
            }

        }

    }

    public void paint(Graphics g) {
        for (int i = 0; i < tank.length; i++) {
            tank[i].draw(g);
        }

    }

    public  void update(Graphics g)
    {
        offScreen_g.clearRect(0,0,1200,900);
        paint(offScreen_g);
        g.drawImage(offscreen,0,0,null);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
       pressed[e.getKeyCode()] = false;

    }
}
