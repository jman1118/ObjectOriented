
/* Name: James Vanaselja
 * Course: COP 3330 - Spring 2015
 * University of Central Florida
 */
package asteroidgame;

import blobmx.BlobAction;
import blobmx.BlobProximity;
import blobmx.BlobUtils;
import blobmx.PolyBlob;
import blobmx.SandBox;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.*;

public class Rocket extends PolyBlob implements BlobAction, BlobProximity {

    private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    private final int[] x = {10, -10, -5, -10};
    private final int[] y = {0, -7, 0, 7};

    private final int[] xRef = {10, -10, -5, -10};
    private final int[] yRef = {0, -7, 0, 7};

    public SandBox sb;

    public Rocket(int xloc, int yloc, SandBox sb) {
        super(300, 300, 0);
        this.sb = sb;
        setLoc(xloc, yloc);
        angle = 0;
        setPolygon(x, y);

    }

    @Override
    public void keyAction(KeyEvent e) {
        //Method for reading in Keyboard inputs.
        int k = e.getKeyCode();
        if (k == 37) {
            //left key
            angle = angle - delta;
            if (angle > 0) {
                angle = angle - (2 * Math.PI);
            }
            TurnRocket();

            //System.out.println(k);
        } else if (k == 32) {
            //Spacebar key.

            launch(this.sb);
            BlobUtils.playSound();
        } else if (k == 38) {
            //up key input.
            ForwardRocket();
            //System.out.println(keycode);
        } else if (k == 39) {
            //right key.
            angle = angle + delta;
            if (angle > (2 * Math.PI)) {
                angle = angle + (2 * Math.PI);
            }

            TurnRocket();
        }

    }

    public void ForwardRocket() {
        //Moves the rocket forward.
        int tempX = getLoc().x;
        int tempY = getLoc().y;
        setLoc(tempX + (int) Math.round(speed * Math.cos(angle)), tempY + (int) Math.round(speed * Math.sin(angle)));
    }

    public void TurnRocket() {
        //Turns the rocket.
        for (int i = 0; i < x.length; i++) {

            Point p = BlobUtils.rotatePoint(x[i], y[i], angle);
            xRef[i] = p.x;
            yRef[i] = p.y;
        }
        setPolygon(xRef, yRef);
    }

    public void launch(SandBox sb) {
        int BlobRadius = 0;

        BlobRadius = (getSize() / 2) + 5;
        
        
        Point a = getLoc();
        int NewX = (int) a.getX();
        int NewY = (int) a.getY();

        //xpot and ypot are the final positions of the missiles.
        int xpot = (int) (BlobRadius * cos(angle));
        int ypot = (int) (BlobRadius * sin(angle));
        int finalpointx = (NewX + xpot);
        int finalpointy = (NewY + ypot);

        Missile missile = new Missile(finalpointx, finalpointy, angle);

        sb.addBlob(missile);

        //rotatePoint();
    }

}
