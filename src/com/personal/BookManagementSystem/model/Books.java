/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.personal.BookManagementSystem.model;

/**
 *
 * @author susan
 */
public class Books {

    //Properties of the Books 
    private int Id;
    private String BookName;
    private String Date;

    @Override
    public String toString() {
        return "Books{" + "id=" + Id + ", BookName=" + BookName + ", date=" + Date + ", Publication=" + Publication + ", Category=" + Category + '}';
    }
    private String Publication;
    private String Category;
    //Default Constructor for the books

    public Books() {

    }

    // Parameterized Constructor of the Books     
    /**
     *
     * @param Id
     * @param BookName
     * @param Date
     * @param Publication
     * @param Category
     */
    public Books(int Id, String BookName, String Date, String Publication, String Category) {
        this.Id = Id;
        this.BookName = BookName;
        this.Date = Date;
        this.Publication = Publication;
        this.Category = Category;
    }

    /**
     *
     * @param BookName
     * @param Publication
     * @param Category
     * @param Date
     */
    public Books(String BookName, String Publication, String Category, String Date) {
        this.BookName = BookName;
        this.Publication = Publication;
        this.Category = Category;
        this.Date = Date;

    }

    //Creating the getter and setter method for each and every properties
    public int getId() {
        return Id;
    }

    public String getBookName() {
        return BookName;
    }

    public String getDate() {
        return Date;
    }

    public String getPublication() {
        return Publication;
    }

    public String getCategory() {
        return Category;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setPublication(String Publication) {
        this.Publication = Publication;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

}
