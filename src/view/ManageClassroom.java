package view;

import exception.MessageDialog;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Classroom;
import services.ClassroomService;

public class ManageClassroom extends javax.swing.JFrame {

    public ManageClassroom() {
        initComponents();
        classroomService = new ClassroomService();
        initializeTable();
        setLocationRelativeTo(null);
    }
    
    private void clearAllField(){
        ClassroomIdField.setText("");
        ClassroomNameField.setText("");
    }
    
    private void loadedDataTable(){
        try {
            List<Classroom> data = classroomService.getAllClassroom();
            tableModel.setRowCount(0);
            int count = 0;
            if(data != null){
                for(Classroom item : data){
                    count++;
                    tableModel.addRow(new Object[]{count,item.getCode(),item.getName()});
                }
            }
            tableModel.fireTableDataChanged();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    private void initializeTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"STT", "Mã lớp học", "Tên lớp học"});
        classroomTable.setModel(tableModel);
        loadedDataTable();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClassroomNameField = new javax.swing.JTextField();
        btn_back = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        classroomTable = new javax.swing.JTable();
        ListStudentButton = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ClassroomIdField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ClassroomNameField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

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
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_edit.setPreferredSize(new java.awt.Dimension(269, 37));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(0, 102, 51));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.setPreferredSize(new java.awt.Dimension(269, 37));
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

        classroomTable.setModel(new javax.swing.table.DefaultTableModel(
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
        classroomTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classroomTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(classroomTable);

        ListStudentButton.setBackground(new java.awt.Color(0, 102, 153));
        ListStudentButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ListStudentButton.setForeground(new java.awt.Color(255, 255, 255));
        ListStudentButton.setText("Danh sách sinh viên");
        ListStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListStudentButtonActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(153, 0, 0));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Xóa");
        btn_delete.setPreferredSize(new java.awt.Dimension(269, 37));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Mã lớp học:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN LỚP HỌC");

        ClassroomIdField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Tên lớp học:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_back)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ClassroomIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addContainerGap(106, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ClassroomNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ListStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel9)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClassroomIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClassroomNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(ListStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classroomTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classroomTableMouseClicked
        try {
            int index = classroomTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui lòng chọn lớp", "Thông báo");
                return;
            }
            String code = (String) classroomTable.getValueAt(index, 1);
            String name = (String) classroomTable.getValueAt(index, 2);
            
            int classId = classroomService.getIdByClassroom(code, name);
            
            ClassroomIdField.setText(code);
            ClassroomNameField.setText(name);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_classroomTableMouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            String code = this.ClassroomIdField.getText().trim();
            String name = this.ClassroomNameField.getText().trim();
            
            if(code.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã lớp trống", "Thông báo");
                return;
            }
            if(name.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên lớp trống", "Thông báo");
                return;
            }
            if(classroomService.isExistedClassCode(code)){
                MessageDialog.showInfoDialog(this, "Trùng mã lớp", "Thông báo");
            }else if(classroomService.isExistedClassName(name)){
                MessageDialog.showInfoDialog(this, "Trùng tên lớp", "Thông báo");
            }else{
                Classroom classroom = new Classroom(code, name);
                
                classroomService.addClassroom(classroom);
                
                loadedDataTable();
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                clearAllField();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = classroomTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn lớp", "Thông báo");
                return;
            }
            
            String code = (String) classroomTable.getValueAt(index, 1);
            String name = (String) classroomTable.getValueAt(index, 2);
            
            int classId = classroomService.getIdByClassroom(code, name);
            System.out.println(classId);
            
            String classNewCode = this.ClassroomIdField.getText().trim();
            String classNewName = this.ClassroomNameField.getText().trim();
            
            if(classNewCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã lớp trống", "Thông báo");
                return;
            }
            if(classNewName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên lớp trống", "Thông báo");
                return;
            }
            
            if(classroomService.isExistedClassCode(classNewCode) && !classNewCode.equals(classNewCode)){
                MessageDialog.showInfoDialog(this, "Mã lớp không tồn tại!", "Thông báo");
                return;
            }
            if(classroomService.isExistedClassName(classNewName) && !classNewName.equals(classNewName)){
                MessageDialog.showInfoDialog(this, "Tên lớp không tồn tại!", "Thông báo");
                return;
            }
            
            Classroom selectedClass = classroomService.getClassroomById(classId);
            System.out.println(selectedClass);
            
            selectedClass.setCode(classNewCode);
            selectedClass.setName(classNewName);
            
            classroomService.updateClassroom(selectedClass, classId);
            loadedDataTable();
            MessageDialog.showInfoDialog(this, "Cập nhật thành công", "Thông báo");
            clearAllField();
            
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = classroomTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn lớp", "Thông báo");
                return;
            }
            String code = (String) classroomTable.getValueAt(index, 1);
            String name = (String) classroomTable.getValueAt(index, 2);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa lớp này không?", "Xác nhận xóa");
            
            if(confirm == 0){
                int classId = classroomService.getIdByClassroom(code, name);
                
                System.out.println("ID: " + classId);
                
                classroomService.deleteClassroom(classId);
                loadedDataTable();
                clearAllField();
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearAllField();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        AdminHome homeScreen = new AdminHome();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void ListStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListStudentButtonActionPerformed
        try {
            int index = classroomTable.getSelectedRow();
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn lớp học", "Thông báo");
                return;
            }
            String code = (String) classroomTable.getValueAt(index, 1);
            String name = (String) classroomTable.getValueAt(index, 2);
            
            int classId = classroomService.getIdByClassroom(code,name);
            Classroom classroom = classroomService.getClassroomById(classId);
            System.out.println("Classroom: " + classroom.getId());
            
            dispose();
            ManageListStudentClass manageListStudentClass = new ManageListStudentClass(classroom);
            manageListStudentClass.setLocationRelativeTo(null);
            manageListStudentClass.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ListStudentButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageClassroom().setVisible(true);
            }
        });
    }

    private DefaultTableModel tableModel;
    private ClassroomService classroomService;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ClassroomIdField;
    private javax.swing.JTextField ClassroomNameField;
    private javax.swing.JButton ListStudentButton;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JTable classroomTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
