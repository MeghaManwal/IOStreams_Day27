package com.addressbooksystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFile {
	
    private File file;
   
    public DataFile(String fileName) {
        this.file = new File(fileName);
    }

    public void save(Person person) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(person.getFirstname()+"\n" + person.getLastname() + "\n"+ person.getAddress() +"\n" + person.getCity()+"\n"+person.getState()+
            		"\n"+person.getZip()+"\n"+ person.getphoneNumber() + "\n" + person.getemail() + "\n\n");
            
        } catch(IOException e) {
            System.out.println(e);
        }
     }

     public List<Person> loadAll() throws IOException {
        List<Person> people = new ArrayList<Person>();

        @SuppressWarnings("resource")
	    BufferedReader reader = new BufferedReader(new FileReader(file)) ;
            while((reader.readLine()) != null) {
                Person person = new Person(reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine());
                people.add(person);
                reader.readLine();
            }
        return people;
     }
	
}
