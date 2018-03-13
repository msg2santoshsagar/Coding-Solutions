package com.alife.codechef.march18b.mineeat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;


public class Solution {

	private static final String 	INPUT_FILE_PATH = "src/com/alife/codechef/march18b/mineeat/input.txt";

	public static void main(String[] args){

		String homePc = System.getenv("HOME_PC");

		FastScanner scanner = null;

		if(homePc == null){
			scanner = new FastScanner();
		}else{
			scanner = new FastScanner(INPUT_FILE_PATH);
		}

		Solution solution = new Solution();
		solution.solve(scanner);

	}

	private void solve(FastScanner scanner) {
		
		int testCase = scanner.nextInt();
		
		while( testCase --> 0){
			
			int numberOfPiles = scanner.nextInt();
			int hours 		  = scanner.nextInt();
			
			int banana[]      = new int[numberOfPiles];
			
			for( int i=0; i < numberOfPiles ; i++ ){
				banana[i] = scanner.nextInt();
			}
			
			int diff = hours - numberOfPiles;
			
			if(diff == 0){
				
				OptionalInt max = Arrays.stream(banana).max();
				System.out.println(max.getAsInt());
				
			}else{
				//System.out.println("Difference is not 0, find result");
				
				OptionalInt max = Arrays.stream(banana).max();
				int maxVal      = max.getAsInt();
				
				int p = (int) Math.ceil( maxVal / hours );
				
				Arrays.sort(banana);
				
				for(int i=0;i<banana.length-1;i++){
					if(p < banana[i]){
						p = banana[i];
					}
				}
				
				System.out.println(p);
				
				
			}
			
		}

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
