/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package asteroidgame;

import blobmx.BlobGUI;
import blobmx.BlobPanel;
import blobmx.SandBox;
import blobmx.SandBoxMode;
import java.util.Random;

public class AsteroidGame extends BlobPanel implements BlobGUI {

    SandBox sb = new SandBox();

    public static void main(String[] args) {
        AsteroidGame AG = new AsteroidGame();

    }

    public AsteroidGame() {
        //SandBox sb = new SandBox();
        sb.setSandBoxMode(SandBoxMode.FLOW);
        sb.setFrameRate(66);
        sb.init(this);

        //  generate();
    }

    @Override
    public void generate() {

        sb.addBlob(new Rocket(300, 300, sb));
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int a;
            int b;

            int r = (1 + random.nextInt(2));
            double rotation = 0.0;

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
            Asteroid ast = new Asteroid(a, b, rotation);
            sb.addBlob(ast);

        }

    }
}
