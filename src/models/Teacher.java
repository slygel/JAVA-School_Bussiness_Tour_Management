package models;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    
    private List<Tour> tours = new ArrayList<>();
    private String imagePath;
    private int accountId;
    public Teacher() {
    }

    public Teacher( int id,String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int accountID) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.imagePath = imagePath;
        this.accountId = accountID;
    }
    
    public Teacher(String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int accountID) {
        super(code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.imagePath = imagePath;
        this.accountId = accountID;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    
    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }

    public String toStringFile() {
        return id + "," + code + "," + firstName + "," + lastName + "," + address + "," + phoneNumber + "," + email + "," + getBirthDate() ;
    }
}
