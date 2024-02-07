
package view;

import exception.MessageDialog;
import exception.PDFExporter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import models.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.*;

public class ManageTourStudent extends javax.swing.JFrame {

    private CompanyService companyService;
    private StudentService studentService;
    private ClassroomService classroomService;
    private StudentTourService studentTourService;
    private TourService tourService;
    
    public ManageTourStudent() {
        initComponents();
        companyService = new CompanyService();
        studentService = new StudentService();
        classroomService = new ClassroomService();
        studentTourService = new StudentTourService();
        tourService = new TourService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    private Tour selectedTour;
    
    public ManageTourStudent(Tour tour){
        companyService = new CompanyService();
        studentService = new StudentService();
        classroomService = new ClassroomService();
        studentTourService = new StudentTourService();
        tourService = new TourService();
        try {
            this.selectedTour = tour;
            initComponents();
            setLocationRelativeTo(null);
            initializeTable();
            String tourTitle = tour.getName() + " (Mã: " + tour.getCode() + ", công ty: " + tour.getName() + ") - Ngày: " + tour.getStartDate();
            tourNameTitle.setText(tourTitle);
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra! Chi tiết: " + ex.getMessage(), "lỗi");
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        screenTitle = new javax.swing.JLabel();
        tourNameTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        rateStudentButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        pdfBtn = new javax.swing.JButton();
        excelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();

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

        screenTitle.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        screenTitle.setText("Danh sách sinh viên tham gia chuyến tham quan");

        tourNameTitle.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        tourNameTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tourNameTitle.setText("Tên công ty - Ngày diễn ra");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Tìm kiếm sinh viên:");

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        searchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchInputKeyPressed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(0, 102, 153));
        resetButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("Nhập lại");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(0, 102, 51));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Tìm kiếm");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(0, 102, 51));
        addButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Thêm sinh viên vào chuyến đi");
        addButton.setPreferredSize(new java.awt.Dimension(269, 37));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        rateStudentButton.setBackground(new java.awt.Color(0, 153, 153));
        rateStudentButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rateStudentButton.setForeground(new java.awt.Color(255, 255, 255));
        rateStudentButton.setText("Đánh giá sinh viên");
        rateStudentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rateStudentButton.setPreferredSize(new java.awt.Dimension(269, 37));
        rateStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateStudentButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(153, 0, 0));
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Xóa sinh viên trong danh sách");
        deleteButton.setPreferredSize(new java.awt.Dimension(269, 37));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        pdfBtn.setBackground(new java.awt.Color(0, 102, 102));
        pdfBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        pdfBtn.setForeground(new java.awt.Color(255, 255, 255));
        pdfBtn.setText("Xuất danh sách PDF");
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });

        excelBtn.setBackground(new java.awt.Color(0, 102, 102));
        excelBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        excelBtn.setForeground(new java.awt.Color(255, 255, 255));
        excelBtn.setText("Xuất danh sách Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(screenTitle)
                .addGap(513, 513, 513))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tourNameTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(searchInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rateStudentButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(excelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(79, 79, 79))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(screenTitle)
                .addGap(18, 18, 18)
                .addComponent(tourNameTitle)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(rateStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(excelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        ManageTour manageTour = new ManageTour();
        manageTour.setLocationRelativeTo(null);
        manageTour.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
        try {
            int index = studentTable.getSelectedRow();
            if(index == -1){
                return;
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_studentTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        AddStudentToTour screen = new AddStudentToTour(selectedTour);
        screen.setLocationRelativeTo(null);
        dispose();
        screen.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        handleSearchByKeyword();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Handle Enter key press
            handleSearchByKeyword();
        }
    }//GEN-LAST:event_searchInputKeyPressed

    private void rateStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateStudentButtonActionPerformed
        try {
            int index = studentTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui chọn chọn sinh viên để thực hiện chức năng này", "Thông báo");
                return;
            }
            
            String code = (String) studentTable.getValueAt(index, 0);
            
            Student student = studentService.getStudentByStudentCode(code);
            
            dispose();
            RateStudentResult rateScreen = new RateStudentResult(selectedTour,student);
            rateScreen.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_rateStudentButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            int index = studentTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn sinh viên để thực hiện chức năng", "Thông báo");
                return;
            }
            String code = (String) studentTable.getValueAt(index, 0);
            
            Student student = studentService.getStudentByStudentCode(code);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sinh viên này khỏi chuyến đi", "Xác nhận xóa");
            if(confirm == 0){
                System.out.println("checking student and tour id: " + student.getId() + ", " + selectedTour.getId());
                studentTourService.deleteStudentTour(student.getId(), selectedTour.getId());
                this.selectedTour = tourService.getTourById(selectedTour.getId());
                System.out.println("SelectedTour: " + this.selectedTour);
                reinitialize();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        try {
            int companyId = tourService.getCompanyIdByTourId(selectedTour.getId());
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
                    Tour tour = this.selectedTour;
                    String tourTitle = tour.getName() + " (Mã: " + tour.getCode() + ", công ty: " + companyService.getCompanyById(companyId).getName() + ") - Ngày: " + tour.getStartDate();
                    Sheet sheet = workbook.createSheet("Danh sách sinh viên tham gia chuyến tham quan " + tourTitle);

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

                    String[] headers = {"Mã sinh viên", "Họ", "Tên", "Ngày sinh", "Lớp", "SĐT", "Email", "Địa chỉ", "Điểm đánh giá", "Xếp loại"};

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
                    List<StudentTour> data = studentTourService.getAllStudentToursByTourId(selectedTour.getId());
                    if (data != null) {
                        int rowNum = 1;
                        for (StudentTour stuTour : data) {
                            Student stu = studentService.getStudentById(stuTour.getStudentId());
                            Row row = sheet.createRow(rowNum++);
                            for (int i = 0; i < headers.length; i++) {
                                Cell cell = row.createCell(i);
                                cell.setCellValue(getCellValue(stu, stuTour, i));
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
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi xảy ra khi xuất Excel. Chi tiết: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_excelBtnActionPerformed

    private String getCellValue(Student stu, StudentTour stuTour, int columnIndex) throws Exception{
        switch (columnIndex) {
            case 0:
                return stu.getCode();
            case 1:
                return stu.getLastName();
            case 2:
                return stu.getFirstName();
            case 3:
                return stu.getBirthDate();
            case 4:
                return classroomService.getClassNameById(stu.getClassId()).getName();
            case 5:
                return stu.getPhoneNumber();
            case 6:
                return stu.getEmail();
            case 7:
                return stu.getAddress();
            case 8:
                return String.valueOf(stuTour.getRate());
            case 9:
                return stuTour.getResult();
            default:
                return "";
        }
    }
    
    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed
        try {
            int companyId = tourService.getCompanyIdByTourId(selectedTour.getId());
            PDFExporter.exportTableToPDF(studentTable, "DANH SÁCH SINH CỦA CHUYẾN THAM QUAN CÓ " 
                    + "(MÃ: " + selectedTour.getCode().toUpperCase() + ", "
                    + "CÔNG TY: " + companyService.getCompanyById(companyId).getName().toUpperCase() 
                    + ") - NGÀY: " + selectedTour.getStartDate()
            );
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(jLabel2, "Có lỗi, chi tiết: " + ex.getMessage(), "Lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_pdfBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageTourStudent().setVisible(true);
            }
        });
    }
    
    private void reinitialize() {
        searchInput.setText("");
        loadTableData();
    }
    
    private void handleSearchByKeyword(){
        try {
            String keyword = searchInput.getText().trim();
            if (keyword.trim().equals("")) {
                MessageDialog.showInfoDialog(this, "Chưa có từ khóa tìm kiếm", "Thông báo");
                return;
            }
            List<StudentTour> data = studentTourService.getAllStudentToursByTourId(selectedTour.getId());
            tableModel.setRowCount(0);
            if (data != null) {
                for (StudentTour stuTour : data) {
                    Student stu = studentService.getStudentById(stuTour.getStudentId());
                    if (stu.getAddress().contains(keyword) || stu.getCode().contains(keyword) || stu.getFirstName().contains(keyword) || stu.getLastName().contains(keyword) || stu.getPhoneNumber().contains(keyword)) {
                        tableModel.addRow(
                                new Object[]{
                                    stu.getCode(),
                                    stu.getFirstName(),
                                    stu.getLastName(),
                                    classroomService.getClassNameById(stu.getClassId()).getName(),
                                    stu.getBirthDate(),
                                    stu.getPhoneNumber(),
                                    stu.getEmail(),
                                    stu.getAddress()
                                });
                    }
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception e) {
        }
    }
    
    private void clearAllFields(){
        searchInput.setText("");
    }
    
    private void loadTableData(){
        try {
            List<StudentTour> data = studentTourService.getAllStudentToursByTourId(selectedTour.getId());
            tableModel.setRowCount(0);
            if(data != null){
                for(StudentTour stuTour : data){
                    Student student = studentService.getStudentById(stuTour.getStudentId());
                    tableModel.addRow(new Object[]{
                        student.getCode(),
                        student.getLastName(),
                        student.getFirstName(),
                        student.getBirthDate(),
                        classroomService.getClassNameById(student.getClassId()).getName(),
                        student.getPhoneNumber(),
                        student.getEmail(),
                        student.getAddress(),
                        stuTour.getRate(),
                        stuTour.getResult()
                    });
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ", "Tên", "Ngày sinh", "Lớp", "SĐT", "Email", "Địa chỉ", "Điểm đánh giá", "Xếp loại"});
        studentTable.setModel(tableModel);
        loadTableData();
    }

    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton excelBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JButton rateStudentButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel screenTitle;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTable studentTable;
    private javax.swing.JLabel tourNameTitle;
    // End of variables declaration//GEN-END:variables
}
