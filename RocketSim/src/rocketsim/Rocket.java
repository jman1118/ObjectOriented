
/* Name: James Vanaselja
 * Course: COP 3330 - Spring 2015
 * University of Central Florida
 */
package rocketsim;

import blobfx.*;
import java.awt.*;
import java.awt.event.*;

public class Rocket extends PolyBlob implements BlobAction {

    private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    private final int[] x = {10, -10, -5, -10};
    private final int[] y = {0, -7, 0, 7};

    private final int[] xRef = {10, -10, -5, -10};
    private final int[] yRef = {0, -7, 0, 7};

    public Rocket() {
        super(300, 300, 0);

        setPolygon(x, y);
    }

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

}
