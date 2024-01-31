package view;

import exception.MessageDialog;
import models.*;
import services.*;


public class Login extends javax.swing.JFrame {

    private AccountService accountService;
    private StudentService studentService;
    private TeacherService teacherService;
    
    public Login() {
        initComponents();
        accountService = new AccountService();
        studentService = new StudentService();
        teacherService = new TeacherService();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(loginBtn);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagesKey = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        imagesLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        imagesKey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));

        imagesLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(imagesLogin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1)))
                .addContainerGap(163, Short.MAX_VALUE))
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setText("Tên tài khoản");

        username.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setText("Mật khẩu");

        password.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N

        loginBtn.setBackground(new java.awt.Color(0, 153, 0));
        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Đăng nhập");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
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
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(password)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(imagesKey)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagesKey)
                .addGap(42, 42, 42)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        try {
            String username = this.username.getText().trim();
            if(username.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên người dùng không được bỏ trống", "Thông báo");
                return;
            }
            
            String password = this.password.getText().trim();
            if (password.equals("")) {
                MessageDialog.showInfoDialog(this, "Mật khẩu không được bỏ trống", "Thông báo");
                return;
            }
            
            Account account = new Account(username, password);
            
            if(accountService.isExisted(account)){
               accountService.currentLoginUser = accountService.getAccountByUsername(account.getUsername());
               dispose();
               Account loggedInAccount = accountService.getAccountByUsername(account.getUsername());
               
               if(loggedInAccount.getRole().equalsIgnoreCase("Tài khoản sinh viên")){
                   Student loggedInStudent = studentService.getStudentByAccountId(loggedInAccount.getId());
                   if(loggedInStudent == null){
                       MessageDialog.showInfoDialog(jPanel1, "Tài khoản của bạn không tồn tại, vui lòng liên hệ lại với giáo viên chủ nhiệm", "Thông báo");
                        return;
                   }
                   TeacherAndStudentHome teacherAndStudentHome = new TeacherAndStudentHome(loggedInStudent);
                   teacherAndStudentHome.setVisible(true);
                   teacherAndStudentHome.setLocationRelativeTo(null);
               }else if(loggedInAccount.getRole().equalsIgnoreCase("Tài khoản giáo viên")){
                   Teacher loggedInputTeacher = teacherService.getTeacherByAccountId(loggedInAccount.getId());
                   if(loggedInputTeacher == null)
                    {
                        MessageDialog.showInfoDialog(jPanel1, "Tài khoản của bạn không tồn tại, vui lòng liên hệ lại với đội kỹ thuật của nhà trường", "Thông báo");
                        return;
                    }
                   TeacherAndStudentHome teacherAndStudentHome = new TeacherAndStudentHome(loggedInputTeacher);
                   teacherAndStudentHome.setVisible(true);
                   teacherAndStudentHome.setLocationRelativeTo(null);
               }else{
                   AdminHome adminHome = new AdminHome();
                   adminHome.setVisible(true);
               }
            }else{
               MessageDialog.showInfoDialog(this, "Tên tài khoản hoặc mật khẩu không chính xác", "Thông báo");
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tạo tài khoản mới có lỗi, chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagesKey;
    private javax.swing.JLabel imagesLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
