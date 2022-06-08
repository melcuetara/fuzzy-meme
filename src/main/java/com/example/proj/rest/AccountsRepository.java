package com.example.proj.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.example.proj.model.Account;

public class AccountsRepository {
    private static Map<String, Account> map = new HashMap<String, Account>();
   
    public AccountsRepository(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/sampledb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "meljamaica");

            if (connection != null) {
                String sql = "SELECT * FROM accounts";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();
                int key = 1;
                while(rs.next()){  
                    map.put("" + key, new Account(rs.getString(2), rs.getString(3), rs.getInt(4)));
                    key++;
                }
            } 
         } catch (Exception e) {

         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }  
    }
    public Map<String, Account> findAllAccounts(){
        return map;
    }

    public void save(Account account) {
        Connection connection = null;
        Statement statement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/sampledb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "meljamaica");

            if (connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO accounts(firstName, lastName, age) VALUES('" +account.getFirstName()+"','"+account.getLastName()+"','"+account.getAge()+"')";
                statement.executeUpdate(sql);
            } 
        } catch (Exception e) {

        } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
        }
    }
}