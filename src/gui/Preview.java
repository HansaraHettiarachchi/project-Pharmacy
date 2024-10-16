/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme;
import java.awt.Frame;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import model.Onload;

/**
 *
 * @author ASUS
 */
public class Preview extends javax.swing.JFrame {

    /**
     * Creates new form Preview
     */
    public Preview() {
        initComponents();

        Thread progress = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 20; i++) {
                    jProgressStart.setValue(i);

                    try {
                        Thread.sleep(50);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                jMainText.setText("Please wait. We are getting ready.");
                try {
                    Thread.sleep(500);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                for (int i = 20; i <= 50; i++) {
                    jProgressStart.setValue(i);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                jMainText.setText("Checking internet Connection.");
                boolean rs = isInternetAvailable();
                if (!rs) {
                    jMainText.setText("Connecting to internet is failed.");
                }
                try {
                    Thread.sleep(500);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                for (int i = 50; i <= 78; i++) {
                    jProgressStart.setValue(i);

                    try {
                        Thread.sleep(70);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                if (!rs) {
                    jMainText.setText("Connecting to internet is failed.");
                } else {
                    jMainText.setText("Starting Data BackUp.");
                    
                }

                try {
                    Thread.sleep(500);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                for (int i = 78; i <= 100; i++) {
                    jProgressStart.setValue(i);

                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                
                
                Home h = new Home(true);
                h.setVisible(true);
                h.setExtendedState(Home.MAXIMIZED_BOTH);
                
                dispose();
            }

            public boolean isInternetAvailable() {
                return Onload.isInternetAvailable();
            }
        });

        progress.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jProgressStart = new javax.swing.JProgressBar();
        jMainText = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(778, 180));

        jProgressStart.setForeground(new java.awt.Color(255, 255, 0));

        jMainText.setFont(new java.awt.Font("Play", 1, 24)); // NOI18N
        jMainText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMainText.setText("WELLCOME");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMainText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(jMainText)
                .addGap(58, 58, 58)
                .addComponent(jProgressStart, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/My logo-01-01-01.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLabel2)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            FlatLaf.setup(new FlatMaterialOceanicIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jMainText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressStart;
    // End of variables declaration//GEN-END:variables

}
