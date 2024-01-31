
package view;

import exception.MessageDialog;
import exception.Validator;
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
import services.ClassroomService;
import services.StudentService;
import view.*;

public class UpdateStudentProfile extends javax.swing.JFrame {

    private static Student loggedInStudent;
    private static String selectedImagePath;
    private StudentService studentService;
    private ClassroomService classroomService;
    
    public UpdateStudentProfile(Student student){
        initComponents();
        setLocationRelativeTo(null);
        studentService = new StudentService();
        classroomService = new ClassroomService();
        this.loggedInStudent = student;
    }
    
    public UpdateStudentProfile() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_first_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_datebirth = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_last_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        imageBrowse = new javax.swing.JButton();
        UpdateProfileButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_first_name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        txt_address.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Ngày sinh:");

        txt_datebirth.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_phone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Email:");

        txt_last_name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Họ:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Tên:");

        imageLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        imageBrowse.setBackground(new java.awt.Color(0, 153, 153));
        imageBrowse.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageBrowse.setForeground(new java.awt.Color(255, 255, 255));
        imageBrowse.setText("Tải ảnh lên");
        imageBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBrowseActionPerformed(evt);
            }
        });

        UpdateProfileButton.setBackground(new java.awt.Color(0, 204, 255));
        UpdateProfileButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        UpdateProfileButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdateProfileButton.setText("Lưu thay đổi");
        UpdateProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateProfileButtonActionPerformed(evt);
            }
        });

        CancelButton.setBackground(new java.awt.Color(204, 51, 0));
        CancelButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CancelButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelButton.setText("Hủy bỏ");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)))
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UpdateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_datebirth)
                    .addComponent(txt_address)
                    .addComponent(txt_first_name)
                    .addComponent(txt_phone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_first_name, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_datebirth, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
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
    
    private void imageBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageBrowseActionPerformed
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
                loggedInStudent.setImagePath(selectedImagePath);
                studentService.updateStudent(loggedInStudent,loggedInStudent.getId());

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
    }//GEN-LAST:event_imageBrowseActionPerformed

    private void UpdateProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateProfileButtonActionPerformed
        try {
            String lastName = this.txt_last_name.getText().trim();
            String firstName = this.txt_first_name.getText().trim();
            String address = this.txt_address.getText().trim();
            String phoneNumber = this.txt_phone.getText().trim();
            String email = this.txt_email.getText().trim();
            String birthDate = this.txt_datebirth.getText().trim();
            
            if(lastName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên sinh viên không được bỏ trống", "Thông báo");
                return;
            }
            
            if(firstName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(address.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Địa chỉ sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(phoneNumber.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "SĐT sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(email.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Email sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(birthDate.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Ngày sinh của sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if (!Validator.isNumeric(phoneNumber)) {
                MessageDialog.showErrorDialog(this, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }

            if (!Validator.isValidEmail(email)) {
                MessageDialog.showErrorDialog(this, "Emal không đúng định dạng", "Thông báo");
                return;
            }
            
            loggedInStudent.setFirstName(firstName);
            loggedInStudent.setLastName(lastName);
            loggedInStudent.setAddress(address);
            loggedInStudent.setPhoneNumber(phoneNumber);
            loggedInStudent.setEmail(email);
            loggedInStudent.setBirthDate(birthDate);
            
            studentService.updateStudent(loggedInStudent, loggedInStudent.getId());
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            dispose();
            StudentProfile studentProfile = new StudentProfile(loggedInStudent);
            studentProfile.setLocationRelativeTo(null);
            studentProfile.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_UpdateProfileButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateStudentProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton UpdateProfileButton;
    private javax.swing.JButton imageBrowse;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_datebirth;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
