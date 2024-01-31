package dao;

import connectdb.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Classroom;

public class ClassroomDao {
    
    public List<Classroom> getAllClassrooms(){
        List<Classroom> classrooms = new ArrayList<>();
        String sql = "SELECT * FROM tbl_class";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Classroom classroom = new Classroom();
                classroom.setCode(rs.getString("code"));
                classroom.setName(rs.getString("name"));
                classrooms.add(classroom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classrooms;
    }
    
    public int getIdByClassroom(String code, String name){
        int classId = -1;
        String sql = "SELECT tbl_class.id FROM tbl_class WHERE code = ? AND name = ?";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, name);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                classId = rs.getInt("id");
            }
            
            return classId;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public Classroom getClassroomById(int classId){
        String sql = "SELECT id,code,name FROM tbl_class WHERE id = ?";
        Classroom classroom = new Classroom();
        try{
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, classId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                classroom.setId(rs.getInt("id"));
                classroom.setCode(rs.getString("code"));
                classroom.setName(rs.getString("name"));
            }
            
            rs.close();
            preparedStatement.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return classroom;
    }
    
    public Classroom getClassNameById(int classId){
        String sql = "SELECT name FROM tbl_class WHERE id = ?";
        Classroom classroom = new Classroom();
        try{
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, classId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                classroom.setName(rs.getString("name"));
            }
            
            rs.close();
            preparedStatement.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return classroom;
    }
    
    public void addClassroom(Classroom classroom){
        String sql = "INSERT INTO tbl_class(code,name) VALUES(?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,classroom.getCode());
            preparedStatement.setString(2, classroom.getName());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateClassroom(Classroom classroom , int classId){
        String sql = "UPDATE tbl_class SET code = ? , name = ? WHERE id = ?";
        
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, classroom.getCode());
            preparedStatement.setString(2, classroom.getName());
            preparedStatement.setInt(3, classId);
            
            System.out.println("SQL: " + preparedStatement.toString());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Classroom updated.");
            }else {
                System.out.println("No changes detected. Classroom not updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteClassroom(int classId) {
        String sql = "DELETE FROM tbl_class WHERE id = ?";
        
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, classId);
            
            int deleteRow = preparedStatement.executeUpdate();
            if(deleteRow > 0){
                System.out.println("Classroom deleted!");
            }else{
                System.out.println("Classroom delete failed!");
            }
        } catch (Exception e) {
        }
    }

    public int getClassIdByClassName(Classroom classroom) {
        int classId = -1;
        String sql = "SELECT id from tbl_class WHERE name = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, classroom.getName());
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                classId = rs.getInt("id");
            }
            return classId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
