package com.Qapitol.manager;

import com.Qapitol.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private final List<Student> students;

    // Constructor to initialize students list
    public StudentManager(List<Student> students) {
        this.students = students != null ? students : new ArrayList<>(); // Ensure non-null list
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Update an existing student's details
    public void updateStudent(String id, String name, int age, String mobileNumber, String address) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(name);
                student.setAge(age);
                student.setMbNo(mobileNumber);
                student.setAddresses(address);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    // Delete a student by ID
    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
        System.out.println("Student deleted successfully!");
    }

    // View all students
    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student List:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return a copy of the students list
    }

    /**
     * Borrow a book for a student.
     * Ensures a student can borrow only if the book is not already borrowed.
     */
    public boolean borrowBook(String studentId, String bookName) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                if (student.getBorrowedBooks() == null) {
                    student.setBorrowedBooks(new ArrayList<>());
                }
                if (!student.getBorrowedBooks().contains(bookName)) {
                    student.getBorrowedBooks().add(bookName);
                    System.out.println("Book borrowed successfully!");
                    return true;
                }
                System.out.println("Error: Book already borrowed.");
                return false; // Book already borrowed
            }
        }
        System.out.println("Error: Student not found.");
        return false; // Student not found
    }

    /**
     * Submit back a borrowed book for a student.
     */
    public boolean submitBook(String studentId, String bookName) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                if (student.getBorrowedBooks() != null && student.getBorrowedBooks().contains(bookName)) {
                    student.getBorrowedBooks().remove(bookName);
                    System.out.println("Book returned successfully!");
                    return true;
                }
                System.out.println("Error: Book not found in borrowed list.");
                return false; // Book not found in borrowed list
            }
        }
        System.out.println("Error: Student not found.");
        return false; // Student not found
    }

    // Add a book to a specific student (previous method has been adjusted)
    public boolean addBookToStudent(String studentId, String bookName) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                if (student.getBorrowedBooks() == null) {
                    student.setBorrowedBooks(new ArrayList<>());
                }
                if (!student.getBorrowedBooks().contains(bookName)) {
                    student.getBorrowedBooks().add(bookName);
                    return true;
                }
                return false; // Book already exists in borrowed list
            }
        }
        return false; // Student not found
    }
}
