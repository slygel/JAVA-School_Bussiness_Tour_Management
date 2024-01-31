package view;

import exception.MessageDialog;
import static exception.Validator.*;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.Classroom;
import models.Student;
import models.Teacher;
import models.Tour;
import services.AccountService;
import services.ClassroomService;
import services.StudentService;
import services.TourService;

public class ManageStudent extends javax.swing.JFrame {
    
    public ManageStudent() {
        initComponents();
        studentService = new StudentService();
        classroomService = new ClassroomService();
        accountService = new AccountService();
        tourService = new TourService();
        loadComboBox();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ", "Tên", "Địa chỉ", "SĐT", "Email", "Ngày sinh", "Lớp"});
        studentTable.setModel(tableModel); 
        loadDataTable();
    }
    
    private void loadDataTable(){
        try {
            List<Student> students_data = studentService.getAllStudents();
            List<Classroom> classroom_data = classroomService.getAllClassroom();
            tableModel.setRowCount(0);
            if(students_data != null){
                for(Student student : students_data){
                    String className = studentService.getStudentClassNameById(student.getClassId());
                    tableModel.addRow(new Object[]{
                        student.getCode(),
                        student.getLastName(),
                        student.getFirstName(),
                        student.getAddress(),
                        student.getPhoneNumber(),
                        student.getEmail(),
                        student.getBirthDate(),
                        className
                    });
                }
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    }
    
    private void loadComboBox() {
        try {
            List<Classroom> classroom_data = classroomService.getAllClassroom();
            // Xóa các mục cũ trước khi thêm mới
            classroomInput.removeAllItems();

            for (Classroom classroom : classroom_data) {
                classroomInput.addItem(classroom.getName());
            }
            
            Object selectedClassroom = classroomInput.getSelectedItem();
            System.out.println("Giá trị được chọn: " + selectedClassroom);                

        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho combobox có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
}
    
    private void clearAllFields(){
        txt_code.setText("");
        txt_last_name.setText("");
        txt_first_name.setText("");
        txt_address.setText("");
        txt_email.setText("");
        txt_phone.setText("");
        txt_datebirth.setText("");
        classroomInput.setSelectedIndex(0);
        txt_code.requestFocus();
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

        btn_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_code = new javax.swing.JTextField();
        txt_last_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_first_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_StudentTours = new javax.swing.JButton();
        txt_datebirth = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        imageBrowse = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        classroomInput = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Trở lại trang chủ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Mã sinh viên:");

        txt_code.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_last_name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Họ:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Tên:");

        txt_first_name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Địa chỉ:");

        txt_address.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Ngày sinh:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Lớp:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN SINH VIÊN");

        btn_add.setBackground(new java.awt.Color(0, 102, 51));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(0, 102, 102));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Sửa");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(102, 153, 0));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Nhập lại");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_StudentTours.setBackground(new java.awt.Color(0, 102, 153));
        btn_StudentTours.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_StudentTours.setForeground(new java.awt.Color(255, 255, 255));
        btn_StudentTours.setText("Chuyến thăm quan sinh viên tham gia");
        btn_StudentTours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StudentToursActionPerformed(evt);
            }
        });

        txt_datebirth.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txt_phone.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        imageBrowse.setBackground(new java.awt.Color(0, 153, 153));
        imageBrowse.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageBrowse.setForeground(new java.awt.Color(255, 255, 255));
        imageBrowse.setText("Tải ảnh lên");
        imageBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageBrowseActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Email:");

        imageLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageLabel.setText("Ảnh");

        classroomInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1189, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel4)))
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10))
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_phone, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_first_name, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txt_address, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_datebirth, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                        .addComponent(classroomInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_StudentTours, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(668, 668, 668))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel9)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_StudentTours, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageBrowse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(49, 49, 49)
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
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_datebirth, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(classroomInput, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
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

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String studentCode = this.txt_code.getText().trim();
            String studentLastName = this.txt_last_name.getText().trim();
            String studentFirstName = this.txt_first_name.getText().trim();
            String studentAddress = this.txt_address.getText().trim();
            String studentPhone = this.txt_phone.getText().trim();
            String studentEmail = this.txt_email.getText().trim();
            String studentBirthDate = this.txt_datebirth.getText().trim();
//            Classroom classroom = (Classroom) classroomInput.getSelectedItem();
            
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
            
            if(studentCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã sinh viên không được bỏ trống", "Thông báo");
                return;
            }
            
            if(studentLastName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên sinh viên không được bỏ trống", "Thông báo");
                return;
            }
            
            if(studentFirstName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(studentAddress.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Địa chỉ sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(studentPhone.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "SĐT sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(studentEmail.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Email sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(studentBirthDate.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Ngày sinh của sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if (!isNumeric(studentPhone)) {
                MessageDialog.showInfoDialog(this, "dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (!isValidEmail(studentEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }
            if (!isDate(studentBirthDate)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            
            if(studentService.isExistedStudentCode(studentCode)){
                MessageDialog.showInfoDialog(this, "Mã sinh viên đã tồn tại", "Thông báo");
                return;
            }
            
            if (classroomInput.getSelectedItem() instanceof String) {
                String selectedClassName = (String) classroomInput.getSelectedItem();
                System.out.println("SelectedClassName: " + selectedClassName);
                // Tìm đối tượng Classroom tương ứng với tên lớp học được chọn
                List<Classroom> classroom_data = classroomService.getAllClassroom();
                for (Classroom c : classroom_data) {
                    if (c.getName().equals(selectedClassName)) {
                        Classroom classroom = c;
                        int classId = classroomService.getClassIdByClassName(classroom);
                        
                        int accountId = accountService.getLastIdFromAccount() + 1;
           
                        Student student = new Student(
                                accountId, 
                                imagePath, 
                                studentCode,
                                studentFirstName,
                                studentLastName, 
                                studentAddress, 
                                studentPhone, 
                                studentEmail, 
                                studentBirthDate, 
                                accountId,
                                classId
                        );

                        System.out.println("Student: " + student.getCode());
                        System.out.println("ClassId : " + classId);
                        accountService.addStudentAccount(student.getCode(), student.getCode(), "Tài khoản sinh viên");
                        studentService.addStudent(student);
                        loadDataTable();
                        MessageDialog.showInfoDialog(this, "Thêm sinh viên thành công", "Thông báo");
                        clearAllFields();
                        break;
                    }
                }
            } else {
                System.out.println("Kiểu dữ liệu không phải là String");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
        try {
            int index = studentTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn sinh viên", "Thông báo");
                return;
            }
            String code = (String) studentTable.getValueAt(index, 0);
            String lastName = (String) studentTable.getValueAt(index, 1);
            String firstName = (String) studentTable.getValueAt(index, 2);
            String address = (String) studentTable.getValueAt(index, 3);
            String phone = (String) studentTable.getValueAt(index, 4);
            String email = (String) studentTable.getValueAt(index, 5);
            String birthdate = (String) studentTable.getValueAt(index, 6);
            
            // Lấy ra studentId theo studentCode
            int studentId = studentService.getIdByStudent(code);
            
            // Lấy ra đối tượng Student theo studentId
            Student getStudentImage = studentService.getStudentById(studentId);
            
            // Lấy ra classId theo studentId
            int classId = studentService.getClassIdByStudentId(studentId);
            
            // Lấy ra đối tượng Classroom theo classId
            Classroom classroom = classroomService.getClassNameById(classId);
            
            classroomInput.setSelectedItem(classroom.getName());
            txt_code.setText(code);
            txt_last_name.setText(lastName);
            txt_first_name.setText(firstName);
            txt_address.setText(address);
            txt_email.setText(email);
            txt_phone.setText(phone);
            txt_datebirth.setText(birthdate);
            
            ImageIcon imageIcon = new ImageIcon(getStudentImage.getImagePath());

            // Chỉnh kích thước ảnh vừa với khung 
            Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_studentTableMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = studentTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn sinh viên", "Thông báo");
                return;
            }
            
            String code = (String) studentTable.getValueAt(index, 0);
            String lastName = (String) studentTable.getValueAt(index, 1);
            String firstName = (String) studentTable.getValueAt(index, 2);
            String address = (String) studentTable.getValueAt(index, 3);
            String phone = (String) studentTable.getValueAt(index, 4);
            String email = (String) studentTable.getValueAt(index, 5);
            String birthdate = (String) studentTable.getValueAt(index, 6);
            
            int studentId = studentService.getIdByStudent(code);
            System.out.println(studentId);
            Student student = studentService.getStudentById(studentId);
            System.out.println(student);
            
            String imagePath = student.getImagePath();
            if (!selectedImagePath.equals(imagePath)) {
                if (!selectedImagePath.trim().equals("")) {
                    student.setImagePath(selectedImagePath);
                }
            }
            
            String studentCode = this.txt_code.getText().trim();
            String studentLastName = this.txt_last_name.getText().trim();
            String studentFirstName = this.txt_first_name.getText().trim();
            String studentAddress = this.txt_address.getText().trim();
            String studentPhone = this.txt_phone.getText().trim();
            String studentEmail = this.txt_email.getText().trim();
            String studentBirthDate = this.txt_datebirth.getText().trim();
            
            if(studentCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã sinh viên không được bỏ trống", "Thông báo");
                return;
            }
            
            if(studentLastName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên sinh viên không được bỏ trống", "Thông báo");
                return;
            }
            
            if(studentFirstName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(studentAddress.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Địa chỉ sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(studentPhone.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "SĐT sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(studentEmail.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Email sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if(studentBirthDate.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Ngày sinh của sinh viên không được bỏ trống", "Thông báo");
                return; 
            }
            
            if (!isNumeric(studentPhone)) {
                MessageDialog.showInfoDialog(this, "dữ liệu nhập vào phải là số", "Thông báo");
                return;
            }
            if (!isValidEmail(studentEmail)) {
                MessageDialog.showInfoDialog(this, "Email không đúng định dạng", "Thông báo");
                return;
            }
            if (!isDate(studentBirthDate)) {
                MessageDialog.showInfoDialog(this, "Ngày sinh nhập chưa đúng định dạng", "Thông báo");
                return;
            }
            
            if(studentService.isExistedStudentCode(studentCode) && !studentCode.equals(code)){
                MessageDialog.showInfoDialog(this, "Mã sinh viên không tồn tại", "Thông báo");
                return;
            }
            
            String selectedClassName = (String) classroomInput.getSelectedItem();
            System.out.println("SelectedClassName: " + selectedClassName);
        
            // Tìm đối tượng Classroom tương ứng với tên lớp học được chọn
            List<Classroom> classroom_data = classroomService.getAllClassroom();
            for (Classroom c : classroom_data) {
                if (c.getName().equals(selectedClassName)) {
                    Classroom classroom = c;
                    int classId = classroomService.getClassIdByClassName(classroom);

                    System.out.println("classId: " + classId);
                    student.setCode(studentCode);
                    student.setFirstName(studentFirstName);
                    student.setLastName(studentLastName);
                    student.setPhoneNumber(studentPhone);
                    student.setBirthDate(studentBirthDate);
                    student.setEmail(studentEmail);
                    student.setAddress(studentAddress);
                    student.setClassId(classId);

                    studentService.updateStudent(student, studentId);
                    loadDataTable();
                    MessageDialog.showInfoDialog(this, "Cập nhật sinh viên thành công", "Thông báo");
                    clearAllFields();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = studentTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn sinh viên", "Thông báo");
                return;
            }
            
            String code = (String) studentTable.getValueAt(index, 0);
            
            int studentId = studentService.getIdByStudent(code);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sinh viên này không?", "Xác nhận xóa");
            
            if(confirm == 0){
                studentService.deleteStudentById(studentId);
                loadDataTable();
                MessageDialog.showInfoDialog(this, "Xóa sinh viên thành công", "Thông báo");
                clearAllFields();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearAllFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        AdminHome homeScreen = new AdminHome();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_StudentToursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StudentToursActionPerformed
        try {
            int index = studentTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn sinh viên để thực hiện chức năng", "Thông báo");
                return;
            }
            String code = (String) studentTable.getValueAt(index, 0);
            
            Student student = studentService.getStudentByStudentCode(code);
            dispose();
            
            int studentId = student.getId();
            System.out.println("StudentId: " + studentId);
            List<Tour> tours = tourService.getToursByStudentId(studentId);
            System.out.println("Tours: " + tours);
            
            ManageStudentTour manageStudentTourScreen = new ManageStudentTour();
            manageStudentTourScreen.setTours(tours);
            manageStudentTourScreen.setImagePath(student.getImagePath());
            manageStudentTourScreen.getStudentCodeLabel().setText(student.getCode());
            manageStudentTourScreen.getFullNameLabel().setText(student.getLastName() + " " + student.getFirstName());
            manageStudentTourScreen.getAddressLabel().setText(student.getAddress());
            manageStudentTourScreen.getPhoneNumberLabel().setText(student.getPhoneNumber());
            manageStudentTourScreen.getEmailLabel().setText(student.getEmail());
            manageStudentTourScreen.getBirthDateLabel().setText(student.getBirthDate());
            manageStudentTourScreen.getClassIdLabel().setText(classroomService.getClassNameById(student.getClassId()).getName());
            
            manageStudentTourScreen.setLocationRelativeTo(null);
            manageStudentTourScreen.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_StudentToursActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }
    
    private DefaultTableModel tableModel;
    private String selectedImagePath = "";
    private StudentService studentService;
    private ClassroomService classroomService;
    private AccountService accountService;
    private TourService tourService;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_StudentTours;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JComboBox<Object> classroomInput;
    private javax.swing.JButton imageBrowse;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable studentTable;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_datebirth;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
