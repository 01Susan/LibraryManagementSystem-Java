/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.personal.BookManagementSystem.dao.impl;

import static com.personal.BookManagementSystem.JDBC.ConnectionSql.getConnection;
import com.personal.BookManagementSystem.dao.BooksDao;
import com.personal.BookManagementSystem.model.Books;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BooksDaoimpl implements BooksDao {

    @Override
    public int save(Books book) throws SQLException, ClassNotFoundException {
        String insertSql = "insert into books(book_name,publication,category,date) values(?,?,?,?)";
        PreparedStatement prepareStatement;
        prepareStatement = getConnection().prepareStatement(insertSql);
        prepareStatement.setString(1, book.getBookName());
        prepareStatement.setString(2, book.getPublication());
        prepareStatement.setString(3, book.getCategory());
        prepareStatement.setString(4, book.getDate());
        return prepareStatement.executeUpdate();
    }

    @Override
    public int update(Books book, int id) throws SQLException, ClassNotFoundException {
        String updateSql = "update books set book_name= ?,publication =?,category=?,date =? where Id=?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(updateSql);
        preparedStatement.setString(1, book.getBookName());
        preparedStatement.setString(2, book.getPublication());
        preparedStatement.setString(3, book.getCategory());
        preparedStatement.setString(4, book.getDate());
        preparedStatement.setInt(5, book.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int remove(int id) throws SQLException, ClassNotFoundException {
        String deleSql = "delete from books where Id =?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(deleSql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public Books findOne(int Id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("Select * from books where Id = ?");
        preparedStatement.setInt(1, Id);
        ResultSet resultset = preparedStatement.executeQuery();
        Books book = new Books();
        while (resultset.next()) {
            book.setId(resultset.getInt("id"));
            book.setBookName(resultset.getString("book_name"));
            book.setPublication(resultset.getString("publication"));
            book.setCategory(resultset.getString("category"));
            book.setDate(resultset.getString("date"));
        }
        return book;
    }

    @Override
    public List<Books> findAll() throws SQLException, ClassNotFoundException {

        List<Books> books = new ArrayList<>();
        PreparedStatement preparedStatement = getConnection().prepareStatement("Select * from books");
        ResultSet resultset = preparedStatement.executeQuery();

        while (resultset.next()) {
            Books book = new Books();
            book.setId(resultset.getInt("id"));
            book.setBookName(resultset.getString("book_name"));
            book.setPublication(resultset.getString("Publication"));
            book.setCategory(resultset.getString("Category"));
            book.setDate(resultset.getString("Date"));
            books.add(book);
        }
        return books;
    }

    @Override
    public List<Books> search(String query) throws SQLException, ClassCastException {
        List<Books> books = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getConnection().prepareStatement(
                    "Select * from books where book_name like concat ('%' ? '%')"
                    + "or Ppublication like concat ('%' ? '%')"
                    + "or date like concat('%' ? '%')"
                    + "or Id like concat('%' ? '%')"
                    + "or category like concat('%' ? '%')"
            );
            preparedStatement.setString(1, query);
            preparedStatement.setString(2, query);
            preparedStatement.setString(3, query);
            preparedStatement.setString(4, query);
            preparedStatement.setString(5, query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Books book = new Books();

                book.setBookName(resultSet.getString("book_name"));

                book.setPublication(resultSet.getString("publication"));

                book.setCategory(resultSet.getString("category"));

                book.setDate(resultSet.getString("date"));

                book.setId(resultSet.getInt("Id"));

                books.add(book);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return books;
    }
}
