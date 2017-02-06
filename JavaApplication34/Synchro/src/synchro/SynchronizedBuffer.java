/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package synchro;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author James
 */
public class SynchronizedBuffer implements Buffer {

    private String buffer = "NIL";
    private boolean occupied = false;
    public int producer_wait_time = 1;
    public int consumer_wait_time = 1;

    public synchronized void put(String value) throws InterruptedException {
        
        while (occupied) {
           System.out.println("Producer wait # " + producer_wait_time
                   + "\t\t\t" +buffer+"\t\t"+occupied);
           // displayState("Buffer full. Producer waits.");
            wait();
            producer_wait_time++;
        }
       
        buffer = value;
        occupied = true;
        System.out.println("Producer writes: " + buffer);
        //displayState(a);
        notifyAll();

    }

    public synchronized String get() throws InterruptedException {
        while (!occupied) {
            
            System.out.println("Consumer wait #" + consumer_wait_time + "\t\t\t" 
                    + buffer+ "\t\t" + occupied);
            System.out.print("\n");
            //displayState("Consumer wait #");
            
                //System.out.print("@@@");
            
            wait();
            consumer_wait_time++;
        }
        occupied = false;
        System.out.println ( "Consumer reads: " + buffer);
        System.out.print("\n");
        
        //displayState(b);
        notifyAll();
        return buffer;
    }

    private synchronized void displayState(String operation) {
        System.out.printf("%-40s%s\t\t%b%n%n", operation, buffer, occupied);

    }
}
