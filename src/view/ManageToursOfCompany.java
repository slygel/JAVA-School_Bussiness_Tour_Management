package view;

import exception.MessageDialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import models.Teacher;
import models.Tour;
import services.TeacherService;
import services.TourService;

public class ManageToursOfCompany extends javax.swing.JFrame {

    
    private int companyId;
    private List<Tour> tours = new ArrayList<>();
    
    public void setTours(List<Tour> tours) {
        this.tours = tours;
        loadedDataTable();
    }
    
    public void setCompanyId(int comId) {
        this.companyId = comId; 
    }
    
    public int getCompanyId() {
        return companyId;
    }
    
    public ManageToursOfCompany() {
        initComponents();
        setLocationRelativeTo(null);
        tourService = new TourService();
        teacherService = new TeacherService();
        initializeTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        JLabel = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        toursOfCompanyTable = new javax.swing.JTable();
        createCompanyButton = new javax.swing.JButton();
        companyCodeLabel = new javax.swing.JLabel();
        companyPhoneLabel = new javax.swing.JLabel();
        companyAddressLabel = new javax.swing.JLabel();
        companyNameLabel = new javax.swing.JLabel();
        companyEmailLabel = new javax.swing.JLabel();
        companyDescriptionLabel = new javax.swing.JLabel();

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
        JLabel.setText("CÁC CHUYẾN THAM QUAN DOANH NGHIỆP TỔ CHỨC");

        label1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label1.setText("Mã doanh nghiệp:   ");

        label2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label2.setText("Điện thoại:   ");

        label3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label3.setText("Địa chỉ:   ");

        label4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label4.setText("Tên doanh nghiệp:   ");

        label5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label5.setText("Email:   ");

        label6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label6.setText("Ghi chú:   ");

        toursOfCompanyTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(toursOfCompanyTable);

        createCompanyButton.setBackground(new java.awt.Color(0, 153, 153));
        createCompanyButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        createCompanyButton.setForeground(new java.awt.Color(255, 255, 255));
        createCompanyButton.setText("Quản lí các chuyến tham quan");
        createCompanyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        createCompanyButton.setPreferredSize(new java.awt.Dimension(269, 37));
        createCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCompanyButtonActionPerformed(evt);
            }
        });

        companyCodeLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        companyPhoneLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        companyAddressLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        companyNameLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        companyEmailLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        companyDescriptionLabel.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(JLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1578, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(581, 581, 581)
                        .addComponent(createCompanyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label2)
                        .addGap(3, 3, 3)
                        .addComponent(companyPhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label3)
                        .addGap(1, 1, 1)
                        .addComponent(companyAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1)
                        .addGap(4, 4, 4)
                        .addComponent(companyCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label5)
                        .addGap(2, 2, 2)
                        .addComponent(companyEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label6)
                        .addGap(1, 1, 1)
                        .addComponent(companyDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label4)
                        .addGap(3, 3, 3)
                        .addComponent(companyNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(178, 178, 178))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(JLabel)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(companyNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(companyCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyPhoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyAddressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createCompanyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Nút thêm tour -> ManageTour
    private void createCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCompanyButtonActionPerformed
        try {
            ManageTour manageTour = new ManageTour();
            manageTour.setVisible(true);
            dispose();
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Phát hiện lỗi khi thêm doanh nghiệp, chi tiết: " + ex.getMessage() + "\n" + ex.toString() + "\n", "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_createCompanyButtonActionPerformed

    // Nút trở lại trang ManageCompany
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        ManageCompany company = new ManageCompany();
        company.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ManageToursOfCompany().setVisible(true);
        });
    }
    
    // Hàm load dữ liệu cho bảng
    private void loadedDataTable(){
        try {
            if (tours != null) {
                for (Tour tour : tours) {
                String teacherName = tourService.getTeacherNameById(tour.getTeacherId());
                tableModel.addRow(new Object[]{
                        tour.getCode(), 
                        tour.getName(),
                        tour.getStartDate(), 
                        tour.getDescription(),
                        tour.getAvailables(),
                        tour.getPresentator(), 
                        teacherName
                });    
                }
            }
        } catch (Exception ex) {
            MessageDialog.showErrorDialog(this, "Tải dữ liệu cho bảng có lỗi! Chi tiết: " + ex.getMessage(), "Có lỗi xảy ra");
            ex.printStackTrace();
        }
    }
    
    public void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã chuyến", "Tên chuyến",
            "Ngày khởi hành", "Mô tả", "Số ghế","Người thuyết trình","Giáo viên"});
        toursOfCompanyTable.setModel(tableModel);
        loadedDataTable();
    }

    private DefaultTableModel tableModel;
    private TourService tourService;
    private TeacherService teacherService;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel companyAddressLabel;
    private javax.swing.JLabel companyCodeLabel;
    private javax.swing.JLabel companyDescriptionLabel;
    private javax.swing.JLabel companyEmailLabel;
    private javax.swing.JLabel companyNameLabel;
    private javax.swing.JLabel companyPhoneLabel;
    private javax.swing.JButton createCompanyButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JTable toursOfCompanyTable;
    // End of variables declaration//GEN-END:variables

    public JLabel getCompanyAddressLabel() {
        return companyAddressLabel;
    }

    public void setCompanyAddressLabel(JLabel companyAddressLabel) {
        this.companyAddressLabel = companyAddressLabel;
    }

    public JLabel getCompanyCodeLabel() {
        return companyCodeLabel;
    }

    public void setCompanyCodeLabel(JLabel companyCodeLabel) {
        this.companyCodeLabel = companyCodeLabel;
    }

    public JLabel getCompanyDescriptionLabel() {
        return companyDescriptionLabel;
    }

    public void setCompanyDescriptionLabel(JLabel companyDescriptionLabel) {
        this.companyDescriptionLabel = companyDescriptionLabel;
    }

    public JLabel getCompanyEmailLabel() {
        return companyEmailLabel;
    }

    public void setCompanyEmailLabel(JLabel companyEmailLabel) {
        this.companyEmailLabel = companyEmailLabel;
    }

    public JLabel getCompanyNameLabel() {
        return companyNameLabel;
    }

    public void setCompanyNameLabel(JLabel companyNameLabel) {
        this.label4 = companyNameLabel;
    }

    public JLabel getCompanyPhoneLabel() {
        return companyPhoneLabel;
    }
    

    public void setCompanyPhoneLabel(JLabel companyPhoneLabel) {
        this.companyPhoneLabel = companyPhoneLabel;
    }

}
