package Qapitol.com.day2;

public class Employee extends Person {
	
	private int id;
	private long salary;
	private String assingedWork;
	
	public Employee(int id, long salary, String name, int age, String designation, String assinedwork) {
		super(name, age, designation);
		
		this.id = id;
		this.salary = salary;
		this.assingedWork = assinedwork;
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	
	
	public String getAssingedWork() {
		return assingedWork;
	}

	public void setAssingedWork(String assingedWork) {
		this.assingedWork = assingedWork;
	}

	@Override
	void displayInfo() {
		
		System.out.println("ID "+getId()+" Name "+getName()+"AGE:  "+getAge()+
				"Desingnation::   "+getDesingation()+" Salary::   "+getSalary()+" Assigned Work"+getAssingedWork());
		
	}
	
	

}
