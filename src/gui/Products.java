/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
//import com.google.zxing.BinaryBitmap;
//import com.google.zxing.LuminanceSource;
//import com.google.zxing.MultiFormatReader;
//import com.google.zxing.Reader;
//import com.google.zxing.Result;
//import com.google.zxing.common.HybridBinarizer;
//import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.MySql;
import model.Onload;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ASUS
 */
public class Products extends javax.swing.JFrame {

    private static Logger l = new Onload().setLogger("Product.log");
    HashMap<Integer, Object> compnay_map = new HashMap<>();
    HashMap<Integer, Object> brand_map = new HashMap<>();
    HashMap<Integer, Object> drug_map = new HashMap<>();
    HashMap<Integer, Object> product_map = new HashMap<>();

    String pId;
    String supplier;
    String brand;
    String pName;
    int qty;
    String mfd;
    String exp;
    Double bPrice;
    Double sPrice;
    Double tPrice;
    Double pAmount = 0.00;
    Double subTotal;
    Double total;

    String qRest;
    ArrayList<Object> qDataArray[];

    Boolean setColumns = true;

    public Products() {
        initComponents();
        setExtendedState(this.MAXIMIZED_BOTH);
        loadData();
        l = new Onload().setLogger("products.log");
        jTable2.getTableHeader().setFont(new Font("Play", Font.BOLD, 13));
        comboBoxTyped();
//        System.out.println(Onload.readBarCode("src/images/ds.png"));
    }

