package com.iostreams;

public class EmployeePayrollData {

	private int id;
	private double salary;
	private String name;
	
	public EmployeePayrollData(int id, double salary, String name) {
		
		this.id = id;
		this.salary = salary;
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmployeePayrollData [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}
}
