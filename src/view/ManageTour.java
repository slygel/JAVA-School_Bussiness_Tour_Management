package view;

import dao.TourDao;
import exception.MessageDialog;
import static exception.Validator.isDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.BreakNode;
import models.*;
import services.CompanyService;
import services.TeacherService;
import services.TourService;

public class ManageTour extends javax.swing.JFrame {

    private int teacherId = -1;
    
    public ManageTour() {
        initComponents();
        setLocationRelativeTo(null);
        tourServices = new TourService();
        teacherService = new TeacherService();
        companyService = new CompanyService();
        loadComboBox();
        initializeTable();
    }
    
    public ManageTour(int index) {
        initComponents();
        this.teacherId = index;
        tourServices = new TourService();
        teacherService = new TeacherService();
        companyService = new CompanyService();
        setLocationRelativeTo(null);
        loadComboBox();
        initializeTable();
    }
    
    private void clearAllFields(){
        codeInput.setText("");
        nameInput.setText("");
        descriptionInput.setText("");
        startDateInput.setText("");
        presentatorInput.setText("");
        availablesInput.setText("");
    }
    
    private void loadComboBox(){
        try {
            List<Company> company_data = companyService.getAllCompanies();
            companyInput.removeAllItems();
            for(Company comp : company_data){
                companyInput.addItem(comp.getName());
            }
            Object selectedCompany = companyInput.getSelectedItem();
            
            
            List<Teacher> teacher_data = teacherService.getAllTeachers();
            teacherInput.removeAllItems();
            for(Teacher teacher : teacher_data){
                teacherInput.addItem(teacher.getLastName() + " " + teacher.getFirstName());
            }
            Object selectedTeacher = teacherInput.getSelectedItem();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho combobox có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    private void loadTableData(){
        try {
            List<Tour> tour_data = tourServices.getAllTours();
            tableModel.setRowCount(0);
            if(tour_data != null){
                for (Tour tour : tour_data) {
                String companyName = tourServices.getCompanyNameById(tour.getCompanyId());
                
                String teacherName = "";
                if (tour.getTeacherId() > 0) {
                    teacherName = tourServices.getTeacherNameById(tour.getTeacherId());
                }
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
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Thời gian", "Mô tả",
            "Số lượng", "Người đại diện", "Công ty", "Giáo viên"});
        tourTable.setModel(tableModel);
        if (teacherId >= 0) {
            btn_delete.setEnabled(false);
            btn_back.setText("Quay lại trang trước");
        }
        loadTableData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tourTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        codeInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nameInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descriptionInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        startDateInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        presentatorInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        availablesInput = new javax.swing.JTextField();
        companyInput = new javax.swing.JComboBox<>();
        teacherInput = new javax.swing.JComboBox<>();
        btn_back = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        viewStudentListButton = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tourTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tourTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tourTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tourTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Mã chuyến thăm quan:");

        codeInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Tên chuyến tham quan:");

        nameInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Mô tả hoạt động chuyến đi:");

        descriptionInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Ngày diễn ra: ");

        startDateInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Doanh nghiệp chủ quản:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Người đại diện doanh nghiệp:");

        presentatorInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Giảng viên đại diện trường:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Số lượng sinh viên có thể đi:");

        availablesInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        companyInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        teacherInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btn_back.setBackground(new java.awt.Color(153, 0, 0));
        btn_back.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Trở lại trang chủ");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(0, 153, 153));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Sửa");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
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

        btn_clear.setBackground(new java.awt.Color(102, 153, 0));
        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Nhập lại");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        viewStudentListButton.setBackground(new java.awt.Color(0, 102, 153));
        viewStudentListButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viewStudentListButton.setForeground(new java.awt.Color(255, 255, 255));
        viewStudentListButton.setText("Danh sách sinh viên tham gia");
        viewStudentListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStudentListButtonActionPerformed(evt);
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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN CHUYẾN THĂM QUAN DOANH NGHIỆP");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(teacherInput, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel5))
                                                .addGap(23, 23, 23)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(codeInput, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                                    .addComponent(nameInput, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                                    .addComponent(descriptionInput)
                                                    .addComponent(startDateInput)
                                                    .addComponent(companyInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(presentatorInput)))
                                            .addComponent(availablesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(431, 431, 431))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(viewStudentListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_back)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel9)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel9)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(viewStudentListButton, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(companyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(presentatorInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(teacherInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(availablesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(141, 141, 141))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        if(teacherId < 0){
            dispose();
            AdminHome homeScreen = new AdminHome();
            homeScreen.setLocationRelativeTo(null);
            homeScreen.setVisible(true);
        }else{
            Teacher teacher;
            try {
                dispose();
                teacher = teacherService.getTeacherById(teacherId);
                List<Tour> tours = tourServices.getToursByTeacherId(teacherId);
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
            }
        }
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String tourName = this.nameInput.getText().trim();
            String tourCode = this.codeInput.getText().trim();
            String tourDes = this.descriptionInput.getText().trim();
            String tourDate = this.startDateInput.getText().trim();
            String presentator = this.presentatorInput.getText().trim();
            
            if(tourDate.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Ngày tham quan không được trống", "Thông báo");
                return;
            }
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(tourDate, formatter);
            LocalDate currentDate = LocalDate.now();
            
            String availablesText = this.availablesInput.getText().trim();
            if (availablesText.isEmpty()) {
                MessageDialog.showInfoDialog(this, "Số lượng tham quan không được trống", "Thông báo");
                return;
            }

            int availables = Integer.parseInt(availablesText);
            
            if(tourCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã chuyến tham quan không được trống", "Thông báo");
                return;
            }
            if(tourName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên chuyến tham quan không được trống", "Thông báo");
                return;
            }
            if(tourDes.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mô tả chuyến tham quan không được trống", "Thông báo");
                return;
            }
            
            if (currentDate.compareTo(inputDate) >= 0) {
                MessageDialog.showInfoDialog(this, "Ngày khởi hành của chuyến đi phải lớn hơn ngày hiện tại", "Thông báo");
                return;
            }
            if(presentator.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Người đại diện không được trống", "Thông báo");
                return;
            }
            if(availables < 10){
                MessageDialog.showInfoDialog(this, "Số lượng tham quan không được dưới 10 người", "Thông báo");
                return;
            }
            if(!isDate(tourDate)){
                MessageDialog.showInfoDialog(this, "Nhập ngày không đúng định dạng", "Thông báo");
                return;
            }
            if(tourServices.isExistedTourCode(tourCode)){
                MessageDialog.showInfoDialog(this, "Mã chuyến tham quan đã tồn tại", "Thông báo");
                return;
            }
            if(companyInput.getSelectedItem() instanceof String && teacherInput.getSelectedItem() instanceof String){
                String selectedCompanyName = (String) companyInput.getSelectedItem();
                String selectedTeacherName = (String) teacherInput.getSelectedItem();
                
                
                List<Company> company_data = companyService.getAllCompanies();
                
                Company selectedCompany = null;
                for(Company company : company_data){
                    if(company.getName().equalsIgnoreCase(selectedCompanyName)){
                        selectedCompany = company;
                        break;
                    }
                }
                
                int companyId = companyService.getIdByCompanyName(selectedCompany.getName());
                System.out.println("CompanyId : " + companyId);


                int teacherId = teacherService.getIdByTeacherName(selectedTeacherName);
                System.out.println("TeacherId: " + teacherId);
                
                Teacher teacher = teacherService.getTeacherById(teacherId);
                System.out.println("Teacher Code: " + teacher.getCode());

                Tour tour = new Tour(
                        tourCode, 
                        tourName, 
                        tourDes, 
                        tourDate, 
                        availables, 
                        companyId, 
                        teacherId, 
                        presentator);

                tourServices.addTour(tour);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                clearAllFields();
                
                /*
                ManageToursOfTeacher manageToursOfTeacher = new ManageToursOfTeacher(teacher);
            if (manageToursOfTeacher != null) {
                manageToursOfTeacher.setLocationRelativeTo(null);
                manageToursOfTeacher.setVisible(true);
                manageToursOfTeacher.setImagePath(teacher.getImagePath());
                manageToursOfTeacher.getTeacherIdLabel().setText("Mã doanh nghiệp: " + teacher.getCode());
                manageToursOfTeacher.getTeacherNameLabel().setText("Tên giáo viên: " + teacher.getLastName() + " " + teacher.getFirstName());
                manageToursOfTeacher.getTeacherPhoneNumberLabel().setText("Số điện thoại: " + teacher.getPhoneNumber());
                manageToursOfTeacher.getTeacherEmailLable().setText("Email: " + teacher.getEmail());
                manageToursOfTeacher.getTeacherAdressLable().setText("Địa chỉ: " + teacher.getAddress());
                manageToursOfTeacher.setTeacherID(teacher.getId());
                manageToursOfTeacher.initializeTable();
                dispose();
            }
                
                */
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void tourTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tourTableMouseClicked
        try {
            int index = tourTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn chuyến tham quan", "Thông báo");
                return;
            }
            
            String code = (String) tourTable.getValueAt(index, 0);
            String name = (String) tourTable.getValueAt(index, 1);
            String date = (String) tourTable.getValueAt(index, 2);
            String description = (String) tourTable.getValueAt(index, 3);
            String presentors = (String) tourTable.getValueAt(index, 5);
            
            
            Object availablesObject = tourTable.getValueAt(index, 4);
            int availables = 0;
            if (availablesObject instanceof Integer) {
                Integer availablesValue = (Integer) availablesObject;
                String availablesText = String.valueOf(availablesValue);

                // Tiếp tục xử lý
                availables = Integer.parseInt(availablesText);
            } else if (availablesObject instanceof String) {
                String availablesText = (String) availablesObject;

                // Tiếp tục xử lý
                availables = Integer.parseInt(availablesText);
            } else {
                // Xử lý theo trường hợp không xác định, tùy thuộc vào logic ứng dụng của bạn
                System.out.println("Giá trị không phải kiểu Integer hoặc String");
            }
            int tourId = tourServices.getIdByTourCode(code);
            
            int companyId = tourServices.getCompanyIdByTourId(tourId);
            
            int teacherId = tourServices.getTeacherIdByTourId(tourId);
            
            Teacher teacher = teacherService.getTeacherById(teacherId);
            Company company = companyService.getCompanyById(companyId);
            
            teacherInput.setSelectedItem(teacher.getLastName() + " " + teacher.getFirstName());
            companyInput.setSelectedItem(company.getName());
            codeInput.setText(code);
            nameInput.setText(name);
            descriptionInput.setText(description);
            startDateInput.setText(date);
            presentatorInput.setText(presentors);
            availablesInput.setText(String.valueOf(availables));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tourTableMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearAllFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = tourTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn chuyến tham quan", "Thông báo");
                return;
            }
            
            String code = (String) tourTable.getValueAt(index, 0);
            
            int tourId = tourServices.getIdByTourCode(code);
            
            Tour tour = tourServices.getTourById(tourId);
            
            String tourName = this.nameInput.getText().trim();
            String tourCode = this.codeInput.getText().trim();
            String tourDes = this.descriptionInput.getText().trim();
            String tourDate = this.startDateInput.getText().trim();
            String presentator = this.presentatorInput.getText().trim();
            
            if(tourDate.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Ngày tham quan không được trống", "Thông báo");
                return;
            }
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inputDate = LocalDate.parse(tourDate, formatter);
            LocalDate currentDate = LocalDate.now();
            
            String availablesText = this.availablesInput.getText().trim();
            if (availablesText.isEmpty()) {
                MessageDialog.showInfoDialog(this, "Số lượng tham quan không được trống", "Thông báo");
                return;
            }

            int availables = Integer.parseInt(availablesText);
            
            if(tourCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã chuyến tham quan không được trống", "Thông báo");
                return;
            }
            if(tourName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên chuyến tham quan không được trống", "Thông báo");
                return;
            }
            if(tourDes.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mô tả chuyến tham quan không được trống", "Thông báo");
                return;
            }
            
            if (currentDate.compareTo(inputDate) >= 0) {
                MessageDialog.showInfoDialog(this, "Ngày khởi hành của chuyến đi phải lớn hơn ngày hiện tại", "Thông báo");
                return;
            }
            if(presentator.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Người đại diện không được trống", "Thông báo");
                return;
            }
            if(availables < 10){
                MessageDialog.showInfoDialog(this, "Số lượng tham quan không được dưới 10 người", "Thông báo");
                return;
            }
            if(tourServices.isExistedTourCode(tourCode) && !tourCode.equals(code)){
                MessageDialog.showInfoDialog(this, "Mã chuyến tham quan không đã tồn tại", "Thông báo");
                return;
            }
            
            String selectedCompanyName = (String) companyInput.getSelectedItem();
            String selectedTeacherName = (String) teacherInput.getSelectedItem();

            List<Company> company_data = companyService.getAllCompanies();

            Company selectedCompany = null;
            for(Company company : company_data){
                if(company.getName().equalsIgnoreCase(selectedCompanyName)){
                    selectedCompany = company;
                    break;
                }
            }

            int companyId = companyService.getIdByCompanyName(selectedCompany.getName());
            System.out.println("CompanyId : " + companyId);

            int teacherId = teacherService.getIdByTeacherName(selectedTeacherName);
            System.out.println("TeacherId: " + teacherId);
            
            tour.setCode(tourCode);
            tour.setName(tourName);
            tour.setDescription(tourDes);
            tour.setPresentator(presentator);
            tour.setStartDate(tourDate);
            tour.setAvailables(availables);
            tour.setCompanyId(companyId);
            tour.setTeacherId(teacherId);
            
            tourServices.updateTour(tour, tourId);
            loadTableData();
            MessageDialog.showInfoDialog(this, "Cập nhật sinh viên thành công", "Thông báo");
            clearAllFields();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = tourTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn chuyến tham quan", "Thông báo");
                return;
            }
            
            String code = (String) tourTable.getValueAt(index, 0);
            
            int tourId = tourServices.getIdByTourCode(code);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa chuyến tham quan này không?", "Xác nhận xóa");
            if(confirm == 0){
                tourServices.deleteTourById(tourId);
                loadTableData();
                MessageDialog.showInfoDialog(this, "Xóa sinh chuyến tham quan thành công", "Thông báo");
                clearAllFields();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void viewStudentListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStudentListButtonActionPerformed
        try {
            int index = tourTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui chọn chuyến tham quan doanh nghiệp trước để xem danh sách sinh viên tham gia", "Thông báo");
                return;
            }
            String code = (String)tourTable.getValueAt(index, 0);
            
            int tourId = tourServices.getIdByTourCode(code);
            
            Tour selectedTour = tourServices.getTourById(tourId);
            
            ManageTourStudent manageTourStudent = new ManageTourStudent(selectedTour);
            manageTourStudent.setVisible(true);
            manageTourStudent.setLocationRelativeTo(null);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_viewStudentListButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageTour().setVisible(true);
        });
    }
    
    private TourService tourServices;
    private TeacherService teacherService;
    private CompanyService companyService;
    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField availablesInput;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JTextField codeInput;
    private javax.swing.JComboBox<Object> companyInput;
    private javax.swing.JTextField descriptionInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameInput;
    private javax.swing.JTextField presentatorInput;
    private javax.swing.JTextField startDateInput;
    private javax.swing.JComboBox<Object> teacherInput;
    private javax.swing.JTable tourTable;
    private javax.swing.JButton viewStudentListButton;
    // End of variables declaration//GEN-END:variables
}
