package dao;

import java.sql.Connection;
import connectdb.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.*;

public class TeacherDao {
    
    public List<Teacher> getAllTeachers(){
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT tbl_teacher.id, tbl_teacher.code, tbl_teacher.firstName, tbl_teacher.lastName, tbl_teacher.address, tbl_teacher.phoneNumber, tbl_teacher.email, tbl_teacher.birthDate, \n" +
                      "COUNT(tbl_tour.id) AS tourCount FROM tbl_teacher LEFT JOIN tbl_tour ON tbl_teacher.id = tbl_tour.teacherId\n" +
                        "GROUP BY tbl_teacher.id";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setCode(rs.getString("code"));                
                teacher.setFirstName(rs.getString("firstName"));
                teacher.setLastName(rs.getString("lastName"));
                teacher.setAddress(rs.getString("address"));
                teacher.setPhoneNumber(rs.getString("phoneNumber"));
                teacher.setEmail(rs.getString("email"));
                teacher.setBirthDate(rs.getString("birthDate"));
                int tourCount = rs.getInt("tourCount");
                
                // Create a new list of tours
                List<Tour> tours = new ArrayList<>();
                for (int i = 0; i < tourCount; i++) {
                    Tour tour = new Tour();
                    tours.add(tour);
                }
                teacher.setTours(tours);
                
                teachers.add(teacher);
            }
            
        } catch (SQLException e) {
        }
        return teachers;
    }
    
    public void addTeacher(Teacher teacher){
        String sql = "INSERT INTO tbl_teacher (id,code,firstName,lastName,birthDate,address,phoneNumber,imagePath,email,accountId) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getCode());
            preparedStatement.setString(3, teacher.getFirstName());
            preparedStatement.setString(4, teacher.getLastName());
            preparedStatement.setString(5, teacher.getBirthDate());
            preparedStatement.setString(6, teacher.getAddress());
            preparedStatement.setString(7, teacher.getPhoneNumber());
            preparedStatement.setString(8, teacher.getImagePath());
            preparedStatement.setString(9, teacher.getEmail());
            preparedStatement.setInt(10, teacher.getAccountId());
            
            int addRows = preparedStatement.executeUpdate();
            if (addRows > 0) {
                System.out.println("Add Teacher successful!");
            } else {
                System.out.println("Add Teacher failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getIdByTeacher(String teacherCode){
        String sql = "SELECT id from tbl_teacher WHERE code = ?";
        int teacherId = -1;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, teacherCode);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                teacherId = rs.getInt("id");
            }
            
            return teacherId;
        } catch (Exception e) {
            return -1;
        }
    }
    
    public int getIdByTeacherName(String name){
        int companyId = -1;
        String sql = "SELECT id \n" +
                    "FROM tbl_teacher \n" +
                    "WHERE CONCAT(COALESCE(tbl_teacher.lastName, ''), ' ', COALESCE(tbl_teacher.firstName, '')) = ?";
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
    
    public Teacher getTeacherById(int teacherId){
        String sql = "SELECT id,code,firstName,lastName,birthDate,address,phoneNumber,imagePath,email,accountId FROM tbl_teacher WHERE id = ?";
        Teacher teacher = new Teacher();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, teacherId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                teacher.setId(rs.getInt("id"));
                teacher.setCode(rs.getString("code"));
                teacher.setFirstName(rs.getString("firstName"));
                teacher.setLastName(rs.getString("lastName"));
                teacher.setBirthDate(rs.getString("birthDate"));
                teacher.setAddress(rs.getString("address"));
                teacher.setPhoneNumber(rs.getString("phoneNumber"));
                teacher.setImagePath(rs.getString("imagePath"));
                teacher.setEmail(rs.getString("email"));
                teacher.setAccountId(rs.getInt("accountId"));
            }
            
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacher;
    }
    
    public void updateTeacher(Teacher teacher , int teacherId){
        String sql = "UPDATE tbl_teacher SET "
                + "code = ? , "
                + "firstName = ? , "
                + "lastName = ?, "
                + "birthDate = ? , "
                + "address = ? , "
                + "phoneNumber = ? , "
                + "imagePath = ? , "
                + "email = ? , "
                + "accountId = ? "
                + "WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, teacher.getCode());
            preparedStatement.setString(2, teacher.getFirstName());
            preparedStatement.setString(3, teacher.getLastName());
            preparedStatement.setString(4, teacher.getBirthDate());
            preparedStatement.setString(5, teacher.getAddress());
            preparedStatement.setString(6, teacher.getPhoneNumber());
            preparedStatement.setString(7, teacher.getImagePath());
            preparedStatement.setString(8, teacher.getEmail());
            preparedStatement.setInt(9, teacher.getAccountId());
            preparedStatement.setInt(10, teacherId);
            
            System.out.println("SQL: " + preparedStatement.toString());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Teacher updated.");
            }else {
                System.out.println("No changes detected. Teacher not updated.");
            }
        } catch (Exception e) {
        }
    }
    
    public void deleteTeacherById(int teacherId){
        String sql = "DELETE FROM tbl_teacher WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, teacherId);
            
            int rowDeleted = preparedStatement.executeUpdate();
            if(rowDeleted > 0){
                System.out.println("Teacher deleted.");
            }else {
                System.out.println("No changes detected. Teacher not deleted.");
            }
        } catch (Exception e) {
        }
    }
    
    public Teacher getTeacherByAccountId(int accountId){
        String sql = "SELECT * FROM tbl_teacher WHERE accountId = ?";
        Teacher teacher = new Teacher();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                teacher.setId(rs.getInt("id"));
                teacher.setCode(rs.getString("code"));
                teacher.setFirstName(rs.getString("firstName"));
                teacher.setLastName(rs.getString("lastName"));
                teacher.setBirthDate(rs.getString("birthDate"));
                teacher.setAddress(rs.getString("address"));
                teacher.setPhoneNumber(rs.getString("phoneNumber"));
                teacher.setImagePath(rs.getString("imagePath"));
                teacher.setEmail(rs.getString("email"));
                teacher.setAccountId(rs.getInt("accountId"));
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
        return teacher;
    }
}