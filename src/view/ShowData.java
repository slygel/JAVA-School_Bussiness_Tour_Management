package view;

import exception.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.*;

public class ShowData extends javax.swing.JFrame {
    
    TransmittedDataShowData dataOfShowData;
    private TeacherService teacherService;
    private StudentService studentService;
    private StudentTourService studentTourService;
    private ClassroomService classroomService;
    private TourService tourService;
    private CompanyService companyService;

    public ShowData(TransmittedDataShowData data){
        
        teacherService = new TeacherService();
        studentService = new StudentService();
        studentTourService = new StudentTourService();
        classroomService = new ClassroomService();
        companyService = new CompanyService();
        tourService = new TourService();
        try {
            this.dataOfShowData = data;
            initComponents();
            setLocationRelativeTo(null);
            checkAndInitializeTable();
            if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfTeachers") || dataOfShowData.getTypeData().equalsIgnoreCase("toursOfStudents")) {
                clearDataButton.setText("Hủy chuyến tham quan");
            }
            if (dataOfShowData.getTypeData().equalsIgnoreCase("studentTookPlaceTours")) {
                clearDataButton.setText("Đánh giá");
//                exportPDFFileButton.setText("Sinh viên chưa đánh giá");
//                exportExcelFileButton.setText("Sinh viên đã đánh giá");
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra! Chi tiết: " + ex.getMessage(), "lỗi");
            ex.printStackTrace();
        }
    }
    
