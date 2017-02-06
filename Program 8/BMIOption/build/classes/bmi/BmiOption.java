/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package bmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author James
 */
public class BmiOption {

    public static void main(String[] args) {
        int i = 0;
        //While loop to run program.
        while (i == 0) {
            JButton open = new JButton();

            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new java.io.File("."));

            if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

                File file = new File(fc.getSelectedFile().getAbsolutePath());

                try {
                    Scanner scanner = new Scanner(new FileInputStream(file));

                    int value = scanner.nextInt();
                //System.out.println("Read Value: " + value);
                    //System.out.println("BMI Report:");
                    int height;
                    int weight;
                    String name = "";
                    String output = "";
                    while (scanner.hasNextLine()) {
                        height = scanner.nextInt();
                        weight = scanner.nextInt();
                        name = scanner.nextLine();
                        BmiRecord rec = new BmiRecord(name, height, weight);
                        //System.out.println(rec.report());
                        output += (" " + rec.report() + "\n");

                    }
                    int dialogButton = JOptionPane.YES_NO_OPTION;

                    int dialogResult = JOptionPane.showConfirmDialog(null, output
                            + "\nWould you like to try another file?",
                            "BMI Calculations by James Vanaselja", dialogButton);
                    if (dialogResult == 0) {
                    //System.out.println("Yes option");

                    //repeat
                    } else {
                        JOptionPane.showMessageDialog(null, "Session ended.");
                    //System.out.println("No Option");
                        //i is incremented to 1, thus ending the loop.
                        i++;
                    }

                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");
                }

            } else {
                //i is incremented to 1, thus ending the loop.
                i++;
            }

        }
    }
}
