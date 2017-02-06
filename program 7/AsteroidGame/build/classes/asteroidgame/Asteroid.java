
/* Name: James Vanaselja
 * Course: COP 3330 - Spring 2015
 * University of Central Florida
 */
package asteroidgame;

import blobmx.PolyBlob;
import java.util.Random;

public class Asteroid extends PolyBlob {

    private static Random random = new Random();

    public Asteroid(int idx, int idy, double rot) {
        super(idx, idy, rot);
        //Sets starting location.
        setLoc(-100, -100);
        //Sets velocity.
        setDelta(idx, idy);

        int sides = 5 + random.nextInt(5);

        int[] x = new int[sides];
        int[] y = new int[sides];

        double angle = 0.0;
        //Region is unit cirle/sides.
        double region = ((double) (2 * Math.PI) / sides);

        //For each side, generates a random radius
        //& the coordinate points, theta.
        //Note: Radius is half of diameter.
        for (int j = 0; j < sides; j++) {
            int radius = 5 + random.nextInt(10);
            //converting polar coords to cartsaeson points.
            x[j] = (int) (radius * Math.cos(angle));
            y[j] = (int) (radius * Math.sin(angle));
            //increment angle by region.
            angle += region;
        }

        //passes the array of coordinates into the polygon.
        setPolygon(x, y);

    }

}
