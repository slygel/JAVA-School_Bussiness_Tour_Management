package services;

import dao.CompanyDao;
import models.*;

import java.util.List;


// Lớp Service: Triển khai và sử lý logic từ lớp DAO
public class CompanyService {
    
    private CompanyDao companyDao;
    
    public CompanyService() {
        companyDao = new CompanyDao();
    }
    
    // GetAll
    public List<Company> getAllCompanies(){
        return companyDao.getAllCompanies();
    }
    
    // GetId
    public int GetIdByCompany(String code, String name, String description, String email, String phoneNumber, String address){
        return companyDao.getIdByCompany(code, name, description, email, phoneNumber, address);
    }
    
    public int getIdByCompanyName(String name){
        return companyDao.getIdByCompanyName(name);
    }
    
    // GetCompany
    public Company getCompanyById(int companyId){
        return companyDao.getCompanyById(companyId);
    }
    
    // Add
    public void addCompany(Company company){
        companyDao.addCompany(company);
    }
    
    // Update
    public void updateCompany(Company company , int id){
        companyDao.updateCompany(company , id);
    }
    
    // Delete 
    public void deleteCompanyById(int companyId) {
        companyDao.deleteCompanyById(companyId);
    }
    
    // Kiểm tra tồn tại mã doanh nghiệp
    public boolean isExistedComCode(String companyCode) {
        List<Company> company_data = companyDao.getAllCompanies();
        for (Company com : company_data) {
            if (com.getCode().trim().equals(companyCode.trim())) {
                return true;
            }
        }
        return false;
    }

    // Kiểm tra tồn tại tên doanh nghiệp
    public boolean isExistedComName(String companyName) {
        List<Company> company_data = companyDao.getAllCompanies();
        for(Company com : company_data){
            if(com.getName().trim().equals(companyName.trim())){
                return true;
            }
        }
        return false;
    }
}
