package org.example.JsonFile;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class StudentManagementJSON {

    private static final String FILE_NAME = "C:\\Users\\karthik.nagendrappa\\OneDrive - QAPITOL QA\\Desktop\\CashFloApiAutomationPreMAster\\FileOperation\\src\\main\\resources\\Student.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nStudent Management System:");
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
                case 5 -> displayAllStudents();
                case 6 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void addStudent(Scanner scanner) {
        List<Student> students = readAllRecords();

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(id, name, age, grade);
        students.add(student);

        writeRecords(students);
        System.out.println("Student added successfully.");
    }
    private static void updateStudent(Scanner scanner) {
        List<Student> students = readAllRecords();

        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();

        boolean updated = false;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.print("Enter Updated Name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter Updated Age: ");
                student.setAge(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Updated Grade: ");
                student.setGrade(scanner.nextLine());

                updated = true;
                break;
            }
        }

        if (updated) {
            writeRecords(students);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    // Get details of a specific student
    private static void getStudentDetails(Scanner scanner) {
        List<Student> students = readAllRecords();

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("\nStudent Details:");
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("Grade: " + student.getGrade());
                return;
            }
        }

        System.out.println("Student ID not found.");
    }
    private static void deleteStudent(Scanner scanner) {
        List<Student> students = readAllRecords();

        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        boolean deleted = students.removeIf(student -> student.getId().equals(id));

        if (deleted) {
            writeRecords(students);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }
    private static void displayAllStudents() {
        List<Student> students = readAllRecords();

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\nAll Students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() +
                    ", Age: " + student.getAge() + ", Grade: " + student.getGrade());
        }
    }
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

    // Write all records to the JSON file
    private static void writeRecords(List<Student> students) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            GSON.toJson(students, writer);
        } catch (IOException e) {
            System.err.println("Error writing student records.");
            e.printStackTrace();
        }
    }

    // Inner class for Student
    static class Student {
        private String id;
        private String name;
        private int age;
        private String grade;

        public Student(String id, String name, int age, String grade) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }
}
