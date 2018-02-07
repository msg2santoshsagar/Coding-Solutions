package com.alife.gfg.permpal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solved but add some comment
 * @author Santosh Sagar
 * https://www.codechef.com/FEB18/problems/PERMPAL
 *
 */
public class Solution {


	static class Letter{
		int pos;
		int used;
	}

	public static void main(String args[]) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc =  Integer.parseInt(br.readLine());

		for(; tc > 0 ; tc--){


			String str 		= br.readLine();
			String revStr 	= new StringBuilder(str).reverse().toString(); 

			if( str.equals(revStr) ){
				// If already palindrome
				System.out.print(1);
				for(int i = 1 ; i < str.length() ; i++ ){
					System.out.print(" ");
					System.out.print(i+1);
				}
				System.out.println();
			}else{
				//	System.out.println("String is not palindrome");

				int count[] = new int[26];
				Arrays.fill(count, 0);
				Map<Character, List<Integer>> charPosList = new HashMap<>(26);

				for(int i=0; i< str.length();i++){
					char c = str.charAt(i);
					count[c-97]++;
					List<Integer> list = charPosList.get(c);
					if(list == null){
						list = new ArrayList<>();
						charPosList.put(c, list);
					}
					list.add(i+1);
				}

				int oddCount = 0;

				for(int i=0; i< 26;i++){
					if(count[i] % 2 ==1){
						oddCount++;
					}

				}

				boolean isPalindromePossible = (str.length() % 2 == 0 && oddCount == 0) || (str.length() % 2 == 1 && oddCount == 1);


				if( ! isPalindromePossible ){
					System.out.println("-1");
				}else{
					//			System.out.println(" Palindrome possible , print arrangement");

					StringBuilder sb = new StringBuilder();
					Character singleChar = null;
					for(int i=0; i< 26;i++){
						if( count[i] == 0){
							continue;
						}
						if(count[i] %2 ==1){
							singleChar = (char) (i+97);
						}
						for(int j=0;j<count[i]/2;j++){
							sb.append( Character.toString(  (char) (i+97) ) );
						}


					}

					String half = sb.toString();
					String rev  = sb.reverse().toString();
					if(singleChar != null){
						half = half+singleChar;
					}
					String palindromeString = half+rev;
					//System.out.println("Palindrome String -- "+palindromeString);

					for(int i=0; i< palindromeString.length() ; i++){
						char c = palindromeString.charAt(i);
						List<Integer> position = charPosList.get(c);

						System.out.print(position.get(0));
						if( i != palindromeString.length() -1 ){
							System.out.print(" ");
						}
						position.remove(0);
					}
					System.out.println();

				}


			}



		}


	}


}
