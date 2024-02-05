package services;

import dao.*;
import java.util.List;
import models.Tour;

public class TourService {
    
    private TourDao tourDao;
    private CompanyDao companyDao;
    
    public TourService(){
        tourDao = new TourDao();
    }
    
    public List<Tour> getAllTours(){
        return tourDao.getAllTours();
    }
    
    public String getCompanyNameById(int companyId){
        return tourDao.getCompanyNameById(companyId);
    }
    
    public String getTeacherNameById(int teacherId){
        return tourDao.getTeacherNameById(teacherId);
    }
    
    public boolean getTeacherIdByTour(int tourId){
        return tourDao.getTeacherIdByTour(tourId);
    }
    
    public void addTour(Tour tour){
        tourDao.addTour(tour);
    }
    
    public void updateTour(Tour tour, int tourId){
        tourDao.updateTour(tour, tourId);
    }
    
    public void updateTeacherIdByTourId(int tourId){
        tourDao.updateTeacherIdByTourId(tourId);
    }
    
    public void deleteTourById(int tourId){
        tourDao.deleteTourById(tourId);
    }
    
    public int getIdByTourCode(String tourCode){
        return tourDao.getIdByTourCode(tourCode);
    } 
    
    public Tour getTourById(int tourId){
        return tourDao.getTourById(tourId);
    }
    
    public boolean isExistedTourCode(String code) throws Exception{
        List<Tour> tour_data = tourDao.getAllTours();
        for(Tour tour : tour_data){
            if(tour.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }
    
    public int getTeacherIdByTourId(int tourId){
        return tourDao.getTeacherIdByTourId(tourId);
    }
    
    public int getCompanyIdByTourId(int tourId){
        return tourDao.getCompanyIdByTourId(tourId);
    }

    public void addListTours(List<Tour> tourData) {
        tourDao.addListTours(tourData);
    }
    
    public List<Tour> getToursByStudentId(int studentId){
        return tourDao.getToursByStudentId(studentId);
    }
    
    public List<Tour> getToursByCompanyId(int companyId){
        return tourDao.getToursByCompanyId(companyId);
    }
    
    public List<Tour> getToursByTeacherId(int teacherId){
        return tourDao.getToursByTeacherId(teacherId);
    }
    
    public Tour getTourByTeacherId(int teacherId){
        return tourDao.getTourByTeacherId(teacherId);
    }
    
    public Tour getTourByStudentId(int studentId){
        return tourDao.getTourByStudentId(studentId);
    }
}
