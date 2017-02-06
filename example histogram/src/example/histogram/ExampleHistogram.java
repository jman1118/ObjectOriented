/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package example.histogram;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ExampleHistogram  {

    
    public static void main(String[] args) {
        JFrame frame = new JFrame ();
        frame.setLayout (new BorderLayout());
        
        BarChartPanel panel = new BarChartPanel();
        frame.add (panel, BorderLayout.CENTER);
        
        JPanel topPanel = new JPanel();
        JButton button = new JButton ("enter text");
        
        button.addActionListener(
                new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                String s = JOptionPane.showInputDialog("Enter text to analyze");
                int [] ltrs = histo(s);
                panel.setHisto(ltrs);
                panel.repaint();
            }
        });
        topPanel.add(button);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
    } public static int[] histo (String s) {
        s = s.toLowerCase();
        int[] letter = new int [26];
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (Character.isLetter(ch)){
                int num = ch - 'a';
                letter[num]++;
            }
        } return letter;
    }
    
}
