package org.example.excelFIle;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentExcelFile {

    // Define a Student class to store student details
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

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        // Sample data for students
        List<Student> students = new ArrayList<>();
        students.add(new Student("S01", "Alice", 20, "A"));
        students.add(new Student("S02", "Bob", 21, "B"));
        students.add(new Student("S03", "Charlie", 19, "A+"));
        students.add(new Student("S04", "Diana", 22, "B+"));
        students.add(new Student("so5","karthik",22,"B+"));
        String excelFilePath = "Students.xlsx";
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Students");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Age");
            headerRow.createCell(3).setCellValue("Grade");
            int rowCount = 1;
            for (Student student : students) {
                Row row = sheet.createRow(rowCount++);
                row.createCell(0).setCellValue(student.getId());
                row.createCell(1).setCellValue(student.getName());
                row.createCell(2).setCellValue(student.getAge());
                row.createCell(3).setCellValue(student.getGrade());
            }
            for (int i = 0; i < 4; i++) {
                sheet.autoSizeColumn(i);
            }
            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Excel file created successfully at: " + excelFilePath);

        } catch (IOException e) {
            System.err.println("Error while creating Excel file: " + e.getMessage());
        }
    }
}
