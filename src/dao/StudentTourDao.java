package dao;

import connectdb.JDBCUtil;
import java.sql.*;
import models.*;
import services.*;
import java.util.*;

public class StudentTourDao {
    
    public List<StudentTour> getAllStudentTours(){
        String sql = "SELECT * FROM tbl_student_tour";
        List<StudentTour> studentTours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                StudentTour studentTour = new StudentTour();
                studentTour.setStudentId(rs.getInt("studentId"));
                studentTour.setTourId(rs.getInt("tourId"));
                studentTour.setRate(rs.getInt("rate"));
                studentTours.add(studentTour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentTours;
    }
    
    public List<StudentTour> getAllStudentToursByTourId(int tourId){
        String sql = "SELECT * FROM tbl_student_tour WHERE tourId = ?";
        List<StudentTour> studentTours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                StudentTour studentTour = new StudentTour();
                studentTour.setStudentId(rs.getInt("studentId"));
                studentTour.setTourId(rs.getInt("tourId"));
                studentTour.setRate(rs.getInt("rate"));
                studentTours.add(studentTour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentTours;
    }
    
    public List<StudentTour> getAllStudentToursByStudentId(int studentId){
        String sql = "SELECT * FROM tbl_student_tour WHERE studentId = ?";
        List<StudentTour> studentTours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                StudentTour studentTour = new StudentTour();
                studentTour.setStudentId(rs.getInt("studentId"));
                studentTour.setTourId(rs.getInt("tourId"));
                studentTour.setRate(rs.getInt("rate"));
                studentTours.add(studentTour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentTours;
    }
    
    public void addStudentTour(StudentTour studentTour){
        String sql = "INSERT INTO tbl_student_tour (studentId,tourId,rate) VALUES (?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, studentTour.getStudentId());
            preparedStatement.setInt(2, studentTour.getTourId());
            preparedStatement.setInt(3, studentTour.getRate());
            
            int addRows = preparedStatement.executeUpdate();
            if (addRows > 0) {
                System.out.println("Add StudentTour successful!");
            } else {
                System.out.println("Add StudentTour failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addListStudentTours(List<StudentTour> studentTours){
        String sql = "INSERT INTO tbl_student_tour (studentId,tourId,rate) VALUES (?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            for(StudentTour studentTour : studentTours){
                preparedStatement.setInt(1, studentTour.getStudentId());
                preparedStatement.setInt(2, studentTour.getTourId());
                preparedStatement.setInt(3, studentTour.getRate());
                preparedStatement.addBatch();
            }
            
            int[] addRows = preparedStatement.executeBatch();
            
            // Check the number of rows affected for each batch
            for (int rows : addRows) {
                if (rows > 0) {
                    System.out.println("Add Tour successful!");
                } else {
                    System.out.println("Add Tour failed!");
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateRateStudent(int studentId , int tourId , int rate){
        String sql = "UPDATE tbl_student_tour SET rate = ? WHERE studentId = ? AND tourId = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
          
            preparedStatement.setInt(1, rate);
            preparedStatement.setInt(2, studentId);
            preparedStatement.setInt(3, tourId);
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Teacher updated.");
            }else {
                System.out.println("No changes detected. Teacher not updated.");
            }
        } catch (Exception e) {
        }
    }
    
    public void deleteStudentTour(int studentId , int tourId){
        String sql = "DELETE FROM tbl_student_tour WHERE studentId = ? AND tourId = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, tourId);
            
            int rowDeleted = preparedStatement.executeUpdate();
            if(rowDeleted > 0){
                System.out.println("Tour deleted.");
            }else {
                System.out.println("No changes detected. Tour not deleted.");
            }
        } catch (Exception e) {
        }
    }
    
    public int getNumberOfStudents(int tourId){
        String sql = "SELECT Count(tbl_student_tour.studentId) AS StudentCount FROM tbl_student_tour WHERE tbl_student_tour.tourId = ?";
        int numberOfStudents = -1;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                numberOfStudents = resultSet.getInt("StudentCount");
            }
            
            resultSet.close();
            preparedStatement.close();
            connection.close();
            
            return numberOfStudents;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
