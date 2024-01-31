package services;

import dao.StudentDao;
import java.util.List;
import models.Student;

public class StudentService {
    
    public StudentDao studentDao;
    
    public StudentService(){
        studentDao = new StudentDao();
    }
    
    public List<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }
    
    public String getStudentClassNameById(int classId){
        return studentDao.getStudentClassNameById(classId);
    }
    
    public int getIdByStudent(String studentCode){
        return studentDao.getIdByStudent(studentCode);
    }
    
    public Student getStudentById(int studentId){
        return studentDao.getStudentById(studentId);
    }
    
    public void addStudent(Student student){
        studentDao.addStudent(student);
    }
    
    public void addListStudents(List<Student> students) {
        studentDao.addListStudents(students);
    }
    
    public void updateStudent(Student student , int studentId){
        studentDao.updateStudent(student, studentId);
    }
    
    public void deleteStudentById(int studentId){
        studentDao.deleteStudentById(studentId);
    }
    
    public boolean isExistedStudentCode(String studentCode) throws Exception{
        List<Student> students_data = studentDao.getAllStudents();
        for(Student student : students_data){
            if(student.getCode().equalsIgnoreCase(studentCode)){
                return true;
            }
        }
        return false;
    }
    
    public int getClassIdByStudentId(int studentId){
        return studentDao.getClassIdByStudentId(studentId);
    }

    public Student getStudentByAccountId(int accountId) throws Exception {
        return studentDao.getStudentByAccountId(accountId);
    }
    
    public Student getStudentByStudentCode(String studentCode){
        return studentDao.getStudentByStudentCode(studentCode);
    }
    
    public List<Student> getStudentsByTourId(int tourId){
        return studentDao.getStudentsByTourId(tourId);
    }
    
    public List<Student> getStudentsByClassId(int classId){
        return studentDao.getStudentsByClassId(classId);
    }
}
