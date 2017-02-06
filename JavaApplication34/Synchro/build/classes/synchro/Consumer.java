/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package synchro;

import java.security.SecureRandom;

/**
 *
 * @author James
 */
public class Consumer implements Runnable{
    
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;
    String input = null;
    public Consumer (Buffer sharedLocation, String inputString){
        this.sharedLocation = sharedLocation;
        this.input = inputString;
    }
    @Override
    public void run() {
         String [] inputstringarray = input.split(" ");
        
        for (int i=1; i<= inputstringarray.length; i++){
            try{
                Thread.sleep(generator.nextInt(3000));
                inputstringarray[i-1] = sharedLocation.get();
                
                //System.out.println("\t\t\t\t" + inputstringarray[i]);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        //System.out.println("\nConsumer Summary: " + input + "\n");
                
    }
    
}
