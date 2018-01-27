package com.alife.gfg.longest_palindrodme;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.alife.util.CustomStopWatch;

/**
 * Given a string, find the longest substring which is palindrome. 
 * For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
 * 
 * @see {@link https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/}
 * 
 * 
 * @author Santosh Sagar
 * @since  21 Jan 2017
 * 
 */

public class LongestPalindrome {

	private static final String INPUT_FILE_PATH = "src/com/alife/gfg/longest_palindrodme/input.txt";

	public static void main(String args[]) throws FileNotFoundException{

		File file = new File(INPUT_FILE_PATH);

		/**
		 * By default we will read input from file
		 * You can modify code to read the input from user;
		 * 
		 */
		Scanner scanner = new Scanner(file);

		while(scanner.hasNextLine()){

			String inputString = scanner.nextLine();
			CustomStopWatch stopWatch = new CustomStopWatch();
			stopWatch.start();
			String palindromeString = findPalindromeSubStringWithMaxLength(inputString);
			stopWatch.stop();
			System.out.println("Input : "+inputString+", Output String : "+palindromeString+", time taken : "+stopWatch.getElapsedTimeInNanoSecond()+"(ns)");

		}


		scanner.close();

	}

	private static String findPalindromeSubStringWithMaxLength(String string) {

		int len = string.length();

		int lb=0, ub=0, plen=0;

		for(int i = 0 ; i< len; i++){

			for(int j = i+1; j<len ; j++){

				boolean isPalindrome = true;
				for(int tempLb = i, tempUb = j ; tempLb < tempUb ; tempLb++,  tempUb--){
					if( string.charAt(tempLb) != string.charAt(tempUb) ){
						isPalindrome = false;
						break;
					}
				}

				if( isPalindrome && plen < (j-i) ){
					lb = i;
					ub = j;
					plen = j -i;
				}

			}

		}

		return string.substring(lb, ub+1);
	}

}
