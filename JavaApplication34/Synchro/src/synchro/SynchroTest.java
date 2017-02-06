/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package synchro;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author James
 */
public class SynchroTest {
    
     

    public static void main(String[] args) throws InterruptedException {
       ArrayList <String> input = new ArrayList <>();
       int flag = 0;
       // String input = "";
        JButton open = new JButton();
        //int wordcount = 0;
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File("."));

        if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

            File file = new File(fc.getSelectedFile().getAbsolutePath());

            try {
                Scanner scanner = new Scanner(new FileInputStream(file));
                while (scanner.hasNext() == true) {
                     input.add(scanner.next());
                     flag++;
                    
                    //input += " " + scanner.next();
                    // wordcount++;
                }
                

            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
           
    StringBuilder a = new StringBuilder();
    
           //System.out.println("Input is: " + input);
            for(int i=0; i<input.size(); i++){
                a.append(input.get(i));
                a.append(" ");
            }
            JOptionPane.showMessageDialog(null, "Input sentence: \n" + a);
            
        }else { System.exit(-1); }     
        StringBuilder e = new StringBuilder();
    
           //System.out.println("Input is: " + input);
            for(int i=0; i<input.size(); i++){
                e.append(input.get(i));
                e.append(" ");
            }
        String output = e.toString();
        
     
        String sendtoproducer = "";
       sendtoproducer = e.toString();
        
        //System.out.println("Flag value is: " + flag);
        //String inputString = input.toString();
        System.out.println("COP3330 Program 10 output for James Vanaselja\n");
        System.out.printf("%-40s%s\t\t%s%n%-40s%s%n%n", "Operation",
                "Buffer", "Occupied", "---------", "------\t\t--------");
        Buffer sharedLocation = new SynchronizedBuffer();
        
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        executorService.execute(new Producer (sharedLocation, sendtoproducer));
        executorService.execute(new Consumer (sharedLocation, sendtoproducer));
        
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
    } 
    
}
