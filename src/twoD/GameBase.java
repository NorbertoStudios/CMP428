package twoD;////

////    Created     9/26/19, 8:55 PM
////    By:         Norberto Studios
////

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public abstract class GameBase extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    Thread t;

    public boolean[] pressed = new boolean[1024];

    protected abstract void initialize();
    protected abstract void inGameLoop();

    public void init() {

        setSize(new Dimension(1200, 900));

        initialize();

        this.setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        t = new Thread(this);
        t.start();
    }



    @Override
    public void run() {
        while (true)
        {
            inGameLoop();

            repaint();

            try {
                t.sleep(16);
            } catch (Exception o) {
            }

        }

    }



    public void keyTyped(KeyEvent e)            {}
    public void keyPressed(KeyEvent e)          { pressed[e.getKeyCode()] = true;  }
    public void keyReleased(KeyEvent e)         { pressed[e.getKeyCode()] = false; }

    public void mouseClicked(MouseEvent e)      {}
    public void mousePressed(MouseEvent e)      {}
    public void mouseReleased(MouseEvent e)     {}
    public void mouseEntered(MouseEvent e)      {}
    public void mouseExited(MouseEvent e)       {}
    public void mouseDragged(MouseEvent e)      {}
    public void mouseMoved(MouseEvent e)        {}
}

