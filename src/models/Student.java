package models;

import java.awt.image.BufferedImage;
import java.util.List;

public class Student extends Person {

    private String imagePath;
    private List<StudentTour> studentTours;
    private int classId;
    private int accountId;

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(int id, String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int classId) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.classId = classId;
        this.imagePath = imagePath;
    }

    public Student(int id, String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate,int accountId, int classId) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.accountId = accountId;
        this.imagePath = imagePath;
        this.classId = classId;
    }
    
    public Student(String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int classId) {
        super(code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.classId = classId;
        this.imagePath = imagePath;
    }

    public Student(int id, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, List<StudentTour> studentTours, int classId) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.studentTours = studentTours;
        this.classId = classId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<StudentTour> getStudentTours() {
        return studentTours;
    }

    public void setStudentTours(List<StudentTour> studentTours) {
        this.studentTours = studentTours;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return id + "," + code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + birthDate + "," + studentTours + "," + classId;
    }

    public String toStringFile() {
        return id + "," + code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + birthDate + "," + classId;

    }

}