    private void checkAndInitializeTable() {
        try {
            if (dataOfShowData.getTypeData() != null && dataOfShowData.getBackToPage() != null) {
                tableModel = new DefaultTableModel();
                if (dataOfShowData.getTypeData().equalsIgnoreCase("teachers")) {
                    titleMainLabel.setText("Danh sách giáo viên đại diện doanh nghiệp");
                    tableModel.setColumnIdentifiers(new String[]{"Mã giáo viên", "Họ tên",
                        "Địa chỉ", "Điện thoại", "Email", "Ngày sinh"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("students")) {
                    titleMainLabel.setText("Danh sách sinh viên được quản lý");
                    tableModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ", "Tên", "Địa chỉ", "SĐT", "Email", "Ngày sinh", "Lớp"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("companys")) {
                    titleMainLabel.setText("Danh sách doanh nghiệp liên kết với nhà trường");
                    tableModel.setColumnIdentifiers(new String[]{"Mã doanh nghiệp", "Doanh nghiệp", "Địa chỉ",
                        "Email", "Điện thoại", "Mô tả"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("tours")) {
                    titleMainLabel.setText("Danh sách các chuyến tham quan được tổ chức");
                    tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến", "Thời gian", "Mô tả",
                        "Số lượng", "Người đại diện", "Công ty", "Giáo viên"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("studentTours")) {
                    titleMainLabel.setText("Danh sách sinh viên của chuyến tham quan");
                    tableModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ", "Tên", "Địa chỉ", "SĐT", "Email", "Ngày sinh","Lớp"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfTeachers")) {
                    Teacher teacher = teacherService.getTeacherById(dataOfShowData.getTeacherId());
                    titleMainLabel.setText("DANH SÁCH CÁC CHUYẾN THAM QUAN CỦA GIÁO VIÊN " + teacher.getLastName().toUpperCase() + " " + teacher.getFirstName().toUpperCase());
                    tableModel.setColumnIdentifiers(new String[]{"Mã chuyến tham quan", "Tên chuyến tham quan", "Ngày tham quan", "Doanh nghiệp chủ quản", "Số lượng sinh viên tham gia"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfStudents")) {
                    Student stu = studentService.getStudentById(dataOfShowData.getStudentId());
                    titleMainLabel.setText("DANH SÁCH CÁC CHUYẾN THAM QUAN CỦA SINH VIÊN " + stu.getLastName().toUpperCase() + " " + stu.getFirstName().toUpperCase());
                    tableModel.setColumnIdentifiers(new String[]{"Mã chuyến tham quan", "Tên chuyến tham quan", "Mô tả", "Ngày bắt đầu", "Số ghế ", "Tên doanh nghiệp", "Tên giáo viên", "Người đại diện"});
                } else if (dataOfShowData.getTypeData().equalsIgnoreCase("studentTookPlaceTours")) {
                    titleMainLabel.setText("Danh sách sinh viên của chuyến tham quan");
                    tableModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ", "Tên", "Địa chỉ", "SĐT", "Email", "Ngày sinh", "Điểm đánh giá"});
                }
                dataTable.setModel(tableModel);
                loadTableData();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(search, "Có lỗi, chi tiết: " + ex.getMessage(), "Lỗi");
        }
    }
    
    private void loadTableData() {
        try {
            if(dataOfShowData.getTypeData() != null && dataOfShowData.getBackToPage() != null){
                tableModel.setRowCount(0);
            }
            if(dataOfShowData.getTypeData().equalsIgnoreCase("students")){
                loadStudentsData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("studentTours")){
                loadStudentToursData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("tours")){
                loadToursData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("companys")){
                loadCompanysData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("teachers")){
                loadTeachersData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfTeachers")){
                loadTableToursOfTeacherData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfStudents")){
                loadTableToursOfStudentData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("studentTookPlaceTours")){
                loadStudentsAwaitingFeedback("=");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ShowData() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleMainLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        searchInput = new javax.swing.JTextField();
        search = new javax.swing.JLabel();
        searchButton = new javax.swing.JToggleButton();
        clearDataButton = new javax.swing.JToggleButton();
        exportPDFFileButton = new javax.swing.JToggleButton();
        exportExcelFileButton = new javax.swing.JToggleButton();
        backButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleMainLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        titleMainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleMainLabel.setText("Danh sách thông tin");
        titleMainLabel.setToolTipText("");

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(dataTable);

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        search.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        search.setText("Tìm kiếm theo tên:");

        searchButton.setBackground(new java.awt.Color(0, 102, 153));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Tìm kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        clearDataButton.setBackground(new java.awt.Color(102, 153, 0));
        clearDataButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        clearDataButton.setForeground(new java.awt.Color(255, 255, 255));
        clearDataButton.setText("Nhập lại");
        clearDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDataButtonActionPerformed(evt);
            }
        });

        exportPDFFileButton.setBackground(new java.awt.Color(0, 102, 102));
        exportPDFFileButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exportPDFFileButton.setForeground(new java.awt.Color(255, 255, 255));
        exportPDFFileButton.setText("Xuất danh sách PDF");
        exportPDFFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPDFFileButtonActionPerformed(evt);
            }
        });

        exportExcelFileButton.setBackground(new java.awt.Color(0, 102, 102));
        exportExcelFileButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exportExcelFileButton.setForeground(new java.awt.Color(255, 255, 255));
        exportExcelFileButton.setText("Xuất danh sách Excel");
        exportExcelFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelFileButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(153, 0, 0));
        backButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Trở lại trang trước");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exportPDFFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(exportExcelFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(clearDataButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(searchInput))
                .addGap(85, 85, 85))
            .addComponent(titleMainLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleMainLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(clearDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportPDFFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(exportExcelFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDataButtonActionPerformed
        try {
            if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfStudents")){
                int index = dataTable.getSelectedRow();
                if (index == -1) {
                    MessageDialog.showInfoDialog(this, "Vui lòng chọn chuyến tham quan mà bạn muốn xóa", "Thông báo");
                    return;
                }
                String tourCode = (String) dataTable.getValueAt(index, 0);
                System.out.println("TourCode: " + tourCode);
                int tourId = tourService.getIdByTourCode(tourCode);
                System.out.println("TourId: " + tourId);
                System.out.println("StudentId: " + dataOfShowData.getStudentId());
                int studentId = dataOfShowData.getStudentId();
                studentTourService.deleteStudentTour(studentId, tourId);
                MessageDialog.showInfoDialog(this, "Xóa chuyến tham quan thành công", "Thông báo");
                loadTableToursOfStudentData();
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfTeachers")){
                int index = dataTable.getSelectedRow();
                if(index == -1){
                    MessageDialog.showInfoDialog(this, "Vui lòng chọn chuyến tham quan mà bạn muốn xóa", "Thông báo");
                    return;
                }
                String tourCode = (String) dataTable.getValueAt(index, 0);
                int tourId = tourService.getIdByTourCode(tourCode);
                int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa chuyến tham quan này không", "Thông báo");
                if(confirm == 0){
                    tourService.updateTeacherIdByTourId(tourId);
                    loadTableToursOfTeacherData();
                }
            }
            else if (dataOfShowData.getTypeData().equalsIgnoreCase("studentTookPlaceTours")) {
                try {
                    int index = dataTable.getSelectedRow();
                    if (index == -1) {
                        MessageDialog.showInfoDialog(this, "Vui lòng chọn sinh viên bạn muốn đánh giá", "Thông báo");
                        return;
                    }
                    String studentCode = (String) dataTable.getValueAt(index, 0);
                    int studentId = studentService.getIdByStudent(studentCode);
                    Student selectStudent = studentService.getStudentById(studentId);
                    System.out.println("Student: " + selectStudent);
                    dispose();

                    Tour selectTour = tourService.getTourById(dataOfShowData.getTourId());
                    System.out.println("Tour: " + selectTour);
                    RateStudentResult screen = new RateStudentResult(selectTour, selectStudent,true);
                    screen.setLocationRelativeTo(null);
                    screen.setVisible(true);
                } catch (Exception ex) {
                    MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage(), "Lỗi");
                    ex.printStackTrace();
                }
            }else{
                searchInput.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_clearDataButtonActionPerformed

    private void exportPDFFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPDFFileButtonActionPerformed
        try {
            String title = "";
            if (dataOfShowData.getTypeData().equalsIgnoreCase("studentTours")) {
                title = "DANH SÁCH SINH VIÊN CỦA CHUYẾN THAM QUAN";
            }
            dataTable.setModel(tableModel);
            loadTableData();
            PDFExporter.exportTableToPDF(dataTable, title);
        } catch (Exception e) {
            MessageDialog.showErrorDialog(search, "Có lỗi, chi tiết: " + e.getMessage(), "Lỗi");
        }
    }//GEN-LAST:event_exportPDFFileButtonActionPerformed

    private void exportExcelFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelFileButtonActionPerformed
        try {
            if (dataOfShowData.getTypeData().equalsIgnoreCase("toursOfTeachers")) {
                Tour tour = tourService.getTourByTeacherId(dataOfShowData.getTeacherId());
                Teacher teacher = teacherService.getTeacherById(dataOfShowData.getTeacherId());
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
                        String tourTitle = tour.getName() + " (Mã: " + teacher.getCode() + ", Tên giáo viên: " + teacher.getLastName() +" "+teacher.getFirstName() + ") ";
                        Sheet sheet = workbook.createSheet("Danh sách các chuyến tham quan mà giáo viên tham gia " + tourTitle);

                        // Create header row
                        Row headerRow = sheet.createRow(0);

                        CellStyle headerStyle = workbook.createCellStyle();
                        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        headerStyle.setAlignment(HorizontalAlignment.CENTER);

                        Font headerFont = workbook.createFont();
                        headerFont.setColor(IndexedColors.WHITE.getIndex());
                        headerFont.setBold(true);
                        headerStyle.setFont(headerFont);

                        String[] headers = {"Mã chuyến tham quan", "Tên chuyến tham quan", "Ngày tham quan", "Doanh nghiệp chủ quản", "Số lượng sinh viên tham gia"};

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
                        List<Tour> tours = tourService.getToursByTeacherId(dataOfShowData.getTeacherId());
                        if (tours != null) {
                            int rowNum = 1;
                            for (Tour teacherTour : tours) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfTourTeacher(teacherTour, i));
                                    cell.setCellStyle(cellStyle);
                                }
                            }
                        }

                        try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                            workbook.write(fileOut);
                        } catch (Exception exs) {
                            throw exs;
                        }

                        workbook.close();

                        MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                    }
                }
            } else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfStudents")){
                Tour tour = tourService.getTourByStudentId(dataOfShowData.getStudentId());
                Student student = studentService.getStudentById(dataOfShowData.getStudentId());
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
                        String tourTitle = tour.getName() + " (Mã: " + student.getCode() + ", Tên sinh viên: " + student.getLastName() +" "+student.getFirstName() + ") ";
                        Sheet sheet = workbook.createSheet("Danh sách các chuyến tham quan mà sinh viên tham gia " + tourTitle);

                        // Create header row
                        Row headerRow = sheet.createRow(0);

                        CellStyle headerStyle = workbook.createCellStyle();
                        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        headerStyle.setAlignment(HorizontalAlignment.CENTER);

                        Font headerFont = workbook.createFont();
                        headerFont.setColor(IndexedColors.WHITE.getIndex());
                        headerFont.setBold(true);
                        headerStyle.setFont(headerFont);

                        String[] headers = {"Mã chuyến tham quan", 
                            "Tên chuyến tham quan", 
                            "Mô tả", 
                            "Ngày bắt đầu", 
                            "Số ghế ", 
                            "Tên doanh nghiệp", 
                            "Tên giáo viên", 
                            "Người đại diện"};

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
                        List<Tour> tours = tourService.getToursByStudentId(dataOfShowData.getStudentId());
                        if (tours != null) {
                            int rowNum = 1;
                            for (Tour studentTour : tours) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfTourStudent(studentTour, i));
                                    cell.setCellStyle(cellStyle);
                                }
                            }
                        }

                        try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                            workbook.write(fileOut);
                        } catch (Exception exs) {
                            throw exs;
                        }

                        workbook.close();

                        MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                    }
                }
            }else if(dataOfShowData.getTypeData().equalsIgnoreCase("students")){
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
                        Sheet sheet = workbook.createSheet("Danh sách sinh viên được quản lý ");

                        // Create header row
                        Row headerRow = sheet.createRow(0);

                        CellStyle headerStyle = workbook.createCellStyle();
                        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        headerStyle.setAlignment(HorizontalAlignment.CENTER);

                        Font headerFont = workbook.createFont();
                        headerFont.setColor(IndexedColors.WHITE.getIndex());
                        headerFont.setBold(true);
                        headerStyle.setFont(headerFont);

                        String[] headers = {"Mã sinh viên", 
                            "Họ", 
                            "Tên", 
                            "Địa chỉ", 
                            "SĐT", 
                            "Email", 
                            "Ngày sinh", 
                            "Lớp"};

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
                        List<Student> students = studentService.getAllStudents();
                        if (students != null) {
                            int rowNum = 1;
                            for (Student studentSelect : students) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfStudents(studentSelect, i));
                                    cell.setCellStyle(cellStyle);
                                }
                            }
                        }

                        try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                            workbook.write(fileOut);
                        } catch (Exception exs) {
                            throw exs;
                        }

                        workbook.close();

                        MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("companys")){
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
                        Sheet sheet = workbook.createSheet("Danh sách doanh nghiệp liên kết với nhà trường ");

                        // Create header row
                        Row headerRow = sheet.createRow(0);

                        CellStyle headerStyle = workbook.createCellStyle();
                        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        headerStyle.setAlignment(HorizontalAlignment.CENTER);

                        Font headerFont = workbook.createFont();
                        headerFont.setColor(IndexedColors.WHITE.getIndex());
                        headerFont.setBold(true);
                        headerStyle.setFont(headerFont);

                        String[] headers = {
                            "Mã doanh nghiệp", 
                            "Tên doanh nghiệp", 
                            "Địa chỉ", 
                            "Email", 
                            "SĐT", 
                            "Mô tả"
                        };

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
                        List<Company> companys = companyService.getAllCompanies();
                        if (companys != null) {
                            int rowNum = 1;
                            for (Company companySelect : companys) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfCompanys(companySelect, i));
                                    cell.setCellStyle(cellStyle);
                                }
                            }
                        }

                        try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                            workbook.write(fileOut);
                        } catch (Exception exs) {
                            throw exs;
                        }

                        workbook.close();

                        MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("teachers")){
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
                        Sheet sheet = workbook.createSheet("Danh sách giáo viên đại diện nhà trường ");

                        // Create header row
                        Row headerRow = sheet.createRow(0);

                        CellStyle headerStyle = workbook.createCellStyle();
                        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        headerStyle.setAlignment(HorizontalAlignment.CENTER);

                        Font headerFont = workbook.createFont();
                        headerFont.setColor(IndexedColors.WHITE.getIndex());
                        headerFont.setBold(true);
                        headerStyle.setFont(headerFont);

                        String[] headers = {
                            "Mã giáo viên", 
                            "Họ tên", 
                            "Địa chỉ", 
                            "SĐT", 
                            "Email", 
                            "Ngày sinh"
                        };

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
                        List<Teacher> teachers = teacherService.getAllTeachers();
                        if (teachers != null) {
                            int rowNum = 1;
                            for (Teacher teacherSelect : teachers) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfTeachers(teacherSelect, i));
                                    cell.setCellStyle(cellStyle);
                                }
                            }
                        }

                        try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                            workbook.write(fileOut);
                        } catch (Exception exs) {
                            throw exs;
                        }

                        workbook.close();

                        MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("tours")){
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
                        Sheet sheet = workbook.createSheet("Danh sách các chuyến tham quan được tổ chức");

                        // Create header row
                        Row headerRow = sheet.createRow(0);

                        CellStyle headerStyle = workbook.createCellStyle();
                        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        headerStyle.setAlignment(HorizontalAlignment.CENTER);

                        Font headerFont = workbook.createFont();
                        headerFont.setColor(IndexedColors.WHITE.getIndex());
                        headerFont.setBold(true);
                        headerStyle.setFont(headerFont);

                        String[] headers = {
                            "Mã chuyến", 
                            "Tên chuyến", 
                            "Thời gian", 
                            "Mô tả",
                            "Số lượng", 
                            "Người đại diện", 
                            "Công ty", 
                            "Giáo viên"
                        };

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
                        List<Tour> tours = tourService.getAllTours();
                        if (tours != null) {
                            int rowNum = 1;
                            for (Tour tourSelect : tours) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfTours(tourSelect, i));
                                    cell.setCellStyle(cellStyle);
                                }
                            }
                        }

                        try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                            workbook.write(fileOut);
                        } catch (Exception exs) {
                            throw exs;
                        }

                        workbook.close();

                        MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                    }
                }
            }
            
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("studentTours")){
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
                        Sheet sheet = workbook.createSheet("Danh sách sinh viên tham gia chuyến đi");

                        // Create header row
                        Row headerRow = sheet.createRow(0);

                        CellStyle headerStyle = workbook.createCellStyle();
                        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        headerStyle.setAlignment(HorizontalAlignment.CENTER);

                        Font headerFont = workbook.createFont();
                        headerFont.setColor(IndexedColors.WHITE.getIndex());
                        headerFont.setBold(true);
                        headerStyle.setFont(headerFont);

                        String[] headers = {
                            "Mã sinh viên", 
                            "Họ", 
                            "Tên", 
                            "Địa chỉ",
                            "SĐT", 
                            "Email", 
                            "Ngày sinh", 
                            "Lớp"
                        };
                        
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
                        List<Student> students_data = studentService.getStudentsByTourId(dataOfShowData.getTourId());
                        if (students_data != null) {
                            int rowNum = 1;
                            for (Student studentSelect : students_data) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfStudentTours(studentSelect, i));
                                    cell.setCellStyle(cellStyle);
                                }
                            }
                        }

                        try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                            workbook.write(fileOut);
                        } catch (Exception exs) {
                            throw exs;
                        }

                        workbook.close();

                        MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("studentTookPlaceTours")){
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
                        Sheet sheet = workbook.createSheet("Danh sách sinh viên của chuyến tham quan");

                        // Create header row
                        Row headerRow = sheet.createRow(0);

                        CellStyle headerStyle = workbook.createCellStyle();
                        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        headerStyle.setAlignment(HorizontalAlignment.CENTER);

                        Font headerFont = workbook.createFont();
                        headerFont.setColor(IndexedColors.WHITE.getIndex());
                        headerFont.setBold(true);
                        headerStyle.setFont(headerFont);

                        String[] headers = {
                            "Mã sinh viên", 
                            "Họ", 
                            "Tên", 
                            "Địa chỉ",
                            "SĐT", 
                            "Email", 
                            "Ngày sinh", 
                            "Điểm đánh giá"
                        };
                        
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
                        
                        List<Student> students = studentService.getStudentsByTourId(dataOfShowData.getTourId());
                        if (students != null) {
                            int rowNum = 1;
                            for (Student studentSelect : students) {
                                Row row = sheet.createRow(rowNum++);
                                for (int i = 0; i < headers.length; i++) {
                                    Cell cell = row.createCell(i);
                                    cell.setCellValue(getCellValueOfStudentTookPlaceTours(studentSelect, i));
                                    cell.setCellStyle(cellStyle);
                                }
                            }
                        }

                        try ( FileOutputStream fileOut = new FileOutputStream(filePath)) {
                            workbook.write(fileOut);
                        } catch (Exception exs) {
                            throw exs;
                        }

                        workbook.close();

                        MessageDialog.showInfoDialog(this, "Xuất danh sách thành công! " + "\nNơi lưu: " + filePath, "Thông báo");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_exportExcelFileButtonActionPerformed

    private String getCellValueOfTourTeacher(Tour tour, int columnIndex)throws Exception{
        switch (columnIndex) {
            case 0:
                return tour.getCode();
            case 1:
                return tour.getName();
            case 2:
                return tour.getStartDate();
            case 3:
                return tourService.getCompanyNameById(tour.getCompanyId());
            case 4:
                return String.valueOf(studentTourService.getNumberOfStudents(tour.getId()));
            default:
                return "";
        }
    }
    
    private String getCellValueOfTourStudent(Tour tour , int columnIndex) throws Exception{
        switch (columnIndex) {
            case 0:
                return tour.getCode();
            case 1:
                return tour.getName();
            case 2:
                return tour.getDescription();
            case 3: 
                return tour.getStartDate();
            case 4:
                return String.valueOf(tour.getAvailables());
            case 5:
                return tourService.getCompanyNameById(tour.getCompanyId());
            case 6:
                return tourService.getTeacherNameById(tour.getTeacherId());
            case 7:
                return tour.getPresentator();
            default:
                return "";
        }
    }
    
    private String getCellValueOfStudents(Student student , int columnIndex) throws Exception{
        switch(columnIndex){
            case 0:
                return student.getCode();
            case 1:
                return student.getLastName();
            case 2:
                return student.getFirstName();
            case 3:
                return student.getAddress();
            case 4:
                return student.getPhoneNumber();
            case 5:
                return student.getEmail();
            case 6:
                return student.getBirthDate();
            case 7:
                return studentService.getStudentClassNameById(student.getClassId());
            default:
                return "";
        }
    }
    
    private String getCellValueOfCompanys(Company company , int columnIndex) throws Exception{
        switch(columnIndex){
            case 0:
                return company.getCode();
            case 1:
                return company.getName();
            case 2:
                return company.getAddress();
            case 3:
                return company.getEmail();
            case 4:
                return company.getPhoneNumber();
            case 5:
                return company.getDescription();
            default:
                return "";
        }
    }
    
    private String getCellValueOfTeachers(Teacher teacher , int columnIndex) throws Exception{
        switch(columnIndex){
            case 0: 
                return teacher.getCode();
            case 1:
                return teacher.getLastName() + " " + teacher.getFirstName();
            case 2:
                return teacher.getAddress();
            case 3:
                return teacher.getPhoneNumber();
            case 4:
                return teacher.getEmail();
            case 5:
                return teacher.getBirthDate();
            default:
                return "";
        }
        
    }
    
    private String getCellValueOfTours(Tour tour , int columnIndex) throws Exception{
        switch (columnIndex) {
        case 0:
            return tour.getCode();
        case 1:
            return tour.getName();
        case 2:
            return tour.getStartDate();
        case 3: 
            return tour.getDescription();
        case 4:
            return String.valueOf(tour.getAvailables());
        case 5:
            return tour.getPresentator();
        case 6:
            return tourService.getCompanyNameById(tour.getCompanyId());
        case 7:
            return tourService.getTeacherNameById(tour.getTeacherId());
        default:
            return "";
        }
    }
    
    private String getCellValueOfStudentTours(Student student , int columnIndex) throws Exception{
        
        switch(columnIndex){
            case 0:
                return student.getCode();
            case 1:
                return student.getLastName();
            case 2:
                return student.getFirstName();
            case 3:
                return student.getAddress();
            case 4:
                return student.getPhoneNumber();
            case 5:
                return student.getEmail();
            case 6:
                return student.getBirthDate();
            case 7:
                return studentService.getStudentClassNameById(student.getClassId());
            default:
                return "";
        }
    }
    
    private String getCellValueOfStudentTookPlaceTours(Student student , int columnIndex) throws Exception{
        switch(columnIndex){
        case 0:
            return student.getCode();
        case 1:
            return student.getLastName();
        case 2:
            return student.getFirstName();
        case 3:
            return student.getAddress();
        case 4:
            return student.getPhoneNumber();
        case 5:
            return student.getEmail();
        case 6:
            return student.getBirthDate();
        case 7:
            return String.valueOf(studentTourService.geStudentTourByStudentId(student.getId()).getRate());
        default:
            return "";
        }
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
        if(dataOfShowData.getBackToPage().equalsIgnoreCase("managetoursofteacher")){
            try {
                List<Tour> tours = tourService.getToursByTeacherId(dataOfShowData.getTeacherId());
                Teacher teacher = teacherService.getTeacherById(dataOfShowData.getTeacherId());
                ManageToursOfTeacher manageToursOfTeacher = new ManageToursOfTeacher();
                manageToursOfTeacher.setTours(tours);
                manageToursOfTeacher.setTeacherID(dataOfShowData.getTeacherId());
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
        }else if (dataOfShowData.getBackToPage().equalsIgnoreCase("home")) {
            AdminHome home = new AdminHome();
            home.setLocationRelativeTo(null);
            home.setVisible(true);
        }else if(dataOfShowData.getBackToPage().equalsIgnoreCase("teacherAndStudentHome")){
            try {
                dispose();
                TeacherAndStudentHome teacherAndStudentHome = null;
                if(dataOfShowData.isIsStudent()){
                    Student student = studentService.getStudentById(dataOfShowData.getStudentId());
                    teacherAndStudentHome = new TeacherAndStudentHome(student);
                }else {
                    Teacher teacher = teacherService.getTeacherById(dataOfShowData.getTeacherId());
                    teacherAndStudentHome = new TeacherAndStudentHome(teacher);
                }
                teacherAndStudentHome.setLocationRelativeTo(null);
                teacherAndStudentHome.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            String keyword = searchInput.getText().trim();
            int count = 0;
            if (keyword.trim().equals("")) {
                checkAndInitializeTable();
                return;
            }
            
            if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfTeachers")){
                    List<Tour> tour_data = tourService.getToursByTeacherId(dataOfShowData.getTeacherId());
                    List<Company> company_data = companyService.getAllCompanies();
                    List<Teacher> teacher_data = teacherService.getAllTeachers();
                    tableModel.setRowCount(0);
                    if (tour_data != null) {
                        for (Tour tour : tour_data) {
                            String companyName = "";
                            String teacherName = "";
                            int numberOfStudents = studentTourService.getNumberOfStudents(tour.getId());
                            for (Company comp : company_data) {
                                if (comp.getId() == tour.getCompanyId()) {
                                    companyName = comp.getName();
                                }
                            }
                            for (Teacher tea : teacher_data) {
                                if (tea.getId() == tour.getTeacherId()) {
                                    teacherName = tea.getLastName() + " " + tea.getFirstName();
                                }
                            }
                            if (keyword.equalsIgnoreCase(companyName) || keyword.equalsIgnoreCase(tour.getName()) || keyword.equalsIgnoreCase(tour.getCode())) {
                                tableModel.addRow(new Object[]{
                                tour.getCode(), 
                                tour.getName(), 
                                tour.getStartDate(),
                                companyName,
                                numberOfStudents
                                });
                            } else {
                                count++;
                            }
                        }
                        if (count == tour_data.size()) {
                            MessageDialog.showInfoDialog(dataTable, "Không tìm thấy chuyến tham quan doanh nghiệp bạn cần tìm", "Thông báo");
                            checkAndInitializeTable();
                        }
                    }
                }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("toursOfStudents")){
                List<Tour> tour_data = tourService.getToursByStudentId(dataOfShowData.getStudentId());
                    List<Company> company_data = companyService.getAllCompanies();
                    List<Teacher> teacher_data = teacherService.getAllTeachers();
                    tableModel.setRowCount(0);
                    if (tour_data != null) {
                        for (Tour tour : tour_data) {
                            String companyName = "";
                            String teacherName = "";
                            for (Company comp : company_data) {
                                if (comp.getId() == tour.getCompanyId()) {
                                    companyName = comp.getName();
                                }
                            }
                            for (Teacher tea : teacher_data) {
                                if (tea.getId() == tour.getTeacherId()) {
                                    teacherName = tea.getLastName() + " " + tea.getFirstName();
                                }
                            }
                            if (keyword.equalsIgnoreCase(companyName) || keyword.equalsIgnoreCase(tour.getName()) || keyword.equalsIgnoreCase(tour.getCode())) {
                                tableModel.addRow(new Object[]{
                                tour.getCode(), 
                                tour.getName(), 
                                tour.getDescription(),
                                tour.getStartDate(),
                                tour.getAvailables(),
                                companyName,
                                teacherName,
                                tour.getPresentator()
                                });
                            } else {
                                count++;
                            }
                        }
                        if (count == tour_data.size()) {
                            MessageDialog.showInfoDialog(dataTable, "Không tìm thấy chuyến tham quan doanh nghiệp bạn cần tìm", "Thông báo");
                            checkAndInitializeTable();
                        }
                    }
            }
            else if (dataOfShowData.getTypeData().equalsIgnoreCase("studentTours")) {
                Tour tour = tourService.getTourById(dataOfShowData.getTourId());
                if (tour != null) {
                    List<StudentTour> data_students_tour = studentTourService.getAllStudentToursByTourId(tour.getId());
                    List<Student> data = studentService.getStudentsByTourId(tour.getId());
                            
                    tableModel.setRowCount(0);
                    if (data != null && data_students_tour != null) {
                        for (Student stu : data) {
                            String className = studentService.getStudentClassNameById(stu.getClassId());
                            for (StudentTour item : data_students_tour) {
                                if (stu.getId() == item.getStudentId()) {
                                    if (stu.getFirstName().equalsIgnoreCase(keyword) || stu.getLastName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(stu.getLastName() + stu.getFirstName()) || keyword.equalsIgnoreCase(stu.getCode())) {
                                        tableModel.addRow(new Object[]{
                                            stu.getCode(), 
                                            stu.getLastName(), 
                                            stu.getFirstName(), 
                                            stu.getAddress(), 
                                            stu.getPhoneNumber(), 
                                            stu.getEmail(), 
                                            stu.getBirthDate(),
                                            className
                                        });
                                    } else {
                                        count++;
                                    }
                                }
                            }
                        }
                        if (count == data_students_tour.size()) {
                            MessageDialog.showInfoDialog(dataTable, "Không tìm thấy sinh viên bạn cần tìm", "Thông báo");
                            checkAndInitializeTable();
                        }
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("tours")){
                List<Tour> tour_data = tourService.getAllTours();
                List<Company> company_data = companyService.getAllCompanies();
                List<Teacher> teacher_data = teacherService.getAllTeachers();
                tableModel.setRowCount(0);
                if (tour_data != null) {
                    for (Tour tour : tour_data) {
                        String companyName = "";
                        String teacherName = "";
                        for (Company comp : company_data) {
                            if (comp.getId() == tour.getCompanyId()) {
                                companyName = comp.getName();
                            }
                        }
                        for (Teacher tea : teacher_data) {
                            if (tea.getId() == tour.getTeacherId()) {
                                teacherName = tea.getLastName() + " " + tea.getFirstName();
                            }
                        }
                        if (keyword.equalsIgnoreCase(teacherName) || keyword.equalsIgnoreCase(companyName) || keyword.equalsIgnoreCase(tour.getName()) || keyword.equalsIgnoreCase(tour.getCode())) {
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
                        } else {
                            count++;
                        }
                    }
                    if (count == tour_data.size()) {
                        MessageDialog.showInfoDialog(dataTable, "Không tìm thấy chuyến tham quan doanh nghiệp bạn cần tìm", "Thông báo");
                        checkAndInitializeTable();
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("students")){
                List<Student> data = studentService.getAllStudents();
                tableModel.setRowCount(0);
                if (data != null) {
                    for (Student stu : data) {
                        if (stu.getFirstName().equalsIgnoreCase(keyword) || stu.getLastName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(stu.getLastName() + stu.getFirstName()) || keyword.equalsIgnoreCase(stu.getCode())) {
                            tableModel.addRow(new Object[]{
                                stu.getCode(), 
                                stu.getLastName(), 
                                stu.getFirstName(), 
                                stu.getAddress(), 
                                stu.getPhoneNumber(), 
                                stu.getEmail(), 
                                stu.getBirthDate(),
                                classroomService.getClassNameById(stu.getClassId())
                            });
                        } else {
                            count++;
                        }
                    }
                    if (count == data.size()) {
                        MessageDialog.showInfoDialog(dataTable, "Không tìm thấy sinh viên bạn cần tìm", "Thông báo");
                        checkAndInitializeTable();
                    }
                }
            }
            else if(dataOfShowData.getTypeData().equalsIgnoreCase("companys")){
                List<Company> data = companyService.getAllCompanies();
                tableModel.setRowCount(0);
                if(data != null){
                    for(Company com : data){
                        if (com.getName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(com.getCode())) {
                            tableModel.addRow(new Object[]{
                                com.getCode(), 
                                com.getName(), 
                                com.getAddress(),
                                com.getEmail(), 
                                com.getPhoneNumber(),
                                com.getDescription()});
                        } else {
                            count++;
                        }
                    }
                    if (count == data.size()) {
                        MessageDialog.showInfoDialog(dataTable, "Không tìm thấy doanh nghiệp bạn cần tìm", "Thông báo");
                        checkAndInitializeTable();
                    }
                }
            }
            else if (dataOfShowData.getTypeData().equalsIgnoreCase("teachers")){
                List<Teacher> data = teacherService.getAllTeachers();
                tableModel.setRowCount(0);
                if(data != null){
                    for(Teacher tea : data){
                        if(tea.getFirstName().equalsIgnoreCase(keyword) || tea.getLastName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(tea.getLastName() + tea.getFirstName()) || keyword.equalsIgnoreCase(tea.getCode())){
                            tableModel.addRow(new Object[]{
                                tea.getCode(),
                                tea.getLastName() + " " +tea.getFirstName(),
                                tea.getAddress(),
                                tea.getPhoneNumber(),
                                tea.getEmail(),
                                tea.getBirthDate()
                            });
                        }else{
                            count++;
                        }
                    }
                    if(count == data.size()){
                        MessageDialog.showInfoDialog(dataTable, "Không tìm thấy giáo viên bạn cần tìm", "Thông báo");
                        checkAndInitializeTable();
                    }
                }
            }
            else if (dataOfShowData.getTypeData().equalsIgnoreCase("studentTookPlaceTours")) {
                Tour tour = tourService.getTourById(dataOfShowData.getTourId());
                if (tour != null) {
                    List<StudentTour> data_students_tour = studentTourService.getAllStudentToursByTourId(tour.getId());
                    List<Student> data = studentService.getAllStudents();
                    tableModel.setRowCount(0);
                    if (data != null && data_students_tour != null) {
                        for (Student stu : data) {
                            for (StudentTour item : data_students_tour) {
                                if (stu.getId() == item.getStudentId()) {
                                    if (stu.getFirstName().equalsIgnoreCase(keyword) || stu.getLastName().equalsIgnoreCase(keyword) || keyword.equalsIgnoreCase(stu.getLastName() + stu.getFirstName()) || keyword.equalsIgnoreCase(stu.getCode())) {
                                        tableModel.addRow(new Object[]{
                                            stu.getCode(), 
                                            stu.getLastName(), 
                                            stu.getFirstName(), 
                                            stu.getAddress(), 
                                            stu.getPhoneNumber(), 
                                            stu.getEmail(), 
                                            stu.getBirthDate()
                                        });
                                    } else {
                                        count++;
                                    }
                                }
                            }
                        }
                        if (count == data_students_tour.size()) {
                            MessageDialog.showInfoDialog(dataTable, "Không tìm thấy sinh viên bạn cần tìm", "Thông báo");
                            checkAndInitializeTable();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchButtonActionPerformed
    private DefaultTableModel tableModel;

    private void loadTableToursOfStudentData() throws Exception{
        try {
            List<Tour> data = tourService.getToursByStudentId(dataOfShowData.getStudentId());
            tableModel.setRowCount(0);
            if(data != null){
                for(Tour tour : data){
                    int companyId = tourService.getCompanyIdByTourId(tour.getId());
                    Company company = companyService.getCompanyById(companyId);
                    String teacherName = tourService.getTeacherNameById(tour.getTeacherId());
                    tableModel.addRow(new Object[]{
                        tour.getCode(),
                        tour.getName(),
                        tour.getDescription(),
                        tour.getStartDate(),
                        tour.getAvailables(),
                        company.getName(),
                        teacherName,
                        tour.getPresentator()
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadTableToursOfTeacherData() throws Exception{
        try {
            List<Tour> data = tourService.getToursByTeacherId(dataOfShowData.getTeacherId());
            tableModel.setRowCount(0);
            if(data != null){
                for(Tour tour : data){
                    int companyId = tourService.getCompanyIdByTourId(tour.getId());
                    Company company = companyService.getCompanyById(companyId);
                    int numberOfStudents = studentTourService.getNumberOfStudents(tour.getId());
                    tableModel.addRow(new Object[]{
                        tour.getCode(),tour.getName(),tour.getStartDate(),
                        company.getName(),
                        numberOfStudents
                    });
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadStudentsData() throws Exception {
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
    
    private void loadStudentToursData() throws Exception{
        List<Student> students_data = studentService.getStudentsByTourId(dataOfShowData.getTourId());
        if(students_data != null){
            for(Student stu : students_data){
                Classroom classroom = classroomService.getClassNameById(stu.getClassId());
                String className = classroom.getName();
                tableModel.addRow(new Object[]{stu.getCode(), 
                    stu.getLastName(), 
                    stu.getFirstName(), 
                    stu.getAddress(), 
                    stu.getPhoneNumber(), 
                    stu.getEmail(), 
                    stu.getBirthDate(), 
                    className});
            }
        }
    }
    
    private void loadToursData() throws Exception{
        try {
            List<Tour> tour_data = tourService.getAllTours();
            tableModel.setRowCount(0);
            if(tour_data != null){
                for (Tour tour : tour_data) {
                String companyName = tourService.getCompanyNameById(tour.getCompanyId());
                
                String teacherName = "";
                if (tour.getTeacherId() > 0) {
                    teacherName = tourService.getTeacherNameById(tour.getTeacherId());
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
    
    private void loadCompanysData() throws Exception{
        try{
            List<Company> companies_data = companyService.getAllCompanies();
            tableModel.setRowCount(0);
            if(companies_data != null){
                for(Company company : companies_data){
                    
                    // Thêm đối tượng Company vào các dòng của table
                    tableModel.addRow(new Object[]{
                        company.getCode(),
                        company.getName(),
                        company.getAddress(),
                        company.getEmail(),
                        company.getPhoneNumber(),
                        company.getDescription()
                    });
                }
            }
            tableModel.fireTableDataChanged();
        }catch(Exception e){
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    } 
    
    private void loadTeachersData() throws Exception{
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
                    });
                }
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + e.getMessage(), "Có lỗi xảy ra");
            e.printStackTrace();
        }
    }
    
    private void loadStudentsAwaitingFeedback(String type) throws Exception {
        Tour tour = tourService.getTourById(dataOfShowData.getTourId());
        List<StudentTour> data = studentTourService.getAllStudentToursByTourId(tour.getId());
        List<Student> students = studentService.getStudentsByTourId(dataOfShowData.getTourId());

        if (data != null && students != null && !data.isEmpty()) {
            for (Student stu : students) {
                StudentTour studentTour = studentTourService.geStudentTourByStudentId(stu.getId());
                    tableModel.addRow(new Object[]{
                        stu.getCode(), 
                        stu.getLastName(), 
                        stu.getFirstName(), 
                        stu.getAddress(), 
                        stu.getPhoneNumber(), 
                        stu.getEmail(), 
                        stu.getBirthDate(), 
                        studentTour.getRate()
                    });
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton backButton;
    private javax.swing.JToggleButton clearDataButton;
    private javax.swing.JTable dataTable;
    private javax.swing.JToggleButton exportExcelFileButton;
    private javax.swing.JToggleButton exportPDFFileButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel search;
    private javax.swing.JToggleButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JLabel titleMainLabel;
    // End of variables declaration//GEN-END:variables

}
