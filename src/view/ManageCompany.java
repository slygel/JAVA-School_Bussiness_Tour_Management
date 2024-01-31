package view;

import exception.MessageDialog;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;
import models.*;
import services.*;

public class ManageCompany extends javax.swing.JFrame {

    public ManageCompany() {
        initComponents();
        companyService = new CompanyService();
        tourService = new TourService();
        initializeTable();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        companyCodeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        companyNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        companyPhoneField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        companyEmailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        companyAddressField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        companyDesField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        companyTable = new javax.swing.JTable();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        toursOfComButton = new javax.swing.JButton();

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel9.setText("QUẢN LÍ THÔNG TIN DOANH NGHIỆP");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Mã doanh nghiệp: ");

        companyCodeField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Tên doanh nghiệp: ");

        companyNameField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Số điện thoại:");

        companyPhoneField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Email:");

        companyEmailField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        companyAddressField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Mô tả:");

        companyDesField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        companyTable.setModel(new javax.swing.table.DefaultTableModel(
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
        companyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                companyTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(companyTable);

        btn_add.setBackground(new java.awt.Color(0, 102, 51));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("Thêm");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
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

        toursOfComButton.setBackground(new java.awt.Color(0, 102, 153));
        toursOfComButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        toursOfComButton.setForeground(new java.awt.Color(255, 255, 255));
        toursOfComButton.setText("Các chuyến thăm quan của doanh nghiệp");
        toursOfComButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toursOfComButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(companyAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(companyPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(companyCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(companyEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(companyDesField, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_back)
                                .addGap(247, 247, 247)
                                .addComponent(jLabel9))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(100, 100, 100)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(109, 109, 109)
                                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(114, 114, 114)
                                    .addComponent(toursOfComButton, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1540, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(companyEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(companyDesField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(93, 93, 93)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(toursOfComButton, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Hàm clear
    private void clearAllFields() {
        companyCodeField.setText("");
        companyNameField.setText("");
        companyPhoneField.setText("");
        companyEmailField.setText("");
        companyAddressField.setText("");
        companyDesField.setText("");
    }
    
    // Hàm load dữ liệu
    private void loadedTableData(){
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
        }
    }
    
    // Hàm khởi tạo bảng
    private void initializeTable(){
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã doanh nghiệp", "Doanh nghiệp","Địa chỉ",
            "Email", "Điện thoại", "Mô tả"});
        companyTable.setModel(tableModel);
        loadedTableData();
    }
    
    // Nút thêm
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            
            // Lấy giá trị từ text field
            String companyCode = this.companyCodeField.getText().trim();
            String companyName = this.companyNameField.getText().trim();
            String companyDescription = this.companyDesField.getText().trim();
            String companyEmail = this.companyEmailField.getText().trim();
            String companyPhoneNumber = this.companyPhoneField.getText().trim();
            String companyAdress = this.companyAddressField.getText().trim();

            // Bắt lỗi bỏ trống
            if(companyName.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Tên doanh nghiệp trống", "Thông báo");
                return;
            }
            if(companyCode.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mã doanh nghiệp trống ", "Thông báo");
                return;
            }
            if(companyEmail.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Email doanh nghiệp trống", "Thông báo");
                return;
            }
            if(companyPhoneNumber.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Điện thoại doanh nghiệp trống", "Thông báo");
                return;
            }
            if(companyAdress.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Địa chỉ doanh nghiệp trống", "Thông báo");
                return;
            }
            if(companyDescription.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mô tả doanh nghiệp trống", "Thông báo");
                return;
            }
            // Bắt lỗi trùng
            if(companyService.isExistedComCode(companyCode)){
                MessageDialog.showInfoDialog(this, "Mã số doanh nghiệp đã tồn tại", "Thông báo");
            }else if(companyService.isExistedComName(companyName)){
                MessageDialog.showInfoDialog(this, "Tên doanh nghiệp đã tồn tại", "Thông báo");
            }else{
                // Gán biến vào đối tượng 
                Company company = new Company(companyCode, companyName, companyDescription, companyEmail,companyPhoneNumber, companyAdress);
                
                // Thực hiện thêm
                companyService.addCompany(company);
                loadedTableData();
                MessageDialog.showInfoDialog(this, "Thêm thành công", "Thông báo");
                clearAllFields();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_addActionPerformed

    // Nút nhập lại
    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearAllFields();
    }//GEN-LAST:event_btn_clearActionPerformed
    
    // Nút xóa
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            int index = companyTable.getSelectedRow();// Hàng được chọn
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui lòng chọn doanh nghiệp", "Thông báo");
                return;
            }
            
            // Lấy giá trị từ hàng được chọn của từng cột 
            String code = (String) companyTable.getValueAt(index, 0);
            String name = (String) companyTable.getValueAt(index, 1);
            String address = (String) companyTable.getValueAt(index, 2);
            String email = (String) companyTable.getValueAt(index, 3);
            String phoneNumber = (String) companyTable.getValueAt(index, 4);
            String description = (String) companyTable.getValueAt(index, 5);
            
            System.out.println("index " + index);
            
            int confirm = MessageDialog.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa doanh nghiệp này không?", "Xác nhận xóa");
            
            if (confirm == 0) {
                
                // Lấy ra id tương ứng với các thuộc tính được chọn ra từ bảng
                int companyId = companyService.GetIdByCompany(code, name, description, email, phoneNumber, address);
                System.out.println("ID: " + companyId);
                // Thực hiện xóa
                companyService.deleteCompanyById(companyId);
                loadedTableData();
                clearAllFields();
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void companyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyTableMouseClicked
        try {
            int index = companyTable.getSelectedRow();
            if (index == -1) {
                MessageDialog.showInfoDialog(this, "Vui lòng chọn doanh nghiệp", "Thông báo");
                return;
            }

            // Lấy giá trị từ bảng
            String code = (String) companyTable.getValueAt(index, 0);
            String name = (String) companyTable.getValueAt(index, 1);
            String address = (String) companyTable.getValueAt(index, 2);
            String email = (String) companyTable.getValueAt(index, 3);
            String phoneNumber = (String) companyTable.getValueAt(index, 4);
            String description = (String) companyTable.getValueAt(index, 5);

            // Đẩy giá trị lên các JTextField
            companyCodeField.setText(code);
            companyNameField.setText(name);
            companyDesField.setText(description);
            companyEmailField.setText(email);
            companyPhoneField.setText(phoneNumber);
            companyAddressField.setText(address);
            
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
        }
    }//GEN-LAST:event_companyTableMouseClicked

    // Nút sửa
    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            int index = companyTable.getSelectedRow(); // Hàng được chọn
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui chọn chọn doanh nghiệp muốn sửa", "Thông báo");
                return;
            }
            
            // Lấy giá trị từ bảng
            String code = (String) companyTable.getValueAt(index, 0);
            String name = (String) companyTable.getValueAt(index, 1);
            String address = (String) companyTable.getValueAt(index, 2);
            String email = (String) companyTable.getValueAt(index, 3);
            String phoneNumber = (String) companyTable.getValueAt(index, 4);
            String description = (String) companyTable.getValueAt(index, 5);

            // Lấy ra id tương ứng với giá trị của bảng
            int companyId = companyService.GetIdByCompany(code, name, description, email, phoneNumber, address);
            
            // Lấy giá trị từ text field
            String companyName = this.companyNameField.getText().trim();
            String companyCode = this.companyCodeField.getText().trim();
            String companyDes = this.companyDesField.getText().trim();
            String companyEmail = this.companyEmailField.getText().trim();
            String companyPhone = this.companyPhoneField.getText().trim();
            String companyAddress = this.companyAddressField.getText().trim();
            
            // Bắt sự kiện bỏ trống
            if (companyName.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Tên doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if (companyCode.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mã số doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if (companyEmail.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Mail doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if (companyPhone.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Số điện thoại doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if (companyAddress.equalsIgnoreCase("")) {
                MessageDialog.showInfoDialog(this, "Địa chỉ doanh nghiệp không để trống", "Thông báo");
                return;
            }
            if(companyDes.equalsIgnoreCase("")){
                MessageDialog.showInfoDialog(this, "Mô tả doanh nghiệp trống", "Thông báo");
                return;
            }
            
            // Bắt sự kiện trùng
            if (companyService.isExistedComCode(companyCode) && !companyCode.equals(companyCode)) {
                MessageDialog.showInfoDialog(this, "Mã số doanh nghiệp đã tồn tại", "Thông báo");
                return;
            }
            if (companyService.isExistedComName(companyName) && !companyName.equals(companyName)) {
                MessageDialog.showInfoDialog(this, "Tên doanh nghiệp đã tồn tại", "Thông báo");
                return;
            }
            
            // Gọi đối tượng thông qua id
            Company selectedCom = companyService.getCompanyById(companyId);
            
            // Đẩy giá trị từ text Field vào đối tượng
            selectedCom.setCode(companyCode);
            selectedCom.setName(companyName);
            selectedCom.setDescription(companyDes);
            selectedCom.setEmail(companyEmail);
            selectedCom.setPhoneNumber(companyPhone);
            selectedCom.setAddress(companyAddress);
            
            // Thực hiện sửa đối tượng theo id
            companyService.updateCompany(selectedCom , companyId);
            loadedTableData();
            MessageDialog.showInfoDialog(this, "Cập nhật thông tin thành công!", "Thông báo");
            clearAllFields();
            
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Có lỗi, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Phát hiện lỗi");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_editActionPerformed

    // Nút danh sách các chuyến thăm quan của doanh nghiệp
    private void toursOfComButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toursOfComButtonActionPerformed
        try {
            int index = companyTable.getSelectedRow(); // Hàng được chọn
            if(index == -1){
                MessageDialog.showInfoDialog(this, "Vui lòng chọn doanh nghiệp", "Thông báo");
                return;
            }
            
            // Lấy giá trị từ bảng
            String code = (String) companyTable.getValueAt(index, 0);
            String name = (String) companyTable.getValueAt(index, 1);
            String address = (String) companyTable.getValueAt(index, 2);
            String email = (String) companyTable.getValueAt(index, 3);
            String phoneNumber = (String) companyTable.getValueAt(index, 4);
            String description = (String) companyTable.getValueAt(index, 5);

            int companyId = companyService.GetIdByCompany(code, name, description, email, phoneNumber, address);
            System.out.println("CompanyId: " + companyId);
            
            Company selectedCom = companyService.getCompanyById(companyId);
            System.out.println("Company: " + selectedCom.getEmail());
           
            List<Tour> tours = tourService.getToursByCompanyId(companyId);
            
            dispose();
            ManageToursOfCompany manageToursOfCompany = new ManageToursOfCompany();
            
            if(manageToursOfCompany != null){
                manageToursOfCompany.setVisible(true);
                manageToursOfCompany.setTours(tours);
                manageToursOfCompany.getCompanyCodeLabel().setText(selectedCom.getCode());
                manageToursOfCompany.getCompanyNameLabel().setText(selectedCom.getName());
                manageToursOfCompany.getCompanyDescriptionLabel().setText(selectedCom.getDescription());
                manageToursOfCompany.getCompanyAddressLabel().setText(selectedCom.getAddress());
                manageToursOfCompany.getCompanyEmailLabel().setText(selectedCom.getEmail());
                manageToursOfCompany.getCompanyPhoneLabel().setText(selectedCom.getPhoneNumber());
                manageToursOfCompany.setCompanyId(companyId);
                
                manageToursOfCompany.setLocationRelativeTo(null);
                manageToursOfCompany.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_toursOfComButtonActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
        AdminHome homeScreen = new AdminHome();
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageCompany().setVisible(true);
        });
    }

    private DefaultTableModel tableModel;
    private CompanyService companyService;
    private TourService tourService;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JTextField companyAddressField;
    private javax.swing.JTextField companyCodeField;
    private javax.swing.JTextField companyDesField;
    private javax.swing.JTextField companyEmailField;
    private javax.swing.JTextField companyNameField;
    private javax.swing.JTextField companyPhoneField;
    private javax.swing.JTable companyTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton toursOfComButton;
    // End of variables declaration//GEN-END:variables
}
