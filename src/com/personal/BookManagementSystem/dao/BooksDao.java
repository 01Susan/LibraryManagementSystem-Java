/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.personal.BookManagementSystem.dao;

import com.personal.BookManagementSystem.model.Books;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author susan
 */
public interface BooksDao {

    int save(Books book) throws SQLException, ClassNotFoundException;

    int update(Books book, int id) throws SQLException, ClassNotFoundException;

    int remove(int id) throws SQLException, ClassNotFoundException;

    Books findOne(int id) throws SQLException, ClassNotFoundException;

    List<Books> findAll() throws SQLException, ClassNotFoundException;

    List<Books> search(String query) throws SQLException, ClassCastException;

}
