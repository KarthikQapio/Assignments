package Qapitol.com.day2;

abstract class Person {
	
	
	private String name;
	private int age;
	private String desingation;
	
	public Person(String name, int age, String designtn) {
		this.name = name;
		this.age = age;
		this.desingation = designtn;		
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
	public String getDesingation() {
		return desingation;
	}
	public void setDesingation(String desingation) {
		this.desingation = desingation;
	}
	
	abstract void displayInfo();
	
	

}
