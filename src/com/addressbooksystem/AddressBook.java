package com.addressbooksystem;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	private DataFile dataFile;
	private Scanner s;
	private List<Person> people;
	
	public AddressBook( DataFile dataFile) throws IOException {
		s = new Scanner(System.in);
		this.dataFile = dataFile;
		people = dataFile.loadAll();
	}
	
	public AddressBook(String fileName) throws IOException {
		this(new DataFile(fileName));
	}
	
    private Person getPersonInformation() {
		
        System.out.println("Enter Firstname: ");
        String firstname = s.nextLine();
        String firstname1 = s.nextLine();
        System.out.println("Enter Lastname: ");
        String lastname = s.nextLine();
        System.out.println("Enter Address: ");
        String address = s.nextLine();
        System.out.println("Enter City: ");
        String city = s.nextLine();
        System.out.println("Enter State: ");
        String state = s.nextLine();
        System.out.println("Enter ZipCode: ");
        String zip = s.nextLine();
        System.out.println("Enter Phone number: ");
        String phoneNumber = s.nextLine();
        System.out.println("Enter EmailId: ");
        String email = s.nextLine();
        
        return new Person(firstname1, lastname, address, city, state, zip, phoneNumber, email);
    }
    
	public void ActionPerform() {
		while(true) {
			System.out.println(" Enter 1 to Add person \n Enter 2 to Show Contacts\n Enter 3 to Exit\n");
			 
	        int choice;
	        do {
	        	choice = s.nextInt();
	        	switch(choice) {
	        	
	        	case 1:
	        		Person person = getPersonInformation();
	        		dataFile.save(person);
	        		people.add(person);
	        		break;
	        	
	        	case 2:
	        		System.out.println(this.people);
	        		System.out.println();
	        		break;
	        		
	        	case 3:
	        		System.exit(0);
	        		break;
	        	
	        	}
	        	System.out.println(" Enter 1 to Add person \n Enter 2 to Show Contacts\n Enter 3 to Exit\n");
		        
	        }while (!(choice == 3));
	        System.out.println("Invalid choice!!");
		}    
		
	 }

	public static class main {
		
		public static void main(String[] args) throws IOException {
			AddressBook addressbook = new AddressBook("C:\\Users/Varsha Manwal/Desktop/BridgeLabz/Fellowship/Day27_IOStreams/IOStreams/demo/contact1.txt ");
			addressbook.ActionPerform();
		}
	}
}
