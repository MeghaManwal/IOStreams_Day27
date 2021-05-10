package com.iostreams;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {
	
	  
		private List<EmployeePayrollData> data;
		
		public EmployeePayrollService() { }
		
		public EmployeePayrollService(List<EmployeePayrollData> data) {
			this.data = data;
		}
		
		
		private void readData(Scanner scanner) {
			System.out.println("Enter ID: ");
			int id = scanner.nextInt();
			
			System.out.println("Enter name: ");
			String name = scanner.next();
			
			System.out.println("Enter salary: ");
			double sal = scanner.nextDouble();
			
			data.add(new EmployeePayrollData(id, sal, name));
			
		}
		
		private void writeData() {
			
			System.out.println("\n Writing Employee payroll roaster:"+(data));		
		}
		
		public static void main(String[] args) {
			List<EmployeePayrollData> data = new ArrayList<EmployeePayrollData>();
			EmployeePayrollService service = new EmployeePayrollService(data);
			service.readData(new Scanner(System.in));
			
			service.writeData();
			
		}
		
		

}
