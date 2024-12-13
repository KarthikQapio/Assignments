package org.example.TextFile;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StudentManagement {

    private static final String FILE_NAME = "C:\\Users\\karthik.nagendrappa\\OneDrive - QAPITOL QA\\Desktop\\CashFloApiAutomationPreMAster\\FileOperation\\src\\main\\resources\\student.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Student Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Get Student Details");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> updateStudent(scanner);
                case 3 -> getStudentDetails(scanner);
                case 4 -> deleteStudent(scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        String studentRecord = id + "," + name + "," + age + "," + grade;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(studentRecord);
            writer.newLine();
            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.err.println("Error adding student.");
            e.printStackTrace();
        }
    }

    // Method to update an existing student
    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        List<String> records = readAllRecords();

        boolean updated = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String record : records) {
                String[] details = record.split(",");
                if (details[0].equals(id)) {
                    System.out.print("Enter Updated Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Updated Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Updated Grade: ");
                    String grade = scanner.nextLine();

                    writer.write(id + "," + name + "," + age + "," + grade);
                    updated = true;
                    System.out.println("Student updated successfully.");
                } else {
                    writer.write(record);
                }
                writer.newLine();
            }
            if (!updated) {
                System.out.println("Student ID not found.");
            }
        } catch (IOException e) {
            System.err.println("Error updating student.");
            e.printStackTrace();
        }
    }

    // Method to get details of a specific student
    private static void getStudentDetails(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        List<String> records = readAllRecords();

        for (String record : records) {
            String[] details = record.split(",");
            if (details[0].equals(id)) {
                System.out.println("Student Details:");
                System.out.println("ID: " + details[0]);
                System.out.println("Name: " + details[1]);
                System.out.println("Age: " + details[2]);
                System.out.println("Grade: " + details[3]);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }
    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        List<String> records = readAllRecords();

        boolean deleted = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String record : records) {
                String[] details = record.split(",");
                if (!details[0].equals(id)) {
                    writer.write(record);
                    writer.newLine();
                } else {
                    deleted = true;
                }
            }
            if (deleted) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (IOException e) {
            System.err.println("Error deleting student.");
            e.printStackTrace();
        }
    }
    private static void displayAllStudents() {
        List<String> records = readAllRecords();
        if (records.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("Student Records:");
        for (String record : records) {
            String[] details = record.split(",");
            System.out.println("ID: " + details[0] + ", Name: " + details[1] + ", Age: " + details[2] + ", Grade: " + details[3]);
        }
    }
    private static List<String> readAllRecords() {
        List<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading student records.");
            e.printStackTrace();
        }
        return records;
    }
}
