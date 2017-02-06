/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package javaapplication34;

/**
 *
 * @author James
 */
public class x {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int sum =0;
       int idx =1;
       while(true){
           sum+=idx;
           if(sum > 6){
               break;
           }
           System.out.println( "sum = " + sum + " for " + idx + " terms");
           idx++;
        }
       // System.out.println( "sum = " + sum + " for " + idx + " terms");
        
        
        
    }
    
}
