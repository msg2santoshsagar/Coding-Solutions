package com.alife.hackerrank.poisonous_plants;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Not solved yet
 * https://www.hackerrank.com/challenges/poisonous-plants/problem
 * @author Santosh Sagar
 * N
 */
public class Solution {

	private static final String INPUT_FILE_PATH = "src/com/alife/hackerrank/poisonous_plants/input.txt";

	public static void main(String args[]) throws FileNotFoundException{

		File file = new File(INPUT_FILE_PATH);

		/**
		 * By default we will read input from file
		 * You can modify code to read the input from user;
		 * 
		 */
		Scanner scanner = new Scanner(file);
		doTask(scanner);
		scanner.close();

	}


	public static void doTask(Scanner scanner){
		
		int n 			 			= scanner.nextInt();
		Stack<Integer>   stack 	    = new Stack<>();  
		
		for(int i=0;i<n;i++){
			int number = scanner.nextInt();
			stack.push(number);
		}
		
		
		
		System.out.println(stack.size());
		
	}




}
