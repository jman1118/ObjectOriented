/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmi;

/**
 * Name: James Vanaselja Course: COP 3330 - Spring 2015 University of Central
 * Florida
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bmi {

    public static void main(String args[]) {

        // The file name will be part of the command line
        File file = new File(args[0]);
        //File here = new File (".");
       //System.out.println(here.getAbsolutePath());
        try {
            Scanner scanner = new Scanner(new FileInputStream(file));
            
            int value = scanner.nextInt(); 
            //System.out.println("Read Value: " + value);
                    
            int count = 1;
            
            System.out.println("BMI Report:");
            
            //While loop to read file.
            while (scanner.hasNextLine()) {
                int height = scanner.nextInt();
                int weight = scanner.nextInt();
                String name = scanner.nextLine();
             
                //BMI formula
                double BMI = (double)(weight * 703)/((height)*(height));
                               
                
              
               
                System.out.print (name +
                 "\t" + height + "\t" + "inches"+ " "+ 
                   weight + "\t" + "pounds" + "\t");
                System.out.format("BMI: %.1f" + "\t", BMI);
                        
                  count++;
                  // Nested if/else statements to print output to the screen
                    if(BMI<18.5)
                {
                    System.out.println("Underweight");
                }
                else if (BMI<25.9 && BMI>18.5)
                {
                    System.out.println("Normal");
                }
                else if (BMI<29.9 && BMI>25)
                {
                    System.out.println("Overweight");
                }
                else if (BMI>30)
                { 
                    System.out.println("Obese");
                }
                else 
                {
                   System.out.println("Invalid entry");
                }
                  
            }
                 scanner.close(); 
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

    }
}
