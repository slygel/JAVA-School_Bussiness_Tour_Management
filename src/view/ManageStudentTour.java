package view;

import exception.MessageDialog;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import models.*;
import services.*;

public class ManageStudentTour extends javax.swing.JFrame {

    private String imagePath;
    private List<Tour> tours = new ArrayList<>();
    private CompanyService companyService;
    private TeacherService teacherService;
    private TourService tourService;
    
    public ManageStudentTour() {
        initComponents();
        companyService = new CompanyService();
        teacherService = new TeacherService();
        tourService = new TourService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    public void setTours(List<Tour> tours) {
        this.tours = tours;
        loadTableData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        JLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTourTable = new javax.swing.JTable();
        label7 = new javax.swing.JLabel();
        studentCodeLabel = new javax.swing.JLabel();
        fullNameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        birthDateLabel = new javax.swing.JLabel();
        classIdLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        JLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        JLabel.setText("CHUYẾN THAM QUAN SINH VIÊN THAM GIA");

        imageLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageLabel.setText("Ảnh");

        label1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label1.setText("Mã sinh viên:");

        label2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label2.setText("Họ tên:");

        label3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label3.setText("Địa chỉ:");

        label4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label4.setText("Email:");

        label5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label5.setText("Sô điện thoại:");

        label6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label6.setText("Ngày sinh:");

        studentTourTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(studentTourTable);

        label7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label7.setText("Lớp:");

        studentCodeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        studentCodeLabel.setText("Text");

        fullNameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        fullNameLabel.setText("Text");

        addressLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        addressLabel.setText("Text");

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        emailLabel.setText("Text");

        phoneNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        phoneNumberLabel.setText("Text");

        birthDateLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        birthDateLabel.setText("Text");

        classIdLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        classIdLabel.setText("Text");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(18, 18, 18)
                                .addComponent(studentCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label6)
                                .addGap(18, 18, 18)
                                .addComponent(birthDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label7)
                                .addGap(18, 18, 18)
                                .addComponent(classIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label5)
                                .addGap(18, 18, 18)
                                .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(409, 409, 409)
                        .addComponent(JLabel))
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(JLabel)
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(birthDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(classIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(107, 107, 107)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 127, Short.MAX_VALUE)))
                                .addGap(42, 42, 42))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(studentCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        ManageStudent manageStudent = new ManageStudent();
        manageStudent.setLocationRelativeTo(null);
        manageStudent.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudentTour().setVisible(true);
            }
        });
    }
    
    private void initializeTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến tham quan", "Tên chuyến tham quan", "Mô tả", "Ngày bắt đầu", "Số ghế ", "Tên doanh nghiệp", "Tên giáo viên", "Người đại diện"});
        studentTourTable.setModel(tableModel);
        loadTableData();
    }
    
    private void loadTableData() {
        try {
            if (tours != null) {
                for (Tour tour : tours) {
                String companyName = tourService.getCompanyNameById(tour.getCompanyId());
                String teacherName = tourService.getTeacherNameById(tour.getTeacherId());
                tableModel.addRow(new Object[]{
                        tour.getCode(), 
                        tour.getName(),
                        tour.getStartDate(), 
                        tour.getDescription(),
                        tour.getAvailables(),
                        tour.getPresentator(), 
                        companyName, 
                        teacherName
                });    
                }
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi khi tải dữ liệu", "Thông báo");
            e.printStackTrace();
        }
    }
    
    private void showImage() {
        // Hiển thị ảnh
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Chỉnh kích thước ảnh vừa với khung 
        Image image = imageIcon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        imageLabel.setIcon(imageIcon);
    }
    
    public JLabel getImageLabel() {
        return imageLabel;
    }

    public JLabel getAddressLabel() {
        return addressLabel;
    }

    public JLabel getBirthDateLabel() {
        return birthDateLabel;
    }

    public JLabel getClassIdLabel() {
        return classIdLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JLabel getFullNameLabel() {
        return fullNameLabel;
    }

    public JLabel getPhoneNumberLabel() {
        return phoneNumberLabel;
    }

    public JLabel getStudentCodeLabel() {
        return studentCodeLabel;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setAddressLabel(JLabel addressLabel) {
        this.addressLabel = addressLabel;
    }

    public void setBirthDateLabel(JLabel birthDateLabel) {
        this.birthDateLabel = birthDateLabel;
    }

    public void setClassIdLabel(JLabel classIdLabel) {
        this.classIdLabel = classIdLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public void setFullNameLabel(JLabel fullNameLabel) {
        this.fullNameLabel = fullNameLabel;
    }

    public void setPhoneNumberLabel(JLabel phoneNumberLabel) {
        this.phoneNumberLabel = phoneNumberLabel;
    }

    public void setStudentCodeLabel(JLabel studentCodeLabel) {
        this.studentCodeLabel = studentCodeLabel;
    }

    public void setImageLabel(JLabel imageLabel) {
        this.imageLabel = imageLabel;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        showImage();
    }

    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel birthDateLabel;
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel classIdLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel studentCodeLabel;
    private javax.swing.JTable studentTourTable;
    // End of variables declaration//GEN-END:variables
}
