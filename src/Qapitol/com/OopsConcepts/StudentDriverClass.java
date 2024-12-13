package Qapitol.com.OopsConcepts;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Teacher> teacherList = new ArrayList<>();
        int input;

        do {
            System.out.println("Menu Options:");
            System.out.println("1. Add Student Detail");
            System.out.println("2. Add Teacher Detail");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    Student student = new Student();
                    System.out.print("Enter student ID: ");
                    int studentId = sc.nextInt();
                    System.out.print("Enter student name: ");
                    String studentName = sc.next();
                    System.out.print("Enter student age: ");
                    int studentAge = sc.nextInt();
                    System.out.print("Enter course: ");
                    String course = sc.next();
                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();

                    student.setId(studentId);
                    student.setName(studentName);
                    student.setAge(studentAge);
                    student.setCourse(course);
                    student.setMarks(marks);

                    studentList.add(student);
                    System.out.println("Student details added successfully!");
                    break;

                case 2:
                    Teacher teacher = new Teacher();
                    System.out.print("Enter teacher ID: ");
                    int teacherId = sc.nextInt();
                    System.out.print("Enter teacher name: ");
                    String teacherName = sc.next();
                    System.out.print("Enter teacher age: ");
                    int teacherAge = sc.nextInt();
                    System.out.print("Enter subject: ");
                    String subject = sc.next();
                    System.out.print("Enter salary: ");
                    int salary = sc.nextInt();
                    teacher.setId(teacherId);
                    teacher.setName(teacherName);
                    teacher.setAge(teacherAge);
                    teacher.setSubjectteacher(subject);
                    teacher.setSalary(salary);

                    teacherList.add(teacher);
                    System.out.println("Teacher details added successfully!");
                    break;

                case 3:
                    System.out.println("Exiting the program...");
                    break;
            }
        } while (input != 3);

        sc.close();
    }
}
