/*
 Name: James Vanaselja
 Course: COP3330 - Spring 2015
 University of Central Florida

 */
package asteroidsim;

import blobfx.SandBox;
import blobfx.SandBoxMode;
import java.util.Random;

public class AsteroidSim {

    public static void main(String[] args) {
        SandBox sandbox = new SandBox();
        sandbox.setSandBoxMode(SandBoxMode.FLOW);
        sandbox.setFrameRate(66);

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int a;
            int b;

            int r = (1 + random.nextInt(2));
            double rotation = 0;

            if (r == 1) {
                rotation = .1;
            }
            if (r == 2) {
                rotation = -.1;
            }
            //Do while loops to generate random velocity values.
            do {
                a = -3 + random.nextInt(7);

            } while (a == 0);
            do {
                b = -3 + random.nextInt(7);
            } while (b == 0);

            sandbox.addBlob(new Asteroid(a, b, rotation));

        }

        SandBox.simulate(sandbox);
    }

}
