package org.example.Demo1;

import java.util.List;

public class Person {
	
	private String name;
	private int age;
	private long mbNo;
	private List<Address> addr;
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
	public long getMbNo() {
		return mbNo;
	}
	public void setMbNo(long mbNo) {
		this.mbNo = mbNo;
	}
	public List<Address> getAddr() {
		return addr;
	}
	public void setAddr(List<Address> addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", mbNo=" + mbNo + ", addr=" + addr + "]";
	}


	

}
