/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class Helloworld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // The file name will be part of the command line
        File file = new File(args[0]);
        try{
            Scanner scanner = new Scanner(new FileInputStream(file));
            
            while(scanner.hasNextLine())
            {  String name = scanner.nextLine();
            System.out.println("GoodBye, " + name);
        
    
            }
        }
       catch(FileNotFoundException ex) {
           System.out.println ("File not found");
    }
    
 }
 }
