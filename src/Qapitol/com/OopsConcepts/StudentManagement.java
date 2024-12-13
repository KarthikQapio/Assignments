package Qapitol.com.OopsConcepts;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter teacher Employee id");
        int id = sc.nextInt();
        System.out.println("Enter teacher name");
        String name = sc.next();
        System.out.println("Enter teacher age");
        int age = sc.nextInt();
        System.out.println("Enter subject");
        String subject = sc.next();
        System.out.println("Enter salary");
        int salary = sc.nextInt();
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setSubjectteacher(subject);
        teacher.setSalary(salary);
        teacher.displayDetails();

        Student student = new Student();
        System.out.println("Enter student id");
        int studentid = sc.nextInt();
        System.out.println("Enter student name");
        String studentname = sc.next();
        System.out.println("Enter student age");
        int Studentage = sc.nextInt();
        System.out.println("Enter course");
        String course = sc.next();
        System.out.println("Enter marks");
        int marks = sc.nextInt();
        student.setId(studentid);
        student.setName(studentname);
        student.setAge(Studentage);
        student.setCourse(course);
        student.setMarks(marks);
        ArrayList teacherAl = new ArrayList();
        teacherAl.add(teacher);
        ArrayList studentAl = new ArrayList();
        teacherAl.add(student);
        student.calculate(marks);

    }


}
