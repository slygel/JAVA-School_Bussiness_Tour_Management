package models;

import java.util.ArrayList;
import java.util.List;

public class Company {

    public static int count = 0;

    private int id;
    private String code;
    private String name;
    private String description;
    private String email;
    private String phoneNumber;
    private String address;
    private List<Tour> tours;

    public Company() {

    }
    
    public Company( String code, String name, String description, String email, String phone, String address){
        this.code = code;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phoneNumber = phone;
        this.address = address;    
    }
    
    public Company(int id, String code, String name, String description, String email, String phone, String address){
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phoneNumber = phone;
        this.address = address;    
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    @Override
    public String toString() {
        return name;
    }
    
    public String toStringFile() {
        return id + "," + code + "," + name + "," + description + "," + email + "," + phoneNumber + "," + address;
    }

}
