package Qapitol.com.OopsConcepts;

public class Student extends Person {
    private String course;
    private int marks;

    public void calculate(int marks) {
        if(marks>100) {
            System.out.println("A");
        }
        else if(marks>=100) {
            System.out.println("B");
        }
        else if(marks<100) {
            System.out.println("D");

        }
    }

    @Override
    void displayDetails() {
        System.out.println("ID "+getId() +" Name "+getName() +"AGE:  "+getAge() +
                "Course ::"+getCourse() +"marks::"+getMarks());

    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
}
