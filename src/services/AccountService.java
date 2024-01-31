package services;

import dao.AccountDao;
import java.util.List;
import models.Account;
import models.Classroom;

public class AccountService {
    
    public static Account currentLoginUser;
    private AccountDao accountDao;
    
    public AccountService(){
        accountDao = new AccountDao();
    }
    
    //Get all
    public List<Account> getAllAccounts(){
        return accountDao.getAllAcounts();
    }
    
    // Add
    public void addAccount(Account account){
        accountDao.addAccount(account);
    }
    
    // Add teacher account
    public void addTeacherAccount(String username, String password, String role){
        accountDao.addTeacherAccount(username, password, role);
    }
    
    // Add student account
    public void addStudentAccount(String username, String password, String role){
        accountDao.addStudentAccount(username, password, role);
    }
    
    public int getLastIdFromAccount(){
        return accountDao.getLastIdFromAccount();
    }
    
    public boolean isExisted(Account account) throws Exception {
        List<Account> data = accountDao.getAllAcounts();
        for (Account acc : data) {
            if (acc.getUsername().equals(account.getUsername()) && acc.getPassword().equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isExistedUsername(String username){
        List<Account> account_data = accountDao.getAllAcounts();
        for(Account account : account_data){
            if(account.getUsername().equals(username.trim())){
                return true;
            }
        }
        return false;
    }
    
    public Account getAccountByUsername(String username) throws Exception {
        return accountDao.getAccountByUsername(username);
    }
    
    public int getIdByAccount(String username , String password , String role){
        return accountDao.getIdByAccount(username, password, role);
    }
    
    public Account getAccountById(int accountId){
        return accountDao.getAccountById(accountId);
    }

    public void updateAccount(Account account, int accountId) {
        accountDao.updateAccount(account,accountId);
    }
    
    public void deleteAccountById(int accountId){
        accountDao.deleteAccountById(accountId);
    }
}
