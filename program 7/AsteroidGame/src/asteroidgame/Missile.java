/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package asteroidgame;

import blobmx.Blob;
import blobmx.BlobProximity;

public class Missile extends Blob implements BlobProximity {

    double speed = 5.0;
    int size = 5;
    int distance = 5;
    double angle = 0.0;

    public Missile(int idx, int idy, double angle) {
        super(idx, idy);

       int dx = (int) Math.round(speed * Math.cos(angle));
       int dy = (int) Math.round(speed * Math.sin(angle));

        setLoc(idx, idy);
        setDelta(dx, dy);

    }

}