    private void comboBoxTyped() {
        jComboBox4.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                JTextField textField = (JTextField) evt.getSource();
                char c = evt.getKeyChar();

                if (!String.valueOf(c).matches("^[A-Za-z0-9\\[\\]/& ()]+$") || textField.getText().length() >= 50) {
                    evt.consume();
                }
            }
        });

    }

    private void loadData() {

        setNormalColumns();
        jComboBox2.setEnabled(false);
        jComboBox4.setEnabled(false);
        jComboBox1.setEnabled(true);

        HashMap m = new Onload().getComboData("suppliers", "", "nic");
        compnay_map = (HashMap<Integer, Object>) m.get(2);
        jComboBox1.setModel((DefaultComboBoxModel) m.get(1));

        jComboBox5.setModel((DefaultComboBoxModel) new Onload().getComboData("suppliers", "", "nic").get(1));

        HashMap m2 = new Onload().getComboData("brand");
        brand_map = (HashMap<Integer, Object>) m2.get(2);
        jComboBox2.setModel((DefaultComboBoxModel) m2.get(1));

        jComboBox6.setModel((DefaultComboBoxModel) new Onload().getComboData("brand").get(1));

        HashMap m3 = new Onload().getComboData("product");
        product_map = (HashMap<Integer, Object>) m3.get(2);
        jComboBox4.setModel((DefaultComboBoxModel) m3.get(1));

        HashMap m4 = new Onload().getComboData("med_type");
        drug_map = (HashMap<Integer, Object>) m4.get(2);
        jComboBox3.setModel((DefaultComboBoxModel) m4.get(1));

        jTextField4.setEnabled(false);
        jTextField6.setEnabled(false);

        StringBuilder randomNumber = new StringBuilder();

        // Generate a random number with 20 digits
        for (int i = 0; i < 20; i++) {
            int digit = (int) (Math.random() * 10); // Generates a random digit between 0 and 9
            randomNumber.append(digit);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel31 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel50 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel26 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jPanel47 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1281, 843));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(1127, 150));

        jPanel3.setPreferredSize(new java.awt.Dimension(248, 50));

        jLabel2.setFont(new java.awt.Font("Play", 1, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Products");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel3.setText("Select  Supplier");

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addContainerGap(350, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel12.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel12.setText("Select Brand");

        jComboBox2.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(12, 12, 12)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel27);

        jPanel4.add(jPanel6);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supplier.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Suppliers");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grns.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("GRN s");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/company.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Company");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Stock Report");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Reset");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1410, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(204, 204, 255)));
        jPanel12.setPreferredSize(new java.awt.Dimension(1248, 140));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jPanel14.setPreferredSize(new java.awt.Dimension(156, 150));

        jLabel11.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel11.setText("Product Name");

        jComboBox4.setEditable(true);
        jComboBox4.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox4KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addContainerGap(238, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.add(jPanel14);

        jPanel16.setLayout(new java.awt.GridLayout(1, 0));

        jPanel29.setPreferredSize(new java.awt.Dimension(156, 150));

        jLabel10.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel10.setText("Quantity");

        jTextField1.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel16.add(jPanel29);

        jPanel28.setPreferredSize(new java.awt.Dimension(156, 150));

        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel13.setText("MFD");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(12, 12, 12)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel16.add(jPanel28);

        jPanel12.add(jPanel16);

        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        jPanel30.setPreferredSize(new java.awt.Dimension(156, 150));

        jLabel14.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel14.setText("EXP");

        jDateChooser2.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser2.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jDateChooser2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooser2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel30);

        jPanel31.setPreferredSize(new java.awt.Dimension(156, 150));

        jLabel15.setFont(new java.awt.Font("Play", 1, 12)); // NOI18N
        jLabel15.setText("Buying Price(Per Unit)");

        jTextField2.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(14, 14, 14)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel31);

        jPanel12.add(jPanel15);

        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        jPanel32.setPreferredSize(new java.awt.Dimension(156, 150));

        jLabel16.setFont(new java.awt.Font("Play", 1, 12)); // NOI18N
        jLabel16.setText("Selling Price(Per Unit)");

        jTextField3.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(14, 14, 14)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel32);

        jPanel33.setPreferredSize(new java.awt.Dimension(156, 150));

        jLabel25.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel25.setText("Sub Total");

        jTextField6.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(11, 11, 11)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel33);

        jPanel12.add(jPanel17);

        jPanel8.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 204, 255)));

        jLabel20.setFont(new java.awt.Font("Play", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 0, 153));

        jLabel19.setFont(new java.awt.Font("Play", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 153));
        jLabel19.setText("Supplier Name :");

        jLabel21.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 204, 51));
        jLabel21.setText("Total Value of Currrent Quantity (Rs.) :");

        jLabel22.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 204, 51));
        jLabel22.setText("87 000");

        jLabel23.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 204, 51));
        jLabel23.setText("Count of free items :");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 204, 51));

        jLabel17.setFont(new java.awt.Font("Play", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("Total (Rs.)");

        jTextField4.setFont(new java.awt.Font("Play", 1, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 0, 0));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4))
        );

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24))
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel36.setPreferredSize(new java.awt.Dimension(400, 91));

        jLabel18.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setText("Paid Amount");

        jTextField5.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18))
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jButton1.setFont(new java.awt.Font("Play", 1, 20)); // NOI18N
        jButton1.setText("Drop");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Play", 1, 20)); // NOI18N
        jButton2.setText("Insert");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Play", 1, 20)); // NOI18N
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel24, java.awt.BorderLayout.PAGE_START);

        jPanel25.setLayout(new java.awt.BorderLayout());

        jPanel37.setPreferredSize(new java.awt.Dimension(1248, 100));
        jPanel37.setLayout(new java.awt.BorderLayout());

        jPanel45.setPreferredSize(new java.awt.Dimension(1410, 70));
        jPanel45.setLayout(new java.awt.GridLayout(1, 0));

        jLabel28.setFont(new java.awt.Font("Play", 1, 16)); // NOI18N
        jLabel28.setText("Product ID Or Name");

        jTextField7.setFont(new java.awt.Font("Play", 1, 15)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(0, 181, Short.MAX_VALUE))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jTextField7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34))))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jTextField7))
                .addGap(0, 0, 0))
        );

        jPanel45.add(jPanel49);

        jLabel31.setFont(new java.awt.Font("Play", 1, 16)); // NOI18N
        jLabel31.setText("Select Suppiler");

        jComboBox5.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(0, 223, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox5, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        jPanel45.add(jPanel48);

        jPanel50.setLayout(new java.awt.GridLayout(1, 0));

        jLabel9.setFont(new java.awt.Font("Play", 1, 16)); // NOI18N
        jLabel9.setText("Select By Drug");

        jComboBox3.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel59Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 58, Short.MAX_VALUE))))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel50.add(jPanel59);

        jLabel32.setFont(new java.awt.Font("Play", 1, 16)); // NOI18N
        jLabel32.setText("Select By Brand");

        jComboBox6.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox6KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 50, Short.MAX_VALUE))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel50.add(jPanel26);

        jPanel45.add(jPanel50);

        jPanel51.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel51.setLayout(new java.awt.BorderLayout());

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expire.png"))); // NOI18N
        jLabel43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel51.add(jLabel43, java.awt.BorderLayout.CENTER);

        jLabel44.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel44.setPreferredSize(new java.awt.Dimension(0, 15));
        jPanel51.add(jLabel44, java.awt.BorderLayout.PAGE_START);

        jPanel52.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel52.setLayout(new java.awt.BorderLayout());

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });
        jPanel52.add(jLabel35, java.awt.BorderLayout.CENTER);

        jLabel47.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel47.setPreferredSize(new java.awt.Dimension(0, 15));
        jPanel52.add(jLabel47, java.awt.BorderLayout.PAGE_START);

        jPanel53.setLayout(new java.awt.BorderLayout());

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel53.add(jLabel33, java.awt.BorderLayout.CENTER);

        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel38.setPreferredSize(new java.awt.Dimension(0, 15));
        jPanel53.add(jLabel38, java.awt.BorderLayout.PAGE_START);

        jPanel54.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel54MouseClicked(evt);
            }
        });
        jPanel54.setLayout(new java.awt.BorderLayout());

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stockReport.png"))); // NOI18N
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel54.add(jLabel41, java.awt.BorderLayout.CENTER);

        jLabel42.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel42.setPreferredSize(new java.awt.Dimension(0, 15));
        jPanel54.add(jLabel42, java.awt.BorderLayout.PAGE_START);

        jPanel55.setPreferredSize(new java.awt.Dimension(70, 70));
        jPanel55.setLayout(new java.awt.BorderLayout());

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel55.add(jLabel39, java.awt.BorderLayout.CENTER);

        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel40.setPreferredSize(new java.awt.Dimension(0, 15));
        jPanel55.add(jLabel40, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel45.add(jPanel47);

        jPanel37.add(jPanel45, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1410, Short.MAX_VALUE)
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel37.add(jPanel46, java.awt.BorderLayout.CENTER);

        jPanel25.add(jPanel37, java.awt.BorderLayout.PAGE_START);

        jPanel38.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        jPanel38.add(jPanel56, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        jPanel38.add(jPanel57, java.awt.BorderLayout.LINE_END);

        jPanel58.setLayout(new java.awt.BorderLayout());

        jTable2.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jPanel58.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel38.add(jPanel58, java.awt.BorderLayout.CENTER);

        jPanel25.add(jPanel38, java.awt.BorderLayout.CENTER);

        jPanel13.add(jPanel25, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        if (evt.getClickCount() == 2) {
            gotoBrand();
        }
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (setColumns) {
            setInsertColumns();
            setColumns = false;
        }
        boolean canDo = validateFields();

        if (canDo) {
            DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();

            Vector<Object> v = new Vector<>();
            v.add(brand);
            v.add(pName);
            v.add(qty);
            v.add(mfd);
            v.add(exp);
            v.add(bPrice);
            v.add(sPrice);
            v.add(subTotal);

            tb.addRow(v);
            jComboBox1.setEnabled(false);

            if (total == null) {
                total = subTotal;
            } else {
                total += subTotal;
            }
            jTextField4.setText(String.valueOf(total));
            reset();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private boolean validateFields() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        supplier = String.valueOf(jComboBox1.getSelectedItem());

        brand = String.valueOf(jComboBox2.getSelectedItem());
        pName = String.valueOf(jComboBox4.getEditor().getItem());
        String quantity = String.valueOf(jTextField1.getText());

        Date d = jDateChooser1.getDate();
        Date d1 = jDateChooser2.getDate();

        String bCPrice = jTextField2.getText();
        String sCPrice = jTextField3.getText();
        String subTCPrice = jTextField6.getText();

        if (supplier.equals("SELECT")) {
            JOptionPane.showMessageDialog(this, "Please Select Supplier", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (brand.equals("SELECT")) {
            JOptionPane.showMessageDialog(this, "Please Select Brand", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (pName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Product Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (pName.equals("SELECT")) {
            JOptionPane.showMessageDialog(this, "Please Select Product Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (quantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Quantity", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (d == null) {
            JOptionPane.showMessageDialog(this, "Please Select Manufactured Date.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (d1 == null) {
            JOptionPane.showMessageDialog(this, "Please Select Expire Date.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (bCPrice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please buying Price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (sCPrice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please selling Price", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (subTCPrice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Sub Total.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            mfd = sdf.format(d);
            exp = sdf.format(d1);
            qty = Integer.parseInt(quantity);
            bPrice = Double.valueOf(bCPrice);
            sPrice = Double.valueOf(sCPrice);
            subTotal = Double.valueOf(subTCPrice);

            return true;
        }
        return false;
    }

    private void setInsertColumns() {

        DefaultTableModel tb = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                int[] nonEditableColumns = {0, 1};
                for (int col : nonEditableColumns) {
                    if (column == col) {
                        return false;
                    }
                }
                return true;
            }
        };

        tb.setColumnCount(0);

//        tb.addColumn("Company");
        tb.addColumn("Brand");
        tb.addColumn("Product Name");
        tb.addColumn("Quantity");
        tb.addColumn("MFD");
        tb.addColumn("EXP");
        tb.addColumn("Buying Price");
        tb.addColumn("Selling Price");
        tb.addColumn("Sub Total");

        jTable2.setModel(tb);

    }

    private void setNormalColumns() {
        DefaultTableModel tb = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                int[] nonEditableColumns = {0, 1};
                for (int col : nonEditableColumns) {
                    if (column == col) {
                        return false;
                    }
                }
                return true;
            }
        };

        tb.setColumnCount(0);

        tb.addColumn("Product ID");
        tb.addColumn("Company");
        tb.addColumn("Brand");
        tb.addColumn("Product Name");
        tb.addColumn("Quantity");
        tb.addColumn("MFD");
        tb.addColumn("EXP");
        tb.addColumn("Buying Price");
        tb.addColumn("Selling Price");

        jTable2.setModel(tb);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();
        int rCount = tb.getRowCount();
        boolean canDo = false;
        boolean canDo1 = false;
//        System.out.println(rCount);

        String pAmountS = String.valueOf(jTextField5.getText());

        if (!pAmountS.isEmpty()) {
            pAmount = Double.parseDouble(pAmountS);
        }
        if (rCount > 0) {

            pId = genarateRandomNumber();
            try {
                while (MySql.select("SELECT * FROM `product` WHERE `id` = '" + pId + "' ;").next()) {
                    pId = genarateRandomNumber();
                }
            } catch (Exception e) {
                l.log(Level.WARNING, "While Product Process.", e);
            }

            Date d = new Date();
            int grn_id = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String date = sdf.format(d);
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = sdf1.format(d);

            ResultSet rs1;
            try {
                rs1 = MySql.select("SELECT * FROM `grn` "
                        + "WHERE `DAT` LIKE '%" + date1 + "%' AND `suppliers_id` = '" + compnay_map.get(supplier) + "' ; ");

                ResultSet rs2 = MySql.select("SELECT * FROM `suppliers` WHERE `id` = '" + compnay_map.get(supplier) + "'");
                if (rs2.next()) {
                    double paidA = rs1.getDouble("pAmount") + pAmount;

                    Object data[] = {paidA, compnay_map.get(supplier)};
                    MySql.iud("UPDATE `suppliers` SET `pAmount` = ? WHERE `id` = ?;", data);
                }

                if (rs1.next()) {
                    double tot1 = Double.valueOf(rs1.getDouble("total")) + total;
                    MySql.iud("UPDATE `grn` SET `total` = '" + tot1 + "' WHERE `id` = '" + rs1.getInt("id") + "' ;");
                    grn_id = rs1.getInt("id");

                    canDo1 = true;
                } else {
                    Object val3[] = {date, pAmount, compnay_map.get(supplier), total};
                    long id = MySql.iud("INSERT INTO `grn` (`DAT`,`paid_amount`,`suppliers_id`,`total`) VALUES (?,?,?,?);", val3);

                    grn_id = (int) id;
//                    MySql.iud("UPDATE `suppliers` SET `pAmount` = ? WHERE `id` = ?;", new Object[]{pAmount, compnay_map.get(supplier)});

                    canDo1 = true;
                }
            } catch (Exception ex) {
                l.log(Level.WARNING, "While Checking GRN.", ex);
            }

            for (int i = 0; i < rCount; i++) {
                HashMap<Integer, Object> val = new HashMap<>();

                //Product Insert-:-
                val.put(1, String.valueOf(jTable2.getValueAt(i, 1)));
                try {
                    ResultSet rs = MySql.select("SELECT * FROM `product` WHERE `name` = ? ;", val);

                    if (rs.next()) {
                        pId = rs.getString("id");
                        canDo = true;
                    } else {
                        val.put(2, pId);
                        val.put(3, brand_map.get(String.valueOf(jTable2.getValueAt(i, 0))));
                        MySql.iud("INSERT INTO `product` (`name`,`id`, `brand_id`) VALUES (?, ?, ?);", val);
                        canDo = true;
                    }
                } catch (Exception ex) {
                    l.log(Level.WARNING, "While Product Process.", ex);
                }

                if (canDo) {
                    Double sP = Double.valueOf(String.valueOf(jTable2.getValueAt(i, 6)));
                    int stock_id = 0;
                    try {
//                        ResultSet rs = MySql.select("SELECT * FROM `stock` WHERE `product_id` = '" + pId + "' AND `s_single_price` = '" + sP + "' "
//                                + " AND `MFD` = '" + String.valueOf(jTable2.getValueAt(i, 3)) + "' AND `EXP` = '" + String.valueOf(jTable2.getValueAt(i, 4)) + "' ;");

                        Object val2[] = {pId, sP, String.valueOf(jTable2.getValueAt(i, 3)), String.valueOf(jTable2.getValueAt(i, 4))};
                        ResultSet rs = MySql.select("SELECT * FROM `stock` WHERE `product_id` = ? AND `s_single_price` = ? AND `MFD` = ? AND `EXP` = ? ;", val2);

                        if (rs.next()) {
                            stock_id = rs.getInt("id");
                            int cQty = (Integer) jTable2.getValueAt(i, 2) + Integer.parseInt(rs.getString("qty"));
                            MySql.iud("UPDATE `stock` SET `qty` = '" + cQty + "'; ");
                        } else {
                            Object sVal[] = {(int) jTable2.getValueAt(i, 2), (double) jTable2.getValueAt(i, 6), pId, (String) jTable2.getValueAt(i, 3), (String) jTable2.getValueAt(i, 4)};
                            long id = MySql.iud("INSERT INTO `stock` (`qty`,`s_single_price`,`product_id`,`MFD`,`EXP`) VALUES (?,?,?,?,?); ", sVal);
                            stock_id = (int) id;
                        }

                        if (canDo1) {

                            ResultSet rs2 = MySql.select("SELECT * FROM `grn_items` WHERE `itemName` = '" + jTable2.getValueAt(i, 1) + "' AND `MFD` = '" + jTable2.getValueAt(i, 3) + "' "
                                    + "AND `EXP` = '" + jTable2.getValueAt(i, 4) + "' AND `grn_id` = '" + grn_id + "' AND `bSPrice` = '" + jTable2.getValueAt(i, 5) + "' ;");
                            if (rs2.next()) {
                                double cSubT = rs2.getDouble("bTotal") + (double) jTable2.getValueAt(i, 7);
                                double cQty1 = rs2.getInt("qty") + (int) jTable2.getValueAt(i, 2);
                                MySql.iud("UPDATE `grn_items` SET `bTotal` = '" + cSubT + "', `qty` = '" + cQty1 + "' ;");
                            } else {
                                Object val4[] = {(String) jTable2.getValueAt(i, 1), (int) jTable2.getValueAt(i, 2), (String) jTable2.getValueAt(i, 3), (String) jTable2.getValueAt(i, 4),
                                    (double) jTable2.getValueAt(i, 7), (double) jTable2.getValueAt(i, 5), grn_id, stock_id};
                                MySql.iud("INSERT INTO `grn_items` (`itemName`,`qty`,`MFD`,`EXP`,`bTotal`,`bSPrice`,`grn_id`,`stock_id`) VALUES (?,?,?,?,?,?,?,?);", val4);
                                success();
                            }
                        }
                    } catch (Exception ex) {
                        l.log(Level.WARNING, "While inserting stock.", ex);
                    }

                }

            }

        } else {
            JOptionPane.showMessageDialog(this, "Please enter product details before insert.", "Empty Details", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void success() {
        JOptionPane.showMessageDialog(this, "Stock inserted successfully.", "Successfull", JOptionPane.INFORMATION_MESSAGE);
        total = 0.0;
        jTextField4.setText("");
        jTextField5.setText("");
        DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();
        tb.setRowCount(0);
        reset();
    }

    private void reset() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField6.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);

        HashMap m3 = new Onload().getComboData("product");
        product_map = (HashMap<Integer, Object>) m3.get(2);
        jComboBox4.setModel((DefaultComboBoxModel) m3.get(1));
    }

    private String genarateRandomNumber() {
        StringBuilder randomNumber = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int digit = (int) (Math.random() * 10);
            randomNumber.append(digit);
        }
        return String.valueOf(randomNumber);
    }

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        JTextField textField = (JTextField) evt.getSource();
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || textField.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c = evt.getKeyChar();
        String text = jTextField2.getText();

        if (!Character.isDigit(c) && c != '.' || text.length() >= 30) {
            evt.consume();
        } else if (c == '.' && text.contains(".") || text.length() >= 30) {
            evt.consume();
        }

    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        char c = evt.getKeyChar();
        String text = jTextField3.getText();

        if (!Character.isDigit(c) && c != '.' || text.length() >= 30) {
            evt.consume();
        } else if (c == '.' && text.contains(".") || text.length() >= 30) {
            evt.consume();
        }


    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        char c = evt.getKeyChar();
        String text = jTextField6.getText();

        if (!Character.isDigit(c) && c != '.' || text.length() >= 30) {
            evt.consume();
        } else if (c == '.' && text.contains(".") || text.length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char c = evt.getKeyChar();
        String text = jTextField4.getText();

        if (!Character.isDigit(c) && c != '.' || text.length() >= 30) {
            evt.consume();
        } else if (c == '.' && text.contains(".") || text.length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char c = evt.getKeyChar();
        String text = jTextField5.getText();

        if (!Character.isDigit(c) && c != '.' || text.length() >= 30) {
            evt.consume();
        } else if (c == '.' && text.contains(".") || text.length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        if (evt.getClickCount() == 2) {
            jTextField4.setEnabled(false);
            jTextField6.setEnabled(true);
            String qty1 = jTextField1.getText();
            String bP = jTextField2.getText();

            if (!qty1.isEmpty() && !bP.isEmpty()) {
                double tot = Double.valueOf(qty1) * Double.valueOf(bP);
                jTextField6.setText(String.valueOf(tot));

                jLabel22.setText(String.valueOf(tot));

            }
        }
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        if (evt.getClickCount() == 2) {
            jTextField4.setEnabled(true);
            jTextField6.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        int row = jTable2.getSelectedRow();
        DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();

        if (row != -1) {
            if (evt.getKeyCode() == 127) {
                tb.removeRow(row);
            }

        }
    }//GEN-LAST:event_jTable2KeyPressed
    long lastPressTime = 0;
    int DOUBLE_PRESS_INTERVAL = 300;
    private static Timer timer = new Timer();
    private static boolean isDoublePress = false;

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed

        if (evt.getKeyCode() == 10) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastPressTime < DOUBLE_PRESS_INTERVAL) {
                isDoublePress = true;
                selectComboBoxItemIgnoreCase(jComboBox1, (String) jComboBox1.getEditor().getItem());
            } else {
                isDoublePress = false;
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (!isDoublePress) {
                            jComboBox2.grabFocus();
                        }
                    }
                }, DOUBLE_PRESS_INTERVAL);
            }
            lastPressTime = currentTime;

        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String item = String.valueOf(jComboBox1.getSelectedItem());
        try {
            ResultSet rs = MySql.select("SELECT * FROM `suppliers` WHERE `nic` = '" + item + "' ;");
            if (rs.next()) {
                jLabel20.setText(rs.getString("s_name"));
                setBrands(rs.getString("id"));
                jComboBox2.setEnabled(true);
            }
        } catch (Exception e) {
            l.log(Level.WARNING, "While suppiler selecting Process.", e);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void setBrands(String id) {

        String rest = " INNER JOIN `company` ON `brand`.`company_id` = `company`.`id` WHERE `suppliers_id` = '" + id + "' ";

        HashMap m2 = new Onload().getComboData("brand", rest, "brand.name");
        brand_map = (HashMap<Integer, Object>) m2.get(2);
        jComboBox2.setModel((DefaultComboBoxModel) m2.get(1));
    }

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        if (evt.getClickCount() == 2) {
            new Suppliers(this, true);
        }
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        String item = String.valueOf(jComboBox2.getSelectedItem());

        if (!item.equals("SELECT")) {
            String rest = " WHERE `brand_id` = '" + brand_map.get(item) + "' ";

            HashMap m = new Onload().getComboData("product", rest, "product.name");
            product_map = (HashMap<Integer, Object>) m.get(2);
            jComboBox4.setModel((DefaultComboBoxModel) m.get(1));
            jComboBox4.setEnabled(true);

        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        loadData();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        String qty1 = jTextField1.getText();
        String bP = jTextField2.getText();
        String subT = jTextField6.getText();

        if (!qty1.isEmpty() && !bP.isEmpty() && !subT.isEmpty()) {
            double tot = Double.valueOf(qty1) * Double.valueOf(bP);
            tot = (tot - Double.parseDouble(subT)) / Double.parseDouble(bP);

//            jLabel22.setText(String.valueOf(tot));
            jLabel24.setText(String.valueOf((int) Math.floor(tot)));

        }
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        if (evt.getKeyCode() == 10) {
            jButton3.doClick();
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jComboBox4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyPressed
        if (evt.getKeyCode() == 10) {
            jTextField1.grabFocus();
        }
    }//GEN-LAST:event_jComboBox4KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == 10) {
            jDateChooser1.grabFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jDateChooser2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser2KeyPressed
        if (evt.getKeyCode() == 10) {
            jTextField2.grabFocus();
        }
    }//GEN-LAST:event_jDateChooser2KeyPressed

    private void jDateChooser1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyPressed
        if (evt.getKeyCode() == 10) {
            jDateChooser2.grabFocus();
        }
    }//GEN-LAST:event_jDateChooser1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.getKeyCode() == 10) {
            jTextField3.grabFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if (evt.getKeyCode() == 10) {
            jTextField6.grabFocus();
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        if (evt.getKeyCode() == 10) {
            searchLabelAction();
        }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Suppliers(this, true).setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new Companies(this, true).setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        searchLabelAction();
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        String item = String.valueOf(jComboBox5.getSelectedItem());

        if (!item.equals("SELECT")) {
            
            Object values[] = {item};
            qRest = "WHERE `nic` = ?";
            
            selectProduct1(qRest, values);
            String rest = " INNER JOIN `company` ON `brand`.`company_id` = `company`.`id` WHERE `suppliers_id` = '" + compnay_map.get(item) + "' ";
            jComboBox6.setModel((DefaultComboBoxModel) getComboData("brand", rest, "name"));
        } else {
            selectProduct1("", new Object[]{});
            jComboBox6.setModel((DefaultComboBoxModel) new Onload().getComboData("brand").get(1));
        }

    }//GEN-LAST:event_jComboBox5ItemStateChanged

    public DefaultComboBoxModel getComboData(String tableName, String rest, String columnName) {

        Vector<String> v = new Vector<>();

        try {
            ResultSet rs = MySql.select("SELECT * FROM `" + tableName + "` " + rest + " ;");
            v.add("SELECT");
            while (rs.next()) {
                v.add(rs.getString(tableName + "." + columnName));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DefaultComboBoxModel(v);
    }

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        String sup = String.valueOf(jComboBox5.getSelectedItem());
        String bran = String.valueOf(jComboBox3.getSelectedItem());

        if (!sup.equals("SELECT") && !bran.equals("SELECT")) {
//            Object valule[] = {sup};
//            selectProduct1("WHERE `nic` = ?", valule);
            try {
                ResultSet rs = MySql.select("SELECT * FROM `brand` INNER JOIN `company` ON `brand`.`company_id` = `company`.`id` "
                        + "INNER JOIN `med_type` ON `brand`.`med_type_id` = `med_type`.`id` WHERE `suppliers_id` = '" + compnay_map.get(sup) + "' AND `med_type`.`name` = '" + bran + "' ");

                Vector<String> v = new Vector<>();
                v.add("SELECT");
                while (rs.next()) {
                    v.add(rs.getString("brand.name"));
                }
                jComboBox6.setModel((DefaultComboBoxModel) new DefaultComboBoxModel(v));
            } catch (Exception ex) {
                l.log(Level.WARNING, "While sorting Process.", ex);
            }
        } else if (sup.equals("SELECT") && !bran.equals("SELECT")) {
            Object valule[] = {sup};

            try {
                ResultSet rs = MySql.select("SELECT * FROM `brand` INNER JOIN `company` ON `brand`.`company_id` = `company`.`id` "
                        + "INNER JOIN `med_type` ON `brand`.`med_type_id` = `med_type`.`id` WHERE `med_type`.`name` = '" + bran + "' ");

                Vector<String> v = new Vector<>();
                v.add("SELECT");
                while (rs.next()) {
                    v.add(rs.getString("brand.name"));
                }
                jComboBox6.setModel((DefaultComboBoxModel) new DefaultComboBoxModel(v));
            } catch (Exception ex) {
                l.log(Level.WARNING, "While sorting Process.", ex);
            }
        } else {
            jComboBox6.setModel((DefaultComboBoxModel) new Onload().getComboData("brand").get(1));
        }
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox6KeyPressed
        String bran = String.valueOf(jComboBox6.getSelectedItem());
        String sup = String.valueOf(jComboBox5.getSelectedItem());

        if (!bran.equals("SELECT") && sup.equals("SELECT")) {
            Object valule[] = {bran};
            selectProduct1("WHERE `brand`.`name` = ?", valule);
        } else if (!bran.equals("SELECT") && !sup.equals("SELECT")) {
            Object valule[] = {bran, compnay_map.get(sup)};
            selectProduct1("WHERE `brand`.`name` = ? AND `supplier_id` = ? ", valule);
        }
    }//GEN-LAST:event_jComboBox6KeyPressed

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jPanel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel54MouseClicked

        int rowCount = jTable2.getRowCount();

        if (rowCount > 0) {
            double bTot = 0;
            double sTot = 0;

            for (int i = 0; i < rowCount; i++) {
                bTot += Integer.parseInt(String.valueOf(jTable2.getValueAt(i, 4))) * Double.parseDouble(String.valueOf(jTable2.getValueAt(i, 7)).split(" LKR")[0]);
                sTot += Integer.parseInt(String.valueOf(jTable2.getValueAt(i, 4))) * Double.parseDouble(String.valueOf(jTable2.getValueAt(i, 8)).split(" LKR")[0]);
            }

            try {
//                InputStream file = this.getClass().getResourceAsStream("reports/pInvoice.jasper");
                String file = "src/reports/stockReport.jasper";

                HashMap<String, Object> parameters = new HashMap<>();

                Date d2 = new Date();
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

                String date2 = sdf2.format(d2);

                parameters.put("Parameter1", "");
                parameters.put("Parameter2", Onload.df.format(bTot) + " LKR");

                parameters.put("Parameter3", Onload.df.format(sTot) + " LKR");
                parameters.put("Parameter4", Onload.df.format(sTot - bTot) + " LKR");

                parameters.put("Parameter5", date2);

                JRTableModelDataSource jrtm = new JRTableModelDataSource(jTable2.getModel());

                JasperPrint p = JasperFillManager.fillReport(file, parameters, jrtm);
//            JasperPrintManager.printReport(p, false);
                JasperViewer.viewReport(p, true);

            } catch (Exception e) {
                l.log(Level.WARNING, "While Genarating Report.", e);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please set data that need get report.", "Please Select data.", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jPanel54MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        new Grns(this, true).setVisible(true);
    }//GEN-LAST:event_jPanel11MouseClicked

    private void searchLabelAction() {
        String productId = jTextField7.getText();
        if (productId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Product id or Scan.");
        } else {
            selectProduct(productId);
        }
    }

    private void selectProduct(String productId) {
        setNormalColumns();
        try {
            String q = "SELECT * FROM `product` INNER JOIN `brand` ON brand.id = product.brand_id INNER JOIN company ON  brand.company_id = company.id "
                    + "INNER JOIN suppliers ON suppliers.id = company.suppliers_id INNER JOIN stock ON stock.product_id = product.id "
                    + "INNER JOIN grn_items ON grn_items.stock_id = stock.id WHERE `product`.`id` = ? ORDER BY `stock`.`qty` DESC ;";
            Object val[] = {productId};
            ResultSet rs = MySql.select(q, val);

            DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();
            tb.setRowCount(0);

            while (rs.next()) {
                Vector<String> v = new Vector<>();

                v.add(rs.getString("company.name"));
                v.add(rs.getString("brand.name"));
                v.add(rs.getString("product.name"));
                v.add(rs.getString("stock.qty"));
                v.add(rs.getString("stock.MFD"));
                v.add(rs.getString("stock.EXP"));
                v.add(rs.getString("bSPrice"));
                v.add(rs.getString("stock.s_single_price"));

                tb.addRow(v);

            }

        } catch (Exception ex) {
            l.log(Level.WARNING, "While product details selecting Process.", ex);
        }
    }

    private void selectProduct1(String rest, Object val[]) {
        setNormalColumns();
        try {
            String q = "SELECT * FROM `product` INNER JOIN `brand` ON brand.id = product.brand_id INNER JOIN company ON  brand.company_id = company.id "
                    + "INNER JOIN suppliers ON suppliers.id = company.suppliers_id INNER JOIN stock ON stock.product_id = product.id "
                    + "INNER JOIN grn_items ON grn_items.stock_id = stock.id " + rest + " ORDER BY `stock`.`qty` DESC ;";
            ResultSet rs = MySql.select(q, val);

            DefaultTableModel tb = (DefaultTableModel) jTable2.getModel();
            tb.setRowCount(0);

            while (rs.next()) {
                Vector<String> v = new Vector<>();

                v.add(rs.getString("product.id"));
                v.add(rs.getString("company.name"));
                v.add(rs.getString("brand.name"));
                v.add(rs.getString("product.name"));
                v.add(rs.getString("stock.qty"));
                v.add(rs.getString("stock.MFD"));
                v.add(rs.getString("stock.EXP"));
                v.add(Onload.df.format(rs.getDouble("bSPrice")) + " LKR");
                v.add(Onload.df.format(rs.getDouble("stock.s_single_price")) + " LKR");

                tb.addRow(v);

            }

        } catch (Exception ex) {
            l.log(Level.WARNING, "While product details selecting Process.", ex);
        }
    }

    private void selectComboBoxItemIgnoreCase(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equalsIgnoreCase(item)) {
                comboBox.setSelectedIndex(i);
                try {
                    ResultSet rs = MySql.select("SELECT * FROM `suppliers` WHERE `nic` = '" + item + "' ;");
                    if (rs.next()) {
                        jLabel20.setText(rs.getString("s_name"));
                        setBrands(rs.getString("id"));
                        jComboBox2.setEnabled(true);
                    }
                } catch (Exception e) {
                    l.log(Level.WARNING, "While suppiler selecting Process.", e);
                }
                break;
            } else {
                JOptionPane.showMessageDialog(this, "Supplier Do not Exits.", "Invalid supplier NIC", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            FlatLaf.setup(new FlatArcDarkOrangeIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Products().setVisible(true);
            }
        });
    }

    private void gotoBrand() {
        new Brand(this, true).setVisible(true);
    }

    public void setCompany(String item) {
        HashMap m = new Onload().getComboData("company");
        brand_map = (HashMap<Integer, Object>) m.get(2);
        jComboBox1.setModel((DefaultComboBoxModel) m.get(1));

        jComboBox1.setSelectedItem(item);
    }

    public void setBrands(String drug, String brand) {
        HashMap m2 = new Onload().getComboData("brand");
        brand_map = (HashMap<Integer, Object>) m2.get(2);
        jComboBox2.setModel((DefaultComboBoxModel) m2.get(1));

        jComboBox2.setSelectedItem(brand);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
