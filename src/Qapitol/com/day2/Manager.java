package Qapitol.com.day2;

public class Manager extends Person{
	
	private int id;
	private long salary;
	
	public Manager(int id, long salary, String name, int age, String designation) {
		super(name,age,designation);
		
		this.id = id;
		this.salary = salary;
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

	@Override
	void displayInfo() {
		// TODO Auto-generated method stub
		System.out.println("ID "+getId()+" Name "+getName()+" AGE:  "+getAge()+
				" Desingnation::   "+getDesingation()+" Salary::   "+getSalary());
		
	}
	
	
}
