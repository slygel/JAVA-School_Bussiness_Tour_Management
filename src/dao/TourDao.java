package dao;

import connectdb.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Tour;
public class TourDao {
    
    public List<Tour> getAllTours(){
        List<Tour> tours = new ArrayList<>();
        String sql = "SELECT tbl_tour.id, tbl_tour.code, tbl_tour.name, startDate, tbl_tour.description, availables, presentator, tbl_company.id as companyId, tbl_company.name, tbl_teacher.id as teacherId,CONCAT(COALESCE(tbl_teacher.lastName, ''), ' ', COALESCE(tbl_teacher.firstName, '')) AS fullName FROM tbl_tour\n" +
             "JOIN tbl_company ON tbl_company.id = tbl_tour.companyId\n" +
             "LEFT JOIN tbl_teacher ON tbl_teacher.id = tbl_tour.teacherId;";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Tour tour = new Tour();
                tour.setId(rs.getInt("id"));
                tour.setCode(rs.getString("code"));
                tour.setName(rs.getString("name"));
                tour.setStartDate(rs.getString("startDate"));
                tour.setDescription(rs.getString("description"));
                tour.setAvailables(rs.getInt("availables"));
                tour.setPresentator(rs.getString("presentator"));
                tour.setCompanyId(rs.getInt("companyId"));
                tour.setTeacherId(rs.getInt("teacherId"));
                
                tours.add(tour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }
    
    public String getCompanyNameById(int companyId) {
        String companyName = null;
        try {
            String sql = "SELECT tbl_company.name FROM tbl_company WHERE tbl_company.id = ?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, companyId);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                companyName = rs.getString("name");
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companyName;
    }
    
    public String getTeacherNameById(int teacherId) {
        String teacherName = null;
        try {
            String sql = "SELECT CONCAT(COALESCE(tbl_teacher.lastName, ''), ' ', COALESCE(tbl_teacher.firstName, '')) AS fullName FROM tbl_teacher WHERE tbl_teacher.id = ?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, teacherId);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                teacherName = rs.getString("fullName");
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacherName;
    }
    
    public boolean getTeacherIdByTour(int tourId) {
        String sql = "SELECT tbl_teacher.id FROM tbl_teacher JOIN tbl_tour ON tbl_teacher.id = tbl_tour.teacherId WHERE tbl_tour.id = ?";
        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, tourId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSet.getInt("id");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void addTour(Tour tour){
        String sql = "INSERT INTO tbl_tour(code,name,description,startDate,companyId,teacherId,presentator,availables) VALUES(?,?,?,?,?,?,?,?)";
        List<Tour> tours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tour.getCode());
            preparedStatement.setString(2, tour.getName());
            preparedStatement.setString(3, tour.getDescription());
            preparedStatement.setString(4, tour.getStartDate());
            preparedStatement.setInt(5, tour.getCompanyId());
            preparedStatement.setInt(6, tour.getTeacherId());
            preparedStatement.setString(7, tour.getPresentator());
            preparedStatement.setInt(8, tour.getAvailables());
            
            int addRows = preparedStatement.executeUpdate();
            if (addRows > 0) {
                System.out.println("Add Tour successful!");
            } else {
                System.out.println("Add Tour failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateTour(Tour tour, int tourId){
        String sql = "UPDATE tbl_tour SET code=?, name=?, description=?, startDate=?, companyId=?, teacherId=?, presentator=?, availables=? WHERE id=?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tour.getCode());
            preparedStatement.setString(2, tour.getName());
            preparedStatement.setString(3, tour.getDescription());
            preparedStatement.setString(4, tour.getStartDate());
            preparedStatement.setInt(5, tour.getCompanyId());
            preparedStatement.setInt(6, tour.getTeacherId());
            preparedStatement.setString(7, tour.getPresentator());
            preparedStatement.setInt(8, tour.getAvailables());
            preparedStatement.setInt(9, tourId);
            
            System.out.println("SQL: " + preparedStatement.toString());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Tour updated.");
            }else {
                System.out.println("No changes detected. Tour not updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateTeacherIdByTourId(int tourId) {
        String sql = "UPDATE tbl_tour SET teacherId = NULL WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);

            System.out.println("SQL: " + preparedStatement.toString());

            int rowUpdated = preparedStatement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Tour updated.");
            } else {
                System.out.println("No changes detected. Tour not updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTourById(int tourId){
        String sql = "DELETE FROM tbl_tour WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            int rowDeleted = preparedStatement.executeUpdate();
            if(rowDeleted > 0){
                System.out.println("Tour deleted.");
            }else {
                System.out.println("No changes detected. Tour not deleted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int getIdByTourCode(String tourCode){
        String sql = "SELECT id FROM tbl_tour WHERE code = ?";
        int tourId = -1;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, tourCode);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                tourId = rs.getInt("id");
            }
            return tourId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public Tour getTourById(int tourId){
        String sql = "SELECT * FROM tbl_tour WHERE id = ?";
        Tour tour = new Tour();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                tour.setId(rs.getInt("id"));
                tour.setCode(rs.getString("code"));
                tour.setName(rs.getString("name"));
                tour.setDescription(rs.getString("description"));
                tour.setStartDate(rs.getString("startDate"));
                tour.setCompanyId(rs.getInt("companyId"));
                tour.setTeacherId(rs.getInt("teacherId"));
                tour.setPresentator(rs.getString("presentator"));
                tour.setAvailables(rs.getInt("availables"));
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }
    
    public int getTeacherIdByTourId(int tourId){
        int teacherId = -1;
        String sql = "SELECT teacherId from tbl_tour WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                teacherId = rs.getInt("teacherId");
            }
            return teacherId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public int getCompanyIdByTourId(int tourId){
        int companyId = -1;
        String sql = "SELECT tbl_tour.companyId from tbl_tour WHERE tbl_tour.id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                companyId = rs.getInt("companyId");
            }
            return companyId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void addListTours(List<Tour> tourData) {
        String sql = "INSERT INTO tbl_tour(code,name,description,startDate,companyId,teacherId,presentator,availables) VALUES(?,?,?,?,?,?,?,?)";
        List<Tour> tours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(Tour tour : tourData){
                preparedStatement.setString(1, tour.getCode());
                preparedStatement.setString(2, tour.getName());
                preparedStatement.setString(3, tour.getDescription());
                preparedStatement.setString(4, tour.getStartDate());
                preparedStatement.setInt(5, tour.getCompanyId());
                preparedStatement.setInt(6, tour.getTeacherId());
                preparedStatement.setString(7, tour.getPresentator());
                preparedStatement.setInt(8, tour.getAvailables());
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
    
    public List<Tour> getToursByStudentId(int studentId){
        String sql = "SELECT tbl_tour.id,tbl_tour.code,tbl_tour.name,tbl_tour.description,tbl_tour.startDate,tbl_tour.companyId,tbl_tour.teacherId,tbl_tour.presentator,tbl_tour.availables \n" +
                    "FROM tbl_tour JOIN tbl_student_tour ON tbl_student_tour.tourId = tbl_tour.id JOIN tbl_student ON tbl_student.id = tbl_student_tour.studentId\n" +
                    "WHERE tbl_student.id = ?";
        List<Tour> tours = new ArrayList<>();
        
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setCompanyId(resultSet.getInt("companyId"));
                tour.setTeacherId(resultSet.getInt("teacherId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));

                tours.add(tour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }
    
    public List<Tour> getToursByCompanyId(int companyId){
        String sql = "SELECT * FROM tbl_tour WHERE tbl_tour.companyId = ?";
        List<Tour> tours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, companyId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setCompanyId(resultSet.getInt("companyId"));
                tour.setTeacherId(resultSet.getInt("teacherId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));

                tours.add(tour);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }
    
    public List<Tour> getToursByTeacherId(int teacherId){
        String sql = "SELECT * FROM tbl_tour WHERE tbl_tour.teacherId = ?";
        List<Tour> tours = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, teacherId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setCompanyId(resultSet.getInt("companyId"));
                tour.setTeacherId(resultSet.getInt("teacherId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));

                tours.add(tour);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tours;
    }
    
    public Tour getTourByTeacherId(int teacherId){
        String sql = "SELECT * FROM tbl_tour WHERE tbl_tour.teacherId = ?";
        Tour tour = new Tour();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, teacherId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setCompanyId(resultSet.getInt("companyId"));
                tour.setTeacherId(resultSet.getInt("teacherId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }
    
    public Tour getTourByStudentId(int studentId){
        String sql = "SELECT tbl_tour.id,tbl_tour.code,tbl_tour.name,tbl_tour.description,tbl_tour.startDate,tbl_tour.companyId,tbl_tour.teacherId,tbl_tour.presentator,tbl_tour.availables \n" +
                    "FROM tbl_tour JOIN tbl_student_tour ON tbl_student_tour.tourId = tbl_tour.id JOIN tbl_student ON tbl_student.id = tbl_student_tour.studentId\n" +
                    "WHERE tbl_student.id = ?";
        Tour tour = new Tour();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                tour.setId(resultSet.getInt("id"));
                tour.setCode(resultSet.getString("code"));
                tour.setName(resultSet.getString("name"));
                tour.setDescription(resultSet.getString("description"));
                tour.setStartDate(resultSet.getString("startDate"));
                tour.setCompanyId(resultSet.getInt("companyId"));
                tour.setTeacherId(resultSet.getInt("teacherId"));
                tour.setPresentator(resultSet.getString("presentator"));
                tour.setAvailables(resultSet.getInt("availables"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tour;
    }
    
    public void deleteTourOfTeacher(List<Tour> tours){
        String sql = "UPDATE tbl_tour SET teacherId = NULL WHERE code = ? AND teacherId = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        } catch (Exception e) {
        }
    }
}
