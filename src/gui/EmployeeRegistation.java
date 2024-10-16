/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.MySql;
import model.Onload;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author ASUS
 */
public class EmployeeRegistation extends javax.swing.JFrame {

    HashMap<String, Object> worker_type = new HashMap<>();
    HashMap<String, Object> gender = new HashMap<>();
    HashMap<String, Object> status = new HashMap<>();

    public EmployeeRegistation() {
        initComponents();
        loadCombos();
        loadTableData();
        JTableHeader h = jTable1.getTableHeader();
        h.setFont(new Font("Play",Font.BOLD, 12));
        jComStatus.setSelectedItem("Deactive");
        jComStatus.setEnabled(false);
//        setExtendedState(this.MAXIMIZED_BOTH);
    }

    private void loadTableData() {
        try {
            ResultSet rs = MySql.select("SELECT * FROM `users` INNER JOIN `gender` ON users.gender_id = gender.id "
                    + "INNER JOIN `worker_type` ON users.worker_type_id = worker_type.id "
                    + "INNER JOIN `status` ON status.id = users.status_id ORDER BY `registered_date` ASC;");
            DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
            tb.setRowCount(0);

            while (rs.next()) {
                Vector<String> v = new Vector();

                v.add(rs.getString("NIC"));
                v.add(rs.getString("fname"));
                v.add(rs.getString("lname"));
                v.add(rs.getString("email"));
                v.add(rs.getString("ps"));
                v.add(rs.getString("mobile"));
                v.add(rs.getString("gender.name"));
                v.add(rs.getString("status.name"));
                v.add(rs.getString("worker_type.name"));
                v.add(rs.getString("registered_date"));
                tb.addRow(v);
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeRegistation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCombos() {
        HashMap m = new Onload().getComboData("worker_type");
        HashMap m2 = new Onload().getComboData("gender");
        HashMap m3 = new Onload().getComboData("status");

        worker_type = (HashMap<String, Object>) m.get(2);
        gender = (HashMap<String, Object>) m2.get(2);
        status = (HashMap<String, Object>) m3.get(2);

        jComW_type.setModel((DefaultComboBoxModel) m.get(1));
        jComGender.setModel((DefaultComboBoxModel) m2.get(1));
        jComStatus.setModel((DefaultComboBoxModel) m3.get(1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jBtnSignUp = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComGender = new javax.swing.JComboBox<>();
        jComW_type = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComStatus = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1278, 870));
        setPreferredSize(new java.awt.Dimension(1278, 821));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTable1.setFont(new java.awt.Font("Play", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIC", "First Name", "Last Name", "E-mail", "Password", "Mobile", "Gender", "Status", "Worker Type", "Registered Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 600));

        jLabel17.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel17.setText("Mobile");

        jBtnSignUp.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jBtnSignUp.setText("Register");
        jBtnSignUp.setPreferredSize(new java.awt.Dimension(70, 25));
        jBtnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSignUpActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.setPreferredSize(new java.awt.Dimension(70, 25));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPassword.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel6.setText(":");

        jLabel7.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel7.setText("Fisrt Name");

        jLabel8.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel8.setText(":");

        jLabel9.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel9.setText("Last Name");

        jLabel10.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel11.setText("NIC");

        jLabel12.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel12.setText(":");

        jLabel13.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel13.setText("Gender");

        jLabel14.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel14.setText(":");

        jLabel15.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel15.setText("Worker Type");

        jComGender.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jComGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComGenderKeyPressed(evt);
            }
        });

        jComW_type.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jComW_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComW_type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComW_typeKeyPressed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Play", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Employees");

        jTextField2.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel2.setText("E-mail ");

        jTextField3.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel3.setText("Password");

        jTextField4.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jEmail.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEmailKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel16.setText(":");

        jLabel4.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel4.setText(":");

        jLabel5.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel5.setText(":");

        jLabel18.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel18.setText("Status");

        jLabel19.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jLabel19.setText(":");

