package com.operations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {
	
	public boolean isfileExists(String path) {
		 
	       boolean isExists = false;
	    
	       if(path == null || path.trim().isEmpty()) {
	          System.out.println("Invalid Path");
	       }
	 
	       File file = new File(path);
	       if(file.exists()) {
		      System.out.println("File Exist");
		      isExists = true;
	       }
	       else {
		      System.out.println("File does not Exist");
	       }
	       return isExists;
	  }
	 
	  public boolean delete(String path) {
	 
	       boolean isExists = false; 
	       if(path == null ) {
	          System.out.println("Invalid Path");
	       }
	 
	       File file = new File(path);
	       if(file.delete()) {
		     System.out.println("File Deleted");
		     isExists = true;
	       }
	       else {
		     System.out.println("File does not Exist");
		 
	       }
	       return isExists;
	  }
	  
	  public void createdirectory(String path) {
		
	       Path paths = Paths.get(path);
	       if(!Files.exists(paths)) {
	    	  try {
		         Files.createDirectory(paths);
		               System.out.println("Directory created");
		      }catch (IOException e) { 
		               e.printStackTrace();
		      }
	       }
	       else
	    	 System.out.println("Directory already exists");
	  }   
	     
	  public void createdfile(String path) {
			
	       Path paths = Paths.get(path);
	       if(!Files.exists(paths)) {
	    	  try {
			  Files.createFile(paths);
				System.out.println("File created");
			  } catch (IOException e) { 
				e.printStackTrace();
			  }
	       }
	       else
	         System.out.println("File already exists");
	   }   
	      

}



