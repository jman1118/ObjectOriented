/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package example.histogram;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class BarChartPanel extends JPanel{
    
    private final int[] histo = new int [26];
    private final int maxHeight = 260;
    
    public void setHisto(int[] inputHisto) {
        scale(inputHisto);
    }
    
    @Override 
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        setBackground (Color.WHITE);
        drawLines(g);
        drawHisto(g);
    }
    
    private void scale (int [] inp) {
        int max = findMax(inp);
        for (int i=0; i<histo.length; i++){
            double scaled = maxHeight * (((double) inp[i]) /max);
            histo [i] = (int) Math.floor(scaled);
            
        }
        
    }
    private int findMax(int[] inp) {
        int max =inp[0];
        for (int i=0;i<inp.length; i++){
            if (inp[i] > max){
                max = inp[i];}
            
            }
        return max;
    }
    
    private void drawLines (Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(50,30,50,300);
        g.drawLine(50, 300, 360, 300);
    }
    private void drawHisto (Graphics g) {
        for (int i=0; i< histo.length; i++){
            int x=50 +10 *i;
            int y= 40 + (260 - histo[i]);
            g.drawRect(x, y, 10, histo[i]);
        }
        
    }
}
