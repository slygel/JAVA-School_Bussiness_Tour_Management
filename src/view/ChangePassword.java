package view;

import exception.MessageDialog;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.*;
import services.*;

public class ChangePassword extends javax.swing.JFrame {
    
    private Student loggedInStudent;
    private AccountService accountService;
    
    public ChangePassword(Student student) {
        initComponents();
        setLocationRelativeTo(null);
        this.loggedInStudent = student;
        accountService = new AccountService();
    }
    
    public ChangePassword() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        oldPasswordField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JPasswordField();
        reEnterPasswordField = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imagesLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setText("Mật khẩu cũ");

        oldPasswordField.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setText("Mật khẩu");

        newPasswordField.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        reEnterPasswordField.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu");

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        imagesLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(imagesLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(imagesLogin)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CancelButton.setBackground(new java.awt.Color(153, 0, 0));
        CancelButton.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        CancelButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelButton.setText("Hủy");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(0, 153, 0));
        saveButton.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Lưu thay đổi");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(newPasswordField)
                            .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reEnterPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(saveButton)
                        .addGap(48, 48, 48)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reEnterPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy cập nhật", "Thông báo", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            dispose();
            try {
                StudentProfile personalAccountInformationScreen = new StudentProfile(loggedInStudent);
                personalAccountInformationScreen.setLocationRelativeTo(null);
                personalAccountInformationScreen.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(UpdateStudentProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            Account account = accountService.getAccountById(loggedInStudent.getAccountId());
            String oldPassword = accountService.getAccountById(loggedInStudent.getAccountId()).getPassword();
            String oldPasswordField = this.oldPasswordField.getText().trim();
            String newPasswordField = this.newPasswordField.getText().trim();
            String reNewPasswordField = this.reEnterPasswordField.getText().trim();
            
            if(oldPasswordField.isEmpty() || newPasswordField.isEmpty() || reNewPasswordField.isEmpty()){
                MessageDialog.showErrorDialog(this, "Vui lòng nhập đủ dữ liệu", "Thông báo");
                return;
            }
            
            if(!oldPassword.equalsIgnoreCase(oldPassword)){
                MessageDialog.showErrorDialog(this, "Mật khẩu không đúng", "Thông báo");
                return;
            }
            
            if(!newPasswordField.equalsIgnoreCase(reNewPasswordField)){
                MessageDialog.showErrorDialog(this, "Nhập lại mật khẩu không đúng", "Thông báo");
                return;
            }
            
            account.setPassword(newPasswordField);
            accountService.updateAccount(account, loggedInStudent.getId());
            MessageDialog.showInfoDialog(this, "Đổi mật khẩu thành công", "Thông báo");
            dispose();
            StudentProfile studentProfile = new StudentProfile(loggedInStudent);
            studentProfile.setLocationRelativeTo(null);
            studentProfile.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel imagesLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JTextField oldPasswordField;
    private javax.swing.JPasswordField reEnterPasswordField;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
