package view;

import exception.MessageDialog;
import static exception.Validator.isDate;
import static exception.Validator.isNumeric;
import static exception.Validator.isValidEmail;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.*;
import view.*;
import services.*;

public class TeacherProfile extends javax.swing.JFrame {

    private Teacher loggedInTeacher;
    private String selectedImagePath = "";
    private static final String imageFolderPath = "src/images/";
    private AccountService accountService;
    private TeacherService teacherService;
    
    public TeacherProfile(Teacher teacher) throws Exception{
        try {
            this.loggedInTeacher = teacher;
            initComponents();
            accountService = new AccountService();
            teacherService = new TeacherService();
            loadInformationTeacher();
        } catch (Exception ex) {
            Logger.getLogger(TeacherProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public TeacherProfile() {
        initComponents();
        accountService = new AccountService();
        teacherService = new TeacherService();
        setLocationRelativeTo(null);
    }
    
    private void loadInformationTeacher() throws Exception{
        if(loggedInTeacher != null){
            teacherNameTitle.setText(loggedInTeacher.getLastName().toUpperCase() + " " + loggedInTeacher.getFirstName().toUpperCase());
            teacherIDField.setText(loggedInTeacher.getCode());
            nameTeacherField.setText(loggedInTeacher.getLastName() + " " + loggedInTeacher.getFirstName());
            birthdayTeacherField.setText(loggedInTeacher.getBirthDate());
            emailTeacherField.setText(loggedInTeacher.getEmail());
            addressTeacherField.setText(loggedInTeacher.getAddress());
            phoneNumberTeacherField.setText(loggedInTeacher.getPhoneNumber());
            ImageIcon imageIcon = new ImageIcon(loggedInTeacher.getImagePath());
            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
            teacherAvatar.setIcon(imageIcon);
            
            List<Account> data_accounts = accountService.getAllAccounts();
            Account selectAccount = null;
            for (Account item : data_accounts) {
                if (item.getId() == loggedInTeacher.getAccountId()) {
                    selectAccount = item;
                    break;
                }
            }
            teacherUsernameInput.setText(selectAccount.getUsername());
            teacherPasswordInput.setText(selectAccount.getPassword());
            disableInput();
        }
    }
    
    private void disableInput() {
        teacherAvataButton.setEnabled(false);
        teacherIDField.setEnabled(false);
        nameTeacherField.setEnabled(false);
        birthdayTeacherField.setEnabled(false);
        phoneNumberTeacherField.setEnabled(false);
        addressTeacherField.setEnabled(false);
        emailTeacherField.setEnabled(false);
        teacherUsernameInput.setEnabled(false);
        teacherPasswordInput.setEnabled(false);
        
        teacherIDField.setDisabledTextColor(Color.BLACK);
        nameTeacherField.setDisabledTextColor(Color.BLACK);
        birthdayTeacherField.setDisabledTextColor(Color.BLACK);
        phoneNumberTeacherField.setDisabledTextColor(Color.BLACK);
        addressTeacherField.setDisabledTextColor(Color.BLACK);
        emailTeacherField.setDisabledTextColor(Color.BLACK);
        teacherUsernameInput.setDisabledTextColor(Color.BLACK);
        teacherPasswordInput.setDisabledTextColor(Color.BLACK);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        teacherNameTitle = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        backpage = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        teacherIDField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        birthdayTeacherField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        addressTeacherField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        phoneNumberTeacherField = new javax.swing.JTextField();
        emailTeacherField = new javax.swing.JTextField();
        nameTeacherField = new javax.swing.JTextField();
        teacherAvatar = new javax.swing.JLabel();
        teacherAvataButton = new javax.swing.JButton();
        changeInformationButton = new javax.swing.JButton();
        saveChangeInfomation = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        changeAccoutButton = new javax.swing.JButton();
        saveChangeAccount = new javax.swing.JButton();
        teacherUsernameInput = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        teacherPasswordInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        teacherNameTitle.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        teacherNameTitle.setForeground(new java.awt.Color(255, 255, 255));
        teacherNameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teacherNameTitle.setText("Nguyễn Tài Tuệ");
        teacherNameTitle.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Giáo viên");

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        backpage.setBackground(new java.awt.Color(204, 51, 0));
        backpage.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        backpage.setForeground(new java.awt.Color(255, 255, 255));
        backpage.setText("Quay lại trang trước");
        backpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backpageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(teacherNameTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(backpage)
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(teacherNameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backpage, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Mã giáo viên:");

        teacherIDField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Ngày sinh:");

        birthdayTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Địa chỉ:");

        addressTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Tên giáo viên:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Email:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Số điện thoại:");

        phoneNumberTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        emailTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        nameTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        teacherAvatar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        teacherAvatar.setText("Ảnh");

        teacherAvataButton.setBackground(new java.awt.Color(0, 153, 153));
        teacherAvataButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        teacherAvataButton.setForeground(new java.awt.Color(255, 255, 255));
        teacherAvataButton.setText("Tải ảnh lên");
        teacherAvataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherAvataButtonActionPerformed(evt);
            }
        });

        changeInformationButton.setBackground(new java.awt.Color(0, 204, 255));
        changeInformationButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        changeInformationButton.setForeground(new java.awt.Color(255, 255, 255));
        changeInformationButton.setText("Thay đổi thông tin");
        changeInformationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInformationButtonActionPerformed(evt);
            }
        });

