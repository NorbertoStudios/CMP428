package DrawToScreen;

import twoD.Tank3;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawAndMove5 extends Applet implements Runnable, KeyListener {
    Tank3[] tank = new Tank3[10];
    Tank3 myTank;
    Thread t;

    Image       offscreen;
    Graphics    offScreen_g;

    boolean[] pressed = new boolean[1024];

    boolean lt_pressed = false;
    boolean rt_pressed = false;
    boolean up_pressed = false;
    boolean dn_pressed = false;

    boolean a_pressed = false;
    boolean d_pressed = false;
    boolean w_pressed = false;
    boolean s_pressed = false;

    boolean _1Pressed = false;
    boolean _2Pressed = false;

    public DrawAndMove5() {
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
        while (true) {
            if (lt_pressed) myTank.rotate(-2);
            if (rt_pressed) myTank.rotate(2);
            if (up_pressed) myTank.moveForward(4);
            if (dn_pressed) myTank.moveForward(-4);

            if (a_pressed) myTank.rotateGun(5);
            if (d_pressed) myTank.rotateGun(-5);

            if (_1Pressed) myTank = tank[1];
            if (_2Pressed) myTank = tank[2];

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
        if (e.getKeyCode() == e.VK_LEFT) {
            lt_pressed = true;
        }
        if (e.getKeyCode() == e.VK_RIGHT) {
            rt_pressed = true;
        }
        if (e.getKeyCode() == e.VK_UP) {
            up_pressed = true;
        }
        if (e.getKeyCode() == e.VK_DOWN) {
            dn_pressed = true;
        }

        if (e.getKeyCode() == e.VK_D) {
            d_pressed = true;
        }
        if (e.getKeyCode() == e.VK_A) {
            a_pressed = true;
        }

        if (e.getKeyCode() == e.VK_1) {
            _1Pressed = true;
        }
        if (e.getKeyCode() == e.VK_2) {
            _2Pressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == e.VK_LEFT) {
            lt_pressed = false;
        }
        if (e.getKeyCode() == e.VK_RIGHT) {
            rt_pressed = false;
        }
        if (e.getKeyCode() == e.VK_UP) {
            up_pressed = false;
        }
        if (e.getKeyCode() == e.VK_DOWN) {
            dn_pressed = false;
        }

        if (e.getKeyCode() == e.VK_D) {
            d_pressed = false;
        }
        if (e.getKeyCode() == e.VK_A) {
            a_pressed = false;
        }

        if (e.getKeyCode() == e.VK_1) {
            _1Pressed = false;
        }
        if (e.getKeyCode() == e.VK_2) {
            _2Pressed = false;
        }


    }
}
