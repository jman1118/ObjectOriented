/**
 *Name: James Vanaselja
 * Course: COP 3330 - Spring 2015
 * University of Central Florida
 */


package blobsim;


import blob.Blob;
import blob.SandBox;
import java.util.Random; 



public class BlobSim {
    public static void main(String[] args) {
                   
       //int [] b = new int [20];
       
       SandBox sb = new SandBox();
      //for (int i=0; i<20; i++){
       
        
       Blob b1 = new Blob ((randLocation()) ,(randLocation()), randMotion(), randMotion(), (randSize()));
       sb.addBlob(b1);
       //}            
       
           
        SandBox.simulate (sb);
                    
       
        
        for(int j = 0; j<10; j++)
        System.out.println(randLocation());
        
    }
    //Random Number Generator for beginning location.
    private static int randLocation()
    { 
        Random rand = new Random();
        int value = 30+rand.nextInt(340);
        return value;
    }
    //Random Number Generator for diameter
    private static int randSize () 
    {
        Random rand = new Random();
        int value_2 = 10+rand.nextInt(30);
        return value_2;
    }
    //Random Number Generator for motion.
    private static int randMotion()
    {
        Random rand = new Random();
        int value_3 = -4+rand.nextInt(100);
        return value_3;
    }
}
