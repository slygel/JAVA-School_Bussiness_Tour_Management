package dao;

import connectdb.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import models.Student;

public class StudentDao {
    
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM tbl_student";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setCode(rs.getString("code"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                student.setEmail(rs.getString("email"));
                student.setBirthDate(rs.getString("birthDate"));
                student.setAccountId(rs.getInt("accountId"));
                student.setClassId(rs.getInt("classId"));
                students.add(student);
            }
            
        } catch (Exception e) {
        }
        return students;
    }
    
    public String getStudentClassNameById(int classId) {
        String className = null;
        try {
            String sql = "SELECT tbl_class.name FROM tbl_class WHERE tbl_class.id = ?";
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, classId);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                className = rs.getString("name");
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return className;
    }
    
    public int getIdByStudent(String studentCode){
        String sql = "SELECT id from tbl_student WHERE code = ?";
        int studentId = -1;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, studentCode);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                studentId = rs.getInt("id");
            }
            return studentId;
        } catch (Exception e) {
            return -1;
        }
    }
    
    public Student getStudentById(int studentId){
        String sql = "SELECT * FROM tbl_student WHERE id = ?";
        Student student = new Student();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                student.setId(rs.getInt("id"));
                student.setCode(rs.getString("code"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setBirthDate(rs.getString("birthDate"));
                student.setAddress(rs.getString("address"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                student.setImagePath(rs.getString("imagePath"));
                student.setEmail(rs.getString("email"));
                student.setAccountId(rs.getInt("accountId"));
                student.setClassId(rs.getInt("classId"));
            }
            
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
    
    public void addStudent(Student student){
        String sql = "INSERT INTO tbl_student (id,code,firstName,lastName,birthDate,address,phoneNumber,email,imagePath,accountId,classId) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getCode());
            preparedStatement.setString(3, student.getFirstName());
            preparedStatement.setString(4, student.getLastName());
            preparedStatement.setString(5, student.getBirthDate());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setString(7, student.getPhoneNumber());
            preparedStatement.setString(8, student.getEmail());
            preparedStatement.setString(9, student.getImagePath());
            preparedStatement.setInt(10, student.getAccountId());
            preparedStatement.setInt(11, student.getClassId());
            
            int addRows = preparedStatement.executeUpdate();
            if (addRows > 0) {
                System.out.println("Add Student successful!");
            } else {
                System.out.println("Add Student failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addListStudents(List<Student> students) {
        String sql = "INSERT INTO tbl_student (id, code, firstName, lastName, birthDate, address, phoneNumber, email, imagePath, accountId, classId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (Student student : students) {
                preparedStatement.setInt(1, student.getId());
                preparedStatement.setString(2, student.getCode());
                preparedStatement.setString(3, student.getFirstName());
                preparedStatement.setString(4, student.getLastName());
                preparedStatement.setString(5, student.getBirthDate());
                preparedStatement.setString(6, student.getAddress());
                preparedStatement.setString(7, student.getPhoneNumber());
                preparedStatement.setString(8, student.getEmail());

                // Ensure 'imagePath' is set to null if it is null in the Student object
                if (student.getImagePath() != null) {
                    preparedStatement.setString(9, student.getImagePath());
                } else {
                    preparedStatement.setNull(9, Types.VARCHAR);
                }

                preparedStatement.setInt(10, student.getAccountId());
                preparedStatement.setInt(11, student.getClassId());
                preparedStatement.addBatch();
            }

            int[] addRows = preparedStatement.executeBatch();

            // Check the number of rows affected for each batch
            for (int rows : addRows) {
                if (rows > 0) {
                    System.out.println("Add Student successful!");
                } else {
                    System.out.println("Add Student failed!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateStudent(Student student , int studentId){
        String sql = "UPDATE tbl_student SET "
                + "code = ? , "
                + "firstName = ? , "
                + "lastName = ?, "
                + "birthDate = ? , "
                + "address = ? , "
                + "phoneNumber = ? , "
                + "imagePath = ? , "
                + "email = ? , "
                + "accountId = ?,"
                + "classId = ? "
                + "WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, student.getCode());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getBirthDate());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getPhoneNumber());
            preparedStatement.setString(7, student.getImagePath());
            preparedStatement.setString(8, student.getEmail());
            preparedStatement.setInt(9, student.getAccountId());
            preparedStatement.setInt(10, student.getClassId());
            preparedStatement.setInt(11, studentId);
            
            System.out.println("SQL: " + preparedStatement.toString());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Student updated.");
            }else {
                System.out.println("No changes detected. Student not updated.");
            }
        } catch (Exception e) {
        }
    }
    
    public void deleteStudentById(int studentId){
        String sql = "DELETE FROM tbl_student WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            
            int rowDeleted = preparedStatement.executeUpdate();
            if(rowDeleted > 0){
                System.out.println("Student deleted.");
            }else {
                System.out.println("No changes detected. Student not deleted.");
            }
        } catch (Exception e) {
        }
    }

    public int getClassIdByStudentId(int studentId) {
        int classId = -1;
        String sql = "SELECT classId from tbl_student WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, studentId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                classId = rs.getInt("classId");
            }
            return classId;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public Student getStudentByAccountId(int accountId){
        String sql = "SELECT * FROM tbl_student WHERE accountId = ?";
        Student student = new Student();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                student.setId(rs.getInt("id"));
                student.setCode(rs.getString("code"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setBirthDate(rs.getString("birthDate"));
                student.setAddress(rs.getString("address"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                student.setImagePath(rs.getString("imagePath"));
                student.setEmail(rs.getString("email"));
                student.setAccountId(rs.getInt("accountId"));
                student.setClassId(rs.getInt("classId"));
            }
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
    
    public Student getStudentByStudentCode(String studentCode) {
        String sql = "SELECT * FROM tbl_student WHERE code = ?";
        Student student = null;  // Initialize to null
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentCode);

            ResultSet rs = preparedStatement.executeQuery();

            // Check if there is at least one row in the result set
            if (rs.next()) {
                student = new Student();  // Initialize only if there are results

                student.setId(rs.getInt("id"));
                student.setCode(rs.getString("code"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setBirthDate(rs.getString("birthDate"));
                student.setAddress(rs.getString("address"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                student.setImagePath(rs.getString("imagePath"));
                student.setEmail(rs.getString("email"));
                student.setAccountId(rs.getInt("accountId"));
                student.setClassId(rs.getInt("classId"));
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
    
    public List<Student> getStudentsByTourId(int tourId){
        String sql = "SELECT tbl_student.id , code,firstName,lastName,birthDate,address,phoneNumber,email,imagePath,classId\n" +
                     "from tbl_student JOIN tbl_student_tour ON tbl_student.id = tbl_student_tour.studentId WHERE tbl_student_tour.tourId = ?";
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, tourId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setCode(rs.getString("code"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                student.setEmail(rs.getString("email"));
                student.setBirthDate(rs.getString("birthDate"));
//                student.setAccountId(rs.getInt("accountId"));
                student.setClassId(rs.getInt("classId"));
                student.setImagePath(rs.getString("imagePath"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public List<Student> getStudentsByClassId(int classId){
        String sql = "SELECT * FROM tbl_student WHERE tbl_student.classId = ? ";
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, classId);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setCode(rs.getString("code"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                student.setEmail(rs.getString("email"));
                student.setBirthDate(rs.getString("birthDate"));
                student.setAccountId(rs.getInt("accountId"));
                student.setClassId(rs.getInt("classId"));
                student.setImagePath(rs.getString("imagePath"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
