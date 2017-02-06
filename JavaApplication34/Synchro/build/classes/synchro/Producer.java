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
public class Producer implements Runnable {
    
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;
    String input = null;
    String sentinel = "@@@";
   

    public Producer(Buffer sharedLocation, String sendtoproducer) {
        this.sharedLocation = sharedLocation;
        this.input = sendtoproducer;
    }
   
    @Override
    public void run() {
    String [] inputstringarray = input.split(" ");

        for (int i = 0; i < inputstringarray.length; i++) {
            try{
        
            Thread.sleep(generator.nextInt(3000));
            sharedLocation.put(inputstringarray[i]);
           if (inputstringarray[i] == " "){
               System.out.print("@@@");
           }
            //System.out.println("\t\t");

        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }
       // System.out.println("\nProducer : " + input + "\n");
    }
}