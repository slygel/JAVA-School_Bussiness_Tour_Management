package services;

import dao.StudentTourDao;
import java.util.List;
import models.StudentTour;

public class StudentTourService {
    
    private StudentTourDao studentTourDao;
    
    public StudentTourService(){
        studentTourDao = new StudentTourDao();
    }
    
    public List<StudentTour> getAllStudentTours(){
        return studentTourDao.getAllStudentTours();
    }
    
    public List<StudentTour> getAllStudentToursByTourId(int tourId){
        return studentTourDao.getAllStudentToursByTourId(tourId);
    }
    
    public List<StudentTour> getAllStudentToursByStudentId(int studentId){
        return studentTourDao.getAllStudentToursByStudentId(studentId);
    }
    
    public StudentTour geStudentTourByStudentId(int studentId){
        return studentTourDao.geStudentTourByStudentId(studentId);
    }
    
    public void addStudentTour(StudentTour studentTour){
        studentTourDao.addStudentTour(studentTour);
    }
    
    public void addListStudentTours(List<StudentTour> studentTours){
        studentTourDao.addListStudentTours(studentTours);
    }
    
    public void updateRateStudent(int studentId , int tourId , int rate){
        studentTourDao.updateRateStudent(studentId, tourId, rate);
    }
    
    public void deleteStudentTour(int studentId , int tourId){
        studentTourDao.deleteStudentTour(studentId, tourId);
    }
    
    public int getNumberOfStudents(int tourId){
        return studentTourDao.getNumberOfStudents(tourId);
    }
}
