/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.personal.BookManagementSystem.JDBC;

/**
 *
 * @author susan
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionSql {
      public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/books_crud", "root", "");
    }
}
