
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegisterPackage;

import Config.Koneksi;
import LoginPackage.JFrameLogin;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class JFrameRegister extends javax.swing.JFrame {

    /**
     * Creates new form JFrameRegister
     */
    
    private void clear(){
        txtNip.setText(null);
        txtName.setText(null);
        txtEmail.setText(null);
        txtPass.setText(null);
        cbGn.setSelectedItem(null);
        cbJb.setSelectedItem(null);
        
    }
    public JFrameRegister() {
        initComponents();
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
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNip = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        cbGn = new javax.swing.JComboBox<>();
        cbJb = new javax.swing.JComboBox<>();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        labelHaveanAccount = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(86, 177, 222));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("Email");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 250, 250));
        jLabel4.setText("Sign Up");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 30));

        txtNip.setBackground(new java.awt.Color(86, 177, 222));
        txtNip.setForeground(new java.awt.Color(255, 255, 255));
        txtNip.setText("Enter Your NIP..");
        txtNip.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtNip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNipFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNipFocusLost(evt);
            }
        });
        jPanel1.add(txtNip, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 260, 30));

        txtName.setBackground(new java.awt.Color(86, 177, 222));
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        txtName.setText("Name..");
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 260, 30));

        txtEmail.setBackground(new java.awt.Color(86, 177, 222));
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setText("Email..");
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 260, 30));

        txtPass.setBackground(new java.awt.Color(86, 177, 222));
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setText("Password Here..");
        txtPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 260, 30));

        cbGn.setBackground(new java.awt.Color(0, 102, 153));
        cbGn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - Laki", "Perempuan" }));
        jPanel1.add(cbGn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 100, 30));

        cbJb.setBackground(new java.awt.Color(0, 102, 153));
        cbJb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Employee" }));
        cbJb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJbActionPerformed(evt);
            }
        });
        jPanel1.add(cbJb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 100, 30));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 153, 204));
        rSMaterialButtonRectangle1.setText("Sign Up");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 110, 40));

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("I Agree All Privacy..............");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 180, 30));

        jLabel5.setText("Create an Account To Access Our");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        labelHaveanAccount.setForeground(new java.awt.Color(0, 51, 204));
        labelHaveanAccount.setText("Already Have an Account ?");
        labelHaveanAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelHaveanAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHaveanAccountMouseClicked(evt);
            }
        });
        jPanel1.add(labelHaveanAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Name");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 102));
        jLabel14.setText("Password");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 102));
        jLabel15.setText("Gender");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 102));
        jLabel16.setText("NIP");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 102));
        jLabel17.setText("Position");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void cbJbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJbActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        try {
    // Validasi NIP
    String nipToCheck = txtNip.getText();
    String nip = txtNip.getText();
    String nama = txtName.getText();
    String email = txtEmail.getText();
    String password = txtPass.getText();
    String gender = cbGn.getSelectedItem().toString();
    String jabatan = cbJb.getSelectedItem().toString();
    
    // Validasi kolom kosong & Nip Tidak Terdaftar
    if ("Enter Your NIP..".equals(nip) || "Name..".equals(nama) || "Email..".equals(email)
        || "Password Here..".equals(password) || gender.isEmpty() || jabatan.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Semua Kolom Harus Diisi!", "Warning!!", JOptionPane.ERROR_MESSAGE);
    return;
    } else if (!isNIPRegistered(nipToCheck)) {
        JOptionPane.showMessageDialog(this, "NIP Tidak terdaftar", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    clear();

    String sql = "INSERT INTO user (nip, nama, gender, jabatan, email, password) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = Koneksi.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {

        pstm.setString(1, nip);
        pstm.setString(2, nama);
        pstm.setString(3, gender);
        pstm.setString(4, jabatan);
        pstm.setString(5, email);
        pstm.setString(6, password);

        pstm.executeUpdate();
        JOptionPane.showMessageDialog(null, "Proses Registrasi berhasil, Silahkan Login !!");
        clear();

        // Tampilkan JFrameLogin di EDT
        
            JFrameLogin login = new JFrameLogin();
            login.show();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
} catch (HeadlessException | SQLException e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
}

    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed
private boolean isNIPRegistered(String nipToCheck) throws SQLException {
    String query = "SELECT nip FROM pegawai WHERE nip = ?";
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement statement = conn.prepareStatement(query)) {

        statement.setString(1, nipToCheck);
        try (ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next(); // True jika NIP sudah terdaftar
        }
    }
}
    private void txtNipFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNipFocusGained
        String nip = txtNip.getText();
        if(nip.equals("Enter Your NIP..")){
            txtNip.setText("");
        }
    }//GEN-LAST:event_txtNipFocusGained

    private void txtNipFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNipFocusLost
        String nip = txtNip.getText();
        if(nip.equals("") ||nip.equals("Enter Your NIP..")) {
            txtNip.setText("Enter Your NIP..");
        }
    }//GEN-LAST:event_txtNipFocusLost

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        String name = txtName.getText();
        if(name.equals("Name..")){
            txtName.setText("");
        }
    }//GEN-LAST:event_txtNameFocusGained

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        String name = txtName.getText();
        if(name.equals("") ||name.equals("Name..")) {
            txtName.setText("Name..");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        String email = txtEmail.getText();
        if(email.equals("Email..")){
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        String email = txtEmail.getText();
        if(email.equals("") ||email.equals("Email..")) {
            txtEmail.setText("Email..");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        String pass = txtPass.getText();
        if(pass.equals("Password Here..")){
            txtPass.setText("");
        }
    }//GEN-LAST:event_txtPassFocusGained

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost
        String pass = txtPass.getText();
        if(pass.equals("") ||pass.equals("Password Here..")) {
            txtPass.setText("Password Here..");
        }
    }//GEN-LAST:event_txtPassFocusLost

    private void labelHaveanAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHaveanAccountMouseClicked
        JFrameLogin login = new JFrameLogin();
        login.show();
        this.dispose();
    }//GEN-LAST:event_labelHaveanAccountMouseClicked

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
            java.util.logging.Logger.getLogger(JFrameRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbGn;
    private javax.swing.JComboBox<String> cbJb;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelHaveanAccount;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNip;
    private javax.swing.JTextField txtPass;
    // End of variables declaration//GEN-END:variables
}
