package services;

import dao.ClassroomDao;
import java.util.List;
import models.Classroom;

public class ClassroomService {
    
    private ClassroomDao classroomDao;
    
    public ClassroomService(){
        classroomDao = new ClassroomDao();
    }
    
    public List<Classroom> getAllClassroom(){
        return classroomDao.getAllClassrooms();
    }
    
    public int getIdByClassroom(String code , String name){
        return classroomDao.getIdByClassroom(code, name);
    }
    
    public Classroom getClassroomById(int classId){
        return classroomDao.getClassroomById(classId);
    }
    
    public void addClassroom(Classroom classroom){
        classroomDao.addClassroom(classroom);
    }
    
    public boolean isExistedClassCode(String classroomId) {
        List<Classroom> classroom_data = classroomDao.getAllClassrooms();
        for (Classroom cls : classroom_data) {
            if (cls.getCode().trim().equals(classroomId.trim())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isExistedClassName(String classroomName) {
        List<Classroom> classroom_data = classroomDao.getAllClassrooms();
        for (Classroom cls : classroom_data) {
            if (cls.getName().trim().equals(classroomName.trim())) {
                return true;
            }
        }
        return false;
    }
    
    public void updateClassroom(Classroom classroom , int classId){
        classroomDao.updateClassroom(classroom, classId);
    }

    public void deleteClassroom(int classId) {
        classroomDao.deleteClassroom(classId);
    }

    public int getClassIdByClassName(Classroom classroom) {
        return classroomDao.getClassIdByClassName(classroom);
    }
    
    public Classroom getClassNameById(int classId){
        return classroomDao.getClassNameById(classId);
    }
    
    
}
