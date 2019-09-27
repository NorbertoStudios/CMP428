package DrawToScreen;

import twoD.Tank3;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawAndMove3 extends Applet implements Runnable, KeyListener
{
    Tank3 tank,tank1, tank2;
    Thread t;

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

    public DrawAndMove3()
    {
        tank1 = new Tank3(200,200, 0);
        tank2 = new Tank3(500,400, 180);

        tank = tank1;

        this.setFocusable(true);
        addKeyListener(this);
    }

    public void init()
    {
        setSize(new Dimension(1200,900));
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run()
    {
        while (true)
        {
            if(lt_pressed) tank.rotate(-2);
            if(rt_pressed) tank.rotate(2);
            if(up_pressed) tank.moveForward(4);
            if(dn_pressed) tank.moveForward(-4);

            if(a_pressed) tank.rotateGun(5);
            if(d_pressed) tank.rotateGun(-5);

            if(_1Pressed) tank = tank1;
            if(_2Pressed) tank = tank2;

            repaint();

            try {
                t.sleep(16);
            }catch (Exception o) {}

        }

    }

    public void paint(Graphics g)           { tank1.draw(g); tank2.draw(g); }

    @Override
    public void keyTyped(KeyEvent e)        { }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == e.VK_LEFT) { lt_pressed = true;}
        if(e.getKeyCode() == e.VK_RIGHT) {rt_pressed = true;}
        if(e.getKeyCode() == e.VK_UP) {up_pressed = true;}
        if(e.getKeyCode() == e.VK_DOWN) {dn_pressed = true;}

        if(e.getKeyCode() == e.VK_D) {d_pressed = true; tank.isRotating=true;}
        if(e.getKeyCode() == e.VK_A) {a_pressed = true; tank.isRotating=true;}

        if(e.getKeyCode() == e.VK_1) {_1Pressed = true;}
        if(e.getKeyCode() == e.VK_2) {_2Pressed = true;}
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == e.VK_LEFT) { lt_pressed = false;}
        if(e.getKeyCode() == e.VK_RIGHT) {rt_pressed = false;}
        if(e.getKeyCode() == e.VK_UP) {up_pressed = false;}
        if(e.getKeyCode() == e.VK_DOWN) {dn_pressed = false;}

        if(e.getKeyCode() == e.VK_D) {d_pressed = false;}
        if(e.getKeyCode() == e.VK_A) {a_pressed = false;}

        if(e.getKeyCode() == e.VK_1) {_1Pressed = false;}
        if(e.getKeyCode() == e.VK_2) {_2Pressed = false;}

        tank.isRotating = false;
    }
}
