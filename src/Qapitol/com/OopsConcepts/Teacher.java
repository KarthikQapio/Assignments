package Qapitol.com.OopsConcepts;

public class Teacher extends Person {
    private String subjectteacher;
    private int salary;


    public String getSubjectteacher() {
        return subjectteacher;
    }

    public void setSubjectteacher(String subjectteacher) {
        this.subjectteacher = subjectteacher;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {

        this.salary = salary;
    }

    @Override
    void displayDetails() {
        System.out.println("ID:"+getId()+" " +"Name:"+ getName()+" "+"AGE:  "+ getAge()+" "+
                "SubjectTeacher::"+getSubjectteacher()+" "+" Salary::"+ getSalary());

    }
}
