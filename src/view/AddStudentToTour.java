package view;

import exception.MessageDialog;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.*;
import services.*;

public class AddStudentToTour extends javax.swing.JFrame {
    
    private StudentService studentService;
    private ClassroomService classroomService;
    private StudentTourService studentTourService;
    private TourService tourService;
    
    public AddStudentToTour() {
        initComponents();
        studentService = new StudentService();
        classroomService = new ClassroomService();
        studentTourService = new StudentTourService();
        tourService = new TourService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    private Tour selectedTour;

    public AddStudentToTour(Tour tour) {
        studentService = new StudentService();
        classroomService = new ClassroomService();
        studentTourService = new StudentTourService();
        tourService = new TourService();
        try {
            this.selectedTour = tour;
            initComponents();
            setLocationRelativeTo(null);
            initializeTable();
            screenTitle.setText("" + tour.getName() + " (Mã: " + tour.getCode() + ", công ty: " + tour.getName() + ") - Ngày: " + tour.getStartDate());
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }
    
    private void handleSearchByKeyword(){
        try {
            String keyword = searchInput.getText().trim();
            if(keyword.trim().equals("")){
                MessageDialog.showInfoDialog(this, "Chưa có từ khóa tìm kiếm", "Thông báo");
                return;
            }
            List<Student> data = studentService.getAllStudents();
            List<Student> displayData = new ArrayList<>();
            List<StudentTour> selectedData = new ArrayList<>();
            
            if(studentTourService.getAllStudentToursByTourId(selectedTour.getId()) == null){
                studentTourService.addListStudentTours(new ArrayList<>());
            }
            
            for (Student student : data) {
                boolean isExisted = false;
                for (StudentTour selectedRel : selectedData) {
                    if (selectedRel.getStudentId() == studentService.getIdByStudent(student.getCode())) {
                        isExisted = true;
                        break;
                    }
                }
                if (!isExisted) {
                    displayData.add(student);
                }
            }
            
            tableModel.setRowCount(0);
            if (displayData != null) {
                for (Student stu : displayData) {
                    if (stu.getAddress().contains(keyword) || stu.getCode().contains(keyword) || stu.getFirstName().contains(keyword) || stu.getLastName().contains(keyword) || stu.getPhoneNumber().contains(keyword)) {
                    tableModel.addRow(
                            new Object[]{
                                stu.getCode(),
                                stu.getLastName(),
                                stu.getFirstName(),
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabel = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        screenTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        addToListButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        JLabel.setText("Thêm sinh viên tham gia chuyến tham quan");

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
        screenTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        screenTitle.setText("Tên công ty - Ngày diễn ra");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Tìm kiếm sinh viên:");

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        searchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchInputKeyPressed(evt);
            }
        });

        findButton.setBackground(new java.awt.Color(0, 102, 153));
        findButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        findButton.setForeground(new java.awt.Color(255, 255, 255));
        findButton.setText("Tìm kiếm");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(102, 153, 0));
        resetButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("Nhập lại");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        addToListButton.setBackground(new java.awt.Color(0, 102, 51));
        addToListButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addToListButton.setForeground(new java.awt.Color(255, 255, 255));
        addToListButton.setText("Thêm sinh viên vào chuyến đi");
        addToListButton.setPreferredSize(new java.awt.Dimension(269, 37));
        addToListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToListButtonActionPerformed(evt);
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
        jScrollPane1.setViewportView(studentTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(screenTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(535, 535, 535)
                        .addComponent(JLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchInput)
                    .addComponent(addToListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(screenTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(addToListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(305, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        ManageTourStudent screen = new ManageTourStudent(selectedTour);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void addToListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToListButtonActionPerformed
        try {
            int chosenIndex[] = studentTable.getSelectedRows();
            if (chosenIndex.length == 0) {
                MessageDialog.showInfoDialog(this, "Chưa có sinh viên nào được chọn để thực hiện chức năng này", "Thông báo");
                return;
            }
            
            List<Student> chosenStudents = new ArrayList<>();
            for (int index : chosenIndex) {
                String code = (String) studentTable.getValueAt(index, 0);
                Student student = studentService.getStudentByStudentCode(code);
                if (student != null) {
                    chosenStudents.add(student);
                }
            }
            System.out.println("ChosenStudents: " + chosenStudents);
            
//            List<StudentTour> studentTourData = studentTourService.getAllStudentTours();
//            if(studentTourService.getAllStudentToursByTourId(selectedTour.getId()) == null){
//                studentTourService.addListStudentTours(new ArrayList<>());
//            }

            List<StudentTour> studentTourData = new ArrayList<>();

            for (Student student : chosenStudents) {
                StudentTour relationship = new StudentTour();
                relationship.setStudentId(student.getId());
                relationship.setRate(0);
                relationship.setTourId(selectedTour.getId());
                studentTourData.add(relationship); 
                studentTourService.getAllStudentToursByTourId(selectedTour.getId()).add(relationship);
                if (studentTourService.getAllStudentToursByStudentId(student.getId()) == null) {
                    studentService.addListStudents(new ArrayList<>());
                }
                studentTourService.getAllStudentToursByStudentId(student.getId()).add(relationship);
            }
            studentTourService.addListStudentTours(studentTourData);
            
            List<Student> studentData = studentService.getAllStudents();
            for (int i = 0; i < studentData.size(); i++) {
                for (Student tempStudent : chosenStudents) {
                    if (studentData.get(i).getId() == tempStudent.getId()) {
                        studentData.set(i, tempStudent);
                    }
                }
            }
            
            List<Tour> tourData = tourService.getAllTours();
            for (int i = 0; i < tourData.size(); i++) {
                if (tourData.get(i).getId() == selectedTour.getId()) {
                    tourData.set(i, selectedTour);
                    break;
                }
            }
            
            clearAllFields();
            MessageDialog.showInfoDialog(this, "Đã thêm thành công " + chosenIndex.length + " sinh viên vào chuyến tham quan!", "Thông báo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_addToListButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        clearAllFields();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        handleSearchByKeyword();
    }//GEN-LAST:event_findButtonActionPerformed

    private void searchInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            // Handle Enter key press
            handleSearchByKeyword();
        }
    }//GEN-LAST:event_searchInputKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudentToTour().setVisible(true);
            }
        });
    }
    
    private void clearAllFields() {
        searchInput.setText("");
        loadTableData();
    }
    
    private void loadTableData() {
        try {
            List<Student> data = studentService.getAllStudents();
            List<Student> displayData = new ArrayList<>();
            List<StudentTour> selectedData = new ArrayList<>();
            if (studentTourService.getAllStudentToursByTourId(selectedTour.getId()) != null) {
                selectedData = studentTourService.getAllStudentToursByTourId(selectedTour.getId());
            }// selectedData: [3,2,9]

            for (Student student : data) {
                boolean isExisted = false;
                for (StudentTour selectedRel : selectedData) {
                    if (selectedRel.getStudentId() == studentService.getIdByStudent(student.getCode())) {
                        isExisted = true;
                        break;
                    }
                }
                if (!isExisted) {
                    displayData.add(student);
                }
            }
            tableModel.setRowCount(0);
            if (displayData != null) {
                for (Student stu : displayData) {
                    tableModel.addRow(
                            new Object[]{
                                stu.getCode(),
                                stu.getLastName(),
                                stu.getFirstName(),
                                classroomService.getClassNameById(stu.getClassId()).getName(),
                                stu.getBirthDate(),
                                stu.getPhoneNumber(),
                                stu.getEmail(),
                                stu.getAddress()
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
        tableModel.setColumnIdentifiers(new String[]{"Mã sinh viên", "Họ", "Tên", "Ngày sinh", "Lớp", "SĐT", "Email", "Địa chỉ",});
        studentTable.setModel(tableModel);
        loadTableData();
    }

    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JButton addToListButton;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton findButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel screenTitle;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTable studentTable;
    // End of variables declaration//GEN-END:variables
}
