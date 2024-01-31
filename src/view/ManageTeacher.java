package view;

import exception.MessageDialog;
import static exception.Validator.isDate;
import static exception.Validator.isNumeric;
import static exception.Validator.isValidEmail;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.table.DefaultTableModel;
import services.TeacherService;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.*;
import services.AccountService;
import services.TourService;

public class ManageTeacher extends javax.swing.JFrame {

    public ManageTeacher() {
        initComponents();
        teacherService = new TeacherService();
        accountService = new AccountService();
        tourService = new TourService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    private void loadedTableData(){
        try {
            List<Teacher> teachers_data = teacherService.getAllTeachers();
            tableModel.setRowCount(0);
            if(teachers_data != null){
                for(Teacher teacher : teachers_data){
                    String fullName = teacher.getLastName() + " " + teacher.getFirstName();
                    
                    tableModel.addRow(new Object[]{
                        teacher.getCode(),
                        fullName,
                        teacher.getAddress(),
                        teacher.getPhoneNumber(),
                        teacher.getEmail(),
                        teacher.getBirthDate(),
                        (teacher.getTours() != null) ? teacher.getTours().size() : 0
                    });
                }
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    }
    
    private void initializeTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã giáo viên", "Họ tên",
            "Địa chỉ", "Điện thoại", "Email", "Ngày sinh", "Số lượng chuyến tham quan"});
        teacherTable.setModel(tableModel);
        loadedTableData();
    }
    
    public void clearField() {
        teacherIDField.setText("");
        nameTeacherField.setText("");
        addressTeacherField.setText("");
        phoneNumberTeacherField.setText("");
        emailTeacherField.setText("");
        birthdayTeacherField.setText("");
        String imagePath = "";
        // Hiển thị ảnh
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Chỉnh kích thước ảnh vừa với khung 
        Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_clear = new javax.swing.JButton();
        emailTeacherField = new javax.swing.JTextField();
        detailTour = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        addressTeacherField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        phoneNumberTeacherField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        teacherTable = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();
        birthdayTeacherField = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        teacherIDField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameTeacherField = new javax.swing.JTextField();
        imageLabel = new javax.swing.JLabel();
        imageBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_clear.setBackground(new java.awt.Color(102, 153, 0));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Nhập lại");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        emailTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        detailTour.setBackground(new java.awt.Color(0, 102, 153));
        detailTour.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        detailTour.setForeground(new java.awt.Color(255, 255, 255));
        detailTour.setText("Xem danh sách chuyến tham quan của giáo viên");
        detailTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailTourActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        addressTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Số điện thoại:");

        phoneNumberTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        teacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        teacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(teacherTable);

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Trở lại trang chủ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(0, 102, 51));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN GIÁO VIÊN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Ngày sinh:");

