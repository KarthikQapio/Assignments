package com.Qapitol.model;

import java.util.Scanner;

public class Book {
    private String bookID;
    private String subject;
    private int bookCount;

    public Book(int bookID, String subject, int bookCount) {
        System.out.print("Enter Address: ");
        Scanner scanner = null;
        String book = scanner.nextLine();
        System.out.println("Book added Successfully");
//        this.subject = subject;
//        this.bookCount = bookCount;
    }

    public String getBookID() {
        return bookID;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void decrementBookCount() {
        if (bookCount > 0) {
            bookCount--;
        }
    }
    public void enterBookName(){
        System.out.print("Enter BookName: ");
        Scanner scanner = null;
        String book = scanner.nextLine();
        System.out.println("Book added Successfully");
    }

    @Override
    public String toString() {
        return String.format("Book ID: %s | Subject: %s | Available Copies: %d", bookID, subject, bookCount);
    }
}
