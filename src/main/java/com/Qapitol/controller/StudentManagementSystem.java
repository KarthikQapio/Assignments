package com.Qapitol.controller;

import com.Qapitol.manager.StudentManager;
import com.Qapitol.model.AddressPage;
import com.Qapitol.model.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final String FILE_NAME = "C:\\Users\\karthik.nagendrappa\\Downloads\\student-management-system\\src\\main\\java\\com\\Qapitol\\students.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        // Load existing student records from the JSON file
        List<Student> students = readAllRecords();
        StudentManager manager = new StudentManager(students);
        AddressPage addressPage = new AddressPage();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner, manager);
                    break;

                case 2:
                    updateStudent(scanner, manager);
                    break;

                case 3:
                    manager.viewAllStudents();
                    break;

                case 4:
                    deleteStudent(scanner, manager);
                    break;

                case 5:
                    addAddress(scanner, addressPage);
                    break;

                case 6:
                    addBookToStudent(scanner, manager);
                    break;

                case 7:
                    borrowBook(scanner, manager);
                    break;

                case 8:
                    submitBook(scanner, manager);
                    break;

                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }

    /**
     * Display the main menu options.
     */
    private static void displayMenu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. View All Students");
        System.out.println("4. Delete Student");
        System.out.println("5. Enter Address");
        System.out.println("6. Enter Book Name for a Student");
        System.out.println("7. Borrow a Book");
        System.out.println("8. Submit Back a Book");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Add a new student.
     */
    private static void addStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Mobile Number: ");
        String mbNo = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Book Name");
        String Books = scanner.nextLine();
        manager.updateStudent(id, name, age, mbNo, address);

        manager.addStudent(new Student(id, name, age, mbNo, address));
        writeRecords(manager.getAllStudents());
    }

    private static void updateStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter Student ID to Update: ");
        String id = scanner.nextLine();
        System.out.print("Enter Updated Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Updated Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Updated Mobile Number: ");
        String mbNo = scanner.nextLine();
        System.out.print("Enter Updated Address: ");
        String address = scanner.nextLine();

        manager.updateStudent(id, name, age, mbNo, address);
        writeRecords(manager.getAllStudents());
    }


    private static void deleteStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter Student ID to Delete: ");
        String id = scanner.nextLine();
        manager.deleteStudent(id);
        writeRecords(manager.getAllStudents());
    }

    private static void addAddress(Scanner scanner, AddressPage addressPage) {
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        addressPage.Address("", "", address);
        System.out.println("Address added successfully!");
    }


    private static void addBookToStudent(Scanner scanner, StudentManager manager) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Book Name: ");
        String bookName = scanner.nextLine();

        boolean success = manager.addBookToStudent(id, bookName);
        if (success) {
            System.out.println("Book added successfully!");
            writeRecords(manager.getAllStudents());
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void borrowBook(Scanner scanner, StudentManager manager) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Book Name to Borrow: ");
        String bookName = scanner.nextLine();

        boolean success = manager.borrowBook(id, bookName);
        if (success) {
            System.out.println("Book borrowed successfully!");
            writeRecords(manager.getAllStudents());
        } else {
            System.out.println("Error: Either student not found or the book is already borrowed!");
        }
    }

    private static void submitBook(Scanner scanner, StudentManager manager) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Book Name to Submit Back: ");
        String bookName = scanner.nextLine();

        boolean success = manager.submitBook(id, bookName);
        if (success) {
            System.out.println("Book returned successfully!");
            writeRecords(manager.getAllStudents());
        } else {
            System.out.println("Error: Either student not found or the book was not borrowed!");
        }
    }

    /**
     * Read all student records from the JSON file.
     */
    private static List<Student> readAllRecords() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<List<Student>>() {}.getType();
            return GSON.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error reading student records.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void writeRecords(List<Student> students) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            GSON.toJson(students, writer);
        } catch (IOException e) {
            System.err.println("Error writing student records.");
            e.printStackTrace();
        }
    }
}
