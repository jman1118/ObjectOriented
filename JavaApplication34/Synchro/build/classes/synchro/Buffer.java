/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package synchro;

/**
 *
 * @author James
 */
public interface Buffer {
    public void put(String value) throws InterruptedException;
    
    public String get() throws InterruptedException;
    
}
