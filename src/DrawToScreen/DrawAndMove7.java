package DrawToScreen;

import twoD.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DrawAndMove7 extends GameBase {

    Tank3[] tank = new Tank3[10];
    Tank3 myTank;

    Image       offscreen;
    Graphics    offScreen_g;

    public void initialize() {

        // initialize the offscreen image
        offscreen   = createImage(1200,900);
        offScreen_g = offscreen.getGraphics();

        for (int i = 0; i < tank.length; i++) {
            tank[i] = new Tank3(100 + 80 * i, 100 +1 * i);
        }

        myTank = tank[0];

    }

    @Override
    public void inGameLoop()
    {
        if(pressed[KeyEvent.VK_1]) { myTank = tank[1]; }
        if(pressed[KeyEvent.VK_2]) { myTank = tank[2]; }
        if(pressed[KeyEvent.VK_3]) { myTank = tank[3]; }

        if(pressed[KeyEvent.VK_LEFT]) { myTank.rotate(-2); }
        if(pressed[KeyEvent.VK_RIGHT]) { myTank.rotate(2); }
        if(pressed[KeyEvent.VK_UP]) { myTank.moveForward(4);}
        if(pressed[KeyEvent.VK_DOWN]) { myTank.moveForward(-4);}
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
}
