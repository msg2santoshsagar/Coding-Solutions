package com.alife.hackerrank.simple_text_editor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor/problem 
 * @author Santosh Sagar
 *
 */
public class Solution {

	private static final String INPUT_FILE_PATH = "src/com/alife/hackerrank/simple_text_editor/input.txt";

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

		int queryCount = Integer.parseInt(scanner.nextLine());

		Stack<String> stack = new Stack<>();

		stack.push("");

		while(queryCount -- > 0){

			String nextLine = scanner.nextLine();
			String nextLineArr [] = nextLine.split(" ");

			int opKey = Integer.parseInt(nextLineArr[0]);

			String opData = nextLineArr.length == 2 ? nextLineArr[1] : null;

			String str = stack.peek();

			switch(opKey){

			case 1 :  
				stack.push(str+opData);
				break;

			case 2 :
				str = str.substring(0,str.length()-Integer.parseInt(opData));
				stack.push(str);
				break;

			case 3 : 
				System.out.println(str.charAt(Integer.parseInt(opData)-1));
				break;

			case 4 : 
				stack.pop();
				break;


			}

		}


	}




}
