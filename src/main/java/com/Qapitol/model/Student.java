package com.Qapitol.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private int age;
    private String mbNo;  // Mobile Number
    private List<String> addresses; // List of addresses
    private List<String> borrowedBooks; // List of borrowed book names
    private List<Book> books; // List of Book objects

    // Constructor
    public Student(String id, String name, int age, String mbNo, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbNo = mbNo;
        this.addresses = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>(); // Initialize empty list for borrowed books
        this.books = new ArrayList<>(); // Initialize empty list for books
        this.addresses.add(address); // Add initial address
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMbNo() {
        return mbNo;
    }

    public void setMbNo(String mbNo) {
        this.mbNo = mbNo;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void addAddress(String address) {
        this.addresses.add(address);
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<String> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    // Method to borrow a book by adding it to the borrowedBooks list
    public void borrowBook(String bookName) {
        if (borrowedBooks == null) {
            borrowedBooks = new ArrayList<>();
        }
        borrowedBooks.add(bookName);
    }

    // Method to return a borrowed book
    public void returnBook(String bookName) {
        
    }

    @Override
    public String toString() {
        return String.format("Student ID: %s | Name: %s | Age: %d | Mobile: %s | Addresses: %s | Borrowed Books: %s | Books: %s",
                id, name, age, mbNo, addresses, borrowedBooks, books);
    }

    public void setAddresses(String address) {
    }
}
