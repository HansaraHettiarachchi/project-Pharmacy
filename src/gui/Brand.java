/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkOrangeIJTheme;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.MySql;
import model.Onload;

/**
 *
 * @author ASUS
 */
public class Brand extends javax.swing.JDialog {

    Products p;
    private static Logger l;
    String brand;
    String com;
    String drugT;

    HashMap<Integer, Object> med_map = new HashMap<>();
    HashMap<Integer, Object> company_map = new HashMap<>();

    public Brand(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        p = (Products) parent;
        initComponents();
        l = new Onload().setLogger("brand.log");
        onload();
        jCOmboBoxKeyPressed();

        JTableHeader h = jTable1.getTableHeader();
        h.setFont(new Font("Play", Font.BOLD, 12));

    }

    private void jCOmboBoxKeyPressed() {
        jComboBox2.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {

                if (evt.getKeyCode() == 127) {
                    String item = (String) jComboBox2.getSelectedItem();
                    if (!item.equals("SELECT")) {
                        int r = JOptionPane.showConfirmDialog(new Frame(), "Do you want to delete " + item + " ...?", "Comfirm the Deletion", JOptionPane.YES_NO_OPTION);

                        if (r == 0) {
                            HashMap<Integer, Object> val = new HashMap<>();
                            val.put(1, med_map.get(item));

                            try {
                                ResultSet rs = MySql.select("SELECT * FROM `brand` WHERE `med_type_id` = ? ;", val);
                                if (!rs.next()) {
                                    MySql.iud("DELETE FROM `med_type` WHERE `id` = ? ;", val);
                                    onload();
                                } else {
                                    JOptionPane.showMessageDialog(new Frame(), "The Drug Name can't be deleted because there are some recodes exsts with the Drug.", "Can't Delete", JOptionPane.WARNING_MESSAGE);
                                }
                            } catch (Exception ex) {
                                l.log(Level.WARNING, "While Deleting Drug.", ex);
                            }
                        }

                    }
                }
            }
        });
    }

    private void setTableData(String rest, String tColumns[]) {
        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();

        String query = "SELECT * FROM `brand` INNER JOIN `med_type` ON  `med_type`.`id` = `brand`.`med_type_id` INNER JOIN `company` ON `brand`.`company_id` = `company`.`id` " + rest + ";";

        try {
            ResultSet rs = MySql.select(query);

            tb.setRowCount(0);

            while (rs.next()) {
                Vector<String> v = new Vector();

                for (String colunm : tColumns) {
                    v.add(rs.getString(colunm));
                }

                tb.addRow(v);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void onload() {
        setTableData(" ORDER BY `med_type`.`name` ASC ", new String[]{"med_type.name", "brand.name", "company.name"});
        jbid.setVisible(false);
        jButton3.setEnabled(false);

        HashMap m = new Onload().getComboData("company", "ORDER BY `name` ASC");
        jComboBox1.setModel((DefaultComboBoxModel) m.get(1));
        company_map = (HashMap<Integer, Object>) m.get(2);

        HashMap m1 = new Onload().getComboData("med_type", "ORDER BY `name` ASC");
        jComboBox2.setModel((DefaultComboBoxModel) m1.get(1));
        med_map = (HashMap<Integer, Object>) m1.get(2);

        jComboBox4.setModel((ComboBoxModel) new Onload().getComboData("med_type", " ORDER BY `id` ASC ").get(1));
        jComboBox5.setModel((ComboBoxModel) new Onload().getComboData("company", " ORDER BY `id` ASC ").get(1));

        jTextField1.setText("");
//        jComboBox2.setModel((DefaultComboBoxModel) new Onload().getComboData("product").get(1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jbid = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 255), 5, true));

        jLabel1.setFont(new java.awt.Font("Play", 1, 36)); // NOI18N
        jLabel1.setText("Brands");

        jButton2.setFont(new java.awt.Font("Play", 1, 18)); // NOI18N
        jButton2.setText("Add Brand");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Play", 1, 18)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel4.setText("Brand Name");

        jLabel5.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel5.setText("Select  Drug Type");

        jLabel3.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel3.setText("Select  Company");

        jComboBox1.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/what.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)))
        );

        jComboBox2.setEditable(true);
        jComboBox2.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Play", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Durg Name", "Brand Name", "Company "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel12.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("X");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Play", 1, 16)); // NOI18N
        jButton1.setText("Get Report");

        jComboBox3.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jComboBox5.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        String drug = String.valueOf(jComboBox2.getEditor().getItem());

        if (drug.isEmpty() || drug.equals("SELECT")) {
            JOptionPane.showMessageDialog(this, "Please enter drug name.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!drug.matches("^[a-zA-Z]{1,44}$")) {
            JOptionPane.showMessageDialog(this, "The drug name should contain letters A-Z less than 45 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean canDo = false;
            HashMap<Integer, Object> val = new HashMap<>();
            val.put(1, drug);
            try {
                ResultSet rs = MySql.select("SELECT * FROM `med_type` WHERE `name` = ?;", val);
                if (!rs.next()) {
                    canDo = true;
                } else {
                    JOptionPane.showMessageDialog(this, "The drug already exits.", "Don't worry", JOptionPane.INFORMATION_MESSAGE);
                    selectComboBoxItemIgnoreCase(jComboBox2, drug);
                }
            } catch (Exception e) {
            }

            try {
                if (canDo) {
                    MySql.iud("INSERT INTO `med_type` (`name`) VALUES (?);", val);

                    JOptionPane.showMessageDialog(this, "Drug added Successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE);

//                    jComboBox2.setModel((DefaultComboBoxModel) new Onload().getComboData("med_type", "ORDER BY `name` ASC").get(1));
                    onload();
                    jComboBox2.setSelectedItem(drug);

                }
            } catch (Exception e) {
                l.log(Level.WARNING, "Inserting Drugs.", e);
            }
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void selectComboBoxItemIgnoreCase(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equalsIgnoreCase(item)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        String brandName = jTextField1.getText();
        if (!brandName.isEmpty()) {
            String query = "What is " + brandName + " ";
            Onload.searchBing(query);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter brand name for search.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        if (evt.getClickCount() == 2) {
            this.dispose();
            new Companies(p, true).setVisible(true);
        }
    }//GEN-LAST:event_jComboBox1MouseClicked

    private boolean validateField() {
        brand = jTextField1.getText();
        com = String.valueOf(jComboBox1.getSelectedItem());
        drugT = String.valueOf(jComboBox2.getSelectedItem());

        if (com.equals("SELECT")) {
            JOptionPane.showMessageDialog(this, "Please Select Company.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (drugT.equals("SELECT")) {
            JOptionPane.showMessageDialog(this, "Please Select drug.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (brand.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Brand Name.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!brand.matches("^[a-zA-Z]{1,44}$")) {
            JOptionPane.showMessageDialog(this, "The Brand name should contain letters A-Z less than 45 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean canDo = false;

            HashMap<Integer, Object> val = new HashMap<>();
            val.put(1, brand);
//            val.put(2, String.valueOf(company_map.get(com)));

            try {
                ResultSet rs = MySql.select("SELECT *FROM `brand` WHERE `name` = ? ;", val);

                if (rs.next()) {
//                    AND `company_id` = ?
                    JOptionPane.showMessageDialog(this, "The Brand name already exits.", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    return true;
                }
            } catch (Exception e) {
                l.log(Level.WARNING, "While checking brand is available.", e);
            }
        }
        return false;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean canDo = validateField();

        HashMap<Integer, Object> val = new HashMap<>();
        val.put(1, brand);
        val.put(2, company_map.get(com));
        val.put(3, med_map.get(drugT));

        if (canDo) {
            try {
                MySql.iud("INSERT INTO `brand` (`name`,`company_id`,`med_type_id`) VALUES (?,?,?);", val);
                JOptionPane.showMessageDialog(this, "Brand added Successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE);

                onload();
            } catch (Exception e) {
                l.log(Level.WARNING, "While inserting brand.", e);
            }
        } else if (med_map.get(drugT) == null) {
            JOptionPane.showMessageDialog(this, "Please Select medicene Name.");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed


    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean canDo = validateField();

        HashMap<Integer, Object> val = new HashMap<>();
        val.put(1, brand);
        val.put(2, company_map.get(com));
        val.put(3, med_map.get(drugT));
        val.put(4, Integer.parseInt(jbid.getText()));

        if (canDo) {
            try {
                MySql.iud("UPDATE `brand` SET `name` = ?, `company_id` = ?, `med_type_id` = ?  WHERE `id` = ?;", val);
                JOptionPane.showMessageDialog(this, "Brand updated Successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE);

                onload();
            } catch (Exception e) {
                l.log(Level.WARNING, "While UPDATING brand.", e);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();

        if (evt.getClickCount() == 2) {
            p.setBrands((String) jTable1.getValueAt(row, 0), (String) jTable1.getValueAt(row, 1));
            this.dispose();
        } else if (evt.getClickCount() == 1) {
            boolean canDo = false;
            try {
                ResultSet rs = MySql.select("SELECT * FROM `brand` WHERE `company_id` = '" + company_map.get(jTable1.getValueAt(row, 2)) + "' AND `name` = '" + jTable1.getValueAt(row, 1) + "' ;");
                if (rs.next()) {
                    jbid.setText(String.valueOf(rs.getInt("id")));
                    canDo = true;
                }
            } catch (Exception ex) {
                l.log(Level.WARNING, "While getting brand id for updating.", ex);
            }

            if (canDo) {
                jButton3.setEnabled(true);
                jComboBox1.setSelectedItem(jTable1.getValueAt(row, 2));
                jComboBox2.setSelectedItem(jTable1.getValueAt(row, 0));
                jTextField1.setText((String) jTable1.getValueAt(row, 1));

            }

        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selectedItem = (String) evt.getItem();

            if (selectedItem.equals("ASC")) {
                setTableData(" ORDER BY `med_type`.`name` ASC ", new String[]{"med_type.name", "brand.name", "company.name"});
            } else {
                setTableData(" ORDER BY `med_type`.`name` DESC ", new String[]{"med_type.name", "brand.name", "company.name"});
            }
        }
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selectedItem = (String) evt.getItem();

            if (!selectedItem.equals("SELECT")) {
                setTableData(" WHERE `brand`.`med_type_id` = '" + med_map.get(selectedItem) + "' ORDER BY `med_type`.`name` ASC ", new String[]{"med_type.name", "brand.name", "company.name"});
            }
        }
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selectedItem = (String) evt.getItem();

            if (!selectedItem.equals("SELECT")) {
                setTableData(" WHERE `brand`.`company_id` = '" + company_map.get(selectedItem) + "' ORDER BY `med_type`.`name` ASC ", new String[]{"med_type.name", "brand.name", "company.name"});
            }
        }
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    /**
     * @param args the command line arguments
     */
//    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jbid;
    // End of variables declaration//GEN-END:variables
}
