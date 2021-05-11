package com.iostreams;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {
	
	        public enum IOService {
	    	
		  CONSOLE_ID, FILE_ID;
		
	        }
	    
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
		
		private void writeData(IOService service) throws IOException {
			
			if(service.equals(IOService.FILE_ID)) {
				writeDatainfile();
			}
			else if(service.equals(IOService.CONSOLE_ID)) {
				System.out.println("\nData Written:"+data);
			}	
		}
		
		private void writeDatainfile() throws IOException {
			
			StringBuffer buffer = new StringBuffer();
			data.forEach(emp -> {	
			String empData=emp.toString().concat("\n");
			buffer.append(empData);
			});
			
			Files.write(Paths.get("C:\\Users/Varsha Manwal/Desktop/BridgeLabz/Fellowship/Day27_IOStreams/IOStreams/demo/contact.txt"), buffer.toString().getBytes());
				
		}

		public static void main(String[] args) throws IOException {
			List<EmployeePayrollData> data = new ArrayList<EmployeePayrollData>();
			EmployeePayrollService service = new EmployeePayrollService(data);
			service.readData(new Scanner(System.in));
			
			service.writeData(IOService.FILE_ID);
			
		}
		

}
