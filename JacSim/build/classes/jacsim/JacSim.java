/*
 *Name: James Vanaselja
 *Course: COP3330 - Spring 2015
 *University of Central Florida
 */
package jacsim;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JacSim {

    public static void main(String[] args) {
        //Scan in file and read in sentences.

        File file = new File(args[0]);
        //File file = new File("Textfile.txt"
        ArrayList<String> items = new ArrayList<String>();
        try { //System.out.println(here.getAbsolutePath());
            Scanner scanner = new Scanner(new FileInputStream(file));
            /*While scanner has another line of input, add those characters to 
             the arraylist of items.
             */
            while (scanner.hasNextLine()) {
                //String name = scanner.nextLine();
                items.add(scanner.nextLine());

            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

        System.out.println("Input Sentences:\n");
        /*Counter counts the number of sentences in the file.
         */

        int counter = 0;

        for (String s : items) {
            System.out.println((counter++) + ": " + s);
        }
        ArrayList<ArrayList<String>> shingles = new ArrayList<ArrayList<String>>();

        System.out.println("\nSorted Shingle Arrays:\n");

        for (int j = 0; j < items.size(); j++) {
            String sentence = items.get(j);
            ArrayList<String> shingleset = ShingleConverter(sentence);
            shingles.add(shingleset);
            Collections.sort(shingleset);
            System.out.println(j + ": " + shingles.get(j).toString());
       }
        
        int winner1 = 0;
        int winner2 = 0;
        double winningIndex = 0;
        System.out.println("\nJaccard Similarity Matrix" + ": \n");
        for (int i = 0; i < shingles.size(); i++) {
            for (int j = 0; j < shingles.size(); j++) {
                double index = 0;
                index = JacIndex(shingles.get(i), shingles.get(j));
                System.out.printf("%.4f ", index);
                /*if i is not equal to j and the index is greater then
                 winning index, the winningIndex will be equal to the index.
                 */
                if (i != j && index > winningIndex) {
                    winningIndex = index;
                    winner1 = i;
                    winner2 = j;
                }
            }
            System.out.println();
        }
        /* Print statements for the winning values.
         */
        System.out.print("\nMost similar sentences: " + winner1 + " and "
                + winner2 + " with Jaccard Value = ");
        System.out.printf("%.4f ", winningIndex);                                                                                    
    }
    /* This method (function) creates an arraylist called shingles that stores &
     creates the two character shingle sets. If a shingle does not contain another
     shingle of the same characters, it is added onto the shingles arraylist, 
     otherwise it is not added onto the list.
     */

    private static ArrayList<String> ShingleConverter(String item) {

        ArrayList<String> shingles = new ArrayList<>();

        for (int i = 0; i < item.length() - 1; i++) {
            String shingle = item.substring(i, i + 2);
            if (!shingles.contains(shingle)) {
                shingles.add(shingle);
            }

        }
        return shingles;
    }
    /* This method (function) reads in the shingle sets, compares them in a 
     matrix and outputs the Jaccard Index values.
     */

    private static double JacIndex(ArrayList<String> shingle1,
            ArrayList<String> shingle2) {
        double result = 0;
        int total = shingle1.size() + shingle2.size();
        int intersection = 0;
        int union = 0;
        for (int i = 0; i < shingle1.size(); i++) {
            for (int j = 0; j < shingle2.size(); j++) {
                shingle1.get(i);
                shingle2.get(j);
                if (shingle1.get(i).equals(shingle2.get(j))) {
                    intersection++;
                }
            }

        }
        union = total - intersection;
//        System.out.println(union);
//        System.out.println(intersection);

        result = ((double) intersection / union);
        return result;

    }

}