        saveChangeInfomation.setBackground(new java.awt.Color(0, 153, 51));
        saveChangeInfomation.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        saveChangeInfomation.setForeground(new java.awt.Color(255, 255, 255));
        saveChangeInfomation.setText("Lưu thay đổi");
        saveChangeInfomation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangeInfomationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(teacherIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(birthdayTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(addressTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumberTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(emailTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(nameTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(teacherAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changeInformationButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveChangeInfomation, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(teacherAvataButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teacherIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(birthdayTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(emailTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneNumberTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(teacherAvataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changeInformationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveChangeInfomation, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(teacherAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        changeAccoutButton.setBackground(new java.awt.Color(0, 204, 255));
        changeAccoutButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        changeAccoutButton.setForeground(new java.awt.Color(255, 255, 255));
        changeAccoutButton.setText("Thay đổi thông tin");
        changeAccoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeAccoutButtonActionPerformed(evt);
            }
        });

        saveChangeAccount.setBackground(new java.awt.Color(0, 153, 51));
        saveChangeAccount.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        saveChangeAccount.setForeground(new java.awt.Color(255, 255, 255));
        saveChangeAccount.setText("Lưu thay đổi");
        saveChangeAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangeAccountActionPerformed(evt);
            }
        });

        teacherUsernameInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Tên tài khoản:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Mật khẩu:");

        teacherPasswordInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(changeAccoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveChangeAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(teacherPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(134, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherUsernameInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeAccoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveChangeAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("TÀI KHOẢN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setText("THÔNG TIN GIÁO VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backpageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backpageActionPerformed
        dispose();
        TeacherAndStudentHome screen = new TeacherAndStudentHome(loggedInTeacher);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
    }//GEN-LAST:event_backpageActionPerformed

    private void teacherAvataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherAvataButtonActionPerformed
        JFileChooser browseImageFile = new JFileChooser();

        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpeg", "jpg", "jfif", "svg");
        browseImageFile.addChoosableFileFilter(fnef);

        int showOpenDialogue = browseImageFile.showOpenDialog(null);

        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();

            // Tạo đường dẫn mới cho tập tin hình ảnh đến thư mục đích
            Path currentDirectory = Paths.get("").toAbsolutePath();
            Path destinationDirectory = currentDirectory.resolve(Paths.get("src", "images"));
            Path destinationPath = destinationDirectory.resolve(selectedImageFile.getName());

            try {
                // Sao chép tập tin vào thư mục đích
                Files.copy(selectedImageFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "Tải tệp thành công");

                // Lấy đường dẫn tương đối của tập tin đã lưu
                Path relativePath = currentDirectory.relativize(destinationPath);
                selectedImagePath = relativePath.toString();

                // Hiển thị ảnh
                ImageIcon imageIcon = new ImageIcon(selectedImageFile.toURI().toURL()); // Chuyển đổi File thành URL
                Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi trong quá trình lưu tệp");
            }
        }
    }//GEN-LAST:event_teacherAvataButtonActionPerformed

    private void changeInformationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInformationButtonActionPerformed
        nameTeacherField.setEnabled(true);
        birthdayTeacherField.setEnabled(true);
        phoneNumberTeacherField.setEnabled(true);
        addressTeacherField.setEnabled(true);
        emailTeacherField.setEnabled(true);
        teacherAvataButton.setEnabled(true);
    }//GEN-LAST:event_changeInformationButtonActionPerformed

    private void saveChangeInfomationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangeInfomationActionPerformed
        try {
            String teacherName = this.nameTeacherField.getText().trim();
            String teacherAddress = this.addressTeacherField.getText().trim();
            String teacherPhoneNumber = this.phoneNumberTeacherField.getText().trim();
            String teacherBirthday = this.birthdayTeacherField.getText().trim();
            String teacherEmail = this.emailTeacherField.getText().trim();
            
            String imagePath = loggedInTeacher.getImagePath();

            if (!selectedImagePath.equals(imagePath)) {
                if (!selectedImagePath.trim().equals("")) {
                    loggedInTeacher.setImagePath(selectedImagePath);
                }
            }
            
            if (teacherName.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập họ tên giáo viên", "Thông báo");
                return;
            }

            if (teacherAddress.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (teacherPhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(teacherPhoneNumber)) {
                MessageDialog.showInfoDialog(jPanel1, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (teacherBirthday.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(teacherBirthday)) {
                MessageDialog.showInfoDialog(jPanel1, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (teacherEmail.equals("")) {
                MessageDialog.showInfoDialog(jPanel1, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(teacherEmail)) {
                MessageDialog.showInfoDialog(jPanel1, "Email không đúng định dạng", "Thông báo");
                return;
            }
            
            loggedInTeacher.setFirstName(TeacherService.FirstName(teacherName));
            loggedInTeacher.setLastName(TeacherService.LastName(teacherName));
            loggedInTeacher.setPhoneNumber(teacherPhoneNumber);
            loggedInTeacher.setBirthDate(teacherBirthday);
            loggedInTeacher.setEmail(teacherEmail);
            loggedInTeacher.setAddress(teacherAddress);
            
            teacherService.updateTeacher(loggedInTeacher, loggedInTeacher.getId());
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            loadInformationTeacher();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveChangeInfomationActionPerformed

    private void changeAccoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeAccoutButtonActionPerformed
        teacherPasswordInput.setEnabled(true);
    }//GEN-LAST:event_changeAccoutButtonActionPerformed

    private void saveChangeAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangeAccountActionPerformed
        try {
            String password = teacherPasswordInput.getText().trim();
            if(password.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mật khẩu", "Thông báo");
                return;
            }
            Account account = accountService.getAccountById(loggedInTeacher.getId());
            account.setPassword(password);
            accountService.updateAccount(account, loggedInTeacher.getId());
            MessageDialog.showInfoDialog(this, "Cập nhật thành công", "Thông báo");
            loadInformationTeacher();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_saveChangeAccountActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTeacherField;
    private javax.swing.JButton backpage;
    private javax.swing.JTextField birthdayTeacherField;
    private javax.swing.JButton changeAccoutButton;
    private javax.swing.JButton changeInformationButton;
    private javax.swing.JTextField emailTeacherField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField nameTeacherField;
    private javax.swing.JTextField phoneNumberTeacherField;
    private javax.swing.JButton saveChangeAccount;
    private javax.swing.JButton saveChangeInfomation;
    private javax.swing.JButton teacherAvataButton;
    private javax.swing.JLabel teacherAvatar;
    private javax.swing.JTextField teacherIDField;
    private javax.swing.JLabel teacherNameTitle;
    private javax.swing.JTextField teacherPasswordInput;
    private javax.swing.JTextField teacherUsernameInput;
    // End of variables declaration//GEN-END:variables
}
