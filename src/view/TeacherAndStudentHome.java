package view;

import exception.MessageDialog;
import exception.TransmittedDataShowData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.*;
import services.*;

public class TeacherAndStudentHome extends javax.swing.JFrame {
    
    private Student loggedInStudent;
    private Teacher loggedInTeacher;
    private String reated = "comingTours";
    private TourService tourService;
    private CompanyService companyService;
    private TeacherService teacherService;
    private StudentService studentService;
    private StudentTourService studentTourService;
    
    public TeacherAndStudentHome() {
        initComponents();
        tourService = new TourService();
        companyService = new CompanyService();
        teacherService = new TeacherService();
        studentTourService = new StudentTourService();
        initializeTableOfTours();
        setLocationRelativeTo(null);
    }
    
    public TeacherAndStudentHome(Object object){
        initComponents();
        tourService = new TourService();
        companyService = new CompanyService();
        teacherService = new TeacherService();
        studentService = new StudentService();
        studentTourService = new StudentTourService();
        if(object instanceof Student){
            this.loggedInStudent = (Student) object;
            String title = loggedInStudent.getLastName() + " " + loggedInStudent.getFirstName();
            if(title.contains("SV chưa nhập")){
                welcomeLabel.setText("Xin chào");
            }else{
                welcomeLabel.setText("Xin chào: " + title);
            }
        }else if(object instanceof Teacher){
            this.loggedInTeacher = (Teacher) object;
            welcomeLabel.setText("Xin chào: " + loggedInTeacher.getLastName() + " " + loggedInTeacher.getFirstName());
        }else{
            throw new IllegalArgumentException("Không hỗ trợ loại đối tượng này.");
        }
        if(loggedInStudent == null && loggedInTeacher == null){
            MessageDialog.showErrorDialog(this, "Phải đăng nhập với tài khoản sinh viên để sử dụng GUI này ", "Lỗi");
            return;
        }
        
        ratedTour.setVisible(false);
        initializeTableOfTours();
        evaluateBtn.setVisible(false);
        showStudentsOfTour.setVisible(false);
        if(loggedInTeacher != null){
            evaluateBtn.setVisible(true);
            addTour.setVisible(false);
            showStudentsOfTour.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        updateProfile = new javax.swing.JButton();
        showTourInDay = new javax.swing.JButton();
        showUpcomingTours = new javax.swing.JButton();
        registeredTourBtn = new javax.swing.JButton();
        evaluateBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        menu1 = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        searchBtn = new javax.swing.JToggleButton();
        showStudentsOfTour = new javax.swing.JButton();
        ratedTour = new javax.swing.JButton();
        addTour = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        futureTourTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        welcomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLabel.setText("XIN CHÀO");

        updateProfile.setBackground(new java.awt.Color(0, 102, 102));
        updateProfile.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        updateProfile.setForeground(new java.awt.Color(255, 255, 255));
        updateProfile.setText("Tài khoản cá nhân");
        updateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfileActionPerformed(evt);
            }
        });

        showTourInDay.setBackground(new java.awt.Color(0, 102, 102));
        showTourInDay.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        showTourInDay.setForeground(new java.awt.Color(255, 255, 255));
        showTourInDay.setText("Chuyến tham quan hôm nay của bạn");
        showTourInDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTourInDayActionPerformed(evt);
            }
        });

        showUpcomingTours.setBackground(new java.awt.Color(0, 102, 102));
        showUpcomingTours.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        showUpcomingTours.setForeground(new java.awt.Color(255, 255, 255));
        showUpcomingTours.setText("Các chuyến tham quan sắp diễn ra");
        showUpcomingTours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUpcomingToursActionPerformed(evt);
            }
        });

        registeredTourBtn.setBackground(new java.awt.Color(0, 102, 102));
        registeredTourBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registeredTourBtn.setForeground(new java.awt.Color(255, 255, 255));
        registeredTourBtn.setText("Các chuyến tham quan đã đăng kí");
        registeredTourBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registeredTourBtnActionPerformed(evt);
            }
        });

        evaluateBtn.setBackground(new java.awt.Color(0, 102, 102));
        evaluateBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        evaluateBtn.setForeground(new java.awt.Color(255, 255, 255));
        evaluateBtn.setText("Đánh giá sinh viên của chuyến tham quan");
        evaluateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluateBtnActionPerformed(evt);
            }
        });

        logOutBtn.setBackground(new java.awt.Color(204, 0, 0));
        logOutBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(registeredTourBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showTourInDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showUpcomingTours, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(evaluateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(welcomeLabel)
                .addGap(42, 42, 42)
                .addComponent(registeredTourBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(updateProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(showTourInDay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(showUpcomingTours, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(evaluateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        menu1.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        menu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu1.setText("CÁC CHUYẾN THAM QUAN DOANH NGHIỆP SẮP DIỄN RA");

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        searchBtn.setBackground(new java.awt.Color(0, 153, 204));
        searchBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Tìm kiếm");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        showStudentsOfTour.setBackground(new java.awt.Color(0, 102, 102));
        showStudentsOfTour.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        showStudentsOfTour.setForeground(new java.awt.Color(255, 255, 255));
        showStudentsOfTour.setText("Danh sách sinh viên tham gia tham quan");

        ratedTour.setBackground(new java.awt.Color(0, 102, 102));
        ratedTour.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ratedTour.setForeground(new java.awt.Color(255, 255, 255));
        ratedTour.setText("Các chuyến tham quan đã đánh giá");

        addTour.setBackground(new java.awt.Color(0, 102, 102));
        addTour.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addTour.setForeground(new java.awt.Color(255, 255, 255));
        addTour.setText("Đăng ký tham gia chuyến tham quan");
        addTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTourActionPerformed(evt);
            }
        });

        futureTourTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(futureTourTable);

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
                            .addComponent(menu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1491, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(377, 377, 377))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(showStudentsOfTour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ratedTour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addTour)
                                .addGap(9, 9, 9))
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(menu1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchInput)
                    .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratedTour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showStudentsOfTour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        int key = MessageDialog.showConfirmDialog(this, "Bạn có chắc muốn đăng xuất khỏi hệ thống?", "Xác nhận");
        if (key == 0) {
            dispose();
            Login loginScreen = new Login();
            loginScreen.setLocationRelativeTo(null);
            loginScreen.setVisible(true);
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void registeredTourBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registeredTourBtnActionPerformed
        try {
            dispose();
            ShowData scData = null;
            if(loggedInTeacher != null){
                TransmittedDataShowData data = new TransmittedDataShowData("toursOfTeachers", "teacherAndStudentHome", loggedInTeacher.getId(), false);
                scData = new ShowData(data);
            }else if(loggedInStudent != null){
                TransmittedDataShowData data = new TransmittedDataShowData("toursOfStudents", "teacherAndStudentHome", loggedInStudent.getId(), true);
                scData = new ShowData(data);
            }
            scData.setLocationRelativeTo(null);
            scData.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_registeredTourBtnActionPerformed

    private void updateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProfileActionPerformed
        try {
            dispose();
            if(loggedInStudent != null){
                Student student = studentService.getStudentByAccountId(loggedInStudent.getId());
                StudentProfile studentProfile = new StudentProfile(student);
                studentProfile.setLocationRelativeTo(null);
                studentProfile.setVisible(true);
            }else if(loggedInTeacher != null){
                Teacher teacher = teacherService.getTeacherByAccountId(loggedInTeacher.getId());
                TeacherProfile teacherProfile = new TeacherProfile(teacher);
                teacherProfile.setLocationRelativeTo(null);
                teacherProfile.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateProfileActionPerformed

    private void showTourInDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTourInDayActionPerformed
        try {
            menu1.setText("CHUYẾN THAM QUAN HÔM NAY CỦA BẠN");
            addTour.setVisible(false);
            searchInput.setVisible(false);
            searchBtn.setVisible(false);
            tableModel = new DefaultTableModel();
            tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Mô tả",
                "Số lượng", "Ngày diễn ra", "Người đại diện công ty", "Công ty", "Giáo viên"});
            futureTourTable.setModel(tableModel);
            tableModel.setRowCount(0);
            if(loggedInStudent != null){
                List<Tour> tour_data = tourService.getToursByStudentId(loggedInStudent.getId());
                List<Company> company_data = companyService.getAllCompanies();
                List<Teacher> teacher_data = teacherService.getAllTeachers();
                
                if(tour_data != null){
                    for(Tour tour : tour_data){
                        String dateString = tour.getStartDate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        try {
                            LocalDate inputDate = LocalDate.parse(dateString,formatter);
                            LocalDate currentDate = LocalDate.now();
                            if(currentDate.compareTo(inputDate) == 0){
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
                                    tour.getStartDate(),
                                    tour.getPresentator(), 
                                    companyName, 
                                    teacherName
                                });
                            }
                        } catch (Exception e) {
                            MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                            e.printStackTrace();
                        }
                    }
                }
            }else if(loggedInTeacher != null){
                List<Tour> tour_data = tourService.getToursByTeacherId(loggedInTeacher.getId());
                List<Company> company_data = companyService.getAllCompanies();
                List<Teacher> teacher_data = teacherService.getAllTeachers();
                
                if(tour_data != null){
                    for(Tour tour : tour_data){
                        String dateString = tour.getStartDate();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        try {
                            LocalDate inputDate = LocalDate.parse(dateString,formatter);
                            LocalDate currentDate = LocalDate.now();
                            if(currentDate.compareTo(inputDate) == 0){
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
                                    tour.getStartDate(),
                                    tour.getPresentator(), 
                                    companyName, 
                                    teacherName
                                });
                            }
                        } catch (Exception e) {
                            MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                            e.printStackTrace();
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_showTourInDayActionPerformed

    private void showUpcomingToursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUpcomingToursActionPerformed
        menu1.setText("CÁC CHUYẾN THAM QUAN DOANH NGHIỆP SĂP DIỄN RA");
        addTour.setVisible(false);
        searchInput.setVisible(true);
        searchBtn.setVisible(true);
        initializeTableOfTours();
        reated = "comingTours";
    }//GEN-LAST:event_showUpcomingToursActionPerformed

    private void addTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTourActionPerformed
        
        try {
            if(reated.equalsIgnoreCase("tookPlaceTours")){
                
            }else{
                int index = futureTourTable.getSelectedRow();
                if (index == -1) {
                    MessageDialog.showInfoDialog(this, "Vui chọn chuyến tham quan mà bạn muốn thêm", "Thông báo");
                    return;
                }
                String code = (String) futureTourTable.getValueAt(index, 0);
                int tourId = tourService.getIdByTourCode(code);
                Tour tour = tourService.getTourById(tourId);
                
                if(loggedInStudent != null){
                    List<StudentTour> studentTours_data = studentTourService.getAllStudentToursByStudentId(loggedInStudent.getId());
                    List<Tour> tours = tourService.getToursByStudentId(loggedInStudent.getId());
                    if(studentTours_data != null && tours != null){
                        for(StudentTour studentTour : studentTours_data){
                            if(studentTour.getStudentId() == loggedInStudent.getId()){
                                MessageDialog.showInfoDialog(futureTourTable, "Bạn đã đăng ký chuyến tham quan này rồi", "Thông báo");
                                return;
                            }
                        }
                        
                        for(Tour item : tours){
                            if (item.getStartDate().compareTo(tour.getStartDate()) == 0) {
                                MessageDialog.showInfoDialog(futureTourTable, "Bạn đã có một chuyến tham quan vào ngày " + item.getStartDate() + " rồi.", "Thông báo");
                                return;
                            }
                            if (item.getId() == tour.getId() && item.getAvailables() == tour.getStudentTours().size()) {
                                MessageDialog.showInfoDialog(futureTourTable, "Hiện tại số lượng người tham quan đã đầy, mong bạn tham gia chuyến tham quan khác", "Thông báo");
                                return;
                            }
                        }
                    }
                    
                    StudentTour studentTour = new StudentTour(loggedInStudent.getId(), tourId, 0);
                    studentTourService.addStudentTour(studentTour);
                    MessageDialog.showInfoDialog(futureTourTable, "Đăng ký tham quan thành công", "Thông báo");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addTourActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        searchByKey();
    }//GEN-LAST:event_searchBtnActionPerformed

    private void evaluateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluateBtnActionPerformed
        menu1.setText("DANH SÁCH CÁC CHUYẾN THAM QUAN CẦN ĐƯỢC ĐÁNH GIÁ");
        addTour.setText("Các chuyến tham quan chưa đánh giá");
        addTour.setVisible(true);
        ratedTour.setVisible(true);
        reated = "tookPlaceTours";
    }//GEN-LAST:event_evaluateBtnActionPerformed

    private void searchByKey(){
        try {
            String keyword = searchInput.getText().trim();
            int count = 0;
            if(keyword.trim().equalsIgnoreCase("")){
                if(reated.equalsIgnoreCase("comingTours")){
                    initializeTableOfTours();
                }else if(reated.equalsIgnoreCase("tookPlaceTours")){
                    loadTableDataOfTours();
                }
            }
            
            List<Tour> tour_data = tourService.getAllTours();
            List<Company> company_data = companyService.getAllCompanies();
            List<Teacher> teacher_data = teacherService.getAllTeachers();
            tableModel.setRowCount(0);
            if(tour_data != null){
                for(Tour tour : tour_data){
                    try {
                        String companyName = "";
                        String teacherName = "";
                        for(Company comp : company_data){
                            if(comp.getId() == tour.getId()){
                                companyName = comp.getName();
                            }
                        }
                        for(Teacher tea : teacher_data){
                            if (tea.getId() == tour.getTeacherId()) {
                                teacherName = tea.getLastName() + " " + tea.getFirstName();
                            }
                        }
                        if (keyword.equalsIgnoreCase(tour.getCode()) || keyword.equalsIgnoreCase(tour.getName())) {
                            tableModel.addRow(new Object[]{tour.getCode(), tour.getName(), tour.getDescription(),
                                tour.getAvailables(),
                                tour.getPresentator(), companyName, teacherName, tour.getStartDate()});
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherAndStudentHome().setVisible(true);
            }
        });
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
                        if(currentDate.compareTo(inputDate) < 0){
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
                                tour.getStartDate(),
                                tour.getPresentator(), 
                                companyName, 
                                teacherName
                            });
                        }
                    } catch (Exception e) {
                        MessageDialog.showInfoDialog(this, "Có lỗi", "Thông báo");
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void initializeTableOfTours() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Mô tả",
            "Số lượng", "Ngày  diễn ra", "Người đại diện công ty", "Công ty", "Giáo viên"});
        futureTourTable.setModel(tableModel);
        loadTableDataOfTours();
    }
    
    
    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTour;
    private javax.swing.JButton evaluateBtn;
    private javax.swing.JTable futureTourTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLabel menu1;
    private javax.swing.JButton ratedTour;
    private javax.swing.JButton registeredTourBtn;
    private javax.swing.JToggleButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JButton showStudentsOfTour;
    private javax.swing.JButton showTourInDay;
    private javax.swing.JButton showUpcomingTours;
    private javax.swing.JButton updateProfile;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
