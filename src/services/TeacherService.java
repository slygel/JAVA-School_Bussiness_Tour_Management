package services;

import dao.AccountDao;
import models.Teacher;
import java.util.*;
import dao.TeacherDao;
import exception.*;
import static exception.Validator.formatName;
import models.Account;

public class TeacherService {
    
    private TeacherDao teacherDao;
    private AccountDao accountDao;
    
    public  TeacherService(){
        teacherDao = new TeacherDao();
        accountDao = new AccountDao();
    }
    public List<Teacher> getAllTeachers(){
        return teacherDao.getAllTeachers();
    }
    
    public void addTeacher(Teacher teacher){
        teacherDao.addTeacher(teacher);
    }
    
    public int getIdByTeacher(String teacherCode){
        return teacherDao.getIdByTeacher(teacherCode);
    }
    
    public int getIdByTeacherName(String name){
        return teacherDao.getIdByTeacherName(name);
    }
    
    public Teacher getTeacherById(int teacherId){
        return teacherDao.getTeacherById(teacherId);
    }
    
    public void updateTeacher(Teacher teacher , int teacherId){
        teacherDao.updateTeacher(teacher, teacherId);
    }
    
    public void deleteTeacherById(int teacherId){
        teacherDao.deleteTeacherById(teacherId);
    }
    
    public int getLastAccountId() throws Exception {
        List<Account> data = accountDao.getAllAcounts();
        if (data != null) {
            if (data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }
    
    public int getLastTeacherId() throws Exception {
        List<Teacher> data = teacherDao.getAllTeachers();
        if (data != null) {
            if (data.size() == 0) {
                return 0;
            }
            return data.get(data.size() - 1).getId();
        }
        return -1;
    }
    
    public static String LastName(String name) {
        String[] splitName = formatName(name).split(" ");
        String lastName = "";
        for (int i = 0; i < splitName.length - 1; i++) {
            lastName += (splitName[i] + " ");
        }
        return lastName.trim();
    }

    public static String FirstName(String name) {
        String[] splitName = formatName(name).split(" ");
        return splitName[splitName.length - 1].trim();
    }
    
    public boolean isCheckCodeTeacher(String newCode) throws Exception {
        List<Teacher> teachers = teacherDao.getAllTeachers();
        for (Teacher next : teachers) {
            if (next.getCode().equalsIgnoreCase(newCode)) {
                return true;
            }
        }
        return false;
    }
    
    public Teacher getTeacherByAccountId(int accountId){
        return teacherDao.getTeacherByAccountId(accountId);
    }
    
}
