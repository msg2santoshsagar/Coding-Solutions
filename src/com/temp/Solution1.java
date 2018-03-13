package com.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		
		while( tc -- > 0){
			
			String str = br.readLine();
			
			int count = str.length() - str.replaceAll("1", "").length();
			
			switch(count){
			case 0: System.out.println("Beginner");break;
			case 1: System.out.println("Junior Developer");break;
			case 2: System.out.println("Middle Developer");break;
			case 3: System.out.println("Senior Developer");break;
			case 4: System.out.println("Hacker");break;
			case 5: System.out.println("Jeff Dean");break;
				
			}
			
			
		}
		

	}

}
