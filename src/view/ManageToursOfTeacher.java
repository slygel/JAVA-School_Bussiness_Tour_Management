package view;

import exception.MessageDialog;
import exception.PDFExporter;
import exception.TransmittedDataShowData;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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
import services.CompanyService;
import services.StudentTourService;
import services.TeacherService;
import services.TourService;

public class ManageToursOfTeacher extends javax.swing.JFrame {

    
    private String imagePath = "";
    private Teacher selectTeacher;
    private List<Tour> tours = new ArrayList<>();
    private CompanyService companyService;
    private TeacherService teacherService;
    private TourService tourService;
    private StudentTourService studentTourService;
    private int teacherId;
    
    public void setTours(List<Tour> tours) {
        this.tours = tours;
        loadTableData();
    }
    

    public void setTeacherID(int teaID) {
        this.teacherId = teaID;
    }
    
    public ManageToursOfTeacher(Teacher teacher) {
        initComponents();
        this.selectTeacher = teacher;
        tourService = new TourService();
        teacherService = new TeacherService();
        companyService = new CompanyService();
        studentTourService = new StudentTourService();
        loadTableData();
    }
    
    public ManageToursOfTeacher() {
        initComponents();
        tourService = new TourService();
        teacherService = new TeacherService();
        companyService = new CompanyService();
        studentTourService = new StudentTourService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    public void showImage() {
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
        titleMain = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        toursTable = new javax.swing.JTable();
        exportFilePDF = new javax.swing.JButton();
        exportFileExcel = new javax.swing.JButton();
        deleteTourForTeacher = new javax.swing.JButton();
        showListStudents = new javax.swing.JButton();
        addTourForTeacher = new javax.swing.JButton();
        teacherIdLabel = new javax.swing.JLabel();
        teacherNameLabel = new javax.swing.JLabel();
        teacherAdressLable = new javax.swing.JLabel();
        teacherPhoneNumberLabel = new javax.swing.JLabel();
        teacherEmailLable = new javax.swing.JLabel();

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

        titleMain.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        titleMain.setText("CÁC CHUYẾN THAM QUAN DOANH NGHIỆP DO GIÁO VIÊN ĐẠI DIỆN");

        label5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label5.setText("Email:");

        label4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label4.setText("Số điện thoại:");

        label3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label3.setText("Địa chỉ:");

        label2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label2.setText("Họ tên:");

        label1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label1.setText("Mã giáo viên:");

        imageLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        imageLabel.setText("Ảnh");

        toursTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(toursTable);

        exportFilePDF.setBackground(new java.awt.Color(0, 102, 102));
        exportFilePDF.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exportFilePDF.setForeground(new java.awt.Color(255, 255, 255));
        exportFilePDF.setText("Xuất danh sách PDF");
        exportFilePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFilePDFActionPerformed(evt);
            }
        });

        exportFileExcel.setBackground(new java.awt.Color(0, 102, 102));
        exportFileExcel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        exportFileExcel.setForeground(new java.awt.Color(255, 255, 255));
        exportFileExcel.setText("Xuất danh sách Excel");
        exportFileExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileExcelActionPerformed(evt);
            }
        });

        deleteTourForTeacher.setBackground(new java.awt.Color(153, 0, 0));
        deleteTourForTeacher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        deleteTourForTeacher.setForeground(new java.awt.Color(255, 255, 255));
        deleteTourForTeacher.setText("Xóa chuyến tham quan");
        deleteTourForTeacher.setPreferredSize(new java.awt.Dimension(269, 37));
        deleteTourForTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTourForTeacherActionPerformed(evt);
            }
        });

        showListStudents.setBackground(new java.awt.Color(0, 153, 153));
        showListStudents.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        showListStudents.setForeground(new java.awt.Color(255, 255, 255));
        showListStudents.setText("Danh sách sinh viên của chuyến đi");
        showListStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        showListStudents.setPreferredSize(new java.awt.Dimension(269, 37));
        showListStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showListStudentsActionPerformed(evt);
            }
        });

        addTourForTeacher.setBackground(new java.awt.Color(0, 102, 51));
        addTourForTeacher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addTourForTeacher.setForeground(new java.awt.Color(255, 255, 255));
        addTourForTeacher.setText("Thêm chuyến tham quan");
        addTourForTeacher.setPreferredSize(new java.awt.Dimension(269, 37));
        addTourForTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTourForTeacherActionPerformed(evt);
            }
        });

        teacherIdLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        teacherIdLabel.setText("Txt");

        teacherNameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        teacherNameLabel.setText("Txt");

        teacherAdressLable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        teacherAdressLable.setText("Txt");

        teacherPhoneNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        teacherPhoneNumberLabel.setText("Txt");

        teacherEmailLable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        teacherEmailLable.setText("Txt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addTourForTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                                .addGap(15, 15, 15)
                                .addComponent(deleteTourForTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(exportFilePDF, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exportFileExcel)
                                .addGap(18, 18, 18)
                                .addComponent(showListStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 1622, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label3)
                                                .addGap(18, 18, 18)
                                                .addComponent(teacherAdressLable, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label1)
                                                .addGap(18, 18, 18)
                                                .addComponent(teacherIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label2)
                                                .addGap(18, 18, 18)
                                                .addComponent(teacherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label5)
                                                .addGap(18, 18, 18)
                                                .addComponent(teacherEmailLable, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(teacherPhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(239, 239, 239))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(titleMain)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleMain)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherPhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherEmailLable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherAdressLable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTourForTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteTourForTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportFilePDF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportFileExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showListStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        ManageTeacher manageTeacherScreen = new ManageTeacher();
        manageTeacherScreen.setLocationRelativeTo(null);
        manageTeacherScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void addTourForTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTourForTeacherActionPerformed
        try {
            ManageTour manageTour = new ManageTour(teacherId);
            dispose();
            manageTour.setLocationRelativeTo(null);
            manageTour.setVisible(true);
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi khi thêm chuyến tham quan cho giáo viên, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_addTourForTeacherActionPerformed

    private void deleteTourForTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTourForTeacherActionPerformed
        try {
            int index = toursTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn chuyến tham quan để thực hiện chức năng", "Thông báo");
                return;
            }
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa chuyến tham quan này không", "Thông báo");
            
            String tourCode = (String) toursTable.getValueAt(index, 0);
            int tourId = tourService.getIdByTourCode(tourCode);
            System.out.println("TourId: " + tourId);
            Tour tour = tourService.getTourById(tourId);

            if(confirm == 0){
                tourService.updateTeacherIdByTourId(tourId);
            }
            loadTableData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteTourForTeacherActionPerformed

    private void exportFilePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFilePDFActionPerformed
        Teacher teacher = teacherService.getTeacherById(teacherId);
        PDFExporter.exportTableToPDF(toursTable, "DANH SÁCH CÁC CHUYẾN THAM QUAN CỦA GIÁO VIÊN " + teacher.getLastName().toUpperCase() + " "+teacher.getFirstName().toUpperCase());
    }//GEN-LAST:event_exportFilePDFActionPerformed

    private void exportFileExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileExcelActionPerformed
       try {
            Tour tour = tourService.getTourByTeacherId(teacherId);
            Teacher teacher = teacherService.getTeacherById(teacherId);
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
                    List<Tour> tours = tourService.getToursByTeacherId(teacherId);
                    if (tours != null) {
                        int rowNum = 1;
                        for (Tour teacherTour : tours) {
                            Row row = sheet.createRow(rowNum++);
                            for (int i = 0; i < headers.length; i++) {
                                Cell cell = row.createCell(i);
                                cell.setCellValue(getCellValue(teacherTour, i));
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
    }//GEN-LAST:event_exportFileExcelActionPerformed

    private void showListStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showListStudentsActionPerformed
        try {
            int index = toursTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui chọn chọn chọn chuyến tham quan để xem danh sách sinh viên tham quan", "Thông báo");
                return;
            }
            String tourCode = (String) toursTable.getValueAt(index, 0);
            int tourId = tourService.getIdByTourCode(tourCode);
            System.out.println("TourId: " + tourId);
            Tour tour = tourService.getTourById(tourId);
            dispose();
            TransmittedDataShowData data = new TransmittedDataShowData("studentTours", "managetoursofteacher", tour.getId(), teacherId, false);
            System.out.println("Data: " + data);
            ShowData showData = new ShowData(data);
            if (showData != null) {
                showData.setLocationRelativeTo(null);
                showData.setVisible(true);
            }
        } catch (Exception e) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + e, "Lỗi");
        }
    }//GEN-LAST:event_showListStudentsActionPerformed

    private String getCellValue(Tour tour,int columnIndex) throws Exception{
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
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageToursOfTeacher().setVisible(true);
            }
        });
    }
    
    public void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến tham quan", "Tên chuyến tham quan", "Ngày tham quan", "Doanh nghiệp chủ quản", "Số lượng sinh viên tham gia"});
        toursTable.setModel(tableModel);
        loadTableData();
    }
    
    private void loadTableData() {
        try {
            tableModel.setRowCount(0);  // Clear the existing data in the table
            boolean hideHeader = true;  // Assume initially that the header should be hidden

            if (tours != null && !tours.isEmpty()) {
                for (Tour tour : tours) {
                    String companyName = tourService.getCompanyNameById(tour.getCompanyId());
                    int numberOfStudents = studentTourService.getNumberOfStudents(tour.getId());

                    // Check if teacherId is less than 0
                    if (tour.getTeacherId() >= 0) {
                        hideHeader = false;  // Set to false if teacherId is not less than 0
                        tableModel.addRow(new Object[]{
                                tour.getCode(),
                                tour.getName(),
                                tour.getStartDate(),
                                companyName,
                                numberOfStudents
                        });
                    }
                }
            }

            toursTable.getTableHeader().setVisible(!hideHeader);  // Show/hide the header based on the condition
    } catch (Exception e) {
        MessageDialog.showErrorDialog(this, "Có lỗi khi tải dữ liệu", "Thông báo");
        e.printStackTrace();
    }
    }

    
    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTourForTeacher;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton deleteTourForTeacher;
    private javax.swing.JButton exportFileExcel;
    private javax.swing.JButton exportFilePDF;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JButton showListStudents;
    private javax.swing.JLabel teacherAdressLable;
    private javax.swing.JLabel teacherEmailLable;
    private javax.swing.JLabel teacherIdLabel;
    private javax.swing.JLabel teacherNameLabel;
    private javax.swing.JLabel teacherPhoneNumberLabel;
    private javax.swing.JLabel titleMain;
    private javax.swing.JTable toursTable;
    // End of variables declaration//GEN-END:variables

    public JLabel getTeacherIdLabel() {
        return teacherIdLabel;
    }

    public JLabel getTeacherNameLabel() {
        return teacherNameLabel;
    }

    public JLabel getTeacherPhoneNumberLabel() {
        return teacherPhoneNumberLabel;
    }

    public JLabel getTeacherEmailLable() {
        return teacherEmailLable;
    }

    public JLabel getTeacherAdressLable() {
        return teacherAdressLable;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
        showImage();
    }

    public String getImagePath() {
        return imagePath;
    }
    
}
