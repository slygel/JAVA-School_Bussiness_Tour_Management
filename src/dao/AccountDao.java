package dao;

import connectdb.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Account;
import models.Classroom;

public class AccountDao {
    
    public List<Account> getAllAcounts(){
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM tbl_account";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
                
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    
    // Add account
    public void addAccount(Account account){
        String sql = "INSERT INTO tbl_account (username,password,role) VALUES (?,?,?)";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getRole());
            
            int addRows = preparedStatement.executeUpdate();
            if(addRows > 0){
                System.out.println("Add successful!");
            }else{
                System.out.println("Add false!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Add teacher account
    public void addTeacherAccount(String username, String password, String role){
        String sql = "INSERT INTO tbl_account (id,username,password,role) VALUES (?,?,?,?)";
        try {
            Account account = new Account(username, password, role);
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getRole());
            
            int addRows = preparedStatement.executeUpdate();
            if(addRows > 0){
                System.out.println("Add account teacher successful!");
            }else{
                System.out.println("Add account teacher false!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Add student account
    public void addStudentAccount(String username, String password, String role){
        String sql = "INSERT INTO tbl_account (id,username,password,role) VALUES (?,?,?,?)";
        try {
            Account account = new Account(username, password, role);
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getRole());
            
            int addRows = preparedStatement.executeUpdate();
            if(addRows > 0){
                System.out.println("Add account student successful!");
            }else{
                System.out.println("Add account student false!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getIdByAccount(String username , String password , String role){
        int accountId = -1;
        String sql = "SELECT id FROM tbl_account WHERE username = ? AND password = ? AND role = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, role);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                accountId = rs.getInt("id");
            }
            return accountId;
        } catch (Exception e) {
            return -1;
        }
    }
    
    public int getLastIdFromAccount(){
        String sql = "SELECT id from tbl_account order by id DESC LIMIT 1";
        int lastId = -1;
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next()){
                lastId = rs.getInt("id");
            }
            
            rs.close();
            preparedStatement.close();
            connection.close();
            
            return lastId;
        } catch (SQLException e) {
            return -1;
        }
    }
    
    public Account getAccountById(int accountId){
        String sql = "SELECT id,username,password,role FROM tbl_account WHERE id = ?";
        Account account = new Account();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
            }
            
            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public void updateAccount(Account account, int accountId) {
        String sql = "UPDATE tbl_account SET username = ? , password = ? , role = ? WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getRole());
            preparedStatement.setInt(4, accountId);
            
            System.out.println("SQL: " + preparedStatement.toString());
            
            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated > 0){
                System.out.println("Account updated.");
            }else {
                System.out.println("No changes detected. Account not updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteAccountById(int accountId){
        String sql = "DELETE FROM tbl_account WHERE id = ?";
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            
            int deleteRow = preparedStatement.executeUpdate();
            if(deleteRow > 0){
                System.out.println("Account deleted!");
            }else{
                System.out.println("Account delete failed!");
            }
        } catch (Exception e) {
        }
    }
    
    public Account getAccountByUsername(String username){
        String sql = "SELECT * from tbl_account WHERE username = ?";
        Account account = new Account();
        try {
            Connection connection = JDBCUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getString("role"));
            }
            rs.close();
            preparedStatement.close();
            connection.close();
            return account;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }
}
