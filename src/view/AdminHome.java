package view;

import exception.MessageDialog;
import exception.PDFExporter;
import exception.TransmittedDataShowData;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.*;

public class AdminHome extends javax.swing.JFrame {
    
    private TourService tourService;
    private TeacherService teacherService;
    private StudentService studentService;
    private CompanyService companyService;
    private AccountService accountService;

    public AdminHome() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
       
        tourService = new TourService();
        teacherService = new TeacherService();
        studentService = new StudentService();
        companyService = new CompanyService();
        accountService = new AccountService();
        
        Account currentLoginUser = accountService.currentLoginUser;
        if(!currentLoginUser.getRole().equalsIgnoreCase("Toàn quyền hệ thống")){
            manageSystemBtn.setVisible(false);
        }
        initializeTableOfTours();
        loadTextButton();
        
    }
    
    private void loadTableDataOfTours(){
        try {
            List<Tour> tour_data = tourService.getAllTours();
            List<Company> company_data = companyService.getAllCompanies();
            List<Teacher> teacher_data = teacherService.getAllTeachers();
            tableModel.setRowCount(0);
            if(tour_data != null){
                for(Tour tour : tour_data){
                    String dateString = tour.getStartDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    try {
                        LocalDate inputDate = LocalDate.parse(dateString,formatter);
                        LocalDate currentDate = LocalDate.now();
                        if(currentDate.equals(inputDate)){
                            String companyName = "";
                            String teacherName = "";
                            for(Company comp : company_data){
                                if(comp.getId() == tour.getCompanyId()){
                                    companyName = comp.getName();
                                }
                            }
                            for(Teacher tea : teacher_data){
                                if(tea.getId() == tour.getTeacherId()){
                                    teacherName = tea.getLastName() + " " + tea.getFirstName();
                                }
                            }
                            tableModel.addRow(new Object[]{
                                tour.getCode(),
                                tour.getName(),
                                tour.getDescription(),
                                tour.getAvailables(),
                                tour.getPresentator(), 
                                companyName, 
                                teacherName,
                                tour.getStartDate()
                            });
                        }
                    } catch (Exception e) {
                        MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menu = new javax.swing.JLabel();
        manageStudentBtn = new javax.swing.JButton();
        manageTeacherBtn = new javax.swing.JButton();
        manageCompanyBtn = new javax.swing.JButton();
        manageTourBtn = new javax.swing.JButton();
        manageSystemBtn = new javax.swing.JButton();
        manageClassroomBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        menu1 = new javax.swing.JLabel();
        StudentDataButton = new javax.swing.JButton();
        companyDataButton = new javax.swing.JButton();
        teacherDataButton = new javax.swing.JButton();
        tourDataButton = new javax.swing.JButton();
        menu2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pdfBtn = new javax.swing.JButton();
        excelBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        todayTourTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        menu.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setText("MENU");

        manageStudentBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageStudentBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        manageStudentBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageStudentBtn.setText("Quản lí thông tin sinh viên");
        manageStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStudentBtnActionPerformed(evt);
            }
        });

        manageTeacherBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageTeacherBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        manageTeacherBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageTeacherBtn.setText("Quản lí thông tin giáo viên");
        manageTeacherBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageTeacherBtnActionPerformed(evt);
            }
        });

        manageCompanyBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageCompanyBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        manageCompanyBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageCompanyBtn.setText("Quản lí thông tin doanh nghiệp");
        manageCompanyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCompanyBtnActionPerformed(evt);
            }
        });

        manageTourBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageTourBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        manageTourBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageTourBtn.setText("Quản lí thăm quan doanh nghiệp");
        manageTourBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageTourBtnActionPerformed(evt);
            }
        });

        manageSystemBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageSystemBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        manageSystemBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageSystemBtn.setText("Quản lí hệ thống");
        manageSystemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSystemBtnActionPerformed(evt);
            }
        });

        manageClassroomBtn.setBackground(new java.awt.Color(0, 102, 102));
        manageClassroomBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        manageClassroomBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageClassroomBtn.setText("Quản lí thông tin lớp học");
        manageClassroomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageClassroomBtnActionPerformed(evt);
            }
        });

        logOutBtn.setBackground(new java.awt.Color(204, 0, 0));
        logOutBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        logOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logOutBtn.setText("Đăng xuất");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manageTourBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageStudentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageTeacherBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageCompanyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageClassroomBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageSystemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(menu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(menu)
                .addGap(40, 40, 40)
                .addComponent(manageTourBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(manageStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(manageTeacherBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(manageCompanyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(manageClassroomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(manageSystemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        menu1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        menu1.setText("DỮ LIỆU HIỆN CÓ TRONG HỆ THỐNG");

        StudentDataButton.setBackground(new java.awt.Color(0, 102, 0));
        StudentDataButton.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        StudentDataButton.setForeground(new java.awt.Color(255, 255, 255));
        StudentDataButton.setText("Sinh viên được quản lí");
        StudentDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentDataButtonActionPerformed(evt);
            }
        });

        companyDataButton.setBackground(new java.awt.Color(0, 102, 0));
        companyDataButton.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        companyDataButton.setForeground(new java.awt.Color(255, 255, 255));
        companyDataButton.setText("Doanh nghiệp liên kết với nhà trường");
        companyDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyDataButtonActionPerformed(evt);
            }
        });

        teacherDataButton.setBackground(new java.awt.Color(0, 102, 0));
        teacherDataButton.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        teacherDataButton.setForeground(new java.awt.Color(255, 255, 255));
        teacherDataButton.setText("Giáo viên đại diện doanh nghiệp");
        teacherDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherDataButtonActionPerformed(evt);
            }
        });

        tourDataButton.setBackground(new java.awt.Color(0, 102, 0));
        tourDataButton.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        tourDataButton.setForeground(new java.awt.Color(255, 255, 255));
        tourDataButton.setText("Chuyến thăm quan được tổ chức");
        tourDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tourDataButtonActionPerformed(evt);
            }
        });

        menu2.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        menu2.setText("CÁC CHUYẾN THĂM QUAN ĐƯỢC TỔ CHỨC TRONG NGÀY");

        pdfBtn.setBackground(new java.awt.Color(0, 102, 102));
        pdfBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        pdfBtn.setForeground(new java.awt.Color(255, 255, 255));
        pdfBtn.setText("Xuất danh sách PDF");
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });

        excelBtn.setBackground(new java.awt.Color(0, 102, 102));
        excelBtn.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        excelBtn.setForeground(new java.awt.Color(255, 255, 255));
        excelBtn.setText("Xuất danh sách Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
            }
        });

        todayTourTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(todayTourTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(menu1)
                                .addGap(424, 424, 424))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(menu2)
                                .addGap(291, 291, 291))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tourDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                                            .addComponent(StudentDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(teacherDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(companyDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(excelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(menu1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tourDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StudentDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageTourBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageTourBtnActionPerformed
        dispose();
        ManageTour manageTour = new ManageTour();
        manageTour.setLocationRelativeTo(null);
        manageTour.setVisible(true);
    }//GEN-LAST:event_manageTourBtnActionPerformed

    private void manageStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStudentBtnActionPerformed
        dispose();
        ManageStudent manageStudent = new ManageStudent();
        manageStudent.setLocationRelativeTo(null);
        manageStudent.setVisible(true);
    }//GEN-LAST:event_manageStudentBtnActionPerformed

    private void manageTeacherBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageTeacherBtnActionPerformed
        dispose();
        ManageTeacher manageTeacher = new ManageTeacher();
        manageTeacher.setLocationRelativeTo(null);
        manageTeacher.setVisible(true);
    }//GEN-LAST:event_manageTeacherBtnActionPerformed

    private void manageCompanyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCompanyBtnActionPerformed
        dispose();
        ManageCompany manageCompany = new ManageCompany();
        manageCompany.setLocationRelativeTo(null);
        manageCompany.setVisible(true);
    }//GEN-LAST:event_manageCompanyBtnActionPerformed

    private void manageClassroomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageClassroomBtnActionPerformed
        dispose();
        ManageClassroom manageClassroom = new ManageClassroom();
        manageClassroom.setLocationRelativeTo(null);
        manageClassroom.setVisible(true);
    }//GEN-LAST:event_manageClassroomBtnActionPerformed

    private void manageSystemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSystemBtnActionPerformed
        dispose();
        ManageAccount manageAccount = new ManageAccount();
        manageAccount.setLocationRelativeTo(null);
        manageAccount.setVisible(true);
    }//GEN-LAST:event_manageSystemBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        int key = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn đăng xuất khỏi hệ thống?", "Xác nhận");
        if (key == 0) {
            dispose();
            Login loginScreen = new Login();
            loginScreen.setLocationRelativeTo(null);
            loginScreen.setVisible(true);
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void tourDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tourDataButtonActionPerformed
        try {
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("tours", "home");
            ShowData screen = new ShowData(data);
            if (screen != null) {
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_tourDataButtonActionPerformed

    private void companyDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyDataButtonActionPerformed
        try {
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("companys", "home");
            ShowData screen = new ShowData(data);
            if (screen != null) {
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
            e.printStackTrace();
        }
    }//GEN-LAST:event_companyDataButtonActionPerformed

    private void StudentDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentDataButtonActionPerformed
        try {
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("students", "home");
            ShowData screen = new ShowData(data);
            if (screen != null) {
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_StudentDataButtonActionPerformed

    private void teacherDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherDataButtonActionPerformed
        try {
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("teachers", "home");
            ShowData screen = new ShowData(data);
            if (screen != null) {
                screen.setLocationRelativeTo(null);
                screen.setVisible(true);
            }

        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_teacherDataButtonActionPerformed

    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed
        try {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = currentDate.format(formatter);
            String title = "BẢNG DANH SÁCH CHUYẾN THAM QUAN TRONG NGÀY " + formattedDate;
            PDFExporter.exportTableToPDF(todayTourTable, title);
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(jPanel1, "Có lỗi ở phần xuất PDF, chi tiết: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pdfBtnActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn vị trí để xuất file Excel");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                // Ensure the file has a .xlsx extension
                if (!filePath.toLowerCase().endsWith(".xlsx")) {
                    filePath += ".xlsx";
                }

                File file = new File(filePath);

                // Check if the file already exists
                if (file.exists()) {
                    MessageDialog.showErrorDialog(this, "Tên file đã tồn tại! Vui lòng chọn tên khác.", "Lỗi");
                } else {
                    Workbook workbook = new XSSFWorkbook();

                    LocalDate currentDate = LocalDate.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formattedDate = currentDate.format(formatter);
                    String tourTitle = "DANH SÁCH CHUYẾN THAM QUAN TRONG NGÀY " + formattedDate;

                    Sheet sheet = workbook.createSheet(tourTitle);

                    // Create header row
                    Row headerRow = sheet.createRow(0);

                    CellStyle headerStyle = workbook.createCellStyle();
                    headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    headerStyle.setAlignment(HorizontalAlignment.CENTER);

                    org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
                    headerFont.setColor(IndexedColors.WHITE.getIndex());
                    headerFont.setBold(true);
                    headerStyle.setFont(headerFont);

                    String[] headers = {"Mã chuyến", "Tên chuyến", "Mô tả",
                        "Số lượng", "Người đại diện công ty", "Công ty", "Giáo viên","Ngày diễn ra"};

                    for (int i = 0; i < headers.length; i++) {
                        Cell cell = headerRow.createCell(i);
                        cell.setCellValue(headers[i]);
                        cell.setCellStyle(headerStyle);
                    }

                    // Set cell style with borders
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setBorderBottom(BorderStyle.THIN);
                    cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderTop(BorderStyle.THIN);
                    cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderLeft(BorderStyle.THIN);
                    cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderRight(BorderStyle.THIN);
                    cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());

                    // Write data to the Excel sheet
                    List<Tour> data = tourService.getAllTours();
                    if (data != null) {
                        int rowNum = 1;
                        for (Tour tour : data) {
                            if (!tour.getStartDate().equals(formattedDate)) {
                                continue;
                            }
                            Row row = sheet.createRow(rowNum++);
                            for (int i = 0; i < headers.length; i++) {
                                Cell cell = row.createCell(i);
                                cell.setCellValue(getCellValue(tour, i));
                                cell.setCellStyle(cellStyle);
                            }
                        }
                    }

                    try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                        workbook.write(fileOut);
                    } catch (Exception exs) {
                        throw exs;
                    }

                    workbook.close();

                    MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra khi xuất Excel. Chi tiết: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_excelBtnActionPerformed

    private String getCellValue(Tour tour, int columnIndex) throws Exception {
        switch (columnIndex) {
            case 0:
                return tour.getCode();
            case 1:
                return tour.getName();
            case 2:
                return tour.getDescription();
            case 3:
                return String.valueOf(tour.getAvailables());
            case 4:
                return tour.getPresentator();
            case 5:
                return companyService.getCompanyById(tour.getCompanyId()).getName();
            case 6:
                Teacher teacher = teacherService.getTeacherById(tour.getTeacherId());
                if (teacher == null) {
                    return "";
                }
                String fullName = teacher.getLastName() + " " + teacher.getFirstName();
                return fullName;
            case 7:
                return tour.getStartDate();
            default:
                return "";
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }
    
    private void initializeTableOfTours() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Mô tả",
            "Số lượng", "Người đại diện công ty", "Công ty", "Giáo viên","Ngày diễn ra"});
        todayTourTable.setModel(tableModel);
        loadTableDataOfTours();
    }
    
    private void loadTextButton(){
        try {
            List<Student> students = studentService.getAllStudents();
            List<Tour> tours = tourService.getAllTours();
            List<Teacher> teachers = teacherService.getAllTeachers();
            List<Company> companys = companyService.getAllCompanies();
            
            if(students == null){
                StudentDataButton.setText("0 sinh viên được quản lý");
            }else{
                StudentDataButton.setText(students.size()+" sinh viên được quản lý");
            }
            
            if(tours == null){
                tourDataButton.setText("0 chuyến tham quan được tổ chức");
            }else{
                tourDataButton.setText(tours.size() + " chuyến tham quan được tổ chức");
            }
            
            if(teachers == null){
                teacherDataButton.setText("0 giáo viên đại diện doanh nghiệp");
            }else{
                teacherDataButton.setText(teachers.size()+" giáo viên đại diện doanh nghiệp");
            }
            
            if (companys == null) {
                companyDataButton.setText("0 doanh nghiệp được liên kết với nhà trường");
            } else {
                companyDataButton.setText(companys.size() + " doanh nghiệp được liên kết với nhà trường");
            }
        } catch (Exception e) {
        }
    }

    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StudentDataButton;
    private javax.swing.JButton companyDataButton;
    private javax.swing.JButton excelBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton manageClassroomBtn;
    private javax.swing.JButton manageCompanyBtn;
    private javax.swing.JButton manageStudentBtn;
    private javax.swing.JButton manageSystemBtn;
    private javax.swing.JButton manageTeacherBtn;
    private javax.swing.JButton manageTourBtn;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menu2;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JButton teacherDataButton;
    private javax.swing.JTable todayTourTable;
    private javax.swing.JButton tourDataButton;
    // End of variables declaration//GEN-END:variables
}
