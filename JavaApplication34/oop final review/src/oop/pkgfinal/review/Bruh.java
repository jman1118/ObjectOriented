/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package oop.pkgfinal.review;

import java.util.Scanner;
import java.io.*;
import static oop.pkgfinal.review.Shades.*;

public class Bruh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a file name without extension: ");
        String userIn = sc.next();
        try {
            Scanner weee = new Scanner(new File(userIn + ".txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

        Bro chazz = new Bro("Chazz", 10.2, SHUTTERSHADES, 5000);
        Bro HogStrong = new Bro("Hogstrong the Strong", 7.0, AVIATORS,200);

        chazz.BroDown(HogStrong);
    }
}