        btn_edit.setBackground(new java.awt.Color(0, 153, 153));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Sửa");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        birthdayTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Mã giáo viên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Email:");

        teacherIDField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Tên giáo viên:");

        nameTeacherField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        imageBrowse.setBackground(new java.awt.Color(0, 153, 153));
        imageBrowse.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageBrowse.setForeground(new java.awt.Color(255, 255, 255));
        imageBrowse.setText("Tải ảnh lên");
        imageBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(detailTour))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addressTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(birthdayTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(32, 32, 32)
                                        .addComponent(teacherIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(32, 32, 32)
                                        .addComponent(nameTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(phoneNumberTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addComponent(jLabel9)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel9)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(teacherIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(nameTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthdayTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(emailTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(phoneNumberTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(detailTour, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void teacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherTableMouseClicked
        try {
            int index = teacherTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn giáo viên", "Thông báo");
                return;
            }
            
            String teacherCode = (String) teacherTable.getValueAt(index, 0);
            String teacherName = (String) teacherTable.getValueAt(index, 1);
            String teacherAddress = (String) teacherTable.getValueAt(index, 2);
            String teacherPhone = (String) teacherTable.getValueAt(index, 3);
            String teacherEmail = (String) teacherTable.getValueAt(index, 4);
            String teacherBirthday = (String) teacherTable.getValueAt(index, 5);
            
            teacherIDField.setText(teacherCode);
            nameTeacherField.setText(teacherName);
            phoneNumberTeacherField.setText(teacherPhone);
            birthdayTeacherField.setText(teacherBirthday);
            emailTeacherField.setText(teacherEmail);
            addressTeacherField.setText(teacherAddress);
            
            int teacherId = teacherService.getIdByTeacher(teacherCode);
            
            Teacher getTeacherImage = teacherService.getTeacherById(teacherId);
            ImageIcon imageIcon = new ImageIcon(getTeacherImage.getImagePath());

            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_teacherTableMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String teacherID = this.teacherIDField.getText().trim();
            String teacherName = this.nameTeacherField.getText().trim();
            String teacherAddress = this.addressTeacherField.getText().trim();
            String teacherPhoneNumber = this.phoneNumberTeacherField.getText().trim();
            String teacherBirthday = this.birthdayTeacherField.getText().trim();
            String teacherEmail = this.emailTeacherField.getText().trim();
            String imagePath = "src\\\\images\\\\user.png";
            if (selectedImagePath.trim() != "") {
                imagePath = selectedImagePath;
            }
            
            // Hiển thị ảnh
            ImageIcon imageIcon = new ImageIcon(selectedImagePath);

            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
            
            if (teacherID.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã giáo viên", "Thông báo");
                return;
            }

            if (teacherName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập họ tên giáo viên", "Thông báo");
                return;
            }

            if (teacherAddress.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (teacherPhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(teacherPhoneNumber)) {
                MessageDialog.showInfoDialog(this, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (teacherBirthday.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(teacherBirthday)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (teacherEmail.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(teacherEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }

            int accountId = accountService.getLastIdFromAccount() + 1;
            
            if(teacherService.isCheckCodeTeacher(teacherID)){
                MessageDialog.showInfoDialog(this, "Trùng mã giáo viên", "Thông báo");
            }else{
                Teacher teacher = new Teacher(
                        accountId,
                        imagePath,
                        teacherID,
                        teacherService.FirstName(teacherName),
                        teacherService.LastName(teacherName),
                        teacherAddress,
                        teacherPhoneNumber,
                        teacherEmail,
                        teacherBirthday,
                        accountId
                );
                accountService.addTeacherAccount(teacher.getCode(), teacher.getCode(), "Tài khoản giáo viên");
                teacherService.addTeacher(teacher);
                loadedTableData();
                MessageDialog.showInfoDialog(this, "Đã thêm thành công", "Thông  báo");
                clearField();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = teacherTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn giáo viên", "Thông báo");
                return;
            }
            
            String teacherCode = (String) teacherTable.getValueAt(index, 0);
            String teacherName = (String) teacherTable.getValueAt(index, 1);
            String teacherAddress = (String) teacherTable.getValueAt(index, 2);
            String teacherPhone = (String) teacherTable.getValueAt(index, 3);
            String teacherEmail = (String) teacherTable.getValueAt(index, 4);
            String teacherBirthday = (String) teacherTable.getValueAt(index, 5);
            
            int teacherId = teacherService.getIdByTeacher(teacherCode);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa lớp này không?", "Xác nhận xóa");
            
            if(confirm == 0){
                teacherService.deleteTeacherById(teacherId);
                loadedTableData();
                clearField();
            }
            
            System.out.println("TeacherId: " + teacherId);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = teacherTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn giáo viên", "Thông báo");
                return;
            }
            
            String code = (String) teacherTable.getValueAt(index, 0);
            String name = (String) teacherTable.getValueAt(index, 1);
            String address = (String) teacherTable.getValueAt(index, 2);
            String phone = (String) teacherTable.getValueAt(index, 3);
            String email = (String) teacherTable.getValueAt(index, 4);
            String birthday = (String) teacherTable.getValueAt(index, 5);
            
            int teacherId = teacherService.getIdByTeacher(code);
            System.out.println("TeacherId : " + teacherId);
            
            Teacher teacher = teacherService.getTeacherById(teacherId);
            System.out.println("Teacher: " + teacher.getCode());
            
            String imagePath = teacher.getImagePath();
            if (!selectedImagePath.equals(imagePath)) {
                if (!selectedImagePath.trim().equals("")) {
                    teacher.setImagePath(selectedImagePath);
                }
            }
                    
            String teacherCode = this.teacherIDField.getText().trim();
            String teacherName = this.nameTeacherField.getText().trim();
            String teacherAddress = this.addressTeacherField.getText().trim();
            String teacherPhoneNumber = this.phoneNumberTeacherField.getText().trim();
            String teacherBirthday = this.birthdayTeacherField.getText().trim();
            String teacherEmail = this.emailTeacherField.getText().trim();
            
            if (teacherCode.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập mã giáo viên", "Thông báo");
                return;
            }

            if (teacherName.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập họ tên giáo viên", "Thông báo");
                return;
            }

            if (teacherAddress.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập địa chỉ", "Thông báo");
                return;
            }
            if (teacherPhoneNumber.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập số điện thoại", "Thông báo");
                return;
            }
            if (!isNumeric(teacherPhoneNumber)) {
                MessageDialog.showInfoDialog(this, "Dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (teacherBirthday.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập ngày sinh", "Thông báo");
                return;
            }

            if (!isDate(teacherBirthday)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            if (teacherEmail.equals("")) {
                MessageDialog.showInfoDialog(this, "Bạn chưa nhập email", "Thông báo");
                return;
            }
            if (!isValidEmail(teacherEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }

            if(teacherService.isCheckCodeTeacher(teacherCode) && !teacherCode.equals(teacherCode)){
                MessageDialog.showInfoDialog(this, "Mã giáo viên không tồn tại", "Thông báo");
            }else{
                teacher.setCode(teacherCode);
                teacher.setFirstName(teacherService.FirstName(teacherName));
                teacher.setLastName(teacherService.LastName(teacherName));
                teacher.setPhoneNumber(teacherPhoneNumber);
                teacher.setBirthDate(teacherBirthday);
                teacher.setEmail(teacherEmail);
                teacher.setAddress(teacherAddress);
                
                teacherService.updateTeacher(teacher, teacherId);
                MessageDialog.showInfoDialog(this, "Cập nhật thành công", "Thông báo");
                loadedTableData();
                clearField();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearField();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        AdminHome homeScreen = new AdminHome();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void detailTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailTourActionPerformed
        try {
            int index = teacherTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn giáo viên để thực hiện chức năng", "Thông báo");
                return;
            }
            
            String code = (String) teacherTable.getValueAt(index, 0);
            
            int teacherId = teacherService.getIdByTeacher(code);
            Teacher teacher = teacherService.getTeacherById(teacherId);
            
            dispose();
            List<Tour> tours = tourService.getToursByTeacherId(teacherId);
            
            ManageToursOfTeacher manageToursOfTeacher = new ManageToursOfTeacher();
            manageToursOfTeacher.setTours(tours);
            manageToursOfTeacher.setTeacherID(teacherId);
            manageToursOfTeacher.setImagePath(teacher.getImagePath());
            manageToursOfTeacher.getTeacherIdLabel().setText(teacher.getCode());
            manageToursOfTeacher.getTeacherNameLabel().setText(teacher.getLastName()+" "+teacher.getFirstName());
            manageToursOfTeacher.getTeacherPhoneNumberLabel().setText(teacher.getPhoneNumber());
            manageToursOfTeacher.getTeacherEmailLable().setText(teacher.getEmail());
            manageToursOfTeacher.getTeacherAdressLable().setText(teacher.getAddress());
            
            manageToursOfTeacher.setLocationRelativeTo(null);
            manageToursOfTeacher.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_detailTourActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageTeacher().setVisible(true);
        });
    }
    
    
    private DefaultTableModel tableModel;
    private TeacherService teacherService;
    private String selectedImagePath = "";
    private static final String imageFolderPath = "src/images";
    private AccountService accountService;
    private TourService tourService;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTeacherField;
    private javax.swing.JTextField birthdayTeacherField;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton detailTour;
    private javax.swing.JTextField emailTeacherField;
    private javax.swing.JButton imageBrowse;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTeacherField;
    private javax.swing.JTextField phoneNumberTeacherField;
    private javax.swing.JTextField teacherIDField;
    private javax.swing.JTable teacherTable;
    // End of variables declaration//GEN-END:variables
}
