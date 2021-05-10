package com.operations;

public class FileOperationsUtils {
	
	public static void main(String[] args) {
		
		FileOperations utils = new FileOperations();
		
		utils.createdirectory("C:\\Users/Varsha Manwal/Desktop/BridgeLabz/Fellowship/Day27_IOStreams/IOStreams/demo");
		utils.createdfile("C:\\Users/Varsha Manwal/Desktop/BridgeLabz/Fellowship/Day27_IOStreams/IOStreams/demo/new.txt");
		
		System.out.println(( utils).isfileExists("C:\\Users/Varsha Manwal/Desktop/BridgeLabz/Fellowship/Day27_IOStreams/IOStreams/demo/new.txt"));
		System.out.println(( utils).isfileExists("C:\\Users/Varsha Manwal/Desktop/BridgeLabz/Fellowship/Day27_IOStreams/IOStreams/demo/new1.txt"));
		
		System.out.println(( utils).delete("C:\\Users/Varsha Manwal/Desktop/BridgeLabz/Fellowship/Day27_IOStreams/IOStreams/demo/new.txt"));
		System.out.println(( utils).isfileExists("C:\\Users/Varsha Manwal/Desktop/BridgeLabz/Fellowship/Day27_IOStreams/IOStreams/demo/new.txt"));
		
	}
	

}