        jComStatus.setFont(new java.awt.Font("Play", 0, 14)); // NOI18N
        jComStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComStatusKeyPressed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Play", 1, 14)); // NOI18N
        jButton3.setText("Reset");
        jButton3.setPreferredSize(new java.awt.Dimension(70, 25));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComGender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPassword)
                            .addComponent(jEmail)
                            .addComponent(jComW_type, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComGender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComW_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(40, 40, 40)
                .addComponent(jBtnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSignUpActionPerformed
        Boolean canDo = validateFields();
        String email = jEmail.getText();
        String password = String.valueOf(jPassword.getPassword());
        String fname = jTextField1.getText();
        String lname = jTextField2.getText();
        String mobile = jTextField4.getText();
        String nic = jTextField3.getText();
        String gen = String.valueOf(jComGender.getSelectedItem());
        String w_type = String.valueOf(jComW_type.getSelectedItem());
        String status = String.valueOf(jComStatus.getSelectedItem());

        if (canDo) {

            ResultSet rs = null;
            try {
                String q = "SELECT * FROM `users` WHERE `mobile` = ? OR `nic`=? OR `email` = ?";

                HashMap<Integer, Object> q_data = new HashMap<>();
                q_data.put(1, mobile);
                q_data.put(2, nic);
                q_data.put(3, email);

                rs = MySql.select(q, q_data);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                if (!rs.next() && rs != null) {
                    String q = "INSERT INTO `users` (`NIC`,`fname`,`lname`,`email`,`ps`,`mobile`,`registered_date`,`gender_id`,`status_id`,`worker_type_id`) VALUES "
                            + "(?,?,?,?,?,?,?,?,?,?);";

                    HashMap<Integer, Object> q_data = new HashMap<>();
                    q_data.put(1, nic);
                    q_data.put(2, fname);
                    q_data.put(3, lname);
                    q_data.put(4, email);
                    q_data.put(5, password);
                    q_data.put(6, mobile);
                    q_data.put(7, String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))));
                    q_data.put(8, gender.get(gen));
                    q_data.put(9, 2);
                    q_data.put(10, worker_type.get(w_type));

                    MySql.iud(q, q_data);

                    JOptionPane.showMessageDialog(this, "Employee Registation Successfull.", "Successfull", JOptionPane.INFORMATION_MESSAGE);
                    loadTableData();

                } else {
                    JOptionPane.showMessageDialog(this, "User already exits with these details.", "User already exits", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_jBtnSignUpActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Boolean canDo = validateFields();

        String email = jEmail.getText();
        String password = String.valueOf(jPassword.getPassword());
        String fname = jTextField1.getText();
        String lname = jTextField2.getText();
        String mobile = jTextField4.getText();
        String nic = jTextField3.getText();
        String gen = String.valueOf(jComGender.getSelectedItem());
        String w_type = String.valueOf(jComW_type.getSelectedItem());
        String stat = String.valueOf(jComStatus.getSelectedItem());

        if (canDo) {
            try {
                HashMap<Integer, Object> h = new HashMap<>();
                h.put(1, email);
                h.put(2, mobile);

                ResultSet rs = MySql.select("SELECT * FROM `users` WHERE `email`=? OR `mobile` = ?;", h);

                if (rs.getRow() == 0 || (rs.getRow() == 1 && rs.getString("NIC").equals(nic))) {
                    String q = "UPDATE `users` SET `fname`=?, `lname`=?, `ps`=?, `email`=?, `mobile`=?, `gender_id`=?, `status_id`=?, `worker_type_id`=? WHERE `NIC` = ?";
                    HashMap<Integer, Object> q_data = new HashMap<>();
                    q_data.put(1, fname);
                    q_data.put(2, lname);
                    q_data.put(3, password);
                    q_data.put(4, email);
                    q_data.put(5, mobile);
                    q_data.put(6, gender.get(gen));
                    q_data.put(7, status.get(stat));
                    q_data.put(8, worker_type.get(w_type));
                    q_data.put(9, nic);

                    MySql.iud(q, q_data);

                    JOptionPane.showMessageDialog(this, "Data Updated Successfully", "Successfull", JOptionPane.INFORMATION_MESSAGE);
                    loadTableData();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(this, "E-mail or Mobile number already exits with another user.", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void reset() {
        jTextField3.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jEmail.setText("");
        jPassword.setText("");
        jTextField4.setText("");
        jComGender.setSelectedItem("SELECT");
        jComStatus.setSelectedItem("Deactive");
        jComW_type.setSelectedItem("SELECT");
        jComStatus.setEnabled(false);
        jTextField3.setEnabled(true);
    }

    private void jPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyPressed
        if (evt.getKeyCode() == 10) {
            jTextField1.grabFocus();
        }
    }//GEN-LAST:event_jPasswordKeyPressed

    private void jComGenderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComGenderKeyPressed
        if (evt.getKeyCode() == 10) {
            jComW_type.grabFocus();
        }
    }//GEN-LAST:event_jComGenderKeyPressed

    private void jComW_typeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComW_typeKeyPressed
        if (evt.getKeyCode() == 10) {
            jBtnSignUp.doClick();
        }
    }//GEN-LAST:event_jComW_typeKeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == 10) {
            jTextField2.grabFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.getKeyCode() == 10) {
            jTextField4.grabFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if (evt.getKeyCode() == 10) {
            jComGender.grabFocus();
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if (evt.getKeyCode() == 10) {
            jTextField3.grabFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEmailKeyPressed
        if (evt.getKeyCode() == 10) {
            jPassword.grabFocus();
        }
    }//GEN-LAST:event_jEmailKeyPressed

    private void jComStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComStatusKeyPressed
        if (evt.getKeyCode() == 10) {
            jPassword.grabFocus();
        }
    }//GEN-LAST:event_jComStatusKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int id = 0;
        if (evt.getClickCount() == 2) {
            String name = (String) jTable1.getValueAt(row, 1) + " " + (String) jTable1.getValueAt(row, 2);
            try {
                ResultSet rs = MySql.select("SELECT * FROM `users` WHERE `NIC` ='" + (String) jTable1.getValueAt(row, 0) + "';");
                rs.next();
                id = rs.getInt("id");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (id != 0) {
                new Address(this, "users", id, name, "Employee Address", true).setVisible(true);
            }

        }

        if (evt.getClickCount() == 1) {

            jTextField3.setText((String) jTable1.getValueAt(row, 0));
            jTextField1.setText((String) jTable1.getValueAt(row, 1));
            jTextField2.setText((String) jTable1.getValueAt(row, 2));
            jEmail.setText((String) jTable1.getValueAt(row, 3));
            jPassword.setText((String) jTable1.getValueAt(row, 4));
            jTextField4.setText((String) jTable1.getValueAt(row, 5));
            jComGender.setSelectedItem((String) jTable1.getValueAt(row, 6));
            jComStatus.setSelectedItem((String) jTable1.getValueAt(row, 7));
            jComW_type.setSelectedItem((String) jTable1.getValueAt(row, 8));
            jComStatus.setEnabled(true);
            jTextField3.setEnabled(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

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
                new EmployeeRegistation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSignUp;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComGender;
    private javax.swing.JComboBox<String> jComStatus;
    private javax.swing.JComboBox<String> jComW_type;
    private javax.swing.JTextField jEmail;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private Boolean validateFields() {
        String email = jEmail.getText();
        String password = String.valueOf(jPassword.getPassword());
        String fname = jTextField1.getText();
        String lname = jTextField2.getText();
        String mobile = jTextField4.getText();
        String nic = jTextField3.getText();
        String gen = String.valueOf(jComGender.getSelectedItem());
        String w_type = String.valueOf(jComW_type.getSelectedItem());
        String status = String.valueOf(jComStatus.getSelectedItem());

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your e-mail address.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jEmail.grabFocus();
            return false;
        } else if (!EmailValidator.getInstance().isValid(email)) {
            JOptionPane.showMessageDialog(this, "Invalid e-mail address.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jEmail.grabFocus();
            return false;
        } else if (email.length() > 100) {
            JOptionPane.showMessageDialog(this, "E-mail should contain lower than 100 Charactors.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jEmail.grabFocus();
            return false;
        } else if (password.length() > 50) {
            JOptionPane.showMessageDialog(this, "Password should contain lower than 50 Charactors.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jPassword.grabFocus();
            return false;
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter password.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jPassword.grabFocus();
            return false;
        } else if (!password.matches("^[a-zA-Z0-9@#$%& ]+$")) {
            JOptionPane.showMessageDialog(this, "Password Contains unnecessary Charactors.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jPassword.grabFocus();
            return false;
        } else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your First Name.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField1.grabFocus();
            return false;
        } else if (fname.length() > 45) {
            JOptionPane.showMessageDialog(this, "First Name should contain lower than 45 Charactors.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField1.grabFocus();
            return false;
        } else if (!fname.matches("^[a-zA-Z ]+$")) {
            JOptionPane.showMessageDialog(this, "First Name contains unnecessary charactors..", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField1.grabFocus();
            return false;
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Last Name.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField2.grabFocus();
            return false;
        } else if (lname.length() > 45) {
            JOptionPane.showMessageDialog(this, "Last Name should contain lower than 45 Charactors.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField2.grabFocus();
            return false;
        } else if (!lname.matches("^[a-zA-Z ]+$")) {
            JOptionPane.showMessageDialog(this, "Last Name contains unnecessary charactors.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField2.grabFocus();
            return false;
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your Mobile Number.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField4.grabFocus();
            return false;
        } else if (mobile.length() > 10) {
            JOptionPane.showMessageDialog(this, "Mobile Number should contain lower than 10 Numbers.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField4.grabFocus();
            return false;
        } else if (!mobile.matches("^(0(11|21|25|33|41|81|91)\\d{7}|07\\d{8})$")) {
            JOptionPane.showMessageDialog(this, "Invalied Mobile Number.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField4.grabFocus();
            return false;
        } else if (nic.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter your NIC Number.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField3.grabFocus();
            return false;
        } else if (!nic.matches("^(\\d{12}|\\d{9}[Vv])$")) {
            JOptionPane.showMessageDialog(this, "NIC Number should contain lower than 12 Numbers or 9 Numbers with v.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jTextField3.grabFocus();
            return false;
        } else if ("SELECT".equals(gen)) {
            JOptionPane.showMessageDialog(this, "Please Select your Gender.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jComGender.grabFocus();
            return false;
        } else if ("SELECT".equals(w_type)) {
            JOptionPane.showMessageDialog(this, "Please Select your Worker Type.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jComW_type.grabFocus();
            return false;
        } else if ("SELECT".equals(status)) {
            JOptionPane.showMessageDialog(this, "Please Select Status.", "Please fill all Fields", JOptionPane.ERROR_MESSAGE);
            jComW_type.grabFocus();
            return false;
        } else {
            return true;
        }
    }
}
