package com.alife.codechef.corp2018.enp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 *
 */
public class Main {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/corp2018/enp/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Main solution = new Main();
		solution.solve(scanner);

	}
	
	private void solve(FastScanner scanner) {

		int x = scanner.nextInt();
		int d = scanner.nextInt();
		
		String str = scanner.nextLine();
	
		decrypt(str,x,d);
		
		System.out.println("DECRYPT  : "+Arrays.toString(arr));
		
		long longestPrimeLength = 0;
		
		boolean isOddExist = false;
		
		for(int i=0; i< 26;i++){
			
			if(arr[i]%2 == 1){
				isOddExist = true;
			}
			
			if(arr[i] > 0 ){
				longestPrimeLength += arr[i]/2;
			}
			
		}
		
		if(isOddExist){
			longestPrimeLength++;
		}
		
		System.out.println(longestPrimeLength);
		
		
	}
	
	int[] arr = new int[26]; 

	private void decrypt(String str, int x ,int d) {
		
		int[] darr = new int[26];
		
		for(int i=0;i<26;i++){
			
			int en =  ( i + x + (i*d) ) % 26;
			
			System.out.println("EN FOR "+((char)(i+'a'))+" is "+((char)(en+'a')));
			
			darr[en] = i;
			
		}
		
		String s  = "";
		for(int i=0; i< str.length(); i++){
			
			char c = str.charAt(i);
			
			s += (char)( darr[c-'a'] + 'a');
			
			arr[darr[c-'a']]++;
			
		}
		
		System.out.println("D S "+s);
			
	}



	public static class FastScanner {

		BufferedReader 		br;
		StringTokenizer 	st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException	 e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

		String nextLine(){
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}


}