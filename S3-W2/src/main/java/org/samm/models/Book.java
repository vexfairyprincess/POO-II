package org.samm.models;

public class Book {
    String title;
    String author;
    int year;
    double price;
    String isbn;


    public Book(String title, String author, int year, double price, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
    }
}
