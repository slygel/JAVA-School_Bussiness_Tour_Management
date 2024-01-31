package dao;

import connectdb.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Company;


// Lớp DAO: Tương tác trực tiếp với database
public class CompanyDao {
    
    // Hàm lấy ra tất cả doanh nghiệp
    public  List<Company> getAllCompanies(){
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM tbl_company";
        try {
            // Gọi đối tượng Connection
            Connection connection = JDBCUtil.getConnection();
            
            // PreparedStatement tương tác với SQL có tham số
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Lưu trữ kết quả truy vấn
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Company company = new Company();
                company.setId(rs.getInt("id"));
                company.setCode(rs.getString("code"));
                company.setName(rs.getString("name"));
                company.setDescription(rs.getString("description"));
                company.setEmail(rs.getString("email"));
                company.setPhoneNumber(rs.getString("phoneNumber"));
                company.setAddress(rs.getString("address"));
                
                companies.add(company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }
    
    // Hàm lấy ra thuộc tính của doanh nghiệp qua id
    public Company getCompanyById(int companyId){
        String sql = "SELECT * FROM tbl_company WHERE tbl_company.id = ?";
        Company company = null;
        try{
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, companyId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                company = new Company();
                company.setId(rs.getInt("id"));
                company.setCode(rs.getString("code"));
                company.setName(rs.getString("name"));
                company.setDescription(rs.getString("description"));
                company.setEmail(rs.getString("email"));
                company.setPhoneNumber(rs.getString("phoneNumber"));
                company.setAddress(rs.getString("address"));
            }
            
            rs.close();
            preparedStatement.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return company;
    }
    
    // Hàm thêm đối tượng
    public void addCompany(Company company){
        String sql = "INSERT INTO tbl_company (code, name, description, email, phoneNumber, address) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, company.getCode());
            preparedStatement.setString(2, company.getName());
            preparedStatement.setString(3, company.getDescription());
            preparedStatement.setString(4, company.getEmail());
            preparedStatement.setString(5, company.getPhoneNumber());
            preparedStatement.setString(6, company.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Hàm sửa đối tượng
    public void updateCompany(Company company, int id) {
        String sql = "UPDATE tbl_company SET code = ?, name = ?, description = ?, email = ?, phoneNumber = ?, address = ? WHERE id = ?";
        
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, company.getCode());
            preparedStatement.setString(2, company.getName());
            preparedStatement.setString(3, company.getDescription());
            preparedStatement.setString(4, company.getEmail());
            preparedStatement.setString(5, company.getPhoneNumber());
            preparedStatement.setString(6, company.getAddress());
            preparedStatement.setInt(7, id);

            System.out.println("Executing SQL query: " + preparedStatement.toString());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Company updated successfully.");
            } else {
                System.out.println("No changes detected. Company not updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Hàm xóa đối tượng qua id
    public void deleteCompanyById(int companyId) {
        String sql = "DELETE FROM tbl_company WHERE id = ?";
        
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, companyId);

            int deletedRows = preparedStatement.executeUpdate();
            System.out.println(deletedRows);
            
            if(deletedRows > 0){
                System.out.println("Company deleted!");
            }else{
                System.out.println("Company delete failed! No matching company with ID: " + companyId);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Hàm lấy ra id khi tham số là các thuộc tính của đối tượng Company
    public int getIdByCompany(String code, 
                              String name, 
                              String description, 
                              String email,
                              String phoneNumber, 
                              String address){
        int companyId = -1;
        String sql = "SELECT tbl_company.id FROM tbl_company WHERE tbl_company.code = ? AND tbl_company.name = ? AND tbl_company.description = ? AND tbl_company.email = ? AND tbl_company.phoneNumber = ? AND tbl_company.address = ?";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql); 
             
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setString(6, address);
            
            // Lưu trữ kết quả truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                companyId = resultSet.getInt("id");
            }
            return companyId;
           
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public int getIdByCompanyName(String name){
        int companyId = -1;
        String sql = "SELECT tbl_company.id FROM tbl_company WHERE tbl_company.name = ?";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql); 
             
            preparedStatement.setString(1, name);
            // Lưu trữ kết quả truy vấn
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                companyId = resultSet.getInt("id");
            }
            return companyId;
           
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
