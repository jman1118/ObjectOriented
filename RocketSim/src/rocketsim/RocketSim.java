/*
 * Name: james Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package rocketsim;

import blobfx.SandBox;
import blobfx.SandBoxMode;

public class RocketSim {

    public static void main(String[] args) {
        //Handles the sandbox

        SandBox sb = new SandBox();
        sb.setSandBoxMode(SandBoxMode.FLOW);
        sb.setFrameRate(66);
        //adds the rocket to the sandbox and simulates.
        sb.addBlob(new Rocket());
        SandBox.simulate(sb);
    }

}
