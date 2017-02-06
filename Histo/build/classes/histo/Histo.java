/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package histo;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Histo extends javax.swing.JFrame {

    int SentenceIndex;
    private final int[] histo = new int[26];
    private final int maxHeight = 260;
    int[] letter = new int[26];
    ArrayList<String> input = new ArrayList<>();
    String[] sentence;
    int parser = 0;

    public Histo() {
        initComponents();
        this.setTitle("Letter Historgrams by James Vanaselja");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="GUI Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loadButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        idField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sourceArea = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        canvas = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 620));
        setMinimumSize(new java.awt.Dimension(1000, 620));
        setPreferredSize(new java.awt.Dimension(1000, 620));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 30));

        loadButton.setText("Load File");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        jPanel1.add(loadButton);

        showButton.setText("Show Histo for Sentence");
        showButton.setEnabled(false);
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });
        jPanel1.add(showButton);

        idField.setColumns(5);
        idField.setEnabled(false);
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        jPanel1.add(idField);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jSplitPane2.setDividerLocation(400);

        jPanel4.setPreferredSize(new java.awt.Dimension(400, 0));
        jPanel4.setLayout(new java.awt.BorderLayout());

        sourceArea.setColumns(20);
        sourceArea.setLineWrap(true);
        sourceArea.setRows(5);

        jScrollPane1.setViewportView(sourceArea);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane2.setLeftComponent(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        canvas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                canvasPropertyChange(evt);
            }
        });
        jPanel5.add(canvas, java.awt.BorderLayout.CENTER);

        jSplitPane2.setRightComponent(jPanel5);

        jPanel2.add(jSplitPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>                        

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {

        JButton open = new JButton();

        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new java.io.File("."));

        if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

            File file = new File(fc.getSelectedFile().getAbsolutePath());

            try {
                Scanner scanner = new Scanner(new FileInputStream(file));
                while (scanner.hasNextLine()) {
                    input.add(scanner.nextLine());
                }

            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }

            for (String s : input) {
                //System.out.println((counter++) + ": " + s);
                sourceArea.append((SentenceIndex++) + ": " + s + "\n\n");

            }
        }
        showButton.setEnabled(true);
        idField.setEnabled(true);
    }

    private int findMax(int[] inp) {
        int max = inp[0];
        for (int i = 0; i < inp.length; i++) {
            if (inp[i] > max) {
                max = inp[i];
            }

        }
        return max;
    }

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // System.out.println(SentenceIndex);
        //int[] letter = new int[26];
        if (showButton.isEnabled() == true) {
            try {
                if (evt.getSource() == idField) {
                    parser = Integer.parseInt(idField.getText());

                    if (parser < 0 || parser > SentenceIndex) {
                        JOptionPane.showMessageDialog(null, "Sentence index "
                                + "out of range");
                    }
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Text field is not an integer.");
            }
            String s = input.get(parser);
            s = s.toLowerCase();
           // int[] letter = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isLetter(ch)) {
                    int num = ch - 'a';
                    histo[num]++;
                }
                
                Graphics g = canvas.getGraphics();
                Graphics b = canvas.getGraphics();
                b.setColor(Color.BLUE);
                // letter=(histo(input.get(parser)));
                canvas.update(g);
                int max = findMax(histo);
                for (int k = 0; k < histo.length; k++) {
                    double scaled = maxHeight * (((double) histo[k]) / max);
                    histo[k] = (int) Math.floor(scaled);

                }
                
                g.setColor(Color.red);
                g.drawLine(50, 30, 50, 500);
                g.drawLine(50, 500, 500, 500);
                
                for (int j = 0; j < histo.length; j++) {
                    int x = 50 + 10 * j;
                    int y = 500;
                    
                    // g.drawRect(50,200,10 ,100);
                    b.drawRect(x, y, 15, histo[j]* ( 575/max));
                }

            
            }

        }

    }

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {
        showButtonActionPerformed(evt);
    }

    private void canvasPropertyChange(java.beans.PropertyChangeEvent evt) {
        canvas.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Histo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Histo().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify                     
    private java.awt.Canvas canvas;
    private javax.swing.JTextField idField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton showButton;
    private javax.swing.JTextArea sourceArea;
   // End of variables declaration                   
}
