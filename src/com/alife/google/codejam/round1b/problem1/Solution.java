package com.alife.google.codejam.round1b.problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Santosh Sagar
 *
 */
public class Solution {



	private static final String 	INPUT_FILE_PATH = "src/com/alife/google/codejam/round1b/problem1/input.txt";

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

		int tc = scanner.nextInt();
		
		int ques = 0;
		
		while(ques<tc){
			
			ques++;
			
			
			int n = scanner.nextInt();
			int l = scanner.nextInt();
			
			double each = 100.0 / n;
			
			int sum = 0;
			int[] c = new int[l];
			boolean [] done = new boolean[l];
			
			for(int i=0; i< l; i++){
				c[i]    = scanner.nextInt();
				sum		+= c[i]; 
				if(Math.round(c[i]*each) > c[i]*each){
					done[i] = true;
				}
			}
			
			int left = n - sum;
			
			while(left != 0){
				
				
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